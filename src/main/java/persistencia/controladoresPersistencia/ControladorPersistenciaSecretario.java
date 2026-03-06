/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.controladoresPersistencia;





import logica.Secretario;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.SecretarioJpaController;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Felipe
 */
public class ControladorPersistenciaSecretario {
   SecretarioJpaController controladorSecretario = new SecretarioJpaController();
    
    public void crearSecretario (Secretario  secretario){
        controladorSecretario.create(secretario);
    }
    
    public void editarSecretario (Secretario  secretario){
        try {
            controladorSecretario.edit(secretario);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistenciaSecretario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarSecretario (int id){
        try {
            controladorSecretario.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistenciaSecretario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Secretario  obtenerSecretario (int id){
       return  controladorSecretario.findSecretario(id);
    }
    
    public ArrayList<Secretario> obtenerListaSecretarios(){
        List<Secretario> listaSecretarios = controladorSecretario.findSecretarioEntities();
        ArrayList<Secretario > arrayListSecretarios = new ArrayList<Secretario>(listaSecretarios);
        return arrayListSecretarios;
    }
}
