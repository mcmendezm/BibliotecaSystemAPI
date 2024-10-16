package com.mfigueroa.BibliotecaSystem.models;

import jakarta.persistence.Entity;

@Entity
public class Bibliotecario extends Persona {

    public Bibliotecario() {}

    public Bibliotecario(String nombre, String apellido) {
        super(nombre, apellido, "Bibliotecario");
    }
}
