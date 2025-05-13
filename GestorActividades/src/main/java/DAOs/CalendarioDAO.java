/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import com.mycompany.gestorActividades.AccesoBaseDatos;
import com.mycompany.gestorActividades.Calendario;
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
public class CalendarioDAO implements Repositorio<Calendario>{
       
    private Connection conn;

    public CalendarioDAO(Connection conn) {
        this.conn = AccesoBaseDatos.getInstance().getConn();
    }
    
    @Override
    public List<Calendario> listar() {
        List<Calendario> lista = new ArrayList<>();
        Calendario c;
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("Select  FROM calendarios")) {
                while (rs.next()) {
                    c = crearCalendario(rs);
                    if (!lista.add(c)) {
                        throw new Exception("ERROR: el calendario no ha sido añadido");
                    }
                }         
            System.out.println("Se ha llenado la lista con calendarios");
        } catch (SQLException e) {
            System.out.println("SQL error: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }

    @Override
    public Calendario porId(int id) {
        Calendario calendario = null;
        try (PreparedStatement stmt = conn.prepareStatement("SELECT  FROM calendarios WHERE  id= ?")) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    calendario = crearCalendario(rs);
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
    public void modificar(Calendario c) {
        try (PreparedStatement stmt = conn.prepareStatement("UPDATE calendarios SET  WHERE id= ?")) {
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
    public void agregar(Calendario c) {
       try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO calendarios () VALUES (?, ?, ?, ?, ?, ? ,?)")) {
            stmt.setInt(1, u.getId());
            stmt.setString(2, u.getNombre());
            
            if (stmt.executeUpdate() != 1) {
                throw new Exception("ERROR: no se ha creado el calendario");
            }
            System.out.println("Se ha creado el calendario");
        } catch (SQLException e) {
            System.out.println("SQL ERROR "+e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM calendarios WHERE id=?")) {
            stmt.setObject(1, id);
            if (stmt.executeUpdate() != 1) {
                throw new Exception("ERROR: el calendario no existe");
            }
            System.out.println("Se ha eliminado el calendario");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } 
    }
    
     public Calendario crearCalendario(final ResultSet rs) throws Exception {
        return new Calendario();
    }
}
