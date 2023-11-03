package Principal;

import java.util.Date;

public class Medicamento {

    private String nombreComercial;
    private String nombreGenerico;
    private String indicaciones;
    private String tipo;
    private String lote;
    private Date fechaCaducidad;

    public Medicamento(String nombreComercial, String nombreGenerico, String indicaciones, String tipo, String lote, Date fechaCaducidad) {
        this.nombreComercial = nombreComercial;
        this.nombreGenerico = nombreGenerico;
        this.indicaciones = indicaciones;
        this.tipo = tipo;
        this.lote = lote;
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getNombreGenerico() {
        return nombreGenerico;
    }

    public void setNombreGenerico(String nombreGenerico) {
        this.nombreGenerico = nombreGenerico;
    }

    public String getIndicaciones() {
        return indicaciones;
    }

    public void setIndicaciones(String indicaciones) {
        this.indicaciones = indicaciones;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }


}
