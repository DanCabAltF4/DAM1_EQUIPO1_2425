/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Enumerados.TipoPunto;
import com.mycompany.gestorActividades.AccesoBaseDatos;
import com.mycompany.gestorActividades.PuntoInteres;
import com.mycompany.gestorActividades.Repositorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DAM105
 */
public class PuntoInteresDAO implements Repositorio<PuntoInteres>{
       
    private Connection conn;

    public PuntoInteresDAO(Connection conn) {
        this.conn = AccesoBaseDatos.getInstance().getConn();
    }
    
    @Override
    public List<PuntoInteres> listar() {
        List<PuntoInteres> lista = new ArrayList<>();
        PuntoInteres p;
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("Select id,nombre,tipo,descripcion,caracteristicasEspeciales,longitud,latitud,Ruta.idRuta FROM puntosInteres")) {
                while (rs.next()) {
                    p = crearPuntoInteres(rs);
                    if (!lista.add(p)) {
                        throw new Exception("ERROR: el punto interes no ha sido añadido");
                    }
                }         
            System.out.println("Se ha llenado la lista con puntos interes");
        } catch (SQLException e) {
            System.out.println("SQL error: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }

    public PuntoInteres porId(int id) {
        PuntoInteres puntoInteres = null;
        try (PreparedStatement stmt = conn.prepareStatement("SELECT nombre,tipo,descripcion,caracteristicasEspeciales,longitud,latitud,Ruta.idRuta FROM puntosInteres WHERE id = ?")) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    puntoInteres = crearPuntoInteres(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL ERROR: "+e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return puntoInteres;
    }

    public void modificar(PuntoInteres p) {
        try (PreparedStatement stmt = conn.prepareStatement("UPDATE puntosInteres SET nombre = ?,tipo = ?,descripcion = ?,caracteristicasEspeciales = ?,longitud = ?,latitud = ? WHERE id= ?")) {
            stmt.setString(1, p.getNombre());
            stmt.setObject(2, p.getTipo());
           
            if (stmt.executeUpdate() != 1) {
                throw new Exception("ERROR: no se ha modificado el punto interes");
            }
            System.out.println("Se ha modificado el punto interes");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    
    public void agregar(PuntoInteres u) {
       try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO puntosInteres (id,kilometro,nivelGravedad,descripcion,ruta,longitud,latitud) VALUES (?, ?, ?, ?, ?, ? ,?)")) {
           
            
            if (stmt.executeUpdate() != 1) {
                throw new Exception("ERROR: no se ha creado el punto interes");
            }
            System.out.println("Se ha creado el punto interes");
        } catch (SQLException e) {
            System.out.println("SQL ERROR "+e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void eliminar(int id) {
        try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM puntosInteres WHERE id=?")) {
            stmt.setObject(1, id);
            if (stmt.executeUpdate() != 1) {
                throw new Exception("ERROR: el punto interes no existe");
            }
            System.out.println("Se ha eliminado el punto interes");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } 
    }
    
     public PuntoInteres crearPuntoInteres(final ResultSet rs) throws Exception {
        return new PuntoInteres(rs.getString("descripcion"),rs.getString("imagen"),rs.getString("nombre"),TipoPunto.valueOf("tipo de punto"),rs.getString("caracteristicas"));
    }

    @Override
    public void eliminar(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}  

