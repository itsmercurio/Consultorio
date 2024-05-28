/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author lolal
 */
public class UtilidadesAmansilla {

    static String patronTlfFijo = "^[98]{1}[0-8]{1}[0-9]{7}$";
    static String patronTlfMovil = "^[5-6-7]{1}[0-9]{8}$";
    static String patronCP = "^[0-5]{1}[0-9]{4}$";

    public static boolean compruebaVacioAmansilla(JTextField campo) {

        return campo.getText().trim().isEmpty();

    }

    public static boolean formatoDniCorrectoAmansilla(JTextField campo) {

        String modeloDni = "^[0-9]{8}[A-HJ-NP-Z]{1}$";

        return campo.getText().toUpperCase().matches(modeloDni);
    }

    public static void lanzaAlertaVacioAmansilla(JTextField campo) {

        JOptionPane.showMessageDialog(null, "El campo " + campo.getName() + " es obligatorio");

    }

    public static boolean enteroCorrectoAmansilla(JTextField campo) {
        try {
            String texto = campo.getText();

            int numero = Integer.parseInt(texto);

            if (numero > 0) {
                return true;
            }
        } catch (NumberFormatException e) {
        }

        return false;
    }

    public static void lanzaAlertaEnteroAmansilla(JTextField campo) {
        JOptionPane.showMessageDialog(null, "El campo " + campo.getName() + " debe ser un número entero y mayor a 0.");

    }

    public static boolean doubleCorrectoAmansilla(JTextField campo) {
        try {
            String texto = campo.getText();

            double numero = Double.parseDouble(texto);

            if (numero > 0) {
                return true;
            }
        } catch (NumberFormatException e) {
        }
        return false;
    }

    public static void lanzaAlertaDoubleAmansilla(JTextField campo) {
        JOptionPane.showMessageDialog(null, "El campo " + campo.getName() + " debe ser un número.");
    }

    /**
     * metodo para sacar un joption pane
     *
     * @param padre
     * @param campo
     */
    public static void LanzaAlertaEnteroAmansilla(Component padre, JTextField campo) {
        JOptionPane.showMessageDialog(padre, "El campo " + campo.getName() + " es numérico");
    }

    /**
     * metodo para comprobar si un numero esta entre el 18 y 65 (devolvera true
     * o false)
     *
     * @param campo
     * @return
     */
    public static boolean rangoEdadAmansilla(JTextField campo) {
        int edad = Integer.parseInt(campo.getText());

        return edad > 18 && edad < 65;
    }

    /**
     * metodo para comprobar si un numero esta entre 200 y 300 (devolvera true o
     * false)
     *
     * @param campo
     * @return
     */
    public static boolean rangoHorasAmansilla(JTextField campo) {
        int horas = Integer.parseInt(campo.getText());

        return horas > 200 && horas < 300;
    }

    /**
     * metodo para comprobar si han cambiado una combo box (devolvera true o
     * false)
     *
     * @param combo
     * @return
     */
    public static boolean comboNoSeleccionadoAmansilla(JComboBox combo) {
        return combo.getSelectedIndex() == 0;
    }

    /**
     * metodo para lanzar un joption pane
     *
     * @param padre
     * @param combo
     */
    public static void alertaComboNoSeleccionadoAmansilla(Component padre, JComboBox combo) {
        JOptionPane.showMessageDialog(padre, "Debe seleccionar un elemento del campo " + combo.getName());
    }

    /**
     * metodo para comprobar si un campo esta vacio (devolvera true o false)
     *
     * @param campo
     * @return
     */
    public static boolean letraDniCorrectaAmansilla(JTextField campo) {

        int dni = Integer.parseInt(campo.getText().substring(0, 8));

        int resto = dni % 23;

        char letra = campo.getText().toUpperCase().charAt(8);

        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";

        return letra == letras.charAt(resto);
    }

    public static void lanzaAlertaLetraDniAmansilla(Component c, JTextField campo) {

        JOptionPane.showMessageDialog(c, "La letra no corresponde al DNI.");
    }

    public static boolean formatoTlfAmansilla(JTextField campo) {
        return !campo.getText().matches(patronTlfFijo) && !campo.getText().matches(patronTlfMovil);
    }

    public static void lanzaAlertaFormatoTlfAmansilla(Component c, JTextField campo) {
        JOptionPane.showMessageDialog(c, "El telefono no se corresponde con el formato establecido");
    }

    public static void lanzaAlertaFormatoDniAmansilla(Component c, JTextField campo) {

        JOptionPane.showMessageDialog(c, "El formato del DNI no es correcto.");
    }

    public static boolean rangoTlfAmansilla(int tlf) {
        return tlf < 988999999;
    }

    public static void lanzaAlertaRangoTlfAmansilla(Component c, JTextField campo) {
        JOptionPane.showMessageDialog(c, "El telefono es superior al rango establecido");
    }

    public static boolean formatoEmailCorrectoAmansilla(JTextField campo) {
        String modeloEmail = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.com";
        return campo.getText().matches(modeloEmail);
    }

    public static void lanzaAlertaEmailAmansilla(Component c, JTextField campo) {
        JOptionPane.showMessageDialog(c, "El correo no esta escrito de manera correcta");
    }

    public static void lanzaAlertaDNInoEncontradoAmansilla(Component c, JTextField campo) {
        JOptionPane.showMessageDialog(c, "El DNI no fue encontrado");
    }

    public static boolean formatoCPAmansilla(JTextField campo) {
        return !campo.getText().matches(patronCP);
    }

    public static void lanzaAlertaCPAmansilla(Component c, JTextField campo) {
        JOptionPane.showMessageDialog(c, "El CP no esta escrito de manera correcta");
    }

    public static boolean campovacioAmansilla(JTextField campo) {

        return "".equals(campo.getText());
    }

    public static void lanzaAlertaCampoVacioAmansilla(Component ventanaPadre, JTextField campo) {
        JOptionPane.showMessageDialog(ventanaPadre, "El campo " + campo.getName() + " es obligatorio.");
    }

    public static void desactivaCamposAmansilla(JPanel panel) {
        for (Component c : panel.getComponents()) {
            if (c.isEnabled() == true) {
                c.setEnabled(false);
            }
        }
    }

    public static void activaCamposAmansilla(JPanel panel) {
        for (Component c : panel.getComponents()) {
            if (c.isEnabled() == false) {
                c.setEnabled(true);
            }
        }
    }
    
    public static boolean CompruebaTextAreaVacioAmansilla(JTextArea campoAmansilla) {
        // Comprueba si el área de texto está vacía
        return campoAmansilla.getText().trim().isEmpty();
    }

    public static void LanzaAlertaTextAreaVacioAmansilla(JTextArea campoAmansilla) {
        // Muestra una alerta si el área de texto está vacía
        JOptionPane.showMessageDialog(null, "El campo " + campoAmansilla.getName() + " es obligatorio, compruebelo y vuelvalo a intentar.");
    }
}
