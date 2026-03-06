/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Usuario;
import persistencia.UsuarioJpaController;
import persistencia.controladoresPersistencia.ControladorPersistenciaUsuario;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Felipe
 */
public class ControladorUsuario {
    ControladorPersistenciaUsuario controladorUsuario = new ControladorPersistenciaUsuario();
    
    public void crearUsuario (Usuario  usuario){
        controladorUsuario.crearUsuario(usuario);
    }
    
    public void editarUsuario (Usuario  usuario){
        controladorUsuario.editarUsuario(usuario);
    }
    
    public void eliminarUsuario (int id){
        controladorUsuario.eliminarUsuario(id);
    }
    
    public Usuario  obtenerUsuario (int id){
       return  controladorUsuario.obtenerUsuario(id);
    }
    
    public ArrayList<Usuario> obtenerListaUsuarios(){
        return controladorUsuario.obtenerListaUsuarios();
    }
}
