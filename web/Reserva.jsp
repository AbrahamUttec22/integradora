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
    </head>
    <body><center>
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
