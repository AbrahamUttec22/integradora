/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletJonathan;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jonat
 */
@WebServlet(name = "PintarRP", urlPatterns = {"/PintarRP"})
public class PintarRP extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	   throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
	   /* TODO output your page here. You may use following sample code. */
	   out.println("<!DOCTYPE html>");
	   out.println("<html>");
	   out.println("<head>");
	   out.println("<title>Servlet PintarRP</title>");	   
	   out.println("</head>");
	   out.println("<body>");
	   out.println("<h1>Servlet PintarRP at " + request.getContextPath() + "</h1>");
	   out.println("</body>");
	   out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	   throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<center><input type=text placeholder=platillo required autofocus id=nombre ><br><br>");
        out.println("<select id=tipoj>"); 
        out.println("<option value=Tipo > Tipo de platillo</option>");
        out.println("<option value=Entrada > Entrada</option>");
        out.println("<option value='Plato Fuerte' > Plato Fuerte</option>"); 
        out.println("<option value=Postre > Postre</option> ");
        out.println("<option value=Bebida > Bebida</option>");
        out.println("</select><br><br>");
        out.println("<input type=text placeholder=$ required autofocus id=precioj><br><br>");
        out.println("<label>Foto</label><input type=file placeholder=&#128100; id=imagenj required autofocus value=><br><br>");
        out.println("<textarea placeholder=Descripcion required autofocus id=descripcionj ></textarea><br><br>");
        out.println("<input type=button name=registrar value=Registrar required autofocus onclick=insertarP();><br><br></center>");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	   throws ServletException, IOException {
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
