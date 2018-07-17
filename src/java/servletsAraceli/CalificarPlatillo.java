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

/**
 *
 * @author Araceli
 */
@WebServlet(name = "CalificarPlatillo", urlPatterns = {"/CalificarPlatillo"})
public class CalificarPlatillo extends HttpServlet {
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
            out.println("<title>Servlet CalificarPlatillo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CalificarPlatillo at " + request.getContextPath() + "</h1>");
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
        int cal=Integer.parseInt(request.getParameter("cali"));
        String platillo = request.getParameter("pla");
        int id=Integer.parseInt(request.getParameter("id"));
        int id_platillo=0;
         try {        
              String strComando="SELECT id_platillo FROM platillo where nombre='"+platillo+"'";
            cdr=sentenciaSQL.executeQuery(strComando);
            if(cdr.next()){
                id_platillo=cdr.getInt("id_platillo");
            }
        sentenciaSQL.executeUpdate("INSERT INTO calificar_platillo VALUES (null,"+id+","+id_platillo+","+cal+",'calificado')");
         out.println("¡Platillo Calificado!"); 
       String strComando2="SELECT * FROM top_platillos where nombre_platillo='"+platillo+"'";
            cdr=sentenciaSQL.executeQuery(strComando2);
            if(cdr.next()){
                int con=1;
                int suma=cal;
                    con++;
                    int s=cdr.getInt("calificacion");
                    suma=suma+s;              
                double pro = suma/con;
                sentenciaSQL.executeUpdate("UPDATE top_platillos SET calificacion="+pro+" where nombre_platillo='"+platillo+"'");
            }else{
                sentenciaSQL.executeUpdate("INSERT INTO top_platillos VALUES (null,'"+platillo+"',"+cal+")");
            }
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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        String platillo = request.getParameter("pla");
        int id=Integer.parseInt(request.getParameter("id"));
        int id_platillo=0;
        try {        
              String strComando="SELECT id_platillo FROM platillo where nombre='"+platillo+"'";
            cdr=sentenciaSQL.executeQuery(strComando);
            if(cdr.next()){
                id_platillo=cdr.getInt("id_platillo");
            }
           int cal=0;
        sentenciaSQL.executeUpdate("INSERT INTO calificar_platillo VALUES (null,"+id+","+id_platillo+","+cal+",'calificado')");
         out.println("No se le volvera a mostrar este platillo");  
         }
        catch(SQLException e){
            out.println(e);
    }catch(NullPointerException e){
        out.println(e);
    }finally{
            out.close();
        }
  out.println("No se le volvera a mostrar este platillo");  
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
