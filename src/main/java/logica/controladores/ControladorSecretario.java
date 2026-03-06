/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Secretario;
import persistencia.controladoresPersistencia.ControladorPersistenciaSecretario;
import persistencia.SecretarioJpaController;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Felipe
 */
public class ControladorSecretario {
    ControladorPersistenciaSecretario controladorSecretario = new ControladorPersistenciaSecretario();
    
    public void crearSecretario (Secretario  secretario){
        controladorSecretario.crearSecretario(secretario);
    }
    
    public void editarSecretario (Secretario  secretario){
       controladorSecretario.editarSecretario(secretario);
    }
    
    public void eliminarSecretario (int id){
        controladorSecretario.eliminarSecretario(id);
    }
    
    public Secretario  obtenerSecretario (int id){
       return  controladorSecretario.obtenerSecretario(id);
    }
    
    public ArrayList<Secretario> obtenerListaSecretarios(){
        return controladorSecretario.obtenerListaSecretarios();
    }
}
