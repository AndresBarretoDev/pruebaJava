/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andres
 */
@Entity
@Table(name = "linea")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Linea.findAll", query = "SELECT l FROM Linea l")
    , @NamedQuery(name = "Linea.findByNumLinea", query = "SELECT l FROM Linea l WHERE l.numLinea = :numLinea")
    , @NamedQuery(name = "Linea.findByEstadoLinea", query = "SELECT l FROM Linea l WHERE l.estadoLinea = :estadoLinea")})
public class Linea implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "num_linea")
    private Integer numLinea;
    @Size(max = 45)
    @Column(name = "estado_linea")
    private String estadoLinea;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lINEAnumlinea", fetch = FetchType.LAZY)
    private Collection<Factura> facturaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lINEAnumlinea", fetch = FetchType.LAZY)
    private Collection<Equipo> equipoCollection;
    @JoinColumn(name = "PERSONA_idpersona", referencedColumnName = "idpersona")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Persona pERSONAidpersona;

    public Linea() {
    }

    public Linea(Integer numLinea) {
        this.numLinea = numLinea;
    }

    public Integer getNumLinea() {
        return numLinea;
    }

    public void setNumLinea(Integer numLinea) {
        this.numLinea = numLinea;
    }

    public String getEstadoLinea() {
        return estadoLinea;
    }

    public void setEstadoLinea(String estadoLinea) {
        this.estadoLinea = estadoLinea;
    }

    @XmlTransient
    public Collection<Factura> getFacturaCollection() {
        return facturaCollection;
    }

    public void setFacturaCollection(Collection<Factura> facturaCollection) {
        this.facturaCollection = facturaCollection;
    }

    @XmlTransient
    public Collection<Equipo> getEquipoCollection() {
        return equipoCollection;
    }

    public void setEquipoCollection(Collection<Equipo> equipoCollection) {
        this.equipoCollection = equipoCollection;
    }

    public Persona getPERSONAidpersona() {
        return pERSONAidpersona;
    }

    public void setPERSONAidpersona(Persona pERSONAidpersona) {
        this.pERSONAidpersona = pERSONAidpersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numLinea != null ? numLinea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Linea)) {
            return false;
        }
        Linea other = (Linea) object;
        if ((this.numLinea == null && other.numLinea != null) || (this.numLinea != null && !this.numLinea.equals(other.numLinea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Linea[ numLinea=" + numLinea + " ]";
    }
    
}
