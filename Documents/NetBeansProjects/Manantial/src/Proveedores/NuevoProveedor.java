/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Proveedores;

import Cotizaciones.Cotizacion;
import Cotizaciones.IngresoDeCotizacion;
import Proveedores.objetos.ImprimirOrdenDeTrabajo;
import Proveedores.objetos.MovimientoProveedores;
import Proveedores.objetos.OrdenDePago;
import Recibos.Recidable;
import facturacion.clientes.ListasDePrecios;
import interfaceGraficasManantial.Inicio;
import ClientesPantallas.NuevoCliente;
import Proveedores.Interfaces.FacturableE;
import interfaces.Personalizable;
import interfacesPrograma.Busquedas;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import objetosR.CondicionesIva;
import objetosR.Localidades;

/**
 *
 * @author hernan
 */
public class NuevoProveedor extends javax.swing.JInternalFrame implements InternalFrameListener {
    private JInternalFrame clientes;
    private int modificacion;
    private double saldoTotal;
    private MovimientoProveedores movimiento;
    private Proveedores cliTa=new Proveedores();
    private ArrayList listadoL=new ArrayList();
    private ArrayList listadoIva=new ArrayList();
    private ArrayList listadoLoc=new ArrayList();
    private Cotizacion cotizacionT=new Cotizacion();
    private ArrayList listadoCot=new ArrayList();
    private ArrayList listadoPed=new ArrayList();
    DefaultTableModel modelo=new DefaultTableModel();
    DefaultTableModel modelo1=new DefaultTableModel();
    DefaultTableModel modelo2=new DefaultTableModel();        
    private CondicionesIva condicion=new CondicionesIva();
    private ListasDePrecios listaPrecio=new ListasDePrecios();
    private Localidades localidad=new Localidades();
    private ArrayList listadoFac=new ArrayList();
    
