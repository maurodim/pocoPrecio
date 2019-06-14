/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosDao;

import interfaces.Presentable;
import interfaces.Transaccionable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import objetosCiti.Empresas;
import objetosCiti.Presentacion;
import objetosCiti.Trimestres;

/**
 *
 * @author Usuario
 */
public class PresentacionesControl implements Presentable{
    
    @Override
    public ArrayList FiltrarTrimestre(int idTrimestre, int ano, Object idEmpresa) {
        Transaccionable tra=new Conecciones();
        ArrayList lst=new ArrayList();
        Trimestres trimestre;
        TrimestresControl control=new TrimestresControl();
        Presentacion presentacion;
        Empresas empresa=(Empresas) idEmpresa;
        
        
        trimestre=control.Cargar(idTrimestre);
        String inicio=ano+"-"+trimestre.getMes1()+"-01";
        String fin=ano+"-"+trimestre.getMes3()+"-31";
        String sql="select fiscal.*,presentacion.* from fiscal left join presentacion on presentacion.idfiscal=fiscal.id where fiscal.idempresa="+empresa.getId()+" and tipo like '081' and fiscal.fechaRegistro BETWEEN '"+inicio+"' and '"+fin+"'";
        System.out.println("sql "+sql);
        ResultSet rs=tra.leerConjuntoDeRegistros(sql);
        try {
            while(rs.next()){
                presentacion=new Presentacion();
                presentacion.setTipoComprobante(rs.getString("tipo"));
                presentacion.setPuntoDeVenta(rs.getString("pto"));
                presentacion.setNumeroComprobante(rs.getString("numero"));
                presentacion.setFecha(rs.getString("fecha"));
                presentacion.setImporteTotal(String.valueOf(rs.getDouble("total")));
                presentacion.setCuitReceptor(rs.getString("cuit"));
                presentacion.setRazonSocial(rs.getString("razon"));
                lst.add(presentacion);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PresentacionesControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }

    @Override
    public Object ModificarRegistro(Object registro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String GenerarReporte(int idTrimestre, int ano, int idEmpresa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultTableModel MostrarEnTabla(ArrayList listado) {
        DefaultTableModel modelo=new DefaultTableModel();
        Iterator it=listado.listIterator();
        Presentacion presentacion;
        
        modelo.addColumn("FECHA");
        modelo.addColumn("PTO DE VTA");
        modelo.addColumn("NUMERO");
        modelo.addColumn("RAZON SOCIAL");
        modelo.addColumn("CUIT");
        modelo.addColumn("DNI");
        Object fila[]=new Object[6];
        
        while(it.hasNext()){
            presentacion=(Presentacion) it.next();
            fila[0]=presentacion.getFecha();
            fila[1]=presentacion.getPuntoDeVenta();
            fila[2]=presentacion.getNumeroComprobante();
            fila[3]=presentacion.getRazonSocial();
            fila[4]=presentacion.getCuitReceptor();
            fila[5]=presentacion.getNumeroDocumento();
            modelo.addRow(fila);
        }
        return modelo;
    }

    @Override
    public void ImpactarPresentacion(int idFiscal, Object Presentacion) {
        
    }

    @Override
    public String ImpactarMultiplesPresentaciones(ArrayList listado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
