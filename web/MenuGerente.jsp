<%-- 
    Document   : MenuGerente
    Created on : 23/06/2018, 04:20:50 PM
    Author     : Araceli
--%>

<%@page import="Conexion.Conexion"%>
<%@page import="java.sql.*"%>
<%@page import="java.sql.SQLException"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <%-- SCRIPT JONATHAN cliente --%>
        <script type="text/javascript" src="jsJonathan/GestionarD.js"> </script>
          
           <%-- SCRIPT JONATHAN --%>
        <script type="text/javascript" src="jsOswaldoSalazar.js"> </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/estiloGerente.css" rel="stylesheet">
        <script type="text/javascript" src="jsGerente.js"> </script>
        <%-- SCRIPT ABRAHAM --%>
        <script type="text/javascript" src="jsAbraham/GestionesA.js"> </script>
        <script type="text/javascript" src="jsCheli/ActivarTarjetas.js"> </script>
        <script type="text/javascript" src="jsCheli/jsarchivo.js"> </script>
        <script type="text/javascript" src="jsCheli/Menu.js"> </script>
        <script type="text/javascript" src="jsCheli/jsCalificar.js"> </script>
        <script type="text/javascript" src="jsCheli/jsPaquetes.js"> </script>
        <script type="text/javascript" src="jsCheli/jsPedidosPaquetes.js"> </script>
        <script type="text/javascript" src="jsCheli/jsQuejas.js"> </script>
        <script type="text/javascript" src="jsAbraham/Mesagerente.js"> </script> 
          <script type='text/javascript' src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
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
          <%-- SCRIPT ABRAHAM --%>
          
         
        <title>Entretiempo</title>
        <h1>Bienvenido!</h1>
    <table align="center" width="100%">
        <tr>
            <td><input type="button" value="Inicio" onclick="DinamicoDiv('inicio');"></td>
            <td><input type="button" onclick="DinamicoDiv('empleado');"value="Empleados"></td>
            <td><input type="button" onclick="DinamicoDiv('platillos');" value="Platillos" onclick=""></td>
            <td><input type="button" onclick="DinamicoDiv('repartidor');"value="Asignar Repartidor"></td>
       <td><input type="button" onclick="DinamicoDiv('menu');" value="Subir menú del día"></td>
     <td><input type="button" onclick="DinamicoDiv('paquetes');" value="Paquetes"></td>
        <td><input type="button" onclick="DinamicoDiv('mesas');" value="Mesas"></td>
        <td><input type="button" onclick="DinamicoDiv('archivo');" value="Subir archivo"></td>
        <td><input type="button" onclick="DinamicoDiv('reportesE');" value="Reportes de encuestas"></td>
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
       
       <%--Menu cheli--%>
  <div id="menu" style="display: none"><h3 align="center">Menú del día</h3>
            <div id="consultar"><form align="center">
            <label>Descripción del Menú</label>
            <br/>
            <textarea id="descripcion" rows="10" cols="40" required=""></textarea>
            <br/><br/><br/>
            <label>Precio</label>&nbsp;&nbsp;&nbsp;$<input type="text" id="precio" required=""><br/><br/><br/>
            <label>Imagen</label>&nbsp;&nbsp;&nbsp;<input type="file" id="imagen" required=""><br/><br/><br/>
            <input type="button" value="Guardar" onclick="SubirMenu();">&nbsp;&nbsp;&nbsp;
            <input type="button" value="Ver menú" onclick="ConsultarMenu();"><br/><br/></form>
            </div><div id="detallemenu"></div>           
        </div>
  <div id="repartidor" style="display: none">
            <h3>Asignar Repartidor</h3>
            <input type="button" value="Asignar Repartidor" onclick="MostrarEmpleadosDispoiblesyOrdenesListas();">
            <!-- <input type="button" value="Asignar Repartidor" onclick="verOrdenesOswaldo2();">-->            
            <div id="lista"></div>
        </div>
       <div id="paquetes" style="display: none"><h3 align="center">Paquetes</h3>
            <!--<br/><center><input type="button" value="Consultar" onclick="ConsultarPaquetes();">
                <input type="button" value="Registrar" onclick="RegistrarPaquete();">
                <input type="button" value="Actualizar" onclick="ActualizarPaquete();">
            <br/><br/></center>       --><div id="mostrar">
            <%
