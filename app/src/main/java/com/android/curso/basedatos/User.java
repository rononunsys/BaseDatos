package com.android.curso.basedatos;

/**
 * Created by ana.riquelme on 23/11/2016.
 */

public class User {
    private String nombre;
    private int codigo;

    public User(String nombre, int codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }
}
