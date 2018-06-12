<%-- 
    Document   : InterfazEncuesta
    Created on : 5/06/2018, 06:39:18 PM
    Author     : granq
--%>

<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Conexion.*"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
        <br><br><br><br><br>
    <center>
        <%
      String mensaje="No tienes encuesta por realizar";
      Calendar ca= Calendar.getInstance();
      int ye=ca.get(Calendar.YEAR);
      int moth=ca.get(Calendar.MONTH);
      int day=ca.get(Calendar.DAY_OF_MONTH);
   try{
       ////////////////////////////////////////////DECLARACIONES
   Conexion conexion= new Conexion();
     conexion.Conectar();
     String fechaHOY="";
     String fechaBase="";
     String mesHOY="";
     String anoHOY="";
     String diaHOY="";
     String mesBase="";
     String anoBase="";
     String diaBase="";
     int anoH=0,mesH=0,diaH=0,anoB=0,mesB=0,diaB=0;
     ///////////////////////////////////////////////OBTNER FECHA
      String sql2="select curdate()";
     int cont2=0;
     PreparedStatement sentencia2= conexion.getConexion().prepareCall(sql2);
     ResultSet resultado2 = sentencia2.executeQuery(); //resultset resultado obtener los datos de columna correspondientes a un fila
            while (resultado2.next()) { // con un while podremos recorrer las columnas del registro por eso usamos el next()
        fechaHOY=resultado2.getString(1);
            }
            anoHOY=fechaHOY.substring(0,4);
            mesHOY=fechaHOY.substring(5,7);
            diaHOY=fechaHOY.substring(8,10);
            anoH=Integer.parseInt(anoHOY);
            mesH=Integer.parseInt(mesHOY);
            diaH=Integer.parseInt(diaHOY);
     ////////////////////////////////////////////////////JALAR FECHA DE REGISTRO
     String sql="select fecha from pedido_evento where id_usuario='"+datosCliente.datosCliente.id_usuario+"' and estatus='ENTREGADO' ";
     int cont=0;
    
     PreparedStatement sentencia= conexion.getConexion().prepareCall(sql);
     ResultSet resultado = sentencia.executeQuery(); //resultset resultado obtener los datos de columna correspondientes a un fila
            while (resultado.next()) { // con un while podremos recorrer las columnas del registro por eso usamos el next()
            cont++;
            fechaBase=resultado.getString(1);
            anoBase=fechaBase.substring(6,10);
            mesBase=fechaBase.substring(3,5);
            diaBase=fechaBase.substring(0,2);
            anoB=Integer.parseInt(anoBase);
            mesB=Integer.parseInt(mesBase);
            diaB=Integer.parseInt(diaBase);  
           if (anoH>=anoB){
               if (mesH>mesB){
                   cont++;
               }else if (mesH<mesB && anoB<anoH){
                   cont++;
               }else if (mesH==mesB){
                  if (diaH>diaB){
                      cont++;
                  }
               }
           }
 }//while
            
 /////////////////////////////VALIDACION           
           if (cont>=2){
               out.print("Tienes una encuesta pendiente");
               datosCliente.datosCliente.fecha_pedido=fechaBase;
               out.print("<br><br>");
               out.print("<a href=Encuesta.jsp>Realizar Encuesta</a>");
               out.print("<br><br>");out.print("<br><br>");out.print("<br><br>");
               out.print("<a href=PrincipalUsuario.jsp>Regresar</a>");
           }else if (cont<=1){
               out.print("No tienes encuestas pendientes");
               out.print("<br><br>");
               out.print("<br><br>");out.print("<br><br>");out.print("<br><br>");
               out.print("<a href=PrincipalUsuario.jsp>Regresar</a>");
               
           }
  /////////////////////////////////////////////         
        } catch (Exception e) {
            System.out.println("error consulta"+e);
        }
          
        %>
     
    </center>
    </body>
</html>
