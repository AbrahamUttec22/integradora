/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_jacg;

import Conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author jonat
 */
public class GestionarPl {
   
   public boolean buscar(String nom){
        boolean v=true;
        try {
        final String sql="Select * from platillo where nombre='"+nom+"' ";//declaramos una constante para que no se altare la instruccion del procediminto 
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
   public void insertarP(DatosPlatillo da){
           try {
             final String sql="{call InsertarPlatillo(?,?,?,?) }";//declaramos una constante que contendra el nombre del procedimiento almacenado
Conexion conecta= new Conexion();
     conecta.Conectar();
CallableStatement cs=conecta.getConexion().prepareCall(sql);
        
cs.setString(1, da.getNom());//s
cs.setString(2, da.getTipo());//
cs.setDouble(3, da.getPre());//
cs.setString(4, da.getIma());//

cs.executeQuery();//usamos executeQuery por que son registros
           
        } catch (Exception e) {
               System.out.println("error procedimiento"+e);
        }
          
    }
   public void insertarPe(datosPedido da){
           try {
             final String sql="{call InsertarPedido(?,?,?,?,?,?) }";//declaramos una constante que contendra el nombre del procedimiento almacenado
Conexion conecta= new Conexion();
     conecta.Conectar();
CallableStatement cs=conecta.getConexion().prepareCall(sql);
        
cs.setInt(1, da.getId_usu());//
cs.setString(2, da.getFecha());//
cs.setDouble(3, da.getSub());//
cs.setDouble(4, da.getCos());//
cs.setDouble(5, da.getTo());
cs.setString(6, da.getDomi());

cs.executeQuery();//usamos executeQuery por que son registros
           
        } catch (Exception e) {
               System.out.println("error procedimiento"+e);
        }
          
    }

}

