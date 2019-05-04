/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facturacion.clientes;

import java.util.ArrayList;

/**
 *
 * @author mauro di
 */
public class FormasDePago {
    private int numeroFormaDePago;
    private String descripcionFormaDePago;
    private double recargo;

    public int getNumeroFormaDePago() {
        return numeroFormaDePago;
    }

    public void setNumeroFormaDePago(int numeroFormaDePago) {
        this.numeroFormaDePago = numeroFormaDePago;
    }

    public String getDescripcionFormaDePago() {
        return descripcionFormaDePago;
    }

    public void setDescripcionFormaDePago(String descripcionFormaDePago) {
        this.descripcionFormaDePago = descripcionFormaDePago;
    }

    public FormasDePago() {
        this.numeroFormaDePago = 1;
        this.descripcionFormaDePago = "CONTADO";
    }
    public ArrayList ListarFormas(){
        ArrayList lst=new ArrayList();
        
        return lst;
    }
    
}
