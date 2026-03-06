/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Entity;

/**
 *
 * @author Felipe
 */
@Entity
public class Responsable extends Persona{
    //private int idResponsable;
    private String parentesco;

    public Responsable() {
    }

    public Responsable(String parentesco, int idPersona, String identificacion, String nombre, String apellido, String direccion, String celular, Date fechaNacimiento) {
        super(idPersona, identificacion, nombre, apellido, direccion, celular, fechaNacimiento);
        this.parentesco = parentesco;
    }




/*
    public int getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(int idResponsable) {
        this.idResponsable = idResponsable;
    }
*/

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }
    
    
}
