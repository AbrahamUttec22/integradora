package servletsOswaldo;
import Conexion.Conexion;
import clases_osr.DatosCliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Oswaldo
 */
@WebServlet(name = "ServActualizarCliente", urlPatterns = {"/ServActualizarCliente"})
public class ServActualizarCliente extends HttpServlet 
{
    ResultSet cdr = null;
    Statement sentenciaSQL = null;
    Conexion conecta = new Conexion();
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        conecta.Conectar();
        sentenciaSQL = conecta.getSentenciaSQL();
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        int id;
        String correo,telefono,mun,cp,colonia,calle,num;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try  
        {           
            id=DatosCliente.id_cliente;
            correo=request.getParameter("correo");
            telefono=request.getParameter("telefono");
            mun=request.getParameter("muni");
            cp=request.getParameter("cp");
            colonia=request.getParameter("colo");
            calle=request.getParameter("calle");
            num=request.getParameter("num");
            sentenciaSQL.executeUpdate("update cliente set correo='"+correo+"',telefono='"+telefono+"',municipio='"+mun+"', codigo_postal='"+cp+"', colonia='"+colonia+"',calle='"+calle+"',no_exterior='"+num+"' where id_usuario="+id);
            RequestDispatcher rd=null;
            rd= request.getRequestDispatcher("PrincipalUsuario.jsp");
            rd.forward(request, response);
        }
        catch(NullPointerException e){
            out.println("Apuntado SQL: "+ e.getMessage());
        } catch (SQLException ex) {
            out.println("Apuntado SQL: "+ ex.getMessage());
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

