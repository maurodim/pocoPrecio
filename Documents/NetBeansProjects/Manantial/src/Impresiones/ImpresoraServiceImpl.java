/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impresiones;

import Extension.Archivo;
import Extension.ArchivoImpl;
import Extension.CodigosDeBarra;
import Extension.CodigosDeBarraImpl;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.ServiceUI;
import javax.print.SimpleDoc;
import javax.print.attribute.Attribute;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JOptionPane;

/**
 *
 * @author andy
 */
public class ImpresoraServiceImpl implements Printable, ImpresoraService{
    
    private DocFlavor protocolo;
    private PrintRequestAttributeSet atributos;
    private PrintService[] impresorasDisponibles;
    private PrintService impresora;
    
    private Archivo archivo;
    
    public ImpresoraServiceImpl() {
        archivo = new ArchivoImpl();
    }
    
    @Override
    public int print(Graphics g, PageFormat pf, int page)
            throws PrinterException {
        if (page > 0) {
            /* We have only one page, and 'page' is zero-based */
            return NO_SUCH_PAGE;
        }

        /*
		 * User (0,0) is typically outside the imageable area, so we must
		 * translate by the X and Y values in the PageFormat to avoid clipping
         */
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
        
        /* Now we perform our rendering */
        g.setFont(new Font("Roman", 0, 8));
        

        return PAGE_EXISTS;
    }
    
    private void inciailizacionConfiguracionImpresion(){
        // Estableciendo los parametros iniciales.
        protocolo = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        atributos = new HashPrintRequestAttributeSet();
        //atributos.add(MediaSizeName.ISO_A4);
    }
    
    private void listarImpresoras(){
        // Servicio de localizacion de impresoras instalada en la pc.
        impresorasDisponibles = PrintServiceLookup.lookupPrintServices(protocolo, atributos);
        System.out.println("Impresoras Detectadas: "+impresorasDisponibles.length);
    }
    
    private String ventanaEmergente(String tituloVentana, String mensaje, Object[] listado){
        // Creando la ventana emergente
        String respuesta = (String) 
                JOptionPane.showInputDialog(null, 
                                           mensaje, 
                                           tituloVentana, 
                                           JOptionPane.DEFAULT_OPTION, 
                                           null, 
                                           listado, 
                                           listado[0]);
        
        return respuesta;
    }
    
    /**Este metodo permite en modo grafico seleccionar la impresora de interes */
    private void seleccionarImpresoraGUI(){
        PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
        impresora = ServiceUI.printDialog(null, 700, 200, impresorasDisponibles, defaultService, protocolo, atributos);
       
        if(impresora != null)System.out.println("seleccionada: "+impresora.getName());
        else System.out.println("seleccionada: NINGUNA");
    }
    
    /**Este metodo permite seleccionar la impresora sin despliegue grafico */
    private void seleccionarImpresoraSilenciosa(String nombreImpresora){
    
    }
    
