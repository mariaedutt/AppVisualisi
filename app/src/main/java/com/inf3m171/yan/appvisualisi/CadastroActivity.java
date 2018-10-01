package com.inf3m171.yan.appvisualisi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastroActivity extends AppCompatActivity {

    private EditText etNome, etCpf, etDataDeNascimento, etTelefone, etEmail, etSenha, etConfirmaSenha;
    private Button btnLimparCadastro, btnCadastrar;
    private  String erro = "";

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
        btnLimparCadastro = (Button) findViewById(R.id.btnLimpar);

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

    }

    private void limpar(){

    }



}
