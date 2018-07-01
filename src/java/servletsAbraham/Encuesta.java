
package servletsAbraham;

import Conexion.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@MultipartConfig
@WebServlet(name = "Encuesta", urlPatterns = {"/Encuesta"})
public class Encuesta extends HttpServlet {
      ResultSet cdr=null;
    Statement sentenciaSQL=null;
    Conexion conecta= new Conexion();
   
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
            out.println("<title>Servlet Encuesta</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Encuesta at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         PrintWriter out= response.getWriter();
             try {
       String resp1,resp2,resp3,resp4,resp5,ocul;
     resp1=request.getParameter("a");
     resp2=request.getParameter("b");
     resp3=request.getParameter("c");
     resp4=request.getParameter("d");
     resp5=request.getParameter("e");

     int cont1=0,cont2=0,cont3=0;
     String cal="";
     ////////////////////////////////////////////////////////
     if (resp1.equals("R")){
         cont1++;
     }
     if (resp2.equals("R")){
         cont1++;
     }
     if (resp3.equals("R")){
         cont1++;
     }
     if (resp4.equals("R")){
         cont1++;
     }
     if (resp5.equals("R")){
         cont1++;
     }
    //////////////////////////////////////////////////////////////////////7 
    ////////////////////////////////////////////////////////
     if (resp1.equals("B")){
         cont2++;
     }
     if (resp2.equals("B")){
         cont2++;
     }
     if (resp3.equals("B")){
         cont2++;
     }
     if (resp4.equals("B")){
         cont2++;
     }
     if (resp5.equals("B")){
         cont2++;
     }
    //////////////////////////////////////////////////////////////////////7 
    ////////////////////////////////////////////////////////
     if (resp1.equals("E")){
         cont3++;
     }
     if (resp2.equals("E")){
         cont3++;
     }
     if (resp3.equals("E")){
         cont3++;
     }
     if (resp4.equals("E")){
         cont3++;
     }
     if (resp5.equals("E")){
         cont3++;
     }
     ////////////////////////////////////////////
     if(cont1 > cont2)
           if(cont1>cont3)
              cal="REGULAR";
           else
             cal="EXCELENTE";
     else if(cont2>cont3)
              cal="BUENA";
                else
              cal="EXCELENTE";
    
    //////////////////////////////////////////////////////////////////////7 
out.print("<br><br> Gracias por evaluarnos");
    
String sql="insert into encuesta values(null,'"+datosCliente.datosCliente.id_usuario+"','"+cal+"',curdate())";                   
         sentenciaSQL.executeUpdate(sql);
String sql2="update pedido_evento set estatus='Encuesta_Realizada' where fecha='"+datosCliente.datosCliente.fecha_pedido+"' and id_usuario='"+datosCliente.datosCliente.id_usuario+"'";                   
         sentenciaSQL.executeUpdate(sql2);

out.close();
        //////////////////////////////////
        } catch (Exception e) {
            System.out.println("error"+e);
        }
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
