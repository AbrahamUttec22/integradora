<%-- 
    Document   : BajasG
    Created on : 31/05/2018, 07:23:31 AM
    Author     : granq
--%>

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
    <div class="container">
		<div class="form__top">
			<h2> <span></span></h2>
		</div>	
       <form class="form__reg" action="BajaE" method="get">
  <input class="input" type="text" placeholder="&#128100;  Ingresa el rfc" required autofocus name="rfc">
             <div class="btn__form">
<input class="btn__submit" type="submit" value="ELIMINAR">
<input class="btn__reset" type="reset" value="LIMPIAR">	
</div>
		</form>
    </body>
</html>
