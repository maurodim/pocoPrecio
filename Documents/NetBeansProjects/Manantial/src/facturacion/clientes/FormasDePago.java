/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facturacion.clientes;

import interfaces.Transaccionable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetosR.Conecciones;

/**
 *
 * @author mauro di
 */
public class FormasDePago {
    private int numeroFormaDePago;
    private String descripcionFormaDePago;
    private double recargo;
    private int ctacte;

    public double getRecargo() {
        return recargo;
    }

    public void setRecargo(double recargo) {
        this.recargo = recargo;
    }

    public int getCtacte() {
        return ctacte;
    }

    public void setCtacte(int ctacte) {
        this.ctacte = ctacte;
    }

    
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
        try {
            Transaccionable tra=new Conecciones();
            FormasDePago forma;
            String sql="select * from formasdepago order by id";
            ResultSet rs=tra.leerConjuntoDeRegistros(sql);
            while(rs.next()){
                forma=new FormasDePago();
                forma.numeroFormaDePago=rs.getInt("id");
                forma.descripcionFormaDePago=rs.getString("descripcion");
                forma.recargo=rs.getDouble("recargo");
                forma.ctacte=rs.getInt("destino");
                
            }
        } catch (InstantiationException ex) {
            Logger.getLogger(FormasDePago.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FormasDePago.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FormasDePago.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }
    
}
