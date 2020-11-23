package com.stingrey.mismascotas;

public class ListaMascotas {

    private String nombre;
    private int foto;

    public ListaMascotas(int foto, String nombre){

        this.foto   = foto;
        this.nombre = nombre;
    }
    public ListaMascotas(int foto){

        this.foto   = foto;

    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public int getFoto() {

        return foto;
    }

    public void setFoto(int foto) {

        this.foto = foto;
    }

}
