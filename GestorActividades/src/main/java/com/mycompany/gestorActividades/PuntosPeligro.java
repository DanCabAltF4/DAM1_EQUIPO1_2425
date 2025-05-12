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
    private Ruta idRuta; 
    private double longitud,latidud;

    public PuntosPeligro(int id, int kilometro, int nivelGravedad, String descripción, Ruta idRuta, double longitud, double latidud) {
        this.id = id;
        this.kilometro = kilometro;
        this.nivelGravedad = nivelGravedad;
        this.descripción = descripción;
        this.idRuta = idRuta;
        this.longitud = longitud;
        this.latidud = latidud;
    }

    public PuntosPeligro(int kilometro, int nivelGravedad, String descripción, Ruta idRuta, double longitud, double latidud) {
        this.kilometro = kilometro;
        this.nivelGravedad = nivelGravedad;
        this.descripción = descripción;
        if(idRuta!=null){
            this.idRuta = idRuta;
        }else{
            this.idRuta=null;
        }
        this.longitud = longitud;
        this.latidud = latidud;
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

    public String getDescripción() {
        return descripción;
    }

    public Ruta getIdRuta() {
        return idRuta;
    }

    public double getLongitud() {
        return longitud;
    }

    public double getLatidud() {
        return latidud;
    }

    
    
}
