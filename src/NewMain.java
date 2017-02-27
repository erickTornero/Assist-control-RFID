

import controlador.controllerBD;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
public class NewMain {

    public static controllerBD contr;
    public static ResultSet rs;
    public static void main(String[] args)throws SQLException {
      
        try
        {
            contr = new controllerBD();
            contr.crearConexion();
            System.out.println("Se conecto");
        }
        catch(SQLException e)
        {
            Logger.getLogger("hey");
        }
        ResultSet rs = contr.mandarSQL("select codigo from Personas where nombre ='Erick'");
        int i=1;
        while(rs.next())
        {
            System.out.println(rs.getString(1));
        }
    }
    
}
