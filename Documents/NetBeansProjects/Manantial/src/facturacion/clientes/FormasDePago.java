/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facturacion.clientes;

import interfaces.Transaccionable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
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
    private double monto;

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    

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
    public Object CargarForma(int id){
        FormasDePago forma = null;
        try {
            Transaccionable tra = new Conecciones();
            
            String sql = "select * from formasdepago where id="+id;
            ResultSet rs = tra.leerConjuntoDeRegistros(sql);
            while (rs.next()) {
                forma = new FormasDePago();
                forma.numeroFormaDePago = rs.getInt("id");
                forma.descripcionFormaDePago = rs.getString("descripcion");
                forma.recargo = rs.getDouble("recargo");
                forma.ctacte = rs.getInt("destino");
                //lst.add(forma);
            }
        } catch (InstantiationException ex) {
            Logger.getLogger(FormasDePago.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FormasDePago.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FormasDePago.class.getName()).log(Level.SEVERE, null, ex);
        }
        return forma;
    }
    public int NuevaForma(Object nueva) {
        int id = 0;
        FormasDePago forma = (FormasDePago) nueva;
        try {
            Transaccionable tra = new Conecciones();
            String sql = "insert into formasdepago (descripcion,recargo,destino) values ('" + forma.descripcionFormaDePago + "'," + forma.recargo + "," + forma.ctacte + ")";
            tra.guardarRegistro(sql);
            ResultSet rs = tra.leerConjuntoDeRegistros("select id from formasdepago order by id desc fetch first 1 rows only");
            while (rs.next()) {
                id = rs.getInt("id");
            }
            rs.close();
        } catch (InstantiationException ex) {
            Logger.getLogger(FormasDePago.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FormasDePago.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FormasDePago.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public void ModificarForma(Object nueva) {
        try {
            FormasDePago forma = (FormasDePago) nueva;
            if (forma.numeroFormaDePago > 1) {
                Transaccionable tra = new Conecciones();
                String sql = "update formasdepago set descripcion='" + forma.descripcionFormaDePago + "',recargo=" + forma.recargo + ",destino=" + forma.ctacte + " where id=" + forma.numeroFormaDePago;
                tra.guardarRegistro(sql);
            }
        } catch (InstantiationException ex) {
            Logger.getLogger(FormasDePago.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FormasDePago.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FormasDePago.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList ListarFormas() {
        ArrayList<FormasDePago> lst = new ArrayList();
        try {
            Transaccionable tra = new Conecciones();
            FormasDePago forma;
            String sql = "select * from formasdepago order by id";
            ResultSet rs = tra.leerConjuntoDeRegistros(sql);
            while (rs.next()) {
                forma = new FormasDePago();
                forma.numeroFormaDePago = rs.getInt("id");
                forma.descripcionFormaDePago = rs.getString("descripcion");
                forma.recargo = rs.getDouble("recargo");
                forma.ctacte = rs.getInt("destino");
                lst.add(forma);
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

    public DefaultComboBoxModel MostrarEnCombo(ArrayList lst) {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        Iterator it = lst.listIterator();
        FormasDePago forma;
        while (it.hasNext()) {
            forma = (FormasDePago) it.next();
            modelo.addElement(forma.descripcionFormaDePago);
        }
        return modelo;
    }
}
