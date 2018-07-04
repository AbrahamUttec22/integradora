var objeto;
var objeto2;
var objeto3;
var objeto4;
var objeto5;
function instanciar(){
    if (window.ActiveXObject){
        objeto= new ActiveXObject("Microsoft.XMLHttp");
        objeto2= new ActiveXObject("Microsoft.XMLHttp");
        objeto3= new ActiveXObject("Microsoft.XMLHttp");
        objeto4= new ActiveXObject("Microsoft.XMLHttp");
        objeto5= new ActiveXObject("Microsoft.XMLHttp");
         
        
    }else if ((window.XMLHttpRequest) || (typeof  XMLHttpRequest)!=undefined) {
        objeto=new XMLHttpRequest();
        objeto2=new XMLHttpRequest();
        objeto3=new XMLHttpRequest
        objeto4=new XMLHttpRequest();
        objeto5=new XMLHttpRequest();
    }else{
        alert("Su navegador no soporta AJAX");
        return;
    }
}


function mostrarE(){//aqui enviamos todo el formulario anterior
    instanciar();
//
//document.getElementById("encuestaabraham").load('InterfazEncuesta.jsp'); 
$('#encuestaabraham').load('InterfazEncuesta.jsp');

}


function mostrarT(){//aqui enviamos todo el formulario anterior
document.getElementById("encuestaabraham").innerHTML="";
       
}

