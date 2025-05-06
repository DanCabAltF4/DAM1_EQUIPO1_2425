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
    private Usuario idUsuario;
    private Ruta idRuta;

    public Calendario(int id, LocalDateTime fecha, String detalles, Usuario idUsuario, Ruta idRuta) {
        this.id = id;
        this.fecha = fecha;
        this.detalles = detalles;
        this.idUsuario = idUsuario;
        this.idRuta = idRuta;
    }

    public Calendario(LocalDateTime fecha, String detalles, Usuario idUsuario, Ruta idRuta) {
        this.fecha = fecha;
        this.detalles = detalles;
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

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public Ruta getIdRuta() {
        return idRuta;
    }
    
    
}
