package Controlador;

import Entidades.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
/**
 *
 * @author Luis Ignacio Cubero
 */

@Stateless
@Path("login")
public class LoginREST extends AbstractFacade<Usuario>{
    
    private EntityManager em = Persistence.createEntityManagerFactory("ChefsPU").createEntityManager();

    public LoginREST() {
        super(Usuario.class);
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void login(Usuario entity) throws Exception {
        TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findForLogin", Usuario.class);
        query.setParameter("correo", entity.getCorreo());
        query.setParameter("contrasenha", entity.getContrasenha());
        //query.setParameter("tipo", entity.getTipo());
        List<Usuario> lista = query.getResultList();
        if(lista.isEmpty())
        {
            PersistenceException exception = new PersistenceException("Datos incorrectos");
            throw exception;
        }
        else
        {
            String accion = "Usuario " + entity.getCorreo() + " ha iniciado sesion";
        }
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
