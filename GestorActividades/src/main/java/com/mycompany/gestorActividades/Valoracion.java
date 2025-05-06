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
public class Valoracion {
    
    private int dificultad,bellezaPaisajistica,interesCultural;
    private String resena,valTecnica;
    private LocalDate fecha;
    private Usuario idUsuario;
    private Ruta idRuta; 

    public Valoracion(int dificultad, int bellezaPaisajistica, int interesCultural, String resena, String valTecnica, LocalDate fecha, Usuario idUsuario, Ruta idRuta) {
        this.dificultad = dificultad;
        this.bellezaPaisajistica = bellezaPaisajistica;
        this.interesCultural = interesCultural;
        this.resena = resena;
        this.valTecnica = valTecnica;
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
