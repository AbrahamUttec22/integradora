<%-- 
    Document   : EliminarPlatillos
    Created on : 5/06/2018, 06:07:44 PM
    Author     : jonat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style> h1{
        text-align: center;    
        }
        th{
            background: gray;
            color:white;
        }
        div{
            position:absolute;
            left: 5px;
            top: 25px;
        }
        
        </style>
        <title>Modificar aviones</title>
    </head>
    <body>
        
        <form action="http://localhost:8080/SWPR/SerEliPlatillo" method="get" >
        <h1 > Eliminacion de platillos</h1> <br/>
          
        <label>Eliminacion del platillos</label><br>
        <%
         int idp;
         
         idp=Integer.parseInt(request.getParameter("nov"));
        
        
        %>
        
        
        
        
        <input type="hidden" readonly="readonly" type="text" name="idplatillo" value=<%=idp%>><br>
        
        <label>¿Seguro deseas eliminar el platillo?</label><br><br>
        
        <input type="radio" name="radios" value="si" required="required" ><label>Si</label><br><br>
        <input type="radio" name="radios" value="no" required="required"><label>No</label><br><br>
        
         
            <input type="submit" value="Aceptar" name="enviar" >
        &nbsp;&nbsp;&nbsp;    
        
                     <br><br>
                     
        </form> 
              
              
    </body>
</html>
