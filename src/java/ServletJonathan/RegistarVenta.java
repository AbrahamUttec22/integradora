
package ServletJonathan;

import Conexion.Conexion;
import clases_jacg.Repatidos;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Double.parseDouble;
import java.sql.CallableStatement;
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


@WebServlet(name = "RegistarVenta", urlPatterns = {"/RegistarVenta"})
public class RegistarVenta extends HttpServlet {
ResultSet cdr=null;
ResultSet cdr2=null;
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
            out.println("<title>Servlet RegistarVenta</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistarVenta at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String total="",tipo="",hora="",sub="";
        double pre;
        response.setContentType("text/html;charset=UTF-8");
        try {
            
	   total=request.getParameter("tot");
           tipo=request.getParameter("tip");
	   hora=request.getParameter("hora");
           sub=request.getParameter("sub");
           double aportado=0;
           double total_re=0;
           total_re=Double.parseDouble(total);
  HttpSession cliente = request.getSession();
  cliente.getAttribute("cliente");
  String v="";
  String sql="";
  sql="select validarsaldo('"+total+"','"+cliente.getAttribute("cliente")+"') ";
  cdr=sentenciaSQL.executeQuery(sql);
  while (cdr.next()){
          v=cdr.getString(1);
          }
        if (v.equals("0")){
            
if (tipo.equals("1")){

 final String sql2="{call restarSaldoCliente(?,?) }";//declaramos una constante que contendra el nombre del procedimiento almacenado

CallableStatement cs=conecta.getConexion().prepareCall(sql2);
cs.setDouble(1,parseDouble(total));//s
cs.setInt(2, (int) cliente.getAttribute("cliente"));//
cs.executeQuery();//usamos executeQuery por que son registros
sentenciaSQL.executeUpdate("INSERT INTO pedido VALUES (Null,'"+cliente.getAttribute("cliente")+"',curdate(),'"+hora+"',"+total+",'0','"+sub+"','"+total+"','a domicilio')");
out.println("Compra realizada, en un momento llegara su orden" );

}else if (tipo.equals("2")){
aportado=total_re/2;
 final String sql2="{call restarSaldoCliente(?,?) }";//declaramos una constante que contendra el nombre del procedimiento almacenado

CallableStatement cs=conecta.getConexion().prepareCall(sql2);
cs.setDouble(1,aportado);//s
cs.setInt(2, (int) cliente.getAttribute("cliente"));//
cs.executeQuery();//usamos executeQuery por que son registros
sentenciaSQL.executeUpdate("INSERT INTO pedido VALUES (Null,'"+cliente.getAttribute("cliente")+"',curdate(),'"+hora+"',"+total+",'0','"+sub+"','"+aportado+"','a local')");
out.println("Gracias por su compra" );
}else if (tipo.equals("3")){
    String fechaMesa="";
    String horaMesa="";
    String id_reserva=request.getParameter("id_r");
    String sql3="select fecha,hora_inicio from reserva_mesa where id_reserva_mesa='"+id_reserva+"'";
    cdr=sentenciaSQL.executeQuery(sql3);
    while (cdr.next()){
        fechaMesa=cdr.getString(1);
      horaMesa=cdr.getString(2);
    }
    /**
     * if (dia!=diaCalendar){
     * out.println("Solo puedes ordenar si las fecha de reserva es hoy" );  
     * }else {
     * 
     * }
     */
aportado=total_re/2;
 final String sql2="{call restarSaldoCliente(?,?) }";//declaramos una constante que contendra el nombre del procedimiento almacenado

CallableStatement cs=conecta.getConexion().prepareCall(sql2);
cs.setDouble(1,aportado);//s
cs.setInt(2, (int) cliente.getAttribute("cliente"));//
cs.executeQuery();//usamos executeQuery por que son registros
sentenciaSQL.executeUpdate("INSERT INTO pedido VALUES (Null,'"+cliente.getAttribute("cliente")+"','"+fechaMesa+"','"+horaMesa+"',"+total+",'0','"+sub+"','"+aportado+"','a local')");
out.println(" El registro del platillo se guardo correctamente" );  
}//con las reservas

} else{//if del saldo
out.println("Saldo insuficiente");
}

     
        } catch (SQLException e) {
             out.println("Excepcion SQL" + e);
             System.out.println(""+e);
       } catch (NullPointerException e) {
             out.println("Apuntando SQL" + e	   );
             System.out.println(""+e);
   }
//	   
             finally{
            out.close();
        }
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
