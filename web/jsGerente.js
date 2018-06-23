    divInicial="inicio";
var xhr;
function crearObjeto(){
    if(window.ActiveXObject){
        xhr = new ActiveXObject("Microsoft.XMLHttp");
    }else if((window.XMLHttpRequest) || (typeof XMLHttpRequest)!=undefined){
        xhr = new XMLHttpRequest();
    }else{
        alert("Su navegador no soporta AJAX");
        return;
    }
}

function DinamicoDiv(divActual){
    document.getElementById(divActual).style.display='block';
    //document.getElementById(a).style.visibility='hidden';
    if (divInicial != divActual){
        document.getElementById(divInicial).style.display='none';
    }
    divInicial = divActual;  
}