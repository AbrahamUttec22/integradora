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


function calculoA(){//aqui enviamos todo el formulario anterior
    instanciar();
  var fdata=new FormData(document.getElementById("ev"));
 objeto4.open("POST","Encuesta",true);
 objeto4.onreadystatechange=mos;
 objeto4.send(fdata); 

}

function mos(){
   if (objeto4.readyState==4){
       document.getElementById("pintar").innerHTML="<h1><center>"+objeto4.responseText+"</center><h1>";
    }
}


