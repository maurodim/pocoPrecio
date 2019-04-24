/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impresiones.otro;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.MediaSizeName;
import javax.swing.JOptionPane;

/**
 *
 * @author andy
 */
public class ImpresoraManagerImpl implements ImpresoraManager{
    private DocFlavor protocolo;
    private PrintRequestAttributeSet atributos;
    private PrintService[] impresoras;
    private int impresoraSeleccionada;
    

    public ImpresoraManagerImpl() {
        
    }

    private void muestra(){
        //        Andy, la idea es un jar que conecte o envíe la información a una impresora térmica o matriz de punto genérica 
//( ej. epson tmu-200).
//Debería recibir como parámetros:
//-Encabezados (razon social, nombre de fantasía, dirección, teléfono, cuit, ing brutos)
//-Datos comprador(nombre, cond iva, direccion, telefono, cuit)
//
//    Array con detalle de articulos(cod, descripcion, cantidad, monto total)
//    -Totales(subtotal, iva,total)
//    -Código de barra debería ser optativo, se envía el string y el jar que lo genere e incluya
//    -Pie (aquí deberíamos poder enviar 3 strings que se utilicen como renglones del final de comprobante) para ser utilizados para saludo o algún código fiscal que sea necesario
//    Todos éstos valores lo ideal es que sean pasados como string así podemos manejar los formatos en el sistema

        char letra = 'V';
        System.out.println(Integer.toHexString(letra));
   
    }
    
    public void inciailizacionConfiguracionImpresion(){
        // Estableciendo los parametros iniciales.
        protocolo = DocFlavor.INPUT_STREAM.AUTOSENSE;
        atributos = new HashPrintRequestAttributeSet();
        //atributos.add(MediaSizeName.ISO_A4);
    }
    
    public void listarImpresoras(){
        // Servicio de localizacion de impresoras instalada en la pc.
        impresoras = PrintServiceLookup.lookupPrintServices(protocolo, atributos);
        System.out.println("Impresoras Detectadas: "+impresoras.length);
    }
    
    public String ventanaEmergente(String tituloVentana, String mensaje, Object[] listado){
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
     
    public void seleccionarImpresora(String tituloVentana, String mensaje){
        Map<Integer, String> elementos = new HashMap<>();
       
        // Revisando todas las impresoras disponibles
        IntStream.range(0, impresoras.length).forEach(indice ->{
         elementos.put(indice, impresoras[indice].getName());
        });
        
        // Seleecionando impresora de interes
        Optional<String> seleccion = Optional.ofNullable(
                this.ventanaEmergente(
                         tituloVentana,
                         mensaje,
                         elementos.values().toArray()
                )
        );
     
        // Se establece la impresora para el trabajo actual.
        if(seleccion.isPresent()) impresoraSeleccionada = elementos.entrySet()
                                                                   .stream()
                                                                   .filter(z -> z.getValue().equalsIgnoreCase((String)seleccion.get()))
                                                                   .findFirst()
                                                                   .get()
                                                                   .getKey();
        else impresoraSeleccionada = -1; // En caso de que no se seleccione ninguna. Valor por defecto
        
        System.out.println("seleccionada: "+impresoraSeleccionada);
    }
    
    
    public void imprimir(){
         // Imprimiendo solo si hay impresoras instaladas y seleccionada
        if (impresoras.length > 0 && impresoraSeleccionada >=0) {
            
            // Creando un print job para la impresora seleccionada
            DocPrintJob pj = impresoras[impresoraSeleccionada].createPrintJob();
            
            try {
                /* 
                *Create a Doc object to hold the print data.
                * Since the data is postscript located in a disk file,
                * an input stream needs to be obtained
                * BasicDoc is a useful implementation that will if requested
                * close the stream when printing is completed.
                 */
                FileInputStream fis = new FileInputStream("test.ps");
                Doc doc = new SimpleDoc(fis, protocolo, null);
                
                 /* print the doc as specified */
                pj.print(doc, atributos);
                
                /*
                * Do not explicitly call System.exit() when print returns.
                * Printing can be asynchronous so may be executing in a
                * separate thread.
                * If you want to explicitly exit the VM, use a print job 
                * listener to be notified when it is safe to do so.
                 */
                
             } catch (FileNotFoundException | PrintException fe) { 
                 System.out.println("Error de Impresion.");
             }
        }else{
            System.out.println("Impresion Cancelada.");
        }
    }
    
    
     
    @Override
    public void listarImpresorasDisponibles() {
       
    }
    
    public static void main(String[] args){
        ImpresoraManagerImpl impre = new ImpresoraManagerImpl();
        
        impre.inciailizacionConfiguracionImpresion();
        impre.listarImpresoras();
        impre.seleccionarImpresora("Impresoras",  "Seleccione Impresora Thermal");
        impre.imprimir();
        
        
        
    }
    
}
