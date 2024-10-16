package com.mfigueroa.BibliotecaSystem.models;

import jakarta.persistence.Entity;

@Entity
public class Usuario extends Persona {
    private int prestamos;

    // Constructor, Getters y Setters
    public Usuario() {}

    public Usuario(String nombre, String apellido, int prestamos) {
        super(nombre, apellido, "Usuario");
        this.prestamos = prestamos;
    }

    public int getPrestamos() { return prestamos; }
    public void setPrestamos(int prestamos) { this.prestamos = prestamos; }
}
