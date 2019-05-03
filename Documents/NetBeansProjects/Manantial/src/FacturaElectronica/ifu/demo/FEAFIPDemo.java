/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifu.demo;

import interfaces.FacturableE;
import java.sql.Connection;
import java.text.ParseException;
import java.util.ArrayList;
import objetos.DetalleFacturas;
import objetos.FacturaElectronica;
import objetos.TiposIva;
import objetosConexiones.Conecciones;

/**
 *
 * @author amiranda
 */
public class FEAFIPDemo {

    
    public static void main(String[] args) throws ParseException {
        /*
        FacturableE factu = new FacturaElectronica();

        Connection conexion = null;
        int condicion = 1;//condicion iva vendedor
        String archivoKey = "clave.key";
        String archivoCrt = "certificado.crt";
        int idCliente = 1;
        String cuitCliente = "30538872128";
        int tipoD = 80;//80- cuit 96- dni
        int tipoC = 1; // tipo comprobante segun excel de la tabla
        Double montoT = 142.17;
        Double montoB = 117.50;
        Double montoI = 24.67;
        int ptoVta = 3;
        String cuitVendedor = "20229053834";
        int tVta = 1;//SI ES SERVICIO=2 O PRODUCTO=1
        ArrayList listadoI = new ArrayList();
        ArrayList listadoT = new ArrayList();
        //listadoI=null;
        //listadoT=null;
        String razon = "CONFEDERACION ARGENTINA DE LA MED EMPRESA (CAME)";
        String direc = "L. N. ALEM 452 - 1003 CABA";
        String condicionIvaC = "1";//tipo iva comprador 1-responsable inscripto 4- exento 5-consumidor final
        ArrayList<DetalleFacturas> lstDetalle = new ArrayList();
        DetalleFacturas detalle = new DetalleFacturas();
        for (int a = 0; a < 30; a++) {
            detalle.setCodigo(""+a);
            detalle.setDescripcion("en una prueba "+a);
            detalle.setCantidadS("1.0");
            detalle.setPrecioUnitarioS("100.0");
            detalle.setDescuentoS("12.00");
            lstDetalle.add(detalle);
        }
        //TiposIva iva=new TiposIva(5,50,10.5f,21);
        TiposIva iva=new TiposIva(5,117.50,24.67f,21);
        listadoI.add(iva);
        //iva=new TiposIva(4,50,5.25f,10.5f);
        //listadoI.add(iva);
        //Tributos tributo=new Tributos(2,"IB Santa Fe",100,5,5);
        //listadoT.add(tributo);
        //listadoI = null;
        listadoT = null;
        double cuit = 20229053834.0;
        Integer idPed=1;
        Conecciones conx=new Conecciones();
        conexion=conx.obtenerConexion();
        factu.generar(conexion, condicion, archivoKey, archivoCrt, idCliente, cuitCliente, tipoC, montoT, montoB, montoI, ptoVta, cuitVendedor, tVta, listadoI, listadoT, razon, direc, condicionIvaC, lstDetalle,idPed,"mauro","Bambusoft","resp inscripto","m alberti 1479","4555555","011-31516561611616","01/01/2003");
*/
        
        /*
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        mainFrame.setSize(600, 400);

        factu.solicitarCertificado("20229053834.0");
*/
    }

}
