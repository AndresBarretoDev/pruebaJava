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
@Table(name = "equipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipo.findAll", query = "SELECT e FROM Equipo e")
    , @NamedQuery(name = "Equipo.findBySerialEquipo", query = "SELECT e FROM Equipo e WHERE e.serialEquipo = :serialEquipo")
    , @NamedQuery(name = "Equipo.findByMarcaEquipo", query = "SELECT e FROM Equipo e WHERE e.marcaEquipo = :marcaEquipo")
    , @NamedQuery(name = "Equipo.findByDescripcionEquipo", query = "SELECT e FROM Equipo e WHERE e.descripcionEquipo = :descripcionEquipo")
    , @NamedQuery(name = "Equipo.findByEstadoEquipo", query = "SELECT e FROM Equipo e WHERE e.estadoEquipo = :estadoEquipo")})
public class Equipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "serial_equipo")
    private Integer serialEquipo;
    @Size(max = 45)
    @Column(name = "marca_equipo")
    private String marcaEquipo;
    @Size(max = 45)
    @Column(name = "descripcion_equipo")
    private String descripcionEquipo;
    @Size(max = 45)
    @Column(name = "estado_equipo")
    private String estadoEquipo;
    @JoinColumn(name = "LINEA_num_linea", referencedColumnName = "num_linea")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Linea lINEAnumlinea;

    public Equipo() {
    }

    public Equipo(Integer serialEquipo) {
        this.serialEquipo = serialEquipo;
    }

    public Integer getSerialEquipo() {
        return serialEquipo;
    }

    public void setSerialEquipo(Integer serialEquipo) {
        this.serialEquipo = serialEquipo;
    }

    public String getMarcaEquipo() {
        return marcaEquipo;
    }

    public void setMarcaEquipo(String marcaEquipo) {
        this.marcaEquipo = marcaEquipo;
    }

    public String getDescripcionEquipo() {
        return descripcionEquipo;
    }

    public void setDescripcionEquipo(String descripcionEquipo) {
        this.descripcionEquipo = descripcionEquipo;
    }

    public String getEstadoEquipo() {
        return estadoEquipo;
    }

    public void setEstadoEquipo(String estadoEquipo) {
        this.estadoEquipo = estadoEquipo;
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
        hash += (serialEquipo != null ? serialEquipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipo)) {
            return false;
        }
        Equipo other = (Equipo) object;
        if ((this.serialEquipo == null && other.serialEquipo != null) || (this.serialEquipo != null && !this.serialEquipo.equals(other.serialEquipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Equipo[ serialEquipo=" + serialEquipo + " ]";
    }
    
}
