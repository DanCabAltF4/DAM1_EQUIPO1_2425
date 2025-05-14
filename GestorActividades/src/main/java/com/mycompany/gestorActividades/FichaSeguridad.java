/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestorActividades;

/**
 *
 * @author DAM102
 */
public class FichaSeguridad extends FichaInformativa{
    private int dificultad;
    private PuntoPeligro[] puntosPeligro;
    private String recomendacion;

    public FichaSeguridad(Disenador creador, Ruta ruta, int dificultad, PuntoPeligro[] puntosPeligro,String recomendacion) {
        super(creador, ruta);
        this.dificultad=dificultad;
        this.puntosPeligro=puntosPeligro;
        this.recomendacion=recomendacion;
    }
}
