/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosActualizador;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Usuario
 */
public class Iva {
    private int id;
    private String descripcion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public ArrayList Listar(){
        ArrayList <Iva> lst=new ArrayList();
        Iva iva;
        
            iva=new Iva();
            iva.id=1;
            iva.descripcion="RESPONSABLLE INSCRIPTO";
            lst.add(iva);
            iva=new Iva();
            iva.id=4;
            iva.descripcion="EXENTO";
            lst.add(iva);
            iva=new Iva();
            iva.id=6;
            iva.descripcion="MONOTRIBUTISTA";
            lst.add(iva);
            return lst;
            
        
    }
    public DefaultComboBoxModel MostrarEnCombo(ArrayList listado){
        DefaultComboBoxModel modelo=new DefaultComboBoxModel();
        Iva iva;
        Iterator it=listado.listIterator();
        while(it.hasNext()){
            iva=(Iva) it.next();
            modelo.addElement(iva.descripcion);
        }
        return modelo;
    }
    
}
