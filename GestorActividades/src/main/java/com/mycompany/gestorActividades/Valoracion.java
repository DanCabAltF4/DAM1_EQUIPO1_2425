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
abstract class Valoracion {
    
    protected Ruta ruta;
    protected Disenador votante;
    protected LocalDate fecha;

    public Valoracion(Ruta ruta, Disenador votante, LocalDate fecha) {
        this.ruta = ruta;
        this.votante = votante;
        this.fecha = fecha;
        if(idUsuario!=null){
            this.idUsuario=idUsuario;
        }else{
            this.idUsuario=null;
        }
        if(idRuta!=null){
            this.idRuta = idRuta;
        }else{
            this.idRuta=null;
        }
    }
    
    //Métodos
    public int getDificultad() {
        return dificultad;
    }

    public int getBellezaPaisajistica() {
        return bellezaPaisajistica;
    }

    public int getInteresCultural() {
        return interesCultural;
    }

    public String getResena() {
        return resena;
    }

    public String getValTecnica() {
        return valTecnica;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public Ruta getIdRuta() {
        return idRuta;
    }
    
    
}
