/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.controladoresPersistencia;

import logica.Horario;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.HorarioJpaController;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Felipe
 */
public class ControladorPersistenciaHorario {
    HorarioJpaController controladorHorario = new HorarioJpaController();
    
    public void crearHorario(Horario horario){
        controladorHorario.create(horario);
    }
    
    public void editarHorario(Horario horario){
        try {
            controladorHorario.edit(horario);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistenciaHorario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarHorario(int id){
        try {
            controladorHorario.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistenciaHorario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Horario obtenerHorario(int id){
       return  controladorHorario.findHorario(id);
    }
    
    public ArrayList<Horario> obtenerListaHorarios(){
        List<Horario> listaHorarios = controladorHorario.findHorarioEntities();
        ArrayList<Horario> arrayListHorarios = new ArrayList<Horario>(listaHorarios);
        return arrayListHorarios;
    }
}
