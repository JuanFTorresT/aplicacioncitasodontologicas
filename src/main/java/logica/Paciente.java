/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Felipe
 */
@Entity
public class Paciente extends Persona{
    
    //private int idPaciente;
    private boolean tieneSeguro;
    private String tipoSangre;
    
    @OneToOne
    private Responsable responsable;
    
    @OneToMany(mappedBy = "paciente")
    private List<Turno> listaTurnos;

    public Paciente() {
    }

    public Paciente(boolean tieneSeguro, String tipoSangre, Responsable responsable, List<Turno> listaTurnos, int idPersona, String identificacion, String nombre, String apellido, String direccion, String celular, Date fechaNacimiento) {
        super(idPersona, identificacion, nombre, apellido, direccion, celular, fechaNacimiento);
        this.tieneSeguro = tieneSeguro;
        this.tipoSangre = tipoSangre;
        this.responsable = responsable;
        this.listaTurnos = listaTurnos;
    }





    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }

    public List<Turno> getListaTurnos() {
        return listaTurnos;
    }

    public void setListaTurnos(List<Turno> listaTurnos) {
        this.listaTurnos = listaTurnos;
    }


/*
    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }
*/
    public boolean isTieneSeguro() {
        return tieneSeguro;
    }

    public void setTieneSeguro(boolean tieneSeguro) {
        this.tieneSeguro = tieneSeguro;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    
    
    
    
}
