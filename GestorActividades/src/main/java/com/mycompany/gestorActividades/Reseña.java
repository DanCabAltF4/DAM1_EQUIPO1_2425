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
public class Reseña {
    
    private String comentarios;
    private LocalDate fecah;
    private int valoracion;
    private Usuario usuario;
    private Ruta ruta; 

    public Reseña(String comentarios, LocalDate fecah, int valoracion, Usuario idUsuario, Ruta idRuta) {
        this.comentarios = comentarios;
        this.fecah = fecah;
        this.valoracion = valoracion;
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
    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public LocalDate getFecah() {
        return fecah;
    }

    public void setFecah(LocalDate fecah) {
        this.fecah = fecah;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }
    
    
}
