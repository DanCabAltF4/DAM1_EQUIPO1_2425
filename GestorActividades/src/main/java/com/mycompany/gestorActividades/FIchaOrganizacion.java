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
    
    //Métodos 

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    public double getAltitud() {
        return altitud;
    }

    public void setAltitud(double altitud) {
        this.altitud = altitud;
    }

    public Actividad getTipo() {
        return tipo;
    }

    public void setTipo(Actividad tipo) {
        this.tipo = tipo;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }
    
}
