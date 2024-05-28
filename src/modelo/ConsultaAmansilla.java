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
public class ConsultaAmansilla {
    
    private String dniPacienteAmansilla;
    private Date fechaConsultaAmansilla;
    private String diagnosticoAmansilla,tratamientoAmansilla,observacionesAmansilla;
    private int codigofacultativoAmansilla;

    public ConsultaAmansilla(String dniPacienteAmansilla, Date fechaConsultaAmansilla, String diagnosticoAmansilla, String tratamientoAmansilla, String observacionesAmansilla, int codigofacultativoAmansilla) {
        this.dniPacienteAmansilla = dniPacienteAmansilla;
        this.fechaConsultaAmansilla = fechaConsultaAmansilla;
        this.diagnosticoAmansilla = diagnosticoAmansilla;
        this.tratamientoAmansilla = tratamientoAmansilla;
        this.observacionesAmansilla = observacionesAmansilla;
        this.codigofacultativoAmansilla = codigofacultativoAmansilla;
    }

    public String getDniPacienteAmansilla() {
        return dniPacienteAmansilla;
    }

    public void setDniPacienteAmansilla(String dniPacienteAmansilla) {
        this.dniPacienteAmansilla = dniPacienteAmansilla;
    }

    public Date getFechaConsultaAmansilla() {
        return fechaConsultaAmansilla;
    }

    public void setFechaConsultaAmansilla(Date fechaConsultaAmansilla) {
        this.fechaConsultaAmansilla = fechaConsultaAmansilla;
    }

    public String getDiagnosticoAmansilla() {
        return diagnosticoAmansilla;
    }

    public void setDiagnosticoAmansilla(String diagnosticoAmansilla) {
        this.diagnosticoAmansilla = diagnosticoAmansilla;
    }

    public String getTratamientoAmansilla() {
        return tratamientoAmansilla;
    }

    public void setTratamientoAmansilla(String tratamientoAmansilla) {
        this.tratamientoAmansilla = tratamientoAmansilla;
    }

    public String getObservacionesAmansilla() {
        return observacionesAmansilla;
    }

    public void setObservacionesAmansilla(String observacionesAmansilla) {
        this.observacionesAmansilla = observacionesAmansilla;
    }

    public int getCodigofacultativoAmansilla() {
        return codigofacultativoAmansilla;
    }

    public void setCodigofacultativoAmansilla(int codigofacultativoAmansilla) {
        this.codigofacultativoAmansilla = codigofacultativoAmansilla;
    }

    
}
