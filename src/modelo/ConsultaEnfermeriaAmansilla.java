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
public class ConsultaEnfermeriaAmansilla {
    
    String dniPacienteAmansilla;
    Date fechaConsultaAmansilla;
    double maximaAmansilla,minimaAmansilla;   
    int glucosaAmansilla;
    double pesoAmansilla;
    int codigofacultativoAmansilla;

    public ConsultaEnfermeriaAmansilla(String dniPacienteAmansilla, Date fechaConsultaAmansilla, double maximaAmansilla, double minimaAmansilla, int glucosaAmansilla, double pesoAmansilla, int codigofacultativoAmansilla) {
        this.dniPacienteAmansilla = dniPacienteAmansilla;
        this.fechaConsultaAmansilla = fechaConsultaAmansilla;
        this.maximaAmansilla = maximaAmansilla;
        this.minimaAmansilla = minimaAmansilla;
        this.glucosaAmansilla = glucosaAmansilla;
        this.pesoAmansilla = pesoAmansilla;
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

    public double getMaximaAmansilla() {
        return maximaAmansilla;
    }

    public void setMaximaAmansilla(double maximaAmansilla) {
        this.maximaAmansilla = maximaAmansilla;
    }

    public double getMinimaAmansilla() {
        return minimaAmansilla;
    }

    public void setMinimaAmansilla(double minimaAmansilla) {
        this.minimaAmansilla = minimaAmansilla;
    }

    public int getGlucosaAmansilla() {
        return glucosaAmansilla;
    }

    public void setGlucosaAmansilla(int glucosaAmansilla) {
        this.glucosaAmansilla = glucosaAmansilla;
    }

    public double getPesoAmansilla() {
        return pesoAmansilla;
    }

    public void setPesoAmansilla(double pesoAmansilla) {
        this.pesoAmansilla = pesoAmansilla;
    }

    public int getCodigofacultativoAmansilla() {
        return codigofacultativoAmansilla;
    }

    public void setCodigofacultativoAmansilla(int codigofacultativoAmansilla) {
        this.codigofacultativoAmansilla = codigofacultativoAmansilla;
    }


    
}
