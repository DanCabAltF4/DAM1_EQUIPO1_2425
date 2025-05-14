/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestorActividades;

/**
 *
 * @author DAM102
 */
abstract class FichaInformativa {
    protected Disenador creador;
    protected Ruta ruta;

    public FichaInformativa(Disenador creador, Ruta ruta) {
        this.creador = creador;
        this.ruta = ruta;
    }

}
