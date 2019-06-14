/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosDao;

import Configuracion.Propiedades;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import objetosCiti.Trimestres;

/**
 *
 * @author Usuario
 */
public class TrimestresControl {
    public ArrayList<Trimestres> Listar(){
        ArrayList<Trimestres> lst=new ArrayList();
        Trimestres trimestre=new Trimestres(1,"01","01",2,"03");
        lst.add(trimestre);
        trimestre=new Trimestres(2,"02","04",5,"06");
        lst.add(trimestre);
        trimestre=new Trimestres(3,"03","07",8,"09");
        lst.add(trimestre);
        trimestre=new Trimestres(4,"04","10",11,"12");
        lst.add(trimestre);
        return lst;
                
    }
    public DefaultComboBoxModel MostrarCombo(ArrayList listado){
        DefaultComboBoxModel modelo=new DefaultComboBoxModel();
        Iterator it=listado.listIterator();
        Trimestres trimestre;
        while(it.hasNext()){
            trimestre=(Trimestres) it.next();
            modelo.addElement(trimestre.getDescripcion());
        }
        
        return modelo;
    }
    public Trimestres Cargar(int id){
        Trimestres trimestre = null;
        switch(id){
            case 1:
                trimestre=new Trimestres(1,"01","01",2,"03");
                break;
            case 2:
                trimestre=new Trimestres(2,"02","04",5,"06");
                break;
            case 3:
                trimestre=new Trimestres(3,"03","07",8,"09");
                break;
            case 4:
                trimestre=new Trimestres(4,"04","10",11,"12");
                break;
                
        }
        return trimestre;
    }
}
