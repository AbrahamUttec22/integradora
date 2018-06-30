
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

@WebServlet(name = "ConsultaActualiza", urlPatterns = {"/ConsultaActualiza"})
public class ConsultaActualiza extends HttpServlet {
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
            out.println("<title>Servlet ConsultaActualiza</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ConsultaActualiza at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
          String sql="";
          int cont=0;
        PrintWriter out= response.getWriter();
   try {
      String rfc=request.getParameter("rfc");
  sql="select * from empleado em inner join sesion se on se.id_usuario=em.id_usuario where em.rfc='"+rfc+"' and em.estado='ACTIVO'";
cdr=sentenciaSQL.executeQuery(sql);


while (cdr.next()) { // con un while podremos recorrer las columnas del registro por eso usamos el next()
  cont++;
/////
out.println("<form enctype=multipart/form-data id=formuAc>");
out.println("<center><table border=1>");
out.println("<tr>");
out.println("<th>Nombre</th>");
out.println("<th>Paterno </th>");
out.println("<th>Materno </th>");
out.println("<th>RFC</th> ");
out.println("<th>Telefono</th>");
out.println("</tr>"); 

//////////////////////////
out.println("<tr>");
out.println("<td><input type=text value="+cdr.getString("nombre")+" name=nombre size=15></td>");
out.println("<td><input type=text value="+cdr.getString("apellido_p")+" name=ap size=\"15\"></td>");
out.println("<td><input type=text value="+cdr.getString("apellido_m")+" name=am size=\"15\"></td>");
out.println("<td><input type=text value="+cdr.getString("rfc")+" name=rfc2 size=\"15\"></td>");
out.println("<td><input type=text value="+cdr.getString("telefono")+" name=telefono size=\"25\"></td>");
out.println("</tr>");
out.println("<tr>");
out.println("<th>Tipo</th>");
out.println("<th>Usuario</th>");
out.println("<th>Contraseña</th>");
out.println("<th>Direccion</th>");
out.println("<th>Imagen</th>");
out.println("</tr>"); 
out.println("<tr>");
out.println("<td><input type=text value="+cdr.getString("tipo_usuario")+" name=tipo size=\"15\"></td>");
out.println("<td><input type=text value="+cdr.getString("usuario")+" name=usuario size=\"15\"></td>");
out.println("<td><input type=text value="+cdr.getString("contrasena")+" name=contrasena size=\"15\"></td>");
out.println("<td><input type=text value="+cdr.getString("direccion")+" name=direccion size=\"25\"></td>");
out.println("<td><input type=file  name=imagen size=\"15\"></td>");
out.println("<input type=hidden value="+cdr.getString("imagen")+" name=bno size=\"25\"> ");
out.println("<td><input type=hidden value="+cdr.getString("id_usuario")+" name=no ></td>");
out.println("</tr>"); 
 //////////////////////////
 out.println("</table>");
 out.println("<br><br><input type=button value=ACTUALIZAR onclick=actulizaEm();><br><br></center>");
 out.println("</form>");
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


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
