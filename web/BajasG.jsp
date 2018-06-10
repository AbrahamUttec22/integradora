<%-- 
    Document   : BajasG
    Created on : 31/05/2018, 07:23:31 AM
    Author     : granq
--%>

<%@page import="java.sql.*"%>
<%@page import="Conexion.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
  String validar =(String)request.getAttribute("mensaje");

   if(validar!=null)
       out.println("<script>alert('"+validar+"')" + "</script>");

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Entretiempo</title>
        <link rel="stylesheet" href="css/abra.css"> 
         <style type="text/css">
             
body {
  background-color: lightblue;
  }

nav{
    /*Bordes redondeados*/
    
    -webkit-border-radius:100px;/*Para chrome y Safari*/
    -moz-border-radius:100px;/*Para Firefox*/
    -o-border-radius:100px;/*Para Opera*/
    border-radius:100px;/*El estandar por defecto*/
    background-image: -webkit-gradient(linear, left top, left bottom, from(#FFF), to(#CCC));/*Para chrome y Safari*/
    /*Degradados*/
    background-image: -moz-linear-gradient(top center, #FFF, #CCC);/*Para Firefox*/
    background-image: -o-linear-gradient(top, #FFF, #CCC);/*Para Opera*/
    background-image: linear-gradient(top, #FFF, #CCC);/*El estandar por defecto*/
    overflow:hidden;
    padding:50px;
     width:600px;
     margin-top: 100px;
    
}
img{
    align:left;
}
header{
    position: fixed;
  top:0;
  width:1300px;
  height:100px;
  background-color:#333;
  color:#FFFFFF;
 padding: 10px;
  margin-top: 0px;
  text-align: right;
  font-size: 100px;
  }
  </style>
    </head>
    <body>
        <center>
    
            <br><br><br><br>    
    <table class="tabla">
       <tr>
<th>Nombre</th>
<th>RFC </th>
<th>IMAGEN </th>


       <form  action="BajaE" method="get">
              <%
 
  try {
      String rfc=request.getParameter("rfc");
  String sql="select * from empleado em inner join sesion se on se.id_usuario=em.id_usuario where em.rfc='"+rfc+"';";
 Conexion conexion= new Conexion();
     conexion.Conectar();
     //conexion.Conectar();
     PreparedStatement sentencia= conexion.getConexion().prepareCall(sql);
     ResultSet resultado = sentencia.executeQuery(); //resultset resultado obtener los datos de columna correspondientes a un fila
            while (resultado.next()) { // con un while podremos recorrer las columnas del registro por eso usamos el next()
       String nom=resultado.getString("nombre");
       String rf= resultado.getString("rfc"); 
       String im= resultado.getString("imagen");
 out.println("<tr class=modo1>");
 out.println("<td>" + resultado.getString("nombre") + "</td>");
 out.println("<td>" + resultado.getString("rfc") + "</td>");
 out.println("<td><img src="+resultado.getString("imagen")+" height=70></img></td>");
          out.println("</tr>");
       
   %>
  
   <input class="input" type="hidden" name="rfc" value="<%=rfc%>">
   
      <%}
   } catch (Exception e) {
       }
   %>
        
  
 
</table>
   <div class="btn__form">
        <input class="btn__submit" type="submit" value="ELIMINAR" name="enviar">
</div>

   </form>
   <br><br><br><br>
   
     </center> 
    </body>
</html>
