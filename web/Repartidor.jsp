<%-- 
    Document   : Repartidor
    Created on : 6/06/2018, 10:10:03 AM
    Author     : Oswaldo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Conexion.*"%>
<%@page import="java.sql.*"%>
<%!
    ResultSet cdr = null;
    ResultSet cdr2 = null;
    Statement sentenciaSQL = null;
    Conexion conecta = new Conexion();   
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/estiloGerente.css" rel="stylesheet">
        <script type="text/javascript" src="jsOswaldoS.js"> </script>
        <script type="text/javascript" src="jsGerente.js"> </script>
        <title>Entretiempo</title>        
    </head>
    <body>
        <input type="hidden" value="asignada" id="estado">
        <h1>¡Bienvenido!</h1>
        <table align="center" width="100%">
        <tr>
            <!--<td><input type="button" value="Ver ordenes" onclick="DinamicoDiv('lista');"></td>-->
            <td><input type="button" value="Ver" onclick="verOrdenesOswaldo();"></td>
            <td><a href="index.jsp"><input type="button" value="Cerrar sesión"></a></td>
        </tr>
    </table>
        <div id="lista">                        
            <div id="res"></div>
        </div>
    </body>
</html>