/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosCiti;

/**
 *
 * @author Usuario
 */
public class CitiVentas {

    String fecha;
    String tipoComprobante;
    String puntoDeVenta;
    String numeroComprobante;
    String gravado;
    String alicuota;
    String impuesto;
    String total;
    String fechaRegistro;
    String estado;
    String idCliente;
    String tipoIdCliente;
    String razon;
    String cuit;

    public CitiVentas(String fecha, String tipoComprobante, String puntoDeVenta, String numeroComprobante, String gravado, String alicuota, String impuesto, String total, String fechaRegistro, String estado, String idCliente, String tipoIdCliente, String razon, String cuit) {
        this.fecha = fecha;
        this.tipoComprobante = tipoComprobante;
        this.puntoDeVenta = puntoDeVenta;
        this.numeroComprobante = numeroComprobante;
        this.gravado = gravado;
        this.alicuota = alicuota;
        this.impuesto = impuesto;
        this.total = total;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
        this.idCliente = idCliente;
        this.tipoIdCliente = tipoIdCliente;
        this.razon = razon;
        this.cuit = cuit;
    }

    public String getFecha() {
        return fecha;
    }

    public String getTipoComprobante() {
        return tipoComprobante;
    }

    public String getPuntoDeVenta() {
        return puntoDeVenta;
    }

    public String getNumeroComprobante() {
        return numeroComprobante;
    }

    public String getGravado() {
        return gravado;
    }

    public String getAlicuota() {
        return alicuota;
    }

    public String getImpuesto() {
        return impuesto;
    }

    public String getTotal() {
        return total;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public String getEstado() {
        return estado;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public String getTipoIdCliente() {
        return tipoIdCliente;
    }

    public String getRazon() {
        return razon;
    }

    public String getCuit() {
        return cuit;
    }

}
