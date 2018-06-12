/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
@WebServlet(urlPatterns = {"/SerDePla"})
public class SerDePla extends HttpServlet {

   ResultSet cdr=null;
   Statement sentenciaSQL=null;
   Conexion conecta=new Conexion();
   
    public void init(ServletConfig config) throws ServletException{
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
            out.println("<title>Servlet SerDePla</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SerDePla at " + request.getContextPath() + "</h1>");
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
    response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String strComando="select p.id_usuario,fecha,total,descuento,subtotal,tipo_pedido,id_pedido,s.tipo_usuario,c.nombre,c.apellido_p,c.apellido_m from pedido p inner join sesion s on p.id_usuario=s.id_usuario inner join cliente c on p.id_usuario=c.id_usuario;"; 
            

            cdr=sentenciaSQL.executeQuery(strComando);
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>lineaAerea</title>");            
            out.println("</head>");
            out.println("<body> <h3>Consulta de vuelos registrados </h3><br/>");
            
            out.println("<table width=100% border=1>");
            out.println("<tr>");
            out.println("<th> id_usuario</th><th> Fecha</th><th> total </th><th> Descuento </th><th> Subtotal </th><th> tipo pedido </th><th> id_pedido </th><th> Tipo usuario </th><th> Nombre </th><th> apellido paterno </th><th> apellido materno </th> ");
            out.println("</tr>");
            while(cdr.next()){
            out.println("<tr>");
            
            out.println("<td width=10%>" + cdr.getInt(1)+ "</td>");
            out.println("<td width=10%>" + cdr.getString(2)+ "</td>");
            out.println("<td width=10%>" + cdr.getDouble(3)+ "</td>");
            out.println("<td width=10%>" + cdr.getDouble(4)+ "</td>");
            out.println("<td width=10%>" + cdr.getDouble(5)+ "</td>");
            out.println("<td width=10%>" + cdr.getString(6)+ "</td>");
            out.println("<td width=10%>" + cdr.getInt(7)+ "</td>");
            out.println("<td width=10%>" + cdr.getString(8)+ "</td>");
            out.println("<td width=10%>" + cdr.getString(9)+ "</td>");
            out.println("<td width=10%>" + cdr.getString(10)+ "</td>");
            out.println("<td width=10%>" + cdr.getString(11)+ "</td>");
            
            out.println("</tr>");
            }
            out.println("</table></br>");
            out.println("<a href=Platillo.jsp>Regresar</a></body></html>");
           
            
        } catch (SQLException e) {
             System.out.println("Excepcion SQL" + e.getMessage());
        } catch (NullPointerException e) {
             System.out.println("Apuntando SQL" + e.getMessage());
        }
             finally{
            out.close();
        }
        
    }
    public void destroy(){
        conecta.cerrar();
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
