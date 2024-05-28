/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author lolal
 */
public class PersonalAmansilla {
    private int numero_colegiadoAmansilla;
    private String nombreAmansilla,apellidosAmansilla;
    private int telefonoAmansilla;
    private String usuarioAmansilla,contrasenyaAmansilla,tipoAmansilla;

    public PersonalAmansilla(int numero_colegiadoAmansilla, String nombreAmansilla, String apellidosAmansilla, int telefonoAmansilla, String usuarioAmansilla, String contrasenyaAmansilla, String tipoAmansilla) {
        this.numero_colegiadoAmansilla = numero_colegiadoAmansilla;
        this.nombreAmansilla = nombreAmansilla;
        this.apellidosAmansilla = apellidosAmansilla;
        this.telefonoAmansilla = telefonoAmansilla;
        this.usuarioAmansilla = usuarioAmansilla;
        this.contrasenyaAmansilla = contrasenyaAmansilla;
        this.tipoAmansilla = tipoAmansilla;
    }

    public int getNumero_colegiadoAmansilla() {
        return numero_colegiadoAmansilla;
    }

    public void setNumero_colegiadoAmansilla(int numero_colegiadoAmansilla) {
        this.numero_colegiadoAmansilla = numero_colegiadoAmansilla;
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

    public int getTelefonoAmansilla() {
        return telefonoAmansilla;
    }

    public void setTelefonoAmansilla(int telefonoAmansilla) {
        this.telefonoAmansilla = telefonoAmansilla;
    }

    public String getUsuarioAmansilla() {
        return usuarioAmansilla;
    }

    public void setUsuarioAmansilla(String usuarioAmansilla) {
        this.usuarioAmansilla = usuarioAmansilla;
    }

    public String getContrasenyaAmansilla() {
        return contrasenyaAmansilla;
    }

    public void setContrasenyaAmansilla(String contrasenyaAmansilla) {
        this.contrasenyaAmansilla = contrasenyaAmansilla;
    }

    public String getTipoAmansilla() {
        return tipoAmansilla;
    }

    public void setTipoAmansilla(String tipoAmansilla) {
        this.tipoAmansilla = tipoAmansilla;
    }

    
}
