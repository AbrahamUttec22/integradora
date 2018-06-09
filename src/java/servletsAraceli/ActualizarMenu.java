package servletsAraceli;

import Conexion.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ActualizarMenu", urlPatterns = {"/ActualizarMenu"})
public class ActualizarMenu extends HttpServlet {
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
            out.println("<title>Actualizar Menú</title>");
out.println("<link href=\"css/abra.css\" rel=\"stylesheet\">");

            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Actualizar menú del día</h1>");
out.println("<form method=POST action=http://localhost:9090/SWPR/ActualizarMenu class=form__top>");
out.println("<label>Descripción del Menú</label><br/>");
out.println(" <textarea name=\"descripcion\" values rows=\"10\" cols=\"40\" name='descripcion' required=>");
Conexion conexion= new Conexion();
                      conexion.Conectar();
                      Statement sentenciaSQL=null;
                        try{
                            String strComando="Select descripcion from menu_dia where id_menu=(SELECT MAX(id_menu) from menu_dia)";
            sentenciaSQL=conexion.getSentenciaSQL();
            ResultSet cdr=sentenciaSQL.executeQuery(strComando);
            while (cdr.next()){
                out.println(cdr.getString("descripcion"));
            } }catch(SQLException e){
            out.println(e);    } 
out.println(" </textarea><br/><br/><br/><label>Precio</label>&nbsp;&nbsp;&nbsp;$<input type=\"text\" name=\"precio\" value=\"");
try{
                            String strComando="Select precio from menu_dia where id_menu=(SELECT MAX(id_menu) from menu_dia)";
            sentenciaSQL=conexion.getSentenciaSQL();
            ResultSet cdr=sentenciaSQL.executeQuery(strComando);
            while (cdr.next()){
                out.println(cdr.getString("precio"));
            } }catch(SQLException e){
            out.println(e);    } 
out.println("\" name=\"precio\" required=><br/><br/><br/>");
out.println("<input type='file' name='imagen' required=><br/><br/><br/>");
out.println("<input type=\"submit\" value=\"Guardar Cambios\" class=\"btn__submit\"></form>");
out.println("<label><a href=\"PrincipalG.jsp\">Regresar</a></label>");
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
        response.setContentType("text/html;charset=UTF-8");
        String descripcion, imagen;
        int id = 0;
        double precio;
        try(PrintWriter out = response.getWriter()){
           descripcion=request.getParameter("descripcion");
         precio=Double.parseDouble(request.getParameter("precio"));
         imagen=request.getParameter("imagen");
         String strComando="select id_menu from menu_dia where id_menu=(SELECT MAX(id_menu) from menu_dia)";
            cdr=sentenciaSQL.executeQuery(strComando);
            while(cdr.next()){
               id=cdr.getInt("id_menu");
            } 
           sentenciaSQL.executeUpdate("UPDATE menu_dia SET descripcion='"+descripcion+"', precio="+precio+", imagen='img/"+imagen+"' WHERE id_menu="+id+"");
        out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<link href=\"css/abra.css\" rel=\"stylesheet\">");
            out.println("<head>");
            out.println("<title>Actualizar Menú</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>El menú de hoy se actualizo exitosamente</h1>");
            out.println("<a href=ConsultarMenu.jsp>Regresar</a>");
            out.println("</body>");
            out.println("</html>");  
       } catch (IOException ex) {
            out.println(ex);
        }catch(SQLException e){
        e.printStackTrace();
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
