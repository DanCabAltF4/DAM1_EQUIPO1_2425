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
    private Usuario usuario;
    private Ruta ruta; 

    public Valoracion(int dificultad, int bellezaPaisajistica, int interesCultural, String resena, String valTecnica, LocalDate fecha, Usuario idUsuario, Ruta idRuta) {
        this.dificultad = dificultad;
        this.bellezaPaisajistica = bellezaPaisajistica;
        this.interesCultural = interesCultural;
        this.resena = resena;
        this.valTecnica = valTecnica;
        this.fecha = fecha;
        if(idUsuario!=null){
            this.usuario=idUsuario;
        }else{
            this.usuario=null;
        }
        if(idRuta!=null){
            this.ruta = idRuta;
        }else{
            this.ruta=null;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public Ruta getRuta() {
        return ruta;
    }
<<<<<<< Updated upstream:GestorActividades/src/main/java/com/mycompany/gestorActividades/Valoracion.java
=======

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

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }
>>>>>>> Stashed changes:GestorActividades/src/main/java/com/mycompany/gestorActividades/ValoracionTécnica.java
    
    
}
