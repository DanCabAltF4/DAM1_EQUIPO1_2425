/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import com.mycompany.gestorActividades.AccesoBaseDatos;
import com.mycompany.gestorActividades.Repositorio;
import com.mycompany.gestorActividades.Resena;
import java.sql.Connection;
import java.sql.Date;
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
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("Select comentario,usuarios_idUsu,rutas_idRuta,fecha,valoracion FROM resenna")) {
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
        try (PreparedStatement stmt = conn.prepareStatement("SELECT comentario,rutas_idRuta,fecha,valoracion FROM resenna WHERE  usuarios_idUsu= ?")) {
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

    
    public void modificar(Resena r,int idRuta) {
        try (PreparedStatement stmt = conn.prepareStatement("UPDATE resenna SET comentario = ?,fecha = ?,valoracion= ? WHERE rutas_idRuta= ?")) {
            stmt.setString(1, r.getComentario());
            stmt.setDate(2, Date.valueOf(r.getFecha()));
            stmt.setInt(3, r.getValoracion());
            stmt.setInt(4, idRuta);
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

    
    public void agregar(Resena r,int idUsuario,int idRuta) {
       try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO resenna (comentario,usuarios_idUsu,rutas_idRuta,fecha,valoracion) VALUES (?, ?, ?, ?, ?)")) {
            stmt.setString(1, r.getComentario());
            stmt.setInt(2, idUsuario);
            stmt.setInt(3, idRuta);
            stmt.setDate(4, Date.valueOf(r.getFecha()));
            stmt.setInt(5, r.getValoracion());
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
        try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM resenna WHERE rutas_idRuta=?")) {
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
        return new Resena(null,null,rs.getDate("fecha").toLocalDate(),rs.getString("comentario"),rs.getInt("estrellas"));
    }

    @Override
    public void eliminar(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}