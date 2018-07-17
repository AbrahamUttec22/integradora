/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletJonathan;

import Conexion.Conexion;
import clases_jacg.Repatidos;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jonat
 */
@WebServlet(name = "RegistrarPLa", urlPatterns = {"/RegistrarPLa"})
public class RegistrarPLa extends HttpServlet {
ResultSet cdr=null;
    Statement sentenciaSQL=null;
    Conexion conecta=new Conexion();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
         super.init(config);
        conecta.Conectar();
        sentenciaSQL= conecta.getSentenciaSQL();
    }
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
	   out.println("<title>Servlet RegistrarPLa</title>");	   
	   out.println("</head>");
	   out.println("<body>");
	   out.println("<h1>Servlet RegistrarPLa at " + request.getContextPath() + "</h1>");
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
        String nomb,tip,ima,ima2,des;
        double pre;
        response.setContentType("text/html;charset=UTF-8");
        try {
            
	   Repatidos obj=new Repatidos();
	   nomb=request.getParameter("nom");
            tip=request.getParameter("tip");
            pre=Double.parseDouble(request.getParameter("pre"));
            ima=request.getParameter("ima");
	   ima2="img/"+ima;
	   des=request.getParameter("des");
	   
            if(obj.buscarp(nomb)){
            out.println("El platillo ya existe");
            }   else {
            sentenciaSQL.executeUpdate("INSERT INTO platillo VALUES (Null,'"+nomb+"','"+tip+"',"+pre+",'"+ima2+"','"+des+"')");
	       out.println(" El registro del platillo se guardo correctamente" );
System.out.print("INSERT INTO platillo VALUES (Null,"+nomb+"','"+tip+"',"+pre+",'"+ima2+"','"+des+"')");
        } 
     
        } catch (SQLException e) {
             out.println("Excepcion SQL" + e);
       } catch (NullPointerException e) {
             out.println("Apuntando SQL" + e	   );
   }
//	   
             finally{
            out.close();
        }
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
        processRequest(request, response);
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
