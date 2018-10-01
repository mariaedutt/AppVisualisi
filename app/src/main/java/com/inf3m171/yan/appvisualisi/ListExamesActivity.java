package com.inf3m171.yan.appvisualisi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class ListExamesActivity extends AppCompatActivity {

    private ListView listaExames;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_exames);

        listaExames = (ListView) findViewById(R.id.lvListaExames);
    }
}
