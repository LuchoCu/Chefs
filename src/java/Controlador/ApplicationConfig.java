package Controlador;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Luis Ignacio Cubero
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(Controlador.IngredienteFacadeREST.class);
        resources.add(Controlador.LoginREST.class);
        resources.add(Controlador.PlatilloFacadeREST.class);
        //resources.add(Controlador.MongoRest.class);
        resources.add(Controlador.UsuarioFacadeREST.class);
        
    }
    
}
