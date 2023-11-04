
package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Connect {
    public static Connection obtenerConexion() {
        try {
            String connectionUrl = "jdbc:sqlserver://DESKTOP-C6MMD5J:1433;database=MedicamentosFarmacia;user=sa;password=2squ2ayer;encrypt=true;trustServerCertificate=true;";
            return DriverManager.getConnection(connectionUrl);
        } catch (SQLException ex) {
            System.out.println("Error al obtener la conexión: " + ex.toString());
            return null;
        }
    }
}
