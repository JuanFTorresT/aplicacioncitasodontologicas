/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.controladoresPersistencia;




import logica.Turno;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.TurnoJpaController;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Felipe
 */
public class ControladorPersistenciaTurno {
   TurnoJpaController controladorTurno = new TurnoJpaController();
    
    public void crearTurno (Turno  turno){
        controladorTurno.create(turno);
    }
    
    public void editarTurno (Turno  turno){
        try {
            controladorTurno.edit(turno);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistenciaTurno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarTurno (int id){
        try {
            controladorTurno.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistenciaTurno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Turno  obtenerTurno (int id){
       return  controladorTurno.findTurno(id);
    }
    
    public ArrayList<Turno> obtenerListaTurnos(){
        List<Turno> listaTurnos = controladorTurno.findTurnoEntities();
        ArrayList<Turno > arrayListTurnos = new ArrayList<Turno>(listaTurnos);
        return arrayListTurnos;
    }
}
