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
        <link href="ccs/paratodo.css" rel="stylesheet">
        <link rel="stylesheet" href="css/abra.css"> s
        <title>JSP Page</title>
    </head>
        <body>  
	<div class="container">
		<div class="form__top">
            <h2>Formulario <span>Registro</span></h2>
		</div>		
                <form class="form__reg" action="ServRegistrarCliente" method="get">
                    <label>Foto</label><input class="input" type="file" placeholder="&#128100;  Imagen" required name="imagen">
                    <label>Nombre</label>
                    <input class="input" type="text"  required autofocus name="nombre">            
                    <label>Apellido Paterno</label>
                    <input class="input" type="text"  required autofocus name="App">            
                    <label>Apellido Materno</label>
                    <input class="input" type="text"  required autofocus name="Apm">            
                    <label>Munucipio</label>
                    <input class="input" type="text"  required autofocus name="Municipio">            
                    <label>Codigo Postal</label>
                    <input class="input" type="text"  required autofocus name="CP">            
                    <label>Colonia</label>
                    <input class="input" type="text"  required autofocus name="Colonia">            
                    <label>Calle</label>
                    <input class="input" type="text"  required autofocus name="Calle">            
                    <label>No Exterior</label>
                    <input class="input" type="text"  required autofocus name="NoExterior">            
                    <label>Telefono</label>
                    <input class="input" type="text"  required autofocus name="telefono">            
                    <label>Correo</label>
                    <input class="input" type="text"  required autofocus name="correo">
                    <label>Usuario</label>
                    <input class="input" type="text"  required autofocus name="usr">
                    <label>Contraseña</label>
                    <input class="input" type="text"  required autofocus name="cont"><br><br>
                    <input class="input" type="radio"  required autofocus name="tarj" value="credito"><label>Tarjeta Credito</label>           
                    <input class="input" type="radio"  required autofocus name="tarj" value="debito"><label>Tarjeta Debito</label>            
                    <input class="input" type="radio"  required autofocus name="tarj" value="prepago"><label>Tarjeta Prepago</label>            
                    <br><label>No Tarjeta</label>
                    <input class="input" type="text"  required autofocus name="NoTarjeta">            
                <div class="btn__form">
                    <input class="btn__submit" type="submit" value="REGISTRAR"> 
                    <input class="btn__reset" type="reset" value="LIMPIAR">	
                </div>
		</form>
	</div>
    </body>
</html>
