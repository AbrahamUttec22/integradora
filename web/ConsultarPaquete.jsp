<%-- 
    Document   : ConsultarPaquete
    Created on : 5/06/2018, 04:35:30 PM
    Author     : Araceli
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="Conexion.Conexion"%>
<%@page import="java.sql.Statement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/abra.css" rel="stylesheet">
        <title>Paquetes</title>
    </head>
    <body>
        <h1>Consultar paquetes</h1>
        <table width=100% border=1  class="tb">
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Precio</th>
                    <th>Descripción</th>
                    <th>Imagen</th>               
                    </tr>
                    <%
                      Conexion conexion= new Conexion();
                      conexion.Conectar();
                      Statement sentenciaSQL=null;
                        try{
            String strComando="Select * from paquete";
            sentenciaSQL=conexion.getSentenciaSQL();
            ResultSet cdr=sentenciaSQL.executeQuery(strComando);
            while (cdr.next()){
                out.println("<tr>");
                out.println("<td width=15>"+cdr.getInt("id_paquete")+"</td>");
                out.println("<td width=20>"+cdr.getString("nombre_paquete")+"</td>");
                out.println("<td width=15>"+cdr.getString("precio")+"</td>");
                out.println("<td width=30>"+cdr.getString("descripcion")+"</td>");
                out.println("<td width=15><img src="+cdr.getString("imagen")+" width=70% > </td>");
                out.println("<td width=10>"+"<form method='post' action='GestionesPaquetes'> <input type='submit' value='Actualizar' name='submits'> <input type='hidden' value='"+cdr.getInt("id_paquete")+"' name='numero'></form>"+"</td>");
                out.println("<td width=10>"+"<form method='get' action='GestionesPaquetes'> <input type='submit' value='Eliminar' name='submits'> <input type='hidden' value='"+cdr.getInt("id_paquete")+"' name='numero'></form>"+"</td>");
                out.println("</tr>");
                               }
                
        }catch(SQLException e){
            out.println(e);
    }%>                              
            </table><br/><br/><br/>
            <a href=RegistrarPaquetes.jsp>Registrar paquete</a><br/><br/><br/>
            <a href=PrincipalG.jsp>Regresar</a></body></html>
</html>
