/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionMYSQLSERVER;

import java.sql.*;
import java.util.logging.*;
import javax.swing.*;

/**
 *
 * @author ADMPRO0209
 */
public class ConexionDB {
    
    public Connection conexion = null;
    public Statement st = null;
    public ResultSet rs = null;
    public PreparedStatement psPrepararSentencia = null;
    
    public Statement ConectarBD(){
        
        String ruta = "jdbc:mysql://";
        //String servidor = "localhost:3306/";
        String servidor = "192.168.1.242:3306/";
        String base = "salitreiqq";
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(ruta+servidor+base,"root","root");
            if (conexion != null){
                st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            }
        }
        catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "No se encuentra la clase para conectar con SQL","",JOptionPane.CLOSED_OPTION);
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos","",JOptionPane.CLOSED_OPTION);
        }
        finally{
            return st;
        }
    }
    
    public void cerrarBD() {
        try {
            if (!conexion.isClosed()) {
                conexion.close();
            } else {
                //System.out.println("** ERROR ** - La conexion ya se encuentra cerrada");                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionSQLSERVER.ConexionDB_SQLSERVER.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
