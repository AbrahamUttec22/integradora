
package ServletJonathan;

import Conexion.Conexion;
import datosCliente.datosCliente;
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
import javax.servlet.http.HttpSession;


@WebServlet(name = "PintarCliente", urlPatterns = {"/PintarCliente"})
public class PintarCliente extends HttpServlet {
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
	   out.println("<title>Servlet PintarCliente</title>");	   
	   out.println("</head>");
	   out.println("<body>");
	   out.println("<h1>Servlet PintarCliente at " + request.getContextPath() + "</h1>");
	   out.println("</body>");
	   out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	   throws ServletException, IOException {
        int id;
       id=datosCliente.id_usuario;
          HttpSession cliente = request.getSession();
  cliente.getAttribute("cliente");
        
       PrintWriter out = response.getWriter();
	   try {
               String ti=request.getParameter("ti");
               
 if (ti.equals("1")){
           String strComando="select * from cliente where id_usuario="+cliente.getAttribute("cliente")+""; 

cdr=sentenciaSQL.executeQuery(strComando);

while(cdr.next()){
out.println("<input type=hidden id=idu value="+id+">");	
out.println("<br><br>Nombre: <input type=text id=nombre readonly value="+cdr.getString(4)+"&nbsp;"+cdr.getString(5)+"&nbsp;"+cdr.getString(6)+">");
out.println("<br><br>Municipio: <input type=text id=direccion value='"+cdr.getString(7)+"'>");
out.println("<br><br>Codigo Postal: <input type=text id=codigo value="+cdr.getString(8)+">");
out.println("<br><br>Colonia: <input type=text id=codigo value="+cdr.getString(9)+">");
out.println("<br><br>Calle: <input type=text id=codigo value="+cdr.getString(10)+">");
out.println("<br><br>Numero Exterior: <input type=text id=codigo value="+cdr.getString(11)+">");
out.println("<br><br>Telefono: <input type=text id=telefono readonly  value="+cdr.getString(12)+">");
out.println("<br><br>Correo: <input type=text id=correo  readonly value="+cdr.getString(13)+">");
out.println("<br><br>Hora :<input type=time id=hora_pedido  value=Aceptar>");

out.println("<br><br><input type=button id=ordenarcomida onclick=insertarVenta(); value=Aceptar>");

	   }
       }else if (ti.equals("2")){
out.println("<br><br>Hora :<input type=time id=hora_pedido  value=Aceptar>");
out.println("<br><br><input type=button id=ordenarcomida onclick=insertarVenta(); value=Aceptar>");
       }else if (ti.equals("3")){
           out.println("<br><br>Hora :<input type=time id=hora_pedido  value=Aceptar>");
           out.println("<br><br>Folio de reserva :<input type=text id=id_r >");
out.println("<br><br><input type=button id=ordenarcomida onclick=insertarVenta(); value=Aceptar>");
       }   

} catch (SQLException e) {
           out.println("Excepcion SQL" + e);
        } catch (NullPointerException e) {
           out.println("Apuntando SQL" + e);
        }
             finally{
            out.close();
        }
        
    }
    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
