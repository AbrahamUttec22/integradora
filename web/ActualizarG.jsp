<%-- 
    Document   : ActualizarG
    Created on : 31/05/2018, 07:22:58 AM
    Author     : granq
--%>

<%@page import="java.sql.*"%>
<%@page import="Conexion.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
  String validar =(String)request.getAttribute("mensaje");

   if(validar!=null)
       out.println("<script>alert('"+validar+"')" + "</script>");

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ENTRETIEMPO</title>
          <link rel="stylesheet" href="css/abra.css"> 
        <style type="text/css">
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
     width:600px;
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
        <table WIDTH="500" height="50">
                <tr>
  <td> <a href="RegistraG.jsp">Registrar </a></td>
  <td> <a href="ConsultasG.jsp">Consulta </a></td>
 
  <td> <a href="PrincipalG.jsp">Inicio</a></td>
                </tr>
            </table>
        </nav>
             </center>   
    
       <form action="ActualizarG"  method="post" enctype="multipart/form-data">
           <center>  
           </center>
         
		
    <br><br><br><br>   
    <center>
  

 <% 

        try {
  int x=Integer.parseInt(request.getParameter("no"));
String sql="select * from empleado em inner join sesion se on se.id_usuario=em.id_usuario where em.id_usuario='"+x+"';";
 Conexion conexion= new Conexion();
     conexion.Conectar();
     //conexion.Conectar();
     PreparedStatement sentencia= conexion.getConexion().prepareCall(sql);
     ResultSet resultado = sentencia.executeQuery(); //resultset resultado obtener los datos de columna correspondientes a un fila
            while (resultado.next()) { // con un while podremos recorrer las columnas del registro por eso usamos el next()
       String nom=resultado.getString("nombre");
       String ap=          resultado.getString("apellido_p");
       String am=           resultado.getString("apellido_m");
       String rfc=            resultado.getString("rfc"); 
       String tel=            resultado.getString("telefono"); 
       String tipo=            resultado.getString("tipo_usuario"); 
       String usu=            resultado.getString("usuario");
       String con=            resultado.getString("contrasena");
       String dir=            resultado.getString("direccion"); 
       String im=            resultado.getString("imagen");
        String estado=            resultado.getString("estado");
                  
                  
    %>    
   <%
   if (resultado.getString("estado").equalsIgnoreCase("ACTIVO")){
       
   %>
     <table class="tabla">
       <tr>
<th>Nombre</th>
<th>Paterno </th>
<th>Materno </th>
<th>RFC</th> 
<th>Telefono</th> 
<th>Tipo</th> 
<th>Usuario</th> 
<th>Contraseña</th> 
<th>Direccion</th> 
<th>Imagen</th> 


       </tr>
       <tr class="modo1">
<td><input type="text" value="<%=nom%>" name="nombre" size="15"></td>
<td><input type="text" value="<%=ap%>" name="ap" size="15"></td>
<td><input type="text" value="<%=am%>" name="am" size="15"></td>
<td><input type="text" value="<%=rfc%>" name="rfc2" size="15"></td>
<td><input type="text" value="<%=tel%>" name="telefono" size="15"></td>
<td><input type="text" value="<%=tipo%>" name="tipo" size="15"></td>
<td><input type="text" value="<%=usu%>" name="usuario" size="15"></td>
<td><input type="text" value="<%=con%>" name="contrasena" size="15"></td>
<td><input type="text" value="<%=dir%>" name="direccion" size="15"></td>
<td><input type="file"  name="imagen" size="15"></td>
<input type="hidden" value="<%=im%>" name="bno"> 
<td><input type="hidden" value="<%=x%>" name="no" ></td>
</tr>

<%
}else if (resultado.getString("estado").equalsIgnoreCase("INACTIVO")){

%>
  <table class="tabla">
       <tr>
<th>Nombre</th>
<th>RFC</th> 
<th>ESTADO</th> 



       </tr>
         <tr class="modo1">
<td><input type="text" value="<%=nom%>" name="nombre" size="15"></td>
<td><input type="text" value="<%=rfc%>" name="rfc2" size="15"></td>
<td><input type="text" value="<%=estado%>" name="estado" size="15"></td>

<input type="hidden" value="<%=ap%>" name="ap" size="15">
<input type="hidden" value="<%=am%>" name="am" size="15">
<input type="hidden" value="<%=tel%>" name="telefono" size="15">
<input type="hidden" value="<%=tipo%>" name="tipo" size="15">
<input type="hidden" value="<%=usu%>" name="usuario" size="15">
<input type="hidden" value="<%=con%>" name="contrasena" size="15">
<input type="hidden" value="<%=dir%>" name="direccion" size="15">
<input type="hidden" value="<%=im%>" name="bno"> 
<input type="hidden" value="<%=x%>" name="no" >

  </tr>
<%
}

%>



</center>
    </table>
 <%   
    
       }   
        } catch (Exception e) {
            System.out.println("error consulta"+e);
        }
 %>
        
          <div class="btn__form">

<input class="btn__submit" type="submit" value="Actualizar" size="1" name="enviar">

           </div>
    </form>

    </body>
</html>
