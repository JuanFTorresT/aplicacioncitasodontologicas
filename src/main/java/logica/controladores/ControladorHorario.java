/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Horario;
import persistencia.controladoresPersistencia.ControladorPersistenciaHorario;
import persistencia.HorarioJpaController;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Felipe
 */
public class ControladorHorario {

    ControladorPersistenciaHorario controladorHorario = new ControladorPersistenciaHorario();
    
    public void crearHorario(Horario horario){
        controladorHorario.crearHorario(horario);
    }
    
    public void editarHorario(Horario horario){
       controladorHorario.editarHorario(horario);
    }
    
    public void eliminarHorario(int id){
        controladorHorario.eliminarHorario(id);
    }
    
    public Horario obtenerHorario(int id){
      return controladorHorario.obtenerHorario(id);
    }
    
    public ArrayList<Horario> obtenerListaHorarios(){
        return controladorHorario.obtenerListaHorarios();
    }
    
}
