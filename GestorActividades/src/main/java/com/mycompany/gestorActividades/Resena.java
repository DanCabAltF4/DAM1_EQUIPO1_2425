/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestorActividades;

import java.time.LocalDate;

/**
 *
 * @author dam105
 */
public class Resena extends Valoracion {

    private String comentario;
    private int valoracion;

    public Resena(Ruta ruta, Disenador votante, LocalDate fecha, String comentario, int valoracion) {
        super(ruta, votante, fecha);
        this.comentario = comentario;
        this.valoracion = valoracion;

    }
    
    //Métodos

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setEstrellas(int valoracion) {
        this.valoracion = valoracion;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
}
