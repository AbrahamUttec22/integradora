
package servletsAbraham;

import Clases_aca.InsertarE;
import Conexion.Conexion;
import datosCliente.datosCliente;
import datosGerente.datosGerente;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
//import org.apache.commons.fileupload.servlet.ServletFileUpload;
//import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
//import org.apache.commons.fileupload.disk.DiskFileItemFactory;


@WebServlet(name = "RegistrarE", urlPatterns = {"/RegistrarE"})
public class RegistrarE extends HttpServlet {
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegistrarE</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistrarE at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
               String mensaje,u;
     datosGerente m= new datosGerente();
     InsertarE ob= new InsertarE();
     String n,ap,am,te,ti,us,co,rf,direc,im,im2;
     n=request.getParameter("nombre");
     ap=request.getParameter("apellido_p");
     am=request.getParameter("apellido_m");
     te=request.getParameter("telefono");
     ti=request.getParameter("tipo");
     us=request.getParameter("usuario");
     co=request.getParameter("contrasena");
     rf=request.getParameter("rfc");
     direc=request.getParameter("direccion");
     im=request.getParameter("imagen");
     im2="imgUsuario/"+im;
     
     m.setEstado("ACTIVO");
       m.setNombre(n);
       m.setApellido_p(ap);
       m.setApellido_m(am);
       m.setTelefono(te);
       m.setTipo_usuario(ti);
       m.setUsuario(us);
       m.setContrasena(co);
       m.setRfc(rf);
       m.setDireccion(direc);
       m.setImg(im2);
      if (ob.buscar(us)){
          mensaje="EMPLEADO REGISTRADO";
          ob.insertarE(m);
//         
//String archivourl="C:\\Users\\granq\\Documents\\NetBeansProjects\\SWPR\\web\\imgUsuario";
//DiskFileItemFactory factory= new  DiskFileItemFactory (); 
//factory.setSizeThreshold(1024);
//factory.setRepository(new File(archivourl));
//ServletFileUpload upload= new ServletFileUpload( factory);
//List<FileItem> partes =upload.parseRequest((RequestContext) request);
//          for (FileItem items: partes) {
//              File file= new File (archivourl,items.getName());
//          items.write(file);
//         }
//     

          
          request.setAttribute("mensaje",mensaje);
          request.getRequestDispatcher("RegistraG.jsp").forward(request, response);
      }else{
           mensaje="ESE EMPLEADO YA ESTABA REGISTRADO";
           request.setAttribute("mensaje",mensaje);
           request.getRequestDispatcher("RegistraG.jsp").forward(request, response);
      }
     
        } catch (Exception e) {
            System.out.println(""+e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
     
     
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
