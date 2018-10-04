package com.inf3m171.yan.appvisualisi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class InicialActivity extends AppCompatActivity {

    private Button btnMarcar;
    private ImageButton btnConsultar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial);

        btnMarcar = (Button) findViewById(R.id.btnMarcar);
        btnConsultar = (ImageButton) findViewById(R.id.btnConsultar);

        btnMarcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(InicialActivity.this, MarcarConsultaActivity.class);
                startActivity(i);
            }
        });

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(InicialActivity.this, ListConsultasActivity.class);
                startActivity(i);
            }
        });
    }
}
