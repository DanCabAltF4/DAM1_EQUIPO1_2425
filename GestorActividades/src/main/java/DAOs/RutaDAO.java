/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

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
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("Select  FROM rutas")) {
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

    @Override
    public Ruta porId(int id) {
        Ruta resena = null;
        try (PreparedStatement stmt = conn.prepareStatement("SELECT  FROM rutas WHERE idRuta = ?")) {
            stmt.setInt(1, id);
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

    @Override
    public void modificar(Ruta r) {
        try (PreparedStatement stmt = conn.prepareStatement("UPDATE rutas SET comentario = ?,fecha = ?,valoracion= ? WHERE idRuta= ?")) {
            
            
            
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

    @Override
    public void agregar(Ruta r) {
       try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO rutas () VALUES (?, ?, ?, ?, ?, ? ,?)")) {
            
            
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

    @Override
    public void eliminar(int id) {
        try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM rutas WHERE idRuta=?")) {
            stmt.setObject(1, id);
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
        return new Ruta();
    }     
    
}
