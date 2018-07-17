
package servletsOswaldo;

import Conexion.Conexion;
import datosCliente.*;
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

@WebServlet(name = "ServBuscarClinte", urlPatterns = {"/ServBuscarClinte"})
public class ServBuscarCliente extends HttpServlet {
ResultSet cdr = null;
    Statement sentenciaSQL = null;
    Conexion conecta = new Conexion();
    int id;
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        conecta.Conectar();
        sentenciaSQL = conecta.getSentenciaSQL();
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try 
        {
            ////////////////////
                ////////////////////
            id=datosCliente.id_usuario;
                ////////////////////
            ////////////////////
            String strComando = "SELECT * FROM cliente WHERE id_usuario="+id;
            cdr = sentenciaSQL.executeQuery(strComando);
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Actualizar Cliente</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<form method='post' action='http://localhost:9090/SWPR/ServActualizarCliente'>");
            while(cdr.next())
            {
                out.println("<label>Correo</label><br>");
                out.println("<input type='text' value='"+cdr.getString("correo")+"' name='correo'> <br><br>");
                out.println("<label>Telefono</label><br>");
                out.println("<input type='text' value='"+cdr.getString("telefono")+"' name='telefono'> <br><br>");
                out.println("<label>Municipio</label><br>");
                out.println("<input type='text' value='"+cdr.getString("municipio")+"' name='muni'> <br><br>");
                out.println("<label>Codigo Postal</label><br>");
                out.println("<input type='text' value='"+cdr.getString("codigo_postal")+"' name='cp'> <br><br>");
                out.println("<label>Colonia</label><br>");
                out.println("<input type='text' value='"+cdr.getString("colonia")+"' name='colo'> <br><br>");
                out.println("<label>Calle</label><br>");
                out.println("<input type='text' value='"+cdr.getString("calle")+"' name='calle'> <br><br>");
                out.println("<label>Numero Exterior</label><br>");
                out.println("<input type='text' value='"+cdr.getString("no_exterior")+"' name='num'> <br><br>");
                out.println("<input type='submit' value='ACTUALIZAR'>");
                out.println("<a href='PrincipalUsuario.jsp'><input type='button' value='ACTUALIZAR'></a>");
            }
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        } catch (SQLException ex) {
        Logger.getLogger(ServBuscarCliente.class.getName()).log(Level.SEVERE, null, ex);
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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try 
        {
           int idC = Integer.parseInt(request.getParameter("uno"));
            id=datosCliente.id_usuario;
            String strComando = "SELECT * FROM cliente WHERE id_usuario="+idC;
            cdr = sentenciaSQL.executeQuery(strComando);
            out.println("<h2>Datos Cliente</h2>");
            while(cdr.next())
            {
                out.println("<label>Correo</label><br>");
                out.println("<input type='text' value='"+cdr.getString("correo")+"' id='correo'> <br><br>");
                out.println("<label>Telefono</label><br>");
                out.println("<input type='text' value='"+cdr.getString("telefono")+"' id='telefono'> <br><br>");
                out.println("<label>Municipio</label><br>");
                out.println("<input type='text' value='"+cdr.getString("municipio")+"' id='muni'> <br><br>");
                out.println("<label>Codigo Postal</label><br>");
                out.println("<input type='text' value='"+cdr.getString("codigo_postal")+"' id='cp'> <br><br>");
                out.println("<label>Colonia</label><br>");
                out.println("<input type='text' value='"+cdr.getString("colonia")+"' id='colo'> <br><br>");
                out.println("<label>Calle</label><br>");
                out.println("<input type='text' value='"+cdr.getString("calle")+"' id='calle'> <br><br>");
                out.println("<label>Numero Exterior</label><br>");
                out.println("<input type='text' value='"+cdr.getString("no_exterior")+"' id='num'> <br><br>");
                out.println("<input type='button' value='CANCELAR' onclick='RecuperarDatosCliente();'>");
            }
            out.close();
        } catch (SQLException ex) {
        out.println("error "+ex);
        }finally{
            out.close();
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
