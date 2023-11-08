package Principal;

import Conexion.Connect;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;

public class Main {
public static void main(String[] args) {
    GestionPrincipal inventario = new GestionPrincipal();

     Medicamento nuevoMedicamento4 = new Medicamento(18, "Aspirina", "NombreGenerico", "Indicaciones", "Tipo", "Lote", new Date(123, 10, 30));
////   
////inventario.insertarMedicamento(nuevoMedicamento4);
//inventario.eliminarMedicamento(3);
 inventario.obtenerMedicamentosVencidos();
    }

}

