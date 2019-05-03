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

import objetosCiti.Comprasfiscal;
import objetosR.Conecciones;


/**
 *
 * @author Usuario
 */
public class ComprasfiscalJpaController implements Serializable {
    private Transaccionable tra;
    public ComprasfiscalJpaController() {
        try {
            //this.emf = Persistence.createEntityManagerFactory("GeneradorCitiPU");
            tra=new Conecciones();
        } catch (InstantiationException ex) {
            Logger.getLogger(ComprasfiscalJpaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ComprasfiscalJpaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ComprasfiscalJpaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    //private EntityManagerFactory emf = null;
/*
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
*/
    public void create(Comprasfiscal comprasfiscal) {
        //tra=new Conecciones();
        
        String sql="insert into comprasfiscal (fecha,tipo,pto,numero,gravado,alicuota,iva,total,fechaRegistro,razon,cuit,netonogravado,exentas,percepcioniva,impuestosnacionales,percepcionib,impmunicipales,impinternos,cantidadalicuotaiva,otrostributos) values ('"+comprasfiscal.getFecha()+"','"+comprasfiscal.getTipo()+"','"+comprasfiscal.getPto()+"','"+comprasfiscal.getNumero()+"',"+comprasfiscal.getGravado()+",'"+comprasfiscal.getAlicuota()+"',"+comprasfiscal.getIva()+","+comprasfiscal.getTotal()+",'"+comprasfiscal.getFecha()+"','"+comprasfiscal.getRazon()+"','"+comprasfiscal.getCuit()+"',"+comprasfiscal.getNetonogravado()+","+comprasfiscal.getExentas()+","+comprasfiscal.getPercepcioniva()+","+comprasfiscal.getImpuestosnacionales()+","+comprasfiscal.getPercepcionib()+","+comprasfiscal.getImpmunicipales()+","+comprasfiscal.getImpinternos()+","+comprasfiscal.getCantidadalicuotaiva()+","+comprasfiscal.getOtrostributos()+")";
        System.out.println(sql);
        tra.guardarRegistro(sql);
        //tra.cerrar();
        
        /*
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(comprasfiscal);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
*/
    }

    
}