    /**
     * Creates new form NuevoCliente
     */
    public NuevoProveedor() {
        initComponents();
        this.jPanel2.setVisible(false);
    }
    public NuevoProveedor(Object client) {
        initComponents();
        cliTa=(Proveedores)client;
        this.jTextField1.setText(cliTa.getNombre());
        //this.setTitle("MODIFICACION DATOS DEL CLIENTE - "+cliTa.getRazonSocial());
        this.jTextField2.setText(cliTa.getDireccion());
        Iterator iIva=listadoIva.listIterator();
        int tipoIvaC=cliTa.getCondicionDeIva();
        int rengl=0;
        int posicion=0;
        while(iIva.hasNext()){
            condicion=(CondicionesIva)iIva.next();
            if(tipoIvaC==condicion.getId()){
                posicion=rengl;
            }
            rengl++;
        }
        this.jComboBox1.setSelectedIndex(posicion);
        
        this.jTextField3.setText(cliTa.getNumeroDeCuit());
        this.jTextField4.setText(cliTa.getTelefono());
        this.jTextArea1.setText(cliTa.getAnexo());
        //tipoIvaC=cliTa.getListaDePrecios();
        rengl=0;
        posicion=0;
        Iterator iLst=listadoL.listIterator();
        while(iLst.hasNext()){
            listaPrecio=(ListasDePrecios)iLst.next();
            if(tipoIvaC==listaPrecio.getNumeroLista()){
                posicion=rengl;
            }
            rengl++;
        }
        //this.jComboBox2.setSelectedIndex(posicion);
        String loc=cliTa.getDescripcionLocalidad();
        String loc2="";
        rengl=0;
        posicion=0;
        Iterator itLoc=listadoLoc.listIterator();
        while(itLoc.hasNext()){
            localidad=(Localidades)itLoc.next();
            loc2=localidad.getDescripcion();
            if(loc.equals(loc2)){
                posicion=rengl;
            }
            rengl++;
        }
        //this.jComboBox3.setSelectedIndex(posicion);
        //this.jTextField5.setText(String.valueOf(cliTa.getCupoDeCredito()));
        Double coef=1.00;
        //coef=cliTa.getCoeficienteListaDeprecios() - 1;
        //if(coef==0.00)coef=1.00;
        /*
        if(cliTa.getCoeficienteListaDeprecios() < 1){
            
            coef=coef * 100;
        }else{
            coef=0.00;
        }
        */
        this.jTextField7.setText(cliTa.getResponsable());
        this.jTextField9.setText(cliTa.getCelular());
        this.jTextField12.setText(cliTa.getMail());
        this.jTextField3.setText(cliTa.getCuit());
        modificacion=1;
        this.setTitle("PERFIL DEL PROVEEDOR");
        /*
        this.jTextField6.setText(cliTa.getDireccionDeEntrega());
        this.jTextField7.setText(cliTa.getResponsable());
        this.jTextField8.setText(cliTa.getFantasia());
        this.jTextField9.setText(cliTa.getCelular());
        this.jTextField10.setText(cliTa.getDireccionFantasia());
        this.jTextField11.setText(cliTa.getFax());
        this.jTextField12.setText(cliTa.getEmail());
        
        modificacion=1;
        //this.setTitle("MODIFICACION DATOS DEL CLIENTE");
        Cotizable cotizable=new Cotizacion();
        Cotizacion cotizacion=new Cotizacion();
        listadoCot=cotizable.listarPorEstado(cliTa.getCodigoId(),0);
        modelo=cotizable.mostrarListado(listadoCot);
        if(Inicio.usuario.getNumeroId()==2){
            this.jButton5.setVisible(false);
            this.jButton8.setVisible(false);
        }
        this.jTable1.setModel(modelo);
        Pedable pedable=new Pedidos();
        Pedidos pedidos=new Pedidos();
        listadoPed=pedable.listarPorEstado(cliTa.getCodigoId(),0);
        modelo1=pedable.mostrarListado(listadoPed);
        this.jTable2.setModel(modelo1);
        Facturable ff=new Facturas();
        Facturas factura=new Facturas();
        listadoFac=ff.listarPorClienteNoRemitidas(cliTa.getCodigoId());
        modelo2=ff.mostrarListado(listadoFac);
        this.jTable3.setModel(modelo2);
        */
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("FACTURACION - CARGA DE NUEVO PROVEEDOR");
        setAutoscrolls(true);
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/Mlogo.png"))); // NOI18N
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
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
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jLabel1.setText("Razon Social");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        jLabel2.setText("Domicilio :");

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
        });

        jLabel3.setText("Cond Iva:");

        CondicionesIva condicion=new CondicionesIva();
        Busquedas bus=new CondicionesIva();
        listadoIva=bus.listar("");
        Iterator iIva=listadoIva.listIterator();
        while(iIva.hasNext()){
            condicion=(CondicionesIva)iIva.next();
            jComboBox1.addItem(condicion.getDescripcion());
        }

        jLabel4.setText("N° de CUIT:");

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField3KeyPressed(evt);
            }
        });

        jLabel5.setText("Telefono :");

        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField4KeyPressed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/nuevos/guardar.png"))); // NOI18N
        jButton1.setText("GUARDAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel11.setText("Responsable :");

        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField7KeyPressed(evt);
            }
        });

        jLabel13.setText("Celular :");

        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField9KeyPressed(evt);
            }
        });

        jLabel16.setText("email  :");

        jTextField12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField12KeyPressed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel6.setText("Observaciones:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(82, 82, 82)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1)
                    .addComponent(jTextField2)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField3)
                    .addComponent(jTextField4)
                    .addComponent(jTextField7)
                    .addComponent(jTextField9)
                    .addComponent(jTextField12)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE))
                .addContainerGap(939, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Perfil", jPanel1);

        jTable3.setModel(modelo2);
        jScrollPane3.setViewportView(jTable3);

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/nuevos/eliminar_des.png"))); // NOI18N
        jButton15.setText("Eliminar Factura");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/currency_black_dollar.png"))); // NOI18N
        jButton16.setText("Ingreso de Factura");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel7.setText("Saldo: $");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1489, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton16)
                        .addGap(18, 18, 18)
                        .addComponent(jButton15)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton15)
                        .addComponent(jButton16)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Movimientos", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       Proveedores cli=new Proveedores();
       //cli.setCodigoCliente(title);
       if(modificacion==1){
           cli=cliTa;
       }
       cli.setNombre(this.jTextField1.getText());
       cli.setDireccion(this.jTextField2.getText());
       String condicion1=null;
       Integer tipo=0;
       condicion=(CondicionesIva)listadoIva.get(this.jComboBox1.getSelectedIndex());
       tipo=condicion.getId();
       
       
      
       
       cli.setCondicionDeIva(tipo);
       //cli.setCondicionIva(condicion1);
       cli.setCuit(this.jTextField3.getText());
       cli.setTelefono(this.jTextField4.getText());
       //cli.setCupoDeCredito(Numeros.ConvertirStringADouble(this.jTextField5.getText()));
       //cli.set(this.jTextField10.getText());
       //Double coef=Numeros.ConvertirStringADouble(this.jTextField6.getText()) / 100;
       //coef=coef + 1;
       //cli.setCoeficienteListaDeprecios(coef);
       cli.setResponsable(this.jTextField7.getText());
       //cli.setFantasia(this.jTextField8.getText());
       cli.setCelular(this.jTextField9.getText());
       //cli.setFax(this.jTextField11.getText());
       //cli.setDireccionFantasia(this.jTextField10.getText());
       cli.setMail(this.jTextField12.getText());
       //localidad=(Localidades)listadoLoc.get(this.jComboBox3.getSelectedIndex());
       //cli.setLocalidad(String.valueOf(localidad.getId()));
       cli.setAnexo(this.jTextArea1.getText());
       Personalizable fact=new Proveedores();
       if(modificacion==1){
          
        fact.modificar(cli); 
       }else{
       
        fact.agregar(cli);
       }
      try{  
       IngresoDeCotizacion.jCheckBox2.setSelected(true);
       IngresoDeCotizacion.jCheckBox2.setEnabled(false);
       //IngresoDeCotizacion.cliT=cli;
       //IngresoDeCotizacion.jLabel6.setText(cli.getRazonSocial());
      }catch (java.lang.NullPointerException exx){
           //JInternalFrame AbmClientes = null;
          //ControlaInstancia(AbmClientes);
      }
       
       
       this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
                MovimientoProveedores comprobante=new MovimientoProveedores();
        int posicion=this.jTable3.getSelectedRow();
        comprobante=(MovimientoProveedores)listadoCot.get(posicion);
        
        if (JOptionPane.showConfirmDialog(this, "Confirma la Eliminación del comprobante ?", "Eliminar Comprobante", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 1) {

        } else {
            FacturableE fac=new MovimientoProveedores();
            fac.eliminar(comprobante);
        }
        listadoCot.clear();
        FacturableE factu=new MovimientoProveedores();
        
        listadoCot=factu.listarPorEstado(cliTa.getNumero());
        this.jTable3.setModel(factu.mostrarListado(listadoCot));
        Iterator itL=listadoCot.listIterator();
        saldoTotal=0;
        while(itL.hasNext()){
            movimiento=(MovimientoProveedores) itL.next();
            saldoTotal=saldoTotal + movimiento.getMonto();
        }
        this.jLabel7.setText("Saldo: $"+saldoTotal);
        /*
        IngresoFcProveedor factu=new IngresoFcProveedor(comprobante,cliTa);
        Inicio.jDesktopPane1.add(factu);
        try {
            factu.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(NuevoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        factu.setTitle("Ingreso de Factura de Proveedores - FACTURA N° "+comprobante.getNumeroComprobante().toUpperCase());
        factu.setVisible(true);
        factu.toFront();
        */
    }//GEN-LAST:event_jButton15ActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        //
    }//GEN-LAST:event_formComponentShown

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
           System.out.println(" debería recargar los datos acá los datos de la tabla");
    }//GEN-LAST:event_formFocusGained

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // ACA DEBO MANEJAR LOS EVENTOS DE LAS TECLAS
        System.out.println(" acá se presiono una tecla");
    }//GEN-LAST:event_formKeyPressed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        IngresoFcProveedor abmP=new IngresoFcProveedor(cliTa);
        Inicio.jDesktopPane1.add(abmP);
        abmP.setVisible(true);
        abmP.toFront();
    }//GEN-LAST:event_jButton16ActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        listadoCot.clear();
        FacturableE factu=new MovimientoProveedores();
        
        listadoCot=factu.listarPorEstado(cliTa.getNumero());
        this.jTable3.setModel(factu.mostrarListado(listadoCot));
        Iterator itL=listadoCot.listIterator();
        saldoTotal=0;
        while(itL.hasNext()){
            movimiento=(MovimientoProveedores) itL.next();
            saldoTotal=saldoTotal + movimiento.getMonto();
        }
        this.jLabel7.setText("Saldo: $"+saldoTotal);
    }//GEN-LAST:event_formInternalFrameActivated

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)this.jTextField2.requestFocus();
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)this.jComboBox1.requestFocus();
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jTextField3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)this.jTextField4.requestFocus();
    }//GEN-LAST:event_jTextField3KeyPressed

    private void jTextField4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)this.jTextField7.requestFocus();
    }//GEN-LAST:event_jTextField4KeyPressed

    private void jTextField7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)this.jTextField9.requestFocus();
    }//GEN-LAST:event_jTextField7KeyPressed

    private void jTextField9KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)this.jTextField12.requestFocus();
    }//GEN-LAST:event_jTextField9KeyPressed

    private void jTextField12KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField12KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)this.jTextArea1.requestFocus();
    }//GEN-LAST:event_jTextField12KeyPressed
    private void ControlaInstancia(JInternalFrame inter){
        /*
        boolean mostrar=true;
        //String nombre=inter.getTitle();
        for(int a =0;a < Inicio.jDesktopPane1.getComponentCount();a++){
            if(inter.getClass().isInstance(Inicio.jDesktopPane1.getComponent(a))){
                inter.toFront();
                Inicio.jDesktopPane1.moveToFront(inter);
            }
        }
        */
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables

    @Override
    public void internalFrameOpened(InternalFrameEvent ife) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void internalFrameClosing(InternalFrameEvent ife) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void internalFrameClosed(InternalFrameEvent ife) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void internalFrameIconified(InternalFrameEvent ife) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void internalFrameDeiconified(InternalFrameEvent ife) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void internalFrameActivated(InternalFrameEvent ife) {
        System.out.println(" debería recargar los datos acá");
    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent ife) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
