<%-- 
    Document   : ConsultasG
    Created on : 31/05/2018, 07:23:14 AM
    Author     : granq
--%>

<%@page import="java.sql.*"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Conexion.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Entretiempo</title>
         <link rel="stylesheet" href="css/abra.css"> 
         <style type="text/css" >
             
body {
  background-color: lightblue;
  }

nav{
    /*Bordes redondeados*/
    
    -webkit-border-radius:100px;/*Para chrome y Safari*/
    -moz-border-radius:100px;/*Para Firefox*/
    -o-border-radius:100px;/*Para Opera*/
    border-radius:100px;/*El estandar por defecto*/
    background-image: -webkit-gradient(linear, left top, left bottom, from(#FFF), to(#CCC));/*Para chrome y Safari*/
    /*Degradados*/
    background-image: -moz-linear-gradient(top center, #FFF, #CCC);/*Para Firefox*/
    background-image: -o-linear-gradient(top, #FFF, #CCC);/*Para Opera*/
    background-image: linear-gradient(top, #FFF, #CCC);/*El estandar por defecto*/
    overflow:hidden;
    padding:50px;
    width:400px;
     margin-top: 100px;
    
}
img{
    align:left;
}
header{
    position: fixed;
  top:0;
  width:1300px;
  height:100px;
  background-color:#333;
  color:#FFFFFF;
 padding: 10px;
  margin-top: 0px;
  text-align: right;
  font-size: 100px;
  }
  </style>
    </head>
    <body>
        <center>
    <nav>
            <table >
                <tr>
  <td> <a href="RegistraG.jsp">Registrar </a></td>
  <td> <a href="ActualizarG.jsp">Actualizar </a></td>
  <td> <a href="ConsultasG.jsp">Consulta </a></td>
  <td> <a href="BajasG.jsp">Dar de baja </a></td>
                </tr>
            </table>
        </nav>
             </center>   
  
       <form action="ConsultasG.jsp" method="post">
           <center>  <input class="input" type="text" placeholder="&#128100;  Ingresa el rfc"  name="rfc" size="30">
               <select name="tipo" class="input">
               <option> Elige</option>
               <option> Cocinero</option>
               <option> Repartidor</option> 
               <option> Todos</option>  
           </select>  
               
               </center>
           <div class="btn__form">
<input class="btn__submit" type="submit" value="BUSCAR" size="1">
<input class="btn__reset" type="reset" value="LIMPIAR">	
</div>
		</form>
    <br><br><br><br>   
    <center>
    <table class="tabla">
       <tr>
<th>Nombre</th>
<th>Paterno </th>
<th>Materno </th>
<th>RFC</th> 
<th>Telefono</th> 
<th>Estado</th> 
<th>Tipo</th> 
<th>Usuario</th> 
<th>Contraseña</th> 
<th>Direccion</th> 
<th>Imagen</th> 
       </tr>
<tr class="modo1">
    <% 
        /**
         * while(rs.next()) {
		//out.println("<td>" + rs.getString("Nombres") + "</td>");
	()} // end while
         */
        try {
             out.println("<tr class=modo1>");
            
            out.println("</tr>");
            String filtro="";
            String validar="";
            filtro=request.getParameter("tipo");
            String filtro2="";
            filtro2=request.getParameter("rfc");
           String sql="";
           if(filtro2.equals("")){
               validar="nada";
           }else{
               validar="algo";
           }
           
           
           if (validar.equals("algo")){
sql="select * from empleado em inner join sesion se on se.id_usuario=em.id_usuario where em.rfc='"+filtro2+"';";
                   
           }else{
                 
               if (filtro.equals("Todos")){
                sql="select * from empleado em inner join sesion se on se.id_usuario=em.id_usuario;";
    
            }else if (filtro.equals("Cocinero")){
                sql="select * from empleado em join sesion se on se.id_usuario=em.id_usuario where se.tipo_usuario='Cocinero';";
            }else if (filtro.equals("Repartidor")){
        sql="select * from empleado em join sesion se on se.id_usuario=em.id_usuario where se.tipo_usuario='Repartidor';";
            }
     }
          
 
 Conexion conexion= new Conexion();
     conexion.Conectar();
     //conexion.Conectar();
     PreparedStatement sentencia= conexion.getConexion().prepareCall(sql);
     ResultSet resultado = sentencia.executeQuery(); //resultset resultado obtener los datos de columna correspondientes a un fila
            while (resultado.next()) { // con un while podremos recorrer las columnas del registro por eso usamos el next()
            out.println("<tr class=modo1>");
            out.println("<td>" + resultado.getString("nombre") + "</td>");
           out.println("<td>" + resultado.getString("apellido_p") + "</td>");
           out.println("<td>" + resultado.getString("apellido_m") + "</td>");
           out.println("<td>" + resultado.getString("rfc") + "</td>");
           out.println("<td>" + resultado.getString("telefono") + "</td>");
           out.println("<td>" + resultado.getString("estado") + "</td>");
           out.println("<td>" + resultado.getString("tipo_usuario") + "</td>");
           out.println("<td>" + resultado.getString("usuario") + "</td>");
           out.println("<td>" + resultado.getString("contrasena") + "</td>");
           out.println("<td>" + resultado.getString("direccion") + "</td>");
           out.println("<td>" + resultado.getString("imagen") + "</td>");
            out.println("</tr>");
            }
            
        } catch (Exception e) {
            System.out.println("error consulta"+e);
        }
     
    %>

</tr>


</center>
    </table>
    </body>
</html>
