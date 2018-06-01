
package servletsAbraham;

import Conexion.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ActualizarG", urlPatterns = {"/ActualizarG"})
public class ActualizarG extends HttpServlet {
      ResultSet cdr=null;
    Statement sentenciaSQL=null;
    Conexion conecta= new Conexion();
     String id_e="",id_u="";
        int id_em=0;
    int id_us=0;
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
            out.println("<title>Servlet ActualizarG</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ActualizarG at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String rfc,nombre,apellido_p,apellido_m,telefono,tipo,usuario,contra,bo,rfc2,direccion,imagen;
       
         response.setContentType("text/html;charset=UTF-8");
       PrintWriter out= response.getWriter();
       direccion=request.getParameter("direccion");
       imagen=request.getParameter("imagen");
       nombre=request.getParameter("nombre");
       apellido_p=request.getParameter("ap");
       apellido_m=request.getParameter("am");
       telefono=request.getParameter("telefono");
       tipo=request.getParameter("tipo");
       usuario=request.getParameter("usuario");
       contra=request.getParameter("contrasena");
        rfc=request.getParameter("rfc");
         rfc2=request.getParameter("rfc2");
        bo=request.getParameter("enviar");
       int cont=0;
     
        try {
            if (bo.equals("Buscar")){
   String strComando="select * from empleado em inner join sesion se on se.id_usuario=em.id_usuario where em.rfc='"+rfc+"' and em.estado='ACTIVO';";
   cdr=sentenciaSQL.executeQuery(strComando);             
     /////////////
            while (cdr.next()) {
    cont ++;
    request.setAttribute("no",cdr.getString("nombre"));
    request.setAttribute("ap",cdr.getString("apellido_p"));
    request.setAttribute("am",cdr.getString("apellido_m"));
    request.setAttribute("rfc",cdr.getString("rfc"));
    request.setAttribute("telefono",cdr.getString("telefono"));
    request.setAttribute("ti",cdr.getString("tipo_usuario"));
    request.setAttribute("us",cdr.getString("usuario"));
    request.setAttribute("co",cdr.getString("contrasena"));
    request.setAttribute("direccion",cdr.getString("direccion"));
    request.setAttribute("imagen",cdr.getString("imagen"));
    id_e=cdr.getString("id_empleado");
    id_u=cdr.getString("id_usuario");
    id_em=Integer.parseInt(id_e);
    id_us=Integer.parseInt(id_u);
    
            RequestDispatcher rd=null;
            rd=request.getRequestDispatcher("ActualizarG.jsp");
        rd.forward(request, response);
     }
     /////////////////////  
     if (cont==0){
            RequestDispatcher rd=null;
             request.setAttribute("mensaje","Ese usuario no existe");
        rd=request.getRequestDispatcher("ActualizarG.jsp");
        rd.forward(request, response);
     }                 
                
            
   }else if (bo.equals("Actualizar")){
 final String sql="{call ActualizarEmpleado(?,?,?,?,?,?,?,?,?,?,?,?) }";//declaramos una constante que contendra el nombre del procedimiento almacenado

CallableStatement cs=conecta.getConexion().prepareCall(sql);


cs.setString(1, nombre);//s
cs.setString(2, apellido_p);//
cs.setString(3, apellido_m);//
cs.setString(4, rfc2);//
cs.setString(5, telefono);//
cs.setString(6, tipo);//
cs.setString(7, usuario);//
cs.setString(8, contra);//
cs.setInt(9, id_em);//
cs.setInt(10, id_us);//
cs.setString(11, direccion);//
cs.setString(12, imagen);//
cs.executeQuery();//usamos executeQuery por que son registros
 
 ////////////////////////////////////////////////////////
 RequestDispatcher rd=null;
       request.setAttribute("mensaje","Datos del empleado actualizados");
        rd=request.getRequestDispatcher("ActualizarG.jsp");
        rd.forward(request, response);
   }
  

    
   //destroy();
   
        } catch (SQLException e) {
            out.println("excepcion sql: "+e);
        }catch (NullPointerException e) {
            out.println("apuntando sql: "+e);
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
