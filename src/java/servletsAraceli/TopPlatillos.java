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
@WebServlet(name = "TopPlatillos", urlPatterns = {"/TopPlatillos"})
public class TopPlatillos extends HttpServlet {
ResultSet cdr=null;
Statement sentenciaSQL=null;
Conexion conecta=new Conexion();

public void init(ServletConfig config) throws ServletException{
    super.init(config);
    conecta.Conectar();
    sentenciaSQL=(Statement) conecta.getSentenciaSQL();
}
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TopPlatillos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TopPlatillos at " + request.getContextPath() + "</h1>");
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
              String strComando="SELECT * from top_platillos order by calificacion DESC";
            cdr=sentenciaSQL.executeQuery(strComando);
            int con=0;
            out.println("<table width=50%><th>Platillo</th><th>Calificación promedio</th>");
            while(cdr.next()){
                con++;
                out.println("<tr>");
               if(con<=10){
                   out.println("<td>"+cdr.getString("nombre_platillo")+"</td>");
                   int cali=cdr.getInt("calificacion");
                   switch (cali){
                       case 10:
                            out.println("<td><img src=img/cali10.jpg width=100px></td>");
                           break;
                       case 9:
                           out.println("<td><img src=img/cali8.png width=100px></td>");
                           break;
                        case 8:
                            out.println("<td><img src=img/cali8.png width=100px></td>");
                           break;
                       case 7:
                            out.println("<td><img src=img/cali6.jpg width=100px></td>");
                           break;
                        case 6:
                             out.println("<td><img src=img/cali6.jpg width=100px></td>");
                           break;
                       case 5:
                           out.println("<td><img src=img/calificacion4.png width=100px></td>");
                           break;
                        case 4:
                            out.println("<td><img src=img/calificacion4.png width=100px></td>");
                           break;
                       case 3:
                           out.println("<td><img src=img/cali2.png width=100px></td>");
                           break;
                      case 2:
                          out.println("<td><img src=img/cali2.png width=100px></td>");
                           break;
               }                   
               }
               out.println("</tr>");
            }
            out.println("</table>");
         }
        catch(SQLException e){
            out.println(e);
    }catch(NullPointerException e){
        e.printStackTrace();
    }finally{
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
