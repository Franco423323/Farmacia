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
   // inventario.insertarMedicamento(nuevoMedicamento3);

    }

}

