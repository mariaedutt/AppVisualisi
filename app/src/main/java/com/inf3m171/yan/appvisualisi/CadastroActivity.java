package com.inf3m171.yan.appvisualisi;

import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.inf3m171.yan.appvisualisi.Model.Paciente;

public class CadastroActivity extends AppCompatActivity {

    private EditText etNome, etCpf, etDataDeNascimento, etTelefone, etEmail, etSenha, etConfirmaSenha;
    private Button btnLimparCadastro, btnCadastrar;
    private String erro = "";
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


        final String nome = etNome.getText().toString();
        String senha = etSenha.getText().toString();
        String confirmaSenha = etConfirmaSenha.getText().toString();
        final String email = etEmail.getText().toString();
        final String telefone = etTelefone.getText().toString();

        if ( !nome.isEmpty() && !email.isEmpty() && !telefone.isEmpty() && !senha.isEmpty() && !confirmaSenha.isEmpty() && ( senha.equals( confirmaSenha ))   ) {


            FirebaseAuth autenticacao = FirebaseAuth.getInstance();

            autenticacao.createUserWithEmailAndPassword(email, senha)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if ( task.isSuccessful()){

                                database = FirebaseDatabase.getInstance();
                                reference = database.getReference();

                                Paciente j = new Paciente();
                                j.setNome(nome);
                                j.setCpf(etCpf.getText().toString());
                                j.setDataDeNascimento(etDataDeNascimento.getText().toString());
                                j.setTelefone(telefone);
                                j.setEmail(email);


                                String usuario = FirebaseAuth.getInstance().getCurrentUser().getUid();

                                reference.child("Pacientes").child(usuario).setValue(j);

                                finish();

                            }


                        }
                    });



        }else {
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);
            alerta.setTitle("Erro!");
            alerta.setMessage("Favor completar todos os campos");
            alerta.setNeutralButton("OK",null);
            alerta.show();

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
