/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidades.Mongo;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Luis Ignacio Cubero
 */
@Stateless
@Path("mongo")
public class MongoRest {
    private Mongo log = new Mongo();
    
    public MongoRest(){

    }
    
    @GET
    //@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public String findAll() {
        return log.verAccion();
    }
    

}   
