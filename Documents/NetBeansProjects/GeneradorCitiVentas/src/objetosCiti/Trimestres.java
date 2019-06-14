/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosCiti;

/**
 *
 * @author Usuario
 */
public class Trimestres {
    private int id;
    private String descripcion;
    private String mes1;
    private int mes2;
    private String mes3;

    public Trimestres(int id, String descripcion, String mes1, int mes2, String mes3) {
        this.id = id;
        this.descripcion = descripcion;
        this.mes1 = mes1;
        this.mes2 = mes2;
        this.mes3 = mes3;
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

    public String getMes1() {
        return mes1;
    }

    public void setMes1(String mes1) {
        this.mes1 = mes1;
    }

    public int getMes2() {
        return mes2;
    }

    public void setMes2(int mes2) {
        this.mes2 = mes2;
    }

    public String getMes3() {
        return mes3;
    }

    public void setMes3(String mes3) {
        this.mes3 = mes3;
    }
    
    
}
