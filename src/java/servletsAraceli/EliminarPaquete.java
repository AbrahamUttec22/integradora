package servletsAraceli;

import Conexion.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "EliminarPaquete", urlPatterns = {"/EliminarPaquete"})
public class EliminarPaquete extends HttpServlet {
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
            out.println("<title>Servlet EliminarPaquete</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EliminarPaquete at " + request.getContextPath() + "</h1>");
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
               int id;
               String opc;
       try {
           id=Integer.parseInt(request.getParameter("id"));
           opc=request.getParameter("opc");
           if(opc.equals("si")){
               sentenciaSQL.executeUpdate("DELETE FROM paquete WHERE id_paquete="+id); 
               out.println("El paquete se elimino correctamente");
           }else{
              out.println("Se cancelo la operación");
           }
        }catch(SQLException e){
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
        response.setContentType("text/html;charset=UTF-8");     
        int id;
        String opc;
       try (PrintWriter out = response.getWriter()) {
           id=Integer.parseInt(request.getParameter("id"));
           opc=request.getParameter("opc");
           if(opc.equals("si")){
               sentenciaSQL.executeUpdate("DELETE FROM paquete WHERE id_paquete="+id); 
               out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>EliminarPaquete</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>El paquete se elimino correctamente</h1>");
            out.println("<a href='PrincipalG.jsp'>Regresar</a>");
            out.println("</body>");
            out.println("</html>");
           }else{
               out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>EliminarPaquete</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Se cancelo la operación</h1>");
            out.println("<a href='PrincipalG.jsp'>Regresar</a>");
            out.println("</body>");
            out.println("</html>");
           }
        } catch (IOException ex) {
            ex.printStackTrace();
        }catch(SQLException e){
        e.printStackTrace();
        }finally{
            out.close();
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
