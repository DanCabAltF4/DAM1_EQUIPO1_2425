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
    private Ruta idRuta; 

    public PuntosInteres(int id, String nombre, String descripcion, String caracteristicasEspeciales, PuntosTipos tipo, double longitud, double latitud, Ruta idRuta) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.caracteristicasEspeciales = caracteristicasEspeciales;
        this.tipo = tipo;
        this.longitud = longitud;
        this.latitud = latitud;
        this.idRuta = idRuta;
    }

    public PuntosInteres(String nombre, String descripcion, String caracteristicasEspeciales, PuntosTipos tipo, double longitud, double latitud, Ruta idRuta) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.caracteristicasEspeciales = caracteristicasEspeciales;
        this.tipo = tipo;
        this.longitud = longitud;
        this.latitud = latitud;
        if(idRuta!=null){
            this.idRuta = idRuta;
        }else{
            this.idRuta=null;
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
    
    
         
}
