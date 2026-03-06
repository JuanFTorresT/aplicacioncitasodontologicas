/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Odontologo;
import persistencia.controladoresPersistencia.ControladorPersistenciaHorario;
import persistencia.controladoresPersistencia.ControladorPersistenciaOdontologo;
import persistencia.OdontologoJpaController;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Felipe
 */
public class ControladorOdontologo {
    ControladorPersistenciaOdontologo controladorOdontologo = new ControladorPersistenciaOdontologo();
    
    public void crearOdontologo(Odontologo odontologo){
        controladorOdontologo.crearOdontologo(odontologo);
    }
    
    public void editarOdontologo(Odontologo odontologo){
        controladorOdontologo.editarOdontologo(odontologo);
    }
    
    public void eliminarOdontologo(int id){
        controladorOdontologo.eliminarOdontologo(id);
    }
    
    public Odontologo obtenerOdontologo(int id){
       return  controladorOdontologo.obtenerOdontologo(id);
    }
    
    public ArrayList<Odontologo> obtenerListaOdontologos(){
        return controladorOdontologo.obtenerListaOdontologos();
    }
}
