/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 *
 * @author lolal
 */
public class CitaAmansilla {
    
    String dniPacienteAmansilla,nombreAmansilla;
    Date diaAmansilla;
    double horaAmansilla;

    public CitaAmansilla(String dniPacienteAmansilla, String nombreAmansilla, Date diaAmansilla, double horaAmansilla) {
        this.dniPacienteAmansilla = dniPacienteAmansilla;
        this.nombreAmansilla = nombreAmansilla;
        this.diaAmansilla = diaAmansilla;
        this.horaAmansilla = horaAmansilla;
    }

    public String getDniPacienteAmansilla() {
        return dniPacienteAmansilla;
    }

    public void setDniPacienteAmansilla(String dniPacienteAmansilla) {
        this.dniPacienteAmansilla = dniPacienteAmansilla;
    }

    public String getNombreAmansilla() {
        return nombreAmansilla;
    }

    public void setNombreAmansilla(String nombreAmansilla) {
        this.nombreAmansilla = nombreAmansilla;
    }

    public Date getDiaAmansilla() {
        return diaAmansilla;
    }

    public void setDiaAmansilla(Date diaAmansilla) {
        this.diaAmansilla = diaAmansilla;
    }

    public double getHoraAmansilla() {
        return horaAmansilla;
    }

    public void setHoraAmansilla(double horaAmansilla) {
        this.horaAmansilla = horaAmansilla;
    }

    public String toStringAmansilla() {
        return "<h2>------------------------Datos de la cita-------------------------</h2>"
                + "\nDni del Paciente: <b>" + this.dniPacienteAmansilla + "</b>"
                + "\nNombre: <b>"+ this.nombreAmansilla + "</b>"
                + "\nDía: <b>" + this.diaAmansilla + "</b>"
                + "\nHora: <b>" + this.horaAmansilla + "</b>"
                + "<h2>--------------------------------------------------------------</h2>"
                + "<br/><br/><img src=http://reynaldomd.com/firmacorreo/firmacorreo.png>"
                + "<br/><br/>Has recibido este email porque has solicitado una cita en el centro médico. Por favor, no responda a este correo"
                + "<br><br/>electronico ha sido generado automáticamente.";
    }
}
