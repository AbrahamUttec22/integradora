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
          <link href="css/estiloGerente.css" rel="stylesheet">
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
     
            HttpSession cliente = request.getSession();
            
     String sql="select fecha from pedido_evento where id_usuario='"+cliente.getAttribute("cliente")+"' and estatus='ENTREGADO' ";
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
              
                HttpSession encuesta = request.getSession();
  encuesta.setAttribute("fechaEncuesta",fechaBase);
               out.print("<br><br>");
               out.print("<a href=Encuesta.jsp target=_blank>Realizar Encuesta</a>");
               out.print("<br><br>");out.print("<br><br>");out.print("<br><br>");
               
           }else if (cont<=1){
               out.print("No tienes encuestas pendientes");
               out.print("<br><br>");
               out.print("<br><br>");out.print("<br><br>");out.print("<br><br>");
               
               
           }
  /////////////////////////////////////////////         
        } catch (Exception e) {
            System.out.println("error consulta"+e);
        }
          
        %>
     
    </center>
    </body>
</html>
