/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestorActividades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author  Raúl Buenaga
 */
public class AccesoBaseDatos {
    
     private Connection conn = null;
    // constantes a definir
    private static final String BD = "BD_EQUIPO1";
    private static final String USUARIO = "admin";
    private static final String CLAVE = "password";
    private static final String URL = "jdbc:mysql://10.0.16.150:3306/" + BD;

    
    /**
     * Constructor privado que crea una instancia para la conexión con la base de datos.
     * Utiliza el patrón Singleton para instanciar la clase una unica vez. 
     */
    private AccesoBaseDatos() {

        try {
            Properties properties = new Properties();
            properties.setProperty("user", USUARIO);
            properties.setProperty("password", CLAVE);
            properties.setProperty("useSSL", "false");
            properties.setProperty("autoReconnect", "true");
            conn = (Connection) DriverManager.getConnection(URL, properties);
            if (conn == null) {
                System.out.println("Error en conexion");
            } else {
                System.out.println("Conexion correcta a: " + URL);
            }
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    /**
     * Este método devuelva la instancia para la conexión. 
     * @return La instancia AccesoBaseDatos.
     */
    public static AccesoBaseDatos getInstance() {
        return AccesoBaseDatosHolder.INSTANCE;

    }
    
    /**
     * Clase privada que guarda la unica instancia de conexión
     */

    private static class AccesoBaseDatosHolder {

        private static final AccesoBaseDatos INSTANCE = new AccesoBaseDatos();
    }

    
    public Connection getConn() {
        return conn;
    }

    /**
     * Metodo que cierra la conexión con la base de datos.
     * @return Boolean true si la conexion se ha cerrado, false en caso contrario.
     */
    public boolean cerrar() {
        boolean siCerrada = false;
        try {
            conn.close();
            if (conn.isClosed()) {
                siCerrada = true;
            }
        } catch (SQLException sqe) {
            System.out.println("Se produjo un error en el cierre");
        }
        return siCerrada;
    }

}
