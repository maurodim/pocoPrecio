/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import objetosActualizador.Formularios;
import objetosActualizador.Serial;

/**
 *
 * @author Usuario
 */
public class FormControlador {

    private String serie;
    private String idCpu;
    private String nombre;
    private String razonSocial;
    private String direccion;
    private String telefono;
    private String cuit;
    private int codicionIva;
    private int presupuesto;
    private int facturaElectronica;
    private int idLicencia;

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getIdCpu() {
        return idCpu;
    }

    public void setIdCpu(String idCpu) {
        this.idCpu = idCpu;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public int getCodicionIva() {
        return codicionIva;
    }

    public void setCodicionIva(int codicionIva) {
        this.codicionIva = codicionIva;
    }

    public int getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }

    public int getFacturaElectronica() {
        return facturaElectronica;
    }

    public void setFacturaElectronica(int facturaElectronica) {
        this.facturaElectronica = facturaElectronica;
    }

    public int getIdLicencia() {
        return idLicencia;
    }

    public void setIdLicencia(int idLicencia) {
        this.idLicencia = idLicencia;
    }

    public Integer Enviar(Object objeto) {

        String line = "";
        Formularios formulario=(Formularios) objeto;
        Integer id=0;
        //To handle cookies and therefore get redirected to the site
        //CookieHandler.setDefault(new CookieManager());
        try {
            Serial serial = new Serial();
            String cpu = serial.LeerSerial();
            String data = URLEncoder.encode("serie", "UTF-8") + "=" + URLEncoder.encode(formulario.getSerie(), "UTF-8");
            data += "&" + URLEncoder.encode("cpu", "UTF-8") + "=" + URLEncoder.encode(cpu, "UTF-8");
            data += "&" + URLEncoder.encode("nombre", "UTF-8") + "=" + URLEncoder.encode(formulario.getNombre(), "UTF-8");
            data += "&" + URLEncoder.encode("razon", "UTF-8") + "=" + URLEncoder.encode(formulario.getRazonSocial(), "UTF-8");
            data += "&" + URLEncoder.encode("direccion", "UTF-8") + "=" + URLEncoder.encode(formulario.getDireccion(), "UTF-8");
            data += "&" + URLEncoder.encode("telefono", "UTF-8") + "=" + URLEncoder.encode(formulario.getTelefono(), "UTF-8");
            data += "&" + URLEncoder.encode("mail", "UTF-8") + "=" + URLEncoder.encode(formulario.getMail(), "UTF-8");
            data += "&" + URLEncoder.encode("cuit", "UTF-8") + "=" + URLEncoder.encode(formulario.getCuit(), "UTF-8");
            data += "&" + URLEncoder.encode("brutos", "UTF-8") + "=" + URLEncoder.encode(formulario.getIngBrutos(), "UTF-8");
            data += "&" + URLEncoder.encode("presupuesto", "UTF-8") + "=" + URLEncoder.encode(formulario.getPresupuesto(), "UTF-8");
            data += "&" + URLEncoder.encode("electro", "UTF-8") + "=" + URLEncoder.encode(formulario.getElectronica(), "UTF-8");
            data += "&" + URLEncoder.encode("licencia", "UTF-8") + "=" + URLEncoder.encode(formulario.getLicencia(), "UTF-8");
            data += "&" + URLEncoder.encode("iva", "UTF-8") + "=" + URLEncoder.encode(formulario.getIva(), "UTF-8");

            URL url = new URL("http://www.manantialgestion.com/gestor/alta.php");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
            wr.write(data);
            wr.flush();

            BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String aux;

            while ((aux = rd.readLine()) != null) {
                line += aux;
            }
            System.out.println("retorno " + line);
            id=Integer.parseInt(line);
            if (id > 0) {
                JOptionPane.showMessageDialog(null, "VALIDADO EL EQUIPO!!!! COMIENZA LA INSTALACIÓN");
            }
            wr.close();
            rd.close();
        } catch (MalformedURLException ex) {
            Logger.getLogger(FormControlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FormControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        //We parse Line and find whether password is correct or not
        if (line.indexOf("<div class=\"loginerrors\">") != -1) {
            return id;
        } else {
            return id;
        }

    }
    public Boolean Verificar(String serie){
        String line = "";
        Boolean respuesta=false;
        //To handle cookies and therefore get redirected to the site
        //CookieHandler.setDefault(new CookieManager());
        try {
            Serial serial = new Serial();
            String cpu = serial.LeerSerial();
            String data = URLEncoder.encode("serie", "UTF-8") + "=" + URLEncoder.encode(serie, "UTF-8");
            //data += "&" + URLEncoder.encode("cpu", "UTF-8") + "=" + URLEncoder.encode(cpu, "UTF-8");
            

            URL url = new URL("http://www.manantialgestion.com/gestor/verificar.php");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
            wr.write(data);
            wr.flush();

            BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String aux;

            while ((aux = rd.readLine()) != null) {
                line += aux;
            }
            System.out.println("retorno " + line);
            if (line.equals("ok")) {
                //JOptionPane.showMessageDialog(null, "EXCELENTE!!!!");
                respuesta=true;
            }
            wr.close();
            rd.close();
        } catch (MalformedURLException ex) {
            Logger.getLogger(FormControlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FormControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        //We parse Line and find whether password is correct or not
        return respuesta;
    }

}
