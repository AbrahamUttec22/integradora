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

@WebServlet(name = "ActivarTarjeta", urlPatterns = {"/ActivarTarjeta"})
public class ActivarTarjeta extends HttpServlet {
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
            out.println("<title>Servlet ActivarTarjeta</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ActivarTarjeta at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int opc=Integer.parseInt(request.getParameter("tipo"));
        switch(opc){
            case 1:
                break;
            case 2:
                break;
            case 3:
                out.println("<form name=activar><br/>Numero de tarjeta: "
                        + "<input type=text id=numero_tarjeta>&nbsp;&nbsp;"
                        + "&nbsp;&nbsp;&nbsp;&nbsp;<input type=button value=Consultar onclick=BuscarTarjeta();>"
                        + "<br/><br/><div id=respuesta></div></form>");
                break;
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
        String tarjeta = request.getParameter("tarjeta");
        try{
        String strComando="SELECT * FROM tarjeta_prepago where no_tarjeta="+tarjeta;
           cdr=sentenciaSQL.executeQuery(strComando);         
           if(cdr.next()){
              String estatus=cdr.getString("estatus");
              if (!estatus.equals("libre")){
                  out.println("La tarjeta ya esta ocupada");
              }else{
                  out.println("<br/><br/>Ingrese codigo de activación:&nbsp;&nbsp;"
                          + "<input type=text id=codigo>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                          + "<input type=button value='Activar Tarjeta' onclick=Actualizarsaldo();>");
              }
           }else{
               out.println("La tarjeta no existe");
           }
           }            
           catch(SQLException e){
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
