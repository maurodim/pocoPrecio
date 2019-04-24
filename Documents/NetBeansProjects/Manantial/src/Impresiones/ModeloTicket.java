/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impresiones;

import Extension.CodigosDeBarraImpl;
import java.awt.Image;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author andy
 */
public class ModeloTicket {
    //Debería recibir como parámetros:
//-Encabezados (razon social, nombre de fantasía, dirección, teléfono, cuit, ing brutos)
//-Datos comprador(nombre, cond iva, direccion, telefono, cuit)
//
//    Array con detalle de articulos(cod, descripcion, cantidad, monto total)
//    -Totales(subtotal, iva,total)
//    -Código de barra debería ser optativo, se envía el string y el jar que lo genere e incluya
//    -Pie (aquí deberíamos poder enviar 3 strings que se utilicen como renglones del final de comprobante) para ser utilizados para saludo o algún código fiscal que sea necesario
//    Todos éstos valores lo ideal es que sean pasados como string así podemos manejar los formatos en el sistema
    
    // Encabezado
    private FormatoComerciante formatoComerciante;
    
    // Datos Comprador
    private FormatoCliente formatoCliente;
    
    // Datos Articulos
    private List<FormatoArticulos> articulos;
    
    // Datos extras de la factura
    private FormatoFactura formatoFactura;
    
    // Codigo de barras
    private String codigoBarra;
    
    // Pie de Pagina
    private String piePagina;

    public FormatoComerciante getFormatoComerciante() {
        return formatoComerciante;
    }

    public void setFormatoComerciante(FormatoComerciante formatoComerciante) {
        this.formatoComerciante = formatoComerciante;
    }

    public FormatoCliente getFormatoCliente() {
        return formatoCliente;
    }

    public void setFormatoCliente(FormatoCliente formatoCliente) {
        this.formatoCliente = formatoCliente;
    }

