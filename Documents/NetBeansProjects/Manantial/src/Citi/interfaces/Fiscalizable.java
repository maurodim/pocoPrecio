/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public interface Fiscalizable {
    public Boolean Nuevo(Object objeto);
    public ArrayList ListarPorFechas(String fechaDesde,String fechaHasta);
    public void GenerarArchivoComprobantes(ArrayList listado);
    public void GenerarArchivoAlicuota(ArrayList listado);
}
