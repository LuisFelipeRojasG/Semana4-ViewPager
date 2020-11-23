package com.stingrey.mismascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toolbar;

import com.stingrey.mismascotas.adaptador.MascotaAdaptador;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity {

    private RecyclerView listaMascotas1;
    ArrayList<ListaMascotas> mascotaFavoritas;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        androidx.appcompat.widget.Toolbar actionBar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.actionBar);
        setSupportActionBar(actionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotas1 = (RecyclerView) findViewById(R.id.rvMascotas1);
        LinearLayoutManager llm1 = new LinearLayoutManager(this);
        llm1.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas1.setLayoutManager(llm1);
        inicializarListaMascotas1();
        inicializarAdaptador1();

    }

    public boolean onCreateOptionsMenu (Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_opciones, menu);

        return true;
    }

    private void inicializarAdaptador1() {
        MascotaAdaptador adaptador1 = new MascotaAdaptador(mascotaFavoritas);
        listaMascotas1.setAdapter(adaptador1);

    }

    private void inicializarListaMascotas1() {

        mascotaFavoritas = new ArrayList<ListaMascotas>();

        mascotaFavoritas.add(new ListaMascotas(R.drawable.perro_05, "Candy"));
        mascotaFavoritas.add(new ListaMascotas(R.drawable.perro_04, "Buzz"));
        mascotaFavoritas.add(new ListaMascotas(R.drawable.perro_03, "Nemo"));
        mascotaFavoritas.add(new ListaMascotas(R.drawable.perro_02, "Dorry"));
        mascotaFavoritas.add(new ListaMascotas(R.drawable.perro_01, "Happy"));

    }

    private void setSupportActionBar(Toolbar miActionBar1) {

        MascotaAdaptador adaptador1 = new MascotaAdaptador(mascotaFavoritas);
        listaMascotas1.setAdapter(adaptador1);

    }



}