    public List<FormatoArticulos> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<FormatoArticulos> articulos) {
        this.articulos = articulos;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getPiePagina() {
        return piePagina;
    }

    public void setPiePagina(String piePagina) {
        this.piePagina = piePagina;
    }

    public FormatoFactura getFormatoFactura() {
        return formatoFactura;
    }

    public void setFormatoFactura(FormatoFactura formatoFactura) {
        this.formatoFactura = formatoFactura;
    }
    
     
    
    /**Formato de ticket. com = comerciante; cli = cliente y fact = otro proceso relacionado a la factura  */
    private String formatoTicket1(){
        String contenido = 
        "                $com.local               \n"+
        "                                         \n"+
        "CUIT Nro.: $com.cuit                     \n"+
        "$com.ingresos                            \n"+                        
        "$com.telefono                            \n"+        
        "$com.direccion                           \n"+
        "$com.razon_social                        \n"+
        "=========================================\n"+
        "TIQUE FACTURA          Nro. $fact.nro    \n"+        
        "                       Fecha: $fact.fecha\n"+
        "                       Hora:  $fact.hora \n"+        
        "=========================================\n"+
        "CUIT Nro. $cli.cuit                      \n"+
        "$cli.condIva                             \n"+
        "$cli.cliente                             \n"+    
        "$cli.telefono                            \n"+                
        "$cli.dir                                 \n"+        
        "=========================================\n"+
        "Cant./Precio Unit                        \n"+                
        "Descripcion (%IVA)(%B)            IMPORTE\n"+
        "=========================================\n"+
        "$productos                               \n"+
        "                                         \n"+
        "TOT. NETO SIN IVA              $fact.Niva\n"+        
        "=========================================\n"+        
        "                                         \n"+
        "SUBTOTAL: $fact.iva             $fact.sub\n"+
        "IVA: $fact.iva                 $fact.Miva\n"+
        "CONCEPTO NO GRAVADOS             $fact.ng\n"+
        "                                         \n"+
        "TOTAL                           $fact.tot\n"+        
        "                                         \n"+
        "RECIBI(MOS)                              \n"+        
        "Su pago                        $fact.val1\n"+        
        "Suma de sus pagos              $fact.val2\n"+
        "Su Vuelto                      $fact.val3\n"+
        "                                         \n"+        
        "$fact.pie                                \n"+        
        "\n";
        
        return contenido;
    }
    
    private String adaptarLinea(String texto){
        int longitudHorizontal = 43;
        
        
        return null;
    }
    
    private String estructuracionArticulos(){
        return
        this.articulos.stream()
                      .map(items -> items.getCodigo()+
                                    " "
                                    +items.getDescripcion()+
                                    " X "
                                    +items.getCantidad()+
                                    "     "
                                    +items.getMontoTotal()+
                                    "\n"
                      ).collect(Collectors.joining(""));
        
    }
    
    private Image codigoBarra128(){
        return new CodigosDeBarraImpl().barraCode128(codigoBarra);
    }
    
    private void mostrarCodigoBarra(){
        //----------------
        
        JFrame jf = new JFrame("Codigo Barra");
        JDialog emergente = new JDialog(jf, 
                                        "Codigo Barra", 
                                        true);
       
        ImageIcon visual = new ImageIcon(this.codigoBarra128());
        System.out.println("imagen: "+visual.getIconWidth()+" "+visual.getIconHeight());
       
        JLabel etiqueta = new JLabel(visual);
        
        emergente.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        emergente.setSize(visual.getIconWidth()+50, visual.getIconHeight()+20);
        emergente.setLocationRelativeTo(null);
        emergente.getContentPane().add(etiqueta);
        emergente.setVisible(true);
        //-----------------
        
    }
    
    
    private String procesamiento(String contenido){
       
        contenido = contenido.replace("$com.local", formatoComerciante.getNombreDelLocal());
        contenido = contenido.replace("$com.cuit", formatoComerciante.getCuitLocal());
        contenido = contenido.replace("$com.ingresos", formatoComerciante.getIngresosBrutos());
        contenido = contenido.replace("$com.telefono", formatoComerciante.getTelefono());
        contenido = contenido.replace("$com.direccion", formatoComerciante.getDireccion());        
        contenido = contenido.replace("$com.razon_social", formatoComerciante.getRazonSocial());
        
        contenido = contenido.replace("$fact.nro", formatoFactura.getNroFactura());
        contenido = contenido.replace("$fact.fecha", formatoFactura.getFecha() );
        contenido = contenido.replace("$fact.hora", formatoFactura.getHora());
        contenido = contenido.replace("$fact.iva", formatoFactura.getIva());
        
        contenido = contenido.replace("$cli.cuit", formatoCliente.getCuitCliente());
        contenido = contenido.replace("$cli.condIva", formatoCliente.getCondIva());
        contenido = contenido.replace("$cli.cliente", formatoCliente.getNombreCliente());
        contenido = contenido.replace("$cli.telefono", formatoCliente.getTelefonoCliente());
        contenido = contenido.replace("$cli.dir", formatoCliente.getDireccionCliente());
        
        contenido = contenido.replace("$productos", this.estructuracionArticulos());
       
        contenido = contenido.replace("$fact.Niva", formatoFactura.getTotalSinIva());
        contenido = contenido.replace("$fact.sub", formatoFactura.getSubTotal());
        contenido = contenido.replace("$fact.ng", formatoFactura.getNoGravados());
        contenido = contenido.replace("$fact.Miva", formatoFactura.getMontoIva());
        contenido = contenido.replace("$fact.tot", formatoFactura.getTotal());
        contenido = contenido.replace("$fact.val1", formatoFactura.getSuPago());
        contenido = contenido.replace("$fact.val2", formatoFactura.getSumaSuPago());
        contenido = contenido.replace("$fact.val3", formatoFactura.getSuVuelto());
        contenido = contenido.replace("$fact.pie", this.piePagina);
         
        System.out.println(contenido);
        
         return contenido;
    }
    
    public String procesarTicket(int modelo){
        String procesado = null;
        
        switch(modelo){
            case 1:
                procesado = this.procesamiento(this.formatoTicket1());
                //this.mostrarCodigoBarra();
                break;
                
            default:
                procesado = "Modelo no Valido...!!!";
                break;
        }
    
        return procesado;
    }
    
    
    
}
