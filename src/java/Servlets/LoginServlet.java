/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controlador.LoginREST;
import Entidades.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Scarlet
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        }
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter writer = response.getWriter();
        
        String mail = request.getParameter("correo");
        String password = request.getParameter("contrasena");
        
        if (checkUser(response, mail, password) == true) {            
            HttpSession session=request.getSession();
            session.setAttribute("mail",mail);
            //response.sendRedirect("ProfileServlet");
            response.sendRedirect("Main.html");
        } else {
            writer.print("Datos incorrectos");
        }
    }

    protected boolean checkUser (HttpServletResponse response, String name, String pass) throws IOException {  
        //Usuario usuario = new Usuario();
        //try{
        //    LoginREST.login(usuario);
        //            }
        return true;
    }
}
