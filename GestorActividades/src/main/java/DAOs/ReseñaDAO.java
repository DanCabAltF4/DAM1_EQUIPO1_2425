/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import com.mycompany.gestorActividades.AccesoBaseDatos;
import com.mycompany.gestorActividades.Repositorio;
import com.mycompany.gestorActividades.Resena;
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
public class ReseñaDAO implements Repositorio<Resena>{
       
    private Connection conn;

    public ReseñaDAO(Connection conn) {
        this.conn = AccesoBaseDatos.getInstance().getConn();
    }
    
    @Override
    public List<Resena> listar() {
        List<Resena> lista = new ArrayList<>();
        Resena r;
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("Select comentario,Usuario.idUsu,Ruta.idRuta,fecha,valoracion FROM resenna")) {
                while (rs.next()) {
                    r = crearReseña(rs);
                    if (!lista.add(r)) {
                        throw new Exception("ERROR: la resena no ha sido añadido");
                    }
                }         
            System.out.println("Se ha llenado la lista con resenas");
        } catch (SQLException e) {
            System.out.println("SQL error: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }

    
    public Resena porId(int id) {
        Resena resena = null;
        try (PreparedStatement stmt = conn.prepareStatement("SELECT comentario,Usuario.idUsu,Ruta.idRuta,fecha,valoracion FROM resenna WHERE  = ?")) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    resena = crearReseña(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL ERROR: "+e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resena;
    }

    
    public void modificar(Resena r) {
        try (PreparedStatement stmt = conn.prepareStatement("UPDATE resenna SET comentario = ?,fecha = ?,valoracion= ? WHERE = ?")) {
            stmt.setString(1, r.getComentario());
            
            
            if (stmt.executeUpdate() != 1) {
                throw new Exception("ERROR: no se ha modificado la resena");
            }
            System.out.println("Se ha modificado la resena");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    
    public void agregar(Resena r) {
       try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO resenna (comentario,idUsu,idRuta,fecha,valoracion) VALUES (?, ?, ?, ?, ?)")) {
            
            
            if (stmt.executeUpdate() != 1) {
                throw new Exception("ERROR: no se ha creado la resena");
            }
            System.out.println("Se ha creado la resena");
        } catch (SQLException e) {
            System.out.println("SQL ERROR "+e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    
    public void eliminar(int id) {
        try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM resenna WHERE =?")) {
            stmt.setObject(1, id);
            if (stmt.executeUpdate() != 1) {
                throw new Exception("ERROR: la resena no existe");
            }
            System.out.println("Se ha eliminado la resena");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } 
    }
    
     public Resena crearReseña(final ResultSet rs) throws Exception {
        return new Resena(null,null,rs.getDate("fecha").toLocalDate(),rs.getString("comentario"),rs.getFloat("estrellas"));
    }

    @Override
    public void eliminar(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}