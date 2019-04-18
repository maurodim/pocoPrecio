/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bbsgestion;

import Actualizaciones.BkDeConeccion;
import ConfiguracionR.Propiedades;
import Sucursales.Usuarios;
import interfaceGraficas.Inicio;
import interfaceGraficas.LoguinBbsGestion;
import interfaces.Backpeable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.jvnet.substance.SubstanceLookAndFeel;

/**
 *
 * @author mauro
 */
public class BbsGestion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        /*
        ArrayList usuariosList=new ArrayList();
        Usuarios usuarios=new Usuarios();
        usuariosList=usuarios.listarUsuario();
        */
        try{
           //UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
           JFrame.setDefaultLookAndFeelDecorated(true);
           SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.OfficeSilver2007Skin");
            //UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
            //UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
            //UIManager.setLookAndFeel("ch.randelshofer.quaqua.BasicQuaquaLookAndFeel");
        }catch(Exception e){
            e.printStackTrace();
        }
        File folder=new File("Gestion");
        File archivos=new File("Informes");
        File bases=new File("base14");
        File configuracion=new File("Configuracion");
        //File imagenes=new File("C:\\Gestion\\imagenes\\saynomore.jpg");
        File bk;
        //FileInputStream fregis = new FileInputStream("C:\\Users\\mauro\\Pictures\\Camera Uploads\\snm.jpg"); 
        

        File archivo=null;
        FileReader fr=null;
        BufferedReader br=null;
        if(!bases.isDirectory()){
            JOptionPane.showMessageDialog(null,"INICIANDO CONFIGURACION Y CREACION DE LA BASE DE DATOS");
            //bases.mkdirs();
            //ConeccionLocal.CrearDb();
            
        }
        if(!folder.isDirectory()){
            //System.out.println("EXISTE EL DIRECTORIO");
            folder.mkdirs();
        }else{
            //System.out.println("NOOOOOOOOOOOOOOO EXISTE EL DIRECTORIO");
            
        }
        if(!archivos.isDirectory())archivos.mkdirs();
        if(!configuracion.isDirectory())configuracion.mkdirs();
        /*
        if(!imagenes.isFile()){
            //imagenes.mkdirs();
            FileOutputStream fsalida = new FileOutputStream("C:\\Gestion\\imagenes\\saynomore.jpg", true); 
        int b = fregis.read(); 
        while (b != -1) { 
        fsalida.write(b); 
        b = fregis.read(); 

        } 
        
        fsalida.flush(); 
        fsalida.close();
         
       
            
        }
          
        fregis.close();
        */
        bk=new File("Gestion\\backUp.sql");
        //String sql="select * from movimientoscaja into outfile "+bk+" FIELDS TERMINATED BY ';' OPTIONALLY ENCLOSED BY '\"' LINES TERMINATED BY '\n\r'";
       // Transaccionable tra=null;
       
        //tra.guardarRegistro(sql);
        
        try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         archivo = new File ("Gestion\\erroresDeConeccion.txt");
         if(archivo.exists()){
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);
 
         // Lectura del fichero
         String linea;
          //Transaccionable tra=null;
        
         while((linea=br.readLine())!=null){
             
            //System.out.println(linea);
           
           // if(tra.guardarRegistro(linea));
      }
        }
        }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
         }
          File archivo1=null;
        
         archivo = new File ("Gestion\\idEquipo.txt");
        try {
            
            Propiedades.CargarPropiedades1();
        } catch (ParseException ex) {
            Logger.getLogger(BbsGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /*LoguinBbsGestion lBb=new LoguinBbsGestion();
        lBb.setVisible(true);
        lBb.pack();
*/
        Usuarios usuario=new Usuarios();
        Usuarios usuarios=new Usuarios();
        //try{
        //usuarios=(Usuarios) usuario.validarClave(jTextField1.getText(),new String(jPasswordField1.getPassword()));
        //}catch(Exception ex){
        Backpeable bk1=new BkDeConeccion();
            usuarios=(Usuarios) bk1.leerUsuarios("adm","adm");
        //}
        
        Inicio in=new Inicio(2);
        //Inicio in=new Inicio();
        Inicio.niv=usuarios.getNivelDeAutorizacion();
        Inicio.usuario=usuarios;
        Inicio.sucursal=usuarios.getSucursal();
        Inicio.deposito=Inicio.sucursal.getDepositos();
        in.setTitle(" SISTEMA DE GESTION IMPRENTA eR&Re //   USUARIO : "+Inicio.usuario.getNombre()+" SUCURSAL :"+Inicio.sucursal.getNumero()+" - "+Inicio.sucursal.getDescripcion());
        in.setExtendedState(JFrame.MAXIMIZED_BOTH);
        in.setVisible(true);
        in.toFront();
    }
}
