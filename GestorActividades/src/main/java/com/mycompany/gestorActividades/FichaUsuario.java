/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestorActividades;

/**
 *
 * @author DAM102
 */
public class FichaUsuario extends FichaInformativa {

    private String datos;//temporal?
    private String recomendaciones;

    public FichaUsuario(String datos, String recomendaciones, Disenador creador, Ruta ruta) {
        super(creador, ruta);
        this.datos = datos;
        this.recomendaciones = recomendaciones;
    }

}
