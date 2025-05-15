/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import com.mycompany.gestorActividades.AccesoBaseDatos;
import com.mycompany.gestorActividades.Actividad;
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
 * @author Raúl Buenaga
 */
public class ActividadDAO implements Repositorio<Actividad>{
       
    private Connection conn;

    public ActividadDAO(Connection conn) {
        this.conn = AccesoBaseDatos.getInstance().getConn();
    }
    
    @Override
    public List<Actividad> listar() {
        List<Actividad> lista = new ArrayList<>();
        Actividad a;
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("Select idActividad,nomActividad FROM actividad")) {
                while (rs.next()) {
                    a = crearActividad(rs);
                    if (!lista.add(a)) {
                        throw new Exception("ERROR: la actividad no ha sido añadido");
                    }
                }         
            System.out.println("Se ha llenado la lista con actividades");
        } catch (SQLException e) {
            System.out.println("SQL error: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }

    
    public Actividad porId(int id) {
        Actividad actividad = null;
        try (PreparedStatement stmt = conn.prepareStatement("SELECT idActividad,nomActividad FROM actividad WHERE idActividad= ?")) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    actividad = crearActividad(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL ERROR: "+e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return actividad;
    }

    
    public void modificar(Actividad a,int id) {
        try (PreparedStatement stmt = conn.prepareStatement("UPDATE actividad SET nomActividad=? WHERE idActividad= ?")) {
             stmt.setString(1, a.getTipo());
             stmt.setInt(2, id);
            if (stmt.executeUpdate() != 1) {
                throw new Exception("ERROR: no se ha modificado la actividad");
            }
            System.out.println("Se ha modificado la actividad");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    
    public void agregar(Actividad a) {
       try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO actividad (nomActividad) VALUES (?)")) {
            stmt.setString(1, a.getTipo());           
            if (stmt.executeUpdate() != 1) {
                throw new Exception("ERROR: no se ha creado la actividad");
            }
            System.out.println("Se ha creado la actividad");
        } catch (SQLException e) {
            System.out.println("SQL ERROR "+e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void eliminar(String nombre) {
        try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM actividad WHERE nombre=?")) {
            stmt.setString(1, nombre);
            if (stmt.executeUpdate() != 1) {
                throw new Exception("ERROR: la actividad no existe");
            }
            System.out.println("Se ha eliminado la actividad");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } 
    }
    
     public Actividad crearActividad(final ResultSet rs) throws Exception {
        return new Actividad(rs.getString("tipo"));
    }
}
