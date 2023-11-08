package Principal;

import Conexion.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class MedicamentosVencidos {
    private int idRegistro;
    private Medicamento medicamento; // Asociación con la clase Medicamento
    private String nombreMedicamento;
    private Date fechaVencimiento;

    public MedicamentosVencidos(int idRegistro, Medicamento medicamento, String nombreMedicamento, Date fechaVencimiento) {
        this.idRegistro = idRegistro;
        this.medicamento = medicamento;
        this.nombreMedicamento = nombreMedicamento;
        this.fechaVencimiento = fechaVencimiento;
    }

    // Getters y setters

    public void guardarMedicamentoVencido() {
        if (medicamentoExiste()) {
            String sql = "INSERT INTO MEDICAMENTOS_VENCIDOS (IDRegistro, IDMedicamento, NombreMedicamento, FechaVencimiento) VALUES (?, ?, ?, ?)";

            try (Connection connection = Connect.obtenerConexion();
                 PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, idRegistro);
                statement.setInt(2, medicamento.getIdMedicamento());
                statement.setString(3, nombreMedicamento);
                statement.setDate(4, new java.sql.Date(fechaVencimiento.getTime()));

                int filasInsertadas = statement.executeUpdate();

                if (filasInsertadas > 0) {
                    System.out.println("Medicamento vencido registrado exitosamente.");
                } else {
                    System.out.println("No se pudo registrar el medicamento vencido.");
                }
            } catch (SQLException e) {
                System.out.println("Error al registrar el medicamento vencido: " + e.getMessage());
            }
        } else {
            System.out.println("El medicamento no existe en la base de datos.");
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
    