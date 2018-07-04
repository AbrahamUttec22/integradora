<%-- 
    Document   : RegistrarCliente
    Created on : 5/06/2018, 01:36:25 PM
    Author     : Oswaldo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- <link href="ccs/paratodo.css" rel="stylesheet"> -->
        <link rel="stylesheet" href="css/abra.css">
        <script type="text/javascript" src="jsOswaldo.js"></script>
        <title>JSP Page</title>
    </head>
        <body>  
	<div class="container">
		<div class="form__top">
            <h2>Formulario <span>Registro</span></h2>
		</div>		
                <form class="form__reg" name="RegistroCliente">
                    <label style="color: black">Foto</label><input class="input" type="file" placeholder="&#128100;Imagen" required id="imagen">
                    <label style="color: black">Nombre</label>
                    <input class="input" type="text"  required autofocus id="nombre">            
                    <label style="color: black">Apellido Paterno</label>
                    <input class="input" type="text"  required autofocus id="App">            
                    <label style="color: black">Apellido Materno</label>
                    <input class="input" type="text"  required autofocus id="Apm">            
                    <label style="color: black">Munucipio</label>
                    <input class="input" type="text"  required autofocus id="Municipio">            
                    <label style="color: black">Codigo Postal</label>
                    <input class="input" type="text"  required autofocus id="CP">            
                    <label style="color: black">Colonia</label>
                    <input class="input" type="text"  required autofocus id="Colonia">            
                    <label style="color: black">Calle</label>
                    <input class="input" type="text"  required autofocus id="Calle">            
                    <label style="color: black">No Exterior</label>
                    <input class="input" type="text"  required autofocus id="NoExterior">            
                    <label style="color: black">Telefono</label>
                    <input class="input" type="text"  required autofocus id="telefono">            
                    <label style="color: black">Correo</label>
                    <input class="input" type="text"  required autofocus id="correo">
                    <label style="color: black">Usuario</label>
                    <input class="input" type="text"  required autofocus id="usr">
                    <label style="color: black">Contraseña</label>
                    <input class="input" type="text"  required autofocus id="cont"><br><br>
                    <label style="color: black">Tipo de tarjeta</label>
                    <input class="input" type="radio"  required autofocus id="rb" name="tarj" value="credito" onclick="Credito();"><label style="color: black">Tarjeta Credito</label>           
                    <input class="input" type="radio"  required autofocus id="rb" name="tarj" value="debito" onclick="Credito();"><label style="color: black">Tarjeta Debito</label>            
                    <input class="input" type="radio"  required autofocus id="rb" name="tarj" value="prepago" onclick="Nada();"><label style="color: black">Tarjeta Prepago</label>            
                    <br>
                    <div id="Ntarjeta"></div>
                    <div class="btn__form">
                        <input class="btn__submit" type="button" onclick="enviarCorreo();" value="REGISTRAR"> 	
                    </div>
		</form>
            <br>
            <div id="validar"></div>
	</div>
    </body>
</html>
