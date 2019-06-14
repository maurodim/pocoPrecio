/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public interface Presentable {
    public ArrayList FiltrarTrimestre(int idTrimestre,int ano,Object idEmpresa);
    public Object ModificarRegistro(Object registro);
    public String GenerarReporte(int idTrimestre,int ano,int idEmpresa);
    public DefaultTableModel MostrarEnTabla(ArrayList listado);
    public void ImpactarPresentacion(int idFiscal,Object Presentacion);
    public String ImpactarMultiplesPresentaciones(ArrayList listado); 
}
