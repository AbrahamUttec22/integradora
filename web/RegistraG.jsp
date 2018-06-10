<%-- 
    Document   : RegistraG
    Created on : 31/05/2018, 07:22:30 AM
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
  <td> <a href="ConsultasG.jsp">Consulta </a></td>

  <td> <a href="PrincipalG.jsp">Inicio</a></td>
                </tr>
            </table>
        </nav>
             </center>   
	<div class="container">
		<div class="form__top">
			<h2>Formulario <span>Registro</span></h2>
		</div>		
            <form class="form__reg" action="RegistrarE" method="post" enctype="multipart/form-data">
                    <input class="input" type="text" placeholder="&#128100;  Nombre"  autofocus name="nombre">
            
                    <input class="input" type="text" placeholder="&#128100;  Apellido Paterno"  name="apellido_p">
                    <input class="input" type="text" placeholder="&#128100;  Apellido Materno"  name="apellido_m">
 <input class="input" type="text" placeholder="&#128100;  RFC"  name="rfc">                   
                    <input class="input" type="text" placeholder="&#128100;  Telefono"  name="telefono">
 <input class="input" type="text" placeholder="&#128100;  Direccion"  name="direccion">
 
 <label>Foto</label><input class="input" type="file" placeholder="&#128100;  Imagen" name="imagen">
 <select name="tipo" class="input">
      <option > Tipo de empleado</option>  
      <option > Cocinero</option>     
      <option > Repartidor</option>   
 
  </select>
                    <input class="input" type="text" placeholder="&#128100;  Usuario"  name="usuario">
        
                    <input class="input" type="password" placeholder="&#9993;  Contraseña"  name="contrasena">

                    <div class="btn__form">
<input class="btn__submit" type="submit" value="REGISTRAR">
<input class="btn__reset" type="reset" value="LIMPIAR">	
</div>
		</form>
	</div>
    </body>
</html>
