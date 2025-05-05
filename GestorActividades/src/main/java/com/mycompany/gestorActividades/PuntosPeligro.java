/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestorActividades;

/**
 *
 * @author Raúl Buenaga
 */
public class PuntosPeligro {
    
    private int id,kilometro,nivelGravedad;
    private String descripción;

    public PuntosPeligro(int id, int kilometro, int nivelGravedad, String descripción) {
        this.id = id;
        this.kilometro = kilometro;
        this.nivelGravedad = nivelGravedad;
        this.descripción = descripción;
    }

   //Métodos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKilometro() {
        return kilometro;
    }

    public void setKilometro(int kilometro) {
        this.kilometro = kilometro;
    }

    public int getNivelGravedad() {
        return nivelGravedad;
    }
    
    
}
