var xhr;
function crear(){
    if(window.ActiveXObject){
        xhr = new ActiveXObject("Microsoft.XMLHttp");      
    }else if((window.XMLHttpRequest) || (typeof XMLHttpRequest)!=undefined){
        xhr = new XMLHttpRequest();
    }else{
        alert("Su navegador no soporta AJAX");
        return;
    }
}

function ElegirTarjeta(){
    document.getElementById("detalletarjetas").innerHTML="<form name=tarjeta>\n\
<br/><input type=radio name=tipo_tarjeta value=1 onclick=FormularioTarjeta();>&nbsp; Crédito\n\
<br/><input type=radio name=tipo_tarjeta value=2 onclick=FormularioTarjeta();>&nbsp; Debito\n\
<br/><input type=radio name=tipo_tarjeta value=3 onclick=FormularioTarjeta();>&nbsp; Prepago\n\
</form>";
}

function FormularioTarjeta(){
    crear();
    var opc= document.tarjeta.tipo_tarjeta.value;
    xhr.open("GET", "ActivarTarjeta?tipo="+opc, true);
        xhr.onreadystatechange=RespuestaActivar;  
xhr.send(null);
}

function RespuestaActivar(){
    if(xhr.readyState==4){
        document.getElementById("activartarjeta").innerHTML=xhr.responseText;
        }
}

function BuscarTarjeta(){
   crear();
   var tarjeta=document.getElementById("numero_tarjeta").value;
   xhr.open("POST", "ActivarTarjeta?tarjeta="+tarjeta, true);
        xhr.onreadystatechange=RespuestaBuscar;  
xhr.send(null);
}

function RespuestaBuscar(){
    if(xhr.readyState==4){
        document.getElementById("respuesta").innerHTML=xhr.responseText;
        }
}

function Actualizarsaldo(){
   crear();
   var tarjeta=document.getElementById("numero_tarjeta").value;
   var codigo=document.getElementById("codigo").value;
   var usuario = document.getElementById("idCliente").value;
   xhr.open("GET", "ActualizarTarjeta?tarjeta="+tarjeta+"&codigo="+codigo+"&usuario="+usuario, true);
        xhr.onreadystatechange=RespuestaActualizarSaldo;  
xhr.send(null);
}

function RespuestaActualizarSaldo(){
    if(xhr.readyState==4){
        alert(xhr.responseText);
        document.getElementById("respuesta").innerHTML="";
//        document.getElementById("numero_tarjeta").value="";
        }
}