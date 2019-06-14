/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosDao;

import interfaces.Transaccionable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import objetosCiti.Empresas;

/**
 *
 * @author Usuario
 */
public class EmpresasControl {
    public ArrayList<Empresas> Listar(){
        ArrayList<Empresas> lst=new ArrayList();
        Transaccionable tra=new Conecciones();
        Empresas empresa;
        String sql="select * from empresas";
        ResultSet rs=tra.leerConjuntoDeRegistros(sql);
        try {
            while(rs.next()){
                empresa=new Empresas();
                empresa.setId(rs.getInt("id"));
                empresa.setDescripcion(rs.getString("descripcion"));
                lst.add(empresa);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(EmpresasControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }
    public DefaultComboBoxModel MostrarEnCombo(ArrayList listado){
        DefaultComboBoxModel modelo=new DefaultComboBoxModel();
        Iterator it=listado.listIterator();
        Empresas empresa;
        while(it.hasNext()){
            empresa=(Empresas) it.next();
                    modelo.addElement(empresa.getDescripcion());
        }
        return modelo;
    }
}
