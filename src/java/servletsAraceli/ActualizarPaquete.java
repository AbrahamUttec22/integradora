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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        int id=Integer.parseInt(request.getParameter("id"));
                try{
           String strComando="SELECT * FROM paquete where id_paquete="+id;
            cdr=sentenciaSQL.executeQuery(strComando);
            while(cdr.next()){
                out.println("<br/><br/><form align=center>Nombre: &nbsp&nbsp<input type=text value='"+cdr.getString("nombre_paquete")+"'id=nombre readonly=>");
                out.println("<br/><br/><br/>Precio:&nbsp&nbsp$<input type=text value='"+cdr.getString("precio")+"' id=pre >");
 out.println("<br/><br/><br/>Descripcion:&nbsp&nbsp<textarea id=desc >"+cdr.getString("descripcion")+"</textarea>");          
           out.println("<br/><br/><br/><input type=button value='Guardar cambios' onclick=GuardarCambios();>");
           out.println("&nbsp&nbsp&nbsp&nbsp<input type=button value='Cancelar' onclick=Mostrar();></form>");
            } 
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
         response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();
        String nombre, descripcion;
        double precio;       
        try{
          nombre=request.getParameter("nombre");
         descripcion=request.getParameter("desc");
         precio=Double.parseDouble(request.getParameter("pre"));
           sentenciaSQL.executeUpdate("UPDATE paquete SET precio="+precio+", descripcion='"+descripcion+"' WHERE nombre_paquete='"+nombre+"'");
            out.println("El registro se actualiz&oacute; exitosamente");
        } catch (SQLException ex) {
       out.print(ex);
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
