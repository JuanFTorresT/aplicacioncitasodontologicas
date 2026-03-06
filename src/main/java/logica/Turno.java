/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Felipe
 */
@Entity
public class Turno implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTurno;
    
    @Temporal(TemporalType.DATE)
    private Date fecha;
    private String hora;
    
    @ManyToOne
    @JoinColumn(name = "idTurnoOdontologo")
    private Odontologo odontologo;
    
    @ManyToOne
    @JoinColumn(name = "idTurnoPaciente")
    private Paciente paciente;

    public Turno() {
    }

    public Turno(int idTurno, Date fecha, String hora, Odontologo odontologo) {
        this.idTurno = idTurno;
        this.fecha = fecha;
        this.hora = hora;
        this.odontologo = odontologo;
    }



    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }
    
    
    
}
