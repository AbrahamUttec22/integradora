var objeto;
var objeto2;
var objeto3;
var objeto4;
var objeto5;
function instanciar(){
    if (window.ActiveXObject)
    {
        objeto= new ActiveXObject("Microsoft.XMLHttp");
  
         
        
    }else if ((window.XMLHttpRequest) || (typeof  XMLHttpRequest)!=undefined) {
        objeto=new XMLHttpRequest();
      
    }else{
        alert("Su navegador no soporta AJAX");
        return;
    }
}

function instanciar2(){
    if (window.ActiveXObject){
 
        objeto2= new ActiveXObject("Microsoft.XMLHttp");
        objeto3= new ActiveXObject("Microsoft.XMLHttp");
      
         
        
    }else if ((window.XMLHttpRequest) || (typeof  XMLHttpRequest)!=undefined) {
      
        objeto2=new XMLHttpRequest();
        objeto3=new XMLHttpRequest();
        
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
    instanciar2();
    objeto2.open("GET", "ConsultaTicketMesa", true);
    objeto2.onreadystatechange=misT;
    objeto2.send(null);

       
}

function misT(){
      if (objeto2.readyState==4){
       document.getElementById("encuestaabraham").innerHTML=""+objeto2.responseText;
    }
   
}
