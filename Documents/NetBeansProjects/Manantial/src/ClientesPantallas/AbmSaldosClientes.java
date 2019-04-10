/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientesPantallas;


import Excel.InformesClientes;
import Excel.InformesMovimientos;
import Sucursales.Cajas;
import facturacion.clientes.Clientes;
import facturacion.clientes.Editables;
import facturacion.clientes.Movible;
import facturacion.clientes.MovimientosClientes;
import interfaceGraficas.Inicio;
import interfacesPrograma.Cajeables;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author mauro
 */
public class AbmSaldosClientes extends javax.swing.JInternalFrame {

    private Clientes cli;
    private DefaultTableModel modelo;
    private MovimientosClientes moviC;
    private ArrayList listadoMov;
    
    public AbmSaldosClientes(Clientes cliente) {
        initComponents();
        cli=cliente;
        
        
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
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Detalle de Saldos");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/excel_icone.png"))); // NOI18N
        jButton1.setText("Exportar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Eliminar Movimiento");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Editar Movimiento");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        InformesMovimientos informes=new InformesMovimientos();
        
        
        
        try {
            informes.GenerarInforme(listadoMov);
        } catch (SQLException ex) {
            Logger.getLogger(AbmSaldosClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        cargarLista();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(JOptionPane.showConfirmDialog(this,"Confirma que Elimina todos los movimientos de la cuenta del cliente?","Limpieza de Movimientos de CTA CTE",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==1){
            
        }else{
            Editables edita=new MovimientosClientes();
            int posicion=this.jTable1.getSelectedRow();
            moviC=(MovimientosClientes) listadoMov.get(posicion);
            edita.EliminacionDeObjeto(moviC);
            listadoMov.clear();
            Movible movib=new MovimientosClientes();
            listadoMov=movib.ListarMovimientos(cli.getCodigoId());
            modelo=movib.MostrarMovimientos(listadoMov);
            this.jTable1.setModel(modelo);
            this.dispose();
            
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //ABRE VENTANA PARA EDICION
        int posicion=this.jTable1.getSelectedRow();
        moviC=(MovimientosClientes) listadoMov.get(posicion);
        EdicionMovimiento edicion=new EdicionMovimiento(moviC);
        Inicio.jDesktopPane1.add(edicion);
        edicion.setVisible(true);
        edicion.toFront();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        listadoMov=new ArrayList();
        modelo=new DefaultTableModel();
        moviC=new MovimientosClientes();
        Movible movib=new MovimientosClientes();
        listadoMov=movib.ListarMovimientos(cli.getCodigoId());
        System.out.println("cantidad de movimientos: "+listadoMov.size());
        modelo=movib.MostrarMovimientos(listadoMov);
        this.jTable1.setModel(modelo);
    }//GEN-LAST:event_formInternalFrameActivated
private void cargarLista(){
    /*
    DefaultListModel modelo=new DefaultListModel();
    //ArrayList lista=new ArrayList();
    Cajeables cajea=new Cajas();
   
    //lista=Cajas.getListadoCajas();
    int posic=this.jTable1.getSelectedRow();
    Cajas caaj=new Cajas();
    //caaj=(Cajas)Cajas.getListadoCajas().get(posic);
    moviC=(MovimientosClientes) listadoMov.get(posic);
    
    //modelo=cajea.LeerComprobante(moviC.getId(),moviC.getTipoComprobante(),moviC.getTipoComprobante());
    
    ListadoComprobantesClientes listadoDeArticulos=new ListadoComprobantesClientes(caaj);
    listadoDeArticulos.jList1.setModel(modelo);
    listadoDeArticulos.setVisible(true);
    int posicion=listadoDeArticulos.jList1.getSelectedIndex();
    */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
