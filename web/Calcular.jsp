<%-- 
    Document   : Calcular
    Created on : 7/06/2018, 06:46:25 PM
    Author     : jonat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
    width:400px;
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
            <table width="100%">
                <tr>

  <td> <a href="SerDePla">Mostrar Detalle </a></td> &nbsp;&nbsp;&nbsp;
  <td> <a href="ConsultasP.jsp">Calcular Costo </a></td>&nbsp;&nbsp;&nbsp;             
                  <td> <a href="PrincipalUsuario.jsp">Inicio </a></td>&nbsp;&nbsp;&nbsp;
                </tr>
            </table>
       
        
        </nav>
             </center>   
	<div class="container">
		<div class="form__top">
			<h2>Calcular <span>Pedido </span></h2>
		</div>		
            <form class="form__reg" action="SerCalPl" method="get">
                
                <input class="input" type="text" placeholder="id_usuario" required autofocus name="id_usuario" value="${resp2}"><br><br>
                <input class="input" type="date" placeholder="fecha" required autofocus name="fecha" value="${resp3}"><br><br>
                <input class="input" type="text" placeholder="subtotal" required autofocus name="subtotal" value="${resp4}"><br><br>
                     
<input class="input" readonly="readonly" type="text" placeholder="costo" name="costo" value="${resp5}"><br><br>
<input class="input" readonly="readonly" type="text" placeholder="total"  name="total" value="${resp6}"><br><br>
                
                        <select name="tipo" class="input" value="">
                            <option seleted="selected"> Domicilio</option> 
                            <option > Para consumir en el restaurante</option>
                             
                            
                        </select><br><br>                    
               

<input class="btn__submit" type="submit" value="calcular" name="enviar">
<input class="btn__submit" type="submit" value="Registrar" name="enviar">
<input class="btn__reset" type="reset" value="Limpiar"><br><br>
</div>
 
 
 
		</form>
                              
 
    </body>
</html>

