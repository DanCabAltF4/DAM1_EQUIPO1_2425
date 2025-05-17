/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestorActividades;

import Enumerados.Clasificacion;
import Enumerados.Estado;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Raúl Buenaga
 */
public class Ruta {

    private int nivelRiesgo, nivelEsfuerzo, tipoTerreno,indicaciones,duracion;
    private String nombre, gpx, recomendaciones, zona;
    private LocalDate fechaCreacion;
    private double longInicio, longFinal, latInicio, latFinal, altMax, altMin,desnivelPos, desnivelNeg, distancia,valoracionMedia;
    private boolean accesibilidad,familiar;
    private Clasificacion clasificacion;
    private Estado estado;
    private Invitado usuario;
    private Actividad tipoActividad;
    private Periodo periodo;
    private List<Waypoint> waypoints; //Hay que controlar a la hora de mostrarlos si son Interes o Peligro

    public Ruta(int nivelRiesgo, int nivelEsfuerzo, int tipoTerreno, int indicaciones, boolean accesibilidad, boolean familiar, int duracion, String nombre, String gpx, String recomendaciones, String zona, LocalDate fechaCreacion, double longInicio, double longFinal, double latInicio, double latFinal, double altMax, double altMin, double desnivelPos, double desnivelNeg, double distancia, double valoracionMedia, Clasificacion clasificacion, Estado estado, Invitado usuario, Actividad tipoActividad, Periodo periodo) {
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
        if(tipoActividad!=null){
            this.tipoActividad = tipoActividad;
        }else{
            this.tipoActividad=null;
        }
        if(periodo!=null){
            this.periodo=periodo;
        }else{
            this.periodo = null;
        }       
        this.waypoints = new ArrayList<>();
        }   
    
    //Constructor con los parámetros para crear una ruta 
    public Ruta(int tipoTerreno, int indicaciones, int duracion, String nombre, String recomendaciones, String zona, double distancia, boolean accesibilidad, boolean familiar, Clasificacion clasificacion, Actividad tipoActividad, Periodo periodo) {
        this.tipoTerreno = tipoTerreno;
        this.indicaciones = indicaciones;
        this.duracion = duracion;
        this.nombre = nombre;
        this.recomendaciones = recomendaciones;
        this.zona = zona;
        this.distancia = distancia;
        this.accesibilidad = accesibilidad;
        this.familiar = familiar;
        this.clasificacion = clasificacion;
        if(tipoActividad!=null){
            this.tipoActividad = tipoActividad;
        }else{
            this.tipoActividad=null;
        }
        if(periodo!=null){
            this.periodo=periodo;
        }else{
            this.periodo = null;
        }       
    }
    
    //Métodos
    public int getNivelRiesgo() {
        return nivelRiesgo;
    }

    public int getNivelEsfuerzo() {
        return nivelEsfuerzo;
    }

    public int getTipoTerreno() {
        return tipoTerreno;
    }

    public int getIndicaciones() {
        return indicaciones;
    }

    public boolean getAccesibilidad() {
        return accesibilidad;
    }

    public boolean getFamiliar() {
        return familiar;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGpx() {
        return gpx;
    }

    public String getRecomendaciones() {
        return recomendaciones;
    }

    public String getZona() {
        return zona;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public double getLongInicio() {
        return longInicio;
    }

    public double getLongFinal() {
        return longFinal;
    }

    public double getLatInicio() {
        return latInicio;
    }

    public double getLatFinal() {
        return latFinal;
    }

    public double getAltMax() {
        return altMax;
    }

    public double getAltMin() {
        return altMin;
    }

    public double getDesnivelPos() {
        return desnivelPos;
    }

    public double getDesnivelNeg() {
        return desnivelNeg;
    }

    public double getDistancia() {
        return distancia;
    }

    public double getValoracionMedia() {
        return valoracionMedia;
    }

    public Clasificacion getClasificacion() {
        return clasificacion;
    }

    public Estado getEstado() {
        return estado;
    }

    public Invitado getUsuario() {
        return usuario;
    }

    public Actividad getTipoActividad() {
        return tipoActividad;
    }

    public Periodo getPeriodo() {
        return periodo;
    }
    
       
}
