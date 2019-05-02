package Etiquetador.Objetos;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;





/**
 *
 * @author hernan
 */
public class ImprimirPedido {

    Font fuente = new Font("Courier", Font.PLAIN, 9);
    Font fuente1=new Font("Courier",Font.BOLD,12);
    Font fuente3 = new Font("Courier", Font.PLAIN, 7);
    Font fuente4 = new Font("Courier", Font.BOLD,7);
    Font fuente5=new Font("Courier",Font.PLAIN,16);
    Font fuente6 = new Font("Courier", Font.BOLD, 9);
    Font fuente7=new Font("Courier", Font.BOLD,7);
    Font fuente8=new Font("Courier",Font.PLAIN,8);
    Font fuente9 = new Font("Courier", Font.BOLD, 5);
    Font fuente10 = new Font("Courier", Font.PLAIN, 6);
    Font fuente11=new Font("Courier",Font.BOLD,11);
    Font fuente12=new Font("Courier",Font.BOLD,14);
    Font fuente13=new Font("Courier",Font.BOLD,16);
	PrintJob pj;	
	Graphics pagina;
	

	/********************************************************************
	*	A continuación el constructor de la clase. Aquí lo único que	*
	*	hago es tomar un objeto de impresion.							*
	********************************************************************/
	public ImprimirPedido()
	{
		pj = Toolkit.getDefaultToolkit().getPrintJob(new Frame(), "SCAT",null);
               
	}
			
	/********************************************************************
	*	A continuación el método "imprimir(String)", el encargado de 	*
	*	colocar en el objeto gráfico la cadena que se le pasa como 		*
	*	parámetro y se imprime.											*
	********************************************************************/
        

    
    public void ImprimirEtiquetaGondola(ArrayList listado,int copias){
        //campos del formato
        String tituloProducto;
        
        // formulario izquierdo
        //new Copies(2);
        int renglon=12;
        int col1=10;
        int col2=20;
        int col3=40;
        int col4=300;
        int col5=80;
        int col6=150;
        Etiqueta etiqueta;
        Iterator it=listado.listIterator();
        int izq=0;
        int items=0;
        int cantItems=0;
        try{
        //BufferedImage imagen= ImageIO.read(new File("C://Gestion//imagen//logo.png"));
        //pagina.drawImage(imagen,63,20,174,93,null);
        
        pagina = pj.getGraphics();
        
        while(it.hasNext()){
            etiqueta=(Etiqueta) it.next();
            
            if(izq==0){
                items=0;
                col1=10;
                col2=20;
                col3=40;
                col4=300;
                col5=80;
                col6=150;
                izq=1;
                cantItems=64;
                if(renglon > 800){
                    pagina.dispose();
                    pagina=pj.getGraphics();
                    renglon=12;
                }
            }else{
                
                renglon=renglon -cantItems; 
                System.out.println("valor derecho renglon :"+renglon+" restar "+cantItems);
                col1=310;
                col2=320;
                col3=340;
                col4=600;
                col5=380;
                col6=450;
                izq=0;
            }
            
            if(etiqueta.getNombre().length() > 30){
                tituloProducto=etiqueta.getNombre().substring(0, 30);
            }else{
                tituloProducto=etiqueta.getNombre();
            }
            pagina.setFont(fuente5);
            pagina.setColor(Color.black);
            pagina.drawLine(col1, renglon, col4, renglon);
            items++;
            renglon=renglon + 16;
            
            pagina.drawString(tituloProducto,col2,renglon);
            items++;
            pagina.setFont(fuente12);
            renglon=renglon+12;
            if(etiqueta.getIncluyeMayorista()){
                pagina.drawString("MAYOR: $ "+etiqueta.getPrecioMayorista(), col5, renglon);
                items++;
                if(etiqueta.getAclaracionMayorista() != null){
                    renglon=renglon + 10;
                    pagina.setFont(fuente);
                    pagina.drawString(etiqueta.getAclaracionMayorista(), col3, renglon);
                    pagina.setFont(fuente1);
                    renglon=renglon + 2;
                    items++;
                    cantItems=cantItems + 12;
                }
                renglon=renglon + 12;
                cantItems=cantItems + 12;
            }
            pagina.setFont(fuente12);
            pagina.drawString("MENOR $ "+etiqueta.getPrecioMinorista(), col5, renglon);
            items++;
                if(etiqueta.getAcalracionMinorista() != null){
                    renglon=renglon + 10;
                    pagina.setFont(fuente);
                    pagina.drawString(etiqueta.getAcalracionMinorista(), col3, renglon);
                    pagina.setFont(fuente1);
                    items++;
                    renglon=renglon + 2;
                    cantItems=cantItems + 12;
                }
                renglon=renglon + 12;
                pagina.setFont(fuente);
                pagina.drawString("COD.: "+etiqueta.getCodigo(), col2, renglon);
                items++;
                renglon=renglon + 12;
                pagina.drawString(etiqueta.getNombreEmpresa(), col6, renglon);
                renglon=renglon + 12;
        }
        
        pagina.dispose();
        pj.end();
        }catch(Exception e)
	{
		System.out.println("LA IMPRESION HA SIDO CANCELADA..."+e);
	}

    }
    
}//FIN DE LA CLASE Impresora

 
