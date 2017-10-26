/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidades.Mongo;
import Entidades.Usuario;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.persistence.exceptions.DatabaseException;


/**
 *
 * @author Luis Ignacio Cubero
 */
@Stateless
@Path("usuario")
public class UsuarioFacadeREST extends AbstractFacade<Usuario> {

    //@PersistenceContext(unitName = "ChefsPU")
    private EntityManager em = Persistence.createEntityManagerFactory("ChefsPU").createEntityManager();
    private Mongo log = new Mongo();

    public UsuarioFacadeREST() {
        super(Usuario.class);
    }

    @POST
    @Override
    //@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Usuario entity) {
        
        try {
            em.getTransaction().begin();
            StoredProcedureQuery query = this.em.createStoredProcedureQuery("Insertar_usuario");
            query.registerStoredProcedureParameter("input_correo", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("input_nombre", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("input_contrasenha", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("input_tipo", String.class, ParameterMode.IN);
            query.setParameter("input_correo", entity.getCorreo());
            query.setParameter("input_nombre", entity.getNombre());
            query.setParameter("input_contrasenha", entity.getContrasenha());
            query.setParameter("input_tipo", entity.getTipo());
            query.execute();
            em.getTransaction().commit();
            String accion = "Usuario " + entity.getCorreo()+ " se ha registrado";
            log.insertarAccion(accion);
        } catch (DatabaseException e) {
            throw e;
        }
        //super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") BigDecimal id, Usuario entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") BigDecimal id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    //@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Usuario find(@PathParam("id") BigDecimal id) {
        return super.find(id);
    }
    
    @GET
    @Path("{mail}/{algo}/{algo2}")
    //@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Usuario findByMail(@PathParam("mail") String mail) {
        TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findByCorreo", Usuario.class);
        query.setParameter("correo", mail);
        List<Usuario> lista = query.getResultList();
        if(lista.isEmpty())
        {
            PersistenceException exception = new PersistenceException("Datos incorrectos");
            throw exception;
        }
        else
        {
            Usuario resultado = query.getSingleResult();
            String accion = "Usuario " + resultado.getCorreo() + " ha entrado";
            log.insertarAccion(accion);
            return resultado;
        }
    }

    @GET
    @Override
    //@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public List<Usuario> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{tipo}/{algo}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Usuario> findRange(@PathParam("tipo") String tipo, @PathParam("to") Integer to) {
        TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findByTipo", Usuario.class);
        query.setParameter("tipo", tipo);
        
        List<Usuario> lista = query.getResultList();
        if(lista.isEmpty())
        {
            PersistenceException exception = new PersistenceException("Datos vacios");
            throw exception;
        }
        else
        {
            return lista;
        }
        
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
