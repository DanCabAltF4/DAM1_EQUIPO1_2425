/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestorActividades;

import Enumerados.Clasificación;
import Enumerados.EstadoRuta;
import java.time.LocalDate;

/**
 *
 * @author Usuario
 */
public class Ruta {
    
    private int idRuta;
    private String nombre,gpx,recomendaciones,zonaGeográfica;
    private LocalDate fechaCreacion;
    private double longInicio,latInicio,longFin,latFin,altMax,altMin,desnivelPos,desnivelNeg;
    private Clasificación clasificacion;
    private boolean nivelRiesgo,nivelEsfuerzo,tipoTerreno,indicaciones,accesibilidad,familiar,ValoracionMedia;
    private EstadoRuta estado;
    
}
