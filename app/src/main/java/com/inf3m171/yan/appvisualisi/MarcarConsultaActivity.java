package com.inf3m171.yan.appvisualisi;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class MarcarConsultaActivity extends AppCompatActivity {

    private Spinner spMedico, spHorario, spConvenio;
    private Button btnLimpar, btnCadastrar, btnAdicionarData;
    private TextView tvDataCalendario;


    private FirebaseDatabase database;
    private DatabaseReference reference;
    private Query queryRef;
    private ChildEventListener childEventListener;

    private ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marcar_consulta);

        spMedico = (Spinner) findViewById(R.id.spMedico);
        spConvenio = (Spinner) findViewById(R.id.spConvenio);
        spHorario = (Spinner) findViewById(R.id.spHorarios);

        btnLimpar = (Button) findViewById(R.id.btnLimpar);
        btnAdicionarData = (Button) findViewById(R.id.btnAdicionarData);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);

        tvDataCalendario = (TextView) findViewById(R.id.tvDataCalendario);

        btnAdicionarData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selecionarData();
            }
        });


    }


    private void selecionarData(){
        AlertDialog.Builder alerta = new AlertDialog.Builder(this);

        final DatePicker calendario = new DatePicker(this);
        alerta.setView(calendario);

        alerta.setNegativeButton("Selecionar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int dia = calendario.getDayOfMonth();
                int mes = calendario.getMonth() + 1;
                int ano = calendario.getYear();
                String data = "";
                if (dia < 10)
                    data += "0";

                data += dia + "/";
                if (mes < 10)
                    data += "0";
                data += mes+ "/";

                data += ano;

                tvDataCalendario.setText(data);
            }
        });
        alerta.setNeutralButton("Cancelar", null);
        alerta.show();
    }



    @Override
    protected void onStart() {
        super.onStart();



    }

    private void salvar(){
        if(spMedico.getSelectedItemPosition() == 0 ){
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);
            alerta.setTitle("Erro!");
            alerta.setMessage("Favor selecionar o seu médico");

        }else if(spConvenio.getSelectedItemPosition() == 0){
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);
            alerta.setTitle("Erro!");
            alerta.setMessage("Favor selecionar o seu convênio!");
        }else if(spHorario.getSelectedItemPosition() == 0){
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);
            alerta.setTitle("Erro!");
            alerta.setMessage("Favor selecionar o seu horário para a consulta!");
        }



        }
}

