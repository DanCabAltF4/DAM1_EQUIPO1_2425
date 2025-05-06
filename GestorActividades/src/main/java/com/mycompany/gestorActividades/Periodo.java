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
    
    private int id;
    private String nomPeriodo;

    public Periodo(int id, String nomPeriodo) {
        this.id = id;
        this.nomPeriodo = nomPeriodo;
    }
    
    //Métodos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomPeriodo() {
        return nomPeriodo;
    }

    public void setNomPeriodo(String nomPeriodo) {
        this.nomPeriodo = nomPeriodo;
    }

    
}
