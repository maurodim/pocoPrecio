/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Citi.objetosDao;

import interfaces.Transaccionable;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import objetosCiti.Fiscal;
import objetosR.Conecciones;


/**
 *
 * @author Usuario
 */
public class FiscalJpaController implements Serializable {
    private Transaccionable tra;
    public FiscalJpaController() {
        try {
            //this.emf = Persistence.createEntityManagerFactory("GeneradorCitiPU");
            tra=new Conecciones();
        } catch (InstantiationException ex) {
            Logger.getLogger(FiscalJpaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FiscalJpaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FiscalJpaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    public void create(Fiscal fiscal) {
         
        String sql="insert into fiscal (fecha,tipo,pto,numero,gravado,alicuota,impuesto,total,fechaRegistro,tipoclienteid,razon,cuit) values ('"+fiscal.getFecha()+"','"+fiscal.getTipo()+"','"+fiscal.getPto()+"','"+fiscal.getNumero()+"',"+fiscal.getGravado()+",'"+fiscal.getAlicuota()+"',"+fiscal.getImpuesto()+","+fiscal.getTotal()+",'"+fiscal.getFecha()+"',"+fiscal.getTipoClienteId()+",'"+fiscal.getRazon()+"','"+fiscal.getCuit()+"')";
        System.out.println(sql);
        tra.guardarRegistro(sql);
        //tra.cerrar();
        
        /*
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(fiscal);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        */
    }

    
    
}
