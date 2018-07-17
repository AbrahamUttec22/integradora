
package ServletJonathan;

import Conexion.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ObtencionD", urlPatterns = {"/ObtencionD"})
public class ObtencionD extends HttpServlet {
ResultSet cdr=null;
    Statement sentenciaSQL=null;
    Conexion conecta=new Conexion();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
         super.init(config);
        conecta.Conectar();
        sentenciaSQL= conecta.getSentenciaSQL();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	   throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
	   /* TODO output your page here. You may use following sample code. */
	   out.println("<!DOCTYPE html>");
	   out.println("<html>");
	   out.println("<head>");
	   out.println("<title>Servlet ObtencionD</title>");	   
	   out.println("</head>");
	   out.println("<body>");
	   out.println("<h1>Servlet ObtencionD at " + request.getContextPath() + "</h1>");
	   out.println("</body>");
	   out.println("</html>");
        }
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	   throws ServletException, IOException {
     PrintWriter out = response.getWriter();           
            
     
     
     
out.println("<select id=pedido>");
out.println("<option value=0 >Eliga tipo de pedido</option>");
out.println("<option value=1>Domicilio");
out.println("</option>");
out.println("<option value=2>Local");
out.println("</option>");
 out.println("<option value=3>Local con reserva de mesa");
out.println("</option>");
out.println("</select>");
out.println("<br><br>");
//	   out.println("Direccion: <input type=text id=direccion value=direccion>");
	   out.println("<input type=button id=ordenarcomida onclick=ordenarcomida(); value='Oredenar Comida'>");
//        
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