Statement sentenciaSQL=null;
Conexion conecta=new Conexion();
conecta.Conectar();
try{
            String strComando="Select * from paquete";
            sentenciaSQL=conecta.getSentenciaSQL();
            ResultSet cdr=sentenciaSQL.executeQuery(strComando);
            out.println("<table align=center width=100% ><tr><td>Nombre</td><td>Precio</td><td>Descripción</td><td>Imagen</td></tr>");
            while (cdr.next()){
                out.println("<tr>");
                out.println("<td width=20>"+cdr.getString("nombre_paquete")+"</td>");
                out.println("<td width=15>"+cdr.getString("precio")+"</td>");
                out.println("<td width=30>"+cdr.getString("descripcion")+"</td>");
                out.println("<td width=15><img src="+cdr.getString("imagen")+" width=70% > </td>");
                out.println("<td width=15><input type=button value=Actualizar onclick=ActualizarPaquete("+cdr.getString("id_paquete")+");></td>");
                out.println("<td width=15><input type=button value=Eliminar onclick=EliminarPaquetes("+cdr.getString("id_paquete")+");></td>");
                out.println("</tr>");
                }
                out.println("</table>");
        }catch(SQLException e){
            out.println(e);
    }
            %>
            <center><input type="button" value="Registrar nuevo paquete" onclick="RegistrarPaquete()"></center></div>
            <div id="detallePaquetes"></div>
                
       </div> 
    <%-- MESAS ABRAHAM--%>   
        <div id="mesas" style="display: none">
            <br><br><br><br>
    
            <center>
                Elige el tipo de mesa<select id="tipoMesa" onchange="iniciarAbraham();">
                    <option>Elige</option>
                    <option value="chicas">Chicas</option>
                    <option value="medianas">Medianas</option>
                    <option value="grandes">Grandes</option>
                </select>
                <br><br><br>
               <div id="mesa">
        </div>
       
        <div id="cotizacion">
        </div>
    </center>
 </div>  
    <%-- MESAS ABRAHAM--%> 
        <div id="archivo" style="display: none"><h3>Subir archivo</h3>
            <br/><center> Elegir archivo &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="file" id="archivotxt">
                <br/><br/><input type="button" value="Subir Archivo" onclick="subirarchivo();" required=""><div id="respuestaArchivo"></div></center>
        </div>
        <%-- REPORTES ABRAHAM--%> 
        <div id="reportesE" style="display: none">
            <br><br><br><br>
            <center>
                <a href="GraficasMes.jsp" target="_blank"> <input type="button" value="MES"></a>
                <br><br><input type="button" value="Reportes de quejas" onclick="Reportes();">
                <br><br><div id="detallesreportes"></div>
            </center>
        </div>
            
       
        <%-- REPORTES ABRAHAM--%> 
                 	<%-- GESTIONES JON --%>
 <div id="platillos" style="display: none"><br><br>
        <center>
      <input type="radio" name="platillor" onclick="RegistarP();">Registar
      <input type="radio" name="platillor" onclick="RegistarP();">Consultar
      
     <br><br><br><br>
               <table>
          <tr>
	     <td VALIGN="TOP" width="20%">
		<div id="mostrar0" >
                  </div>
	     </td>
              <td width="80%">



                  <div id="mostrar1" >
                  </div>
                  <div id="mensaje1" ></div>
                  
              </td>
          </tr>
      </table>
          </center> 
     </div>      
        <%-- GESTIONES JON --%>
    </body>
</html>
