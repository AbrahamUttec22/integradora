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

@WebServlet(name = "GestionesPaquetes", urlPatterns = {"/GestionesPaquetes"})
public class GestionesPaquetes extends HttpServlet {
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
            out.println("<title>Servlet GestionesPaquetes</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GestionesPaquetes at " + request.getContextPath() + "</h1>");
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
        int id;
       try (PrintWriter out = response.getWriter()) {           
           id=Integer.parseInt(request.getParameter("numero"));
//                    sentenciaSQL.executeUpdate("DELETE FROM vuelo WHERE NoVuelo="+id);      
                    out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Actualizar Paquete</title>");   
            out.println("<link href=css/abra.css rel='stylesheet'> ");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>¿Desea eliminar el paquete?</h1>");
            out.println("<form method='post' action='http://localhost:9090/SWPR/EliminarPaquete'>");
            out.println("<p>SI<input type='radio' value='si' name='opc'> </p>"); 
             out.println("<input type='hidden' value='"+id+"' name=id>");
            out.println("<p>NO<input type='radio' value='no'name='opc'> </p>");
            out.println("<p><input type='submit' value='Eliminar' class='submits'>");
            out.println("</form>");
            out.println("<br/><br/>");
            out.println("<a href='PrincipalG.jsp'>Regresar</a>");
            out.println("</body>");
            out.println("</html>");  
        } catch (IOException ex) {
            out.println(ex);
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
        PrintWriter out=response.getWriter();
        String id;
        try{
            id=request.getParameter("numero");
            String strComando="SELECT * FROM paquete where id_paquete="+id+"";
            cdr=sentenciaSQL.executeQuery(strComando);
                    if(cdr.next()){
               out.println("<html><head><title>VuelosPiloto</title></head>");
            out.println(" <link href=\"css/abra.css\" rel=\"stylesheet\">");
            out.println(" <h1>Actualizar Paquete</h1>");
            out.println("<form method='post' action='http://localhost:9090/SWPR/ActualizarPaquete' class='form__top'> <br/>");
            out.println("<p>id Paquete&nbsp <input type='text' value='"+cdr.getInt("id_paquete")+"' readonly='readonly' name='id_paquete' required= ></p><br/><br/>");
            out.println("<p>Nombre &nbsp <input type='text' value='"+cdr.getString("nombre_paquete")+"' name='nombre_paquete' required=></p><br/><br/> ");                   
            out.println("<p>Precio &nbsp <input type='text' value='"+cdr.getString("precio")+"' name='precio'required=></p><br/><br/>");
            out.println("<p>Descripción &nbsp <input type='text' value='"+cdr.getString("descripcion")+"' name='descripcion' required=></p><br/><br/>");
            out.println("<p>Imagen &nbsp <input type='file' value='"+cdr.getString("imagen")+"' name='imagen' required= ></p><br/><br/>");
            out.println("<p> <input type='submit' value='Guardar Cambios' class='btn__submit'></p>");
            out.println("</form>");
                    }
                out.println("<a href=PrincipalG.jsp>Regresar</a></body></html>");
        }catch(SQLException e){
            out.println(e);
    }
        catch(NullPointerException e){
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
