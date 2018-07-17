/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_jacg;

import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author jonat
 */
public class Repatidos {
  public boolean buscarp(String u){
        boolean v=false;
        
        try {
     final String sql="Select * from platillo where nombre='"+u+"' ";//declaramos una constante para que no se altare la instruccion del procediminto 
     Conexion conexion= new Conexion();
     conexion.Conectar();
     //conexion.Conectar();
     PreparedStatement sentencia= conexion.getConexion().prepareCall(sql);
     ResultSet resultado = sentencia.executeQuery(); //resultset resultado obtener los datos de columna correspondientes a un fila
            while (resultado.next()) { // con un while podremos recorrer las columnas del registro por eso usamos el next()
            v=true;
            }
            return v;
        } catch (Exception e) {
            System.out.println("error consulta"+e);
        }
     return v;
    }

   
}