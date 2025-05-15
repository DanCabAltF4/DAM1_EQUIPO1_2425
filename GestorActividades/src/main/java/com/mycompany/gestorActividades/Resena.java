/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestorActividades;

import java.time.LocalDate;

/**
 *
 * @author DAM102
 */
public class Resena extends Valoracion {

    private String comentario;
    private float estrellas;

    public Resena(Ruta ruta, Disenador votante, LocalDate fecha, String comentario, float estrellas) {
        super(ruta, votante, fecha);
        this.comentario = comentario;
        this.estrellas = estrellas;

    }
    
    //Métodos

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public float getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(float estrellas) {
        this.estrellas = estrellas;
    }
    
}
