/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import com.mycompany.gestorActividades.AccesoBaseDatos;
import com.mycompany.gestorActividades.Repositorio;
import com.mycompany.gestorActividades.ValoracionTécnica;
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
public class ValoracionTecDAO implements Repositorio<ValoracionTécnica>{
    
    
    private Connection conn;

    public ValoracionTecDAO(Connection conn) {
        this.conn = AccesoBaseDatos.getInstance().getConn();
    }
    
    @Override
    public List<ValoracionTécnica> listar() {
        List<ValoracionTécnica> lista = new ArrayList<>();
        ValoracionTécnica v;
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("Select dificultad,bellezaPaisajistica,interesCultural,fecha,usuario,ruta FROM valoracionesTecnicas")) {
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

    @Override
    public ValoracionTécnica porId(int id) {
        ValoracionTécnica valoracion = null;
        try (PreparedStatement stmt = conn.prepareStatement("SELECT idValora, dificultad, fecha, estrellas, interesCultural, belleza FROM valora WHERE idValora = ?")) {
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

    @Override
    public void modificar(ValoracionTécnica t) {
        try (PreparedStatement stmt = conn.prepareStatement("UPDATE valoracionesTecnicas SET dificultad = ?,bellezaPaisajistica = ?,interesCultural = ?,fecha = ?,usuario = ?,ruta= ? WHERE idValora = ?")) {
            stmt.setInt(1, t.getDificultad());
            
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

    @Override
    public void agregar(ValoracionTécnica t) {
        try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO valoracionesTecnicas (dificultad,bellezaPaisajistica,interesCultural,fecha,usuario,ruta) VALUES (?, ?, ?, ?, ?, ?)")) {
            stmt.setInt(1, t.getDificultad());
            stmt.setInt(2, t.getBellezaPaisajistica());
            stmt.setInt(3, t.getInteresCultural());
            stmt.setDate(4, Date.valueOf(t.getFecha()));
            stmt.setObject(4, t.getUsuario());
            stmt.setObject(5, t.getRuta());
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

    @Override
    public void eliminar(int id) {
        try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM valoracionesTecnicas WHERE usuario=?")) {
            stmt.setObject(1, id);
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
    
     public ValoracionTécnica crearValoracion(final ResultSet rs) throws Exception {
        return new ValoracionTécnica(rs.getInt("dificultad"),rs.getInt("belleza paisajistica"),rs.getInt("interes cultural"),rs.getDate("fecha").toLocalDate());
    }
}
