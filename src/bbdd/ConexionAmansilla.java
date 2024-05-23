/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bbdd;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import modelo.PacienteAmansilla;
import utilidades.EncriptadoAmansilla;

/**
 *
 * @author lolal
 */
public class ConexionAmansilla {

    static java.sql.Connection conn;

    public static final String URL = "jdbc:mysql://145.14.151.1/u812167471_consultorioDaw";
    public static final String USERNAME = "u812167471_consultorioDaw";
    public static final String PASSWORD = "2024-Daw";

    public static Connection conectarAmansilla() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (java.sql.Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConexionAmansilla.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void cerrarConexionAmansilla() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionAmansilla.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean accederAmansilla(String userAmansilla, String passAmansilla) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {

        try {
            String consulta = "SELECT usuario, contrasenya FROM personal WHERE usuario=? AND contrasenya=?";
            PreparedStatement pst = conn.prepareStatement(consulta);
            ResultSet rs;

            pst.setString(1, userAmansilla);
            pst.setString(2, EncriptadoAmansilla.encriptar(passAmansilla));

            rs = pst.executeQuery();

            return rs.next(); //true

        } catch (SQLException ex) {
            Logger.getLogger(ConexionAmansilla.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static String[] recuperarDatosUserLogadoAmansilla(String userAmansilla) {
        String[] usuarioAmansilla = new String[3];

        String SQLAmansilla = "SELECT CONCAT(nombre, ' ' ,apellidos), numero_colegiado, tipo FROM personal WHERE usuario ='" + userAmansilla + "'";
        try {
            Statement st = (Statement) conn.createStatement();
            try (ResultSet rs = st.executeQuery(SQLAmansilla)) {
                if (rs.next()) {
                    usuarioAmansilla[0] = rs.getString(1);
                    usuarioAmansilla[1] = rs.getString(2);
                    usuarioAmansilla[2] = rs.getString(3);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionAmansilla.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarioAmansilla;
    }

    public static void recuperarCitasMedicasAmansilla(DefaultTableModel modeloAmansilla) {
        try {
            String SSQL = "SELECT nombre as NOMBRE, dia as DIA, hora as HORA FROM citas";

            java.sql.Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SSQL);

            while (rs.next()) {
                Object[] registro = new Object[3]; // Ajusta el tamaño según el número de columnas
                try {
                    registro[0] = EncriptadoAmansilla.desencriptar(rs.getString("NOMBRE"));
                } catch (InvalidKeyException | NoSuchAlgorithmException | IllegalBlockSizeException | NoSuchPaddingException | BadPaddingException ex) {
                    Logger.getLogger(ConexionAmansilla.class.getName()).log(Level.SEVERE, null, ex);
                }
                registro[1] = rs.getDate("DIA");
                registro[2] = rs.getDouble("HORA");

                modeloAmansilla.addRow(registro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionAmansilla.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void recuperarCitasEnfermeriaAmansilla(DefaultTableModel modelo) {

    }

    /*public static boolean registrarCitaMedicaAmansilla(CitaAmansilla c){
    
    }
    
    public static boolean regitrarCitaEnfermeriaAmansilla(CitaAmansilla c){
    
    }
    
    public static boolean compruebaDniAmansilla(String dni){
    
    }*/
    public static PacienteAmansilla recueperarDatosPacienteAmansilla(String dni) {

        PacienteAmansilla paciente = null;

        try {
            // Encriptar el DNI
            String dniEncriptado = EncriptadoAmansilla.encriptar(dni);
            String sql = "SELECT nombre, apellidos, telefono, email FROM paciente WHERE dni = ?";

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, dniEncriptado); // Establecer el valor encriptado como parámetro
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        paciente = new PacienteAmansilla(" ", dni, 0, " ");
                        // Desencriptar los campos en la lectura
                        paciente.setNombreAmansilla(EncriptadoAmansilla.desencriptar(rs.getString("nombre")));
                        paciente.setApellidosAmansilla(EncriptadoAmansilla.desencriptar(rs.getString("apellidos")));
                        paciente.setTelefonoAmansilla(rs.getInt("telefono"));
                        paciente.setEmailAmansilla(rs.getString("email"));
                    }
                }
            }
        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paciente;
    }

    public static void cargaTablaConsultasMedicasAmansilla(DefaultTableModel modeloAmansilla, String dniAmansilla) {

        try {
            String SSQL = "SELECT fechaConsulta as FECHA, diagnostico as DIAGNOSTICO, tratamiento as TRATAMIENTO, observaciones as OBSERVACIONES FROM consultas WHERE dniPaciente='" + dniAmansilla + "'";

            java.sql.Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SSQL);

            while (rs.next()) {
                Object[] registro = new Object[4]; // Ajusta el tamaño según el número de columnas

                registro[0] = rs.getDate("FECHA");
                registro[1] = rs.getString("DIAGNOSTICO");
                registro[2] = rs.getString("TRATAMIENTO");
                registro[3] = rs.getString("OBSERVACIONES");

                modeloAmansilla.addRow(registro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionAmansilla.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void cargaTablaConsultasEnfermeriaAmansilla(DefaultTableModel modeloAmansilla, String dniAmansilla) {
        try {
            String SSQL = "SELECT fechaConsulta as FECHA, tensionMax as MÁXIMA, tensionMin as MÍNIMA, glucosa as GLUCOSA, peso as PESO FROM enfermeria WHERE dniPaciente='" + dniAmansilla + "'";

            java.sql.Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SSQL);

            while (rs.next()) {
                Object[] registro = new Object[5]; // Ajusta el tamaño según el número de columnas

                registro[0] = rs.getDate("FECHA");
                registro[1] = rs.getString("MÁXIMA");
                registro[2] = rs.getString("MÍNIMA");
                registro[3] = rs.getString("GLUCOSA");
                registro[4] = rs.getString("PESO");

                modeloAmansilla.addRow(registro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionAmansilla.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /*public static boolean registrarConsultaMedicaAmansilla(Consulta c) {
    
    }
    
    public static boolean registrarConsultaEnfermeriaAmansilla(ConsultaEnfermeria c) {
    
    }*/
    public static void cargasComboCpAmansilla(JComboBox comboAmansilla) {
        try {
            String consulta = "SELECT codigopostal from codigospostales";

            ResultSet rs = conn.createStatement().executeQuery(consulta);
            while (rs.next()) {
                comboAmansilla.addItem(rs.getString("codigopostal"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionAmansilla.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static boolean registrarPacienteAmansilla(PacienteAmansilla p) {

        try {
            String consulta = "INSERT INTO paciente (dni, nombre, apellidos, fechaNacimiento, telefono, email, cp, sexo, tabaquismo, consumoAlcohol, antecedentesSalud, datosSaludGeneral, fechaRegistro)"
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement pst = conn.prepareStatement(consulta);

            try {
                pst.setString(1, EncriptadoAmansilla.encriptar(p.getDniAmansilla()));

            } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException ex) {
                Logger.getLogger(ConexionAmansilla.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            try {
                pst.setString(2, EncriptadoAmansilla.encriptar(p.getNombreAmansilla()));

            } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException ex) {
                Logger.getLogger(ConexionAmansilla.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            try {
                pst.setString(3, EncriptadoAmansilla.encriptar(p.getApellidosAmansilla()));

            } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException ex) {
                Logger.getLogger(ConexionAmansilla.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            pst.setDate(4, new java.sql.Date(p.getFechaNacimientoAmansilla().getTime()));
            pst.setInt(5, p.getTelefonoAmansilla());
            pst.setString(6, p.getEmailAmansilla());
            pst.setInt(7, p.getCpAmansilla());
            pst.setString(8, p.getSexoAmansilla());
            pst.setString(9, p.getTabaquismoAmansilla());
            pst.setString(10, p.getConsumoalcoholAmansilla());
            pst.setString(11, p.getAntecedentesSaludAmansilla());
            pst.setString(12, p.getDatosSaludGeneralAmansilla());
            pst.setDate(13, new java.sql.Date(p.getFechaRegistroAmansilla().getTime()));

            pst.execute();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ConexionAmansilla.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static void cargaTablaPacientesAmansilla(DefaultTableModel modelo) {

    }

    /*public static boolean compruebaUserAmansilla(String user) {
    
    }
    
    public static boolean compruebaNumeroColegiadoAmansilla(long numero) {
    
    }
    
    public static boolean registrarPersonalAmansilla(Personal p) {
    
    }*/
}
