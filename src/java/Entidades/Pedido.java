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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Luis Ignacio Cubero
 */
@Entity
@Table(name = "PEDIDO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p")
    , @NamedQuery(name = "Pedido.findById", query = "SELECT p FROM Pedido p WHERE p.id = :id")
    , @NamedQuery(name = "Pedido.findByPlatilloCant", query = "SELECT p FROM Pedido p WHERE p.platilloCant = :platilloCant")})
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PLATILLO_CANT")
    private BigInteger platilloCant;
    @JoinColumn(name = "PLATILLO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Platillo platilloId;
    @JoinColumn(name = "CLIENTE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario clienteId;
    @JoinColumn(name = "CHEF_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario chefId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedidoId")
    private Collection<Factura> facturaCollection;

    public Pedido() {
    }

    public Pedido(BigDecimal id) {
        this.id = id;
    }

    public Pedido(BigDecimal id, BigInteger platilloCant) {
        this.id = id;
        this.platilloCant = platilloCant;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getPlatilloCant() {
        return platilloCant;
    }

    public void setPlatilloCant(BigInteger platilloCant) {
        this.platilloCant = platilloCant;
    }

    public Platillo getPlatilloId() {
        return platilloId;
    }

    public void setPlatilloId(Platillo platilloId) {
        this.platilloId = platilloId;
    }

    public Usuario getClienteId() {
        return clienteId;
    }

    public void setClienteId(Usuario clienteId) {
        this.clienteId = clienteId;
    }

    public Usuario getChefId() {
        return chefId;
    }

    public void setChefId(Usuario chefId) {
        this.chefId = chefId;
    }

    @XmlTransient
    public Collection<Factura> getFacturaCollection() {
        return facturaCollection;
    }

    public void setFacturaCollection(Collection<Factura> facturaCollection) {
        this.facturaCollection = facturaCollection;
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
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Pedido[ id=" + id + " ]";
    }
    
}
