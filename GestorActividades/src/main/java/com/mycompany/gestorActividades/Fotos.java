/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestorActividades;

/**
 *
 * @author Raúl Buenaga
 */
public class Fotos {
    
    private int id;
    private String url;
<<<<<<< Updated upstream:GestorActividades/src/main/java/com/mycompany/gestorActividades/Fotos.java

    public Fotos(int id, String url) {
        this.id = id;
        this.url = url;
=======
    private PuntosInteres puntoInteres;

    public FotoPtInteres(int id, String url, PuntosInteres puntoInteres) {
        this.id = id;
        this.url = url;
        this.puntoInteres = puntoInteres;
    }

    public FotoPtInteres(String url, PuntosInteres puntoInteres) {
        this.url = url;
        this.puntoInteres = puntoInteres;
>>>>>>> Stashed changes:GestorActividades/src/main/java/com/mycompany/gestorActividades/FotoPtInteres.java
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
<<<<<<< Updated upstream:GestorActividades/src/main/java/com/mycompany/gestorActividades/Fotos.java
=======

    public PuntosInteres getIdPunto() {
        return puntoInteres;
    }

    public void setIdPunto(PuntosInteres puntoInteres) {
        this.puntoInteres = puntoInteres;
    }
>>>>>>> Stashed changes:GestorActividades/src/main/java/com/mycompany/gestorActividades/FotoPtInteres.java
    
    
}
