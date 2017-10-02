/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidades.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
/**
 *
 * @author Luis Ignacio Cubero
 */

@Stateless
@Path("login")
public class LoginRest extends AbstractFacade<Usuario>{
    
    private EntityManager em = Persistence.createEntityManagerFactory("ChefsPU").createEntityManager();

    public LoginRest() {
        super(Usuario.class);
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public boolean login(Usuario entity) throws Exception {
        TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findForLogin", Usuario.class);
        query.setParameter("correo", entity.getCorreo());
        query.setParameter("contrasenha", entity.getContrasenha());
        query.setParameter("tipo", entity.getTipo());
        List<Usuario> lista = query.getResultList();
        if(!lista.isEmpty())
        {
            return true;
        }
        else
        {
            PersistenceException exception = new PersistenceException("Datos incorrectos");
            throw exception;
        }
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
