<%-- 
    Document   : index
    Created on : 31/05/2018, 06:43:51 AM
    Author     : granq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/login.css">
   
        <script> 
      
           alert("${resp}"); 
      
    
        </script>
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
            <table >
                <tr>
                    <td><a onclick="document.getElementById('modal-wrapper').style.display='block'"><i class="fa fa-lock"></i>Login</a></td>

                </tr>
            </table>
        </nav>
                
    </center>
<div id="modal-wrapper" class="modal">
    <form action="inicial" class="modal-content animate"> 
    <div class="imgcontainer">
      <span onclick="document.getElementById('modal-wrapper').style.display='none'" class="close" title="Close">&times;</span>
      <img src="imgUsuario/login.png" alt="Avatar" class="avatar">
    </div>
    <div class="container">
        <input type="text" placeholder="Usuario" name="uname" style="width: 450px;"><br>
        <input type="password" placeholder="Contraseña" name="psw" style="width: 450px;"><br>       
        <button type="submit" style="width: 450px;">Login</button><br>
      <a href="RegistrarCliente.jsp">Registrarme.</a>
    </div>   
  </form>
</div>
    </body>
</html>
