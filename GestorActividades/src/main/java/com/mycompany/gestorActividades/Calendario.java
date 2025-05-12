/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestorActividades;

import java.time.LocalDateTime;

/**
 *
 * @author Raúl Buenaga
 */
public class Calendario {
    
    private int id;
    private LocalDateTime fecha;
    private String detalles;
    private Usuario usuario;
    private Ruta ruta;

    public Calendario(int id, LocalDateTime fecha, String detalles, Usuario idUsuario, Ruta idRuta) {
        this.id = id;
        this.fecha = fecha;
        this.detalles = detalles;
        this.usuario = idUsuario;
        this.ruta = idRuta;
    }

    public Calendario(LocalDateTime fecha, String detalles, Usuario idUsuario, Ruta idRuta) {
        this.fecha = fecha;
        this.detalles = detalles;
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
    
    //Metodos
    public int getId() {
        return id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public String getDetalles() {
        return detalles;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Ruta getRuta() {
        return ruta;
    }
    
    
}
