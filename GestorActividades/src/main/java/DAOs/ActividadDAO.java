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
 * @author DAM105
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
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("Select  FROM actividad")) {
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
        Actividad calendario = null;
        try (PreparedStatement stmt = conn.prepareStatement("SELECT  FROM actividad WHERE  id= ?")) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    calendario = crearActividad(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL ERROR: "+e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return calendario;
    }

    @Override
    public void modificar(Actividad a) {
        try (PreparedStatement stmt = conn.prepareStatement("UPDATE actividad SET  WHERE id= ?")) {
            stmt.setString(1, u.getNombre());
            
            if (stmt.executeUpdate() != 1) {
                throw new Exception("ERROR: no se ha modificado el calendario");
            }
            System.out.println("Se ha modificado el calendario");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void agregar(Actividad a) {
       try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO actividad () VALUES (?, ?, ?, ?, ?, ? ,?)")) {
            stmt.setInt(1, u.getId());
            stmt.setString(2, u.getNombre());
            
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
            stmt.setObject(1, id);
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
        return new Actividad();
    }
}
