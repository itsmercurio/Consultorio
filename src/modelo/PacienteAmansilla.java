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
public class PacienteAmansilla {

    private String dniAmansilla, nombreAmansilla, apellidosAmansilla;
    private Date fechaNacimientoAmansilla;
    private int telefonoAmansilla;
    private String emailAmansilla;
    private int cpAmansilla;
    private String sexoAmansilla, tabaquismoAmansilla, consumoalcoholAmansilla, antecedentesSaludAmansilla, datosSaludGeneralAmansilla;
    private Date fechaRegistroAmansilla;

    public PacienteAmansilla(String nombreAmansilla, String apellidosAmansilla, int telefonoAmansilla, String emailAmansilla) {
        this.nombreAmansilla = nombreAmansilla;
        this.apellidosAmansilla = apellidosAmansilla;
        this.telefonoAmansilla = telefonoAmansilla;
        this.emailAmansilla = emailAmansilla;
    }

    public PacienteAmansilla(String dniAmansilla, String nombreAmansilla, String apellidosAmansilla, Date fechaNacimientoAmansilla, int telefonoAmansilla, String emailAmansilla, int cpAmansilla, String sexoAmansilla, String tabaquismoAmansilla, String consumoalcoholAmansilla, String antecedentesSaludAmansilla, String datosSaludGeneralAmansilla, Date fechaRegistroAmansilla) {
        this.dniAmansilla = dniAmansilla;
        this.nombreAmansilla = nombreAmansilla;
        this.apellidosAmansilla = apellidosAmansilla;
        this.fechaNacimientoAmansilla = fechaNacimientoAmansilla;
        this.telefonoAmansilla = telefonoAmansilla;
        this.emailAmansilla = emailAmansilla;
        this.cpAmansilla = cpAmansilla;
        this.sexoAmansilla = sexoAmansilla;
        this.tabaquismoAmansilla = tabaquismoAmansilla;
        this.consumoalcoholAmansilla = consumoalcoholAmansilla;
        this.antecedentesSaludAmansilla = antecedentesSaludAmansilla;
        this.datosSaludGeneralAmansilla = datosSaludGeneralAmansilla;
        this.fechaRegistroAmansilla = fechaRegistroAmansilla;
    }

    public PacienteAmansilla(String nombreAmansilla, String apellidosAmansilla, int telefonoAmansilla, int cpAmansilla) {
        this.nombreAmansilla = nombreAmansilla;
        this.apellidosAmansilla = apellidosAmansilla;
        this.telefonoAmansilla = telefonoAmansilla;
        this.cpAmansilla = cpAmansilla;
    }

    
    public String getDniAmansilla() {
        return dniAmansilla;
    }

    public void setDniAmansilla(String dniAmansilla) {
        this.dniAmansilla = dniAmansilla;
    }

    public String getNombreAmansilla() {
        return nombreAmansilla;
    }

    public void setNombreAmansilla(String nombreAmansilla) {
        this.nombreAmansilla = nombreAmansilla;
    }

    public String getApellidosAmansilla() {
        return apellidosAmansilla;
    }

    public void setApellidosAmansilla(String apellidosAmansilla) {
        this.apellidosAmansilla = apellidosAmansilla;
    }

    public Date getFechaNacimientoAmansilla() {
        return fechaNacimientoAmansilla;
    }

    public void setFechaNacimientoAmansilla(Date fechaNacimientoAmansilla) {
        this.fechaNacimientoAmansilla = fechaNacimientoAmansilla;
    }

    public int getTelefonoAmansilla() {
        return telefonoAmansilla;
    }

    public void setTelefonoAmansilla(int telefonoAmansilla) {
        this.telefonoAmansilla = telefonoAmansilla;
    }

    public String getEmailAmansilla() {
        return emailAmansilla;
    }

    public void setEmailAmansilla(String emailAmansilla) {
        this.emailAmansilla = emailAmansilla;
    }

    public int getCpAmansilla() {
        return cpAmansilla;
    }

    public void setCpAmansilla(int cpAmansilla) {
        this.cpAmansilla = cpAmansilla;
    }

    public String getSexoAmansilla() {
        return sexoAmansilla;
    }

    public void setSexoAmansilla(String sexoAmansilla) {
        this.sexoAmansilla = sexoAmansilla;
    }

    public String getTabaquismoAmansilla() {
        return tabaquismoAmansilla;
    }

    public void setTabaquismoAmansilla(String tabaquismoAmansilla) {
        this.tabaquismoAmansilla = tabaquismoAmansilla;
    }

    public String getConsumoalcoholAmansilla() {
        return consumoalcoholAmansilla;
    }

    public void setConsumoalcoholAmansilla(String consumoalcoholAmansilla) {
        this.consumoalcoholAmansilla = consumoalcoholAmansilla;
    }

    public String getAntecedentesSaludAmansilla() {
        return antecedentesSaludAmansilla;
    }

    public void setAntecedentesSaludAmansilla(String antecedentesSaludAmansilla) {
        this.antecedentesSaludAmansilla = antecedentesSaludAmansilla;
    }

    public String getDatosSaludGeneralAmansilla() {
        return datosSaludGeneralAmansilla;
    }

    public void setDatosSaludGeneralAmansilla(String datosSaludGeneralAmansilla) {
        this.datosSaludGeneralAmansilla = datosSaludGeneralAmansilla;
    }

    public Date getFechaRegistroAmansilla() {
        return fechaRegistroAmansilla;
    }

    public void setFechaRegistroAmansilla(Date fechaRegistroAmansilla) {
        this.fechaRegistroAmansilla = fechaRegistroAmansilla;
    }
}
