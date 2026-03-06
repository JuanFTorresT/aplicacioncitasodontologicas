/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.controladoresPersistencia;





import logica.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.UsuarioJpaController;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Felipe
 */
public class ControladorPersistenciaUsuario {
   UsuarioJpaController controladorUsuario = new UsuarioJpaController();
    
    public void crearUsuario (Usuario  usuario){
        controladorUsuario.create(usuario);
    }
    
    public void editarUsuario (Usuario  usuario){
        try {
            controladorUsuario.edit(usuario);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistenciaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarUsuario (int id){
        try {
            controladorUsuario.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistenciaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Usuario  obtenerUsuario (int id){
       return  controladorUsuario.findUsuario(id);
    }
    
    public ArrayList<Usuario> obtenerListaUsuarios(){
        List<Usuario> listaUsuarios = controladorUsuario.findUsuarioEntities();
        ArrayList<Usuario > arrayListUsuarios = new ArrayList<Usuario>(listaUsuarios);
        return arrayListUsuarios;
    }
}
