package com.inf3m171.yan.appvisualisi;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.inf3m171.yan.appvisualisi.Model.Paciente;

public class LoginActivity extends AppCompatActivity {
    private EditText etSenha, etEmail;
    private Button btnEntrar, btnCadastrar;

    private FirebaseAuth autenticacao;
    private FirebaseAuth.AuthStateListener stateListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etSenha = (EditText) findViewById(R.id.etSenha);
        etEmail = (EditText) findViewById(R.id.etEmail);
        btnEntrar = (Button) findViewById(R.id.btnEntrar);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);

        autenticacao = FirebaseAuth.getInstance();

        stateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null){
                    Intent i = new Intent(LoginActivity.this, InicialActivity.class);
                    startActivity( i );
                }

            }
        };

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                entrar();
            }
        });

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(LoginActivity.this, CadastroActivity.class);
                startActivity( i );
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        autenticacao.addAuthStateListener(stateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        autenticacao.removeAuthStateListener(stateListener);
    }

    private void entrar(){
        String email = etEmail.getText().toString();
        String senha = etSenha.getText().toString();

        if(!email.isEmpty()){
            autenticacao.signInWithEmailAndPassword(email, senha).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(!task.isSuccessful()){
                        Toast.makeText(LoginActivity.this, "Favor completar todos os campos corretamente.", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }
}
