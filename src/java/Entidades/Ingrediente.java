/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Luis Ignacio Cubero
 */
@Entity
@Table(name = "INGREDIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ingrediente.findAll", query = "SELECT i FROM Ingrediente i")
    , @NamedQuery(name = "Ingrediente.findById", query = "SELECT i FROM Ingrediente i WHERE i.id = :id")
    , @NamedQuery(name = "Ingrediente.findByNombre", query = "SELECT i FROM Ingrediente i WHERE i.nombre = :nombre")
    , @NamedQuery(name = "Ingrediente.findByDescripcion", query = "SELECT i FROM Ingrediente i WHERE i.descripcion = :descripcion")
    , @NamedQuery(name = "Ingrediente.findByMonto", query = "SELECT i FROM Ingrediente i WHERE i.monto = :monto")})
public class Ingrediente implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 30)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MONTO")
    private BigInteger monto;
    @JoinTable(name = "PLATILLO_INGREDIENTES", joinColumns = {
        @JoinColumn(name = "INGREDIENTE_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "PLATILLO_ID", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Platillo> platilloCollection;

    public Ingrediente() {
    }

    public Ingrediente(BigDecimal id) {
        this.id = id;
    }

    public Ingrediente(BigDecimal id, String nombre, BigInteger monto) {
        this.id = id;
        this.nombre = nombre;
        this.monto = monto;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigInteger getMonto() {
        return monto;
    }

    public void setMonto(BigInteger monto) {
        this.monto = monto;
    }

    @XmlTransient
    public Collection<Platillo> getPlatilloCollection() {
        return platilloCollection;
    }

    public void setPlatilloCollection(Collection<Platillo> platilloCollection) {
        this.platilloCollection = platilloCollection;
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
        if (!(object instanceof Ingrediente)) {
            return false;
        }
        Ingrediente other = (Ingrediente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Ingrediente[ id=" + id + " ]";
    }
    
}
