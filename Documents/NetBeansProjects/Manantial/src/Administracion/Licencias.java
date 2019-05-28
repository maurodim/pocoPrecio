/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administracion;

import java.sql.Date;

/**
 *
 * @author Usuario
 */
public class Licencias {

    private int id;
    private String descripcion;
    private int cantidadPresupuestos;
    private int cantidadFc;
    private int actualPresupuestos;
    private int actualFc;
    private String fechadeVencimiento;
    private int diasLicencia;
    private Date fechaAlta;
    private int diasRestantes;
    private Boolean alerta;
    private int publicidad;

    public int getPublicidad() {
        return publicidad;
    }

    public void setPublicidad(int publicidad) {
        this.publicidad = publicidad;
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

    public int getCantidadPresupuestos() {
        return cantidadPresupuestos;
    }

    public void setCantidadPresupuestos(int cantidadPresupuestos) {
        this.cantidadPresupuestos = cantidadPresupuestos;
    }

    public int getCantidadFc() {
        return cantidadFc;
    }

    public void setCantidadFc(int cantidadFc) {
        this.cantidadFc = cantidadFc;
    }

    public int getActualPresupuestos() {
        return actualPresupuestos;
    }

    public void setActualPresupuestos(int actualPresupuestos) {
        this.actualPresupuestos = actualPresupuestos;
    }

    public int getActualFc() {
        return actualFc;
    }

    public void setActualFc(int actualFc) {
        this.actualFc = actualFc;
    }

    public String getFechadeVencimiento() {
        return fechadeVencimiento;
    }

    public void setFechadeVencimiento(String fechadeVencimiento) {
        this.fechadeVencimiento = fechadeVencimiento;
    }

    public int getDiasLicencia() {
        return diasLicencia;
    }

    public void setDiasLicencia(int diasLicencia) {
        this.diasLicencia = diasLicencia;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public int getDiasRestantes() {
        return diasRestantes;
    }

    public void setDiasRestantes(int diasRestantes) {
        this.diasRestantes = diasRestantes;
    }

    public Boolean getAlerta() {
        return alerta;
    }

    public void setAlerta(Boolean alerta) {
        this.alerta = alerta;
    }

    
}
