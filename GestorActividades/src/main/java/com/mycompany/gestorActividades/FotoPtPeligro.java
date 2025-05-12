/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestorActividades;

/**
 *
 * @author Usuario
 */
public class FotoPtPeligro {
    
    private int id;
    private String url;
    private PuntosPeligro idPunto;

    public FotoPtPeligro(int id, String url, PuntosPeligro idPunto) {
        this.id = id;
        this.url = url;
        this.idPunto = idPunto;
    }

    public FotoPtPeligro(String url, PuntosPeligro idPunto) {
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

    public PuntosPeligro getIdPunto() {
        return idPunto;
    }

    public void setIdPunto(PuntosPeligro idPunto) {
        this.idPunto = idPunto;
    }
    
}
