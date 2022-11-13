package crud.daoapp.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {

    // modificar la ruta de conexion hacia su base de datos.
    public static final String STRCONEXIONDB = "jdbc:sqlserver://;serverName=192.168.190.129;databaseName=Dao;user=sa;password=Test01.*qw;TrustServerCertificate=True;";

    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(STRCONEXIONDB);

    }
}