    private void imprimir(String texto){
        // Imprimiendo solo si hay impresoras instaladas y seleccionada
        if (impresora != null) {
            
           // System.out.println("Impresora seleccionada: "+impresoraSeleccionada);
            // Creando un print job para la impresora seleccionada
            DocPrintJob pj = impresora.createPrintJob();
            
            try {
                /* 
                *Create a Doc object to hold the print data.
                * Since the data is postscript located in a disk file,
                * an input stream needs to be obtained
                * BasicDoc is a useful implementation that will if requested
                * close the stream when printing is completed.
                 */
              //  FileInputStream fis = new FileInputStream("test.ps");
              //Doc doc = new SimpleDoc(fis, protocolo, null);
                byte[] conversion;

                // important for umlaut chars
                conversion = texto.getBytes("CP437");

                //Doc doc = new SimpleDoc(bytes, flavor, null);
                Doc doc = new SimpleDoc(conversion, protocolo, null);

                //job.print(doc, null); 
                 /* print the doc as specified */
                pj.print(doc, atributos);
                
                /*
                * Do not explicitly call System.exit() when print returns.
                * Printing can be asynchronous so may be executing in a
                * separate thread.
                * If you want to explicitly exit the VM, use a print job 
                * listener to be notified when it is safe to do so.
                 */
                
             } catch (PrintException fe) { 
                 System.out.println("Error de Impresion.");
             } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(ImpresoraServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            System.out.println("Impresion Cancelada.");
        }
    }
    
   private void imprimirGrafico(Image imagen){
       
        // Imprimiendo solo si hay impresoras instaladas y seleccionada
        if (impresora != null) {
            // Creando un print job para la impresora seleccionada
            DocPrintJob pj = impresora.createPrintJob();
            
            try {
               
                // Convirtiendo la imagen en un objeto tipo byte entendible por la impresora
                BufferedImage bufferedImage = 
                                new BufferedImage(imagen.getWidth(null), 
                                                  imagen.getHeight(null), 
                                                  BufferedImage.TYPE_INT_RGB);
                //bufferedImage.
                
                
                //bufferedImage is the RenderedImage to be written
                //double angulo = 90.0;
                Graphics2D g2 = bufferedImage.createGraphics();
                g2.setBackground(Color.WHITE);
                //g2.setColor(Color.red);
                g2.clearRect(0, 0, imagen.getWidth(null), imagen.getHeight(null));
                
               // g2.rotate(angulo * Math.PI / 180.0,imagen.getWidth(null)/2,imagen.getHeight(null)/2);
                g2.drawImage(imagen, null, null);
                g2.dispose();
                
                ByteArrayOutputStream outStream = new ByteArrayOutputStream();
                ImageIO.write(bufferedImage, "jpg", outStream);
                
                InputStream is = new ByteArrayInputStream(outStream.toByteArray());
                
                // Creando el elemento a imprimir
                Doc doc = new SimpleDoc(is, protocolo, null);

                //job.print(doc, null); 
                 /* print the doc as specified */
                pj.print(doc, atributos);
                
             } catch (PrintException fe) {
                 System.out.println(fe.getMessage()+"\n"+fe.getStackTrace().toString());
                 System.out.println("Error de Impresion.");
             } catch (IOException ex) { 
                Logger.getLogger(ImpresoraServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }else{
            System.out.println("Impresion Cancelada.");
        }
       
   }
    
   public void cortarPapel(){
       ModeloTMU220 tmu220 = new ModeloTMU220();
        //
        // Imprimiendo solo si hay impresoras instaladas y seleccionada
        if (impresora != null) {
            // Creando un print job para la impresora seleccionada
            DocPrintJob pj = impresora.createPrintJob();
            
            try {
                byte[] conversion = tmu220.cmd_SelectCutModeAndCutPaper((byte) 1);

                Doc doc = new SimpleDoc(conversion, protocolo, null);
                pj.print(doc, null);
            
                
             } catch (PrintException fe) { 
                 System.out.println("Error Impresora. No se puede ejecutar la secuencia.");
             }
        }else{
            System.out.println("Impresion Cancelada.");
        }
   }
    
    @Override
    public void imprimirTicket(String texto){
        this.inciailizacionConfiguracionImpresion();
        this.listarImpresoras();
        this.seleccionarImpresoraGUI();
        this.imprimir(texto);
        this.cortarPapel();
    }

    @Override
    public void imprimirCodigoDeBarra(Image imagen, String serial) {
        
        
        protocolo = DocFlavor.INPUT_STREAM.JPEG;
        atributos = new HashPrintRequestAttributeSet();
       // atributos.add(OrientationRequested.PORTRAIT);
        
        
        this.listarImpresoras();
        this.seleccionarImpresoraGUI();
        this.imprimirGrafico(imagen);
       
        this.inciailizacionConfiguracionImpresion();
        this.cortarPapel();
        
        // Almacenando en directorio raiz de la aplicacion la imagen
        archivo.guardarImagenLocal("codigobarra_"+serial+".jpg", imagen);
        
    }
    
    
    
    public static void main(String[] args){
       ImpresoraServiceImpl impresoraServicio = new ImpresoraServiceImpl();
        
        /*
        //-----------------TICKET DE COMPRA-------------------------------
        // Ejemplo para envio de informacion e impresion ticket
        // Creando las instancias
        
        ModeloTicket modeloTicket = new ModeloTicket();
        
        FormatoComerciante formatoComerciante = new FormatoComerciante();
        FormatoCliente formatoCliente = new FormatoCliente();
        List<FormatoArticulos> listaArticulos = new ArrayList();
        FormatoFactura formatoFactura = new FormatoFactura();
        
        // Rellenando cada instancia con los valores de interes
        formatoComerciante.setNombreDelLocal(">> DON PAN <<");
        formatoComerciante.setCuitLocal("33-71495926-9");
        formatoComerciante.setIngresosBrutos("1111111-00");
        formatoComerciante.setTelefono("+5823698745");
        formatoComerciante.setDireccion("Esquina la romana, cruce con negro primero");
        formatoComerciante.setRazonSocial("IVA RESPONSABLE INSCRIPTO");
        
        formatoCliente.setNombreCliente("Leonel Messi");
        formatoCliente.setCuitCliente("30-11111111-2");
        formatoCliente.setCondIva("IVA RESPONSABLE INSCRIPTO");
        formatoCliente.setTelefonoCliente("+58458698745");
        formatoCliente.setDireccionCliente("Urb. Las Flores");
        
        formatoFactura.setIva("21,00 %");
        formatoFactura.setNroFactura("0002-00000094");
        formatoFactura.setTotalSinIva("3615,27");
        formatoFactura.setSubTotal("3615,27");
        formatoFactura.setMontoIva("759,30");
        formatoFactura.setNoGravados("0,00");
        
        formatoFactura.setTotal("4375,02");
        
        formatoFactura.setSuPago("4375,02");
        formatoFactura.setSumaSuPago("4375,02");
        formatoFactura.setSuVuelto("0,00");
        
        listaArticulos.add(new FormatoArticulos("758412", "AZUCAR REFINADA", "5", "35,24"));
        listaArticulos.add(new FormatoArticulos("650402", "COCA COLA DIETA", "1", "45,54"));
        listaArticulos.add(new FormatoArticulos("853472", "PASTA", "3", "5,34"));
        listaArticulos.add(new FormatoArticulos("157462", "SERVILLETAS", "2", "25,89"));
        listaArticulos.add(new FormatoArticulos("253413", "Bombillos", "10", "450,32"));
        
        modeloTicket.setFormatoComerciante(formatoComerciante);
        modeloTicket.setFormatoCliente(formatoCliente);
        modeloTicket.setFormatoFactura(formatoFactura);
        modeloTicket.setArticulos(listaArticulos);
        modeloTicket.setCodigoBarra("9781935182618");
        modeloTicket.setPiePagina("Gracias por tu compra...!!!");
        
       
        // Imprimiendo ticket
        String ticketFull = modeloTicket.procesarTicket(1);
        impresoraServicio.imprimirTicket(ticketFull);
        
        //------------------ETIQUETA----------------------------------
       */
       
        /*
            String serialCodigoBarra = "123456789";
            CodigosDeBarra codigosDeBarra = new CodigosDeBarraImpl();
            Image imagen = codigosDeBarra.barraCode128(serialCodigoBarra);
            imagen = codigosDeBarra.redimensionar(imagen, 100, 30);
            
            // Imagen desde la memoria
            impresoraServicio.imprimirCodigoDeBarra(imagen, serialCodigoBarra);
       */
        System.exit(0);
    }

    
}
