
package servletsAbraham;

import Clases_aca.InsertarE;
import Conexion.Conexion;
import datosCliente.datosCliente;
import datosGerente.datosGerente;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RegistrarE", urlPatterns = {"/RegistrarE"})
public class RegistrarE extends HttpServlet {
    
        ResultSet cdr=null;
    Statement sentenciaSQL=null;
    Conexion conecta= new Conexion();
    
  @Override
    public void init(ServletConfig config) throws ServletException {
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
            out.println("<title>Servlet RegistrarE</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistrarE at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
     datosGerente m= new datosGerente();
     InsertarE ob= new InsertarE();
     m.se
     ob.insertarE(m);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
