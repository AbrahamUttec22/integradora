var objeto;
function crearObjeto(){
    if (window.ActiveXObject){
        objeto= new ActiveXObject("Microsoft.XMLHttp");
       
        
    }else if ((window.XMLHttpRequest) || (typeof  XMLHttpRequest)!=undefined) {
        objeto=new XMLHttpRequest();
      
    }else{
        alert("Su navegador no soporta AJAX");
        return;
    }
}

function iniciar(){
    crearObjeto();
    mandarVariables();
    
}

function mandarVariables(){
    try {
    var fe=document.getElementById("fecha");
    var fecha=fe.value;
    var h=document.getElementById("hora");
    var hora=h.value;
    var co=document.getElementById("comensal");
    var comensal=co.value;
 objeto.open("GET","ConsultaMesa?fecha="+fecha+"&hora="+hora+"&comensal="+comensal,true);
    objeto.onreadystatechange=imprimirConsulta;
    objeto.send(null);  
    } catch (e) {
        print("el error"+e);
    }

   
}

function  imprimirConsulta(){
    if (objeto.readyState==4){
        document.getElementById("mesa").innerHTML=""+objeto.responseText+"";
    }
   
}





