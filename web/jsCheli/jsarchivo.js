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

function subirarchivo(){
    var r = document.getElementById("archivotxt").value;
    var ruta= r.substring(12);
     alert(ruta);
    objeto();
    xhr.open("GET", "SubirArchivo?ruta="+ruta, true);
        xhr.onreadystatechange=RespuestaSubir;  
xhr.send(null);
}

function RespuestaSubir(){
    if(xhr.readyState==4){
        document.getElementById("respuestaArchivo").innerHTML="<br/>"+xhr.responseText;
        }
}