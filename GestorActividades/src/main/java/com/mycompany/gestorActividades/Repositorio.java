/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestorActividades;

import java.util.List;

/**
 *
 * @author Raúl Buenaga 
 */
public interface Repositorio<T> {

    // método para listar todos los objetos T
    // para listar todos los registros de una tabla
    public List<T> listar();


}
