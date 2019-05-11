/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosActualizador;

import java.util.ArrayList;
import java.sql.Date;

/**
 *
 * @author Usuario
 */
public class Licencias {
    private int id;
    private String descripcion;
    private int cantidadComprobantes;
    private Date actualizacion;
    private int cantidadPresupuestos;
    private int cantidadDias;

    public int getCantidadPresupuestos() {
        return cantidadPresupuestos;
    }

    public void setCantidadPresupuestos(int cantidadPresupuestos) {
        this.cantidadPresupuestos = cantidadPresupuestos;
    }

    public int getCantidadDias() {
        return cantidadDias;
    }

    public void setCantidadDias(int cantidadDias) {
        this.cantidadDias = cantidadDias;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidadComprobantes() {
        return cantidadComprobantes;
    }

    public void setCantidadComprobantes(int cantidadComprobantes) {
        this.cantidadComprobantes = cantidadComprobantes;
    }

    public Date getActualizacion() {
        return actualizacion;
    }

    public void setActualizacion(Date actualizacion) {
        this.actualizacion = actualizacion;
    }
    
}
