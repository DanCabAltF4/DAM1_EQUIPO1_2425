/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import com.mycompany.gestorActividades.AccesoBaseDatos;
import com.mycompany.gestorActividades.Repositorio;
import com.mycompany.gestorActividades.Invitado;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DAM105
 */
public class InvitadoDAO implements Repositorio<Invitado>{
       
    private Connection conn;

    public InvitadoDAO(Connection conn) {
        this.conn = AccesoBaseDatos.getInstance().getConn();
    }
    
    @Override
    public List<Invitado> listar() {
       
        List<Invitado> usuarios = new ArrayList<>();
        
        try (Statement st= conn.createStatement(); ResultSet rs= st.executeQuery("")){
        
        } catch (SQLException ex){
            System.out.println("No se ha podido hacer la insercción");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return usuarios;
    }

    @Override
    public Invitado porId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void modificar(Invitado t) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void agregar(Invitado t) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
