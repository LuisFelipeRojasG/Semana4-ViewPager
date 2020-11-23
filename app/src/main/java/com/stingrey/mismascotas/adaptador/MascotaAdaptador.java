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

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{
    
    ArrayList<ListaMascotas> mascotas;
    Activity activity;

    public MascotaAdaptador (ArrayList<ListaMascotas> mascotas){

        this.mascotas = mascotas;
    }

   //Inflar el layout y lo pasará al viewHolder para que obtenga los views
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas, parent, false);
        return new MascotaViewHolder(v);
    }

    //Asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder holder, int position) {

        ListaMascotas miMascota = mascotas.get(position);
        holder.ivImagenMascotaCV.setImageResource(miMascota.getFoto());
        holder.tvNombrePerroCV.setText(miMascota.getNombre());

        MascotaViewHolder.ivHuesoBlancoCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(activity, "Te gusta el " + miMascota.getNombre(),Toast.LENGTH_SHORT).show();

            }
        });
    }

    //Cantidad de elementos que contiene la lista
    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

            private ImageView ivImagenMascotaCV;
            private TextView tvNombrePerroCV;
            private static ImageView ivHuesoBlancoCV;


            public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);

            ivImagenMascotaCV   = (ImageView) itemView.findViewById(R.id.ivImagenMascotaCV);
            tvNombrePerroCV     = (TextView) itemView.findViewById(R.id.tvNombrePerroCV);
            ivHuesoBlancoCV     = (ImageView) itemView.findViewById(R.id.ivHuesoBlancoCV);
        }

    }

}
