/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import objetosActualizador.Licencias;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author Usuario
 */
public class LicenciasControlador {
    public ArrayList CargarLicencias() throws MalformedURLException, IOException, ParserConfigurationException, SAXException{
        ArrayList <Licencias> lst=new ArrayList();
        URL url=new URL("http://www.manantialgestion.com/gestor/licencias.php");//modificar luego a config.xml
        BufferedReader br=new BufferedReader(new InputStreamReader(url.openStream()));
        String entrada;
        String cadena="";
        
        while((entrada=br.readLine())!=null){
            cadena =cadena + entrada;
        }
        DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
        DocumentBuilder db=dbf.newDocumentBuilder();
        InputSource archivo=new InputSource();
        archivo.setCharacterStream(new StringReader(cadena));
        Document documento=db.parse(archivo);
        documento.getDocumentElement().normalize();
        org.w3c.dom.NodeList nodeLista=documento.getElementsByTagName("coneccion");
        int cantidad=nodeLista.getLength();
        System.out.println("Informacion de conecciones");
        
        for (int s = 0; s < cantidad; s++) {
            
	Node primerNodo = nodeLista.item(s);
	String titulo;
	String autor;
	String hits;
        System.err.println("numero nodo "+s);
        
	if (primerNodo.getNodeType() == Node.ELEMENT_NODE) {

	Element primerElemento = (Element) primerNodo;
        Licencias conf=new Licencias();

	        org.w3c.dom.NodeList primerNombreElementoLista =primerElemento.getElementsByTagName("id");
	Element primerNombreElemento =(Element) primerNombreElementoLista.item(0);
	        org.w3c.dom.NodeList primerNombre = primerNombreElemento.getChildNodes();
	titulo = ((Node) primerNombre.item(0)).getNodeValue().toString();
	System.out.println("ID : "  + titulo);
        conf.setId(Integer.parseInt(titulo));
	        org.w3c.dom.NodeList segundoNombreElementoLista =primerElemento.getElementsByTagName("descripcion");
	Element segundoNombreElemento =(Element) segundoNombreElementoLista.item(0);
	        org.w3c.dom.NodeList segundoNombre = segundoNombreElemento.getChildNodes();

	titulo = ((Node) segundoNombre.item(0)).getNodeValue().toString();
	System.out.println("DESCRIPCION : "  + titulo);
        conf.setDescripcion(titulo);
	        org.w3c.dom.NodeList tercerNombreElementoLista =primerElemento.getElementsByTagName("comprobantes");
	Element tercerNombreElemento =(Element) tercerNombreElementoLista.item(0);
	        org.w3c.dom.NodeList tercerNombre = tercerNombreElemento.getChildNodes();
    	titulo = ((Node) tercerNombre.item(0)).getNodeValue().toString();
	System.out.println("COMPROBAMTES : "  + titulo);
        conf.setCantidadComprobantes(Integer.parseInt(titulo));
        org.w3c.dom.NodeList cuartoNombreElementoLista =primerElemento.getElementsByTagName("fecha");
	Element cuartoNombreElemento =(Element) cuartoNombreElementoLista.item(0);
	        org.w3c.dom.NodeList cuartoNombre = cuartoNombreElemento.getChildNodes();
    	titulo = ((Node) cuartoNombre.item(0)).getNodeValue().toString();
	System.out.println("FECHA : "  + titulo);
        
        org.w3c.dom.NodeList quintoNombreElementoLista =primerElemento.getElementsByTagName("presupuestos");
	Element quintoNombreElemento =(Element) quintoNombreElementoLista.item(0);
	        org.w3c.dom.NodeList quintoNombre = quintoNombreElemento.getChildNodes();
    	titulo = ((Node) quintoNombre.item(0)).getNodeValue().toString();
	System.out.println("COMPROBAMTES : "  + titulo);
        conf.setCantidadPresupuestos(Integer.parseInt(titulo));
        //conf.setCantidadComprobantes(Integer.parseInt(titulo));
        org.w3c.dom.NodeList sextoNombreElementoLista =primerElemento.getElementsByTagName("dias");
	Element sextoNombreElemento =(Element) sextoNombreElementoLista.item(0);
	        org.w3c.dom.NodeList sextoNombre = sextoNombreElemento.getChildNodes();
    	titulo = ((Node) tercerNombre.item(0)).getNodeValue().toString();
	System.out.println("COMPROBAMTES : "  + titulo);
        conf.setCantidadDias(Integer.parseInt(titulo));
        //conf.setCantidadComprobantes(Integer.parseInt(titulo));
        //conf.setClave(clave);
        lst.add(conf);
	}
        }
        
        return lst;
    }
    public DefaultComboBoxModel MostrarCombo(ArrayList listado){
        DefaultComboBoxModel modelo=new DefaultComboBoxModel();
        Iterator it=listado.listIterator();
        Licencias licencia;
        while(it.hasNext()){
            licencia=(Licencias) it.next();
            modelo.addElement(licencia.getDescripcion());
        }
        return modelo;
    }
}
