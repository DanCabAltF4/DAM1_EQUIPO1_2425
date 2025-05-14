/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import com.mycompany.gestorActividades.AccesoBaseDatos;
import com.mycompany.gestorActividades.PuntoPeligro;
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
public class PuntoPeligroDAO implements Repositorio<PuntoPeligro>{
       
    private Connection conn;

    public PuntoPeligroDAO(Connection conn) {
        this.conn = AccesoBaseDatos.getInstance().getConn();
    }
    
    @Override
    public List<PuntoPeligro> listar() {
        List<PuntoPeligro> lista = new ArrayList<>();
        PuntoPeligro p;
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("Select id,kilometro,nivelGravedad,descripcion,ruta,longitud,latitud FROM puntosPeligro")) {
                while (rs.next()) {
                    p = crearPuntoPeligro(rs);
                    if (!lista.add(p)) {
                        throw new Exception("ERROR: el punto peligroso no ha sido añadido");
                    }
                }         
            System.out.println("Se ha llenado la lista con puntos peligrosos");
        } catch (SQLException e) {
            System.out.println("SQL error: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }

    @Override
    public PuntoPeligro porId(int id) {
        PuntoPeligro puntoPeligro = null;
        try (PreparedStatement stmt = conn.prepareStatement("SELECT id,kilometro,nivelGravedad,descripcion,ruta,longitud,latitud FROM puntosPeligro WHERE id = ?")) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    puntoPeligro = crearPuntoPeligro(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL ERROR: "+e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return puntoPeligro;
    }

    @Override
    public void modificar(PuntoPeligro p) {
        try (PreparedStatement stmt = conn.prepareStatement("UPDATE puntosPeligro SET kilometro = ?,nivelGravedad = ?,descripcion = ?,ruta = ?,longitud = ?,latitud = ? WHERE id= ?")) {
            
            
            if (stmt.executeUpdate() != 1) {
                throw new Exception("ERROR: no se ha modificado el punto peligro");
            }
            System.out.println("Se ha modificado el punto peligro");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void agregar(PuntoPeligro u) {
       try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO puntosPeligro (id,kilometro,nivelGravedad,descripcion,ruta,longitud,latitud) VALUES (?, ?, ?, ?, ?, ? ,?)")) {
            
            
            if (stmt.executeUpdate() != 1) {
                throw new Exception("ERROR: no se ha creado el usuario");
            }
            System.out.println("Se ha creado el usuario");
        } catch (SQLException e) {
            System.out.println("SQL ERROR "+e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM puntosPeligro WHERE id=?")) {
            stmt.setObject(1, id);
            if (stmt.executeUpdate() != 1) {
                throw new Exception("ERROR: el punto peligro no existe");
            }
            System.out.println("Se ha eliminado el punto peligro");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } 
    }
    
     public PuntoPeligro crearPuntoPeligro(final ResultSet rs) throws Exception {
        return new PuntoPeligro(rs.getString("descripcion"),rs.getString("imagen"),rs.getDouble("km"),rs.getInt("nivel de gravedad"));
    }
}
