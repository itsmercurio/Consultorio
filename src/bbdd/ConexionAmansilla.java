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
import modelo.CitaAmansilla;
import modelo.ConsultaAmansilla;
import modelo.ConsultaEnfermeriaAmansilla;
import modelo.PacienteAmansilla;
import modelo.PersonalAmansilla;
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

    public static void recuperarCitasEnfermeriaAmansilla(DefaultTableModel modeloAmansilla) throws InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, NoSuchPaddingException, BadPaddingException {
        try {
            String SSQL = "SELECT nombre as NOMBRE, dia as DIA, Hora as hora FROM citas WHERE dia = CURDATE()";

            Statement st = (Statement) conn.createStatement();
            ResultSet rs = st.executeQuery(SSQL);

            while (rs.next()) {
                Object[] registro = new Object[3];

                registro[0] = EncriptadoAmansilla.desencriptar(rs.getString("NOMBRE"));
                registro[1] = rs.getString("DIA");
                registro[2] = rs.getString("HORA");

                modeloAmansilla.addRow(registro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionAmansilla.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static boolean registrarCitaMedicaAmansilla(CitaAmansilla c) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        try {
            String consulta = "INSERT INTO citas (dniPaciente, nombre, dia, hora)"
                    + "VALUES (?,?,?,?)";

            PreparedStatement pst = conn.prepareStatement(consulta);

            pst.setString(2, EncriptadoAmansilla.encriptar(c.getNombreAmansilla()));
            pst.setDate(3, new java.sql.Date(c.getDiaAmansilla().getTime()));
            pst.setString(1, EncriptadoAmansilla.encriptar(c.getDniPacienteAmansilla()));
            pst.setDouble(4, c.getHoraAmansilla());

            pst.execute();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ConexionAmansilla.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean regitrarCitaEnfermeriaAmansilla(CitaAmansilla c) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        try {
            String consulta = "INSERT INTO citasEnfermeria(dniPaciente, nombre , dia, hora) VALUES (?, ?, ?, ?)";

            PreparedStatement pst = conn.prepareStatement(consulta);

            pst.setString(1, EncriptadoAmansilla.encriptar(c.getDniPacienteAmansilla()));
            pst.setString(2, EncriptadoAmansilla.encriptar(c.getNombreAmansilla()));
            pst.setDate(3, new java.sql.Date(c.getDiaAmansilla().getTime()));
            pst.setDouble(4, c.getHoraAmansilla());

            pst.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ConexionAmansilla.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean compruebaDniAmansilla(String dniAmansilla) {
        try {
            String consulta = "SELECT dni FROM paciente WHERE dni=?";
            PreparedStatement pst = conn.prepareStatement(consulta);
            ResultSet rs;

            pst.setString(1, dniAmansilla);

            rs = pst.executeQuery();

            return rs.next(); //true
        } catch (SQLException ex) {
            Logger.getLogger(ConexionAmansilla.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

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
        } catch (Exception e) {
        }
        return paciente;
    }

    public static void cargaTablaConsultasMedicasAmansilla(DefaultTableModel modeloAmansilla, String dniAmansilla) {

        try {
            String SSQL = "SELECT fechaConsulta as FECHA, tensionMax as MAXIMA, tensionMin as MINIMA, glucosa as GLUCOSA, peso as PESO  FROM enfermeria WHERE dniPaciente = '" + dniAmansilla + "'";

            java.sql.Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SSQL);

            while (rs.next()) {
                Object[] consultaAmansilla = new Object[5];

                consultaAmansilla[0] = rs.getString("FECHA");
                consultaAmansilla[1] = rs.getString("MAXIMA");
                consultaAmansilla[2] = rs.getString("MINIMA");
                consultaAmansilla[3] = rs.getString("GLUCOSA");
                consultaAmansilla[4] = rs.getString("PESO");

                modeloAmansilla.addRow(consultaAmansilla);
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

    public static boolean registrarConsultaMedicaAmansilla(ConsultaAmansilla c) {
        try {
            String consulta = "INSERT INTO consultas(dniPaciente, fechaConsulta , diagnostico, tratamiento, observaciones, codigofacultativo) VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement pst = conn.prepareStatement(consulta);

            pst.setString(1, c.getDniPacienteAmansilla());
            pst.setDate(2, new java.sql.Date(c.getFechaConsultaAmansilla().getTime()));
            pst.setString(3, c.getDiagnosticoAmansilla());
            pst.setString(4, c.getTratamientoAmansilla());
            pst.setString(5, c.getObservacionesAmansilla());
            pst.setInt(6, c.getCodigofacultativoAmansilla());

            pst.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ConexionAmansilla.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean registrarConsultaEnfermeriaAmansilla(ConsultaEnfermeriaAmansilla c) {
        try {
            String consulta = "INSERT INTO enfermeria(dniPaciente, fechaConsulta , tensionMax, tensionMin, glucosa, peso, codigoFacultativo) VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pst = conn.prepareStatement(consulta);

            pst.setString(1, c.getDniPacienteAmansilla());
            pst.setDate(2, new java.sql.Date(c.getFechaConsultaAmansilla().getTime()));
            pst.setDouble(3, c.getMaximaAmansilla());
            pst.setDouble(4, c.getMinimaAmansilla());
            pst.setInt(5, c.getGlucosaAmansilla());
            pst.setDouble(6, c.getPesoAmansilla());
            pst.setInt(7, c.getCodigofacultativoAmansilla());

            pst.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ConexionAmansilla.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

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

    public static void cargaTablaPacientesAmansilla(DefaultTableModel modeloAmansilla) throws InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, NoSuchPaddingException, BadPaddingException {
        try {
            String SSQL = "SELECT dni as DNI, nombre as NOMBRE, apellidos as APELLIDOS, telefono as TELEFONO, cp as CP FROM paciente";

            java.sql.Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SSQL);

            while (rs.next()) {
                Object[] registro = new Object[5]; // Ajusta el tamaño según el número de columnas

                registro[0] = EncriptadoAmansilla.desencriptar(rs.getString("DNI"));
                registro[1] = EncriptadoAmansilla.desencriptar(rs.getString("NOMBRE"));
                registro[2] = EncriptadoAmansilla.desencriptar(rs.getString("APELLIDOS"));
                registro[3] = rs.getString("TELEFONO");
                registro[4] = rs.getInt("CP");

                modeloAmansilla.addRow(registro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionAmansilla.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean compruebaUserAmansilla(String userAmansilla) {
        try {
            String consulta = "SELECT user FROM paciente WHERE dni=?";
            PreparedStatement pst = conn.prepareStatement(consulta);
            ResultSet rs;

            pst.setString(1, userAmansilla);

            rs = pst.executeQuery();

            return rs.next(); //true
        } catch (SQLException ex) {
            Logger.getLogger(ConexionAmansilla.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean compruebaNumeroColegiadoAmansilla(int numeroAmansilla) {
        try {
            String consulta = "SELECT numero_colegiado FROM personal WHERE numero_colegiado=?";
            PreparedStatement pst = conn.prepareStatement(consulta);
            ResultSet rs;

            pst.setInt(1, numeroAmansilla);

            rs = pst.executeQuery();

            return rs.next(); //true
        } catch (SQLException ex) {
            Logger.getLogger(ConexionAmansilla.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean registrarPersonalAmansilla(PersonalAmansilla p) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        try {
            String consulta = "INSERT INTO personal (numero_colegiado, nombre, apellidos, telefono, usuario, contrasenya, tipo)"
                    + "VALUES (?,?,?,?,?,?,?)";

            PreparedStatement pst = conn.prepareStatement(consulta);

            pst.setString(2, p.getNombreAmansilla());
            pst.setString(3, p.getApellidosAmansilla());
            pst.setInt(1, p.getNumero_colegiadoAmansilla());
            pst.setInt(4, p.getTelefonoAmansilla());
            pst.setString(5, p.getUsuarioAmansilla());
            pst.setString(6, EncriptadoAmansilla.encriptar(p.getContrasenyaAmansilla()));
            pst.setString(7, p.getTipoAmansilla());

            pst.execute();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ConexionAmansilla.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static boolean actualizarPacienteAmansilla(PacienteAmansilla p, String dni)
            throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        try {
            String consulta = "UPDATE paciente SET nombre = ?, apellidos = ?, telefono = ?, cp = ? WHERE dni = ?";

            PreparedStatement pst = conn.prepareStatement(consulta);

            pst.setString(1, EncriptadoAmansilla.encriptar(p.getNombreAmansilla()));
            pst.setString(2, EncriptadoAmansilla.encriptar(p.getApellidosAmansilla()));
            pst.setInt(3, p.getTelefonoAmansilla());
            pst.setInt(4, p.getCpAmansilla());
            pst.setString(5, EncriptadoAmansilla.encriptar(dni));

            int filasAfectadas = pst.executeUpdate();

            return filasAfectadas > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionAmansilla.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
