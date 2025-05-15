/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Enumerados.Clasificacion;
import Enumerados.Estado;
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
    public void eliminar(String nombre) {
        try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM rutas WHERE nombre=?")) {
            stmt.setObject(1, nombre);
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
        return new Ruta(rs.getInt("nivel de riesgo")
                ,rs.getInt("nivel de esfuerzo")
                ,rs.getInt("tipo de terreno")
                ,rs.getInt("indicaciones")
                ,rs.getBoolean("accesibilidad")
                ,rs.getBoolean("familiar")
                ,rs.getInt("duracion")
                ,rs.getString("nombre")
                ,rs.getString("gpx")
                ,rs.getString("recomendaciones")
                ,rs.getString("zona")
                ,rs.getDate("fechaCreacion").toLocalDate()
                ,rs.getDouble("longInicio")
                ,rs.getDouble("longFinal")
                ,rs.getDouble("latInicio")
                ,rs.getDouble("latFinal")
                ,rs.getDouble("altMax")
                ,rs.getDouble("altMin")
                ,rs.getDouble("desnivelPos")
                ,rs.getDouble("desnivelNeg")
                ,rs.getDouble("distancia")
                ,rs.getDouble("valoracionMedia")
                ,Clasificacion.valueOf("clasificacion")
                ,Estado.valueOf("estado")
                ,null
                ,null
                ,null);
    }     
    
}
