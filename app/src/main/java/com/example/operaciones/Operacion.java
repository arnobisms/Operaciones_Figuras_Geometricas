package com.example.operaciones;

public class Operacion {

    private String descripcion_operacion;
    private String datos;
    private Double resultado;

    public Operacion(String descripcion_operacion, String datos, Double resultado){
        this.descripcion_operacion = descripcion_operacion;
        this.datos = datos;
        this.resultado = resultado;
    }

    public String getDescripcion_operacion() {
        return descripcion_operacion;
    }

    public void setDescripcion_operacion(String descripcion_operacion) {
        this.descripcion_operacion = descripcion_operacion;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    public Double getResultado() {
        return resultado;
    }

    public void setResultado(Double resultado) {
        this.resultado = resultado;
    }

    public void guardar(){
        Datos.guardar(this);
    }
}
