package clases_osr;
import Conexion.*;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import datosCliente.datosCliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
public class Consultas
{
    
    private int id_u;


    public int autenticacion(String usuario, String contrasena)
    {
    Conexion uno=new Conexion();
    PreparedStatement pst=null;
    ResultSet rs=null;
    uno.Conectar();
    try{
        String consulta="select * from sesion where usuario=? and contrasena=?";
        pst = uno.getConnection().prepareStatement(consulta);
        pst.setString(1, usuario);
        pst.setString(2, contrasena);
        rs=pst.executeQuery();
        while(rs.next())
        {
            datosCliente.id_usuario=(rs.getInt(1));
            
            if(rs.getString("tipo_usuario").equalsIgnoreCase("CLIENTE"))
            {
                return 1;
            }
            else if(rs.getString("tipo_usuario").equalsIgnoreCase("COCINERO"))
            {
                return 2;
            }
            else if(rs.getString("tipo_usuario").equalsIgnoreCase("REPARTIDOR"))
            {
                return 3;
            }
            else if(rs.getString("tipo_usuario").equalsIgnoreCase("GERENTE"))
            {
                return 4;
            }
        }
    }catch(Exception e){
        System.out.print("\nerror" +e);
    }
    finally
    {
        try{
            if(uno.getConnection()!=null) uno.getConnection().close();
            if(pst!=null)pst.close();
            if(rs!=null)rs.close();
        }
        catch(Exception e)
        {
        System.out.print("\nerror" +e);
    }
    }
        return 0;
    }
}