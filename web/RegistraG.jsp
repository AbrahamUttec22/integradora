<%-- 
    Document   : RegistraG
    Created on : 31/05/2018, 07:22:30 AM
    Author     : granq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Entretiempo</title>
        <link rel="stylesheet" href="css/abra.css"> 
 
    </head>
    <body>

	<div class="container">
		<div class="form__top">
			<h2>Formulario <span>Registro</span></h2>
		</div>		
            <form class="form__reg" action="http://localhost:8080/SWPR/RegistrarE" method="post">
                    <input class="input" type="text" placeholder="&#128100;  Nombre" required autofocus name="nombre">
            
                    <input class="input" type="text" placeholder="&#128100;  Apellido Paterno" required name="apellido_p">
                    <input class="input" type="text" placeholder="&#128100;  Apellido Materno" required name="apellido_m">
                    <input class="input" type="text" placeholder="&#128100;  Telefono" required name="telefono">
                    <input class="input" type="text" placeholder="&#128100;  Usuario" required name="usuario">
                    <input class="input" type="password" placeholder="&#9993;  Contraseña" required name="contrasena">
<div class="btn__form">
<input class="btn__submit" type="submit" value="REGISTRAR">
<input class="btn__reset" type="reset" value="LIMPIAR">	
</div>
		</form>
	</div>
    </body>
</html>
