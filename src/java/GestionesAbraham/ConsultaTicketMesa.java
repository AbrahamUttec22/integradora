
package GestionesAbraham;

import Conexion.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ConsultaTicketMesa", urlPatterns = {"/ConsultaTicketMesa"})
public class ConsultaTicketMesa extends HttpServlet {

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
            out.println("<title>Servlet ConsultaTicketMesa</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ConsultaTicketMesa at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
PrintWriter out= response.getWriter();
int id_usuario=0;
id_usuario=datosCliente.datosCliente.id_usuario;
String sql="",fecha="",hora_inicio="";
int cont=0;

try {
sql="select fecha,hora_inicio from reserva_mesa where id_usuario="+id_usuario+"";
cdr=sentenciaSQL.executeQuery(sql);  
while (cdr.next()){
cont++;
fecha=cdr.getString(1);
hora_inicio=cdr.getString(2);
    out.print("<center><a href=imprimirTicketMesa?fecha="+fecha+"&hora="+hora_inicio+" target=_blank>"+fecha+" "+hora_inicio+"</a></center><br>");
    //<a href=ticketMesa target=_blank><input type=submit value=ImprimirTicket></a>";
System.out.println(fecha+hora_inicio);
}
if (cont==0){
    out.print("<center>No has hecho alguna resrvacion</center>");
}
out.close();
} catch (Exception e) {
    System.out.println("Error de :"+e);
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
