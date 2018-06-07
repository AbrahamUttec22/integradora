
package servletsAbraham;

import Clases_aca.*;
import Conexion.*;
import datosCliente.*;
import datosGerente.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

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
//     String fileName="";
//      long size=0;
//      String contentType="";
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
//     FileItemFactory factory = new DiskFileItemFactory();
//            ServletContext servletContext = this.getServletConfig().getServletContext();
//            File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
//            ServletFileUpload upload = new ServletFileUpload(factory);
//            List<FileItem> items = upload.parseRequest(request);
//            for (FileItem item : items) {
//                if (!item.isFormField()) {
//                   String fileName = item.getName();
//                    String contentType = item.getContentType();
//                    //String ruta = request.getParameter("ruta")+"imagenes/";
//                    File archivo_server = new File("C:/Users/granq/Documents/NetBeansProjects/SWPR/web/imgUsuario/"+item.getName());
//                      // "G:/archivos/web/imagenes/"     + "
//                      //C:/Users/Araceli/Documents/Tecamac/MayoAgosto_17/Aplicaciones WEB/archivos/"+item.getName());
//				/*y lo escribimos en el servido*/
//		    item.write(archivo_server);
//                    long size = item.getSize();
////                    request.setAttribute("fileName", fileName);
////                    request.setAttribute("contentType", contentType);
////                    request.setAttribute("size", size);
//                   
//                }
//                break;
//            }
          request.setAttribute("mensaje",mensaje);////+fileName+contentType+size);
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
       try {
               String mensaje,u;
     datosGerente m= new datosGerente();
     InsertarE ob= new InsertarE();
     String n,ap,am,te,ti,us,co,rf,direc,im,im2;
//     String fileName="";
//      long size=0;
//      String contentType="";
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
//     FileItemFactory factory = new DiskFileItemFactory();
//            ServletContext servletContext = this.getServletConfig().getServletContext();
//            File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
//            ServletFileUpload upload = new ServletFileUpload(factory);
//            List<FileItem> items = upload.parseRequest(request);
//            for (FileItem item : items) {
//                if (!item.isFormField()) {
//                   String fileName = item.getName();
//                    String contentType = item.getContentType();
//                    //String ruta = request.getParameter("ruta")+"imagenes/";
//                    File archivo_server = new File("C:/Users/granq/Documents/NetBeansProjects/SWPR/web/imgUsuario/"+item.getName());
//                      // "G:/archivos/web/imagenes/"     + "
//                      //C:/Users/Araceli/Documents/Tecamac/MayoAgosto_17/Aplicaciones WEB/archivos/"+item.getName());
//				/*y lo escribimos en el servido*/
//		    item.write(archivo_server);
//                    long size = item.getSize();
////                    request.setAttribute("fileName", fileName);
////                    request.setAttribute("contentType", contentType);
////                    request.setAttribute("size", size);
//                   
//                }
//                break;
//            }
          request.setAttribute("mensaje",mensaje);////+fileName+contentType+size);
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
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
