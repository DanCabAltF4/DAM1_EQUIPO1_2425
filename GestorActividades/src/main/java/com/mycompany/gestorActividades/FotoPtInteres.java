/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestorActividades;

/**
 *
 * @author Raúl Buenaga
 */
public class FotoPtInteres {
    
    private int id;
    private String url;
    private PuntosInteres idPunto;

    public FotoPtInteres(int id, String url, PuntosInteres idPunto) {
        this.id = id;
        this.url = url;
        this.idPunto = idPunto;
    }

    public FotoPtInteres(String url, PuntosInteres idPunto) {
        this.url = url;
        this.idPunto = idPunto;
    }
    
    //Métodos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public PuntosInteres getIdPunto() {
        return idPunto;
    }

    public void setIdPunto(PuntosInteres idPunto) {
        this.idPunto = idPunto;
    }
    
    
}
