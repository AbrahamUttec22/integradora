var xhr;
function objeto(){
    if(window.ActiveXObject){
        xhr = new ActiveXObject("Microsoft.XMLHttp");      
    }else if((window.XMLHttpRequest) || (typeof XMLHttpRequest)!=undefined){
        xhr = new XMLHttpRequest();
    }else{
        alert("Su navegador no soporta AJAX");
        return;
    }
}

function Enviarquejas(){
    document.getElementById("detalletarjetas").innerHTML="<form name=quejas align=center>\n\
Escriba su comentario:<br/><textarea id=comentario rows=10 cols=60></textarea>\n\
<br/><br/><input type=button value=Enviar onclick=EnviarComentario();></form>";
}

function EnviarComentario(){
    var comentario=document.getElementById("comentario").value;
    var usuario=document.getElementById("idCliente").value;
    objeto();
    xhr.open("GET", "EnviarComentario?comentario="+comentario+"&usuario="+usuario, true);
        xhr.onreadystatechange=RespuestaEnviar;  
xhr.send(null);
}

function RespuestaEnviar(){
    if(xhr.readyState==4){
        alert(xhr.responseText);
        document.getElementById("comentario").value="";
        }
}

function Reportes(){
   objeto();
    xhr.open("POST", "EnviarComentario", true);
        xhr.onreadystatechange=RespuestaReportes;  
        xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
xhr.send(null);
}

function RespuestaReportes(){
    if(xhr.readyState==4){
        document.getElementById("detallesreportes").innerHTML=xhr.responseText;
        }    
}

function GenerarReporte(){
    var opc= document.reporte.opc.value;
 objeto();
    xhr.open("POST", "ReportesComentarios", true);
        xhr.onreadystatechange=RespuestaGenerarReportes;  
        xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
xhr.send("opc="+opc);
}

function RespuestaGenerarReportes(){
    if(xhr.readyState==4){
        alert(xhr.responseText);
        }  
}