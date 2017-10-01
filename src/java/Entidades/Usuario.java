/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findById", query = "SELECT u FROM Usuario u WHERE u.id = :id")
    , @NamedQuery(name = "Usuario.findByCorreo", query = "SELECT u FROM Usuario u WHERE u.correo = :correo")
    , @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "Usuario.findByContrasenha", query = "SELECT u FROM Usuario u WHERE u.contrasenha = :contrasenha")
    , @NamedQuery(name = "Usuario.findByTipo", query = "SELECT u FROM Usuario u WHERE u.tipo = :tipo")
    , @NamedQuery(name = "Usuario.findForLogin", query = "SELECT u FROM Usuario u WHERE u.correo = :correo AND u.contrasenha = :contrasenha AND u.tipo = :tipo")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CORREO")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CONTRASENHA")
    private String contrasenha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "TIPO")
    private String tipo;
    @JoinTable(name = "CHEF_PLATILLO", joinColumns = {
        @JoinColumn(name = "CHEF_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "PLATILLO_ID", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Platillo> platilloCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteId")
    private Collection<Pedido> pedidoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chefId")
    private Collection<Pedido> pedidoCollection1;

    public Usuario() {
    }

    public Usuario(BigDecimal id) {
        this.id = id;
    }

    public Usuario(BigDecimal id, String correo, String nombre, String contrasenha, String tipo) {
        this.id = id;
        this.correo = correo;
        this.nombre = nombre;
        this.contrasenha = contrasenha;
        this.tipo = tipo;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public Collection<Platillo> getPlatilloCollection() {
        return platilloCollection;
    }

    public void setPlatilloCollection(Collection<Platillo> platilloCollection) {
        this.platilloCollection = platilloCollection;
    }

    @XmlTransient
    public Collection<Pedido> getPedidoCollection() {
        return pedidoCollection;
    }

    public void setPedidoCollection(Collection<Pedido> pedidoCollection) {
        this.pedidoCollection = pedidoCollection;
    }

    @XmlTransient
    public Collection<Pedido> getPedidoCollection1() {
        return pedidoCollection1;
    }

    public void setPedidoCollection1(Collection<Pedido> pedidoCollection1) {
        this.pedidoCollection1 = pedidoCollection1;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Usuario[ id=" + id + " ]";
    }

    
   
    
}
