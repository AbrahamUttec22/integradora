var xhr,xhr1,xhr2,xhr3,xhr4,xhr5,xhr6,xhr7,xhr8,xhr9,xhr10,xhr11,xhr12;
function crearOs(){
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
function MensajePrueba()
{
    alert("Si entra");
}
function Credito()
{
    document.getElementById("Ntarjeta").innerHTML="<label style='color: black'>No Tarjeta</label><br>\n\
    <input class='input' type='text' name='NoTarjeta' value='' required autofocus >";
}
function Nada()
{
    document.getElementById("Ntarjeta").innerHTML="<input class='input' type='hidden' name='NoTarjeta' value='0' required autofocus >";
}
function RegistrarCliente()
{
    crearOs();
    var FormDatos =new FormData(document.getElementById("RegistroCliente"));
    //alert(FormDatos);
    xhr.open("POST", "ServRegistrarCliente", true);
    xhr.onreadystatechange=RespuestaRegistrarCliente;
    alert("Envia al servlet");
    //xhr6.setRequestHeader('Content-type','application/x-www-form-urlencoded');
    xhr.send(FormDatos);    
}
function RespuestaRegistrarCliente()
{
    if (xhr.readyState==4){
       //xhr.responseText
       //alert("entrar al if");
       //alert("Lo que regresa el servlet: "+xhr.responseText);
       document.getElementById("respuesta").innerHTML="<br>Valida tu cuenta: <input type='text' id='c'><br><br>\n\
        <input type='button' value='confirmar' onclick='valiadarCodigo();'>\n\
        <div id='r'></div>";
    }
    //alert("Termina el if");
}
function valiadarCodigo()
{
    crearOs();
    var codigo= document.getElementById("c").value;
    xhr1.open("GET", "ServRegistrarCliente?uno="+codigo, true);
    xhr1.onreadystatechange=respuestaRegistro;
    xhr1.send(null);
}
function respuestaRegistro()
{
    if(xhr1.readyState == 4){ 
        document.getElementById("r").innerHTML=xhr1.responseText;     
     }
}
function formularioActualziarDatos()
{
    crearOs();
    var id= document.getElementById("idCliente").value;
    xhr2.open("POST", "ServBuscarClinte", true);
    xhr2.onreadystatechange=RespuestaformularioActualziarDatos;
    xhr2.setRequestHeader('Content-type','application/x-www-form-urlencoded');
    xhr2.send("uno="+id);    
}
function RespuestaformularioActualziarDatos()
{
    if(xhr2.readyState == 4){ 
        document.getElementById("encuestaabraham").innerHTML=xhr2.responseText;     
     }
}
function RecuperarDatosCliente()
{
    alert("entra");
    crearOs();
    var id=document.getElementById("idCliente").value;
    var correo=document.getElementById("correo").value;
    var telefono=document.getElementById("telefono").value;
    var municipio=document.getElementById("muni").value;
    var cp=document.getElementById("cp").value;
    var colonia=document.getElementById("colo").value;
    var calle=document.getElementById("calle").value;
    var NoExterior=document.getElementById("num").value;
    xhr3.open("POST", "ServActualizarCliente", true);
    xhr3.onreadystatechange=RespuestaActualizarCliente;
    xhr3.setRequestHeader('Content-type','application/x-www-form-urlencoded');
    xhr3.send("uno="+id+"&dos="+correo+"&tres="+telefono+"&cuatro="+municipio+"&cinco="+cp+"&seis="+colonia+"&siete="+calle+"&ocho="+NoExterior);
}
function RespuestaActualizarCliente()
{
    if(xhr3.readyState == 4){ 
        document.getElementById("encuestaabraham").innerHTML=xhr3.responseText;     
     }
}