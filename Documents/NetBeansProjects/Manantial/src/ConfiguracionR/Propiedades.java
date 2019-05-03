/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConfiguracionR;

import interfaces.Transaccionable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import objetosActualizador.Formularios;
import objetosActualizador.Licencias;
import objetosDerby.Base;
import objetosDerby.Configuracion;
import objetosR.Conecciones;



/**
 *
 * @author mauro
 */
public class Propiedades {

    static String SERVER;//"localhost";
    static String BD;//"bbgestion";
    static String USUARIO;//"bambusoft";
    static String CLAVE;//"Bghjiit889210}>";
    static String CREADA;
    static String ARCHIVOBCRT;
    static String ARCHIVOKEY;
    static String PUNTODEVENTA;
    static String CUIT;
    static String ARCHIVOCRT;
    static String CONDICIONIVA;
    static String TIPODEVENTA;
    static String NOMBRECOMERCIO;
    static String DIRECCION;
    static String TELEFONO;
    static String INGBRUTOS;
    static String INICIOACT;

    public static String getNOMBRECOMERCIO() {
        return NOMBRECOMERCIO;
    }

    public static String getDIRECCION() {
        return DIRECCION;
    }

    public static String getTELEFONO() {
        return TELEFONO;
    }

    public static String getINGBRUTOS() {
        return INGBRUTOS;
    }

    public static String getINICIOACT() {
        return INICIOACT;
    }

    public static String getARCHIVOCRT() {
        return ARCHIVOCRT;
    }

    public static String getCONDICIONIVA() {
        return CONDICIONIVA;
    }

    public static String getTIPODEVENTA() {
        return TIPODEVENTA;
    }

    public static String getSERVER() {
        return SERVER;
    }

    public static String getBD() {
        return BD;
    }

    public static String getUSUARIO() {
        return USUARIO;
    }

    public static String getCLAVE() {
        return CLAVE;
    }

    public static String getCREADA() {
        return CREADA;
    }

    public static String getARCHIVOBCRT() {
        return ARCHIVOBCRT;
    }

    public static String getARCHIVOKEY() {
        return ARCHIVOKEY;
    }

    public static String getPUNTODEVENTA() {
        return PUNTODEVENTA;
    }

    public static String getCUIT() {
        return CUIT;
    }

    public static Boolean CargarPropiedades1() throws ParseException, IOException {
        File archivo = new File("base14");
        Properties p = new Properties();
        Boolean resultado = true;
        if (archivo.exists()) {
            try {
                //Process px=Runtime.getRuntime().exec("c:/xampp/xampp_start.exe");
                sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Propiedades.class.getName()).log(Level.SEVERE, null, ex);
            }

            int verificado = 0;
            try {
                
                Transaccionable tra=new Conecciones();
                String sql="select * from configuracion";
                ResultSet rs=tra.leerConjuntoDeRegistros(sql);
                while(rs.next()){
                    
                
                ARCHIVOCRT ="";// rs.getString("archivocrt");
                ARCHIVOKEY ="";// rs.getString("archivokey");
                PUNTODEVENTA ="";// rs.getString("puntodeventa");
                CONDICIONIVA =rs.getString("condicioniva");
                CUIT=rs.getString("cuit");
                TIPODEVENTA = "";//rs.getString("tipodeventa");
                NOMBRECOMERCIO = rs.getString("razon");
                DIRECCION = rs.getString("direccion");
                TELEFONO = rs.getString("telefono");
                INGBRUTOS = "";//rs.getString("ingresosbrutos");
                INICIOACT ="";// rs.getString("iniciodeactividades");
                }
                rs.close();
            } catch (InstantiationException ex) {
                Logger.getLogger(Propiedades.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Propiedades.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Propiedades.class.getName()).log(Level.SEVERE, null, ex);
            }
            return resultado;
        } else {
            /*
             ListadoConfiguracion confi=new ListadoConfiguracion();
             confi.setVisible(true);
             confi.toFront();

             CREADA="1";
             CUIT=confi.jTextField8.getText();
             SERVER=confi.jTextField1.getText();
             BD=confi.jTextField2.getText();
             USUARIO=confi.jTextField3.getText();
             CLAVE=confi.jTextField4.getText();
             ARCHIVOBCRT=confi.jTextField6.getText();
             ARCHIVOKEY=confi.jTextField7.getText();
             PUNTODEVENTA=confi.jTextField5.getText();
             
             
             p.setProperty("CREADA",CREADA);
             p.setProperty("CUIT",CUIT);
             p.setProperty("SERVER",SERVER);
             p.setProperty("BD",BD);
                    
             
             p.setProperty("USUARIO",USUARIO);
             p.setProperty("CLAVE",CLAVE);
             p.setProperty("ARCHIVOBCRT",ARCHIVOBCRT);
             p.setProperty("ARCHIVOKEY",ARCHIVOKEY);
             p.setProperty("PUNTODEVENTA",PUNTODEVENTA);
                        
                    
             
             p.store(new FileWriter("Configuracion\\bbsGestion.properties"),"");
             */
            //CrearDBDerby crear=new CrearDBDerby();
            //ManantialActualizador actualizador=new ManantialActualizador();
            Formulario forma = new Formulario(null, true);
            forma.setVisible(true);
            Formularios formu = new Formularios();
            forma.setLocationRelativeTo(null);
            forma.toFront();
            formu = forma.formulario;
            ArrayList lstLicencias=new ArrayList();
            lstLicencias=forma.listadoL;
            System.out.println("cantidad licencias "+lstLicencias.size()+" datos configuracion "+formu.getNombre());
            Base base = new Base();
            base.CrearBase("base14\\bambuPrueba.db", "mauro", "mauro");
            Connection con=base.ObtenerConexion("base14\\bambuPrueba.db", "mauro", "mauro");
            Configuracion configura=new Configuracion();
            configura.setCpu(formu.getCpu());
            configura.setCuit(formu.getCuit());
            configura.setDireccion(formu.getDireccion());
            configura.setElectronica(formu.getElectronica());
            configura.setIngBrutos(formu.getIngBrutos());
            configura.setIva(formu.getIva());
            configura.setLicencia(formu.getLicencia());
            configura.setMail(formu.getMail());
            configura.setNombre(formu.getNombre());
            configura.setPresupuesto(formu.getPresupuesto());
            configura.setRazonSocial(formu.getRazonSocial());
            configura.setSerie(formu.getSerie());
            configura.setTelefono(formu.getTelefono());
            base.InicializarConfiguracion(con, configura);
            Licencias licencia=null;
            Iterator itL=lstLicencias.listIterator();
            while(itL.hasNext()){
            licencia=(Licencias) itL.next();
                base.InicializarLicencias(con,licencia.getId(),licencia.getDescripcion(),licencia.getCantidadComprobantes());
            
            }
            JOptionPane.showMessageDialog(null, "INSTALACIÓN Y CONFIGURACION FINALIZADAS, POR FAVOR RE INGRESE AL SISTEMA");
            //actualizador.run();
            //Base base=new Base();
            //base.CrearBase("base\\manantial.db", "mauro", "mauro");
            //Runtime jpfBatch=Runtime.getRuntime();
            //jpfBatch.exec("java -jar CrearDBDerby.jar");
            return false;

        }
        //return true;
        //BD="siglox";

    }

}
