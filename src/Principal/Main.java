package Principal;

import Conexion.Connect;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;

public class Main {
public static void main(String[] args) {
    InventarioMedicamento inventario = new InventarioMedicamento();

    // Crea un nuevo medicamento
    Medicamento nuevoMedicamento = new Medicamento(1, "NombreComercial", "NombreGenerico", "Indicaciones", "Tipo", "Lote", new Date());
     Medicamento nuevoMedicamento2 = new Medicamento(2, "Aspirina", "NombreGenerico", "Indicaciones", "Tipo", "Lote", new Date());
     Medicamento nuevoMedicamento3 = new Medicamento(3, "Aspirina", "NombreGenerico", "Indicaciones", "Tipo", "Lote", new Date());
      Medicamento nuevoMedicamento4 = new Medicamento(4, "Aspirinaaa", "NombreGenerico", "Indicaciones", "Tipo", "Lote", new Date());
      Medicamento nuevoMedicamento5 = new Medicamento(5, "ola", "NombreGenerico", "Indicaciones", "Tipo", "Lote", new Date());
   
inventario.insertarMedicamento(nuevoMedicamento5);

//  String idUbicacion = "ubicacion1234"; // Reemplaza con el ID de la ubicación deseada
//        String ubicacion = "Estante 1"; // Reemplaza con la ubicación específica
        UbicacionMedicamento ubi1 = new UbicacionMedicamento("181112", nuevoMedicamento5, "Cerca del estan");
       ubi1.asignarMedicamentoAUbicacion();
    }

}

