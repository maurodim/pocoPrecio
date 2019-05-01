/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Articulos;

import java.awt.Component;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
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
    
    
    public void eventoDeSeleccion(JTable tabla){
        
    }
    
    public int desplegarPopUp(String tituloVentana, DefaultTableModel modeloDatos, List<String> parametros){
         AtomicInteger atomicInteger = new AtomicInteger(-1);
        
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
        
        // agregando boton para seleccionar de manera asincrona
        JButton seleccionar = new JButton("SELECCIONAR");
        seleccionar.setAlignmentX(Component.CENTER_ALIGNMENT);
        seleccionar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        seleccionar.addActionListener((accion) -> {
            atomicInteger.set(tabla.getSelectedRow()); // almacenando el indice del elemento seleccionado de la tabla
            emergente.dispose(); // Cerrando la ventana emergente
        });
        
        // Agregando todo el contenido a la ventana emergente
        emergente.getContentPane().setLayout(new BoxLayout(emergente.getContentPane(), BoxLayout.Y_AXIS));
        emergente.getContentPane().add(scrollPane);
        emergente.getContentPane().add(seleccionar);
        
        // Desplegando ventana emergente
        emergente.setVisible(true);
        
        //System.out.println("seleccionado: "+atomicInteger.get());
        return atomicInteger.get();
    }
    
}
