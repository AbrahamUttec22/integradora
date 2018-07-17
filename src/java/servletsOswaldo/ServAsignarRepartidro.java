package servletsOswaldo;

import Conexion.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "ServAsignarRepartidro", urlPatterns = {"/ServAsignarRepartidro"})
public class ServAsignarRepartidro extends HttpServlet {    
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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String strComando = "SELECT * FROM empleado where estado='disponible'";
            cdr = sentenciaSQL.executeQuery(strComando);
            out.println("Empleados disponibles <br>  <select id='idEmpleado'>");
            out.println("<option value='0'>Selecciona</option>");
            while (cdr.next()) {
                out.println("<option value='"+cdr.getString("id_usuario")+"'>"+cdr.getString("nombre")+" "+cdr.getString("apellido_p")+" "+cdr.getString("apellido_m")+"</option>");
            }
            out.println("</select><br>");
            String dia,mes,ano;
            Calendar obj = Calendar.getInstance();
            int y=obj.get(Calendar.YEAR);
            int mo=obj.get(Calendar.MONTH)+1;
            int day=obj.get(Calendar.DAY_OF_MONTH);
            if(day<=9)
            {
                dia="0"+day;
            }
            else{
                dia= String.valueOf(day);
            }
            if(mo<=9)
            {
                mes="0"+mo;
            }
            else{
                mes= String.valueOf(mo);
            }
            String fecha=dia+"/"+mes+"/"+y;
            String estatus="lista";
            int id = 6;            
            final String SQL="call CargarOrdenesListas(?,?)";                                    
            CallableStatement cs=conecta.getConnection().prepareCall(SQL);
            cs.setString(1,fecha);
            cs.setString(2,estatus);
            cdr =cs.executeQuery(); 
            out.println("<br>Ordenes listas<br> <select id='IdOrden' onchange='BuscarDireccionCliente();'>");
            out.println("<option value='0'>Selecciona una orden</option>");
                while (cdr.next()) {                
                    out.println("<option value='"+cdr.getString("p.id_pedido")+"'> Orden numero"+ cdr.getString("p.id_pedido") + "</option>");
                }                                    
            out.println("</select><div id='direccion'></div>");
            out.close();
        }catch (SQLException e) {
            out.println("Excepcion SQL:" + e.getMessage());

        } catch (NullPointerException e) {
            out.println("Apuntando SQL:" + e.getMessage());
        }finally{
            out.close();
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int id=Integer.parseInt(request.getParameter("uno"));
        try {
            final String SQL="call BuscarDirreccionCliente(?)";                                    
            CallableStatement cs=conecta.getConnection().prepareCall(SQL);
            cs.setInt(1,id);
            cdr =cs.executeQuery();
            while (cdr.next()) {
                out.println(cdr.getString("direccion"));
            }
            out.close();
        }catch (SQLException e) {
            out.println("Excepcion SQL:" + e.getMessage());

        } catch (NullPointerException e) {
            out.println("Apuntando SQL:" + e.getMessage());
        }finally{
            out.close();
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
