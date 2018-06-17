<%-- 
    Document   : Mesa
    Created on : 17/06/2018, 12:13:22 PM
    Author     : granq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="jsAbraham/verMesaG.js"></script>
    </head>
    <body>
        <a href="PrincipalG.jsp">Inicio</a>
    <br><br><br><br>
    <center>
    <select id="tipo" onchange="mostrarMesas();">
        <option>Elige</option>
        <option value="chica">Mesas chicas</option>
        <option value="mediana">Mesas Medianas</option>
        <option value="grande">Mesas Grandes</option>
    </select>
    
    <br><br><br><br>
        <div id="mostrar">
            
        </div>
    </center>
    </body>
</html>
