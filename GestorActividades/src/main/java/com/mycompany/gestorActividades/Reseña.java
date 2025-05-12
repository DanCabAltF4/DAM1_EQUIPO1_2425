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
    private Usuario idUsuario;
    private Ruta idRuta; 

    public Reseña(String comentarios, LocalDate fecah, int valoracion, Usuario idUsuario, Ruta idRuta) {
        this.comentarios = comentarios;
        this.fecah = fecah;
        this.valoracion = valoracion;
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

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Ruta getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(Ruta idRuta) {
        this.idRuta = idRuta;
    }
    
    
}
