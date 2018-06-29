
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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet(name = "RegistrarE", urlPatterns = {"/RegistrarE"})
@MultipartConfig
public class RegistrarE extends HttpServlet {
    
    private final static Logger LOGGER =  Logger.getLogger(RegistrarE.class.getCanonicalName());
    
    public  RegistrarE(){
        super();
    }

 


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
// for (Part part : request.getParts()) {
//     try {
//         
//    // Create path components to save the file
//    final String path = "C:/Users/granq/Documents/NetBeansProjects/SWPR/web/imgUsuario/";
//    final Part filePart = request.getPart("imagen");
//    final String fileName = getFileName(filePart);
//
//    OutputStream out = null;
//    InputStream filecontent = null;
//    final PrintWriter writer = response.getWriter();
//               String mensaje,u;
//     datosGerente m= new datosGerente();
//     InsertarE ob= new InsertarE();
//     String n,ap,am,te,ti,us,co,rf,direc,im,im2;
//    
//     n=request.getParameter("nombre");
//     ap=request.getParameter("apellido_p");
//     am=request.getParameter("apellido_m");
//     te=request.getParameter("telefono");
//     ti=request.getParameter("tipo");
//     us=request.getParameter("usuario");
//     co=request.getParameter("contrasena");
//     rf=request.getParameter("rfc");
//     direc=request.getParameter("direccion");
//     im=request.getParameter("imagen");
//     
//     
//     m.setEstado("ACTIVO");
//       m.setNombre(n);
//       m.setApellido_p(ap);
//       m.setApellido_m(am);
//       m.setTelefono(te);
//       m.setTipo_usuario(ti);
//       m.setUsuario(us);
//       m.setContrasena(co);
//       m.setRfc(rf);
//       m.setDireccion(direc);
//     
//      if (ob.buscar(us)){
//          if (ob.buscar2(rf)){
//              mensaje="Ese empleado ya esta registrado";
//                request.setAttribute("mensaje",mensaje);////+fi
//                request.getRequestDispatcher("GestionEmpleados.jsp").forward(request, response);
//
//          }else{
//               
////          
////     FileItemFactory factory = new DiskFileItemFactory();
////            ServletContext servletContext = this.getServletConfig().getServletContext();
////            File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
////            ServletFileUpload upload = new ServletFileUpload(factory);
////            List<FileItem> items = upload.parseRequest(request);
////            for (FileItem item : items) {
////                if (!item.isFormField()) {
////                   String fileName = item.getName();
////                    String contentType = item.getContentType();
////                    String ruta = request.getParameter("ruta")+"imagenes/";
////                    File archivo_server = new File("C:/Users/granq/Documents/NetBeansProjects/SWPR/web/imgUsuario/"+item.getName());
//////                       "G:/archivos/web/imagenes/"     + "
//////                      C:/Users/Araceli/Documents/Tecamac/MayoAgosto_17/Aplicaciones WEB/archivos/"+item.getName());
//////				/*y lo escribimos en el servido*/
////		    item.write(archivo_server);
////                  im2="imgUsuario/"+item.getName();
////                   m.setImg(im2);
////             break;
////                }
////            
////            }
////////////////////////////////////////////////////////////////////////////////7
// try {
//       out = new FileOutputStream(new File(path + File.separator
//                + fileName));
//        filecontent = filePart.getInputStream();
//        int read = 0;
//        final byte[] bytes = new byte[1024];
//        while ((read = filecontent.read(bytes)) != -1) {
//            out.write(bytes, 0, read);
//        }
////        writer.println("New file " + fileName + " created at " + path);
////        LOGGER.log(Level.INFO, "File{0}being uploaded to {1}", 
////                new Object[]{fileName, path});
//         im2="imgUsuario/"+fileName;
//                  m.setImg(im2);
//    } catch (FileNotFoundException fne) {}
////        writer.println("You either did not specify a file to upload or are "
////                + "trying to upload a file to a protected or nonexistent "
////                + "location.");
////        writer.println("<br/> ERROR: " + fne.getMessage());
////
////        LOGGER.log(Level.SEVERE, "Problems during file upload. Error: {0}", 
////                new Object[]{fne.getMessage()});
////    } finally {
////        if (out != null) {
////            out.close();
////        }
////        if (filecontent != null) {
////            filecontent.close();
////        }
////        if (writer != null) {
////            writer.close();
////        }
////    }
//
/////////////////////////////////////////////////////////////////////////////////
//            ob.insertarE(m);
//           
//                      
//          }
//          mensaje="EMPLEADO REGISTRADO";
//             request.setAttribute("mensaje",mensaje);////+fileName+contentType+size);
//               request.getRequestDispatcher("GestionEmpleados.jsp").forward(request, response);
//               
//              // response.sendRedirect("GestionEmpleados.jsp");
//      }else{
//             mensaje="Usuario Repetido";
//           request.setAttribute("mensaje",mensaje);
//           request.getRequestDispatcher("GestionEmpleados.jsp").forward(request, response);
//      
//      }
//      
//     
//           
//        } catch (Exception e) {
//            System.out.println(""+e);
//        }
//    }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        for (Part part : request.getParts()) {//for para recorrer el tamaño del archivo
     try {
      PrintWriter out5 = response.getWriter(); 
    // IMPORTANTE DECLARAR ESTAS CONSTANTES
    //EL STRING PATH DEBE IR CON LA RUTA DE TU PC
    //request.getPart(aqui va el nombre que le envia ajax en el post ID)
    final String path = "C:/Users/granq/Documents/NetBeansProjects/SWPR/web/imgUsuario/";
//     final String path = "C:/jonathan/granq/Documents/NetBeansProjects/SWPR/web/imgUsuario/";
    final Part filePart = request.getPart("imagen");
    final String fileName = getFileName(filePart);

    OutputStream out = null;
    InputStream filecontent = null;
     // lo de arriba para lo de la imagen

    final PrintWriter writer = response.getWriter();
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
     
      if (ob.buscar(us)){
          if (ob.buscar2(rf)){
              mensaje="Ese empleado ya esta registrado";
               out5.println(mensaje);
          }else{
  
///////////////////////////////CODIGO PARA GUARDAR LA IMAGEN///////////////////////////////////////////////7
 try {
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
                  m.setImg(im2);
    } catch (FileNotFoundException fne) {}
//        writer.println("You either did not specify a file to upload or are "
//                + "trying to upload a file to a protected or nonexistent "
//                + "location.");
//        writer.println("<br/> ERROR: " + fne.getMessage());
//
//        LOGGER.log(Level.SEVERE, "Problems during file upload. Error: {0}", 
//                new Object[]{fne.getMessage()});
//    } finally {
//        if (out != null) {
//            out.close();
//        }
//        if (filecontent != null) {
//            filecontent.close();
//        }
//        if (writer != null) {
//            writer.close();
//        }
//    }

///////////////////////////////////hasta aqui////////////////////////////////////////////
            ob.insertarE(m);
           
                      
          }
          mensaje="EMPLEADO REGISTRADO";
                out5.println(mensaje);
      }else{
             mensaje="Usuario Repetido";
             out5.println(mensaje);
      }
      
     out5.close();
           
        } catch (Exception e) {
            System.out.println(""+e);
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
