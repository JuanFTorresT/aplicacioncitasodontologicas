/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Turno;
import persistencia.TurnoJpaController;
import persistencia.controladoresPersistencia.ControladorPersistenciaTurno;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Felipe
 */
public class ControladorTurno {
    ControladorPersistenciaTurno controladorTurno = new ControladorPersistenciaTurno();
    
    public void crearTurno (Turno  turno){
        controladorTurno.crearTurno(turno);
    }
    
    public void editarTurno (Turno  turno){
        controladorTurno.editarTurno(turno);
    }
    
    public void eliminarTurno (int id){
        controladorTurno.eliminarTurno(id);
    }
    
    public Turno  obtenerTurno (int id){
       return  controladorTurno.obtenerTurno(id);
    }
    
    public ArrayList<Turno> obtenerListaTurnos(){
        return controladorTurno.obtenerListaTurnos();
    }
}
