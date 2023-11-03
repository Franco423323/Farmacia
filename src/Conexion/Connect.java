
package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Connect {
    public static void main(String[] args) {
        try {
            String connectionUrl = "jdbc:sqlserver://DESKTOP-C6MMD5J:1433;database=MedicamentosFarmacia;user=sa;password=2squ2ayer;encrypt=true;trustServerCertificate=true;";

  Connection conect = DriverManager.getConnection(connectionUrl);
 System.out.println("Conectado.");
} 
catch (SQLException ex) 
{
 System.out.println("Error." + ex.toString());
}
    }
}
