package Persistencia.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author cesar
 */
public class Conexion {

    private static final String URL
            = "jdbc:mysql://192.168.1.69:3306/SistemaResidencias"
            + "?useSSL=false"
            + "&serverTimezone=UTC"
            + "&allowPublicKeyRetrieval=true";

    private static final String USER = "resi_user";
    private static final String PASSWORD = "Resi12345";

    public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
