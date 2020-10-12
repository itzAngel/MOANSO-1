package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDatosUtil {
    public static Connection creaConexion(){
        try{
            String url = "jdbc:mysql://localhost:3306/sistema_de_almacenamiento_bron?useLegacyDatetimeCode=false&serverTimezone=America/Lima";
            String user = "root";
            String password = "admin";
            Connection conn = DriverManager.getConnection(url, user, password);
            return conn;
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
