/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidades.Usuario;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.embeddable.EJBContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Luis Ignacio Cubero
 */
public class UsuarioFacadeRESTTest {
    
    Usuario entity;
    
    public UsuarioFacadeRESTTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        entity = new Usuario(BigDecimal.ONE, "aa@gmail.com", "aa", "aa", "Chef");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of edit method, of class UsuarioFacadeREST.
     */
    @Test
    public void testEdit_GenericType() throws Exception {
        System.out.println("edit");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UsuarioFacadeREST instance = (UsuarioFacadeREST)container.getContext().lookup("java:global/classes/UsuarioFacadeREST/1"); //Posible error.
        instance.edit(entity);
        container.close();

        fail("No se pudo editar.");
    }

    /**
     * Test of remove method, of class UsuarioFacadeREST.
     */
    @Test
    public void testRemove_GenericType() throws Exception {
        System.out.println("remove");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UsuarioFacadeREST instance = (UsuarioFacadeREST)container.getContext().lookup("java:global/classes/UsuarioFacadeREST/1");
        instance.remove(entity);
        container.close();

        fail("No se pudo remover.");
    }

    /**
     * Test of find method, of class UsuarioFacadeREST.
     */
    @Test
    public void testFind_Object() throws Exception {
        System.out.println("find");
        Object id = 1;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UsuarioFacadeREST instance = (UsuarioFacadeREST)container.getContext().lookup("java:global/classes/UsuarioFacadeREST");
        Usuario expResult = entity;
        Usuario result = instance.find(id);
        assertEquals(expResult, result);
        container.close();

        fail("Usuario no existe.");
    }

    /**
     * Test of count method, of class UsuarioFacadeREST.
     */
    @Test
    public void testCount() throws Exception {
        System.out.println("count");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UsuarioFacadeREST instance = (UsuarioFacadeREST)container.getContext().lookup("java:global/classes/UsuarioFacadeREST");
        int expResult = 2; //Cantidad de usuarios
        int result = instance.count();
        assertEquals(expResult, result);
        container.close();

        fail("La cantidad de usuarios no es la esperada.");
    }

    /**
     * Test of create method, of class UsuarioFacadeREST.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UsuarioFacadeREST instance = (UsuarioFacadeREST)container.getContext().lookup("java:global/classes/UsuarioFacadeREST");
        instance.create(entity);
        container.close();
 
        fail("No se pudo crear el usuario.");
    }

    /**
     * Test of edit method, of class UsuarioFacadeREST.
     */
    @Test
    public void testEdit_BigDecimal_Usuario() throws Exception {
        System.out.println("edit");
        BigDecimal id = new BigDecimal(BigInteger.ONE);
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UsuarioFacadeREST instance = (UsuarioFacadeREST)container.getContext().lookup("java:global/classes/UsuarioFacadeREST");
        instance.edit(id, entity);
        container.close();

        fail("No se pudo editar el usuario #.");
    }

    /**
     * Test of remove method, of class UsuarioFacadeREST.
     */
    @Test
    public void testRemove_BigDecimal() throws Exception {
        System.out.println("remove");
        BigDecimal id = new BigDecimal(BigInteger.ONE);
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UsuarioFacadeREST instance = (UsuarioFacadeREST)container.getContext().lookup("java:global/classes/UsuarioFacadeREST");
        instance.remove(id);
        container.close();
 
        fail("No se pudo remover el usuario #.");
    }

    /**
     * Test of find method, of class UsuarioFacadeREST.
     */
    @Test
    public void testFind_BigDecimal() throws Exception {
        System.out.println("find");
        BigDecimal id = new BigDecimal(BigInteger.ONE);
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UsuarioFacadeREST instance = (UsuarioFacadeREST)container.getContext().lookup("java:global/classes/UsuarioFacadeREST");
        Usuario expResult = entity;
        Usuario result = instance.find(id);
        assertEquals(expResult, result);
        container.close();

        fail("El resultado de # no es el esperado.");
    }

    /**
     * Test of findByMail method, of class UsuarioFacadeREST.
     */
    @Test
    public void testFindByMail() throws Exception {
        System.out.println("findByMail");
        String mail = "aa@gmail.com";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UsuarioFacadeREST instance = (UsuarioFacadeREST)container.getContext().lookup("java:global/classes/UsuarioFacadeREST");
        Usuario expResult = entity;
        Usuario result = instance.findByMail(mail);
        assertEquals(expResult, result);
        container.close();

        fail("El usuario no es el esperado.");
    }
    
}
