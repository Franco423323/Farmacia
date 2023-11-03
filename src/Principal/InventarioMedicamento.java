
package Principal;

import java.util.ArrayList;


public class InventarioMedicamento {
    private ArrayList<Medicamento> medicamentos;

    public InventarioMedicamento() {
        medicamentos = new ArrayList<>();
    }

    public void agregarMedicamento(Medicamento medicamento) {
        medicamentos.add(medicamento);
    }

    public void eliminarMedicamento(Medicamento medicamento) {
        medicamentos.remove(medicamento);
    }

    public ArrayList<Medicamento> obtenerMedicamentos() {
        return medicamentos;
    }
    
//    public int obtenerCantidadEnStock(Medicamento medicamento) {
//
//    }
}
