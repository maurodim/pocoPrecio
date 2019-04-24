/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impresiones;

/**
 *
 * @author andy
 */
public class FormatoArticulos {
    
    private String codigo;
    private String descripcion;
    private String cantidad;
    private String montoTotal;

    public FormatoArticulos() {
    }

    public FormatoArticulos(String codigo, String descripcion, String cantidad, String montoTotal) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.montoTotal = montoTotal;
    }

    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(String montoTotal) {
        this.montoTotal = montoTotal;
    }

    @Override
    public String toString() {
        return "FormatoArticulos{" + "codigo=" + codigo + ", descripcion=" + descripcion + ", cantidad=" + cantidad + ", montoTotal=" + montoTotal + '}';
    }

    
    
}
