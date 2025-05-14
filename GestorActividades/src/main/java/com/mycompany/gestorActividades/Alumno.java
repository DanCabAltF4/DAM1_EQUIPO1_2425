/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestorActividades;

import Enumerados.Estado;

/**
 *
 * @author DAM102
 */
public class Alumno extends Invitado {

    protected String nombre, apellidos, email;
    protected char contrasena;
    protected Estado estado;

    //constructor que crea un alumno con el estado en pendiente
    public Alumno(String nombre, String apellidos, String email, char contrasena) {

        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.contrasena = contrasena;
        estado = Estado.PENDIENTE;
    }

    //constructor que crea un alumno según figura en la base de datos
    public Alumno(String nombre, String apellidos, String email, char contrasena, Estado estado) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.contrasena = contrasena;
        this.estado = estado;
    }

    //Métodos
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
