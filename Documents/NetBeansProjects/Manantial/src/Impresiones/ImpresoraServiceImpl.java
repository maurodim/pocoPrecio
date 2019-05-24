/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impresiones;

import Extension.Archivo;
import Extension.ArchivoImpl;
import Extension.ArchivoPdf;
import Extension.ArchivoPdfImpl;
import Extension.CodigosDeBarra;
import Extension.CodigosDeBarraImpl;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;
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
import javax.print.attribute.Size2DSyntax;
import javax.print.attribute.standard.MediaSize;
import javax.print.attribute.standard.MediaSizeName;
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
        for(PrintService disponibles : impresorasDisponibles){
            System.out.println(" -> "+disponibles.getName());
        }
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
        System.out.println("Predeterminada: "+defaultService.getName());
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
    
    public BufferedImage rotateCw(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage newImage = new BufferedImage(height, width, img.getType());

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                newImage.setRGB(height - 1 - j, i, img.getRGB(i, j));
            }
        }

        return newImage;
    }
    
    public BufferedImage limpiarImagen(BufferedImage img){
        int ancho = img.getWidth();
        int alto = img.getHeight();
        
        BufferedImage limpia = new BufferedImage(ancho, alto, img.getType());
        
        IntStream.range(0, ancho).forEach(px -> {
            IntStream.range(0, alto).forEach(py -> {
                int pixelOriginal = img.getRGB(px, py);
                Color color = new Color(pixelOriginal);
                
                // Analizando umbral
                int nuevoPixel = 0;
                int promedio = (int) ((color.getRed() + color.getGreen() + color.getBlue())/3.0);
                Color escalaGrises = new Color(promedio, promedio, promedio);
                int valor = escalaGrises.getRed();
               // System.out.println("valor:"+escalaGrises.getRed()+"-"+escalaGrises.getGreen()+"-"+escalaGrises.getBlue());
                
              // if(valor > 0)  System.out.println("valor:"+escalaGrises.getRed()+"-"+escalaGrises.getGreen()+"-"+escalaGrises.getBlue());
               
                nuevoPixel = escalaGrises.getRGB();
                 if(valor >= 0 && valor < 100) nuevoPixel = new Color(255,255,255).getRGB(); // blanco
                 else nuevoPixel = new Color(0, 0, 0).getRGB(); // negro
                
                //limpia.setRGB(px, py, escalaGrises.getRGB());
                limpia.setRGB(px, py, nuevoPixel);
                
                //System.out.println("original: "+pixelOriginal+"|promedio: "+promedio+"|grises: "+escalaGrises.getRGB());
               /* 
                original: -1|promedio: 255|grises: -1
                original: -16777216|promedio: 0|grises: -16777216
                */
                
            });
        });
        
        return limpia;
    }

   /**Metodo que permite imprimir un grafico, y posicionando la misma segun los margenes
    @param imagen Grafico que se desea imprimir
    @param margenX Distancia entre la imagen y el margen izquierdo
    @param margenY Distancia entre la imagen y el margen superior 
    */
   private void imprimirGrafico(Image imagen, int margenX, int margenY){
       // Papel de referencia. Se puede modificar
       int anchoPapel = imagen.getWidth(null);//26; // mm, ancho del papel 
       int altoPapel  = imagen.getHeight(null);//37; // mm, alto del papel . 
       
        // Imprimiendo solo si hay impresoras instaladas y seleccionada
        if (impresora != null) {
            // Creando un print job para la impresora seleccionada
            DocPrintJob pj = impresora.createPrintJob();
            
            try {
               
                // Convirtiendo la imagen en un objeto tipo byte entendible por la impresora
                BufferedImage bufferedImage = 
//                                new BufferedImage(imagen.getHeight(null), 
//                                                  imagen.getWidth(null), 
//                                                  BufferedImage.TYPE_INT_RGB);
                                new BufferedImage(anchoPapel,//imagen.getWidth(null) * 2, // Normal
                                                  altoPapel,//imagen.getHeight(null) * 4, 
                                                  BufferedImage.TYPE_INT_RGB);
                
                
                //bufferedImage is the RenderedImage to be written
                Graphics2D g2 = bufferedImage.createGraphics();
                g2.setBackground(Color.WHITE);
              
                g2.clearRect(0, 0, anchoPapel, altoPapel); // Normal
                //g2.clearRect(0, 0, imagen.getHeight(null), imagen.getWidth(null));
              
                
                g2.drawImage(imagen, margenX, margenY, null);
                //g2.drawImage(imagen, 100, 0, imagen.getWidth(null), imagen.getHeight(null), null); // Normal
                
                g2.dispose();
                
                BufferedImage nuevo = this.rotateCw(bufferedImage);
                
//                
                ByteArrayOutputStream outStream = new ByteArrayOutputStream();
                //nuevo = this.limpiarImagen(nuevo);
                ImageIO.write(nuevo, "png", outStream);
                ImageIO.write(nuevo, "png", new File("/home/andy/PDF/grabado.png"));
                
//                ImageIO.write(bufferedImage, "jpg", outStream); // Se agregan artefactos por JPG....perdidas por compresion
//                ImageIO.write(bufferedImage, "jpg", new File("/home/andy/PDF/grabado.jpg"));
                
//                for(byte valor : outStream.toByteArray()){
//                    System.out.println(valor);
//                }


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
   
   private void imprimirGraficoAlternativo(Image imagen, int anchoPapel, int altoPapel, int margenX, int margenY, int anchoEtiqueta, int altoEtiqueta){
      int cantHorizontal = 0;
      int cantVertical = 0;
      int posX = 0;
      int posY = 0;
       
       
        // Imprimiendo solo si hay impresoras instaladas y seleccionada
        if (impresora != null) {
            // Creando un print job para la impresora seleccionada
            DocPrintJob pj = impresora.createPrintJob();
            
            try {
                
                // Convirtiendo la imagen en un objeto tipo byte entendible por la impresora
                BufferedImage bufferedImage = 
                                new BufferedImage(anchoPapel,
                                                  altoPapel,
                                                  BufferedImage.TYPE_INT_RGB);
                
                
                //bufferedImage is the RenderedImage to be written
                Graphics2D g2 = bufferedImage.createGraphics();
                g2.setBackground(Color.WHITE);
              
                g2.clearRect(0, 0, anchoPapel, altoPapel); // Normal
                
                // Condiciones iniciales.
                cantHorizontal = 1;//(int) anchoPapel/anchoEtiqueta;
                cantVertical = (int) altoPapel/altoEtiqueta;
                posX = margenX; 
                
                System.out.println("cant Horizontal: "+cantHorizontal);
                // Pintando la matriz.
                for(int h = 0; h < cantHorizontal; h++){
                    //g2.drawImage(imagen, posX, margenY, anchoEtiqueta, altoEtiqueta, null);
                    g2.drawImage(imagen, posX, posY, null);
                    g2.drawOval(posX, margenY, 1, 1);
                    
                    posX += (2*margenX + anchoEtiqueta);
                }
                
                g2.dispose();
                
                BufferedImage nuevo = this.rotateCw(bufferedImage);
                
//                
                ByteArrayOutputStream outStream = new ByteArrayOutputStream();
                //nuevo = this.limpiarImagen(nuevo);
                ImageIO.write(nuevo, "png", outStream);
                ImageIO.write(nuevo, "png", new File("/home/andy/PDF/grabado.png"));
                
//                ImageIO.write(bufferedImage, "jpg", outStream); // Se agregan artefactos por JPG....perdidas por compresion
//                ImageIO.write(bufferedImage, "jpg", new File("/home/andy/PDF/grabado.jpg"));
                
//                for(byte valor : outStream.toByteArray()){
//                    System.out.println(valor);
//                }


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
   
   private void cargarArchivoPDF(Path rutaArchivoPdf){
     
       // Imprimiendo solo si hay impresoras instaladas y seleccionada
        if (impresora != null) {
            // Creando un print job para la impresora seleccionada
            DocPrintJob pj = impresora.createPrintJob();
            
            try {
                

                FileInputStream is = new FileInputStream(rutaArchivoPdf.toFile());
                System.out.println("Existen? "+Files.exists(rutaArchivoPdf)); 
                // Creando el elemento a imprimir
                Doc doc = new SimpleDoc(is, DocFlavor.INPUT_STREAM.AUTOSENSE, null);
                
                pj.print(doc, atributos);
                
             } catch (PrintException fe) {
                 System.out.println(fe.getMessage()+"\n"+fe.getStackTrace().toString());
                 System.out.println("Error de Impresion.");
             } catch (FileNotFoundException ex) { 
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
    public void imprimirCodigoDeBarra(Image imagen, String serial, int margenX, int margenY) {
        //ancho = 3' =76mm
        //rod paper = 80 x 297 mm
        
        protocolo = DocFlavor.INPUT_STREAM.PNG;
        //protocolo = DocFlavor.SERVICE_FORMATTED.PRINTABLE;
        atributos = new HashPrintRequestAttributeSet(); // Permite establecer que impresoras son capaz de manejar estos atributos
        atributos.add(OrientationRequested.LANDSCAPE);
        //atributos.add(MediaSizeName.ISO_A10); 
        //atributos.add(MediaSize.findMedia(2, 1, Size2DSyntax.INCH)); 
        
        this.listarImpresoras(); // buscando impresoras que cumplan con los requisitos de los atributos
        this.seleccionarImpresoraGUI();
        //this.imprimirGrafico(imagen);
        this.imprimirGrafico(imagen, margenX, margenY);
       
        this.inciailizacionConfiguracionImpresion();
        this.cortarPapel();
        
        // Almacenando en directorio raiz de la aplicacion la imagen
        //archivo.guardarImagenLocal("codigobarra_"+serial+".jpg", imagen);
        
    }
    
    @Override
    public void imprimirCodigoBarraMatriz(Image imagen, int margenX, int margenY){
        protocolo = DocFlavor.INPUT_STREAM.PNG;
        
        atributos = new HashPrintRequestAttributeSet(); // Permite establecer que impresoras son capaz de manejar estos atributos
        atributos.add(OrientationRequested.PORTRAIT);
        //atributos.add(MediaSizeName.ISO_A4); 
        //atributos.add(MediaSize.findMedia(2, 1, Size2DSyntax.INCH)); 
        
        this.listarImpresoras(); // buscando impresoras que cumplan con los requisitos de los atributos
        this.seleccionarImpresoraGUI();
        
        //this.imprimirGrafico(imagen, margenX, margenY);
        this.imprimirGraficoAlternativo(imagen, 210, 297, margenX, margenY, 38, 21);
       
        this.inciailizacionConfiguracionImpresion();
        this.cortarPapel();//506
    
    }
    
    public void imprimirPDF(Path rutaArchivoPDF){
        //protocolo = DocFlavor.INPUT_STREAM.PDF;
        atributos = new HashPrintRequestAttributeSet(); // Permite establecer que impresoras son capaz de manejar estos atributos
        atributos.add(OrientationRequested.PORTRAIT);
        
        this.listarImpresoras(); // buscando impresoras que cumplan con los requisitos de los atributos
        this.seleccionarImpresoraGUI();
        //protocolo = DocFlavor.INPUT_STREAM.PDF;
        this.cargarArchivoPDF(rutaArchivoPDF);
        
    }
    
    public static void main(String[] args){
       //ImpresoraServiceImpl impresoraServicio = new ImpresoraServiceImpl();
       
       /*
        Andy, en cuanto a las impresiones, por favor indicame o documentame como implementar las librerías
        En cuanto a la pantalla de articulosMod, no me genera el codigo de barra, te pasé el error en un texto anterior por workana
       */
        
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
        */
        //------------------ETIQUETA----------------------------------
       
        
            String serialCodigoBarra = "151azucar";
           /* CodigosDeBarra codigosDeBarra = new CodigosDeBarraImpl();
            Image imagen = codigosDeBarra.barraCode128(serialCodigoBarra); // Imagen Original
            //imagen = codigosDeBarra.redimensionar(imagen, 38, 21); // Escalamiento de la imagen (opcional)
            
            // Imagen desde la memoria
           // impresoraServicio.imprimirCodigoDeBarra(imagen, serialCodigoBarra, 0, 0); // imagen, codigo, margen en X, margen en Y
           impresoraServicio.imprimirCodigoBarraMatriz(imagen, 0, 0);*/
        /*
        Archivo archivo = new ArchivoImpl();
        Path rutaArchivo = null;
        try {
            rutaArchivo = archivo.rutaNormalizadaLocal("Etiquetas-"+System.currentTimeMillis()+".pdf");
        } catch (MalformedURLException ex) {
            Logger.getLogger(ImpresoraServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(ImpresoraServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ArchivoPdf apdf = new ArchivoPdfImpl();
        apdf.crearDocumento(10, 10, 20, 0);
        apdf.nombrePdf(rutaArchivo.getFileName().toString(),  rutaArchivo.getParent()); // Ruta raiz del proyecto.
        //apdf.nombrePdf("Etiquetas-"+System.currentTimeMillis()+".pdf", Paths.get("/home/andy/PDF")); // Ejemplo para cualquier otra ruta
        apdf.nuevaEtiqueta("135135456", 5, 0, 0);
        apdf.nuevaEtiqueta("865521548", 25, 0, 0);
        apdf.nuevaEtiqueta("967741213", 30, 0, 0);
        apdf.nuevaEtiqueta("885544771", 15, 0, 0);       
        apdf.generandoGridConEtiquetas(5);
        impresoraServicio.imprimirPDF(apdf.getRutaArchivo());
       
        System.exit(0);
        */
    }

    

    
}
