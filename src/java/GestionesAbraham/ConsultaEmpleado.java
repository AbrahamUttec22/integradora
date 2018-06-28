
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

@WebServlet(name = "ConsultaEmpleado", urlPatterns = {"/ConsultaEmpleado"})
public class ConsultaEmpleado extends HttpServlet {
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
            out.println("<title>Servlet ConsultaEmpleado</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ConsultaEmpleado at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
          String sql="";
        PrintWriter out= response.getWriter();
   
      //1 cocinero, 2 repartidor, 3 eliminados, 4 todos 
        try {
            String value=request.getParameter("tit");
  if(value.equals("1")){
      sql="select * from empleado em join sesion se on se.id_usuario=em.id_usuario where se.tipo_usuario='Cocinero' and em.estado='ACTIVO';";      
  }else if (value.equals("2")){
  sql="select * from empleado em join sesion se on se.id_usuario=em.id_usuario where se.tipo_usuario='Repartidor' and em.estado='ACTIVO';";
  }else if (value.equals("3")){
 sql="select * from empleado em inner join sesion se on se.id_usuario=em.id_usuario and em.estado='INACTIVO';";               
  }else if (value.equals("4")){
 sql="select * from empleado em inner join sesion se on se.id_usuario=em.id_usuario and em.estado='ACTIVO';";
  }
  cdr=sentenciaSQL.executeQuery(sql);  
  int bandera=0;
  out.println(" <table border=1 >");
  int contador=0;
  while(cdr.next()){
      if (bandera==0){
               out.println(" <tr>");
        out.println("<th>Nombre</th>");
        out.println("<th>Paterno </th>");
        out.println("<th>Materno </th>");
        out.println("<th>RFC</th> ");
        out.println("<th>Telefono</th> ");
        out.println("<th>Estado</th>  ");
        out.println("<th>Tipo</th> ");
        out.println("<th>Usuario</th> ");
        out.println("<th>Contraseña</th> ");
        out.println("<th>Direccion</th> ");
        out.println("<th>Imagen</th> ");
        out.println("</tr>");
          bandera++;
      }
      
           out.println("<tr>");
           out.println("<td><input type=hidden  id='nombre' value="+cdr.getString("nombre")+">" + cdr.getString("nombre") + "</td>");
           out.println("<td>" + cdr.getString("apellido_p") + "</td>");
           out.println("<td>" + cdr.getString("apellido_m") + "</td>");
           out.println("<td>" + cdr.getString("rfc") + "</td>");
           out.println("<td>" + cdr.getString("telefono") + "</td>");
           out.println("<td>" + cdr.getString("estado") + "</td>");
           out.println("<td>" + cdr.getString("tipo_usuario") + "</td>");
           out.println("<td>" + cdr.getString("usuario") + "</td>");
           out.println("<td>" + cdr.getString("contrasena") + "</td>");
           out.println("<td>" + cdr.getString("direccion") + "</td>");
           out.println("<td><img src="+cdr.getString("imagen")+" height=70></img></td>");
           out.println("</tr>");  
           contador++;
  }
  out.println(" </table>");
          out.close();
            
        } catch (Exception e) {
            System.out.println("error del servlet"+e);
        }
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
