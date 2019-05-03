/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excel;

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
import objetosCiti.Comprasfiscal;
import objetosDao.ComprasfiscalJpaController;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 *
 * @author mauro di
 */
public class LeerExcelCompras {

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
       
        Boolean verif = false;
        ArrayList lstArt = new ArrayList();
        String unidadDeMedida = "";
        Double peso = 0.00;

        Integer porc = 0;
        String fecha = null;
        Date fechaD = null;
        //Date fechaRegistro=null;
        String comprobante = null;
        String numero = null;
        String numeroComprobante=null;
        String cuit = null;
        String nombre = null;
        String neto = null;
        String impuesto = null;
        String impuesto2=null;
        String iva = null;
        String neto2 = null;
        String ib = null;
        String total = null;
        String noGravado=null;
        int alicuotaIva = 3;
        int cantidadAlicuota=0;
        int tipoVendedor=1;
        Double precio = null;
        Double precio2 = null;
        Double precio3 = null;
        Double precio4 = null;
        Double costo = null;
        Double costo2=0.00;
        Double nGrav=0.00;
        String puntoDeVenta = null;
        int tamaño;
        // String sentencia="insert into articulos (BARRAS,NOMBRE,SERVICIO,COSTO,PRECIO,lista2,lista3,lista4,marca,prov) value ";
        ColumnasExcel col1;
        ColumnasExcel col2;
        ColumnasExcel col3;
        ColumnasExcel col4;
        ColumnasExcel col5;
        ColumnasExcel col6;
       Comprasfiscal compras;
       ComprasfiscalJpaController Cfiscal=new ComprasfiscalJpaController();
        for (int i = 0; i < cellDataList.size(); i++) {
            List cellTempList = (List) cellDataList.get(i);
            tamaño = 0;
            tamaño = cellTempList.size();
            System.out.println("tamaño " + tamaño);
            if (cellTempList.size() > 14) {
                //progrr++;
                int alerta = 0;
                int j;
                j = 0;
                //j=col1.getId();

                HSSFCell hssfCell = (HSSFCell) cellTempList.get(j);
                String stringCellValue = hssfCell.toString();
                if (stringCellValue != null) {
                    fecha = stringCellValue;
                    
                    if(fecha.equals("FECHA") || fecha.isEmpty()){
                        
                    }else{
                    fechaD = Numeros.ConvertirStringEnDate(fecha); //System.out.println("fila "+i+" dato "+stringCellValue);
                    if(fechaD != null){
                        fecha=Numeros.ConvertirFecha(fechaD);
                    }else{
                        fecha="--";
                    }
//fechaD=(Date)fecha;
                    }
                     
                }
                j = 1;
                //j=col1.getId();
                hssfCell = (HSSFCell) cellTempList.get(j);
                stringCellValue = hssfCell.toString();
                if (stringCellValue != null) {
                    comprobante = stringCellValue;
                    if(comprobante.equals("FC A")){
                        comprobante="001";
                        tipoVendedor=1;
                    }
                    if(comprobante.equals("ND A")){
                        comprobante="002";
                        tipoVendedor=1;
                    }
                    if(comprobante.equals("NC A")){
                        comprobante="003";
                        tipoVendedor=1;
                    }
                    if(comprobante.equals("FC B")){
                        comprobante="006";
                        tipoVendedor=4;
                    }
                    if(comprobante.equals("ND B")){
                        comprobante="007";
                        tipoVendedor=4;
                    }
                    if(comprobante.equals("NC B")){
                        comprobante="008";
                        tipoVendedor=4;
                    }
                    if(comprobante.equals("FC C")){
                        comprobante="011";
                        tipoVendedor=6;
                    }
                    if(comprobante.equals("ND C")){
                        comprobante="012";
                        tipoVendedor=6;
                    }
                    if(comprobante.equals("NC C")){
                        comprobante="013";
                        tipoVendedor=6;
                    }
                    if(comprobante.equals("FC M")){
                        comprobante="051";
                        tipoVendedor=1;
                    }
                    if(comprobante.equals("ND M")){
                        comprobante="052";
                        tipoVendedor=1;
                    }
                    if(comprobante.equals("NC M")){
                        comprobante="053";
                        tipoVendedor=1;
                    }
                    
                    //System.out.println("fila "+i+" dato "+stringCellValue);
                }
                j = 2;
                //j=col1.getId();
                hssfCell = (HSSFCell) cellTempList.get(j);
                stringCellValue = hssfCell.toString();
                if (stringCellValue != null) {
                    numero = stringCellValue;
                    int posi=numero.indexOf("-");
                    if(posi > -1){
                    puntoDeVenta=numero.substring(0,posi);
                    posi++;
                    numeroComprobante=numero.substring(posi);
                    }else{
                        puntoDeVenta="0";
                        numeroComprobante="0";
                    }

                }
                j = 3;
                //j=col1.getId();
                hssfCell = (HSSFCell) cellTempList.get(j);
                stringCellValue = hssfCell.toString();
                if (stringCellValue != null) {
                    cuit = stringCellValue;
                    
                }
                j = 8;
                //j=col1.getId();
                hssfCell = (HSSFCell) cellTempList.get(j);
                stringCellValue = hssfCell.toString();
                if (stringCellValue != null) {
                    nombre = stringCellValue;
                    if(nombre.length() > 29){
                        nombre=nombre.substring(0,29);
                    }
                }

                j = 12;
                //j=col1.getId();
                hssfCell = (HSSFCell) cellTempList.get(j);
                stringCellValue = hssfCell.toString();
                if (stringCellValue != null) {
                    neto = stringCellValue;

                }
                switch (tamaño) {
                    case 16:
                        j = 13;
                        //j=col1.getId();
                        hssfCell = (HSSFCell) cellTempList.get(j);
                        stringCellValue = hssfCell.toString();
                        if (stringCellValue != null) {
                            iva = stringCellValue;

                        }

                        j = 15;
                        //j=col1.getId();
                        hssfCell = (HSSFCell) cellTempList.get(j);
                        stringCellValue = hssfCell.toString();
                        if (stringCellValue != null) {
                            total = stringCellValue;

                        }
                        break;
                    case 15:
                        j = 13;
                        //j=col1.getId();
                        hssfCell = (HSSFCell) cellTempList.get(j);
                        stringCellValue = hssfCell.toString();
                        if (stringCellValue != null) {
                            iva = stringCellValue;
                            iva = "0.00";

                        }

                        j = 14;
                        //j=col1.getId();
                        hssfCell = (HSSFCell) cellTempList.get(j);
                        stringCellValue = hssfCell.toString();
                        if (stringCellValue != null) {
                            total = stringCellValue;

                        }
                        break;
                    case 17:
                        j = 13;
                        //j=col1.getId();
                        hssfCell = (HSSFCell) cellTempList.get(j);
                        stringCellValue = hssfCell.toString();
                        if (stringCellValue != null) {
                            iva = stringCellValue;

                        }
                        j = 15;
                        //j=col1.getId();
                        hssfCell = (HSSFCell) cellTempList.get(j);
                        stringCellValue = hssfCell.toString();
                        if (stringCellValue != null) {
                            ib = stringCellValue;

                        }
                        j = 16;
                        //j=col1.getId();
                        hssfCell = (HSSFCell) cellTempList.get(j);
                        stringCellValue = hssfCell.toString();
                        if (stringCellValue != null) {
                            total = stringCellValue;

                        }
                        break;
                    case 18:
                        j = 13;
                        //j=col1.getId();
                        hssfCell = (HSSFCell) cellTempList.get(j);
                        stringCellValue = hssfCell.toString();
                        if (stringCellValue != null) {
                            iva = stringCellValue;

                        }
                        j = 15;
                        //j=col1.getId();
                        hssfCell = (HSSFCell) cellTempList.get(j);
                        stringCellValue = hssfCell.toString();
                        if (stringCellValue != null) {
                            impuesto = stringCellValue;

                        }
                        j = 16;
                        //j=col1.getId();
                        hssfCell = (HSSFCell) cellTempList.get(j);
                        stringCellValue = hssfCell.toString();
                        if (stringCellValue != null) {
                            ib = stringCellValue;

                        }
                        j = 17;
                        //j=col1.getId();
                        hssfCell = (HSSFCell) cellTempList.get(j);
                        stringCellValue = hssfCell.toString();
                        if (stringCellValue != null) {
                            total = stringCellValue;

                        }
                        break;
                    case 19:
                        j = 15;
                        //j=col1.getId();
                        hssfCell = (HSSFCell) cellTempList.get(j);
                        stringCellValue = hssfCell.toString();
                        if (stringCellValue != null) {
                            iva = stringCellValue;

                        }
                        
                        j = 13;
                        //j=col1.getId();
                        hssfCell = (HSSFCell) cellTempList.get(j);
                        stringCellValue = hssfCell.toString();
                        if (stringCellValue != null) {
                            if(neto.equals("")){
                                impuesto = stringCellValue;
                            }else{
                                noGravado = stringCellValue;
                            }

                        }
                        j = 16;
                        //j=col1.getId();
                        hssfCell = (HSSFCell) cellTempList.get(j);
                        stringCellValue = hssfCell.toString();
                        if (stringCellValue != null) {
                            impuesto = stringCellValue;
                            
                        }
                        j = 17;
                        //j=col1.getId();
                        hssfCell = (HSSFCell) cellTempList.get(j);
                        stringCellValue = hssfCell.toString();
                        if (stringCellValue != null) {
                            ib = stringCellValue;

                        }
                        j = 18;
                        //j=col1.getId();
                        hssfCell = (HSSFCell) cellTempList.get(j);
                        stringCellValue = hssfCell.toString();
                        if (stringCellValue != null) {
                            total = stringCellValue;

                        }
                        break;
                }

                
                
                if (neto != null) {
                    if (neto.isEmpty()) {
                        precio = 0.00;
                    } else {
                        try{
                        precio = Double.parseDouble(neto);
                        }catch(java.lang.NumberFormatException ep){
                            precio=0.00;
                        }
                    }
                }
                if (iva != null) {
                    if (iva.isEmpty()) {
                        precio2 = 0.00;
                        cantidadAlicuota=0;
                    } else {
                        try{
                        precio2 = Double.parseDouble(iva);
                        }catch(java.lang.NumberFormatException e2){
                            precio2=0.00;
                            cantidadAlicuota=0;
                        }
                        if(precio2 > 0.00){
                           Double tasa=precio2 / precio;
                           tasa=Math.round(tasa * 1000.0) / 1000.0;
                           if(tasa == 0.105)alicuotaIva=4;
                           if(tasa == 0.210)alicuotaIva=5;
                           if(tasa == 0.270)alicuotaIva=6;
                           cantidadAlicuota=1;
                        }
                    }
                }
                if (total != null) {
                    if (total.isEmpty()) {
                        precio3 = 0.00;
                    } else {
                        try{
                        precio3 = Double.parseDouble(total);
                        }catch(java.lang.NumberFormatException e3){
                            precio3=0.00;
                        }
                    }
                }else{
                    precio3=0.00;
                }
                if(precio3 > 0 && fecha.length() > 5){
                    System.out.println("fila "+fila+" precio 3 "+precio3+" fecha "+fecha);
                    compras=new Comprasfiscal();
                compras.setFecha(fecha);
                if (ib != null) {
                    if (ib.isEmpty()) {
                        precio4 = 0.00;
                    } else {
                        try{
                            
                            precio4 = Double.parseDouble(ib);
                            //precio4=precio4 + costo2;
                        }catch(java.lang.NumberFormatException e4){
                            precio4=0.00;
                        }
                    }
                    compras.setPercepcionib(precio4);
                }
                if (impuesto != null) {
                    if (impuesto.isEmpty()) {
                        costo = 0.00;
                    } else {
                       
                        costo = Double.parseDouble(impuesto);
                        
                    }
                    compras.setImpinternos(costo);
                }
                if (noGravado != null) {
                    if (noGravado.isEmpty()) {
                        nGrav = 0.00;
                    } else {
                       
                        nGrav = Double.parseDouble(noGravado);
                        
                    }
                    compras.setNetonogravado(nGrav);
                }
                
                compras.setAlicuota(String.valueOf(alicuotaIva));
                compras.setFechaRegistro(fechaD);
                compras.setGravado(precio);
                if(precio2 == 0.0)cantidadAlicuota=0;
                compras.setIva(precio2);
                compras.setNumero(numeroComprobante);
                //if(cantidadAlicuota==0)cantidadAlicuota=1;
                compras.setCantidadalicuotaiva((short) cantidadAlicuota);
                compras.setPto(puntoDeVenta);
                compras.setRazon(nombre);
                compras.setTipo(comprobante);
                compras.setCuit(cuit);
                compras.setTipoClienteId(tipoVendedor);
                compras.setTotal(precio3);
                Cfiscal.create(compras);
                
                }
//citi=new CitiCompras(fecha,)
                //if(fisca.Nuevo(citi))System.out.println("guardado "+fila);;
                //System.out.println("fila " + fila + " fecha " + fecha + " tipo comp " + comprobante + " numero " + numero + " cuit " + cuit + " proveedor " + nombre + " neto " + precio + " neto 2 " + neto2 + " iva " + precio2 + " total " + precio3 + " ing brutos " + precio4 + " impuestos " + costo);
                //barra=null;
                fila++;
                neto = null;
                iva = null;
                total = null;
                ib = null;
                impuesto = null;
                impuesto2=null;
                noGravado=null;
                precio = 0.00;
                precio2 = 0.00;
                precio3 = 0.00;
                precio4 = 0.00;
                costo = 0.00;
                costo2=0.00;
                nGrav=0.00;
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
        JOptionPane.showMessageDialog(null, "PROCESO EXITOSO DE IMPORTACIÓN DE COMPRAS\n CANTIDAD DE FILAS PROCESADAS " + fila);
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
        ArrayList columnas1 = new ArrayList();
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
