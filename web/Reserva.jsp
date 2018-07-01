<%-- 
    Document   : Reserva
    Created on : 16/06/2018, 10:14:42 AM
    Author     : granq
--%>

<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
     <%
    Calendar calendario = Calendar.getInstance();
  int hora =calendario.get(Calendar.HOUR_OF_DAY);
  int minutos = calendario.get(Calendar.MINUTE);
 int an= calendario.get(Calendar.YEAR);
  int me= calendario.get(Calendar.MONTH)+1;
   int di= calendario.get(Calendar.DAY_OF_MONTH);
  String actual=String.valueOf(hora+2);
  String actua=String.valueOf(minutos);
 String ano=String.valueOf(an);
 String mes=String.valueOf(me);
 String dia=String.valueOf(di);
  String hora_actual="";
  String fecha="";
            %>
            
           <%
            if(minutos<=9){
      actua="0"+actua;
           }
            if (me<10){
                mes="0"+mes;
            }
            fecha=ano+"-"+mes+"-"+dia;
           %>
                   
            
            
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="jsAbraham/rere.js"> </script>
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
            <br><br><br>
       
            Fecha: <input type="date" id="fecha" value="<%=fecha%>">&nbsp;
  Hora:  <input type="time" id="hora" min="13:00:00" value="<%=hora_actual=actual+":"+actua%>">&nbsp;
  Numero de personas:  <input type="number" min="1" id="comensal" value="2" name="hora" >&nbsp;
                <input type="submit" id="enviar" value="enviar" onclick="iniciar();"><br><br><br>
           
        </div>
        
  <br>
        <div id="mesa">
        </div>
       
        <div id="cotizacion">
        </div>
    </center>

    </body>
</html>
