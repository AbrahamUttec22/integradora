<%-- 
    Document   : MenuCliente
    Created on : 1/07/2018, 05:39:31 PM
    Author     : Araceli
--%>

<%@page import="datosCliente.datosCliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Conexion.*"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
 <% int id = datosCliente.id_usuario; %>
<html>
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="css/estiloGerente.css" rel="stylesheet">
         <script type="text/javascript" src="jsCheli/jsPedidosPaquetes.js"> </script>
        <script type="text/javascript" src="jsGerente.js"> </script>
         <%--js ABRAHAM--%>
         <script type="text/javascript" src="jsAbraham/AbrahamReservarMesa.js"> </script>
         <script type="text/javascript" src="miAbraham.js"> </script>
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>   
          <%--js ABRAHAM--%>
        <title>Entretiempo</title>
    <input type="hidden" value="<%= id %>" id="idCliente">
     <%--estilo para pintar las mesas--%>
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

        </style>
    </head>
    <body>
        <h1>¡Bienvenido!</h1>
        <table align="center" width="100%">
        <tr>
            <td><input type="button" value="Mi perfil" onclick="DinamicoDiv('inicio');"></td>
            <td><input type="button" onclick="DinamicoDiv('ordenar_comida');"value="Ordenar comida"></td>
            <td><input type="button" onclick="DinamicoDiv('platillos');" value="Calificar platillo" onclick=""></td>
       <td><input type="button" onclick="DinamicoDiv('encuesta');" value="Realizar encuesta"></td>
     <td><input type="button" onclick="DinamicoDiv('pagos');" value="Realizar pagos"></td>
        <td><input type="button" onclick="DinamicoDiv('mesas');" value="Reservar mesa"></td>
        <td><input type="button" onclick="DinamicoDiv('paquetes');" value="Paquetes para eventos"></td>
        <td><a href="index.jsp"><input type="button" value="Cerrar sesión"></a></td>
        </tr>
    </table>
        <%--EL PERFIL ABRAHAM Y OSWALDO--%>
        <div id="inicio" style="display: none"><h3>Mi perfil</h3>
            <br><br><br>
            <table width="100%">
                <tr>
                    <td width="20%">
                        <a href="#"  onclick="mostrarE();">Encuestas</a><br><br>
                        <a href="#" onclick="mostrarT();">Ticket de Reservas</a><br><br>
                    </td>
                    <td>
                    <center>
                        <div id="encuestaabraham">
                            <% int idT=0;
            String img;
            Conexion conecta = new Conexion();
            conecta.Conectar();
            Statement sentenciaSQL = null;
            try{
            String strComando = "select * from cliente c inner join sesion s on c.id_usuario=s.id_usuario where c.id_usuario="+id;
            sentenciaSQL=conecta.getSentenciaSQL();
            ResultSet rs=sentenciaSQL.executeQuery(strComando);
            while(rs.next())
            {
                out.println("<img src=imgUsuario/"+rs.getString("imagen")+" style='width: 10%;' >");
                out.println("<h5>CLIENTE:&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("Nombre")+" "+rs.getString("apellido_p")+"</h5>");
                idT=rs.getInt("id_tarjeta");
            }
            }   catch(Exception e){
                out.println("ERROR"+e.getMessage());
            }
            try{
            String strComando = "select * from tarjeta t inner join cliente c on t.id_tarjeta=c.id_tarjeta where t.id_tarjeta="+idT;
            sentenciaSQL=conecta.getSentenciaSQL();
            ResultSet rs=sentenciaSQL.executeQuery(strComando);
            while(rs.next())
            {
                out.println("<h5>Saldo: &nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("saldo")+"</h5>");
            }
            }   catch(Exception e){
                out.println("ERROR"+e.getMessage());
            }
        %>
                            <a href="ServBuscarClinte"><h5>Actualziar Datos</h5></a>
                        </div>                       
                    </center>
                        
                    </td>
                </tr>
            </table>
      
        </div>
       <%--EL PERFIL ABRAHAM Y OSWALDO--%>
        <div id="ordenar_comida" style="display: none"><h3>Ordenar comida</h3></div>
        <div id="platillos" style="display: none"><h3>Calificar platillo</h3></div>
        <div id="encuesta" style="display: none"><h3>Realizar encuesta</h3></div>
        <div id="pagos" style="display: none"><h3>Realizar pagos</h3></div>
          <%--PROCESOS ABRAHAM--%>
          <div id="mesas" style="display: none"><center><br><br><h3>Reservar mesa</h3><br><br>
  Fecha: <input type="date" id="fecha" value="">&nbsp;
  Hora:  <input type="time" id="hora" min="13:00:00" value="">&nbsp;
  Numero de personas:  <input type="number" min="1" id="comensal" value="1"  >&nbsp;
  <input type="submit" id="enviar" value="enviar" onclick="iniciar();"><br><br><br>
        <div id="mesa">
        </div>
       
        <div id="cotizacion">
        </div>  
        
              </center>
        </div>
         <%--PROCESOS ABRAHAM--%>
      <%--Procesos cheli--%>
        <div id="paquetes" style="display: none"><h3>Paquetes para eventos</h3>
            <div id="opc"><br/><form name="opciones">
            <input type="radio" name="opc" value="1" onclick="MostrarOpciones();">&nbsp;Ver paquetes&nbsp;&nbsp;&nbsp;
            <input type="radio" name="opc" value="2" onclick="MostrarOpciones();">&nbsp;Ver platillo
                </form></div><div id="detallepaquetes"></div><div id="mostrarinfo"></div>
        </div>


    </body>
</html>
