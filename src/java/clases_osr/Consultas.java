package clases_osr;
import Conexion.*;
import datosCliente.datosCliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class Consultas
{
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
//    public boolean registrar(String nombre,String apellidoP,String apellidoM,String telefono,String usuario,String contrasena)
//    {
//        PreparedStatement pst=null;
//    try{
//        String consulta="insert into usuarios values(null,?,?,?,?,?,?)";
//        pst = getConnection().prepareStatement(consulta);
//        pst.setString(1,nombre);
//        pst.setString(2,apellidoP);
//        pst.setString(3,apellidoM);
//        pst.setString(4,telefono);
//        pst.setString(5,usuario);
//        pst.setString(6,contrasena);
//        
//        if(pst.executeUpdate()==1)
//        {
//            return true;
//        }
//    }catch(Exception e)
//            {
//              System.out.print("\nerror"+e);
//            }
//    finally{
//        try{
//        if(getConnection()!=null) getConnection().close();
//        if(pst!=null)pst.close();
//        }catch(Exception e){
//            System.out.print("\nerror"+e);
//            }
//    }
//    return false;
//    }
}