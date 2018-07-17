<%-- 
    Document   : MenuCliente
    Created on : 1/07/2018, 05:39:31 PM
    Author     : Araceli
--%>

<%@page import="java.util.Calendar"%>
<%@page import="datosCliente.datosCliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Conexion.*"%>
<%@page import="java.sql.*"%>

<!DOCTYPE html>
 <% 
     Conexion conecta = new Conexion();
     conecta.Conectar();
     int id = datosCliente.id_usuario; 
     int hora,minutos;
            String dia,mes,ano;
            Calendar obj = Calendar.getInstance();
            hora=obj.get(Calendar.HOUR_OF_DAY);
            minutos=obj.get(Calendar.MINUTE);
            int y=obj.get(Calendar.YEAR);
            int mo=obj.get(Calendar.MONTH)+1;
            int day=obj.get(Calendar.DAY_OF_MONTH);
            String horaSis= hora+":"+minutos;
 %>
<html>
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="css/estiloGerente.css" rel="stylesheet">
         <script type="text/javascript" src="jsCheli/ActivarTarjetas.js"> </script>
         <script type="text/javascript" src="jsCheli/Menu.js"> </script>
         <script type="text/javascript" src="jsCheli/jsCalificar.js"> </script>
         <script type="text/javascript" src="jsCheli/jsPaquetes.js"> </script>
         <script type="text/javascript" src="jsCheli/jsPedidosPaquetes.js"> </script>
         <script type="text/javascript" src="jsCheli/jsQuejas.js"> </script>
         <script type="text/javascript" src="jsCheli/jsarchivo.js"> </script>
        <script type="text/javascript" src="jsGerente.js"> </script>
        <script type="text/javascript" src="jsOswaldoRegistro.js"> </script>
         <%--js ABRAHAM--%>
         <script type="text/javascript" src="jsAbraham/AbrahamReservarMesa.js"> </script>
         <script type="text/javascript" src="jsAbraham/todoMesa.js"> </script>
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>   
          <%--js ABRAHAM--%>
        <title>Entretiempo</title>
    <input type="hidden" value="<%= id %>" id="idCliente">
     <%--estilo para pintar las mesas--%>
      <%-- SCRIPT JONATHAN --%>
      <script type="text/javascript" src="jsJonathan/ordenar2.js"> </script>
          
           <%-- SCRIPT JONATHAN --%>

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
            <td><input type="button" onclick="DinamicoDiv('ordenes');"value="Ver ordenes"></td>
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
                        <a href="#" onclick="mostrarT();">Ticket de Reservas</a><br>
                        <a href="#" onclick="formularioActualziarDatos();" >Actualziar Datos</a><br>
                        <input type="button" value="Actualizar Tarjetas" onclick="ElegirTarjeta();"><br><br>
                        <input type="button" value="Enviar queja o comentario" onclick="Enviarquejas();">
                        </td>
                        <td>
                            <center>
                                <div id="encuestaabraham">                                                                             
                                                                        <% int idT=0;
                    String img;
                    conecta.Conectar();
                    Statement sentenciaSQL = null;

                    HttpSession cliente = request.getSession();

                    try{
                    String strComando = "select * from cliente c inner join sesion s on c.id_usuario=s.id_usuario where c.id_usuario="+cliente.getAttribute("cliente");
                    ;
                    sentenciaSQL=conecta.getSentenciaSQL();
                    ResultSet rs=sentenciaSQL.executeQuery(strComando);
                    while(rs.next())
                    {
                        out.println("<img src="+rs.getString("imagen")+" style='width: 10%;' >");
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
                                </div>                    
                                <div id="detalletarjetas"></div>
                                <div id="activartarjeta"></div>   
                            </center>
                        </td>
                </tr>
            </table>      
        </div>
       <%--EL PERFIL ABRAHAM Y OSWALDO--%>
      <div id="platillos" style="display: none"><h3>Calificar platillo</h3>
       <%          
conecta.Conectar();
try{
            String strComando="select max(id_pedido)as id_pedido from pedido where id_usuario="+id;
            sentenciaSQL=conecta.getSentenciaSQL();
            ResultSet cdr=sentenciaSQL.executeQuery(strComando);
            int pedido=0;
            while (cdr.next()){
                pedido=(cdr.getInt("id_pedido"));  
                if (pedido!=0){
                    final String SQL="call PlatillosOrden(?)";                                    
            CallableStatement cs=conecta.getConnection().prepareCall(SQL);
            cs.setInt(1,pedido);            
            cdr =cs.executeQuery();
            out.println("<table width=100% >"
                        + "<th width=20% >Platillo</th><th></th><th></th><th></th><th></th><th></th><th></th>");
            while(cdr.next()){
                String nombre=cdr.getString("nombre");
                String strComando1="select estatus from calificar_platillo where id_platillo=(select id_platillo from platillo where nombre='"+nombre+"') and id_usuario="+id;
                ResultSet cdr1=sentenciaSQL.executeQuery(strComando1);
                if (cdr1.next()){
                    if (cdr1.getString("estatus").equals("ignorado") || cdr1.getString("estatus").equals("calificado")){
                       //out.println("<h3>No tienes platillos pendientes</h3>");
                       break;
                    }
                }else{
                    out.println("<tr width=><td>"+cdr.getString("nombre")+"</td>"
                        + "<td width=10% ><button type=button><img src=img/cali2.png width=80px onclick=calificar('"+nombre+"02');></button></td>"
                        + "<td width=10% ><button type=button><img src=img/calificacion4.png width=80px onclick=calificar('"+nombre+"04');></button></td>"
                        + "<td width=10% ><button type=button><img src=img/cali6.jpg width=90px onclick=calificar('"+nombre+"06');></button></td>"
                        + "<td width=10% ><button type=button><img src=img/cali8.png width=80px onclick=calificar('"+nombre+"08');></button></td>"
                        + "<td width=10% ><button type=button><img src=img/cali10.jpg width=80px onclick=calificar('"+nombre+"10');></button></td>"
                        + "<td width=10% ><input type=button value=Ignorar onclick=ignorar('"+nombre+"');></td></tr>");
                }                
                }
            out.println("</table>");
                }else{
                    out.println("<h3>No tienes platillos pendientes</h3>");
                }
                }
            
        }catch(SQLException e){
           // out.println(e);
    }
            %>
            <br/><br/><input type="button" value="Mostrar los mejores platillos" onclick="toppla();">
            <div id="platillostop"></div>
      </div>
      <div id="ordenes" style="display: none"><h3>Lista de ordenes</h3>
        <%
            ResultSet cdr = null;
            try {            
            if(day<=9)
            {
                dia="0"+day;
            }
            else{
                dia= String.valueOf(day);
            }
            if(mo<=9)
            {
                mes="0"+mo;
            }
            else{
                mes= String.valueOf(mo);
            }
            String fecha=dia+"/"+mes+"/"+y;
            String strComando = "SELECT * FROM pedido where id_usuario="+id+" and fecha='"+fecha+"'";
            cdr = sentenciaSQL.executeQuery(strComando);
            if(cdr.next())
            {
            String strComando2 = "SELECT * FROM pedido where id_usuario="+id+" and fecha='"+fecha+"'";
            cdr = sentenciaSQL.executeQuery(strComando2);
            out.println("<table width=60% border=1>");            
            out.println("<tr>");
            out.println("<th>HORA ENTREGA</th><th>RESTANTE A PAGAR</th><th>TIPO DE ENTREGA</th><th> </th>");
            out.println("</tr>");
            while (cdr.next()) {
                    out.println("<tr>");
                    out.println("<td width='20%'>$"+ cdr.getDouble("subtotal") + " pesos</td>");
                    out.println("<td width='20%'>"+ cdr.getString("tipo_pedido") + "</td>");
                    out.println("<td><input type='button' value='Cancelar Orden' onclick=''><br>"
                            + " <input type='hidden' value='"+cdr.getInt("id_pedido")+"'> </td>");
                    out.println("</tr>");
                }
            out.println("</table>");
            }
            else{
                out.println("<h3>NO TIENES ORDENES DE HOY</h3>");
            }
        }catch (SQLException e) {
            out.println("Excepcion SQL:" + e.getMessage());
        } catch (NullPointerException e) {
            out.println("Apuntando SQL:" + e.getMessage());
        }
            %>
        </div>        
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
        
              </center> </div>
         <%--PROCESOS ABRAHAM--%>
           	<%-- DIV JON --%>
       <div id="ordenar_comida" style="display: none">
	  <center>
      
     <br><br><br><br>
     <table  width="100%" >
           
     <tr>
	     <td VALIGN="TOP" >
		<div id="ver0" >
		    <select id="menu" onChange="pintar();"><option>Elige una opcion</option><option>Entrada</option><option>PLato Fuerte</option>
	   <option>Postre</option><option>Bebida</option></select><br><br>

		   </div>
	     </td>
              <td width="100%" VALIGN="left">
		  <div id="ver1" >
	      </td>
		  </div>
	       <td VALIGN="TOP" >
	          <div id="men1" ></div>
                    <td VALIGN="TOP" width="40%">
	          <div id="men2" >
	  
	   <table border="1" class="imagetable" width="50%" id="myTable">
            <thead>
            <tr>

	   <th>Numero</th>
	   <th>Id platillo</th>    
	   <th>Precio</th>
	   <th>Nombre</th>
	   <th>Subtotal</th>
	   <th>IVA</th>
	   <th>Total</th>
	   </tr>
            </thead>
            <tbody id=tbl_bdy>
	   
	   
            </tbody>
	   </table><br><br>
		     <input type="button" id="todo" value="Borrar Carrito" onClick="borrarTodo();" />&nbsp;&nbsp;&nbsp;&nbsp;
		     <input type="button" id="calcular" value="Calcular" onclick="getAllRows();" /><br><br>
	   
	   </div>
		      <div id="men3" >
	   
	   </div>
		      <div id="men4" >
	   
	   </div>
		</div>
		      <div id="men5" >
	   
	   </div>
            <div id="men6" >
	   
	   </div>
                  </td>  
	        </td>
		  
          </tr>
	 
      </table>
     
     
          </center>
	  
       </div>
      	<%-- DIV JON --%>

         
      <%--Procesos cheli--%>
        <div id="paquetes" style="display: none"><h3>Paquetes para eventos</h3>
            <div id="opc"><br/><form name="opciones">
            <input type="radio" name="opc" value="1" onclick="MostrarOpciones();">&nbsp;Ver paquetes&nbsp;&nbsp;&nbsp;
            <input type="radio" name="opc" value="2" onclick="MostrarOpciones();">&nbsp;Ver platillo
                </form></div><div id="detallepaquetes"></div><div id="mostrarinfo"></div>
        </div>

    </body>
</html>
