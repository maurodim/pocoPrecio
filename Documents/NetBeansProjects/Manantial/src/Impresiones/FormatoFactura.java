/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impresiones;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author andy
 */
public class FormatoFactura {
    private LocalDateTime ldt;
    
    private String nroFactura;
    private String fecha;
    private String hora;
    private String totalSinIva;
    private String subTotal;
    private String iva;
    private String montoIva;
    private String total;
    private String suPago;
    private String sumaSuPago;
    private String suVuelto;
    private String noGravados;

    public FormatoFactura() {
       ldt = LocalDateTime.now();
    }

    public String getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(String nroFactura) {
        this.nroFactura = nroFactura;
    }

    public String getFecha() {
        return ldt.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public String getHora() {
        return ldt.format(DateTimeFormatter.ofPattern("hh:mm:ss a"));
    }

    public String getTotalSinIva() {
        return totalSinIva;
    }

    public void setTotalSinIva(String totalSinIva) {
        this.totalSinIva = totalSinIva;
    }

    public String getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getSuPago() {
        return suPago;
    }

    public void setSuPago(String suPago) {
        this.suPago = suPago;
    }

    public String getSumaSuPago() {
        return sumaSuPago;
    }

    public void setSumaSuPago(String sumaSuPago) {
        this.sumaSuPago = sumaSuPago;
    }

    public String getSuVuelto() {
        return suVuelto;
    }

    public void setSuVuelto(String suVuelto) {
        this.suVuelto = suVuelto;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

    public String getMontoIva() {
        return montoIva;
    }

    public void setMontoIva(String montoIva) {
        this.montoIva = montoIva;
    }

    public String getNoGravados() {
        return noGravados;
    }

    public void setNoGravados(String noGravados) {
        this.noGravados = noGravados;
    }

    @Override
    public String toString() {
        return "FormatoFactura{" + "nroFactura=" + nroFactura + ", fecha=" + fecha + ", hora=" + hora + ", totalSinIva=" + totalSinIva + ", subTotal=" + subTotal + ", iva=" + iva + ", montoIva=" + montoIva + ", total=" + total + ", suPago=" + suPago + ", sumaSuPago=" + sumaSuPago + ", suVuelto=" + suVuelto + ", noGravados=" + noGravados + '}';
    }

    
    
    

   
    
    
    
    
}
