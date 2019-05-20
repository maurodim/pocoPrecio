/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administracion;

import ConfiguracionR.Propiedades;
import interfaces.Transaccionable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import objetosR.Conecciones;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author Usuario
 */
public class LicenciasControl {
    public Object LeerActualLocal(int idlicencia){
         Licencias licencia2 = new Licencias();
        try {
            Transaccionable tra=new Conecciones();
           
            String sql="select * from licencias where id="+idlicencia;
            System.out.println(sql);
            ResultSet rs=tra.leerConjuntoDeRegistros(sql);
            while(rs.next()){
                //licencia2=new Licencias();
                licencia2.setId(rs.getInt("id"));
                licencia2.setActualFc(rs.getInt("restan"));
                licencia2.setActualPresupuestos(rs.getInt("restanpresupuesto"));
                licencia2.setFechadeVencimiento(rs.getString("vencimiento"));
                licencia2.setCantidadFc(rs.getInt("restan"));
                licencia2.setCantidadPresupuestos(rs.getInt("restanpresupuesto"));
                licencia2.setDiasLicencia(rs.getInt("cantidaddias"));
                System.out.println("vencimiento "+licencia2.getFechadeVencimiento());
            }
            rs.close();
        } catch (InstantiationException | IllegalAccessException | SQLException ex) {
            Logger.getLogger(Licencias.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("vencimiento "+licencia2.getFechadeVencimiento());
        return licencia2;
    }
    public void RestarPresupuesto() {
        try {
            Transaccionable tra = new Conecciones();
            String sql = "update licencias set restanpresupuesto=restanpresupuesto -1 where id="+Propiedades.getIDLICENCIA();
            System.out.println("resta "+sql);
            tra.guardarRegistro(sql);
        } catch (InstantiationException ex) {
            Logger.getLogger(Licencias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Licencias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Licencias.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void RestarFc() {
        try {
            Transaccionable tra = new Conecciones();
            String sql = "update licencias set restan=restan -1 where id="+Propiedades.getIDLICENCIA();
            tra.guardarRegistro(sql);

        } catch (InstantiationException ex) {
            Logger.getLogger(Licencias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Licencias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Licencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void RenovarLicencia(Object licn){
        try {
            Transaccionable tra=new Conecciones();
            Licencias licen=(Licencias) licn;
            String sql="update licencias set cantidad="+licen.getCantidadFc()+",restan="+licen.getCantidadFc()+" - ("+licen.getCantidadFc()+" - restan),presupuestos="+licen.getCantidadPresupuestos()+",restanpresupuesto="+licen.getCantidadPresupuestos()+" - ("+licen.getCantidadPresupuestos()+" - restanpresupuesto),vencimiento='"+licen.getFechadeVencimiento()+"' where id="+licen.getId();
            System.out.println(sql);
            tra.guardarRegistro(sql);
            sql="update configuracion set idlicencia="+licen.getId();
            tra.guardarRegistro(sql);
            
        } catch (InstantiationException ex) {
            Logger.getLogger(Licencias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Licencias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Licencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Licencias> ListarLicencias() throws MalformedURLException, IOException, ParserConfigurationException, SAXException {
        
        
        ArrayList lst = new ArrayList();
        
        try{
        URL url = new URL("http://www.manantialgestion.com/gestor/licencias.php");//modificar luego a config.xml
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        String entrada;
        String cadena = "";

        while ((entrada = br.readLine()) != null) {
            cadena = cadena + entrada;
        }
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        InputSource archivo = new InputSource();
        archivo.setCharacterStream(new StringReader(cadena));
        Document documento = db.parse(archivo);
        documento.getDocumentElement().normalize();
        org.w3c.dom.NodeList nodeLista = documento.getElementsByTagName("coneccion");
        int cantidad = nodeLista.getLength();
        System.out.println("Informacion de conecciones");

        for (int s = 0; s < cantidad; s++) {

            Node primerNodo = nodeLista.item(s);
            String titulo;
            String autor;
            String hits;
            System.err.println("numero nodo " + s);

            if (primerNodo.getNodeType() == Node.ELEMENT_NODE) {

                Element primerElemento = (Element) primerNodo;
                Licencias conf = new Licencias();

                org.w3c.dom.NodeList primerNombreElementoLista = primerElemento.getElementsByTagName("id");
                Element primerNombreElemento = (Element) primerNombreElementoLista.item(0);
                org.w3c.dom.NodeList primerNombre = primerNombreElemento.getChildNodes();
                titulo = ((Node) primerNombre.item(0)).getNodeValue().toString();
                System.out.println("ID : " + titulo);
                conf.setId(Integer.parseInt(titulo));
                org.w3c.dom.NodeList segundoNombreElementoLista = primerElemento.getElementsByTagName("descripcion");
                Element segundoNombreElemento = (Element) segundoNombreElementoLista.item(0);
                org.w3c.dom.NodeList segundoNombre = segundoNombreElemento.getChildNodes();

                titulo = ((Node) segundoNombre.item(0)).getNodeValue().toString();
                System.out.println("DESCRIPCION : " + titulo);
                conf.setDescripcion(titulo);
                org.w3c.dom.NodeList tercerNombreElementoLista = primerElemento.getElementsByTagName("comprobantes");
                Element tercerNombreElemento = (Element) tercerNombreElementoLista.item(0);
                org.w3c.dom.NodeList tercerNombre = tercerNombreElemento.getChildNodes();
                titulo = ((Node) tercerNombre.item(0)).getNodeValue().toString();
                System.out.println("COMPROBAMTES : " + titulo);
                conf.setCantidadFc(Integer.parseInt(titulo));
                org.w3c.dom.NodeList cuartoNombreElementoLista = primerElemento.getElementsByTagName("fecha");
                Element cuartoNombreElemento = (Element) cuartoNombreElementoLista.item(0);
                org.w3c.dom.NodeList cuartoNombre = cuartoNombreElemento.getChildNodes();
                titulo = ((Node) cuartoNombre.item(0)).getNodeValue().toString();
                System.out.println("FECHA : " + titulo);

                org.w3c.dom.NodeList quintoNombreElementoLista = primerElemento.getElementsByTagName("presupuestos");
                Element quintoNombreElemento = (Element) quintoNombreElementoLista.item(0);
                org.w3c.dom.NodeList quintoNombre = quintoNombreElemento.getChildNodes();
                titulo = ((Node) quintoNombre.item(0)).getNodeValue().toString();
                System.out.println("COMPROBAMTES : " + titulo);
                conf.setCantidadPresupuestos(Integer.parseInt(titulo));
                //conf.setCantidadComprobantes(Integer.parseInt(titulo));
                org.w3c.dom.NodeList sextoNombreElementoLista = primerElemento.getElementsByTagName("dias");
                Element sextoNombreElemento = (Element) sextoNombreElementoLista.item(0);
                org.w3c.dom.NodeList sextoNombre = sextoNombreElemento.getChildNodes();
                titulo = ((Node) tercerNombre.item(0)).getNodeValue().toString();
                System.out.println("COMPROBAMTES : " + titulo);
                conf.setDiasLicencia(Integer.parseInt(titulo));
                //conf.setCantidadComprobantes(Integer.parseInt(titulo));
                //conf.setClave(clave);
                lst.add(conf);
            }
        }
        }catch(Exception e){
            System.err.println("excepcion "+e);
        }
        return lst;
    }

    public void ActualizarLicencia(ArrayList lst) {
        try {
            Transaccionable tra=new Conecciones();
            Iterator it=lst.listIterator();
            Licencias licencia;
            String sql;
            while(it.hasNext()){
                licencia=(Licencias) it.next();
                //java.util.Date fechaSql=(Date) Numeros.ConvertirStringEnDate(licencia.getFechadeVencimiento());
                //Date ffecha=Numeros.ConvertirDateADate(fechaSql);
                
                    sql="update licencias set descripcion='"+licencia.getDescripcion()+"',cantidaddias="+licencia.getDiasLicencia()+",cantidad="+licencia.getCantidadFc()+",presupuestos="+licencia.getCantidadPresupuestos()+" where id="+licencia.getId();
                    tra.guardarRegistro(sql);
                
            }
        } catch (InstantiationException ex) {
            Logger.getLogger(Licencias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Licencias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Licencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Object LeerYActualizarLicencia(){
        Licencias conf=null;
        try {
            String direccion="http://www.manantialgestion.com/gestor/cliente.php?id="+Propiedades.getIDREMOTO()+"&cpu="+Propiedades.getCpu();
            URL url = new URL(direccion);//modificar luego a config.xml
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String entrada;
            String cadena = "";
            
            
            while ((entrada = br.readLine()) != null) {
                cadena = cadena + entrada;
            }
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource archivo = new InputSource();
            archivo.setCharacterStream(new StringReader(cadena));
            Document documento = db.parse(archivo);
            documento.getDocumentElement().normalize();
            org.w3c.dom.NodeList nodeLista = documento.getElementsByTagName("coneccion");
            int cantidad = nodeLista.getLength();
            System.out.println("Informacion de conecciones");
            
            for (int s = 0; s < cantidad; s++) {
                
                Node primerNodo = nodeLista.item(s);
                String titulo;
                String autor;
                String hits;
                System.err.println("numero nodo " + s);
                
                if (primerNodo.getNodeType() == Node.ELEMENT_NODE) {
                    
                    Element primerElemento = (Element) primerNodo;
                    conf = new Licencias();
                    
                    org.w3c.dom.NodeList primerNombreElementoLista = primerElemento.getElementsByTagName("idlicencia");
                    Element primerNombreElemento = (Element) primerNombreElementoLista.item(0);
                    org.w3c.dom.NodeList primerNombre = primerNombreElemento.getChildNodes();
                    titulo = ((Node) primerNombre.item(0)).getNodeValue().toString();
                    System.out.println("ID : " + titulo);
                    conf.setId(Integer.parseInt(titulo));
                    org.w3c.dom.NodeList segundoNombreElementoLista = primerElemento.getElementsByTagName("idequipo");
                    Element segundoNombreElemento = (Element) segundoNombreElementoLista.item(0);
                    org.w3c.dom.NodeList segundoNombre = segundoNombreElemento.getChildNodes();
                    
                    titulo = ((Node) segundoNombre.item(0)).getNodeValue().toString();
                    System.out.println("DESCRIPCION : " + titulo);
                    
                    //conf.setDescripcion(titulo);
                    org.w3c.dom.NodeList tercerNombreElementoLista = primerElemento.getElementsByTagName("vencimiento");
                    Element tercerNombreElemento = (Element) tercerNombreElementoLista.item(0);
                    org.w3c.dom.NodeList tercerNombre = tercerNombreElemento.getChildNodes();
                    titulo = ((Node) tercerNombre.item(0)).getNodeValue().toString();
                    System.out.println("COMPROBAMTES : " + titulo);
                    conf.setFechadeVencimiento(titulo);
                    //conf.setCantidadComprobantes(Integer.parseInt(titulo));
                    org.w3c.dom.NodeList cuartoNombreElementoLista = primerElemento.getElementsByTagName("cantidad");
                    Element cuartoNombreElemento = (Element) cuartoNombreElementoLista.item(0);
                    org.w3c.dom.NodeList cuartoNombre = cuartoNombreElemento.getChildNodes();
                    titulo = ((Node) cuartoNombre.item(0)).getNodeValue().toString();
                    System.out.println("FECHA : " + titulo);
                    int canti=Integer.parseInt(titulo);
                    conf.setCantidadFc(canti);
                    org.w3c.dom.NodeList quintoNombreElementoLista = primerElemento.getElementsByTagName("presupuestos");
                    Element quintoNombreElemento = (Element) quintoNombreElementoLista.item(0);
                    org.w3c.dom.NodeList quintoNombre = quintoNombreElemento.getChildNodes();
                    titulo = ((Node) quintoNombre.item(0)).getNodeValue().toString();
                    System.out.println("COMPROBAMTES : " + titulo);
                    conf.setCantidadPresupuestos(Integer.parseInt(titulo));
                    //conf.setCantidadComprobantes(Integer.parseInt(titulo));
                    org.w3c.dom.NodeList sextoNombreElementoLista = primerElemento.getElementsByTagName("dias");
                    Element sextoNombreElemento = (Element) sextoNombreElementoLista.item(0);
                    org.w3c.dom.NodeList sextoNombre = sextoNombreElemento.getChildNodes();
                    titulo = ((Node) sextoNombre.item(0)).getNodeValue().toString();
                    System.out.println("COMPROBAMTES : " + titulo);
                    conf.setDiasLicencia(Integer.parseInt(titulo));
                    //conf.setCantidadComprobantes(Integer.parseInt(titulo));
                    //conf.setClave(clave);
                    //lst.add(conf);
                }
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(Licencias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Licencias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Licencias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(Licencias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conf;
    }
    public void UpdateLicenciaLocal(Object licencia){
        try {
            Transaccionable tra=new Conecciones();
            Licencias licen=(Licencias) licencia;
            String sql="update licencias set cantidad="+licen.getCantidadFc()+",restan="+licen.getCantidadFc()+" - ("+licen.getCantidadFc()+" - restan),presupuestos="+licen.getCantidadPresupuestos()+",restanpresupuesto="+licen.getCantidadPresupuestos()+" - ("+licen.getCantidadPresupuestos()+" - restanpresupuesto),vencimiento='"+licen.getFechadeVencimiento()+"',cantidaddias="+licen.getDiasLicencia()+" where id="+licen.getId();
            System.out.println(sql);
            tra.guardarRegistro(sql);
            sql="update configuracion set idlicencia="+licen.getId();
            tra.guardarRegistro(sql);
            
        } catch (InstantiationException ex) {
            Logger.getLogger(Licencias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Licencias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Licencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
