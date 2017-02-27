/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package coneccion;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author emprendedor01
 */
public class JavaConeccion {
    private Connection con = null;
    private Statement sentencia;
    
   
    private final String controlador;
    private final String nombreBD;
    private final String usuarioBD;
    private final String passwordBD;       
    
    //Metodo constructor
    public JavaConeccion()
    {
       this.controlador = "sun.jdbc.odbc.JdbcOdbcDriver";
       this.nombreBD = "C:\\Users\\emprendedor01\\Documents\\NetBeansProjects\\IntentDatabase\\baseDatosAcc\\dataBasePersonal.accdb";
       this.usuarioBD = "";
       this.passwordBD = "";
               
    }
    
    public boolean EstablecerConexion() throws SQLException
    {
        try
        {
            con = DriverManager.getConnection("jdbc:ucanaccess://"+this.nombreBD,this.usuarioBD,this.passwordBD);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,"error al conectarse: "+e);
            return false;
        }
        try
        {
         this.sentencia = this.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error al crear objeto sentencia: "+e);
            return false;
        }
        return true;
    }
    
    public ResultSet EjecutarSentencia(String sqlSentence) throws SQLException
    {
       try
        {
            ResultSet rs;
            rs = this.sentencia.executeQuery(sqlSentence);
            return rs;
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,"Error al ejecutar sentencia: "+e);
            return null;
        }
    }
    
    public boolean EjecutarStatement(String sql) throws SQLException
    {
        Statement stm = con.createStatement();
        stm.executeUpdate(sql);
        return true;
    }
    
    public Connection JavaConeccion()
    {
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:BASEPERSONAL");
        }
        catch(ClassNotFoundException|SQLException e)
        {
          JOptionPane.showMessageDialog(null, "No se ha podido conecta a la BD");
        }
        return con;
    }
}
