package servletsOswaldo;
import Conexion.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "ServRegistrarCliente", urlPatterns = {"/ServRegistrarCliente"})
public class ServRegistrarCliente extends HttpServlet 
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
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String nombre,app,apm,municipio,cp,colonia,calle,noEx,telefono,correo,imagne, tarjeta,tipoTarjeta,usuario,contra;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Conexion uno=new Conexion();
        uno.Conectar();
        try  
        {           
            tarjeta=request.getParameter("NoTarjeta");
            tipoTarjeta=request.getParameter("tarj");
            nombre=request.getParameter("nombre");
            app=request.getParameter("App");
            apm=request.getParameter("Apm");
            municipio=request.getParameter("Municipio");
            cp=request.getParameter("CP");
            colonia=request.getParameter("Colonia");
            calle=request.getParameter("Calle");
            noEx=request.getParameter("NoExterior");
            telefono=request.getParameter("telefono");
            correo=request.getParameter("correo");
            imagne=request.getParameter("imagen");
            usuario=request.getParameter("usr");
            contra=request.getParameter("cont");
            Statement sentenciaSQL = null;
            String strComando = "select * from cliente where nombre='"+nombre+"' and apellido_p='"+app+"' and apellido_m='"+apm+"'";
            sentenciaSQL=conecta.getSentenciaSQL();
            ResultSet rs1=sentenciaSQL.executeQuery(strComando);
            if(rs1.next())
            {
                request.setAttribute("resp","El usuario ya existe");
                //out.println("<script> alert('El usuario ya existe'); </script>");
            }
            else{
            String sql = "call insertarSesion(?,?)";
            pst = uno.getConnection().prepareStatement(sql);
            pst.setString(1, usuario);       
            pst.setString(2, contra);       
            rs=pst.executeQuery();
            String sql2 = "call insertarTarjeta(?,?)";
            pst = uno.getConnection().prepareStatement(sql2);
            pst.setString(1, tarjeta);       
            pst.setString(2, tipoTarjeta);       
            rs=pst.executeQuery();
            String sql3 = "call insertarCliente(?,?,?,?,?,?,?,?,?,?,?)";
            pst = uno.getConnection().prepareStatement(sql3);
            pst.setString(1, nombre);
            pst.setString(2, app);
            pst.setString(3, apm);
            pst.setString(4, municipio);
            pst.setString(5, cp);
            pst.setString(6, colonia);
            pst.setString(7, calle);
            pst.setString(8, noEx);
            pst.setString(9, telefono);
            pst.setString(10, correo);
            pst.setString(11, imagne);
            rs=pst.executeQuery();
            }
            RequestDispatcher rd=null;
            rd= request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        } catch (SQLException ex) {
            out.println("Exepcion SQL: "+ ex.getMessage());
        }
        catch(NullPointerException e){
            out.println("Apuntado SQL: "+ e.getMessage());
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
