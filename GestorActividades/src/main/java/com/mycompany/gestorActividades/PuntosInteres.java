/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestorActividades;

import Enumerados.PuntosTipos;

/**
 *
 * @author Raúl Buenaga
 */
public class PuntosInteres {
    
    private int id;
    private String nombre,descripcion,caracteristicasEspeciales;
    private PuntosTipos tipo;
    private double longitud,latitud;
<<<<<<< Updated upstream
    private Ruta idRuta; 
    private Fotos fotos;
=======
    private Ruta ruta; 
>>>>>>> Stashed changes

    public PuntosInteres(int id, String nombre, String descripcion, String caracteristicasEspeciales, PuntosTipos tipo, double longitud, double latitud, Ruta idRuta, Fotos fotos) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.caracteristicasEspeciales = caracteristicasEspeciales;
        this.tipo = tipo;
        this.longitud = longitud;
        this.latitud = latitud;
<<<<<<< Updated upstream
        this.idRuta = idRuta;
        this.fotos = fotos;
=======
        this.ruta = idRuta;
>>>>>>> Stashed changes
    }
    
    

    public PuntosInteres(String nombre, String descripcion, String caracteristicasEspeciales, PuntosTipos tipo, double longitud, double latitud, Ruta idRuta,Fotos fotos) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.caracteristicasEspeciales = caracteristicasEspeciales;
        this.tipo = tipo;
        this.longitud = longitud;
        this.latitud = latitud;
        if(idRuta!=null){
            this.ruta = idRuta;
        }else{
            this.ruta=null;
        }
        if(fotos!=null){
            this.fotos=fotos;
        }else{
            this.fotos=null;
        }
    }
    
    //Metodos
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCaracteristicasEspeciales() {
        return caracteristicasEspeciales;
    }

    public PuntosTipos getTipo() {
        return tipo;
    }

    public double getLongitud() {
        return longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public Fotos getFoto() {
        return fotos;
    }

    public Fotos getFotos() {
        return fotos;
    }
     

}
