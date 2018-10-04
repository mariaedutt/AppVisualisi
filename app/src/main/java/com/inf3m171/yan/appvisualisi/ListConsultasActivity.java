package com.inf3m171.yan.appvisualisi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListConsultasActivity extends AppCompatActivity {

    private ListView lvListaConsultas;

    private ListView listaExames;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_consultas);

        //listaExames = (ListView) findViewById(R.id.lvListaExames);

    }
}
