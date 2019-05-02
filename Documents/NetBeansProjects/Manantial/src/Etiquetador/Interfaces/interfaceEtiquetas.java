package Etiquetador.Interfaces;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mauro
 */
public interface interfaceEtiquetas {
    public DefaultTableModel MostrarSeleccion(ArrayList lst);
    public ArrayList ActualizarArray(ArrayList lst);
    public void ImprimirSeleccion(ArrayList lst);
}
