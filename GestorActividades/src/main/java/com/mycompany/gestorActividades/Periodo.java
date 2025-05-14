/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestorActividades;

/**
 *
 * @author Raúl Buenaga
 */
public class Periodo {
    
    private String nombre;

    public Periodo( String nomPeriodo) {
        this.nombre= nomPeriodo;
    }
    
    //Métodos
    public String getNomPeriodo() {
        return nombre;
    }

    public void setNomPeriodo(String nomPeriodo) {
        this.nombre = nomPeriodo;
    }

    
}
