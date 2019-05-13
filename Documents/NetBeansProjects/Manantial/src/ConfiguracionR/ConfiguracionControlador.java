/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConfiguracionR;

import interfaces.Transaccionable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetosR.Conecciones;

/**
 *
 * @author Usuario
 */
public class ConfiguracionControlador {
    public ConfiguracionGeneral CargarConfiguracion(){
        ConfiguracionGeneral confi = null;
        try {
            Transaccionable tra=new Conecciones();
            String sql="select * from configuracion";
            ResultSet rs=tra.leerConjuntoDeRegistros(sql);
            while(rs.next()){
                confi=new ConfiguracionGeneral();
                confi.setArchivoCrt(rs.getString("archivocrt"));
                confi.setArchivoKey(rs.getString("archivokey"));
                confi.setCantidad(rs.getInt("cantidad"));
                confi.setCantidadPresupuestos(rs.getInt("cantidadpresupuestos"));
                confi.setClave(rs.getString("clavemail"));
                confi.setCondicionIva(Integer.parseInt(rs.getString("condicioniva")));
                confi.setCpu(rs.getString("cpu"));
                confi.setDireccion(rs.getString("direccion"));
                confi.setElectronica(rs.getInt("electronica"));
                confi.setIdClienteRemoto(rs.getInt("idclienteremoto"));
                confi.setIdLicencia(rs.getInt("idlicencia"));
                confi.setIngresosBrutos(rs.getString("ingresosbrutos"));
                confi.setInicioActividades(rs.getString("iniciodeactividades"));
                confi.setCuit(rs.getString("cuit"));
                confi.setMail(rs.getString("mail"));
                confi.setNombre(rs.getString("nombre"));
                confi.setPresupuestos(rs.getInt("presupuestos"));
                confi.setPuerto(rs.getInt("puertomail"));
                confi.setPuntoDeVenta(Integer.parseInt(rs.getString("puntodeventa")));
                confi.setRazon(rs.getString("razon"));
                confi.setSerie(rs.getString("serie"));
                confi.setServidor(rs.getString("servidormail"));
                confi.setTelefono(rs.getString("telefono"));
                confi.setTipoDeVenta(Integer.parseInt(rs.getString("tipodeventa")));
                confi.setTiqueadora(rs.getInt("tiqueadora"));
                
                
            }
            rs.close();
        } catch (InstantiationException ex) {
            Logger.getLogger(ConfiguracionControlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ConfiguracionControlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConfiguracionControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return confi;
    }
    public void ActualizarConfiguracion(ConfiguracionGeneral configu){
        ConfiguracionGeneral confi = configu;
        try {
            Transaccionable tra=new Conecciones();
            
            String sql="update configuracion set clavemail='"+confi.getClave()+"',condicioniva='"+String.valueOf(confi.getCondicionIva())+"',direccion='"+confi.getDireccion()+"',electronica="+confi.getElectronica()+",ingresosbrutos='"+confi.getIngresosBrutos()+"',iniciodeactividades='"+confi.getInicioActividades()+"',mail='"+confi.getMail()+"',nombre='"+confi.getNombre()+"',presupuestos="+confi.getPresupuestos()+",puertomail="+confi.getPuerto()+",puntodeventa='"+String.valueOf(confi.getPuntoDeVenta())+"',razon='"+confi.getRazon()+"',servidormail='"+confi.getServidor()+"',telefono='"+confi.getTelefono()+"',tipodeventa='"+String.valueOf(confi.getTipoDeVenta())+"',cuit='"+confi.getCuit()+"' where serie='"+confi.getSerie()+"'";
            tra.leerConjuntoDeRegistros(sql);
                
            
        } catch (InstantiationException ex) {
            Logger.getLogger(ConfiguracionControlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ConfiguracionControlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConfiguracionControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
