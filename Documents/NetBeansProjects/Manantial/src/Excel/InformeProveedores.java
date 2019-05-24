/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Excel;

import interfaces.Transaccionable;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetosR.Conecciones;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.IndexedColors;

/**
 *
 * @author mauro
 */
public class InformeProveedores {
    public void GenerarInforme(String desde,String hasta) throws SQLException{
              HSSFWorkbook libro=new HSSFWorkbook();
        //HSSFSheet hoja=libro.createSheet("Resumen");
        //HSSFSheet hoja1=libro.createSheet("Articulos");
        //HSSFSheet hoja2=libro.createSheet("Saldos Proveedores");
        HSSFSheet hoja3=libro.createSheet("Detalle Proveedores");
        /*
         * GENERAR LAS SIGUIENTES HOJAS
         * 1- DETALLE DE MOVIMIENTOS DE CAJA - LEE EN MOVIMIENTOS CAJA INDENTIFICANDO EL TIPO DE MOVIMIENTO, USUARIOS Y 
         * NUMERO DE CAJA
         * 2- DETALLE DE ARTICULOS VENDIDOS: LISTADO DE MOVIEMIENTOS DE ARTICULOS, CON USUARIOS Y CAJA
         * 3- DETALLE DE GASTOS : MOVIMIENTOS DE CAJA DETALLANDO LOS GASTOS
         * 
         */
        
        String ttx="celda numero :";
        HSSFRow fila=null;
        HSSFCell celda;
        HSSFCell celda1;
        HSSFCell celda2;
        HSSFCell celda3;
        HSSFCell celda4;
        HSSFCell celda5;
        HSSFCell celda6;
        HSSFCell celda7;
        HSSFCell celda8;
        HSSFFont fuente=libro.createFont();
        //fuente.setFontHeight((short)21);
        fuente.setFontName(fuente.FONT_ARIAL);
        fuente.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        String form=null;
        String estado;
        String sql="select numeroProveedor,fecha,monto,numeroComprobante,idRemito,tipoComprobante,(select proveedores.nombre from proveedores where proveedores.id=movimientosproveedores.numeroProveedor)as nombreP,(select tipocomprobantes.descripcion from tipocomprobantes where tipocomprobantes.id=movimientosproveedores.tipoComprobante)as comprobante from movimientosproveedores where fecha between '"+desde+" 00:00:00.000' and '"+hasta+" 00:00:00.000' order by numeroProveedor";
        System.out.println(sql);
        Transaccionable tra=null;
        try {
            tra = new Conecciones();
        } catch (InstantiationException ex) {
            Logger.getLogger(InformeProveedores.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(InformeProveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs=tra.leerConjuntoDeRegistros(sql);
        HSSFCellStyle titulo=libro.createCellStyle();
        titulo.setFont(fuente);
        //titulo.setFillBackgroundColor((short)22);
        titulo.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        titulo.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        //for(int a=0;a < 100;a++){
        int col=0;
        int a=0;
            
        if(a==0){
                fila=hoja3.createRow(a);
            celda=fila.createCell(0);
            celda.setCellStyle(titulo);
            celda.setCellValue("Proveedor");
            celda1=fila.createCell(1);
            celda1.setCellStyle(titulo);
            celda1.setCellValue("Fecha");
            celda2=fila.createCell(2);
            celda2.setCellStyle(titulo);
            celda2.setCellValue("Comprobante");
            celda3=fila.createCell(3);
            celda3.setCellStyle(titulo);
            celda3.setCellValue("Monto");
            celda4=fila.createCell(4);
            celda4.setCellStyle(titulo);
            celda4.setCellValue("Comprobante Relacionado");
            }
            while(rs.next()){
            a++;
            //col=rs.getInt("tipoMovimiento");
            switch(col){
                case 1:
                    
                    break;
                default:
                    
                    break;
            }
            fila=hoja3.createRow(a);
            celda=fila.createCell(0);
            ttx=ttx;
            celda.setCellType(HSSFCell.CELL_TYPE_STRING);
            celda.setCellValue(rs.getString("nombreP"));
            celda1=fila.createCell(1);
            ttx=ttx;
            celda1.setCellType(HSSFCell.CELL_TYPE_STRING);
            celda1.setCellValue(" "+rs.getDate("fecha"));
            celda2=fila.createCell(2);
            celda2.setCellType(HSSFCell.CELL_TYPE_STRING);
            celda2.setCellValue(rs.getString("comprobante"));
            celda3=fila.createCell(3);
            celda3.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda3.setCellValue(rs.getDouble("monto"));
            celda4=fila.createCell(4);
            celda4.setCellType(HSSFCell.CELL_TYPE_STRING);
            celda4.setCellValue(rs.getString("numeroComprobante"));
            }
            
          /*
           * segunda hoja
           */  
           /*
            sql="SELECT *,(select articulos.NOMBRE from articulos where articulos.ID=movimientosarticulos.idArticulo)as descripcionArt,(select proveedores.nombre from proveedores where proveedores.numero=numeroCliente)as nombreP,sum(cantidad) as sumaCantidad,sum(precioDeCosto)as costo FROM `movimientosarticulos` where tipoMovimiento=5 and fecha between '"+desde+"' and '"+hasta+"' group by numeroCliente,idArticulo";
            System.out.println(sql);
        //fuente.setFontHeight((short)21);
        fuente.setFontName(fuente.FONT_ARIAL);
        fuente.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        form=null;
        //String sql="SELECT *,(select proveedores.nombre from proveedores where proveedores.numero=movimientosproveedores.numeroProveedor)as nombreP,if(pagado=0,'pendiente','pagado')as estado FROM movimientosproveedores where fecha between '"+desde+"' and '"+hasta+"'";
        //System.out.println(sql);
        //tra=new Conecciones();
        rs=tra.leerConjuntoDeRegistros(sql);
        titulo.setFont(fuente);
        //titulo.setFillBackgroundColor((short)22);
        titulo.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        titulo.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        //for(int a=0;a < 100;a++){
        col=0;
        a=0;
            if(a==0){
                fila=hoja1.createRow(a);
            celda=fila.createCell(0);
            celda.setCellStyle(titulo);
            celda.setCellValue("Proveedor");
            celda1=fila.createCell(1);
            celda1.setCellStyle(titulo);
            celda1.setCellValue("Codigo");
            celda2=fila.createCell(2);
            celda2.setCellStyle(titulo);
            celda2.setCellValue("Descripcion Articulo");
            celda3=fila.createCell(3);
            celda3.setCellStyle(titulo);
            celda3.setCellValue("Monto");
            celda4=fila.createCell(4);
            celda4.setCellStyle(titulo);
            celda4.setCellValue("Cantidad");
            }
            while(rs.next()){
            a++;
            //col=rs.getInt("tipoMovimiento");
            switch(col){
                case 1:
                    
                    break;
                default:
                    
                    break;
            }
            fila=hoja1.createRow(a);
            celda=fila.createCell(0);
            ttx=ttx;
            celda.setCellType(HSSFCell.CELL_TYPE_STRING);
            celda.setCellValue(rs.getString("nombreP"));
            celda1=fila.createCell(1);
            ttx=ttx;
            celda1.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda1.setCellValue(rs.getInt("idArticulo"));
            celda2=fila.createCell(2);
            celda2.setCellType(HSSFCell.CELL_TYPE_STRING);
            celda2.setCellValue(rs.getString("descripcionArt"));
            celda3=fila.createCell(3);
            celda3.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda3.setCellValue(rs.getDouble("costo"));
            celda4=fila.createCell(4);
            celda4.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda4.setCellValue(rs.getDouble("sumaCantidad"));
            
        } 
            */
         /*
           * tercera hoja
           */  
           /*
            sql="select sum(monto)as saldoP,(proveedores.nombre) as nombreP from movimientosproveedores left join proveedores on proveedores.id=movimientosproveedores.numeroproveedor group by movimientosproveedores.numeroproveedor";
            System.out.println(sql);
        //fuente.setFontHeight((short)21);
        fuente.setFontName(fuente.FONT_ARIAL);
        fuente.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        form=null;
        //String sql="SELECT *,(select proveedores.nombre from proveedores where proveedores.numero=movimientosproveedores.numeroProveedor)as nombreP,if(pagado=0,'pendiente','pagado')as estado FROM movimientosproveedores where fecha between '"+desde+"' and '"+hasta+"'";
        //System.out.println(sql);
        //tra=new Conecciones();
        rs=tra.leerConjuntoDeRegistros(sql);
        titulo.setFont(fuente);
        //titulo.setFillBackgroundColor((short)22);
        titulo.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        titulo.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        //for(int a=0;a < 100;a++){
        col=0;
        a=0;
            if(a==0){
                fila=hoja2.createRow(a);
            celda=fila.createCell(0);
            celda.setCellStyle(titulo);
            celda.setCellValue("Proveedor");
            celda1=fila.createCell(1);
            celda1.setCellStyle(titulo);
            celda1.setCellValue("Saldo");
            
            }
            while(rs.next()){
            a++;
            //col=rs.getInt("tipoMovimiento");
            switch(col){
                case 1:
                    
                    break;
                default:
                    
                    break;
            }
            fila=hoja2.createRow(a);
            celda=fila.createCell(0);
            ttx=ttx;
            celda.setCellType(HSSFCell.CELL_TYPE_STRING);
            celda.setCellValue(rs.getString("nombreP"));
            celda1=fila.createCell(1);
            ttx=ttx;
            celda1.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda1.setCellValue(rs.getDouble("saldoP"));
            }
         */
            /*
           * cuarta hoja
           */  
           /*
            sql="select numeroProveedor,fecha,monto,numeroComprobante,idRemito,tipoComprobante,(select proveedores.nombre from proveedores where proveedores.id=movimientosproveedores.numeroProveedor)as nombreP,(select tipocomprobantes.descripcion from tipocomprobantes where tipocomprobantes.id=movimientosproveedores.tipoComprobante)as comprobante from movimientosproveedores where fecha between '"+desde+" 00:00:00.000' and '"+hasta+" 00:00:00.000' order by numeroProveedor";
            System.out.println(sql);
        //fuente.setFontHeight((short)21);
        fuente.setFontName(fuente.FONT_ARIAL);
        fuente.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        form=null;
        //String sql="SELECT *,(select proveedores.nombre from proveedores where proveedores.numero=movimientosproveedores.numeroProveedor)as nombreP,if(pagado=0,'pendiente','pagado')as estado FROM movimientosproveedores where fecha between '"+desde+"' and '"+hasta+"'";
        //System.out.println(sql);
        //tra=new Conecciones();
        rs=tra.leerConjuntoDeRegistros(sql);
        titulo.setFont(fuente);
        //titulo.setFillBackgroundColor((short)22);
        titulo.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        titulo.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        //for(int a=0;a < 100;a++){
        col=0;
        a=0;
            if(a==0){
                fila=hoja3.createRow(a);
            celda=fila.createCell(0);
            celda.setCellStyle(titulo);
            celda.setCellValue("Proveedor");
            celda1=fila.createCell(1);
            celda1.setCellStyle(titulo);
            celda1.setCellValue("Fecha");
            celda2=fila.createCell(2);
            celda2.setCellStyle(titulo);
            celda2.setCellValue("Comprobante");
            celda3=fila.createCell(3);
            celda3.setCellStyle(titulo);
            celda3.setCellValue("Monto");
            celda4=fila.createCell(4);
            celda4.setCellStyle(titulo);
            celda4.setCellValue("Comprobante Relacionado");
            }
            while(rs.next()){
            a++;
            //col=rs.getInt("tipoMovimiento");
            switch(col){
                case 1:
                    
                    break;
                default:
                    
                    break;
            }
            fila=hoja3.createRow(a);
            celda=fila.createCell(0);
            ttx=ttx;
            celda.setCellType(HSSFCell.CELL_TYPE_STRING);
            celda.setCellValue(rs.getString("nombreP"));
            celda1=fila.createCell(1);
            ttx=ttx;
            celda1.setCellType(HSSFCell.CELL_TYPE_STRING);
            celda1.setCellValue(" "+rs.getDate("fecha"));
            celda2=fila.createCell(2);
            celda2.setCellType(HSSFCell.CELL_TYPE_STRING);
            celda2.setCellValue(rs.getString("comprobante"));
            celda3=fila.createCell(3);
            celda3.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda3.setCellValue(rs.getDouble("monto"));
            celda4=fila.createCell(4);
            celda4.setCellType(HSSFCell.CELL_TYPE_STRING);
            celda4.setCellValue(rs.getString("numeroComprobante"));
            }
            */
        rs.close();
        //texto+="\r\n";
        String ruta="Informes//informePorProveedor.xls";
        try {
            FileOutputStream elFichero=new FileOutputStream(ruta);
            try {
                libro.write(elFichero);
                elFichero.close();
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"Informes\\informePorProveedor.xls");
            } catch (IOException ex) {
                Logger.getLogger(InformeMensual.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InformeMensual.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
