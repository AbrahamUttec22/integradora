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

@WebServlet(name = "SubirMenuDelDia", urlPatterns = {"/SubirMenuDelDia"})
public class SubirMenuDelDia extends HttpServlet {
ResultSet cdr=null, c=null;
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
            out.println("<title>Servlet SubirMenuDelDia</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SubirMenuDelDia at " + request.getContextPath() + "</h1>");
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
       response.setContentType("text/html");
        PrintWriter out=response.getWriter();  
        try{
            out.println("<form align=center><br/>Descripción<br/>");
            String strComando="Select * from menu_dia where id_menu=(SELECT MAX(id_menu) from menu_dia)";
            sentenciaSQL=conecta.getSentenciaSQL();
            ResultSet cdr=sentenciaSQL.executeQuery(strComando);
            while (cdr.next()){
                out.println("<textarea rows=5 cols=40>");
                out.println(cdr.getString("descripcion"));
                out.println("</textarea><br/><br/>");
                out.println("Precio: &nbsp&nbsp");
                out.println("$<input type=text id=precio value="+cdr.getString("precio")+">");
                out.println("<br/><br/><img src="+cdr.getString("imagen")+" width=20%>");
            } }catch(SQLException e){
            out.println(e);    } 
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
              response.setContentType("text/html");
        PrintWriter out=response.getWriter();      
         String desc, imagen, fecha="", fecha1="";
       double precio;
         try {
              precio=Double.parseDouble(request.getParameter("precio"));
        desc=request.getParameter("descripcion");
        imagen=request.getParameter("imagen");                        
           String strComando="select fecha from menu_dia where id_menu=(SELECT MAX(id_menu) from menu_dia)";
            cdr=sentenciaSQL.executeQuery(strComando);
            while(cdr.next()){
                fecha=cdr.getString("fecha");
            }          
             sentenciaSQL.executeUpdate("INSERT INTO menu_dia VALUES(null,'"+desc+"',"+precio+",'img/"+imagen+"', now())");
              String str="select fecha from menu_dia where id_menu=(SELECT MAX(id_menu) from menu_dia)";
            c=sentenciaSQL.executeQuery(str);
            while(c.next()){
                fecha1=c.getString("fecha");   
                if(fecha.equals(fecha1)){
                    int aux=0;
                    String a="(SELECT MAX(id_menu)as maximo from menu_dia)";
            c=sentenciaSQL.executeQuery(a);
            while(c.next()){
                aux=Integer.parseInt(c.getString("maximo"));
            }
                    sentenciaSQL.executeUpdate("delete from menu_dia where id_menu="+aux+"");
                     out.println("Ya existe menú para el día de hoy. Vuelve mañana");
            }else{
                   out.println("El Menú se subió exitosamente");
                } 
            }                       
        }catch(NullPointerException e){
//       out.println(e);
//       e.printStackTrace();
    } catch (SQLException ex) {
//         out.println(ex);
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
