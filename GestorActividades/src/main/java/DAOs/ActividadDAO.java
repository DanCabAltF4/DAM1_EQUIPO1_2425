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
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("Select id,nomActividad FROM actividad")) {
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

    @Override
    public Actividad porId(int id) {
        Actividad actividad = null;
        try (PreparedStatement stmt = conn.prepareStatement("SELECT id,nomActividad FROM actividad WHERE  id= ?")) {
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

    @Override
    public void modificar(Actividad a) {
        try (PreparedStatement stmt = conn.prepareStatement("UPDATE actividad SET  id= ?,nomActividad=? WHERE id= ?")) {
            stmt.setInt(1, a.getId());
            stmt.setString(2, a.getNomActividad());           
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

    @Override
    public void agregar(Actividad a) {
       try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO actividad (id,nomActividad) VALUES (?, ?)")) {
            stmt.setInt(1, a.getId());
            stmt.setString(2, a.getNomActividad());           
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
    public void eliminar(int id) {
        try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM actividad WHERE id=?")) {
            stmt.setInt(1, id);
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
        return new Actividad(rs.getInt("id"),rs.getString("nomActividad"));
    }
}
