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
         <style>
 .chicasDisponibles{
  background-image:url(img/chicasD.jpeg);
  background-repeat:no-repeat;
  height:120px;
  width:150px;
  background-position:center;
}
.chicasOcupadas{
  background-image:url(img/chicasO.jpeg);
  background-repeat:no-repeat;
  height:120px;
  width:150px;
  background-position:center;
}
  .medianasOcupadas{
  background-image:url(img/medianasO.jpeg);
  background-repeat:no-repeat;
  height:120px;
  width:150px;
  background-position:center;
}
  .medianasDisponibles{
  background-image:url(img/medianasD.jpeg);
  background-repeat:no-repeat;
  height:120px;
  width:150px;
  background-position:center;
}
  .grandesOcupadas{
  background-image:url(img/grandesO.jpeg);
  background-repeat:no-repeat;
  height:120px;
  width:150px;
  background-position:center;
}
  .grandesDisponibles{
  background-image:url(img/grandesD.jpeg);
  background-repeat:no-repeat;
  height:120px;
  width:150px;
  background-position:center;
}
  
        body {
		background-color: #FFCC66;
	}

        
        </style>
    </head>
    <body><br><br>
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
    <br><br><br><br>
    <br><br><br><br>
 <div id="datos">
            
        </div>
    <br><br><br><br>
    <br><br><br><br>
    </center>
    </body>
</html>
