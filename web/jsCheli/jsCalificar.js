var xhr, xhr1, xhr2;
function crearobjeto(){
    if(window.ActiveXObject){
        xhr = new ActiveXObject("Microsoft.XMLHttp");
        xhr1 = new ActiveXObject("Microsoft.XMLHttp");
        xhr2 = new ActiveXObject("Microsoft.XMLHttp");       
    }else if((window.XMLHttpRequest) || (typeof XMLHttpRequest)!=undefined){
        xhr = new XMLHttpRequest();
        xhr1 = new XMLHttpRequest();
        xhr2 = new XMLHttpRequest();
    }else{
        alert("Su navegador no soporta AJAX");
        return;
    }
}

function calificar(datos){
    crearobjeto();
    var max=datos.length;
    var min = max-2;
    var cali=datos.substring(min);
    var pla=datos.substring(0, min);
    var id=document.getElementById("idCliente").value;
     alert(pla+" "+id);
    xhr.open("GET", "CalificarPlatillo?cali="+cali+"&pla="+pla+"&id="+id, true);
        xhr.onreadystatechange=RespuestaCalificar;  
xhr.send(null);
}

function RespuestaCalificar(){
    if(xhr.readyState==4){
        alert(xhr.responseText);
        }
}

function ignorar(platillo){
    crearobjeto();
    var id=document.getElementById("idCliente").value;
    alert(platillo+" "+id);
     xhr.open("POST", "CalificarPlatillo", true);
     xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
        xhr.onreadystatechange=RespuestaIgnorar;  
xhr.send("pla="+platillo+"&id="+id);
}

function RespuestaIgnorar(){
    if(xhr.readyState==4){
        alert(xhr.responseText);
        }
}

function toppla(){
    crearobjeto();
     xhr.open("GET", "TopPlatillos", true);
        xhr.onreadystatechange=RespuestaTop;  
xhr.send(null);
}

function RespuestaTop(){
    if(xhr.readyState==4){
         document.getElementById("platillostop").innerHTML=xhr.responseText;
        }
}