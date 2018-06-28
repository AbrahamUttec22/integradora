
package GestionesAbraham;

import Conexion.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "eliminarEmpleado", urlPatterns = {"/eliminarEmpleado"})
public class eliminarEmpleado extends HttpServlet {

 ResultSet cdr=null;
    Statement sentenciaSQL=null;
    Conexion conecta= new Conexion();
     String id_e="",id_u="";
        int id_em=0;
    int id_us=0;
    String es;
    
  @Override
    public void init(ServletConfig config) throws ServletException {
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
            out.println("<title>Servlet eliminarEmpleado</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet eliminarEmpleado at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
        PrintWriter out= response.getWriter();
          int cont=0;
        try {
      String rfc=request.getParameter("rfc");
  String sql="select * from empleado em inner join sesion se on se.id_usuario=em.id_usuario where em.rfc='"+rfc+"' and em.estado='ACTIVO'";
cdr=sentenciaSQL.executeQuery(sql);


while (cdr.next()) { // con un while podremos recorrer las columnas del registro por eso usamos el next()
  cont++;
    out.println("<center><table>");
out.println("<tr>");
out.println("<th>Nombre</th>");
out.println("<th>RFC</th>");
out.println("<th>Imagen</th>");
out.println("</tr>"); 
 out.println("<tr>");
 out.println("<td>" + cdr.getString("nombre") + "</td>");
 out.println("<td>" + cdr.getString("rfc") + "</td>");
 out.println("<td><img src="+cdr.getString("imagen")+" height=70></img></td>");
          out.println("</tr>");
             out.println("</table>");
     out.println("<br><br><input type=submit value=ELIMINAR onclick=eliminarE();><br><br></center>");
       }
   } catch (Exception e) {
            System.out.println("error"+e);
  }
if (cont==0){
    out.println("1"); 
}
     
//        out.println("<meta http-equiv='refresh' content='3;URL='>");//redirects after 3 seconds
//   out.println("<p style='color:red;'>User or password incorrect!</p>");

     out.close();
    }

  
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
