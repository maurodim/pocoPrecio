/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetoDaoRyR;

import interfaces.Transaccionable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import objetosR.Conecciones;
import objetosR.TipoDeComprobantes;

/**
 *
 * @author Usuario
 */
public class TipoDeComprobantesDao {
    private Transaccionable tra;
    public ArrayList ListarVentas(){
        ArrayList<TipoDeComprobantes> listado=new ArrayList();
        String sql="select * from tipocomprobantes";
        tra=new Conecciones();
        TipoDeComprobantes tipo;
        ResultSet rs=tra.leerConjuntoDeRegistros(sql);
        try {
            while(rs.next()){
                tipo=new TipoDeComprobantes();
                tipo.setId(rs.getInt("id"));
                tipo.setDescripcion(rs.getString("descripcion"));
                tipo.setCodigoIva(rs.getInt("iva"));
                listado.add(tipo);
            }
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(TipoDeComprobantesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listado;
    }
    public DefaultComboBoxModel MostrarEnCombo(ArrayList lst){
        DefaultComboBoxModel modelo=new DefaultComboBoxModel();
        Iterator it=lst.listIterator();
        TipoDeComprobantes tipo;
        while(it.hasNext()){
            tipo=(TipoDeComprobantes) it.next();
            modelo.addElement(tipo.getDescripcion());
        }
        return modelo;
    }
    public int SeleccionarCargadoEnCombo(ArrayList lst,int id){
        int posicion=0;
        Iterator it=lst.listIterator();
        TipoDeComprobantes tipo;
        int posi=0;
        while(it.hasNext()){
            tipo=(TipoDeComprobantes) it.next();
            if(tipo.getId()== id){
                posicion=posi;
            }
            posi++;
        }
        return posicion;
    }
    
}
