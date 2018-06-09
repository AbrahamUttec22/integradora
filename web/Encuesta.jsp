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
        <title>JSP Page</title>
         <link rel="stylesheet" href="css/abra.css"> 
         <style type="text/css" >
             
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
                
        <form method="post" action="Encuesta">
         <table class="tabla">
       <tr>

<th>   Preguntas </th>
<th>Regular</th> 
<th>Bueno</th> 
<th>Excelente</th> 

       </tr>
<tr class="modo1">
    <td>     <label>Pregunta 1</label></td>
    <td> <input type="radio" value="R" name="1"></td>
    <td>   <input type="radio" value="B" name="1"></td>
    <td>
    <input type="radio" value="E" name="1"></td>
    

</tr>

<tr class="modo1">
    <td>     <label>Pregunta 2</label></td>
    <td> <input type="radio" value="R" name="2"></td>
    <td>  <input type="radio" value="B" name="2"></td>
    <td>
     <input type="radio" value="E" name="2"></td>
</tr>

<tr class="modo1">
    <td>     <label>Pregunta 3</label></td>
    <td> <input type="radio" value="R" name="3"></td>
    <td>   <input type="radio" value="B" name="3"></td>
    <td> <input type="radio" value="E" name="3"></td>
    
    
          
           
</tr>

<tr class="modo1">
    <td>     <label>Pregunta 4</label></td>
    <td>     <input type="radio" value="R" name="4"></td>
    <td>  <input type="radio" value="B" name="4"></td>
    <td>
    <input type="radio" value="E" name="4"></td>
  
            
           

</tr>

<tr class="modo1">
    <td>     <label>Pregunta 5</label></td>
    <td> <input type="radio" value="R" name="5"></td>
    <td>   <input type="radio" value="B" name="5"></td>
    <td>
         
            <input type="radio" value="E" name="5"></td>
    
     
       
</tr>

</center>
    </table>
           <input type="submit" name="enviar"><br><br><br><br><br><br>
            <input type="text" value="${mensaje}">
         </form>
    </body>
</html>
