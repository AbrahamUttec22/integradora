<%-- 
    Document   : Encuesta
    Created on : 2/06/2018, 04:26:32 AM
    Author     : granq

--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="jsAbraham/encu.js"></script>
        <title>JSP Page</title>
  
    </head>
    <body>
        <br><br><br><br><br>
         <center>    
        <div id="pintar">
   
<h1>Por favor evalua los siguientes aspectos del evento</h1>
<h5>Seleccione una respuesta en cada fila </h5>

        <br><br><br><br><br>
        
        <form enctype='multipart/form-data' id="ev" >
            
         <table >
       <tr >

<th >   </th>
<th >Regular</th> 
<th width="8%">Bueno</th> 
<th >Excelente</th> 

       </tr>
<tr>
    <td><label>¿Cómo calificaría la cortesía y trato 
            de los empleados de “Entretiempo”?</label></td>
    <td> <input type="radio" value="R" name="a"></td>
    <td>   <input type="radio" value="B" name="a"></td>
    <td>
    <input type="radio" value="E" name="a"></td>
    

</tr>

<tr>
    <td>     <label>La rapidez con la que le fue otorgado el servicio</label></td>
    <td> <input type="radio" value="R" name="b"></td>
    <td>  <input type="radio" value="B" name="b"></td>
    <td>
     <input type="radio" value="E" name="b"></td>
</tr>

<tr>
    <td>     <label>La calidad del servicio recibido ha sido</label></td>
    <td> <input type="radio" value="R" name="c"></td>
    <td>   <input type="radio" value="B" name="c"></td>
    <td> <input type="radio" value="E" name="c"></td>
         
</tr>

<tr>
    <td>     <label>¿Con qué nivel de eficacia le atendimos?</label></td>
    <td>     <input type="radio" value="R" name="d"></td>
    <td>  <input type="radio" value="B" name="d"></td>
    <td>
    <input type="radio" value="E" name="d"></td>
</tr>

<tr>
    <td>     <label>La relación precio / calidad del servicio es</label></td>
    <td> <input type="radio" value="R" name="e"></td>
    <td>   <input type="radio" value="B" name="e"></td>
    <td><input type="radio" value="E" name="e"></td>  
</tr>

</center>
    </table>
            <br><br><br><br>
            <input type="button" name="enviar" value="Evaluar" onclick="calculoA();"><br><br><br><br><br><br>
         </form>
        
         </div>
              </center> 
    </body>
</html>
