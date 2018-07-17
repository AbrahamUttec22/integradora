package servletsAraceli;

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

@WebServlet(name = "MostrarOpciones", urlPatterns = {"/MostrarOpciones"})
public class MostrarOpciones extends HttpServlet {
ResultSet cdr=null;
Statement sentenciaSQL=null;
Conexion conecta=new Conexion();

public void init(ServletConfig config) throws ServletException{
    super.init(config);
    conecta.Conectar();
    sentenciaSQL=conecta.getSentenciaSQL();
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
            out.println("<title>Servlet MostrarOpciones</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MostrarOpciones at " + request.getContextPath() + "</h1>");
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
        PrintWriter out=response.getWriter();
        int opc=Integer.parseInt(request.getParameter("opc"));
        try{
    if(opc==1){
        String strComando="SELECT * FROM paquete";
           cdr=sentenciaSQL.executeQuery(strComando);
           out.println("<form name=paquetes align=center><table width=100%><tr>");
            while(cdr.next()){
            out.println("<td width=25%>");
              out.println("<img src="+cdr.getString("imagen")+" width=250px><br/>"
              + "<input type=radio name=opcPaquete id="+cdr.getInt("id_paquete")+" "
              + "value="+cdr.getInt("id_paquete")+">"+cdr.getString("nombre_paquete")+""
              + "<br/>$"+cdr.getInt("Precio")+""
              + "<br/>"+cdr.getString("descripcion")+"</td>");
            } 
            out.println("</tr></table><br/><br/><a><input type=button value='Guardar cotizacion' onclick=GenerarCotizacion();></a>&nbsp;"
              + "&nbsp&nbsp&nbsp<input type=button value='Hacer pedido' onclick=HacerPedido();></form>");
    }else{
        out.println("<form name=paquetes align=center><br/>Mostrar: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
        out.println("<input type=radio name=platillo value=1 onclick=MostrarPlatillo(); >Entradas&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
        out.println("<input type=radio name=platillo value=2 onclick=MostrarPlatillo(); >Platos Fuertes&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
        out.println("<input type=radio name=platillo value=3 onclick=MostrarPlatillo(); >Postres&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
    out.println("<input type=radio name=platillo value=4 onclick=MostrarPlatillo(); >Bebidas&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
    out.println("</form><br/><table width=100%><tr><td width=50%><div id=MostrarPlatillo></div></td><td width=50%><div id=MostrarCarrito></div></td></tr></table>");
    }  
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
