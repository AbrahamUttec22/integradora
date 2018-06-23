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
        <script type="text/javascript" src="consultaGerente.js"> </script>
        <title>Entretiempo</title>
    </head>
    <body align="center">     
    <center><nav>
            <table>
                <tr>
  <td> <a href="GestionEmpleados.jsp">Gestionar Empleados </a></td>
  <td><a href="RegistrarP.jsp">Gestionar Platillos</a></td>
  <td><a href="MenudelDia.jsp">Subir menú del día</a></td>
  <td><input type="button" onclick="mostrarPaquete()" value="Paquetes"></td>
  <td><a href="Mesa.jsp">Mesas</a></td>
  <td><a href="index.jsp">Cerrar Sesion</a></td>
 
                </tr>
            </table>
        </nav></center><center>
                <nav id="detallegerente">                   
                </nav>   </center>
    </body>
</html>
