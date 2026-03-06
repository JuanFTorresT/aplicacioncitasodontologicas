/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.controladoresPersistencia;




import logica.Responsable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.ResponsableJpaController;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Felipe
 */
public class ControladorPersistenciaResponsable {
   ResponsableJpaController controladorResponsable = new ResponsableJpaController();
    
    public void crearResponsable (Responsable  responsable){
        controladorResponsable.create(responsable);
    }
    
    public void editarResponsable (Responsable  responsable){
        try {
            controladorResponsable.edit(responsable);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistenciaResponsable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarResponsable (int id){
        try {
            controladorResponsable.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistenciaResponsable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Responsable  obtenerResponsable (int id){
       return  controladorResponsable.findResponsable(id);
    }
    
    public ArrayList<Responsable> obtenerListaResponsables(){
        List<Responsable> listaResponsables = controladorResponsable.findResponsableEntities();
        ArrayList<Responsable > arrayListResponsables = new ArrayList<Responsable>(listaResponsables);
        return arrayListResponsables;
    }
}
