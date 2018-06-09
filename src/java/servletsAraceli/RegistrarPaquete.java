/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletsAraceli;

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
 * @author Araceli
 */
@WebServlet(name = "RegistrarPaquete", urlPatterns = {"/RegistrarPaquete"})
public class RegistrarPaquete extends HttpServlet {
ResultSet cdr=null;
Statement sentenciaSQL=null;
Conexion conecta=new Conexion();

public void init(ServletConfig config) throws ServletException{
    super.init(config);
    conecta.Conectar();
    sentenciaSQL=conecta.getSentenciaSQL();
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
            out.println("<title>Servlet RegistrarPaquete</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistrarPaquete at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        int id;
       String nombre, desc, imagen;
       double precio;
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();       
         try {
             // id=Integer.parseInt(request.getParameter("idPaquete"));
              precio=Double.parseDouble(request.getParameter("precioPaquete"));
        nombre=request.getParameter("nombrePaquete");
        desc=request.getParameter("descripcionPaquete");
        imagen=request.getParameter("imagenPaquete");
          String strComando="SELECT * FROM paquete where nombre_paquete='"+nombre+"'";
            cdr=sentenciaSQL.executeQuery(strComando);
            if(cdr.next()){
             out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Registrar Paquete</title>");   
            out.println("  <link href=\"css/abra.css\" rel=\"stylesheet\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>El paquete ya existe</h1>");
            out.println(" <label><a href=\"PrincipalG.jsp\">Regresar</a></label>");
            out.println("</body>");
            out.println("</html>");
            }else{
                sentenciaSQL.executeUpdate("INSERT INTO paquete VALUES(null,'"+nombre+"',"+precio+",'"+desc+"','img/"+imagen+"')");
           out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Registrar Paquete</title>"); 
            out.println("  <link href=\"css/abra.css\" rel=\"stylesheet\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>El paquete se registro exitosamente</h1>");
            out.println(" <label><a href=\"PrincipalG.jsp\">Regresar</a></label>");
            out.println("</body>");
            out.println("</html>");
                        }
        }catch(NullPointerException e){
       out.println(e);
       e.printStackTrace();
    } catch (SQLException ex) {
         out.println(ex);
    }  
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
