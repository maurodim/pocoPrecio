/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FacturaElectronica.Controlador;

import FacturaElectronica.Objetos.TiposIva;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Usuario
 */
public class TiposIvaControl {
    public List<TiposIva> ListarTipos(){
        List<TiposIva> listado=new ArrayList();
        TiposIva tipo=new TiposIva(3,0.00,0.00,0);
        listado.add(tipo);
        tipo=new TiposIva(4,0.00,0.00,10.5);
        listado.add(tipo);
        tipo=new TiposIva(5,0.00,0.00,21);
        listado.add(tipo);
        tipo=new TiposIva(6,0.00,0.00,27);
        listado.add(tipo);
        return listado;
    }
    public DefaultComboBoxModel MostrarEnCombo(ArrayList lst){
        DefaultComboBoxModel modelo=new DefaultComboBoxModel();
        Iterator it=lst.listIterator();
        TiposIva tipo;
        while(it.hasNext()){
            tipo=(TiposIva) it.next();
            modelo.addElement(tipo.getDescripcion());
        }
        
        return modelo;
    }
}
