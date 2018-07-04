var xhr,xhr1,xhr2,xhr3,xhr4,xhr5,xhr6,xhr7,xhr8,xhr9,xhr10,xhr11,xhr12;
function crearObjeto(){
    if(window.ActiveXObject){
        xhr = new ActiveXObject("Microsoft.XMLHttp");
        xhr1 = new ActiveXObject("Microsoft.XMLHttp");xhr2 = new ActiveXObject("Microsoft.XMLHttp");
        xhr3 = new ActiveXObject("Microsoft.XMLHttp");xhr4 = new ActiveXObject("Microsoft.XMLHttp");
        xhr5 = new ActiveXObject("Microsoft.XMLHttp");xhr6 = new ActiveXObject("Microsoft.XMLHttp");
        xhr7 = new ActiveXObject("Microsoft.XMLHttp");xhr8 = new ActiveXObject("Microsoft.XMLHttp");
        xhr9 = new ActiveXObject("Microsoft.XMLHttp");xhr10 = new ActiveXObject("Microsoft.XMLHttp");
        xhr11 = new ActiveXObject("Microsoft.XMLHttp");xhr12 = new ActiveXObject("Microsoft.XMLHttp");
    }else if((window.XMLHttpRequest) || (typeof XMLHttpRequest)!=undefined){
        xhr = new XMLHttpRequest();
        xhr1 = new XMLHttpRequest();xhr2 = new XMLHttpRequest();xhr3 = new XMLHttpRequest();
        xhr4 = new XMLHttpRequest();xhr5 = new XMLHttpRequest();xhr6 = new XMLHttpRequest();
        xhr7 = new XMLHttpRequest();xhr8 = new XMLHttpRequest();xhr9 = new XMLHttpRequest();
        xhr10 = new XMLHttpRequest();xhr11 = new XMLHttpRequest();xhr12 = new XMLHttpRequest();
    }else{
        alert("Su navegador no soporta AJAX");
        return;
    }
}
function login()
{
    crearObjeto();
    var usuario = document.getElementById("uname").value;
    var password = document.getElementById("psw").value;
    alert("usuario "+usuario+" password "+password);
    xhr.open("POST", "inicial", true);
    xhr.onreadystatechange=respuestaLogin;
    xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded');
    xhr.send("uno="+usuario+"&dos="+password);
}
function respuestaLogin()
{
    if(xhr.readyState == 4){ 
        alert("VA AL JSP "+xhr.responseTexts);
        location.href=xhr.responseText;        
     }
}
function formDeRegistroCliente()
{
    document.getElementById("").innerHTML="";
}
function Credito()
{
    document.getElementById("Ntarjeta").innerHTML="<label style='color: black'>No Tarjeta</label><br>\n\
    <input class='input' type='text' id='NoTarjeta'  required autofocus >";
}
function Nada()
{
    document.getElementById("Ntarjeta").innerHTML="";
}
var imagen,nombre,app,apm,municipio,cp,colonia,calle,noExterior,telefono,correo,usuario,contrasena,tipo_tarjeta,no_tarjeta;
function enviarCorreo()
{
    crearObjeto();
    alert("entra enviarCorreo");
    recuperarDatosCliente();
    var uno = document.getElementById("correo").value;
    var dos = document.getElementById("nombre").value;;
    xhr1.open("POST", "EnviarCorreoRegistro", true);
    xhr1.onreadystatechange=respuestaEnviarCorreo;
    xhr1.setRequestHeader('Content-type','application/x-www-form-urlencoded');
    xhr1.send("uno="+uno+"&dos="+dos);
}
function respuestaEnviarCorreo()
{
     if(xhr1.readyState == 4){ 
         document.getElementById("validar").innerHTML="<br>Valida tu cuenta: <input type='text' id='c'><br><br>\n\
         <input type='button' value='confirmar' onclick='valiadarCodigo();'>\n\
        <div id='respuesta'></div>";
     }
}
function valiadarCodigo()
{
    crearObjeto();
    var codigo= document.getElementById("c").value;
    xhr2.open("POST", "ServRegistrarCliente", true);
    xhr2.onreadystatechange=respuestaRegistro;
    xhr2.setRequestHeader('Content-type','application/x-www-form-urlencoded');
    xhr2.send("uno="+imagen+"&dos="+nombre+"&tres="+app+"&cuatro="+apm+"&cinco="+municipio+"&seis="+cp+"&siete="+colonia
            +"&ocho="+calle+"&nueve="+noExterior+"&dies="+telefono+"&once="+correo+"&doce="+suario+"&trece="+contrasena
            +"&catorce="+tipo_tarjeta+"&quince="+no_tarjeta+"&codigo="+codigo);
}
function respuestaRegistro()
{
    if(xhr2.readyState == 4){ 
        document.getElementById("respuesta").innerHTML=xhr2.responseText;     
     }
}
function recuperarDatosCliente()
{
    imagen = document.getElementById("imagen").value;
    nombre = document.getElementById("nombre").value;
    app = document.getElementById("App").value;
    apm = document.getElementById("Apm").value;
    municipio = document.getElementById("Municipio").value;
    cp = document.getElementById("CP").value;
    colonia = document.getElementById("Colonia").value;
    calle = document.getElementById("Calle").value;
    noExterior = document.getElementById("NoExterior").value;
    telefono = document.getElementById("telefono").value;
    correo = document.getElementById("correo").value;
    suario = document.getElementById("usr").value;
    contrasena = document.getElementById("cont").value;
    tipo_tarjeta= document.RegistroCliente.rb.value;
    alert(tipo_tarjeta);
    if(tipo_tarjeta=="credito" || tipo_tarjeta=="debito")
    {
     no_tarjeta = document.getElementById("NoTarjeta").value;
     alert(no_tarjeta);
    }
    else if(tipo_tarjeta=="prepago")
    {
     no_tarjeta=0;
     alert(no_tarjeta);
    }
}