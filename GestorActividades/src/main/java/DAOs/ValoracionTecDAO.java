/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import com.mycompany.gestorActividades.AccesoBaseDatos;
import com.mycompany.gestorActividades.Repositorio;
import com.mycompany.gestorActividades.ValoracionTecnica;
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
 * @author DAM105
 */
public class ValoracionTecDAO implements Repositorio<ValoracionTecnica>{
    
    
    private Connection conn;

    public ValoracionTecDAO(Connection conn) {
        this.conn = AccesoBaseDatos.getInstance().getConn();
    }
    
    @Override
    public List<ValoracionTecnica> listar() {
        List<ValoracionTecnica> lista = new ArrayList<>();
        ValoracionTecnica v;
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("Select dificultad,bellezaPaisajistica,interesCultural,usuarios_idUsu,rutas_idRuta,fecha FROM valoracionestecnicas")) {
                while (rs.next()) {
                    v = crearValoracion(rs);
                    if (!lista.add(v)) {
                        throw new Exception("ERROR: la valoracion no ha sido añadida");
                    }
                }
            
            System.out.println("Se ha llenado la lista con valoraciones");
        } catch (SQLException e) {
            System.out.println("SQL error: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }

    
    public ValoracionTecnica porId(int id) {
        ValoracionTecnica valoracion = null;
        try (PreparedStatement stmt = conn.prepareStatement("SELECT dificultad,bellezaPaisajistica,interesCultural,usuarios_idUsu,fecha FROM valoracionestecnicas WHERE rutas_idRuta = ?")) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    valoracion = crearValoracion(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL ERROR: "+e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return valoracion;
    }

    
    public void modificar(ValoracionTecnica v, int idRuta) {
        try (PreparedStatement stmt = conn.prepareStatement("UPDATE valoracionestecnicas SET dificultad = ?,bellezaPaisajistica = ?,interesCultural = ?,fecha = ? WHERE rutas_idRuta = ?")) {
            stmt.setInt(1, v.getDificultad());
            stmt.setInt(2, v.getBelleza());
            stmt.setInt(3, v.getInteres());
            stmt.setDate(4, Date.valueOf(v.getFecha()));
            stmt.setInt(5, idRuta);
            if (stmt.executeUpdate() != 1) {
                throw new Exception("ERROR: no se ha modificado la valoracion");
            }
            System.out.println("Se modifico la valoracion");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    
    public void agregar(ValoracionTecnica v,int idUsu,int idRuta) {
        try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO valoracionestecnicas (dificultad,bellezaPaisajistica,interesCultural,usuarios_idUsu,rutas_idRuta,fecha) VALUES (?, ?, ?, ?, ?, ?)")) {
            stmt.setInt(1, v.getDificultad());
            stmt.setInt(2, v.getBelleza());
            stmt.setInt(3, v.getInteres());
            stmt.setInt(4, idUsu);
            stmt.setInt(5, idRuta);
            stmt.setDate(6, Date.valueOf(v.getFecha()));
            if (stmt.executeUpdate() != 1) {
                throw new Exception("ERROR: no se ha creado la valoracion");
            }
            System.out.println("Se ha creado la valoracion");
        } catch (SQLException e) {
            System.out.println("SQL ERROR "+e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    
    public void eliminar(int idRuta) {
        try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM valoracionestecnicas WHERE rutas_idRuta=?")) {
            stmt.setObject(1, idRuta);
            if (stmt.executeUpdate() != 1) {
                throw new Exception("ERROR: la valoracion no existe");
            }
            System.out.println("Se ha eliminado la valoracion");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
     public ValoracionTecnica crearValoracion(final ResultSet rs) throws Exception {
        return new ValoracionTecnica(null,null,rs.getDate("fecha").toLocalDate(),rs.getInt("dificultad"),rs.getInt("belleza paisajistica"),rs.getInt("interes cultural"));
    }

    @Override
    public void eliminar(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
