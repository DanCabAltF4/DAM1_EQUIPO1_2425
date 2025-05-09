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
    private Foto fotos;

    public PuntosInteres(int id, String nombre, String descripcion, String caracteristicasEspeciales, PuntosTipos tipo, double longitud, double latitud, Ruta idRuta, Foto fotos) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.caracteristicasEspeciales = caracteristicasEspeciales;
        this.tipo = tipo;
        this.longitud = longitud;
        this.latitud = latitud;
        this.idRuta = idRuta;
        this.fotos = fotos;
    }
    
    

    public PuntosInteres(String nombre, String descripcion, String caracteristicasEspeciales, PuntosTipos tipo, double longitud, double latitud, Ruta idRuta,Foto fotos) {
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

    public Ruta getIdRuta() {
        return idRuta;
    }

    public Foto getFoto() {
        return fotos;
    }

    public Foto getFotos() {
        return fotos;
    }
     

}
