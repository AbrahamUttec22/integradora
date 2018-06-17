
package servletsAbraham;

import Conexion.Conexion;
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


@WebServlet(name = "MesaGerente", urlPatterns = {"/MesaGerente"})
public class MesaGerente extends HttpServlet {

   String simandaOcupado="si";
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
            out.println("<title>Servlet MesaGerente</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MesaGerente at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
//////////////////////////////////////////////////////////////////////////////

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             response.setContentType("text/html;charset=UTF-8");
      PrintWriter out= response.getWriter();
        try {
            String ti=request.getParameter("tipo");
            out.print("<table>");
            verMesaD(ti,out);
            verMesaO(ti,out);
            out.print("</table>");
            out.close();
        } catch (Exception e) {
            System.out.println("error"+e);
        }
    }

    /////////////////////////////////////////////////////////////////////7
    
     public void verMesaD(String ti,PrintWriter out){
 
      try {
 final String sql="{call ConsultaMesaGerenteD(?) }";//declaramos una constante que contendra el nombre del procedimiento almacenado
int cont =0;
CallableStatement cs=conecta.getConexion().prepareCall(sql);
        cs.setString(1, ti);
cdr=cs.executeQuery();//usamos executeQuery por que son registros
out.print("<tr>");
        while(cdr.next()){
         cont++;  
             out.print("<td>");
  out.print("<input  style='background-color: #7FFF00'   type='submit' value="+cdr.getString(1)+"> <br>");
  //out.print(cdr.getString(1));
   out.print("</td>");
        }
        out.print("</tr>");
     
        } catch (Exception e) {
               System.out.println("error procedimiento"+e);
        }
    }
      /////////////////////////////////////////////////////////////////////7
     public void verMesaO(String ti,PrintWriter out){
 
      try {
 final String sql="{call ConsultaMesaGerenteO(?) }";//declaramos una constante que contendra el nombre del procedimiento almacenado
int cont =0;
CallableStatement cs=conecta.getConexion().prepareCall(sql);
 cs.setString(1, ti);
cdr=cs.executeQuery();//usamos executeQuery por que son registros
out.print("<tr>");
        while(cdr.next()){
         cont++;  
             out.print("<td>");
  out.print("<input  style='background-color: #FF0000'   type='submit' value="+cdr.getString(1)+"> <br>");
  //out.print(cdr.getString(1));
   out.print("</td>");
        }
        out.print("</tr>");
     
        } catch (Exception e) {
               System.out.println("error procedimiento"+e);
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
