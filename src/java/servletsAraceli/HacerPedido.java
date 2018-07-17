package servletsAraceli;

import Conexion.Conexion;
import clases_cheli.ejemplo;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "HacerPedido", urlPatterns = {"/HacerPedido"})
public class HacerPedido extends HttpServlet {
ResultSet cdr=null;
Statement sentenciaSQL=null;
Conexion conecta=new Conexion();

public void init(ServletConfig config) throws ServletException{
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
            out.println("<title>Servlet HacerPedido</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HacerPedido at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       PrintWriter out = response.getWriter();
       int idPaquete= Integer.parseInt(request.getParameter("idPaquete"));
       int precio=0;
       int idCliente= Integer.parseInt(request.getParameter("idCliente"));
       try{
        String strComando="SELECT * FROM paquete where id_paquete="+idPaquete;
           cdr=sentenciaSQL.executeQuery(strComando);
        while(cdr.next()){
            precio=cdr.getInt("precio");
        }
        out.println("<form align=center>Elegir fecha del evento:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
        + "<input type=date id=fechaevento><br/><br/>Elegir hora del evento:&nbsp;&nbsp;&nbsp;&nbsp;"
        + "&nbsp;<input type=time id=horaevento><br/><br/>Número aproximado de personas que asistiran:"
        + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=number id=personas min=1><br/><br/>"
        + "Subtotal:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;$<input type=text readonly='' value='"+precio+"' id=subtotal><br/><br/>"
        + "Descuento: <input type=text readonly='' placeholder='Solo clientes frecuentes' id=descuento>"
        + "Total: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;$<input type=text readonly='' value="+precio+" id=total>"
        + "<br/><br/><input type=button value='Hacer pedido' onclick=CalcularPagos();>"
        + "<div id=respuestaPedido></div><input type=hidden id=idPaquete value="+idPaquete+"></form>");
       }catch(SQLException e){
        e.printStackTrace();
          out.println(e);
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
        ejemplo cal= new ejemplo();
       response.setContentType("text/html;charset=UTF-8");
       PrintWriter out = response.getWriter();
       String fecha = request.getParameter("fecha");
       int total= Integer.parseInt(request.getParameter("total"));
       Calendar obj = Calendar.getInstance();        
            int años=obj.get(Calendar.YEAR);
        int mess=obj.get(Calendar.MONTH)+1;
        int dia=obj.get(Calendar.DAY_OF_MONTH);
        String strFecha = años+"-0"+mess+"-0"+dia;
        ejemplo o= new ejemplo();
        int dias=o.dias(strFecha, fecha);
        if(dias>=8){
            double pago1=total*0.30;
            out.println("<br/><br/>Su primer pago es de $"+pago1+" y será tomado de su saldo actual.");
            out.println("Podrá cubrir el costo total en dos pagos más.");
            out.println("<br/><input type=button value='Confirmar compra' onclick=ConfirmarCompra();>");
        }else{
                out.println("Se descontara el monto total de su saldo actual");
                out.println("<br/><input type=button value='Confirmar compra' onclick=ConfirmarCompra();>");
            }
       try{ 
        String strComando="SELECT * FROM paquete";
           cdr=sentenciaSQL.executeQuery(strComando);
       }catch(SQLException e){
        e.printStackTrace();
          out.println(e);
        }
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
