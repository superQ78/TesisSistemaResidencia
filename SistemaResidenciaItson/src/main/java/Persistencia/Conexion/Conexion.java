package Persistencia.Conexion;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author cesar
 */
public class Conexion {

    private static final String ARCHIVO_CONFIG = "config.properties";

    public static Connection getConexion() throws SQLException {
        Properties props = cargarConfiguracion();

        String host = props.getProperty("db.host", "localhost");
        String port = props.getProperty("db.port", "3306");
        String name = props.getProperty("db.name", "SistemaResidencias");
        String user = props.getProperty("db.user", "root");
        String password = props.getProperty("db.password", "");

        String url = "jdbc:mysql://" + host + ":" + port + "/" + name
                + "?useSSL=false"
                + "&serverTimezone=UTC"
                + "&allowPublicKeyRetrieval=true";

        return DriverManager.getConnection(url, user, password);
    }

    private static Properties cargarConfiguracion() {
        Properties props = new Properties();

        try (FileInputStream fis = new FileInputStream(ARCHIVO_CONFIG)) {
            props.load(fis);
        } catch (IOException e) {
            System.err.println("No se encontró config.properties. Usando configuración por defecto.");
        }

        return props;
    }
}
