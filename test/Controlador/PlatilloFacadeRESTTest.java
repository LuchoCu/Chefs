/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidades.Platillo;
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
public class PlatilloFacadeRESTTest {
    
    public Platillo entity;
    
    public PlatilloFacadeRESTTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of edit method, of class PlatilloFacadeREST.
     */
    @Test
    public void testEdit_GenericType() throws Exception {
        System.out.println("edit");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        PlatilloFacadeREST instance = (PlatilloFacadeREST)container.getContext().lookup("java:global/classes/PlatilloFacadeREST");
        entity = new Platillo(BigDecimal.ONE, BigInteger.ONE);
        BigDecimal id = new BigDecimal(1);
        instance.edit(id, entity);
        container.close();

        fail("No se pudo editar.");
    }

    /**
     * Test of remove method, of class PlatilloFacadeREST.
     */
    @Test
    public void testRemove_GenericType() throws Exception {
        System.out.println("remove");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        PlatilloFacadeREST instance = (PlatilloFacadeREST)container.getContext().lookup("java:global/classes/PlatilloFacadeREST");
        BigDecimal id = new BigDecimal(1);
        instance.remove(id);
        container.close();

        fail("No se pudo remover.");
    }

    /**
     * Test of find method, of class PlatilloFacadeREST.
     */
    @Test
    public void testFind_Object() throws Exception {
        System.out.println("find");
        Object id = 1;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        PlatilloFacadeREST instance = (PlatilloFacadeREST)container.getContext().lookup("java:global/classes/PlatilloFacadeREST");
        entity = new Platillo(BigDecimal.ONE, BigInteger.ONE);
        Platillo expResult = entity;
        Platillo result = instance.find(id);
        assertEquals(expResult, result);
        container.close();

        fail("Usuario no existe.");
    }

    /**
     * Test of count method, of class PlatilloFacadeREST.
     */
    @Test
    public void testCount() throws Exception {
        System.out.println("count");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        PlatilloFacadeREST instance = (PlatilloFacadeREST)container.getContext().lookup("java:global/classes/PlatilloFacadeREST");
        int expResult = 2; //Cantidad de usuarios
        int result = instance.count();
        assertEquals(expResult, result);
        container.close();

        fail("La cantidad de usuarios no es la esperada.");
    }

    /**
     * Test of create method, of class PlatilloFacadeREST.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        PlatilloFacadeREST instance = (PlatilloFacadeREST)container.getContext().lookup("java:global/classes/PlatilloFacadeREST");
        entity = new Platillo(BigDecimal.ONE, BigInteger.ONE);
        instance.create(entity);
        container.close();
 
        fail("No se pudo crear el usuario.");
    }

    /**
     * Test of edit method, of class PlatilloFacadeREST.
     */
    @Test
    public void testEdit_BigDecimal_Platillo() throws Exception {
        System.out.println("edit");
        BigDecimal id = new BigDecimal(BigInteger.ONE);
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        PlatilloFacadeREST instance = (PlatilloFacadeREST)container.getContext().lookup("java:global/classes/PlatilloFacadeREST");
        entity = new Platillo(BigDecimal.ONE, BigInteger.ONE);
        instance.edit(id, entity);
        container.close();

        fail("No se pudo editar el usuario #.");
    }

    /**
     * Test of remove method, of class PlatilloFacadeREST.
     */
    @Test
    public void testRemove_BigDecimal() throws Exception {
        System.out.println("remove");
        BigDecimal id = new BigDecimal(BigInteger.ONE);
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        PlatilloFacadeREST instance = (PlatilloFacadeREST)container.getContext().lookup("java:global/classes/PlatilloFacadeREST");
        instance.remove(id);
        container.close();
 
        fail("No se pudo remover el usuario #.");
    }

    /**
     * Test of find method, of class PlatilloFacadeREST.
     */
    @Test
    public void testFind_BigDecimal() throws Exception {
        System.out.println("find");
        BigDecimal id = new BigDecimal(BigInteger.ONE);;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        PlatilloFacadeREST instance = (PlatilloFacadeREST)container.getContext().lookup("java:global/classes/PlatilloFacadeREST");
        entity = new Platillo(BigDecimal.ONE, BigInteger.ONE);
        Platillo expResult = entity;
        Platillo result = instance.find(id);
        assertEquals(expResult, result);
        container.close();

        fail("El resultado de # no es el esperado.");
    }
    
}
