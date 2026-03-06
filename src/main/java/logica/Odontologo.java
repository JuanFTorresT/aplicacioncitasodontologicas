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
public class Odontologo extends Persona{
    //private int idOdontologo;
    private String especialidad;
    
    @OneToOne
    private Horario horario;
    
    @OneToOne
    private Usuario usuario;
    
    @OneToMany(mappedBy = "odontologo")
    private List<Turno>listaTurnos;

    public Odontologo() {
    }

    public Odontologo(String especialidad, Horario horario, Usuario usuario, List<Turno> listaTurnos, int idPersona, String identificacion, String nombre, String apellido, String direccion, String celular, Date fechaNacimiento) {
        super(idPersona, identificacion, nombre, apellido, direccion, celular, fechaNacimiento);
        this.especialidad = especialidad;
        this.horario = horario;
        this.usuario = usuario;
        this.listaTurnos = listaTurnos;
    }

/*
    public int getIdOdontologo() {
        return idOdontologo;
    }

    public void setIdOdontologo(int idOdontologo) {
        this.idOdontologo = idOdontologo;
    }
*/
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Turno> getListaTurnos() {
        return listaTurnos;
    }

    public void setListaTurnos(List<Turno> listaTurnos) {
        this.listaTurnos = listaTurnos;
    }
    
    
    
}
