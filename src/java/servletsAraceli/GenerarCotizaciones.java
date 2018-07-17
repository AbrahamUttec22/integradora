package servletsAraceli;

import Conexion.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Araceli
 */
@WebServlet(name = "GenerarCotizaciones", urlPatterns = {"/GenerarCotizaciones"})
public class GenerarCotizaciones extends HttpServlet {
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
        PrintWriter out = response.getWriter();
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
        PrintWriter out=response.getWriter();
        int paquete=Integer.parseInt(request.getParameter("idPaquete"));
        int cliente=Integer.parseInt(request.getParameter("idCliente"));
        int precio = 0;
        try{
        String strComando="SELECT * FROM paquete WHERE id_paquete="+paquete;
           cdr=sentenciaSQL.executeQuery(strComando);
           while(cdr.next()){
            precio=cdr.getInt("precio");
            } 
            sentenciaSQL.executeUpdate("INSERT INTO pedido_evento VALUES (null,"+paquete+","+cliente+",' pendiente', 'cotizado', 'pendiente', 0, 0, 0, "+precio+")");
       out.println("El precio de su paquete es de: $"+precio);
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
   response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int opc=Integer.parseInt(request.getParameter("opcPlatillo"));
        out.println("<br/><form name=form><table width=100%>");
        try{
            switch(opc){
                case 1:
                    String strComando="SELECT * FROM platillo WHERE tipo='entrada'";
           cdr=sentenciaSQL.executeQuery(strComando);  
           int numopc=0;  
           while(cdr.next()){
               numopc++;
            out.println("<tr>");
            out.println("<td>"+cdr.getString("nombre")+"</td>");
            out.println("<td>$"+cdr.getInt("precio")+"</td>");
            out.println("<td>"+cdr.getString("descripcion")+"</td>");
            out.println("<td><img src="+cdr.getString("imagen")+" width=150px></td>");
            out.println("<td><input type=text id=cantidad"+cdr.getInt("id_platillo")+" size=5 placeholder=Cantidad></td>");
            out.println("<td><input type=button value=Agregar width=50px onclick=AgregarCarrito("+cdr.getInt("id_platillo")+");></td></tr>"); 
           } 
           break;
                case 2:
                     String strComando2="SELECT * FROM platillo WHERE tipo='plato fuerte';";
           cdr=sentenciaSQL.executeQuery(strComando2); 
           int numopc2=0;  
           while(cdr.next()){
            numopc2++;
            out.println("<tr>");
            out.println("<td>"+cdr.getString("nombre")+"</td>");
            out.println("<td>$"+cdr.getInt("precio")+"</td>");
            out.println("<td>"+cdr.getString("descripcion")+"</td>");
            out.println("<td><img src="+cdr.getString("imagen")+" width=150px></td>");
            out.println("<td><input type=text id=cantidad"+cdr.getInt("id_platillo")+" size=5 placeholder=Cantidad></td>");
            out.println("<td><input type=button value=Agregar width=50px onclick=AgregarCarrito("+cdr.getInt("id_platillo")+");></td></tr>"); 
           } 
           break;
                case 3:
                    String strComando3="SELECT * FROM platillo WHERE tipo='postre';";
           cdr=sentenciaSQL.executeQuery(strComando3);
           int numopc3=0;           
           while(cdr.next()){
               numopc3++;
            out.println("<tr>");
            out.println("<td>"+cdr.getString("nombre")+"</td>");
            out.println("<td>$"+cdr.getInt("precio")+"</td>");
            out.println("<td>"+cdr.getString("descripcion")+"</td>");
            out.println("<td><img src="+cdr.getString("imagen")+" width=150px></td>");
            out.println("<td><input type=text id=cantidad"+cdr.getInt("id_platillo")+" size=5 placeholder=Cantidad></td>");
            out.println("<td><input type=button value=Agregar width=50px onclick=AgregarCarrito("+cdr.getInt("id_platillo")+");></td></tr>"); 
           } 
           break;
                case 4:
                    String strComando4="SELECT * FROM platillo WHERE tipo='bebida';";
           cdr=sentenciaSQL.executeQuery(strComando4);     
           numopc=0; 
           while(cdr.next()){
               numopc++;
            out.println("<tr>");
            out.println("<td>"+cdr.getString("nombre")+"</td>");
            out.println("<td>$"+cdr.getInt("precio")+"</td>");
            out.println("<td>"+cdr.getString("descripcion")+"</td>");
            out.println("<td><img src="+cdr.getString("imagen")+" width=150px></td>");
            out.println("<td><input type=text id=cantidad"+cdr.getInt("id_platillo")+" size=5 placeholder=Cantidad></td>");
            out.println("<td><input type=button value=Agregar width=50px onclick=AgregarCarrito("+cdr.getInt("id_platillo")+");></td>"
                    + "<td><input type=button class=boton value=coger valores de la fila></td></tr>");
           } 
           break;
    }
            } catch (SQLException ex) {
        Logger.getLogger(GenerarCotizaciones.class.getName()).log(Level.SEVERE, null, ex);
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
