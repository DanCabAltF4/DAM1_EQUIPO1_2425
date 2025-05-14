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
public class ValoracionTecnica extends Valoracion {

    private int dificultad;
    private int belleza;
    private int interes;

    public ValoracionTecnica(Ruta ruta, Disenador votante, LocalDate fecha, int dificultad, int belleza, int interes) {
        super(ruta, votante, fecha);
        this.dificultad = dificultad;
        this.belleza = belleza;
        this.interes = interes;

    }
}
