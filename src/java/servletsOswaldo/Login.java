/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletsOswaldo;

import clases_osr.Consultas;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Login", urlPatterns = {"/inicial"})
public class Login extends HttpServlet {
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
        {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();       
        String usuario=request.getParameter("uname");
        String contrasena=request.getParameter("psw");
        Consultas co=new Consultas();   
        switch(co.autenticacion(usuario, contrasena))
        {  
            case 1:
            response.sendRedirect("PrincipalUsuario.jsp");
            break;
            case 2:
            response.sendRedirect("Cocinero.jsp");
            break;
            case 3:
            response.sendRedirect("Repartidor.jsp");
            break;
            case 4:
           response.sendRedirect("MenuGerente.jsp");
            break;
            case 0:
            request.setAttribute("resp","usuraio o contraseña incorrectos");
            RequestDispatcher rd=null;
            rd= request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
            break;
        }   
    }
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
