/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidades.Ingrediente;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
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
public class IngredienteFacadeRESTTest {
    
    public Ingrediente entity;
    
    public IngredienteFacadeRESTTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        entity = new Ingrediente(BigDecimal.ONE, "Tomate", BigInteger.TEN);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of edit method, of class IngredienteFacadeREST.
     */
    @Test
    public void testEdit_GenericType() throws Exception {
        System.out.println("edit");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        IngredienteFacadeREST instance = (IngredienteFacadeREST)container.getContext().lookup("java:global/classes/IngredienteFacadeREST");
        instance.edit(entity);
        container.close();

        fail("No se pudo editar.");
    }

    /**
     * Test of remove method, of class IngredienteFacadeREST.
     */
    @Test
    public void testRemove_GenericType() throws Exception {
        System.out.println("remove");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        IngredienteFacadeREST instance = (IngredienteFacadeREST)container.getContext().lookup("java:global/classes/IngredienteFacadeREST");
        instance.remove(entity);
        container.close();

        fail("No se pudo remover.");
    }

    /**
     * Test of find method, of class IngredienteFacadeREST.
     */
    @Test
    public void testFind_Object() throws Exception {
        System.out.println("find");
        Object id = 1;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        IngredienteFacadeREST instance = (IngredienteFacadeREST)container.getContext().lookup("java:global/classes/IngredienteFacadeREST");
        Ingrediente expResult = entity;
        Ingrediente result = instance.find(id);
        assertEquals(expResult, result);
        container.close();

        fail("Usuario no existe.");
    }

    /**
     * Test of count method, of class IngredienteFacadeREST.
     */
    @Test
    public void testCount() throws Exception {
        System.out.println("count");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        IngredienteFacadeREST instance = (IngredienteFacadeREST)container.getContext().lookup("java:global/classes/IngredienteFacadeREST");
        int expResult = 2; //Cantidad de usuarios
        int result = instance.count();
        assertEquals(expResult, result);
        container.close();

        fail("La cantidad de usuarios no es la esperada.");
    }

    /**
     * Test of create method, of class IngredienteFacadeREST.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        IngredienteFacadeREST instance = (IngredienteFacadeREST)container.getContext().lookup("java:global/classes/IngredienteFacadeREST");
        instance.create(entity);
        container.close();
 
        fail("No se pudo crear el usuario.");
    }

    /**
     * Test of edit method, of class IngredienteFacadeREST.
     */
    @Test
    public void testEdit_BigDecimal_Ingrediente() throws Exception {
        System.out.println("edit");
        BigDecimal id = new BigDecimal(BigInteger.ONE);
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        IngredienteFacadeREST instance = (IngredienteFacadeREST)container.getContext().lookup("java:global/classes/IngredienteFacadeREST");
        instance.edit(id, entity);
        container.close();

        fail("No se pudo editar el usuario #.");
    }

    /**
     * Test of remove method, of class IngredienteFacadeREST.
     */
    @Test
    public void testRemove_BigDecimal() throws Exception {
        System.out.println("remove");
        BigDecimal id = new BigDecimal(BigInteger.ONE);
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        IngredienteFacadeREST instance = (IngredienteFacadeREST)container.getContext().lookup("java:global/classes/IngredienteFacadeREST");
        instance.remove(id);
        container.close();
 
        fail("No se pudo remover el usuario #.");
    }

    /**
     * Test of find method, of class IngredienteFacadeREST.
     */
    @Test
    public void testFind_BigDecimal() throws Exception {
        System.out.println("find");
        BigDecimal id = new BigDecimal(BigInteger.ONE);
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        IngredienteFacadeREST instance = (IngredienteFacadeREST)container.getContext().lookup("java:global/classes/IngredienteFacadeREST");
        Ingrediente expResult = entity;
        Ingrediente result = instance.find(id);
        assertEquals(expResult, result);
        container.close();

        fail("El resultado de # no es el esperado.");
    }
    
}
