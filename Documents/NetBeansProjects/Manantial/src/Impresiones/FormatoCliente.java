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
public class FormatoCliente {
    private String nombreCliente;//
    private String condIva;//
    private String direccionCliente;//
    private String telefonoCliente;
    private String cuitCliente; //

    public FormatoCliente() {
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getCondIva() {
        return condIva;
    }

    public void setCondIva(String condIva) {
        this.condIva = condIva;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getCuitCliente() {
        return cuitCliente;
    }

    public void setCuitCliente(String cuitCliente) {
        this.cuitCliente = cuitCliente;
    }

    @Override
    public String toString() {
        return "FormatoCliente{" + "nombreCliente=" + nombreCliente + ", condIva=" + condIva + ", direccionCliente=" + direccionCliente + ", telefonoCliente=" + telefonoCliente + ", cuitCliente=" + cuitCliente + '}';
    }
    
    
}
