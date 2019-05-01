/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConfiguracionR;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class PortalWeb {
    private String cuit;
    private String serie;
    private String razonSocial;
    private String cpu;
    private int idLicencia;
    private int cantidadComprobantes;

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getIdLicencia() {
        return idLicencia;
    }

    public void setIdLicencia(int idLicencia) {
        this.idLicencia = idLicencia;
    }

    public int getCantidadComprobantes() {
        return cantidadComprobantes;
    }

    public void setCantidadComprobantes(int cantidadComprobantes) {
        this.cantidadComprobantes = cantidadComprobantes;
    }
    
    public void GenerarCertificadosAfip(){
        String line = "";
        
        try {
            //To handle cookies and therefore get redirected to the site
            //CookieHandler.setDefault(new CookieManager());
            String razon=this.razonSocial.trim();
            razon=razon.replace(" ","_");
            line="http://www.manantialgestion.com/gestor/generadorcsr.php?cuit="+this.cuit+"&razon="+razon+"";
            System.out.println("web "+line);
            Desktop.getDesktop().browse(new URI(line));
        } catch (URISyntaxException ex) {
            Logger.getLogger(PortalWeb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PortalWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
