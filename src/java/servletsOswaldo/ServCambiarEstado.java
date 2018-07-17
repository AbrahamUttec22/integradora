package servletsOswaldo;
import Conexion.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServCambiarEstado", urlPatterns = {"/ServCambiarEstado"})
public class ServCambiarEstado extends HttpServlet {
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
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");        
        PrintWriter out = response.getWriter();
        int id= Integer.parseInt(request.getParameter("uno"));
        String estado= request.getParameter("dos");
        if(estado.equals("en espera"))
        {
            estado="lista";
        }else if(estado.equals("lista"))
        {
            estado="asignada";
        }else if(estado.equals("asignada"))        
        {
            estado="entregada";
        }
        try {
             sentenciaSQL.executeUpdate("UPDATE listas set estatus='"+estado+"' where id_lista="+id);
             out.println("Orden actualziada");
             out.close();
        } catch (Exception e) {
            out.println("Error "+ e);
        }finally{
            out.close();
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
