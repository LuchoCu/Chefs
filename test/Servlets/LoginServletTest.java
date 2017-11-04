/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class LoginServletTest {
    
    public LoginServletTest() {
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
     * Test of doPost method, of class LoginServlet.
     */
    @Test
    public void testDoPost() throws Exception {
        System.out.println("doPost");
        LoginServlet instance = new LoginServlet();
        HttpServletResponse response = null;
        HttpServletRequest request = null;
        //CP02
        request.setAttribute("correo", "");
        request.setAttribute("contrasena", "");
        instance.doPost(request, response);
        //CP03
        request.setAttribute("correo", "a@gmail.com");
        request.setAttribute("contrasena", "z");
        instance.doPost(request, response);
        //CP04
        request.setAttribute("correo", "aa@gmail.com");
        request.setAttribute("contrasena", "z");
        instance.doPost(request, response);
        //CP05
        request.setAttribute("correo", "a@a.com");
        request.setAttribute("contrasena", "z");
        instance.doPost(request, response);
        //CP06
        request.setAttribute("correo", "adddddddddddddddddddddddddddddddddodddddddd@a.com");
        request.setAttribute("contrasena", "adddddddddddddd");
        instance.doPost(request, response);
        //CP07
        request.setAttribute("correo", "adddddddddddddddddddddddddddddddddodddddddd@a.com");
        request.setAttribute("contrasena", "addddddddddddddd");
        instance.doPost(request, response);
        //CP08
        request.setAttribute("correo", "");
        request.setAttribute("contrasena", "adddddddddddddd");
        instance.doPost(request, response);
        //CP09
        request.setAttribute("correo", "adddddddddddddddddddddddddddddddddodddddddd@a.com");
        request.setAttribute("contrasena", "");
        instance.doPost(request, response);
        //CP10
        request.setAttribute("correo", "adddddddddddddddddddddddddddddddddodddd@gmail.com");
        request.setAttribute("contrasena", "123456789112345");
        instance.doPost(request, response);

        fail("Ilegal request.");
    }
    
}
