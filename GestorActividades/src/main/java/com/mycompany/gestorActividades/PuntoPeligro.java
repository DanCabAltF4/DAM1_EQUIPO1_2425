/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestorActividades;

/**
 *
 * @author DAM102
 */
public class PuntoPeligro extends Waypoint{
    
    private int nivGravedad,kilometro;

    public PuntoPeligro(String descripcion, String imagen,int kilometro, int nivGravedad) {
        super(descripcion,imagen);
        this.kilometro = kilometro;
        this.nivGravedad = nivGravedad;
    }
    
    //Métodos

    public int getKilometro() {
        return kilometro;
    }

    public void setgetKilometro(int kilometro) {
        this.kilometro = kilometro;
    }

    public int getNivGravedad() {
        return nivGravedad;
    }

    public void setNivGravedad(int nivGravedad) {
        this.nivGravedad = nivGravedad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getImagen() {
        return imagen;
    }
    
}
