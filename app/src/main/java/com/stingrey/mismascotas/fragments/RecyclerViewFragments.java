package com.stingrey.mismascotas.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.stingrey.mismascotas.ListaMascotas;
import com.stingrey.mismascotas.R;
import com.stingrey.mismascotas.adaptador.MascotaAdaptador;

import java.util.ArrayList;

public class RecyclerViewFragments extends Fragment {

    ArrayList<ListaMascotas> mascota;
    private RecyclerView listaMascotas;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycleview, container, false);

        //Se usara despues de organizar los Fragmnets

        listaMascotas = (RecyclerView) view.findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();

        return view;
    }

    public void inicializarListaMascotas(){

        mascota = new ArrayList<ListaMascotas>();

        mascota.add(new ListaMascotas(R.drawable.perro_01, "Happy"));
        mascota.add(new ListaMascotas(R.drawable.perro_02, "Dorry"));
        mascota.add(new ListaMascotas(R.drawable.perro_03, "Nemo"));
        mascota.add(new ListaMascotas(R.drawable.perro_04, "Buzz"));
        mascota.add(new ListaMascotas(R.drawable.perro_05, "Candy"));
        mascota.add(new ListaMascotas(R.drawable.perro_06, "Guddy"));
        mascota.add(new ListaMascotas(R.drawable.perro_07, "Puchi"));

    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascota);
        listaMascotas.setAdapter(adaptador);
    }

}
