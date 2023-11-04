
package Principal;
import Conexion.Connect;
import java.sql.Connection;
import java.util.Date;


public class Main {
    public static void main(String[] args) {
        InventarioMedicamento inventario = new InventarioMedicamento();

        // Crea un nuevo medicamento
        Medicamento medicamento = new Medicamento(1 ,"NombreComercial", "NombreGenerico", "Indicaciones", "Tipo", "Lote", new Date());

        // Inserta el medicamento en l3a base de datos
        inventario.insertarMedicamento(medicamento);
        //inventario.eliminarMedicamento(1);
    }
            
    }


