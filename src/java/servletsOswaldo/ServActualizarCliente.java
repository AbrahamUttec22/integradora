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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try  
        {           
            //id=datosCliente.id_usuario;
            
            int idOrden =Integer.parseInt(request.getParameter("uno"));
            int idEmpleado =Integer.parseInt(request.getParameter("dos"));
            sentenciaSQL.executeUpdate("insert into asignar_repartidor values(null,(select id_empleado from empleado where id_usuario="+idEmpleado+"),"+idOrden+",(select concat(nombre,' ',apellido_p) from empleado where id_usuario="+idEmpleado+"),'en envio')");
            
            sentenciaSQL.executeUpdate("update listas set estatus='asiganada' where id_pedido="+idOrden);
            sentenciaSQL.executeUpdate("update empleado set estado='asignado' where id_usuario="+idEmpleado);
            out.println("Se asigno");
            out.close();
        }
        catch(NullPointerException e){
            out.println("Apuntado SQL: "+ e.getMessage());
            System.out.println(""+e);
        } catch (SQLException ex) {
            out.println("Apuntado SQL: "+ ex.getMessage());
             System.out.println(""+ex);
        }catch (Exception e) {
          
             System.out.println(""+e);
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

