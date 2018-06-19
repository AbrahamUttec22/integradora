<%-- 
    Document   : Reserva
    Created on : 16/06/2018, 10:14:42 AM
    Author     : granq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="jsAbraham/mesas.js"> </script>
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
    <body><center>
        <br><br>
        <a href="PrincipalUsuario.jsp">Regresar</a>
        <div>
            <br><br><br><br><br><br><br><br><br>
       
            Fecha: <input type="date" id="fecha" >&nbsp;
                Hora:  <input type="time" id="hora" >&nbsp;
                Numero de personas:  <input type="number" min="1" id="comensal" name="hora">&nbsp;
                <input type="submit" id="enviar" value="enviar" onclick="iniciar();"><br><br><br>
           
        </div>
        <br><br><br>
        <div id="mesa">
     
        </div>
     
    </center>

    </body>
</html>
