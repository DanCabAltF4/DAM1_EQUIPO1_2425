/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import com.mycompany.gestorActividades.AccesoBaseDatos;
import com.mycompany.gestorActividades.Repositorio;
import com.mycompany.gestorActividades.Usuario;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author DAM105
 */
public class UsuarioDAO implements Repositorio<Usuario>{
       
    private Connection conn;

    public UsuarioDAO(Connection conn) {
        this.conn = AccesoBaseDatos.getInstance().getConn();
    }
    
    @Override
    public List<Usuario> listar() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Usuario porId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void modificar(Usuario t) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void agregar(Usuario t) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
