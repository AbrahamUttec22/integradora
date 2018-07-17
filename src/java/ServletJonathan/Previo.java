/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author jonat
 */
@WebServlet(name = "Previo", urlPatterns = {"/Previo"})
public class Previo extends HttpServlet {
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
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	   throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
	   /* TODO output your page here. You may use following sample code. */
	   out.println("<!DOCTYPE html>");
	   out.println("<html>");
	   out.println("<head>");
	   out.println("<title>Servlet Previo</title>");	   
	   out.println("</head>");
	   out.println("<body>");
	   out.println("<h1>Servlet Previo at " + request.getContextPath() + "</h1>");
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
        int id;
        try {
	   id=Integer.parseInt(request.getParameter("ident"));
	   String strComando="select * from platillo where id_Platillo='"+id+"'"; 
            String nom,desc;
	   double pre=0;
	   cdr=sentenciaSQL.executeQuery(strComando);
            while(cdr.next()){
	   id=cdr.getInt(1);
	   nom=cdr.getString(2);
	   pre=cdr.getDouble(4);
	   desc=cdr.getString(6);
        out.println("<table ><tr><td>");
        out.println("<input type=text placeholder=platillo required autofocus id=nombre value='"+nom+"' readonly><br><br>");
        out.println("<input type=text placeholder=$ required autofocus id=precio value="+pre+" readonly><br><br>");
        out.println("<input type=hidden placeholder=id required autofocus id=idp value="+id+" readonly><br><br>");
        
        out.println("<input type=button name=registrar value=Confirmar required autofocus onclick=agregar();><br><br>");
        out.println("</td></tr></table>");
	   
//	   out.println("<input type=button id=delete value=Borrar onclick=deleteRow()/>");
//	   out.println("<span>columna</span> <input type=number2 id=t name=somecode min=0  onkeypress=return isNumberKey(event) onKeyUp=agregar()/>");
//	   out.println("<input type=button id=calcular value=calcular onclick=getAllRows() />");
//	   out.println("<input type=button id=todo value=Borrar Todo onClick=borrarTodo() />");
//	   out.println("<table class=imagetable width=50% id=myTable>");
//            out.println("<thead>");
//            out.println("<tr>");
//	   out.println("<th>Numero</th>");
//            out.println ("<th>Descripcion</th>");                  
//            out.println("<th>Precio</th>");					   
//            out.println("</tr>");
//            out.println("</thead>");
//            out.println("<tbody id=tbl_bdy>"); 
//            out.println("</tbody>");
//	   out.println("</table>");
            }
            //out.println("<a href=PrincipalG.jsp>Regresar</a></body></html>");
	   
            
        } catch (SQLException e) {
             out.println("Excepcion SQL" + e);
        } catch (NullPointerException e) {
             out.println("Apuntando SQL" + e);
        }
             finally{
            out.close();
        }
        
    }
    public void destroy(){
        conecta.cerrar();
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
