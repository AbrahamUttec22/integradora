<%-- 
    Document   : PrincipalG
    Created on : 31/05/2018, 06:52:57 AM
    Author     : granq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Entretiempo</title>
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
            <table>
                <tr>
  <td> <a href="GestionEmpleados.jsp">Gestionar Empleados </a></td>
  <td><a href="RegistrarP.jsp">Gestionar Platillos</a></td>
  <td><a href="MenudelDia.jsp">Subir menú del día</a></td>
  <td><a href="ConsultarPaquete.jsp">Consultar Paquetes</a></td>
  <td><a href="Mesa.jsp">Mesas</a></td>
  <td><a href="index.jsp">Cerrar Sesion</a></td>
 
                </tr>
            </table>
        </nav>
                
    </center>
    </body>
</html>
