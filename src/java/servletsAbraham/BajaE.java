
package servletsAbraham;

import Clases_aca.InsertarE;
import datosGerente.datosGerente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "BajaE", urlPatterns = {"/BajaE"})
public class BajaE extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BajaE</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BajaE at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String rfc,mensaje;
        rfc=request.getParameter("rfc");
        datosGerente m= new datosGerente();
     InsertarE ob= new InsertarE();
    if(ob.buscarrf(rfc)){
       m.setRfc(rfc);
       ob.eliminar(m);
       mensaje="Empleado dado de baja";
        request.setAttribute("mensaje",mensaje);
        request.getRequestDispatcher("GestionEmpleados.jsp").forward(request, response);
      }else {
        mensaje="Ese empleado no existe";
         request.setAttribute("mensaje",mensaje);
          request.getRequestDispatcher("GestionEmpleados.jsp").forward(request, response);
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
