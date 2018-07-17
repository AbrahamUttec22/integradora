var xhr, xhr1;
function crear(){
    if(window.ActiveXObject){
        xhr = new ActiveXObject("Microsoft.XMLHttp");
        xhr1 = new ActiveXObject("Microsoft.XMLHttp");
       }else if((window.XMLHttpRequest) || (typeof XMLHttpRequest)!=undefined){
        xhr = new XMLHttpRequest();
        xhr1 = new XMLHttpRequest();
    }else{
        alert("Su navegador no soporta AJAX");
        return;
    }
}

function SubirMenu(){
    crear();
    var desc = document.getElementById("descripcion").value;
    var pre = document.getElementById("precio").value;
    var ima = document.getElementById("imagen").value;
    var i= ima.substring(12);
    xhr.open("POST", "SubirMenuDelDia", true);
        xhr.onreadystatechange=RespuestaSubirMenu;  
        xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
xhr.send("descripcion="+desc+"&precio="+pre+"&imagen="+i);
}

function RespuestaSubirMenu(){
    if(xhr.readyState==4){ 
        alert(xhr.responseText);
    }
}

function ConsultarMenu(){
     crear();
     xhr1.open("GET", "SubirMenuDelDia", true);
        xhr1.onreadystatechange=RespuestaConsultarMenu;  
xhr1.send(null);
}

function RespuestaConsultarMenu(){
    if(xhr1.readyState==4){ 
        document.getElementById("consultar").style.display='none';
document.getElementById("detallemenu").innerHTML=xhr1.responseText;
    }
}