
package Persistencia.DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author cesar
 */
public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/SistemaResidencias";
    private static final String USER = "root"; 
    private static final String PASSWORD = "password"; 

    public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}