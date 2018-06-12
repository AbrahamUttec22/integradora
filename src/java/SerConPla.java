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
@WebServlet(urlPatterns = {"/SerConPla"})
public class SerConPla extends HttpServlet {
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
            out.println("<title>Servlet SerConPla</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SerConPla at " + request.getContextPath() + "</h1>");
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
            String strComando="select * from platillo "; 
            int id;
            String tipo,ima;
            
            cdr=sentenciaSQL.executeQuery(strComando);
            
            out.println("<html>");
            
            
            
            out.println("<head>");
            out.println("<title>PLatillos</title>");            
            out.println("</head>");
            out.println("<body> <h3>Consulta de platillos </h3><br/>");
            
            out.println("<table width=100% border=1>");
            out.println("<tr>");
            out.println("<th> Id_platillo</th><th> Nombre   </th><th> Tipo </th><th> Precio </th><th> Imagen </th><th> Actualizar </th><th> Eliminar </th> ");
            out.println("</tr>");
            while(cdr.next()){
            out.println("<tr>");
            id=cdr.getInt(1);
            tipo=cdr.getString(3);
            ima=cdr.getString(5);
            
            out.println("<td width=10%>" + cdr.getInt(1)+ "</td>");
            out.println("<td width=10%>" + cdr.getString(2)+ "</td>");
            out.println("<td width=10%>" + cdr.getString(3)+ "</td>");
            out.println("<td width=10%>" + cdr.getDouble(4)+ "</td>");
            out.println("<td width=10%> <img src="+ cdr.getString(5)+ " WIDTH=50% heigth=50%></img>  </td>");
            
            out.println("<td width=10%>" +"<a href=ModPlatillos.jsp?nov="+id+" ><input type=button value=Actualizar name=enviar ></a></a>"+  "</td>");
            out.println("<td width=10%>" +"<a href=EliminarPlatillos.jsp?nov="+id+" ><input type=button value=Eliminar name=enviar ></a>"+ "</td>");
            out.println("</tr>");
            }
            out.println("</table></br>");
            out.println("<a href=PrincipalG.jsp>Regresar</a></body></html>");
           
            
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
