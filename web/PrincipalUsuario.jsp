<%-- 
    Document   : PrincipalUsuario
    Created on : 31/05/2018, 06:52:45 AM
    Author     : granq
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="Conexion.Conexion"%>
<%@page import="clases_osr.DatosCliente"%>
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
            <table>
                <tr>
<<<<<<< HEAD
                    <td> <a href="IniciarSesion.jsp">Iniciar Sesion </a></td>
                    <td> <a href="">Contactanos </a></td>
                    <td> <a href="index.jsp">Cerrar Sesion</a></td>
=======
                    <td> <a href="InterfazEncuesta.jsp">Hacer encuesta </a></td>
                    
>>>>>>> origin/master
                </tr>
            </table>
        </nav>      
    </center>
    <center>
            <% int id = DatosCliente.id_cliente; int idT=0;
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
        <a href="http://localhost:9090/SWPR/ServBuscarClinte"><h5>Actualziar Datos</h5></a>
        </center>
    </body>
</html>
