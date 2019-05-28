/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosCiti;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author Usuario
 */

public class Comprasfiscal implements Serializable {

    private static final long serialVersionUID = 1L;
    //@Basic(optional = false)
    //@Column(name = "fecha")
    private String fecha;
    //@Basic(optional = false)
    //@Column(name = "tipo")
    private String tipo;
    //@Basic(optional = false)
    //@Column(name = "pto")
    private String pto;
    //@Basic(optional = false)
    //@Column(name = "numero")
    private String numero;
    //@Basic(optional = false)
    //@Column(name = "gravado")
    private double gravado;
    //@Basic(optional = false)
    //@Column(name = "alicuota")
    private String alicuota;
    //@Basic(optional = false)
    //@Column(name = "iva")
    private double iva;
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Basic(optional = false)
    //@Column(name = "id")
    private Integer id;
    //@Basic(optional = false)
    //@Column(name = "total")
    private double total;
    //@Basic(optional = false)
    //@Column(name = "fechaRegistro")
    //@Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    //@Basic(optional = false)
    //@Column(name = "estado")
    private int estado;
    //@Basic(optional = false)
    //@Column(name = "idcliente")
    private int idcliente;
    //@Basic(optional = false)
    //@Column(name = "tipoClienteId")
    private int tipoClienteId;
    //@Basic(optional = false)
    //@Column(name = "razon")
    private String razon;
    //@Basic(optional = false)
    //@Column(name = "cuit")
    private String cuit;
    //@Basic(optional = false)
    //@Column(name = "netonogravado")
    private double netonogravado;
    //@Basic(optional = false)
    //@Column(name = "exentas")
    private double exentas;
    //@Basic(optional = false)
    //@Column(name = "percepcioniva")
    private double percepcioniva;
    //@Basic(optional = false)
    //@Column(name = "impuestosnacionales")
    private double impuestosnacionales;
    //@Basic(optional = false)
    //@Column(name = "percepcionib")
    private double percepcionib;
    //@Basic(optional = false)
    //@Column(name = "impmunicipales")
    private double impmunicipales;
    //@Basic(optional = false)
    //@Column(name = "impinternos")
    private double impinternos;
    //@Basic(optional = false)
    //@Column(name = "cantidadalicuotaiva")
    private short cantidadalicuotaiva;
    private ArrayList lstAlicuotas;
    
    private double otrostributos;

    public Comprasfiscal() {
    }

    public Comprasfiscal(Integer id) {
        this.id = id;
    }

    public Comprasfiscal(Integer id, String fecha, String tipo, String pto, String numero, double gravado, String alicuota, double iva, double total, Date fechaRegistro, int estado, int idcliente, int tipoClienteId, String razon, String cuit, double netonogravado, double exentas, double percepcioniva, double impuestosnacionales, double percepcionib, double impmunicipales, double impinternos, short cantidadalicuotaiva, double otrostributos, ArrayList lstAlicuota) {
        this.id = id;
        this.fecha = fecha;
        this.tipo = tipo;
        this.pto = pto;
        this.numero = numero;
        this.gravado = gravado;
        this.alicuota = alicuota;
        this.iva = iva;
        this.total = total;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
        this.idcliente = idcliente;
        this.tipoClienteId = tipoClienteId;
        this.razon = razon;
        this.cuit = cuit;
        this.netonogravado = netonogravado;
        this.exentas = exentas;
        this.percepcioniva = percepcioniva;
        this.impuestosnacionales = impuestosnacionales;
        this.percepcionib = percepcionib;
        this.impmunicipales = impmunicipales;
        this.impinternos = impinternos;
        this.cantidadalicuotaiva = cantidadalicuotaiva;
        this.otrostributos = otrostributos;
        this.lstAlicuotas=lstAlicuota;
    }

    public String getFecha() {
        return fecha;
    }

    public ArrayList getLstAlicuotas() {
        return lstAlicuotas;
    }

    public void setLstAlicuotas(ArrayList lstAlicuotas) {
        this.lstAlicuotas = lstAlicuotas;
    }
    
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPto() {
        return pto;
    }

    public void setPto(String pto) {
        this.pto = pto;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getGravado() {
        return gravado;
    }

    public void setGravado(double gravado) {
        this.gravado = gravado;
    }

    public String getAlicuota() {
        return alicuota;
    }

    public void setAlicuota(String alicuota) {
        this.alicuota = alicuota;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getTipoClienteId() {
        return tipoClienteId;
    }

    public void setTipoClienteId(int tipoClienteId) {
        this.tipoClienteId = tipoClienteId;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public double getNetonogravado() {
        return netonogravado;
    }

    public void setNetonogravado(double netonogravado) {
        this.netonogravado = netonogravado;
    }

    public double getExentas() {
        return exentas;
    }

    public void setExentas(double exentas) {
        this.exentas = exentas;
    }

    public double getPercepcioniva() {
        return percepcioniva;
    }

    public void setPercepcioniva(double percepcioniva) {
        this.percepcioniva = percepcioniva;
    }

    public double getImpuestosnacionales() {
        return impuestosnacionales;
    }

    public void setImpuestosnacionales(double impuestosnacionales) {
        this.impuestosnacionales = impuestosnacionales;
    }

    public double getPercepcionib() {
        return percepcionib;
    }

    public void setPercepcionib(double percepcionib) {
        this.percepcionib = percepcionib;
    }

    public double getImpmunicipales() {
        return impmunicipales;
    }

    public void setImpmunicipales(double impmunicipales) {
        this.impmunicipales = impmunicipales;
    }

    public double getImpinternos() {
        return impinternos;
    }

    public void setImpinternos(double impinternos) {
        this.impinternos = impinternos;
    }

    public short getCantidadalicuotaiva() {
        return cantidadalicuotaiva;
    }

    public void setCantidadalicuotaiva(short cantidadalicuotaiva) {
        this.cantidadalicuotaiva = cantidadalicuotaiva;
    }

    public double getOtrostributos() {
        return otrostributos;
    }

    public void setOtrostributos(double otrostributos) {
        this.otrostributos = otrostributos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comprasfiscal)) {
            return false;
        }
        Comprasfiscal other = (Comprasfiscal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ConversoresCiti.Comprasfiscal[ id=" + id + " ]";
    }
    
}
