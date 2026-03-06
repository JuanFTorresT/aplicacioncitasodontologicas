/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 *
 * @author Felipe
 */
@Entity
public class Secretario extends Persona{
    //private int idSecretario;
    private String sector;
    
    @OneToOne
    private Usuario usuario;

    public Secretario() {
    }

    public Secretario(String sector, Usuario usuario, int idPersona, String identificacion, String nombre, String apellido, String direccion, String celular, Date fechaNacimiento) {
        super(idPersona, identificacion, nombre, apellido, direccion, celular, fechaNacimiento);
        this.sector = sector;
        this.usuario = usuario;
    }

   


/*
    public int getIdSecretario() {
        return idSecretario;
    }

    public void setIdSecretario(int idSecretario) {
        this.idSecretario = idSecretario;
    }
*/
    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
}
