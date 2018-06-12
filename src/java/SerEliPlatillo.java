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
@WebServlet(urlPatterns = {"/SerEliPlatillo"})
public class SerEliPlatillo extends HttpServlet {
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
            out.println("<title>Servlet SerEliPlatillo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SerEliPlatillo at " + request.getContextPath() + "</h1>");
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
            String bo;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            num=Integer.parseInt(request.getParameter("idplatillo"));
            bo=(request.getParameter("radios"));
            
            if(bo.equals("si")){
           sentenciaSQL.executeUpdate("DELETE from platillo where id_platillo=('"+num+"')");
          
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Eliminacion de platillos</title>");            
            out.println("</head>");
            out.println("<body> El registro del platillo se eliminó correctamente<br/><br/><a href=Platillo.jsp>Regresar</a>");
            
            out.println("</body></html>");
            }else{
                out.println("<html>");
            out.println("<head>");
            out.println("<title>Eliminacion de vuelos</title>");            
            out.println("</head>");
            out.println("<body> La eliminacion del platillo se cancelo correctamente<br/><br/><a href=Platillo.jsp>Regresar</a>");
            
            out.println("</body></html>");
            }
            
        } catch (SQLException e) {
             out.println("Excepcion SQL" + e.getMessage());
        } catch (NullPointerException e) {
             out.println("Apuntando SQL" + e.getMessage());
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
