/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Citi.Excel;

import Citi.objetosDao.FiscalJpaController;
import ConversoresCiti.Numeros;
import Excel.Objetos.ColumnasExcel;
import interfaces.Transaccionable;
import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import javax.swing.JOptionPane;
import objetosCiti.Fiscal;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 *
 * @author mauro di
 */
public class LeerExcel {

    private String sql;
    private Transaccionable tra;
    private ArrayList colmm;
    private Double porc1;
    private int iaa;
    private int ori;
    private Double desc;
    private ConcurrentHashMap listadoArt;

    public void leerExcel1(String fileName) throws SQLException {
        //tra=new ConeccionLocal();
        List cellDataList = new ArrayList();
        colmm = null;
        porc1 = 0.00;
        iaa = 0;
        ori = 0;
        desc = 0.00;
        try {
            /**
             * Create a new instance for FileInputStream class
             */
            FileInputStream fileInputStream = new FileInputStream(fileName);
            /**
             * Create a new instance for POIFSFileSystem class
             */
            POIFSFileSystem fsFileSystem = new POIFSFileSystem(fileInputStream);
            /*
* Create a new instance for HSSFWorkBook Class
             */
            HSSFWorkbook workBook = new HSSFWorkbook(fsFileSystem);
            HSSFSheet hssfSheet = workBook.getSheetAt(0);
            /**
             * Iterate the rows and cells of the spreadsheet to get all the
             * datas.
             */
            Iterator rowIterator = hssfSheet.rowIterator();
            while (rowIterator.hasNext()) {
                HSSFRow hssfRow = (HSSFRow) rowIterator.next();
                Iterator iterator = hssfRow.cellIterator();
                List cellTempList = new ArrayList();
                while (iterator.hasNext()) {
                    HSSFCell hssfCell = (HSSFCell) iterator.next();
                    cellTempList.add(hssfCell);
                }
                cellDataList.add(cellTempList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        /**
         * Call the printToConsole method to print the cell data in the console.
         */
        printToConsole(cellDataList);
    }

    /**
     * This method is used to print the cell data to the console.
     *
     * @param cellDataList - List of the data's in the spreadsheet.
     */
    private void printToConsole(List cellDataList) {
        String error = "";
        ArrayList lstNuevos = new ArrayList();
        ArrayList lstModificador = new ArrayList();
        int fila = 0;
        int fila2=0;
        //DefaultListModel modeloL=new DefaultListModel();
        //ListadoDeProcesos listador=new ListadoDeProcesos();
        //listador.setVisible(true);
        //listador.toFront();
        /*
    Barra barrr=new Barra(null,false);
    barrr.setVisible(true);
    barrr.toFront();
    barrr.jProgressBar1.setMinimum(0);
    barrr.jProgressBar1.setMaximum(100000);
    barrr.jProgressBar1.setVisible(true);
    int progrr=0;
         */
        Boolean verif = false;
        ArrayList lstArt = new ArrayList();
        String unidadDeMedida = "";
        Double peso = 0.00;

        Integer porc = 0;
        String fecha = null;
        Date fechaD = null;
        String comprobante = null;
        String numero = null;
        String puntoDeVenta = null;
        String numeroComprobante = null;
        String cuit = null;
        String nombre = null;
        String tipoComprador = null;
        int tipoClienteId = 0;
        String neto = null;
        String impuesto = null;
        String iva = null;
        String neto2 = null;
        String ib = null;
        String total = null;
        int alicuotaIva = 5;

        Double precio = null;
        Double precio2 = null;
        Double precio3 = null;
        Double precio4 = null;
        Double costo = null;
        int tipoDoc = 99;
        String talle = null;
        int tamaño;
        // String sentencia="insert into articulos (BARRAS,NOMBRE,SERVICIO,COSTO,PRECIO,lista2,lista3,lista4,marca,prov) value ";
        ColumnasExcel col1;
        ColumnasExcel col2;
        ColumnasExcel col3;
        ColumnasExcel col4;
        ColumnasExcel col5;
        ColumnasExcel col6;
        /*
       col1=(ColumnasExcel) colmm.get(0);//codigo
       col2=(ColumnasExcel) colmm.get(1);//descripcion
       col3=(ColumnasExcel) colmm.get(2);//costo
       col4=(ColumnasExcel) colmm.get(3);//precio de venta
       col5=(ColumnasExcel) colmm.get(4);//marca
       col6=(ColumnasExcel) colmm.get(5);//proveedor
         */
 /*
       Articulos arti; 
      Facturar fact=new Articulos();
      Editables edi=new Articulos();
         */
        Fiscal compras;
        FiscalJpaController Ccompras = new FiscalJpaController();

        for (int i = 0; i < cellDataList.size(); i++) {
            List cellTempList = (List) cellDataList.get(i);
            tamaño = 0;
            tamaño = cellTempList.size();
            System.out.println("tamaño " + tamaño + " fila " + i);
            
            if (cellTempList.size() > 20) {
                //progrr++;
                int alerta = 0;
                int j;
                j = 0;
                //j=col1.getId();

                HSSFCell hssfCell = (HSSFCell) cellTempList.get(j);
                String stringCellValue = hssfCell.toString();
                if (stringCellValue != null) {
                    fecha = stringCellValue;

                    if (fecha.equals("FECHA") || fecha.isEmpty()) {

                    } else {
                        fechaD = Numeros.ConvertirStringEnDate(fecha); //System.out.println("fila "+i+" dato "+stringCellValue);
                        if (fechaD != null) {
                            fecha = Numeros.ConvertirFecha(fechaD);
                        }
//fechaD=(Date)fecha;
                    }

                }
                j = 2;
                //j=col1.getId();
                hssfCell = (HSSFCell) cellTempList.get(j);
                stringCellValue = hssfCell.toString();
                if (stringCellValue != null) {
                    comprobante = stringCellValue;
                    if (comprobante.equals("FC A")) {
                        comprobante = "081";
                        //tipoVendedor=1;
                    }
                    if (comprobante.equals("ND A")) {
                        comprobante = "002";
                        //tipoVendedor=1;
                    }
                    if (comprobante.equals("NC A")) {
                        comprobante = "112";
                        //tipoVendedor=1;
                    }
                    if (comprobante.equals("FC B")) {
                        comprobante = "082";
                        //tipoVendedor=4;
                    }
                    if (comprobante.equals("ND B")) {
                        comprobante = "007";
                        //tipoVendedor=4;
                    }
                    if (comprobante.equals("NC B")) {
                        comprobante = "113";
                        //tipoVendedor=4;
                    }

                    //System.out.println("fila "+i+" dato "+stringCellValue);
                }
                j = 3;
                //j=col1.getId();
                hssfCell = (HSSFCell) cellTempList.get(j);
                stringCellValue = hssfCell.toString();
                if (stringCellValue != null) {
                    numero = stringCellValue;
                    int posi = numero.indexOf("-");
                    if (posi > -1) {
                        puntoDeVenta = numero.substring(0, posi);
                        posi++;
                        numeroComprobante = numero.substring(posi);
                       
                    } else {
                        puntoDeVenta = "0";
                        numeroComprobante = "0";
                    }
                }
                //if (tamaño == 10) {
                /*    
                j = 4;
                    //j=col1.getId();
                    hssfCell = (HSSFCell) cellTempList.get(j);
                    stringCellValue = hssfCell.toString();
                    if (stringCellValue != null) {
                        
                            cuit = stringCellValue;
                            if(cuit.length()==11){
                                tipoDoc=80;
                            }else{
                                tipoDoc=99;
                            }

                    }
                 */
                if (tamaño == 26) {
                    j = 4;
                    //j=col1.getId();
                    hssfCell = (HSSFCell) cellTempList.get(j);
                    stringCellValue = hssfCell.toString();
                    if (stringCellValue != null) {

                        cuit = stringCellValue;
                        if (cuit.length() == 11) {
                            tipoDoc = 80;

                        } else {
                            tipoDoc = 99;
                        }

                    }
                    
                    j = 13;
                    //j=col1.getId();
                    hssfCell = (HSSFCell) cellTempList.get(j);
                    stringCellValue = hssfCell.toString();
                    if (stringCellValue != null) {
                        tipoComprador = stringCellValue;
                        if (tipoComprador.equals("CF")) {
                            tipoClienteId = 99;
                        } else {
                            tipoClienteId = 80;
                        }
                        //SI CARGA CUIT ESTE ES EL TIPO DE COMPROBANTE

                    }
                    j = 8;
                    //j=col1.getId();
                    hssfCell = (HSSFCell) cellTempList.get(j);
                    stringCellValue = hssfCell.toString();
                    if (stringCellValue != null) {

                        nombre = stringCellValue;
                        nombre = nombre.replaceAll("[^\\\\dA-Za-z]", "");
                        /*
                    if(nombre.equals("CONSUMIDORFINAL")){
                    }else{
                        JOptionPane.showMessageDialog(null, nombre);
                    }
                         */
                    }
                    
                    
                    j = 14;
                    //j=col1.getId();
                    hssfCell = (HSSFCell) cellTempList.get(j);
                    stringCellValue = hssfCell.toString();
                    if (stringCellValue != null) {
                        neto = stringCellValue;

                    }

                    j = 18;
                    //j=col1.getId();
                    hssfCell = (HSSFCell) cellTempList.get(j);
                    stringCellValue = hssfCell.toString();
                    if (stringCellValue != null) {
                        iva = stringCellValue;
                        //este es el campo iva

                    }

                    j = 23;
                    //j=col1.getId();
                    hssfCell = (HSSFCell) cellTempList.get(j);
                    stringCellValue = hssfCell.toString();
                    if (stringCellValue != null) {
                        total = stringCellValue;
                        //est es campo total

                    }

                }else{

                j = 4;
                //j=col1.getId();
                hssfCell = (HSSFCell) cellTempList.get(j);
                stringCellValue = hssfCell.toString();
                if (stringCellValue != null) {

                    nombre = stringCellValue;
                    nombre = nombre.replaceAll("[^\\\\dA-Za-z]", "");
                    
                    if(nombre.equals("CONSUMIDORFINAL")){
                        nombre="CONSUMIDOR FINAL";
                    }
                     
                }

                j = 9;
                //j=col1.getId();
                hssfCell = (HSSFCell) cellTempList.get(j);
                stringCellValue = hssfCell.toString();
                if (stringCellValue != null) {
                    tipoComprador = stringCellValue;
                    if (tipoComprador.equals("CF")) {
                        tipoClienteId = 99;
                    }

                }

                //si es A o tiene cuit cambia
                j = 10;
                //j=col1.getId();
                hssfCell = (HSSFCell) cellTempList.get(j);
                stringCellValue = hssfCell.toString();
                if (stringCellValue != null) {
                    neto = stringCellValue;

                }
                j = 11;
                //j=col1.getId();
                hssfCell = (HSSFCell) cellTempList.get(j);
                stringCellValue = hssfCell.toString();
                if (stringCellValue != null) {
                    neto2 = stringCellValue;

                }
                j = 12;
                //j=col1.getId();
                hssfCell = (HSSFCell) cellTempList.get(j);
                stringCellValue = hssfCell.toString();
                if (stringCellValue != null) {
                    neto2 = stringCellValue;

                }
                j = 13;
                //j=col1.getId();
                hssfCell = (HSSFCell) cellTempList.get(j);
                stringCellValue = hssfCell.toString();
                if (stringCellValue != null) {
                    tipoComprador = stringCellValue;
                    if (tipoComprador.equals("CF")) {
                        tipoClienteId = 99;
                    }
                    //SI CARGA CUIT ESTE ES EL TIPO DE COMPROBANTE

                }
                j = 14;
                //j=col1.getId();
                hssfCell = (HSSFCell) cellTempList.get(j);
                stringCellValue = hssfCell.toString();
                if (stringCellValue != null) {
                    iva = stringCellValue;

                }

                j = 19;
                //j=col1.getId();
                hssfCell = (HSSFCell) cellTempList.get(j);
                stringCellValue = hssfCell.toString();
                if (stringCellValue != null) {
                    total = stringCellValue;

                }

            }
                if (neto != null) {
                    if (neto.isEmpty()) {
                        precio = 0.00;
                    } else {
                        try {
                            precio = Double.parseDouble(neto);
                        } catch (java.lang.NumberFormatException ep) {
                            precio = 0.00;
                        }
                    }
                }
                if (iva != null) {
                    if (iva.isEmpty()) {
                        precio2 = 0.00;
                    } else {
                        try {
                            precio2 = Double.parseDouble(iva);
                        } catch (java.lang.NumberFormatException e2) {
                            precio2 = 0.00;
                        }
                    }
                }
                if (total != null) {
                    if (total.isEmpty()) {
                        precio3 = 0.00;
                    } else {
                        try {
                            precio3 = Double.parseDouble(total);
                        } catch (java.lang.NumberFormatException e3) {
                            precio3 = 0.00;
                        }
                    }
                }

                //System.out.println("fila " + fila + " fecha " + fecha + " tipo comp " + comprobante + " numero " + puntoDeVenta + "--" + numeroComprobante + " cuit " + cuit + " proveedor " + nombre + " neto " + precio + " neto 2 " + neto2 + " iva " + precio2 + " total " + precio3 + " ing brutos " + precio4 + " impuestos " + costo);
                //barra=null;
                if (nombre.length() > 29) {
                    nombre = nombre.substring(0, 29);
                }
                if (precio3 > 0.00 || precio3 < 0.00) {
                    System.out.println("fila " + fila + " precio 3 " + precio3 + " fecha " + fecha);
                    compras = new Fiscal();
                    compras.setFecha(fecha);

                    compras.setAlicuota(String.valueOf(alicuotaIva));
                    compras.setFechaRegistro(fechaD);
                    compras.setGravado(precio);

                    compras.setImpuesto(precio2);
                    compras.setNumero(numeroComprobante);

                    compras.setPto(puntoDeVenta);

                    compras.setRazon(nombre);
                    compras.setTipo(comprobante);
                    if (cuit != null) {
                        compras.setCuit(cuit);
                    } else {
                        compras.setCuit("0");
                        tipoDoc = 99;
                    }
                    compras.setTipoClienteId(tipoDoc);
                    compras.setTotal(precio3);
                    Ccompras.create(compras);
                    fila2++;
                }

                fila++;
                neto = null;
                iva = null;
                total = null;
                cuit = null;
                ib = null;
                impuesto = null;
                precio = 0.00;
                precio2 = 0.00;
                precio3 = 0.00;
                precio4 = 0.00;
                costo = 0.00;
            }
        }
        //System.err.println(sentencia);

        //barrr.dispose();
        /*
    System.out.println("NUEVO: "+lstNuevos.size()+" MODIFICADOS: "+lstModificador.size());
    GuardarDatosExcel guarda=new GuardarDatosExcel();
    guarda.setLstEdit(lstModificador);
    guarda.setLstNew(lstNuevos);
    guarda.Inicio();
         */
        JOptionPane.showMessageDialog(null, "PROCESO EXITOSO DE IMPORTACIÓN DE VENTAS\n CANTIDAD DE FILAS PROCESADAS " + fila+" REGISTROS GUARDADOS: "+fila2);
    }

    public ArrayList LeerColumnas(String fileName) {
        ArrayList columnas;
        //tra=new ConeccionLocal();
        List cellDataList = new ArrayList();
        try {
            /**
             * Create a new instance for FileInputStream class
             */
            FileInputStream fileInputStream = new FileInputStream(fileName);
            /**
             * Create a new instance for POIFSFileSystem class
             */
            POIFSFileSystem fsFileSystem = new POIFSFileSystem(fileInputStream);
            /*
* Create a new instance for HSSFWorkBook Class
             */
            HSSFWorkbook workBook = new HSSFWorkbook(fsFileSystem);
            HSSFSheet hssfSheet = workBook.getSheetAt(0);
            /**
             * Iterate the rows and cells of the spreadsheet to get all the
             * datas.
             */
            Iterator rowIterator = hssfSheet.rowIterator();
            while (rowIterator.hasNext()) {
                HSSFRow hssfRow = (HSSFRow) rowIterator.next();
                Iterator iterator = hssfRow.cellIterator();
                List cellTempList = new ArrayList();
                while (iterator.hasNext()) {
                    HSSFCell hssfCell = (HSSFCell) iterator.next();
                    cellTempList.add(hssfCell);
                }
                cellDataList.add(cellTempList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        /**
         * Call the printToConsole method to print the cell data in the console.
         */
        columnas = printToConsoleA(cellDataList);
        return columnas;
    }

    private ArrayList printToConsoleA(List cellDataList) {
        String error = "";
        int fila = 0;
        ArrayList<ColumnasExcel> columnas1;
        columnas1 = new ArrayList();
        ColumnasExcel col;
        Boolean verif = false;
        ArrayList lstArt = new ArrayList();
        String unidadDeMedida = "";
        Double peso = 0.00;

        Integer porc = 0;
        String barra = null;
        String descripcion = null;
        String rubro = null;
        String talle1 = null;
        String talle2 = null;
        String talle3 = null;
        String talle4 = null;
        String talle5 = null;
        String talle6 = null;
        String talle7 = null;
        String talle8 = null;
        String talle9 = null;
        Double precio = null;
        Double precio2 = null;
        Double precio3 = null;
        Double precio4 = null;
        Double costo = null;
        String talle = null;
        String sentencia = "insert into articulos (BARRAS,NOMBRE,SERVICIO,COSTO,PRECIO,lista2,lista3,lista4) value ";

        for (int i = 0; i < cellDataList.size(); i++) {
            List cellTempList = (List) cellDataList.get(i);

            int alerta = 0;
            if (i == 0) {
                for (int j = 0; j < cellTempList.size(); j++) {
                    HSSFCell hssfCell = (HSSFCell) cellTempList.get(j);
                    String stringCellValue = hssfCell.toString();
                    //System.err.println("Contenido: "+j+" "+stringCellValue);
                    //descripcion="";
                    //if(i > 0){

                    col = new ColumnasExcel();
                    col.setId(j);
                    col.setContenido(stringCellValue);
                    columnas1.add(col);
                    //System.out.println("CODIGO: "+rubro+barra+talle+" $ "+precio);

                    //}
                    //System.err.println("FINAL");
                    //fac.modificar(cliente);
                }
            }

            //System.out.println(sentencia);
            //System.out.println("  FINAL DE RENGLON");
            barra = null;
            fila++;
        }

        col = new ColumnasExcel();
        col.setId(null);
        col.setContenido("NO SELECCIONADO");
        columnas1.add(col);
        //JOptionPane.showMessageDialog(null,"PROCESO EXITOSO \n CANTIDAD DE FILAS PROCESADAS "+fila);

        return columnas1;
    }
}
