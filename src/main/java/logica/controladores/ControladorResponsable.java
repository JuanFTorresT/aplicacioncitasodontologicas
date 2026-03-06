/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Responsable;
import persistencia.controladoresPersistencia.ControladorPersistenciaResponsable;
import persistencia.ResponsableJpaController;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Felipe
 */
public class ControladorResponsable {
    ControladorPersistenciaResponsable controladorResponsable = new ControladorPersistenciaResponsable();
    
    public void crearResponsable (Responsable  responsable){
        controladorResponsable.crearResponsable(responsable);
    }
    
    public void editarResponsable (Responsable  responsable){
        controladorResponsable.editarResponsable(responsable);
    }
    
    public void eliminarResponsable (int id){
        controladorResponsable.eliminarResponsable(id);
    }
    
    public Responsable  obtenerResponsable (int id){
       return  controladorResponsable.obtenerResponsable(id);
    }
    
    public ArrayList<Responsable> obtenerListaResponsables(){
        return controladorResponsable.obtenerListaResponsables();
    }
}
