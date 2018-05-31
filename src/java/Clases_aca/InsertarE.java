
package Clases_aca;

import java.sql.CallableStatement;
import Conexion.Conexion;
import datosCliente.datosCliente;
import datosGerente.datosGerente;
public class InsertarE {
    public void buscar(){
        
    }
    public void insertarE(datosGerente m){
           try {
             final String sql="{call AgendarM (?,?,?,?,?,?,?,?) }";//declaramos una constante que contendra el nombre del procedimiento almacenado
Conexion conecta= new Conexion();
CallableStatement cs=conecta.getConexion().prepareCall(sql);
cs.setString(1, m.getTipo_usuario());//
cs.setString(2, m.getUsuario());//
cs.setString(3, m.getContrasena());//
cs.setString(4, m.getNombre());//
cs.setString(5, m.getApellido_m());//
cs.setString(6, m.getApellido_p());//
cs.setString(6, m.getTelefono());//
cs.setString(6, m.getEstado());//



cs.executeQuery();//usamos executeQuery por que son registros
           
        } catch (Exception e) {
        }
    }
}
