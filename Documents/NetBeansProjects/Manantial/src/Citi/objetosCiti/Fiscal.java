/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosCiti;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */

public class Fiscal implements Serializable {

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
    //@Column(name = "impuesto")
    private double impuesto;
   // @Id
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

    public Fiscal() {
    }

    public Fiscal(Integer id) {
        this.id = id;
    }

    public Fiscal(Integer id, String fecha, String tipo, String pto, String numero, double gravado, String alicuota, double impuesto, double total, Date fechaRegistro, int estado, int idcliente, int tipoClienteId, String razon, String cuit) {
        this.id = id;
        this.fecha = fecha;
        this.tipo = tipo;
        this.pto = pto;
        this.numero = numero;
        this.gravado = gravado;
        this.alicuota = alicuota;
        this.impuesto = impuesto;
        this.total = total;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
        this.idcliente = idcliente;
        this.tipoClienteId = tipoClienteId;
        this.razon = razon;
        this.cuit = cuit;
    }

    public String getFecha() {
        return fecha;
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

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fiscal)) {
            return false;
        }
        Fiscal other = (Fiscal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ConversoresCiti.Fiscal[ id=" + id + " ]";
    }
    
}
