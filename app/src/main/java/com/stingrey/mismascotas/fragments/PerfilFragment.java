package com.stingrey.mismascotas.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stingrey.mismascotas.ListaMascotas;
import com.stingrey.mismascotas.R;
import com.stingrey.mismascotas.adaptador.MascotaAdaptador;
import com.stingrey.mismascotas.adaptador.PerfilAdaptor;

import java.util.ArrayList;

public class PerfilFragment extends Fragment {

    ArrayList<ListaMascotas> mascota;
    private RecyclerView listaMascotas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);

        //Se usara despues de organizar los Fragmnets

        listaMascotas = (RecyclerView) view.findViewById(R.id.rvPerfilMascota);
        GridLayoutManager llm = new GridLayoutManager(getActivity(), 3);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();

        return view;
    }

    public void inicializarListaMascotas(){

        mascota = new ArrayList<ListaMascotas>();

        mascota.add(new ListaMascotas(R.drawable.perro_01));
        mascota.add(new ListaMascotas(R.drawable.perro_01));
        mascota.add(new ListaMascotas(R.drawable.perro_01));
        mascota.add(new ListaMascotas(R.drawable.perro_01));
        mascota.add(new ListaMascotas(R.drawable.perro_01));
        mascota.add(new ListaMascotas(R.drawable.perro_01));
        mascota.add(new ListaMascotas(R.drawable.perro_01));

    }

    public void inicializarAdaptador(){
        PerfilAdaptor adaptador = new PerfilAdaptor(mascota);
        listaMascotas.setAdapter(adaptador);
    }
}