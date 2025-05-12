/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestorActividades;

import java.time.LocalDate;

/**
 *
 * @author Raúl Buenaga
 */
public class ValoracionTécnica {
    
    private int dificultad,bellezaPaisajistica,interesCultural;
    private LocalDate fecha;
    private Usuario idUsuario;
    private Ruta idRuta; 

    public ValoracionTécnica(int dificultad, int bellezaPaisajistica, int interesCultural, LocalDate fecha, Usuario idUsuario, Ruta idRuta) {
        this.dificultad = dificultad;
        this.bellezaPaisajistica = bellezaPaisajistica;
        this.interesCultural = interesCultural;
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

    public LocalDate getFecha() {
        return fecha;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public Ruta getIdRuta() {
        return idRuta;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

    public void setBellezaPaisajistica(int bellezaPaisajistica) {
        this.bellezaPaisajistica = bellezaPaisajistica;
    }

    public void setInteresCultural(int interesCultural) {
        this.interesCultural = interesCultural;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setIdRuta(Ruta idRuta) {
        this.idRuta = idRuta;
    }
    
    
}
