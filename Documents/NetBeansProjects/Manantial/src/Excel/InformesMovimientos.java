/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excel;

import Conversores.Numeros;
import facturacion.clientes.MovimientosClientes;
import interfaces.Transaccionable;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetosR.Conecciones;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.IndexedColors;

/**
 *
 * @author mauro di
 */
public class InformesMovimientos {

    private HSSFCellStyle titulo;
    private HSSFCellStyle titulo1;

    public void GenerarInforme(ArrayList listadoClientes, String nombreCliente) throws SQLException {
        HSSFWorkbook libro = new HSSFWorkbook();
        HSSFSheet hoja = libro.createSheet("Movimientos de Clientes");
        //HSSFSheet hoja1=libro.createSheet("Detalle de Saldos");

        /*
         * GENERAR LAS SIGUIENTES HOJAS
         * 1- DETALLE DE MOVIMIENTOS DE CAJA - LEE EN MOVIMIENTOS CAJA INDENTIFICANDO EL TIPO DE MOVIMIENTO, USUARIOS Y 
         * NUMERO DE CAJA
         * 2- DETALLE DE ARTICULOS VENDIDOS: LISTADO DE MOVIEMIENTOS DE ARTICULOS, CON USUARIOS Y CAJA
         * 3- DETALLE DE GASTOS : MOVIMIENTOS DE CAJA DETALLANDO LOS GASTOS
         * 
         */
        String ttx = "celda numero :";
        HSSFRow fila = null;
        HSSFCell celda;
        HSSFCell celda1;
        HSSFCell celda2;
        HSSFCell celda3;
        HSSFCell celda4;
        HSSFCell celda5;
        HSSFCell celda6;
        HSSFCell celda7;
        HSSFCell celda8;
        HSSFFont fuente = libro.createFont();
        //fuente.setFontHeight((short)21);
        fuente.setFontName(fuente.FONT_ARIAL);
        fuente.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        String form = null;
        String sql = "";
        String saldo = "";
        System.out.println(sql);
        Transaccionable tra = null;
        try {
            tra = new Conecciones();
        } catch (InstantiationException ex) {
            Logger.getLogger(InformesMovimientos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(InformesMovimientos.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs = null;
        titulo1 = libro.createCellStyle();
        titulo = libro.createCellStyle();
        titulo.setFont(fuente);
        //titulo.setFillBackgroundColor((short)22);
        titulo.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        titulo.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        titulo.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        titulo.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        Iterator iCli = listadoClientes.listIterator();
        MovimientosClientes cliente;
        titulo1.setFont(fuente);
        //titulo.setFillBackgroundColor((short)22);
        titulo1.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        titulo1.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        //for(int a=0;a < 100;a++){
        int col = 0;
        int a = 2;
        fila = hoja.createRow(0);
        celda = fila.createCell(0);

        celda1 = fila.createCell(1);

        celda2 = fila.createCell(2);

        celda3 = fila.createCell(3);

        celda4 = fila.createCell(4);
        hoja.addMergedRegion(new CellRangeAddress(0, 1, 0, 10));
        celda.setCellStyle(titulo);
        if (nombreCliente != null) {
            celda.setCellValue(nombreCliente);
        } else {
            celda.setCellValue("Informe de Clientes");
        }
        fila = hoja.createRow(2);
        celda = fila.createCell(0);
        celda.setCellStyle(titulo1);
        celda.setCellValue("Nro.");
        celda1 = fila.createCell(1);
        celda1.setCellStyle(titulo1);
        celda1.setCellValue("fecha");
        celda2 = fila.createCell(2);
        celda2.setCellStyle(titulo1);
        celda2.setCellValue("Monto");
        celda3 = fila.createCell(3);
        celda3.setCellStyle(titulo1);
        celda3.setCellValue("Saldo");
        celda4 = fila.createCell(4);
        celda4.setCellStyle(titulo1);
        celda4.setCellValue("Tipo de Comprobante");

        while (iCli.hasNext()) {
            cliente = (MovimientosClientes) iCli.next();
            a++;
            //col=rs.getInt("tipoMovimiento");
            switch (col) {
                case 1:

                    break;
                default:

                    break;
            }
            fila = hoja.createRow(a);
            celda = fila.createCell(0);
            ttx = ttx;
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellValue(cliente.getNumeroFactura());
            celda1 = fila.createCell(1);
            ttx = ttx;
            celda1.setCellType(HSSFCell.CELL_TYPE_STRING);
            Calendar fecha = Numeros.ConvertirStringEnCalendar(cliente.getFecha());
            String ffchh = Numeros.ConvertirFechaCalendarEnString(fecha);
            celda1.setCellValue(ffchh);
            celda2 = fila.createCell(2);
            celda2.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda2.setCellValue(cliente.getTotal());
            celda3 = fila.createCell(3);
            celda3.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            if (cliente.getEstado() == 1) {
                saldo = "0.00";
            } else {
                saldo = String.valueOf(cliente.getTotal());
            }

            celda3.setCellValue(saldo);
            celda4 = fila.createCell(4);
            celda4.setCellType(HSSFCell.CELL_TYPE_STRING);
            celda4.setCellValue(cliente.getDescripcionTipo());

        }

        //texto+="\r\n";
        String ruta = "Informes//informeDeMovimientoDeClientes.xls";

        try {
            FileOutputStream elFichero = new FileOutputStream(ruta);
            try {
                libro.write(elFichero);
                elFichero.close();
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "Informes\\informeDeMovimientoDeClientes.xls");
            } catch (IOException ex) {
                Logger.getLogger(InformeMensual.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InformeMensual.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
