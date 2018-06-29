<%-- 
    Document   : MenuGerente
    Created on : 23/06/2018, 04:20:50 PM
    Author     : Araceli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/estiloGerente.css" rel="stylesheet">
        <script type="text/javascript" src="jsGerente.js"> </script>
        <%-- SCRIPT ABRAHAM --%>
        <script type="text/javascript" src="jsAbraham/abraham2.js"> </script>
          
          <script type='text/javascript' src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
          <%-- SCRIPT ABRAHAM --%>
        <title>Entretiempo</title>
        <h1>Bienvenido!</h1>
    <table align="center" width="100%">
        <tr>
            <td><input type="button" value="Inicio" onclick="DinamicoDiv('inicio');"></td>
            <td><input type="button" onclick="DinamicoDiv('empleado');"value="Empleados"></td>
            <td><input type="button" onclick="DinamicoDiv('platillos');" value="Platillos" onclick=""></td>
       <td><input type="button" onclick="DinamicoDiv('menu');" value="Subir menú del día"></td>
     <td><input type="button" onclick="DinamicoDiv('paquetes');" value="Paquetes"></td>
        <td><input type="button" onclick="DinamicoDiv('mesas');" value="Mesas"></td>
        <td><input type="button" onclick="DinamicoDiv('archivo');" value="Subir archivo"></td>
        <td><a href="index.jsp"><input type="button" value="Cerrar sesión"></a></td>
        </tr>
    </table>
    </head>
    <body>
        <div id="inicio" style="display: none"><h3>Inicio</h3></div>
 <%-- GESTIONES ABRAHAM --%>
        <div id="empleado" style="display: none"><br><br>
       
            <center>
      <input type="radio" name="Aempleado" onclick="ConsultaGerente();">Consultar
      <input type="radio" name="Aempleado" onclick="ConsultaGerente();">Registrar
      <input type="radio" name="Aempleado" onclick="ConsultaGerente();">Actualizar
      <input type="radio" name="Aempleado" onclick="ConsultaGerente();">Dar de baja 
     <br><br><br><br>
               <table>
          <tr>
              <td width="80%">



                  <div id="imprimirselectconsultaabraham" >
                  </div>
                  <div id="respuestaabraham" ></div>
                  
              </td>
          </tr>
      </table>
          </center> 
     </div>      
  <%-- GESTIONES ABRAHAM--%>      
        <div id="platillos" style="display: none"><h3>Platillos</h3></div>
        <div id="menu" style="display: none"><h3>Menú del día</h3></div>
        <div id="paquetes" style="display: none"><h3>Paquetes</h3></div>
        <div id="mesas" style="display: none"><h3>Mesas</h3></div>
        <div id="archivo" style="display: none"><h3>Subir archivo</h3></div>
    </body>
</html>
