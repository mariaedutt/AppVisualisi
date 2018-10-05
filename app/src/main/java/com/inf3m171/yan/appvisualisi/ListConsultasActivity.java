package com.inf3m171.yan.appvisualisi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.inf3m171.yan.appvisualisi.Model.Consulta;

import java.util.ArrayList;
import java.util.List;

public class ListConsultasActivity extends AppCompatActivity {

    private ListView lvConsultas;
    private List<Consulta> listaDeConsultas;
    private ArrayAdapter adapter;
    private FirebaseDatabase database;
    private DatabaseReference refecence;
    private Query queryRef;
    private ChildEventListener childEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_consultas);

        lvConsultas = (ListView) findViewById(R.id.lvListaConsultas);
        listaDeConsultas = new ArrayList<>();
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, listaDeConsultas);
        lvConsultas.setAdapter(adapter);

        database = FirebaseDatabase.getInstance();
        refecence = database.getReference();

    }

    @Override
    protected void onStart() {
        super.onStart();

        queryRef = refecence.child("Consultas").orderByChild("data");

        listaDeConsultas.clear();

        childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                String idUsuario = FirebaseAuth.getInstance().getCurrentUser().getUid();

                if (dataSnapshot.child("codPaciente").getValue(String.class).equals(idUsuario)) {
                    Consulta consulta = new Consulta();
                    consulta.setId(dataSnapshot.getKey());
                    consulta.setMedico(dataSnapshot.child("medico").getValue(String.class));
                    consulta.setData(dataSnapshot.child("data").getValue(String.class));
                    consulta.setHorario(dataSnapshot.child("horario").getValue(String.class));
                    consulta.setConvenio(dataSnapshot.child("convenio").getValue(String.class));
                    listaDeConsultas.add(consulta);
                    adapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        queryRef.addChildEventListener( childEventListener);
    }

    @Override
    protected void onStop() {
        super.onStop();

        queryRef.removeEventListener(childEventListener);
    }
}
