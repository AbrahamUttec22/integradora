package servletsAraceli;

import Conexion.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "EnviarComentario", urlPatterns = {"/EnviarComentario"})
public class EnviarComentario extends HttpServlet {
ResultSet cdr=null;
Statement sentenciaSQL=null;
Conexion conecta=new Conexion();

public void init(ServletConfig config) throws ServletException{
    super.init(config);
    conecta.Conectar();
    sentenciaSQL=conecta.getSentenciaSQL();
}
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EnviarComentario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EnviarComentario at " + request.getContextPath() + "</h1>");
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
        String comentario = request.getParameter("comentario");
        int usuario = Integer.parseInt(request.getParameter("usuario"));
    try {
        sentenciaSQL.executeUpdate("INSERT INTO queja_sugerencia VALUES(null,"+usuario+", '"+comentario+"', now())");
        out.println("Gracias por su comentario");
    } catch (SQLException ex) {
        ex.printStackTrace();
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
         response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
        String strComando="select distinct concat(month (fecha), year (fecha)) as fecha1 from queja_sugerencia;";
           cdr=sentenciaSQL.executeQuery(strComando); 
           out.println("<form name=reporte align=center><h3>Periodos disponibles. Elija uno:</h3><br/>");
           while(cdr.next()){
              String fecha=cdr.getString("fecha1");
              String año=fecha.substring(1, 5);
              String mes=fecha.substring(0, 1); 
              out.println("<input type=radio value="+cdr.getString("fecha1")+" name=opc>"+mes+"-"+año);
           } 
           out.println("<br/><br/><input type=button value='Generar Reporte' onclick=GenerarReporte();>");
           }catch(SQLException e){
        out.println(e);
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
