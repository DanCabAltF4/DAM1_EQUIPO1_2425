/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Enumerados.Clasificacion;
import com.mycompany.gestorActividades.AccesoBaseDatos;
import com.mycompany.gestorActividades.Repositorio;
import com.mycompany.gestorActividades.Ruta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dam105
 */
public class RutaDAO implements Repositorio<Ruta>{
       
    private Connection conn;

    public RutaDAO(Connection conn) {
        this.conn = AccesoBaseDatos.getInstance().getConn();
    }
    
    @Override
    public List<Ruta> listar() {
        List<Ruta> lista = new ArrayList<>();
        Ruta r;
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("Select nombre,fechaCreacion,longInicio,latInicio,longFin,latFin,altMax,altMin,desnivelPos,desnivelNeg,clasificacion,nivelRiesgo,nivelEsfuerzo,tipoTerreno,indicaciones,accesibilidad,familiar,gpx,estado,recomendaciones,zonaGeografica,ValoracionMedia,Actividad_tipoActividad,distanciaTotal,duracionEstimada FROM rutas")) {
                while (rs.next()) {
                    r = crearRuta(rs);
                    if (!lista.add(r)) {
                        throw new Exception("ERROR: la ruta no ha sido añadido");
                    }
                }         
            System.out.println("Se ha llenado la lista con rutas");
        } catch (SQLException e) {
            System.out.println("SQL error: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }

    
    public Ruta porId(String nombre) {
        Ruta resena = null;
        try (PreparedStatement stmt = conn.prepareStatement("SELECT nombre,fechaCreacion,longInicio,latInicio,longFin,latFin,altMax,altMin,desnivelPos,desnivelNeg,clasificacion,nivelRiesgo,nivelEsfuerzo,tipoTerreno,indicaciones,accesibilidad,familiar,gpx,estado,recomendaciones,zonaGeografica,ValoracionMedia,Actividad_tipoActividad,distanciaTotal,duracionEstimada FROM rutas WHERE nombre = ?")) {
            stmt.setString(1, nombre);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    resena = crearRuta(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL ERROR: "+e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resena;
    }

    
    public void modificar(Ruta r,int idRuta) {
        try (PreparedStatement stmt = conn.prepareStatement("UPDATE rutas SET clasificacion = ?,tipoTerreno = ?,indicaciones= ?,accesibilidad= ?,familiar= ?,estado= ?,recomendaciones= ?,zonaGeografica= ?,Actividad_tipoActividad= ? WHERE idRuta= ?")) {
            String clasificacion = String.valueOf(r.getClasificacion());
            stmt.setString(1, clasificacion);
            stmt.setInt(2, r.getTipoTerreno());
            stmt.setInt(3, r.getIndicaciones());
            stmt.setBoolean(4, r.getAccesibilidad());
            stmt.setBoolean(5, r.getFamiliar());
            String estado = String.valueOf(r.getEstado());
            stmt.setString(6, estado);
            stmt.setString(7, r.getRecomendaciones());
            stmt.setString(8, r.getZona());
            stmt.setObject(9, r.getTipoActividad());
            stmt.setInt(10,idRuta );
            if (stmt.executeUpdate() != 1) {
                throw new Exception("ERROR: no se ha modificado la ruta");
            }
            System.out.println("Se ha modificado la ruta");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    
    public void agregar(Ruta r) {
       try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO rutas (clasificacion,tipoTerreno,indicaciones,accesibilidad,familiar,estado,recomendaciones,zonaGeografica,Actividad_tipoActividad) VALUES (?, ?, ?, ?, ?, ? ,?, ? ,?)")) {
            String clasificacion = String.valueOf(r.getClasificacion());
            stmt.setString(1, clasificacion);
            stmt.setInt(2, r.getTipoTerreno());
            stmt.setInt(3, r.getIndicaciones());
            stmt.setBoolean(4, r.getAccesibilidad());
            stmt.setBoolean(5, r.getFamiliar());
            String estado = String.valueOf(r.getEstado());
            stmt.setString(6, estado);
            stmt.setString(7, r.getRecomendaciones());
            stmt.setString(8, r.getZona());
            stmt.setObject(9, r.getTipoActividad());      
            if (stmt.executeUpdate() != 1) {
                throw new Exception("ERROR: no se ha creado la ruta");
            }
            System.out.println("Se ha creado la ruta");
        } catch (SQLException e) {
            System.out.println("SQL ERROR "+e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    
    public void eliminar(String nombre) {
        try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM rutas WHERE nombre=?")) {
            stmt.setObject(1, nombre);
            if (stmt.executeUpdate() != 1) {
                throw new Exception("ERROR: la ruta no existe");
            }
            System.out.println("Se ha eliminado la ruta");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } 
    }
    
     public Ruta crearRuta(final ResultSet rs) throws Exception {
        return new Ruta(rs.getInt("tipo de terreno")
                ,rs.getInt("indicaciones")
                ,rs.getInt("duracion")
                ,rs.getString("nombre")
                ,rs.getString("recomendaciones")
                ,rs.getString("zona")
                ,rs.getDouble("distancia")
                ,rs.getBoolean("accesibilidad")
                ,rs.getBoolean("familiar")
                ,Clasificacion.valueOf("clasificacion")
                ,null
                ,null);
    }     
    
}
