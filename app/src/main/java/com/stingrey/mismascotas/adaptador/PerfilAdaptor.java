package com.stingrey.mismascotas.adaptador;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.stingrey.mismascotas.ListaMascotas;
import com.stingrey.mismascotas.R;

import java.util.ArrayList;

public class PerfilAdaptor extends RecyclerView.Adapter<PerfilAdaptor.PerfilViewHolder>{
    ArrayList<ListaMascotas> mascotas;
    Activity activity;

    public PerfilAdaptor (ArrayList<ListaMascotas> mascotas){

        this.mascotas = mascotas;
    }

    //Inflar el layout y lo pasará al viewHolder para que obtenga los views
    @Override
    public PerfilViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_pefil, parent, false);
        return new PerfilViewHolder(v);
    }



    //Asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(@NonNull PerfilAdaptor.PerfilViewHolder holder, int position) {

        ListaMascotas miMascota = mascotas.get(position);
        holder.ivImagenMascotaCV.setImageResource(miMascota.getFoto());

    }

    //Cantidad de elementos que contiene la lista
    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class PerfilViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivImagenMascotaCV;
        private TextView tvNombrePerroCV;
        //private static ImageView ivHuesoBlancoCV;


        public PerfilViewHolder(@NonNull View itemView) {
            super(itemView);

            ivImagenMascotaCV   = (ImageView) itemView.findViewById(R.id.ivImagenMascotaCV);
            tvNombrePerroCV     = (TextView) itemView.findViewById(R.id.tvNombrePerroCV);
            //ivHuesoBlancoCV     = (ImageView) itemView.findViewById(R.id.ivHuesoBlancoCV);
        }

    }

}

