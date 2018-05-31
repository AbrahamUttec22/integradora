
package Clases_aca;

import java.sql.CallableStatement;
import Conexion.Conexion;
import datosCliente.datosCliente;
import datosGerente.datosGerente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class InsertarE {
    public boolean buscar(String u){
        boolean v=true;
        try {
        final String sql="Select * from sesion where usuario='"+u+"' ";//declaramos una constante para que no se altare la instruccion del procediminto 
     Conexion conexion= new Conexion();
     conexion.Conectar();
     //conexion.Conectar();
     PreparedStatement sentencia= conexion.getConexion().prepareCall(sql);
     ResultSet resultado = sentencia.executeQuery(); //resultset resultado obtener los datos de columna correspondientes a un fila
            while (resultado.next()) { // con un while podremos recorrer las columnas del registro por eso usamos el next()
            v=false;
            }
            return v;
        } catch (Exception e) {
            System.out.println("error consulta"+e);
        }
     return v;
    }
    public void insertarE(datosGerente m){
           try {
             final String sql="{call InsertarEmpleado(?,?,?,?,?,?,?,?) }";//declaramos una constante que contendra el nombre del procedimiento almacenado
Conexion conecta= new Conexion();
     conecta.Conectar();
CallableStatement cs=conecta.getConexion().prepareCall(sql);
        
cs.setString(1, m.getTipo_usuario());//s
cs.setString(2, m.getUsuario());//
cs.setString(3, m.getContrasena());//
cs.setString(4, m.getNombre());//
cs.setString(5, m.getApellido_m());//
cs.setString(6, m.getApellido_p());//
cs.setString(7, m.getTelefono());//
cs.setString(8, m.getEstado());//
System.out.println("este es el nombre de "+m.getNombre());
cs.executeQuery();//usamos executeQuery por que son registros
           
        } catch (Exception e) {
               System.out.println("error procedimiento"+e);
        }
    }
}
