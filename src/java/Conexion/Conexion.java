
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
     private Connection conexion=null;
    private Statement sentenciaSQL=null;

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public Statement getSentenciaSQL() {
        return sentenciaSQL;
    }

    public void setSentenciaSQL(Statement sentenciaSQL) {
        this.sentenciaSQL = sentenciaSQL;
    }
    
    public void Conectar (){
        try {
            String controlador="com.mysql.jdbc.Driver";
            Class.forName(controlador).newInstance();
            conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurante","root","");
            sentenciaSQL=getConexion().createStatement();
        } catch (ClassNotFoundException ex) {
            System.out.println("no se pudo cargar el controlador: "+ex.getMessage());
        } catch (InstantiationException ex) {
            System.out.println("objeto no creado: "+ex.getMessage());
        } catch (IllegalAccessException ex) {
            System.out.println("acceso ilegal: "+ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("excepcion sql: "+ex.getMessage());
        }
    }
    public void cerrar(){
        try {
            if(getSentenciaSQL()!=null)
             getSentenciaSQL().close();
              if(getConexion()!=null)
                  getConexion().close();
            
        } catch (SQLException ex) {
              System.out.println("excepcion sql: "+ex.getMessage());
        }
    }
  
  
}