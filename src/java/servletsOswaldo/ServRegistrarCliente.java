package servletsOswaldo;
import Conexion.Conexion;
import datosCliente.datosCliente;
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
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String codigo= request.getParameter("codigo");
        if(codigo.equals(datosCliente.codigoVerificacion))
        {
            String nombre,app,apm,municipio,cp,colonia,calle,noEx,telefono,correo,imagen, tarjeta,tipoTarjeta,usuario,contra;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Conexion uno=new Conexion();
        uno.Conectar();
        try  
        {           
            imagen=request.getParameter("uno");
            nombre=request.getParameter("dos");
            app=request.getParameter("tres");
            apm=request.getParameter("cuatro");
            municipio=request.getParameter("cinco");
            cp=request.getParameter("seis");
            colonia=request.getParameter("siete");
            calle=request.getParameter("ocho");
            noEx=request.getParameter("nueve");
            telefono=request.getParameter("dies");
            correo=request.getParameter("once");
            usuario=request.getParameter("doce");
            contra=request.getParameter("trece");
            tarjeta=request.getParameter("quince");
            tipoTarjeta=request.getParameter("catorce");           
            Statement sentenciaSQL = null;
            String strComando = "select * from cliente where nombre='"+nombre+"' and apellido_p='"+app+"' and apellido_m='"+apm+"'";
            sentenciaSQL=conecta.getSentenciaSQL();
            ResultSet rs1=sentenciaSQL.executeQuery(strComando);
            if(rs1.next())
            {
                request.setAttribute("resp","El usuario ya existe");
                out.println("<script> alert('El usuario ya existe'); </script>");
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
            pst.setString(11, imagen);
            rs=pst.executeQuery();
            }
            out.println("Registro exitoso ahora inicia sesion");
            out.close();
        } catch (SQLException ex) {
            out.println("Exepcion SQL: "+ ex.getMessage());
        }
        catch(NullPointerException e){
            out.println("Apuntado SQL: "+ e.getMessage());
        }finally{
            out.close();
        }
        }
        else{
            out.println("Tu codigo es: "+codigo+" y el codigo de verificacion es "+datosCliente.codigoVerificacion);            
            out.close();
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
