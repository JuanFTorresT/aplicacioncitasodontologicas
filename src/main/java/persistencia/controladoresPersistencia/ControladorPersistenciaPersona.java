/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.controladoresPersistencia;



import logica.Persona;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.PersonaJpaController;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Felipe
 */
public class ControladorPersistenciaPersona {
    PersonaJpaController controladorPersona = new PersonaJpaController();
    
    public void crearPersona (Persona  persona){
        controladorPersona.create(persona);
    }
    
    public void editarPersona (Persona  persona){
        try {
            controladorPersona.edit(persona);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistenciaPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarPersona (int id){
        try {
            controladorPersona.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistenciaPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Persona  obtenerPersona (int id){
       return  controladorPersona.findPersona(id);
    }
    
    public ArrayList<Persona> obtenerListaPersonas(){
        List<Persona> listaPersonas = controladorPersona.findPersonaEntities();
        ArrayList<Persona > arrayListPersonas = new ArrayList<Persona>(listaPersonas);
        return arrayListPersonas;
    }
}
