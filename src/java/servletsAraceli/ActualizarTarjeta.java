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

@WebServlet(name = "ActualizarTarjeta", urlPatterns = {"/ActualizarTarjeta"})
public class ActualizarTarjeta extends HttpServlet {
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
            out.println("<title>Servlet ActualizarTarjeta</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ActualizarTarjeta at " + request.getContextPath() + "</h1>");
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
       String tarjeta = request.getParameter("tarjeta");
       String codigo = request.getParameter("codigo");
       int usuario = Integer.parseInt(request.getParameter("usuario"));
       try{
        String strComando="SELECT * FROM tarjeta_prepago where no_tarjeta="+tarjeta;
           cdr=sentenciaSQL.executeQuery(strComando);         
           if(cdr.next()){
              String cod=cdr.getString("codigo");
              int saldo=cdr.getInt("saldo");
              if(cod.equals(codigo)){
                  sentenciaSQL.executeUpdate("UPDATE tarjeta_prepago SET estatus='ocupada' WHERE no_tarjeta='"+tarjeta+"'");
                  sentenciaSQL.executeUpdate("UPDATE cliente SET saldo=(saldo+"+saldo+") WHERE id_usuario="+usuario);
              out.println("Se activó con exito la tarjeta. Su saldo se actualizó");
              }else{
                  out.println("Código incorrecto");
              }
           }
           }            
           catch(SQLException e){
        out.println(e);
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
