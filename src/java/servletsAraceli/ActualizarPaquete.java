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
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ActualizarPaquete", urlPatterns = {"/ActualizarPaquete"})
public class ActualizarPaquete extends HttpServlet {
ResultSet cdr=null;
Statement sentenciaSQL=null;
Conexion conecta=new Conexion();

@Override
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
            out.println("<title>Servlet ActualizarPaquete</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ActualizarPaquete at " + request.getContextPath() + "</h1>");
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
        String nombre, descripcion, imagen;
        double precio;
        int id;
        try(PrintWriter out = response.getWriter()){
            id=Integer.parseInt(request.getParameter("id_paquete"));
          nombre=request.getParameter("nombre_paquete");
         descripcion=request.getParameter("descripcion");
         imagen="img/"+request.getParameter("imagen");
         precio=Double.parseDouble(request.getParameter("precio"));
           sentenciaSQL.executeUpdate("UPDATE paquete SET nombre_paquete='"+nombre+"', precio="+precio+", descripcion='"+descripcion+"', imagen="+imagen+"' WHERE id_paquete="+id+"");
        out.println(sentenciaSQL);
           out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Actualizar Paquete</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>El registro se actualizo exitosamente</h1>");
            out.println("<a href=ConsultarPaquete.jsp>Regresar</a>");
            out.println("<a href=Menu.jsp>Menú principal</a>");
            out.println("</body>");
            out.println("</html>");  
       } catch (IOException ex) {
            out.println(ex);
            ex.printStackTrace();
        }catch(SQLException e){
        e.printStackTrace();
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
        String nombre, descripcion, imagen;
        double precio;
        int id;
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             id=Integer.parseInt(request.getParameter("id_paquete"));
          nombre=request.getParameter("nombre_paquete");
         descripcion=request.getParameter("descripcion");
         imagen=request.getParameter("imagen");
         precio=Double.parseDouble(request.getParameter("precio"));
           sentenciaSQL.executeUpdate("UPDATE paquete SET nombre_paquete='"+nombre+"', precio="+precio+", descripcion='"+descripcion+"', imagen='img/"+imagen+"' WHERE id_paquete="+id+"");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Actualizar Paquete</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>El registro se actualizo exitosamente</h1>");
            out.println("<a href=ConsultarPaquete.jsp>Regresar</a>");
            out.println("<a href=PrincipalG.jsp>Menú principal</a>");
            out.println("</body>");
            out.println("</html>"); 
        } catch (SQLException ex) {
        Logger.getLogger(ActualizarPaquete.class.getName()).log(Level.SEVERE, null, ex);
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
