/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.controladores;

import java.util.ArrayList;
import logica.Persona;
import persistencia.controladoresPersistencia.ControladorPersistenciaPersona;


/**
 *
 * @author Felipe
 */
public class ControladorPersona {
    ControladorPersistenciaPersona controladorPersona = new ControladorPersistenciaPersona();
    
    public void crearPersona (Persona  persona){
        controladorPersona.crearPersona(persona);
    }
    
    public void editarPersona (Persona  persona){
        controladorPersona.editarPersona(persona);
    }
    
    public void eliminarPersona (int id){
        controladorPersona.eliminarPersona(id);
    }
    
    public Persona  obtenerPersona (int id){
       return  controladorPersona.obtenerPersona(id);
    }
    
    public ArrayList<Persona> obtenerListaPersonas(){
        return controladorPersona.obtenerListaPersonas();
    }
}
