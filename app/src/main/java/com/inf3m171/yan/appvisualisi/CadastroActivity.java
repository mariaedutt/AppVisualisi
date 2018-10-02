package com.inf3m171.yan.appvisualisi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.inf3m171.yan.appvisualisi.Model.Paciente;

public class CadastroActivity extends AppCompatActivity {

    private EditText etNome, etCpf, etDataDeNascimento, etTelefone, etEmail, etSenha, etConfirmaSenha;
    private Button btnLimparCadastro, btnCadastrar;
    private  String erro = "";
    private FirebaseDatabase database;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        etNome = (EditText) findViewById(R.id.etNome);
        etCpf = (EditText) findViewById(R.id.etCpf);
        etDataDeNascimento = (EditText) findViewById(R.id.etDataDeNascimento);
        etTelefone = (EditText) findViewById(R.id.etTelefone);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etSenha = (EditText) findViewById(R.id.etSenha);
        etConfirmaSenha = (EditText) findViewById(R.id.etConfirmaSenha);

        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        btnLimparCadastro = (Button) findViewById(R.id.btnLimparCadastro);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastrar();
            }
        });

        btnLimparCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limpar();
            }
        });
    }

    private void cadastrar(){


        String nome = etNome.getText().toString();

        if ( ! nome.isEmpty()) {
            database = FirebaseDatabase.getInstance();
            reference = database.getReference();

            Paciente j = new Paciente();
            j.setNome(nome);

            j.setCpf(etCpf.getText().toString());
            j.setCpf(etDataDeNascimento.getText().toString());
            j.setCpf(etTelefone.getText().toString());
            j.setCpf(etEmail.getText().toString());
            j.setCpf(etSenha.getText().toString());
            j.setCpf(etConfirmaSenha.getText().toString());
            j.setCpf(etCpf.getText().toString());



            reference.child("Pacientes").push().setValue(j);

            finish();

        }


    }

    private void limpar(){
        etNome.setText("");
        etCpf.setText("");
        etDataDeNascimento.setText("");
        etTelefone.setText("");
        etEmail.setText("");
        etSenha.setText("");
        etConfirmaSenha.setText("");

    }



}
