<%-- 
    Document   : MenudelDia
    Created on : 6/06/2018, 10:32:56 AM
    Author     : Araceli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/abra.css" rel="stylesheet">
        <title>Paquetes</title>
        </head>
    <body>
        <h1>Menú del día</h1>
        <form method="post" action="SubirMenuDelDia" class="form__top">
            <label>Descripción del Menú</label>
            <br/>
            <textarea name="descripcion" rows="10" cols="40" required=""></textarea>
            <br/><br/><br/>
            <label>Precio</label>&nbsp;&nbsp;&nbsp;$<input type="text" name="precio" required=""><br/><br/><br/>
            <label>Imagen</label>&nbsp;&nbsp;&nbsp;<input type="file" name="imagen" required=""><br/><br/><br/>
            <input type="submit" value="Guardar" class="btn__submit">
        </form><br/><br/>
        <label><a href="ConsultarMenu.jsp">Consultar Menú</a></label><br/><br/>
        <label><a href="PrincipalG.jsp">Regresar</a></label>        
    </body>
</html>
