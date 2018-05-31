
package servletsAbraham;

import Clases_aca.InsertarE;
import Conexion.Conexion;
import datosCliente.datosCliente;
import datosGerente.datosGerente;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
     String n,ap,am,te,ti,us,co;
     n=request.getParameter("nombre");
     ap=request.getParameter("apellido_p");
     am=request.getParameter("apellido_m");
     te=request.getParameter("telefono");
     ti=request.getParameter("tipo");
     us=request.getParameter("usuario");
     co=request.getParameter("contrasena");
     m.setEstado("ACTIVO");
       m.setNombre(n);
       m.setApellido_p(ap);
       m.setApellido_m(am);
       m.setTelefono(te);
       m.setTipo_usuario(ti);
       m.setUsuario(us);
       m.setContrasena(co);
      if (ob.buscar(us)){
          mensaje="EMPLEADO REGISTRADO";
          ob.insertarE(m);
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
