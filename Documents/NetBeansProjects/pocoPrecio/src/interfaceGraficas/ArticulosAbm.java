/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceGraficas;

import Excel.InformeArticulos;
import Excel.PlanillaStock;
import interfacesPrograma.Facturar;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import objetos.Articulos;
import tablas.MiModeloTablaArticulos;

/**
 *
 * @author mauro
 */
public class ArticulosAbm extends javax.swing.JInternalFrame {
    private ArrayList listadoA=new ArrayList();
    
    /**
     * Creates new form ArticulosAbm
     */
    public ArticulosAbm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Alta, Baja y modificacion de Articulos");

        MiModeloTablaArticulos modelArticulos=new MiModeloTablaArticulos();
        Facturar fact=new Articulos();
        listadoA=fact.listadoBusqueda("");
        Iterator list=listadoA.listIterator();
        jTable1.setModel(modelArticulos);
        modelArticulos.addColumn("CODIGO");
        modelArticulos.addColumn("DESCRIPCION");
        modelArticulos.addColumn("STOCK");
        modelArticulos.addColumn("STOCK MIN");
        modelArticulos.addColumn("COSTO");
        modelArticulos.addColumn("P. VENTA");
        modelArticulos.addColumn("SERVICIO");
        Object[] fila=new Object[7];
        while(list.hasNext()){
            Articulos articulos=(Articulos)list.next();
            fila[0]=articulos.getCodigoAsignado();
            fila[1]=articulos.getDescripcionArticulo();
            fila[2]=articulos.getStockActual();
            fila[3]=articulos.getStockMinimo();
            fila[4]=articulos.getPrecioDeCosto();
            fila[5]=articulos.getPrecioUnitarioNeto();
            fila[6]=articulos.getPrecioServicio();
            modelArticulos.addRow(fila);
        }
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Nuevo Articulo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Alertas");

        jButton4.setText("Modificar Articulo");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setText("Ingrese descripcion de articulo");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        jLabel2.setText("Ingrese codigo de barra");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/excel_icone.png"))); // NOI18N
        jButton2.setText("Listar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/excel_icone.png"))); // NOI18N
        jButton5.setText("Planilla de Stock");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                    .addComponent(jTextField1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField2)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Articulos articulo=(Articulos)listadoA.get(this.jTable1.getSelectedRow());
        //System.out.println(" codigo elegido "+articulo.getCodigoAsignado());
        ArticulosMod articM=new ArticulosMod(articulo);
        Inicio.jDesktopPane1.add(articM);
        articM.setVisible(true);
        articM.toFront();
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ArticulosMod articMo=new ArticulosMod();
        Inicio.jDesktopPane1.add(articMo);
        articMo.setVisible(true);
        articMo.toFront();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_F1){
            //System.out.println("ENTRO CON F1¡¡¡¡¡");
        Facturar fart=new Articulos();
        ArrayList listadoDeBusqueda=fart.listadoBusqueda(this.jTextField1.getText().toUpperCase());
        cargarLista(listadoDeBusqueda);    
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
                if(evt.getKeyCode()==KeyEvent.VK_F1){
            //System.out.println("ENTRO CON F1¡¡¡¡¡");
        Facturar fart=new Articulos();
        
        ArrayList listadoDeBusqueda=fart.listarClientes(this.jTextField2.getText().toUpperCase());
        cargarLista(listadoDeBusqueda);    
        }

    }//GEN-LAST:event_jTextField2KeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        InformeArticulos informe=new InformeArticulos();
        try {
            informe.GenerarInforme(listadoA);
        } catch (SQLException ex) {
            Logger.getLogger(ArticulosAbm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        PlanillaStock planilla=new PlanillaStock();
        try {
            planilla.GenerarInforme(listadoA);
        } catch (SQLException ex) {
            Logger.getLogger(ArticulosAbm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed
    public void agregarRenglon(){
        MiModeloTablaArticulos busC=new MiModeloTablaArticulos();
        this.jTable1.removeAll();
        Double montoTotal=0.00;
        //ArrayList listadoPedidos=new ArrayList();
        this.jTable1.setModel(busC);
        Articulos pedidos=null;
        busC.addColumn("CODIGO");
        busC.addColumn("DESCRIPCION");
        busC.addColumn("STOCK");
        busC.addColumn("STOCK MIN");
        busC.addColumn("COSTO");
        busC.addColumn("P VENTA");
        busC.addColumn("SERVICIO");
        Object[] fila=new Object[7];
        Iterator irP=listadoA.listIterator();
        while(irP.hasNext()){
            pedidos=(Articulos) irP.next();
            //fila[0]=pedidos.getCodigo();
            fila[0]=pedidos.getCodigoAsignado();
            fila[1]=pedidos.getDescripcionArticulo();
            fila[2]=pedidos.getStockActual();
            fila[3]=pedidos.getStockMinimo();
            fila[4]=pedidos.getPrecioDeCosto();
            fila[5]=pedidos.getPrecioUnitarioNeto();
            fila[6]=pedidos.getPrecioServicio();
            busC.addRow(fila);
        }
    }
    private void cargarLista(ArrayList lista){
    DefaultListModel modelo=new DefaultListModel();
    Iterator il=lista.listIterator();
    Articulos art=new Articulos();
    while(il.hasNext()){
        art=(Articulos)il.next();
        //System.out.println("DESCRIPCION "+art.getDescripcionArticulo());
        modelo.addElement(art.getCodigoAsignado()+" "+art.getDescripcionArticulo());
    }
    ListadoDeArticulos1 listadoDeArt=new ListadoDeArticulos1();
    listadoDeArt.jList1.setModel(modelo);
    listadoDeArt.setVisible(true);
    listadoDeArt.jList1.requestFocus();
    int posicion=listadoDeArt.jList1.getSelectedIndex();
    Articulos articulo=(Articulos)lista.get(posicion);
    //System.out.println(" codigo elegido "+articulo.getCodigoAsignado());
        ArticulosMod articM=new ArticulosMod(articulo);
        Inicio.jDesktopPane1.add(articM);
        articM.setVisible(true);
        articM.toFront();
    
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}