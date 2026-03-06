/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.controladoresPersistencia;


import logica.Paciente;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.PacienteJpaController;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Felipe
 */
public class ControladorPersistenciaPaciente {
    PacienteJpaController controladorPaciente = new PacienteJpaController();
    
    public void crearPaciente (Paciente  paciente){
        controladorPaciente.create(paciente);
    }
    
    public void editarPaciente (Paciente  paciente){
        try {
            controladorPaciente.edit(paciente);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistenciaPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarPaciente (int id){
        try {
            controladorPaciente.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistenciaPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Paciente  obtenerPaciente (int id){
       return  controladorPaciente.findPaciente(id);
    }
    
    public ArrayList<Paciente> obtenerListaHorarios(){
        List<Paciente> listaPacientes = controladorPaciente.findPacienteEntities();
        ArrayList<Paciente > arrayListPacientes = new ArrayList<Paciente>(listaPacientes);
        return arrayListPacientes;
    }
}
