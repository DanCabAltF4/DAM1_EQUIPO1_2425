/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestorActividades;

/**
 *
 * @author DAM102
 */
public class FIchaOrganizacion extends FichaInformativa{
    
    private String datos; //temporal? 
    private double altitud;
    private Actividad tipo;
    private String opinion;
    //preguntar por nivel educativo


    public FIchaOrganizacion(String datos, double altitud, Actividad tipo, String opinion, Disenador creador, Ruta ruta) {
        super(creador, ruta);
        this.datos = datos;
        this.altitud = altitud;
        this.tipo = tipo;
        this.opinion = opinion;
    }
    
    
}
