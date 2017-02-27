/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;
import coneccion.JavaConeccion;
import java.sql.*;
/**
 *
 * @author emprendedor01
 */

public class controllerBD {
    private final JavaConeccion con;
    public controllerBD()
    {
        this.con = new JavaConeccion();
    }
    public void crearConexion() throws SQLException
    {
        this.con.EstablecerConexion();
    }
    public ResultSet mandarSQL(String sql) throws SQLException
    {
        ResultSet auxRs = this.con.EjecutarSentencia(sql);
        return auxRs;
    }
    public boolean ejecutarStatement(String sql) throws SQLException
    {
        this.con.EjecutarStatement(sql);
        return true;
    }
    
}
