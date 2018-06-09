<%-- 
    Document   : ConsultarMenu
    Created on : 11/06/2018, 12:22:09 PM
    Author     : Araceli
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="Conexion.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/abra.css" rel="stylesheet">
        <title>Menú del día</title>
    </head>
    <body>
        <h1>Menú del día</h1>
        <form action="ActualizarMenu" class="form__top">
        <label>Descripción del Menú</label>
            <br/>
            <textarea name="descripcion" values rows="10" cols="40" readonly="" name="descripcion">
                <%Conexion conexion= new Conexion();
                      conexion.Conectar();
                      Statement sentenciaSQL=null;
                        try{
                            String strComando="Select descripcion from menu_dia where id_menu=(SELECT MAX(id_menu) from menu_dia)";
            sentenciaSQL=conexion.getSentenciaSQL();
            ResultSet cdr=sentenciaSQL.executeQuery(strComando);
            while (cdr.next()){
                out.println(cdr.getString("descripcion"));
            } }catch(SQLException e){
            out.println(e);    }            
                %>
            </textarea><br/><br/><br/><label>Precio</label>&nbsp;&nbsp;&nbsp;$<input type="text" name="precio" value="<% 
                try{
                            String strComando="Select precio from menu_dia where id_menu=(SELECT MAX(id_menu) from menu_dia)";
            sentenciaSQL=conexion.getSentenciaSQL();
            ResultSet cdr=sentenciaSQL.executeQuery(strComando);
            while (cdr.next()){
                out.println(cdr.getString("precio"));
            } }catch(SQLException e){
                out.println(e);    } %> " readonly=""><br/><br/><br/>
            <img src=" <%
                 try{
                 String strComando="Select imagen from menu_dia where id_menu=(SELECT MAX(id_menu) from menu_dia)";
            sentenciaSQL=conexion.getSentenciaSQL();
            ResultSet cdr=sentenciaSQL.executeQuery(strComando);
                 while (cdr.next()){
                out.println(cdr.getString("imagen"));
            } }catch(SQLException e){
                out.println(e);    }
                 %> " width="20%">
            <input type="submit" value="Actualizar" class="btn__submit"></form>
            <label><a href="PrincipalG.jsp">Regresar</a></label>
    </body>
</html>
