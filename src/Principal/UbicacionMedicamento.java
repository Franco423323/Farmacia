
package Principal;

import Conexion.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UbicacionMedicamento {
 private String idUbicacion;
    private Medicamento medicamento; 
    private String ubicacion;



    public UbicacionMedicamento(String idUbicacion, Medicamento medicamento, String ubicacion) {
        this.idUbicacion = idUbicacion;
        this.medicamento = medicamento;
        this.ubicacion = ubicacion;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }
    public void asignarMedicamentoAUbicacion() {

        if ( medicamentoExiste()) {

            String sql = "INSERT INTO UBICACIONMEDICAMENTO (IDUbicacion, IDMedicamento, Ubicacion) VALUES (?, ?, ?)";

            try (Connection connection = Connect.obtenerConexion();
                 PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, idUbicacion);
                statement.setInt(2, medicamento.getIdMedicamento());
                statement.setString(3, ubicacion);

                int filasInsertadas = statement.executeUpdate();

                if (filasInsertadas > 0) {
                    System.out.println("Medicamento asignado a la ubicación exitosamente.");
                } else {
                    System.out.println("No se pudo asignar el medicamento a la ubicación.");
                }
            } catch (SQLException e) {
                System.out.println("Error al asignar medicamento a la ubicación: " + e.getMessage());
            }
        } else {
            System.out.println("La ubicación o el medicamento no existen en la base de datos.");
        }
    }

    public boolean ubicacionExiste() {

        String sql = "SELECT 1 FROM UBICACIONMEDICAMENTO WHERE IDUbicacion = ?";

        try (Connection connection = Connect.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, idUbicacion);

            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            System.out.println("Error al verificar la existencia de la ubicación: " + e.getMessage());
            return false;
        }
    }

    public boolean medicamentoExiste() {
        String sql = "SELECT 1 FROM MEDICAMENTOS WHERE IDMedicamento = ?";

        try (Connection connection = Connect.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, medicamento.getIdMedicamento());

            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            System.out.println("Error al verificar la existencia del medicamento: " + e.getMessage());
            return false;
        }
    }
    
}
