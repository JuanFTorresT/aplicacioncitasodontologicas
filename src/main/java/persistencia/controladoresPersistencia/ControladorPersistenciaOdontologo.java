/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.controladoresPersistencia;


import logica.Odontologo;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.OdontologoJpaController;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Felipe
 */
public class ControladorPersistenciaOdontologo {
    OdontologoJpaController controladorOdontologo = new OdontologoJpaController();
    
    public void crearOdontologo(Odontologo odontologo){
        controladorOdontologo.create(odontologo);
    }
    
    public void editarOdontologo(Odontologo odontologo){
        try {
            controladorOdontologo.edit(odontologo);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistenciaOdontologo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarOdontologo(int id){
        try {
            controladorOdontologo.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistenciaOdontologo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Odontologo obtenerOdontologo(int id){
       return  controladorOdontologo.findOdontologo(id);
    }
    
    public ArrayList<Odontologo> obtenerListaOdontologos(){
        List<Odontologo> listaOdontologos = controladorOdontologo.findOdontologoEntities();
        ArrayList<Odontologo> arrayListOdontologos = new ArrayList<Odontologo>(listaOdontologos);
        return arrayListOdontologos;
    }
}
