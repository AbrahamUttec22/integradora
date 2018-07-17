
package servletsAbraham;

import Conexion.Conexion;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "ActualizarG", urlPatterns = {"/ActualizarG"})
@MultipartConfig
public class ActualizarG extends HttpServlet {
        
    private final static Logger LOGGER =  Logger.getLogger(RegistrarE.class.getCanonicalName());
    public ActualizarG(){
        super();
    }

    
    
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
//        String im2,rfc,nombre,apellido_p,apellido_m,telefono,tipo,usuario,contra,bo,rfc2,direccion,imagen;
//       
//         response.setContentType("text/html;charset=UTF-8");
//       PrintWriter out= response.getWriter();
//        int x=Integer.parseInt(request.getParameter("no"));
//       direccion=request.getParameter("direccion");
//       imagen=request.getParameter("imagen");
//        im2="imgUsuario/"+imagen;
//       nombre=request.getParameter("nombre");
//       apellido_p=request.getParameter("ap");
//       apellido_m=request.getParameter("am");
//       telefono=request.getParameter("telefono");
//       tipo=request.getParameter("tipo");
//       usuario=request.getParameter("usuario");
//       contra=request.getParameter("contrasena");
//        rfc=request.getParameter("rfc");
//         rfc2=request.getParameter("rfc2");
//        bo=request.getParameter("enviar");
//       int cont=0;
//     
//        try {
//   String strComando="select * from empleado em inner join sesion se on se.id_usuario=em.id_usuario where em.id_usuario='"+x+"'";
//   cdr=sentenciaSQL.executeQuery(strComando);             
//     /////////////
//            while (cdr.next()) {
//    id_e=cdr.getString("id_empleado");
//    id_u=cdr.getString("id_usuario");
//    id_em=Integer.parseInt(id_e);
//    id_us=Integer.parseInt(id_u);
//            }
// final String sql="{call ActualizarEmpleado(?,?,?,?,?,?,?,?,?,?,?,?) }";//declaramos una constante que contendra el nombre del procedimiento almacenado
//
//CallableStatement cs=conecta.getConexion().prepareCall(sql);
//cs.setString(1, nombre);//s
//cs.setString(2, apellido_p);//
//cs.setString(3, apellido_m);//
//cs.setString(4, rfc2);//
//cs.setString(5, telefono);//
//cs.setString(6, tipo);//
//cs.setString(7, usuario);//
//cs.setString(8, contra);//
//cs.setInt(9, id_em);//
//cs.setInt(10, id_us);//
//cs.setString(11, direccion);//
//cs.setString(12, im2);//
//cs.executeQuery();//usamos executeQuery por que son registros
// 
// ////////////////////////////////////////////////////////
// RequestDispatcher rd=null;
//       request.setAttribute("mensaje","Datos del empleado actualizados");
//        rd=request.getRequestDispatcher("GestionEmpleados.jsp");
//        rd.forward(request, response);
//
//        } catch (SQLException e) {
//            out.println("excepcion sql: "+e);
//        }catch (NullPointerException e) {
//            out.println("apuntando sql: "+e);
//        }
//     
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        for (Part part : request.getParts()) {
            String rfc,nombre,apellido_p,apellido_m,telefono,tipo,usuario,contra,bo,rfc2,direccion,imagen,estado;
        int x=Integer.parseInt(request.getParameter("no"));
     
 ////////////////////////////IMAGEN//////////////////////////////// 
 String im2="";
            try {
                 String strComando="select * from empleado em inner join sesion se on se.id_usuario=em.id_usuario where em.id_usuario='"+x+"'";
   cdr=sentenciaSQL.executeQuery(strComando);             
     /////////////
            while (cdr.next()) {
    id_e=cdr.getString("id_empleado");
    id_u=cdr.getString("id_usuario");
    id_em=Integer.parseInt(id_e);
    id_us=Integer.parseInt(id_u);
   es=cdr.getString("estado");
            }
            } catch (Exception e) {
            }
   
     
  
     try {
    if (es.equals("ACTIVO")){
            
// final String path = "C:/Users/granq/Documents/NetBeansProjects/SWPR/web/imgUsuario/";
 final String path = "C:\\Users\\Oswaldo\\Desktop\\SWPR\\web\\imgUsuario\\";
    final Part filePart = request.getPart("imagen");
    final String fileName = (String) getFileName(filePart);
    OutputStream out = null;
    InputStream filecontent = null;
    final PrintWriter writer = response.getWriter();
       out = new FileOutputStream(new File(path + File.separator
                + fileName));
        filecontent = filePart.getInputStream();
        int read = 0;
        final byte[] bytes = new byte[1024];
        while ((read = filecontent.read(bytes)) != -1) {
            out.write(bytes, 0, read);
        }
//        writer.println("New file " + fileName + " created at " + path);
//        LOGGER.log(Level.INFO, "File{0}being uploaded to {1}", 
//                new Object[]{fileName, path});
         im2="imgUsuario/"+fileName;
        }
    } catch (FileNotFoundException fne) {
         System.out.println("error"+fne);
    }   
 ////////////////////////////////////////////////////////////
     
      
       direccion=request.getParameter("direccion");
      
       // im2="imgUsuario/"+imagen;
       
       if (im2.equals("")){
            imagen=request.getParameter("bno");
           im2=imagen;
       }
       nombre=request.getParameter("nombre");
       apellido_p=request.getParameter("ap");
       apellido_m=request.getParameter("am");
       telefono=request.getParameter("telefono");
       tipo=request.getParameter("tipo");
       usuario=request.getParameter("usuario");
       contra=request.getParameter("contrasena");
      // rfc=request.getParameter("rfc");
       rfc2=request.getParameter("rfc2");
       // bo=request.getParameter("enviar");
       estado=request.getParameter("estado");
       String strComand5="";
            try {
                  if (estado.equalsIgnoreCase("ACTIVO") || estado.equalsIgnoreCase("inactivo")){
       strComand5="update empleado set estado='"+estado+"' where id_usuario='"+x+"'";
   sentenciaSQL.executeUpdate(strComand5);         
       } 
            } catch (Exception e) {
            }
    
       
       
       int cont=0;
     
        try {

 final String sql="{call ActualizarEmpleado(?,?,?,?,?,?,?,?,?,?,?,?) }";//declaramos una constante que contendra el nombre del procedimiento almacenado

CallableStatement cs=conecta.getConexion().prepareCall(sql);
cs.setString(1, nombre);//s
cs.setString(2, apellido_m);//
cs.setString(3, apellido_p);//
cs.setString(4, rfc2);//
cs.setString(5, telefono);//
cs.setString(6, tipo);//
cs.setString(7, usuario);//
cs.setString(8, contra);//
cs.setInt(9, id_em);//
cs.setInt(10, id_us);//
cs.setString(11, direccion);//
cs.setString(12, im2);//
cs.executeQuery();//usamos executeQuery por que son registros

 RequestDispatcher rd=null;
       request.setAttribute("mensaje","Datos del empleado actualizados");
        rd=request.getRequestDispatcher("GestionEmpleados.jsp");
        rd.forward(request, response);

        } catch (SQLException e) {
            System.out.println("excepcion sql: "+e);
        }catch (NullPointerException e) {
            System.out.println("apuntando sql: "+e);
        }
     
    }
    }
       
 private String getFileName(final Part part) {
    final String partHeader = part.getHeader("content-disposition");
    LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
    for (String content : part.getHeader("content-disposition").split(";")) {
        if (content.trim().startsWith("filename")) {
            return content.substring(
                    content.indexOf('=') + 1).trim().replace("\"", "");
        }
    }
    return null;
}
    
    
    
    
    
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
