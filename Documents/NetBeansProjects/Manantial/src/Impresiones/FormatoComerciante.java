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
public class FormatoComerciante {
    private String razonSocial;
    private String nombreDelLocal;
    private String direccion;
    private String telefono;
    private String cuitLocal;
    private String ingresosBrutos;

    public FormatoComerciante() {
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNombreDelLocal() {
        return nombreDelLocal;
    }

    public void setNombreDelLocal(String nombreDelLocal) {
        this.nombreDelLocal = nombreDelLocal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCuitLocal() {
        return cuitLocal;
    }

    public void setCuitLocal(String cuitLocal) {
        this.cuitLocal = cuitLocal;
    }

    public String getIngresosBrutos() {
        return ingresosBrutos;
    }

    public void setIngresosBrutos(String ingresosBrutos) {
        this.ingresosBrutos = ingresosBrutos;
    }

    @Override
    public String toString() {
        return "FormatoComerciante{" + "razonSocial=" + razonSocial + ", nombreDelLocal=" + nombreDelLocal + ", direccion=" + direccion + ", telefono=" + telefono + ", cuitLocal=" + cuitLocal + ", ingresosBrutos=" + ingresosBrutos + '}';
    }
    
    
}
