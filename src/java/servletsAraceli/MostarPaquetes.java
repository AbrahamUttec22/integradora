package servletsAraceli;

import Conexion.*;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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
@WebServlet(name = "MostarPaquetes", urlPatterns = {"/MostarPaquetes"})
public class MostarPaquetes extends HttpServlet {
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
//         response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out=response.getWriter();
//                         try{
//            String strComando="Select * from paquete";
//            sentenciaSQL=conecta.getSentenciaSQL();
//            ResultSet cdr=sentenciaSQL.executeQuery(strComando);
//            out.println("<table>");
//            while (cdr.next()){
//                out.println("<tr>");
//                out.println("<td width=15>"+cdr.getInt("id_paquete")+"</td>");
//                out.println("<td width=20>"+cdr.getString("nombre_paquete")+"</td>");
//                out.println("<td width=15>"+cdr.getString("precio")+"</td>");
//                out.println("<td width=30>"+cdr.getString("descripcion")+"</td>");
//                out.println("<td width=15><img src="+cdr.getString("imagen")+" width=70% > </td>");
//                out.println("<td width=10>"+"<form method='post' action='GestionesPaquetes'> <input type='submit' value='Actualizar' name='submits'> <input type='hidden' value='"+cdr.getInt("id_paquete")+"' name='numero'></form>"+"</td>");
//                out.println("<td width=10>"+"<form method='get' action='GestionesPaquetes'> <input type='submit' value='Eliminar' name='submits'> <input type='hidden' value='"+cdr.getInt("id_paquete")+"' name='numero'></form>"+"</td>");
//                out.println("</tr>");
//                  out.println("</table>");
//                               }
//                
//        }catch(SQLException e){
//            out.println(e);
//    }
out.println("hola");
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
