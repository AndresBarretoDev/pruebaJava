/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andres
 */
@Entity
@Table(name = "factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f")
    , @NamedQuery(name = "Factura.findByFacNumero", query = "SELECT f FROM Factura f WHERE f.facNumero = :facNumero")
    , @NamedQuery(name = "Factura.findByFechaEmision", query = "SELECT f FROM Factura f WHERE f.fechaEmision = :fechaEmision")
    , @NamedQuery(name = "Factura.findByValorFact", query = "SELECT f FROM Factura f WHERE f.valorFact = :valorFact")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fac_numero")
    private Integer facNumero;
    @Size(max = 45)
    @Column(name = "fecha_emision")
    private String fechaEmision;
    @Size(max = 45)
    @Column(name = "valor_fact")
    private String valorFact;
    @JoinColumn(name = "LINEA_num_linea", referencedColumnName = "num_linea")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Linea lINEAnumlinea;

    public Factura() {
    }

    public Factura(Integer facNumero) {
        this.facNumero = facNumero;
    }

    public Integer getFacNumero() {
        return facNumero;
    }

    public void setFacNumero(Integer facNumero) {
        this.facNumero = facNumero;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getValorFact() {
        return valorFact;
    }

    public void setValorFact(String valorFact) {
        this.valorFact = valorFact;
    }

    public Linea getLINEAnumlinea() {
        return lINEAnumlinea;
    }

    public void setLINEAnumlinea(Linea lINEAnumlinea) {
        this.lINEAnumlinea = lINEAnumlinea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facNumero != null ? facNumero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.facNumero == null && other.facNumero != null) || (this.facNumero != null && !this.facNumero.equals(other.facNumero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Factura[ facNumero=" + facNumero + " ]";
    }
    
}
