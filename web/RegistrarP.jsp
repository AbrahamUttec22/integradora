<%-- 
    Document   : RegistrarP
    Created on : 5/06/2018, 02:06:21 PM
    Author     : jonat
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
  <td> <a href="RegistrarP.jsp">Gestionar </a></td> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
  <td> <a href="http://localhost:8080/SWPR/SerDePla">Mostrar Detalle </a></td> &nbsp;&nbsp;&nbsp;
  <td> <a href="Calcular.jsp">Calcular Costo </a></td>&nbsp;&nbsp;&nbsp;             
                  <td> <a href="IniciarSesion.jsp">Inicio </a></td>&nbsp;&nbsp;&nbsp;
                </tr>
            </table>
        
        
        </nav>
             </center>   
	<div class="container">
		<div class="form__top">
			<h2>Insertar <span>Platillo </span></h2>
		</div>		
            <form class="form__reg" action="http://localhost:8080/SWPR/SerGesPl" method="get">
                <input class="input" type="text" placeholder="platillo" required autofocus name="nombre" value=""><br><br>
            
                        <select name="tipo" class="input" value="${resp2}">
                              <option > Tipo de platillo</option>  
                              <option > Entrada</option>
                              <option > Sopa</option>
                              <option > Plato Fuerte</option>   
                              <option > Postre</option>
                              <option > Bebida</option>
                        </select><br><br>                    
                    <input class="input" type="text" placeholder="$" name="precio" required autofocus><br><br>
 
 <label>Foto</label><input class="input" type="file" placeholder="&#128100;  Imagen"  name="imagen" required autofocus><br><br>
 <a href="RegistrarP.jsp"></a>
 
                    
                    <div class="btn__form">
<input class="btn__submit" type="submit" value="Registrar" name="enviar"><br><br>


<input class="btn__reset" type="reset" value="Limpiar"><br><br>
</div>
 
 
 
		</form>
                              	<div class="form__top">
                                    <h2><Span><a href="http://localhost:8080/SWPR/SerConPla"> Ver Registros de platillos <a></span></h2><br><br>
		</div>
                              
 
	</div>
    </body>
</html>
