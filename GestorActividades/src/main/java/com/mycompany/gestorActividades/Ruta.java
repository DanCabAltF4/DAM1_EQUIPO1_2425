/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestorActividades;

import Enumerados.Clasificacion;
import Enumerados.Estado;
import java.time.LocalDate;

/**
 *
 * @author Usuario
 */
public class Ruta {

    private int nivelRiesgo, nivelEsfuerzo, tipoTerreno,
            indicaciones,accesibilidad, familiar,duracion;// niveles,indicaciones, accesibilidad y familiar valores de 1-5
    private String nombre, gpx, recomendaciones, zona;
    private LocalDate fechaCreacion;
    private double longInicio, longFinal, latInicio, latFinal, altMax, altMin, 
            desnivelPos, desnivelNeg, distancia,valoracionMedia;
    private Clasificacion clasificacion;
    private Estado estado;
    private Invitado usuario;
    private Actividad tipoActividad;
    private Waypoint[] waypoints;
    private Periodo periodo;

    public Ruta(int nivelRiesgo, int nivelEsfuerzo, int tipoTerreno, int indicaciones, int accesibilidad, int familiar, int duracion, String nombre, String gpx, String recomendaciones, String zona, LocalDate fechaCreacion, double longInicio, double longFinal, double latInicio, double latFinal, double altMax, double altMin, double desnivelPos, double desnivelNeg, double distancia, double valoracionMedia, Clasificacion clasificacion, Estado estado, Invitado usuario, Actividad tipoActividad, Waypoint[] waypoints, Periodo periodo) {
        this.nivelRiesgo = nivelRiesgo;
        this.nivelEsfuerzo = nivelEsfuerzo;
        this.tipoTerreno = tipoTerreno;
        this.indicaciones = indicaciones;
        this.accesibilidad = accesibilidad;
        this.familiar = familiar;
        this.duracion = duracion;
        this.nombre = nombre;
        this.gpx = gpx;
        this.recomendaciones = recomendaciones;
        this.zona = zona;
        this.fechaCreacion = fechaCreacion;
        this.longInicio = longInicio;
        this.longFinal = longFinal;
        this.latInicio = latInicio;
        this.latFinal = latFinal;
        this.altMax = altMax;
        this.altMin = altMin;
        this.desnivelPos = desnivelPos;
        this.desnivelNeg = desnivelNeg;
        this.distancia = distancia;
        this.valoracionMedia = valoracionMedia;
        this.clasificacion = clasificacion;
        this.estado = estado;
        this.usuario = usuario;
        this.tipoActividad = tipoActividad;
        this.waypoints = waypoints;
        this.periodo = periodo;
    }
       
}
