/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Paciente;
import persistencia.controladoresPersistencia.ControladorPersistenciaPaciente;
import persistencia.PacienteJpaController;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Felipe
 */
public class ControladorPaciente {
     ControladorPersistenciaPaciente controladorPaciente = new ControladorPersistenciaPaciente();
    
    public void crearPaciente (Paciente  paciente){
        controladorPaciente.crearPaciente(paciente);
    }
    
    public void editarPaciente (Paciente  paciente){
        controladorPaciente.editarPaciente(paciente);
    }
    
    public void eliminarPaciente (int id){
        controladorPaciente.eliminarPaciente(id);
    }
    
    public Paciente  obtenerPaciente (int id){
       return  controladorPaciente.obtenerPaciente(id);
    }
    
    public ArrayList<Paciente> obtenerListaHorarios(){
        return controladorPaciente.obtenerListaHorarios();
    }
}
