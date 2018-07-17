<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- <link href="ccs/paratodo.css" rel="stylesheet"> -->
        <link rel="stylesheet" href="css/abra.css">
        <script type="text/javascript" src="jsOswaldoRegistro.js"></script>        
        
        <title>JSP Page</title>
</head>
    <body>                          
        <div class="form__top" id="respuesta">
            <label style="color: black">Registro Cliente</label><br>
                <form  enctype='multipart/form-data'  id="RegistroCliente">
                    <label style="color: black">Foto</label><input class="input" type="file" placeholder="&#128100;Imagen" required name="imagen"><br><br>
                    <label style="color: black">Nombre</label>
                    <input class="input" type="text"  required autofocus name="nombre"><br><br>
                    <label style="color: black">Apellido Paterno</label>
                    <input class="input" type="text"  required autofocus name="App"><br><br> 
                    <label style="color: black">Apellido Materno</label>
                    <input class="input" type="text"  required autofocus name="Apm"><br><br>    
                    <label style="color: black">Munucipio</label>
                    <input class="input" type="text"  required autofocus name="Municipio"><br><br>          
                    <label style="color: black">Codigo Postal</label>
                    <input class="input" type="text"  required autofocus name="CP"><br><br>
                    <label style="color: black">Colonia</label>
                    <input class="input" type="text"  required autofocus name="Colonia"><br><br>         
                    <label style="color: black">Calle</label>
                    <input class="input" type="text"  required autofocus name="Calle"><br><br>  
                    <label style="color: black">No Exterior</label>
                    <input class="input" type="text"  required autofocus name="NoExterior"><br><br>         
                    <label style="color: black">Telefono</label>
                    <input class="input" type="text"  required autofocus name="telefono"><br><br>  
                    <label style="color: black">Correo</label>
                    <input class="input" type="text"  required autofocus name="correo"><br><br>
                    <label style="color: black">Usuario</label>
                    <input class="input" type="text"  required autofocus name="usr"><br><br>
                    <label style="color: black">Contraseña</label>
                    <input class="input" type="text"  required autofocus name="cont"><br><br>
                    <label style="color: black">Tipo de tarjeta</label><br>
                    <input class="input" type="radio"  required autofocus id="rb" name="tarj" value="credito" onclick="Credito();"><label style="color: black">Tarjeta Credito</label><br>
                    <input class="input" type="radio"  required autofocus id="rb" name="tarj" value="debito" onclick="Credito();"><label style="color: black">Tarjeta Debito</label><br>
                    <input class="input" type="radio"  required autofocus id="rb" name="tarj" value="prepago" onclick="Nada();"><label style="color: black">Tarjeta Prepago</label><br>
                    <br><div id="Ntarjeta"></div>
                    <div class="btn__form">
                    <input class="btn__submit" type="button" onclick="RegistrarCliente();" value="REGISTRAR">
                    </div>                
		</form>
            </div>
        <!--<div id="respuesta"></div>-->
    </body>
</html>