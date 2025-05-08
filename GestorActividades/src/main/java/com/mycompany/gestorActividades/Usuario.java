/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestorActividades;

/**
 *
 * @author Raúl Buenaga
 */
public class Usuario {
    
    private int id;
    private String nombre,apellidos,email;
    private char contrasena;

    public Usuario(int id, String nombre, String apellidos, String email, char contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.contrasena = contrasena;
    }

    public Usuario(String nombre, String apellidos, String email, char contrasena) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.contrasena = contrasena;
    }
    
    public Usuario() {
        this.nombre ="";
        this.apellidos = "";
        this.email = "";
        this.contrasena = contrasena;
    }
    //Métodos
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public char getContrasena() {
        return contrasena;
    }
      
}
