/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bbdd;

import com.mysql.jdbc.Connection;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lolal
 */
public class ConexionAmansilla {
    
    public static Connection conectar() {
    
    
        return null;
    
    
    }
    
    public static void cerrarConexion(){
    
    }
    
    public static boolean acceder(String user, String pass){
    
    }
    
    public static String[] recuperarDatosUserLogado(String user){
    
    }
    
    public static void recuperarCitasMedicas(DefaultTableModel modelo){
    
    }
    
    public static void recuperarCitasEnfermeria(DefaultTableModel modelo){
    
    }
    
    public static boolean registrarCitaMedica(Cita c){
    
    }
    
    public static boolean regitrarCitaEnfermeria(Cita c){
    
    }
    
    public static boolean compruebaDni(String dni){
    
    }
    
    public static Paciente recueperarDatosPaciente(String dni){
    
    }
    
    public static void cargaTablaConsultasMedicas(DefaultTableModel modelo, String dni){
    
    }
    
    public static void cargaTablaConsultasEnfermeria(DefaultTableModel modelo, String dni){
    
    }
    
    public static boolean registrarConsultaMedica(Consulta c){
    
    }
    
    public static boolean registrarConsultaEnfermeria(ConsultaEnfermeria c){
    
    }
    
    public static void cargasComboCp(JComboBox combo){
    
    }
    
    public static boolean registrarPaciente(Paciente p) {
    
    }
    
    public static void cargaTablaPacientes(DefaultTableModel modelo){
    
    }
    
    public static boolean compruebaUser(String user){
    
    }
    
    public static boolean compruebaNumeroColegiado(long numero){
    
    }
    
    public static boolean registrarPersonal(Personal p){
    
    }
}
