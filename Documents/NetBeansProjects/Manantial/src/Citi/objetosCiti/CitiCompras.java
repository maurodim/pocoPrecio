/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosCiti;

import interfaces.Fiscalizable;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class CitiCompras implements Serializable,Fiscalizable{
    String fecha;
    String tipoComprobante;
    String puntoDeVenta;
    String numeroComprobante;
    String numeroDespachoimportacion;
    String codigoDocumentoVendedor;
    String identificacionVendedor;
    String apellidoNombre;
    String importeTotal;
    String importeTotalNoGravado;
    String importeOperacionesExentas;
    String importePercepcionIva;
    String improteOtrosImpuestosnacionales;
    String importePercepcionIB;
    String importePercepcionMunicipales;
    String importeImpuestosInternos;
    String codigoMoneda;
    String tipoDeCambio;
    String cantidadalicuotaIva;
    String codigoOperacion;
    String creditoFiscalComputado;
    String otrosTributos;
    String cuitEmisor;
    String denominacionEmisor;
    String ivaComision;
    String alicuotaIva;

    public CitiCompras(String fecha, String tipoComprobante, String puntoDeVenta, String numeroComprobante, String numeroDespachoimportacion, String codigoDocumentoVendedor, String identificacionVendedor, String apellidoNombre, String importeTotal, String importeTotalNoGravado, String importeOperacionesExentas, String importePercepcionIva, String improteOtrosImpuestosnacionales, String importePercepcionIB, String importePercepcionMunicipales, String importeImpuestosInternos, String codigoMoneda, String tipoDeCambio, String cantidadalicuotaIva, String codigoOperacion, String creditoFiscalComputado, String otrosTributos, String cuitEmisor, String denominacionEmisor, String ivaComision, String alicuotaIva) {
        this.fecha = fecha;
        this.tipoComprobante = tipoComprobante;
        this.puntoDeVenta = puntoDeVenta;
        this.numeroComprobante = numeroComprobante;
        this.numeroDespachoimportacion = numeroDespachoimportacion;
        this.codigoDocumentoVendedor = codigoDocumentoVendedor;
        this.identificacionVendedor = identificacionVendedor;
        this.apellidoNombre = apellidoNombre;
        this.importeTotal = importeTotal;
        this.importeTotalNoGravado = importeTotalNoGravado;
        this.importeOperacionesExentas = importeOperacionesExentas;
        this.importePercepcionIva = importePercepcionIva;
        this.improteOtrosImpuestosnacionales = improteOtrosImpuestosnacionales;
        this.importePercepcionIB = importePercepcionIB;
        this.importePercepcionMunicipales = importePercepcionMunicipales;
        this.importeImpuestosInternos = importeImpuestosInternos;
        this.codigoMoneda = codigoMoneda;
        this.tipoDeCambio = tipoDeCambio;
        this.cantidadalicuotaIva = cantidadalicuotaIva;
        this.codigoOperacion = codigoOperacion;
        this.creditoFiscalComputado = creditoFiscalComputado;
        this.otrosTributos = otrosTributos;
        this.cuitEmisor = cuitEmisor;
        this.denominacionEmisor = denominacionEmisor;
        this.ivaComision = ivaComision;
        this.alicuotaIva = alicuotaIva;
    }

    public CitiCompras() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    public String getAlicuotaIva() {
        return alicuotaIva;
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

    public String getNumeroDespachoimportacion() {
        return numeroDespachoimportacion;
    }

    public String getCodigoDocumentoVendedor() {
        return codigoDocumentoVendedor;
    }

    public String getIdentificacionVendedor() {
        return identificacionVendedor;
    }

    public String getApellidoNombre() {
        return apellidoNombre;
    }

    public String getImporteTotal() {
        return importeTotal;
    }

    public String getImporteTotalNoGravado() {
        return importeTotalNoGravado;
    }

    public String getImporteOperacionesExentas() {
        return importeOperacionesExentas;
    }

    public String getImportePercepcionIva() {
        return importePercepcionIva;
    }

    public String getImproteOtrosImpuestosnacionales() {
        return improteOtrosImpuestosnacionales;
    }

    public String getImportePercepcionIB() {
        return importePercepcionIB;
    }

    public String getImportePercepcionMunicipales() {
        return importePercepcionMunicipales;
    }

    public String getImporteImpuestosInternos() {
        return importeImpuestosInternos;
    }

    public String getCodigoMoneda() {
        return codigoMoneda;
    }

    public String getTipoDeCambio() {
        return tipoDeCambio;
    }

    public String getCantidadalicuotaIva() {
        return cantidadalicuotaIva;
    }

    public String getCodigoOperacion() {
        return codigoOperacion;
    }

    public String getCreditoFiscalComputado() {
        return creditoFiscalComputado;
    }

    public String getOtrosTributos() {
        return otrosTributos;
    }

    public String getCuitEmisor() {
        return cuitEmisor;
    }

    public String getDenominacionEmisor() {
        return denominacionEmisor;
    }

    public String getIvaComision() {
        return ivaComision;
    }

    @Override
    public Boolean Nuevo(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList ListarPorFechas(String fechaDesde, String fechaHasta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void GenerarArchivoComprobantes(ArrayList listado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void GenerarArchivoAlicuota(ArrayList listado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
