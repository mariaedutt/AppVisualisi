package com.inf3m171.yan.appvisualisi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MarcarConsultaActivity extends AppCompatActivity {

    private Button btnAdicionarData, btnLimpar, btnConfirmar;
    private Spinner spHorarios, spConvenio, spMedico;
    private TextView txtData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marcar_consulta);
    }
}
