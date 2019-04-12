/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Articulos;

import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author andy
 */
public class TablaGenericaProductos {

    public TablaGenericaProductos() {
    }
    
    public void desplegarPopUp(String tituloVentana, DefaultTableModel modeloDatos, List<String> parametros){
        // Creando la ventana emergente
        JFrame jf = new JFrame(tituloVentana);
        JDialog emergente = new JDialog(jf, 
                                        tituloVentana, 
                                        true);
        
        emergente.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        emergente.setSize(1000,400);
        emergente.setLocationRelativeTo(null);
        
        // Crentado la tabla de datos
        JTable tabla = new JTable();
        tabla.setModel(modeloDatos);
        /*tabla.setModel(
                new DefaultTableModel(data, columnNames)
                {
                    boolean[] canEdit = new boolean [] {false, false, false, false, false};
                    public boolean isCellEditable(int rowIndex, int columnIndex) {return canEdit [columnIndex];}
                }
        );*/
        tabla.setFillsViewportHeight(true);
        tabla.setAutoCreateRowSorter(true);
        
        // Configurando parametros de cada columna de interes
        TableColumnModel modeloColumnas = tabla.getColumnModel();
        for(String config : parametros){
            String nombreColumna = config.split(":")[0];
            int anchoColumna = Integer.valueOf(config.split(":")[1]);
            int maxAncho = Integer.valueOf(config.split(":")[2]);
            System.out.println(nombreColumna+" - "+anchoColumna+" - "+maxAncho);
            modeloColumnas.getColumn(modeloColumnas.getColumnIndex(nombreColumna)).setPreferredWidth(anchoColumna);
            modeloColumnas.getColumn(modeloColumnas.getColumnIndex(nombreColumna)).setMaxWidth(maxAncho);
        }
        
        // Creando el scroll para deslizamiento de la tabla
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        
        // Agregando todo el contenido a la ventana emergente
        emergente.getContentPane().add(scrollPane);
        emergente.setVisible(true);
    }
}
