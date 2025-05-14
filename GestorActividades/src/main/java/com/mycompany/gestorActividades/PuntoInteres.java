/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestorActividades;

import Enumerados.TipoPunto;

/**
 *
 * @author DAM102
 */
public class PuntoInteres extends Waypoint {
    
    private String nombre;
    private TipoPunto tipo;
    private String caracteristicas;

    public PuntoInteres(String descripcion, String imagen,String nombre, TipoPunto tipo, String caracteristicas) {
        super(descripcion,imagen);
        this.nombre = nombre;
        this.tipo = tipo;
        this.caracteristicas = caracteristicas;
    }
}
