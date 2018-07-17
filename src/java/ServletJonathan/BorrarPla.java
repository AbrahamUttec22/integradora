/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletJonathan;

import Conexion.Conexion;
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
@WebServlet(name = "BorrarPla", urlPatterns = {"/BorrarPla"})
public class BorrarPla extends HttpServlet {
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
	   out.println("<title>Servlet BorrarPla</title>");	   
	   out.println("</head>");
	   out.println("<body>");
	   out.println("<h1>Servlet BorrarPla at " + request.getContextPath() + "</h1>");
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
        	   int num;
        PrintWriter out = response.getWriter();
        try {
	  
	     
	   
            num=Integer.parseInt(request.getParameter("iden"));
           sentenciaSQL.executeUpdate("DELETE from platillo where id_platillo=('"+num+"')");
	 
	  
	  
	  String strComando2="select * from platillo "; 
            
            cdr=sentenciaSQL.executeQuery(strComando2);
            
            while(cdr.next()){
            out.println("<tr>");
            out.println("<table width=120%  border=5 >"); 
	   out.println("<tr width=10%>");

            out.println("<td width=10%>" + cdr.getInt(1)+ "</td>");
            out.println("<td width=10%>" + cdr.getString(2)+ "</td>");
            out.println("<td width=10%>" + cdr.getString(3)+ "</td>");
            out.println("<td width=10%>" + cdr.getDouble(4)+ "</td>");
            out.println("<td width=10%> <img src="+ cdr.getString(5)+ " WIDTH=100% heigth=100%></img>  </td>");
            out.println("<td width=10%>" + cdr.getString(6)+ "</td>");
            out.println("<td width=10%> <input type=button value=Actualizar name=enviar onclick=actualizarp("+cdr.getInt(1)+");></td>");
	   out.println("<td width=10%> <input type=button value=Eliminar name=enviar onclick=borrarp("+cdr.getInt(1)+");></td>");
//out.println("<td width=10%> <input type=button value=Eliminar name=enviar onclick=borrarp();></td>");
            out.println("</tr>");
            }
            out.println("</table></br>");
            
	  
        } catch (SQLException e) {
             out.println("Excepcion SQL" + e.getMessage());
        } catch (NullPointerException e) {
             out.println("Apuntando SQL" + e.getMessage());
        }
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
