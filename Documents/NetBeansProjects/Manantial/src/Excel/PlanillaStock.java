/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excel;

import interfaces.Editables;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import Articulos.Articulos;
import interfacesPrograma.Facturar;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.IndexedColors;

/**
 *
 * @author mauro di
 */
public class PlanillaStock {

    public void GenerarInforme(ArrayList listadoClientes) throws SQLException {
        HSSFWorkbook libro = new HSSFWorkbook();
        HSSFSheet hoja = libro.createSheet("Stock de Articulos");
        ArrayList listadoPorSucursal = new ArrayList();
        Facturar edi = new Articulos();

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
        HSSFCell celda9;
        HSSFCell celda10;
        HSSFCell celda11;
        HSSFFont fuente = libro.createFont();
        //fuente.setFontHeight((short)21);
        fuente.setFontName(fuente.FONT_ARIAL);
        fuente.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        String form = null;

        HSSFCellStyle titulo = libro.createCellStyle();
        HSSFCellStyle alerta = libro.createCellStyle();
        //Iterator iCli=listadoClientes.listIterator();
        Articulos cliente = new Articulos();
        titulo.setFont(fuente);
        //titulo.setFillBackgroundColor((short)22);
        titulo.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        titulo.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

        alerta.setFillBackgroundColor(IndexedColors.RED.getIndex());
        alerta.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        HSSFCellStyle celdas = libro.createCellStyle();
        /*
        celdas.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
        celdas.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
        celdas.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
        celdas.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
        celdas.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        celdas.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        celdas.setRightBorderColor(IndexedColors.BLACK.getIndex());
        celdas.setTopBorderColor(IndexedColors.BLACK.getIndex());
         */
        fila = hoja.createRow(0);
                celda = fila.createCell(0);
                celda.setCellStyle(titulo);
                celda.setCellValue("Codigo");
                celda1 = fila.createCell(1);
                celda1.setCellStyle(titulo);
                celda1.setCellValue("Descripcion");
                celda2 = fila.createCell(2);
                celda2.setCellStyle(titulo);
                celda2.setCellValue("Stock Actual");
                celda2 = fila.createCell(3);
                celda2.setCellStyle(titulo);
                celda2.setCellValue("Stock Minimo");
        for (int b = 0; b < listadoClientes.size(); b++) {
            int col = 0;
            int a=b +1;
            
                cliente = (Articulos) listadoClientes.get(b);

                fila = hoja.createRow(a);
                celda = fila.createCell(0);
                ttx = ttx;
                celda.setCellStyle(celdas);
                celda.setCellType(HSSFCell.CELL_TYPE_STRING);
                celda.setCellValue(cliente.getCodigoAsignado());

                celda1 = fila.createCell(1);
                ttx = ttx;
                celda1.setCellStyle(celdas);
                celda1.setCellType(HSSFCell.CELL_TYPE_STRING);
                celda1.setCellValue(cliente.getDescripcionArticulo());

                if (cliente.getStockActual() < cliente.getStockMinimo()) {
                    celda2 = fila.createCell(2);
                    celda2.setCellStyle(alerta);
                    celda2.setCellType(HSSFCell.CELL_TYPE_STRING);
                    celda2.setCellValue(cliente.getStockActual());
                    celda2 = fila.createCell(3);
                    celda2.setCellStyle(alerta);
                    celda2.setCellType(HSSFCell.CELL_TYPE_STRING);
                    celda2.setCellValue(cliente.getStockMinimo());
                } else {
                    celda2 = fila.createCell(2);
                    celda2.setCellStyle(celdas);
                    celda2.setCellType(HSSFCell.CELL_TYPE_STRING);
                    celda2.setCellValue(cliente.getStockActual());
                    celda2 = fila.createCell(3);
                    celda2.setCellStyle(celdas);
                    celda2.setCellType(HSSFCell.CELL_TYPE_STRING);
                    celda2.setCellValue(cliente.getStockMinimo());
                }

            
        }

        String ruta = "Informes\\planillaStock.xls";
        try {
            FileOutputStream elFichero = new FileOutputStream(ruta);
            try {
                libro.write(elFichero);
                elFichero.close();
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + ruta);
            } catch (IOException ex) {
                Logger.getLogger(InformeMensual.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InformeMensual.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
