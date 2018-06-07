<%-- 
    Document   : GestionarPaquetes
    Created on : 5/06/2018, 09:59:24 AM
    Author     : Araceli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Estilos/style.css" rel="stylesheet">
        <title>Gestionar Paquetes</title>
    </head>
    <body>
        <h1>Registrar paquetes</h1>
        <br/><br/><br/>
        <form method="POST" action="http://localhost:8080/swpr/InsertarPaquete">
            <label>ID Paquete</label>&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="idPaquete" required="">
            <br/><br/><br/>
            <label>Nombre</label>&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="nombrePaquete" required="">
              <br/><br/><br/>
              <label>Precio</label>&nbsp;&nbsp;&nbsp;&nbsp;<label>$</label><input type="text" name="precioPaquete" required="">
              <br/><br/><br/>
              <label>Descripción</label>&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="descripcionPaquete" required="">
       <br/><br/><br/>
       <label>Imagen</label>&nbsp;&nbsp;&nbsp;&nbsp;<input type="file" name="imagenPaquete" value="Seleccionar imagen" required="">
               <br/><br/><br/>
              <input type="submit" Value="Guardar" class="submits">
              <br/><br/><br/>
       <label><a href="Menu.jsp">Regresar</a></label>
        </form>
    </body>
</html>
