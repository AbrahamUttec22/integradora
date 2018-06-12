<%-- 
    Document   : ModPlatillos
    Created on : 5/06/2018, 06:07:22 PM
    Author     : jonat
--%>

<%@page import="javax.xml.stream.util.EventReaderDelegate"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="Conexion.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style> h1{
        text-align: center;    
        }
        th{
            background: gray;
            color:white;
        }
        div{
            position:absolute;
            left: 5px;
            top: 25px;
        }
        
        </style>
        <title>Modificar platillos</title>
    </head>
    <body>
        
        <form action="http://localhost:8080/SWPR/SerModPlatillo" method="get">
        <h1 > Actualizacion de Platillos</h1> <br/>
          
        
        <%
         int id;
         String tipo,ima;   
         id=Integer.parseInt(request.getParameter("nov"));
        tipo=(request.getParameter("tio"));
        
        %>
        <input type="hidden" name="id_platillo" value=<%=id%>><br>
        
        <label>Nombre</label><br>
            <%
        String nomb="";
                     Conexion conexion = new Conexion();
                     conexion.Conectar();
                     
                     Statement sentenciaSQL=null;
                     try {
                               String str="select nombre from platillo where id_platillo='"+id+"'";
                               sentenciaSQL=conexion.getSentenciaSQL();
                               ResultSet cdr=sentenciaSQL.executeQuery(str);
                               while(cdr.next()){
                                   
                                   nomb=(cdr.getString(1));
                                  
                                   
                               }
                         } catch (Exception e) {
                         }
                     
                      %>
        
        
        <input type="text" name="nombre" value=<%=nomb%>><br>
        
        
        <label>Tipo</label><br>
            <select name="tipo" class="input"  value="<%=tipo%>" selected="selected">
                 
                
                
                
                <option > Tipo de platillo</option>  
                              <option > Entrada</option>
                              <option > Sopa</option>
                              <option > Plato Fuerte</option>   
                              <option > Postre</option>
                              <option > Bebida</option>
                   
                              
                        </select><br><br>
                      
        <label>Precio</label><br>
            <%
        double pre=0;
                     conexion.Conectar();
                     
                     try {
                               String str="select precio from platillo where id_platillo='"+id+"'";
                               sentenciaSQL=conexion.getSentenciaSQL();
                               ResultSet cdr=sentenciaSQL.executeQuery(str);
                               while(cdr.next()){
                                   
                                   pre=(cdr.getDouble(1));
                                  
                                   
                               }
                         } catch (Exception e) {
                         }
                     
                      %>
        
        
        
              <input type="text" name="precio" value=<%=pre%>><br><br>
              
              
            <%
       
                      %>
        
        
        <label>Foto</label><input class="input" type="file" placeholder="&#128100;  Imagen"  name="imagen" value=""><br><br>
             
              
              
              
              
         
            <input type="submit" value="Modificar" name="enviar" >
        &nbsp;&nbsp;&nbsp;    
        
                     <br><br>
                     
        </form> 
              
              
    </body>
</html>