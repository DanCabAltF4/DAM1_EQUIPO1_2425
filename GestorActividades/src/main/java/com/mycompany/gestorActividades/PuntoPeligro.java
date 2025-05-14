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
    
    private double km;
    private int nivGravedad;

    public PuntoPeligro(String descripcion, String imagen,double km, int nivGravedad) {
        super(descripcion,imagen);
        this.km = km;
        this.nivGravedad = nivGravedad;
    }
    
    //Métodos

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public int getNivGravedad() {
        return nivGravedad;
    }

    public void setNivGravedad(int nivGravedad) {
        this.nivGravedad = nivGravedad;
    }
    
}
