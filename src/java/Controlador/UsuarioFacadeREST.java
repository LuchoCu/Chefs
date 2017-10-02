/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidades.Usuario;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;
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
    @Override
    //@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public List<Usuario> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Usuario> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
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
