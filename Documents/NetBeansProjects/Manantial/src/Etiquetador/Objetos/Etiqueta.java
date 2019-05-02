/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Etiquetador.Objetos;


import Etiquetador.Interfaces.interfaceEtiquetas;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mauro
 */
public class Etiqueta implements interfaceEtiquetas{
    private String nombre;
    private String precioMayorista;
    private String aclaracionMayorista;
    private String precioMinorista;
    private String acalracionMinorista;
    private String codigo;
    private String imagen;
    private Boolean incluyeMayorista;
    private String nombreEmpresa;

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecioMayorista() {
        return precioMayorista;
    }

    public void setPrecioMayorista(String precioMayorista) {
        this.precioMayorista = precioMayorista;
    }

    public String getAclaracionMayorista() {
        return aclaracionMayorista;
    }

    public void setAclaracionMayorista(String aclaracionMayorista) {
        this.aclaracionMayorista = aclaracionMayorista;
    }

    public String getPrecioMinorista() {
        return precioMinorista;
    }

    public void setPrecioMinorista(String precioMinorista) {
        this.precioMinorista = precioMinorista;
    }

    public String getAcalracionMinorista() {
        return acalracionMinorista;
    }

    public void setAcalracionMinorista(String acalracionMinorista) {
        this.acalracionMinorista = acalracionMinorista;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Boolean getIncluyeMayorista() {
        return incluyeMayorista;
    }

    public void setIncluyeMayorista(Boolean incluyeMayorista) {
        this.incluyeMayorista = incluyeMayorista;
    }
    
    private DefaultTableModel mostrarTabla(ArrayList lista){
        DefaultTableModel modelo=new DefaultTableModel();
        Etiqueta etiqueta;
        modelo.addColumn("CODIGO");
        modelo.addColumn("DESCRIPCION");
        modelo.addColumn("PRECIO MINORISTA");
            modelo.addColumn("MAYORISTA");
            modelo.addColumn("COMENT MAYORISTA");
            modelo.addColumn("COMENT. MINORISTA");
            Object[] fila=new Object[6];
            Iterator it=lista.listIterator();
            while(it.hasNext()){
                etiqueta=(Etiqueta) it.next();
                fila[0]=etiqueta.codigo;
                fila[1]=etiqueta.nombre;
                fila[2]=etiqueta.precioMinorista;
                if(etiqueta.incluyeMayorista){
                    fila[3]=etiqueta.precioMayorista;
                }else{
                    fila[3]="";
                }
                fila[4]=etiqueta.aclaracionMayorista;
                fila[5]=etiqueta.acalracionMinorista;
                modelo.addRow(fila);
            }
        return modelo;
        
    }
    private void imprimir(ArrayList lista){
        ImprimirPedido imprimir=new ImprimirPedido();
        imprimir.ImprimirEtiquetaGondola(lista, 0);
    }
    @Override
    public DefaultTableModel MostrarSeleccion(ArrayList lst) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList ActualizarArray(ArrayList lst) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ImprimirSeleccion(ArrayList lst) {
        this.imprimir(lst);
    }
    
    
    
}
