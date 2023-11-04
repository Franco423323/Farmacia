
package Principal;
import Conexion.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;


public class InventarioMedicamento {
    private ArrayList<Medicamento> medicamentos;

    public InventarioMedicamento() {
        medicamentos = new ArrayList<>();
    }

    public void insertarMedicamento(Medicamento medicamento) {
        String sql = "INSERT INTO MEDICAMENTOS (IDMedicamento, NombreComercial, NombreGenerico, Indicaciones, Tipo, Lote, FechaCaducidad) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = Connect.obtenerConexion(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, medicamento.getIdMedicamento()); // Proporciona un valor para IDMedicamento
            statement.setString(2, medicamento.getNombreComercial());
            statement.setString(3, medicamento.getNombreGenerico());
            statement.setString(4, medicamento.getIndicaciones());
            statement.setString(5, medicamento.getTipo());
            statement.setString(6, medicamento.getLote());
            statement.setDate(7, new java.sql.Date(medicamento.getFechaCaducidad().getTime()));

            int filasInsertadas = statement.executeUpdate();

            if (filasInsertadas > 0) {
                System.out.println("Medicamento insertado exitosamente en la base de datos.");
            } else {
                System.out.println("No se pudo insertar el medicamento.");
            }
        } catch (SQLException e) {
            System.out.println("Error al insertar el medicamento: " + e.getMessage());
        }
    
    
    }

     public void eliminarMedicamento(int idMedicamento) {
        String sql = "DELETE FROM MEDICAMENTOS WHERE IDMedicamento = ?";

        try (Connection connection = Connect.obtenerConexion(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idMedicamento);

            int filasEliminadas = statement.executeUpdate();

            if (filasEliminadas > 0) {
                System.out.println("Medicamento con ID " + idMedicamento + " eliminado exitosamente.");
            } else {
                System.out.println("No se encontró un medicamento con ID " + idMedicamento + " para eliminar.");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el medicamento: " + e.getMessage());
        }
    
    }

    public ArrayList<Medicamento> obtenerMedicamentos() {
        return medicamentos;
    }
    
//    public int obtenerCantidadEnStock(Medicamento medicamento) {
//
//    }
}
