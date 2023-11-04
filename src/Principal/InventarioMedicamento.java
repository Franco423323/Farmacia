
package Principal;
import Conexion.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;


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
        public void editarMedicamento(int idMedicamento, Medicamento nuevoMedicamento) {
        String sql = "UPDATE MEDICAMENTOS SET NombreComercial = ?, NombreGenerico = ?, Indicaciones = ?, Tipo = ?, Lote = ?, FechaCaducidad = ? WHERE IDMedicamento = ?";

        try (Connection connection = Connect.obtenerConexion(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nuevoMedicamento.getNombreComercial());
            statement.setString(2, nuevoMedicamento.getNombreGenerico());
            statement.setString(3, nuevoMedicamento.getIndicaciones());
            statement.setString(4, nuevoMedicamento.getTipo());
            statement.setString(5, nuevoMedicamento.getLote());
            statement.setDate(6, new java.sql.Date(nuevoMedicamento.getFechaCaducidad().getTime()));
            statement.setInt(7, idMedicamento);

            int filasActualizadas = statement.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Medicamento con ID " + idMedicamento + " actualizado exitosamente.");
            } else {
                System.out.println("No se encontró un medicamento con ID " + idMedicamento + " para actualizar.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar el medicamento: " + e.getMessage());
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
    public ArrayList<Medicamento> obtenerTodosLosMedicamentos() {
        ArrayList<Medicamento> medicamentos = new ArrayList<>();
        String sql = "SELECT * FROM MEDICAMENTOS";

        try (Connection connection = Connect.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int idMedicamento = resultSet.getInt("IDMedicamento");
                String nombreComercial = resultSet.getString("NombreComercial");
                String nombreGenerico = resultSet.getString("NombreGenerico");
                String indicaciones = resultSet.getString("Indicaciones");
                String tipo = resultSet.getString("Tipo");
                String lote = resultSet.getString("Lote");
                Date fechaCaducidad = resultSet.getDate("FechaCaducidad");

                Medicamento medicamento = new Medicamento(idMedicamento, nombreComercial, nombreGenerico, indicaciones, tipo, lote, fechaCaducidad);
                medicamentos.add(medicamento);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener todos los medicamentos: " + e.getMessage());
        }
        return medicamentos;
    }
    public ArrayList<Medicamento> buscarMedicamentoPorNombre(String nombre) {
        ArrayList<Medicamento> medicamentos = new ArrayList<>();
        String sql = "SELECT * FROM MEDICAMENTOS WHERE NombreComercial LIKE ? OR NombreGenerico LIKE ?";

        try (Connection connection = Connect.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "%" + nombre + "%"); // Busca coincidencias en el nombre comercial
            statement.setString(2, "%" + nombre + "%"); // Busca coincidencias en el nombre genérico

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int idMedicamento = resultSet.getInt("IDMedicamento");
                    String nombreComercial = resultSet.getString("NombreComercial");
                    String nombreGenerico = resultSet.getString("NombreGenerico");
                    String indicaciones = resultSet.getString("Indicaciones");
                    String tipo = resultSet.getString("Tipo");
                    String lote = resultSet.getString("Lote");
                    Date fechaCaducidad = resultSet.getDate("FechaCaducidad");

                    Medicamento medicamento = new Medicamento(idMedicamento, nombreComercial, nombreGenerico, indicaciones, tipo, lote, fechaCaducidad);
                    medicamentos.add(medicamento);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar medicamentos por nombre: " + e.getMessage());
        }
        return medicamentos;
    }
     public ArrayList<Medicamento> buscarMedicamentoPorFechaCaducidad(Date fechaCaducidad) {
        ArrayList<Medicamento> medicamentos = new ArrayList<>();
        String sql = "SELECT * FROM MEDICAMENTOS WHERE FechaCaducidad >= ?";

        try (Connection connection = Connect.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDate(1, new java.sql.Date(fechaCaducidad.getTime())); // Convierte la fecha a formato SQL

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int idMedicamento = resultSet.getInt("IDMedicamento");
                    String nombreComercial = resultSet.getString("NombreComercial");
                    String nombreGenerico = resultSet.getString("NombreGenerico");
                    String indicaciones = resultSet.getString("Indicaciones");
                    String tipo = resultSet.getString("Tipo");
                    String lote = resultSet.getString("Lote");
                    Date fecha = resultSet.getDate("FechaCaducidad");

                    Medicamento medicamento = new Medicamento(idMedicamento, nombreComercial, nombreGenerico, indicaciones, tipo, lote, fecha);
                    medicamentos.add(medicamento);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar medicamentos por fecha de caducidad: " + e.getMessage());
        }
        return medicamentos;
    }
     
}
