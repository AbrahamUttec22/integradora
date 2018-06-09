<%-- 
    Document   : ActualizarG
    Created on : 31/05/2018, 07:22:58 AM
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
        <title>ENTRETIEMPO</title>
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
    <nav>
        <table WIDTH="500" height="50">
                <tr>
  <td> <a href="RegistraG.jsp">Registrar </a></td>
  <td> <a href="ActualizarG.jsp">Actualizar </a></td>
  <td> <a href="ConsultasG.jsp">Consulta </a></td>
  <td> <a href="BajasG.jsp">Dar de baja </a></td>
  <td> <a href="PrincipalG.jsp">Inicio</a></td>
                </tr>
            </table>
        </nav>
             </center>   
    
       <form action="ActualizarG" method="get">
           <center>  <input class="input" type="text" placeholder="&#128100;  Ingresa el rfc"  name="rfc" size="30">
               </center>
           <div class="btn__form">
<input class="btn__submit" type="submit" value="Buscar" size="1" name="enviar">
<input class="btn__submit" type="submit" value="Actualizar" size="1" name="enviar">
</div>
		
    <br><br><br><br>   
    <center>
    <table class="tabla">
       <tr>
<th>Nombre</th>
<th>Paterno </th>
<th>Materno </th>
<th>RFC</th> 
<th>Telefono</th> 
<th>Tipo</th> 
<th>Usuario</th> 
<th>Contraseña</th> 
<th>Direccion</th> 
<th>Imagen</th> 


       </tr>
<tr class="modo1">
<td><input type="text" value="${no}" name="nombre" size="15"></td>
<td><input type="text" value="${ap}" name="ap" size="15"></td>
<td><input type="text" value="${am}" name="am" size="15"></td>
<td><input type="text" value="${rfc}" name="rfc2" size="15"></td>
<td><input type="text" value="${telefono}" name="telefono" size="15"></td>

<td><input type="text" value="${ti}" name="tipo" size="15"></td>
<td><input type="text" value="${us}" name="usuario" size="15"></td>
<td><input type="text" value="${co}" name="contrasena" size="15"></td>
<td><input type="text" value="${direccion}" name="direccion" size="15"></td>
<td><input type="file" value="${imagen}" name="imagen" size="15"></td>


</tr>


</center>
    </table>
    </form>

    </body>
</html>
