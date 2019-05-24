/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceGraficasManantial;

import Articulos.Articulos;
import Articulos.Rubrable;
import Articulos.Rubros;
import Articulos.SubRubros;
import Conversores.Numeros;
import ListasDePrecios.Articulable;
import ListasDePrecios.ArticulosAsignados;
import facturacion.clientes.Clientes;
import interfacesPrograma.Facturar;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import Articulos.ModificableArticulos;
import Articulos.TablaGenericaProductos;
import static facturacion.pantallas.IngresoDeFacturas.jTextField1;
import java.util.List;


/**
 *
 * @author mauro
 */
public class StockAbm extends javax.swing.JInternalFrame {
    private TableColumn columnaCodigo;
    private static ArrayList listadoDeBusqueda;
    private ArrayList listadoB;
    private Rubros rubro=new Rubros();
    private SubRubros subRubro;
    private ArrayList listadoSubRubros;
    private Rubrable ruble=new Rubros();
    private ArrayList listadoR=new ArrayList();
    private DefaultComboBoxModel combox=new DefaultComboBoxModel();
    private String valorCargado;
    private Articulos articuloPadre;
    private Articulos articuloHijo;
    private Clientes cliT;
    private DefaultTableModel modelo;
    private ModificableArticulos modiA;
    private TablaGenericaProductos tgp;
    
    /**
     * Creates new form StockAbm
     */
    public StockAbm() {
        initComponents();
        listadoB=new ArrayList();
        cliT=new Clientes();
        cliT=(Clientes) cliT.cargarPorCodigoAsignado(448);
        modelo=new DefaultTableModel();
        modiA=new Articulos();
        articuloPadre=new Articulos();
        articuloHijo=new Articulos();
        tgp = new TablaGenericaProductos();
        listadoDeBusqueda=new ArrayList();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cantidad_txt = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        articulo_txt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Ajuste de Stock");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/Mlogo.png"))); // NOI18N

        jLabel1.setText("Articulo a descontar");

        jLabel2.setText("Cantidad Actual");

        cantidad_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cantidad_txtKeyPressed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/nuevos/procesar.png"))); // NOI18N
        jButton1.setText("Procesar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable3);

        jLabel7.setText("Articulo a Modificar");

        articulo_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                articulo_txtKeyPressed(evt);
            }
        });

        jLabel5.setText("<html>\nPresione F1 para nuscar por descripción<br>\nPresione ENTER para confirmar los campos y cargar en la grilla inferior\n</html>");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(171, 171, 171)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cantidad_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(articulo_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel5))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(articulo_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cantidad_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void articulo_txtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_articulo_txtKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            //listadoDeBusqueda.clear();
            listadoDeBusqueda.clear();
            Facturar fart = new Articulos();
            articuloPadre = new Articulos();
            articuloPadre = (Articulos) fart.cargarPorCodigoDeBarra(this.articulo_txt.getText());
            
            /*
            rubro=new Rubros();
            Rubrable subRuble=new SubRubros();
            Iterator iR=listadoR.listIterator();
            while(iR.hasNext()){
                rubro=(Rubros)iR.next();
                listadoSubRubros=subRuble.listarPorRubro(rubro.getId());
            }
            ModificableArticulos modiA=new Articulos();
            Articulable modi=new ArticulosAsignados();
            listadoDeBusqueda=modi.convertirListadoEnArticulos(modi.filtrador(listadoSubRubros, listadoR, cliT));
            //listadoDeBusqueda=modi.filtrador(listadoSubRubros,listadoR);
            ListadoDeArticulos2 listadoArt=new ListadoDeArticulos2(listadoSubRubros,listadoR,listadoDeBusqueda,cliT);
            ListadoDeArticulos2.jTable1.setModel(modiA.mostrarListadoBusqueda(listadoDeBusqueda));
            //this.jTable3.setModel(modiA.mostrarListadoBusqueda(listadoDeBusqueda));
            listadoArt.setVisible(true);
            ListadoDeArticulos2.jTextField1.setText(null);
            ListadoDeArticulos2.jTextField1.requestFocus();
            articuloPadre=ListadoDeArticulos2.articulo;
            */
            //listadoB.add(ListadoDeArticulos2.articulo);
            this.jLabel1.setText(articuloPadre.getDescripcionArticulo());
            this.cantidad_txt.setText(String.valueOf(articuloPadre.getStockActual()));
            this.cantidad_txt.selectAll();
            this.cantidad_txt.requestFocus();
            
        
        }
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            //System.out.println("ENTRO CON F1¡¡¡¡¡");
            valorCargado =this.articulo_txt.getText();
            Facturar fart = new Articulos();
//            this.jTable2.removeAll();
            modiA = new Articulos();
            Articulable modi = new ArticulosAsignados();
            listadoDeBusqueda.clear();
            listadoDeBusqueda = fart.listadoBusqueda(this.articulo_txt.getText());
            //listadoDeBusqueda=modi.filtrador(listadoSubRubros,listadoR);

//            this.jTable2.setModel(modiA.mostrarListadoBusqueda(listadoDeBusqueda));
//            columnaCodigo=this.jTable2.getColumn("Descripcion");
//            columnaCodigo.setPreferredWidth(600);
//            columnaCodigo.setMaxWidth(600);
//            columnaCodigo=this.jTable2.getColumn("Stock");
//            columnaCodigo.setPreferredWidth(60);
//            columnaCodigo.setMaxWidth(60);
//            this.jTable2.requestFocus();
            // Configurando parametros de algunas columnas de interes
            List<String> columnasTabla = new ArrayList<>();
            columnasTabla.add("Código:100:100");
            columnasTabla.add("Descripcion:600:600");
            columnasTabla.add("Stock:60:60");

            // Desplegando ventana emergente
            int elementoSeleccionado = tgp.desplegarPopUp("Seleccion Item", modiA.mostrarListadoBusqueda(listadoDeBusqueda), columnasTabla);
            articuloPadre = (Articulos) listadoDeBusqueda.get(elementoSeleccionado);
            this.articulo_txt.setText(articuloPadre.getCodigoDeBarra());
            
        }
    }//GEN-LAST:event_articulo_txtKeyPressed

    private void cantidad_txtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidad_txtKeyPressed
        if(KeyEvent.VK_ENTER==evt.getKeyCode()){
            //listadoB.add(articuloPadre);
            articuloPadre.setCantidad(Numeros.ConvertirStringADouble(this.cantidad_txt.getText()));
            //articuloPadre.setCantidad(articuloPadre.getCantidad());
            double actualizado=articuloPadre.getCantidad() - articuloPadre.getStockActual();
            articuloPadre.setCantidad(actualizado);
            listadoB.add(articuloPadre);
            System.out.println("ACTUALIZADO"+ actualizado);
            this.jTable3.setModel(modiA.mostrarModificacionStock(listadoB));
            columnaCodigo=this.jTable3.getColumn("Descripcion");
        columnaCodigo.setPreferredWidth(380);
        columnaCodigo.setMaxWidth(380);
                //columnaCodigo=this.jTable3.getColumn("Cantidad");
        //columnaCodigo.setPreferredWidth(70);
        //columnaCodigo.setMaxWidth(70);
        this.articulo_txt.setText(null);
        this.articulo_txt.requestFocus();
            
        }
    }//GEN-LAST:event_cantidad_txtKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Iterator it=listadoB.listIterator();
        Articulos artic=new Articulos();
        
        while(it.hasNext()){
            artic=(Articulos) it.next();
            modiA.cargarMovimientoDeAjuste(artic);
        }
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField articulo_txt;
    private javax.swing.JTextField cantidad_txt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables
}
