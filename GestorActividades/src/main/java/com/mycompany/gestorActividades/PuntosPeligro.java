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
    private Foto fotos;

    public PuntosPeligro(int id, int kilometro, int nivelGravedad, String descripción, Ruta idRuta, Foto fotos) {
        this.id = id;
        this.kilometro = kilometro;
        this.nivelGravedad = nivelGravedad;
        this.descripción = descripción;
        this.idRuta = idRuta;
        this.fotos = fotos;
    }

    public PuntosPeligro(int kilometro, int nivelGravedad, String descripción, Ruta idRuta, Foto fotos) {
        this.kilometro = kilometro;
        this.nivelGravedad = nivelGravedad;
        this.descripción = descripción;
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

    public Foto getFotos() {
        return fotos;
    }
    
    
}
