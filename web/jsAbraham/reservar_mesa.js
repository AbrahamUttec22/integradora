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
    if (comensal>=1 && comensal<=2){
    objeto.open("GET","mesaschicas?fecha="+fecha+"&hora="+hora,true);
    objeto.onreadystatechange=imprimirConsulta;
    objeto.send(null);  
    }

  if (comensal>=3 && comensal<=4){
    objeto.open("GET","mesasmedianas?fecha="+fecha+"&hora="+hora,true);
    objeto.onreadystatechange=imprimirConsulta;
    objeto.send(null);  
    }

  if (comensal>=5){
    objeto.open("GET","mesasgrandes?fecha="+fecha+"&hora="+hora,true);
    objeto.onreadystatechange=imprimirConsulta;
    objeto.send(null);  
    }

    
    } catch (e) {
        print("el error"+e);
    }

   
}

function  imprimirConsulta(){
    if (objeto.readyState==4){
        document.getElementById("mesa").innerHTML=""+objeto.responseText+"";
    }
   
}


function  cotizar0(){
     var fe=document.getElementById("fecha");
    var fecha=fe.value;
    var h=document.getElementById("hora");
    var hora=h.value;
   var mesas=document.getElementById("mesas0");
   var mesa=mesas.value;
        document.getElementById("cotizacion").innerHTML="Reservar Mesa "+mesa+" a las "+hora+" el dia "+fecha;
}
function  cotizar1(){
     var fe=document.getElementById("fecha");
    var fecha=fe.value;
    var h=document.getElementById("hora");
    var hora=h.value;
   var mesas=document.getElementById("mesas1");
   var mesa=mesas.value;
        document.getElementById("cotizacion").innerHTML="Reservar Mesa "+mesa+" a las "+hora+" el dia "+fecha;
}
function  cotizar2(){
     var fe=document.getElementById("fecha");
    var fecha=fe.value;
    var h=document.getElementById("hora");
    var hora=h.value;
   var mesas=document.getElementById("mesas2");
   var mesa=mesas.value;
        document.getElementById("cotizacion").innerHTML="Reservar Mesa "+mesa+" a las "+hora+" el dia "+fecha;
}
function  cotizar3(){
     var fe=document.getElementById("fecha");
    var fecha=fe.value;
    var h=document.getElementById("hora");
    var hora=h.value;
   var mesas=document.getElementById("mesas3");
   var mesa=mesas.value;
        document.getElementById("cotizacion").innerHTML="Reservar Mesa "+mesa+" a las "+hora+" el dia "+fecha;
}
function  cotizar4(){
     var fe=document.getElementById("fecha");
    var fecha=fe.value;
    var h=document.getElementById("hora");
    var hora=h.value;
   var mesas=document.getElementById("mesas4");
   var mesa=mesas.value;
        document.getElementById("cotizacion").innerHTML="Reservar Mesa "+mesa+" a las "+hora+" el dia "+fecha;
}
function  cotizar5(){
     var fe=document.getElementById("fecha");
    var fecha=fe.value;
    var h=document.getElementById("hora");
    var hora=h.value;
   var mesas=document.getElementById("mesas5");
   var mesa=mesas.value;
        document.getElementById("cotizacion").innerHTML="Reservar Mesa "+mesa+" a las "+hora+" el dia "+fecha;
}
function  cotizar6(){
     var fe=document.getElementById("fecha");
    var fecha=fe.value;
    var h=document.getElementById("hora");
    var hora=h.value;
   var mesas=document.getElementById("mesas6");
   var mesa=mesas.value;
        document.getElementById("cotizacion").innerHTML="Reservar Mesa "+mesa+" a las "+hora+" el dia "+fecha;
}
function  cotizar7(){
     var fe=document.getElementById("fecha");
    var fecha=fe.value;
    var h=document.getElementById("hora");
    var hora=h.value;
   var mesas=document.getElementById("mesas7");
   var mesa=mesas.value;
        document.getElementById("cotizacion").innerHTML="Reservar Mesa "+mesa+" a las "+hora+" el dia "+fecha;
}
function  cotizar8(){
     var fe=document.getElementById("fecha");
    var fecha=fe.value;
    var h=document.getElementById("hora");
    var hora=h.value;
   var mesas=document.getElementById("mesas8");
   var mesa=mesas.value;
        document.getElementById("cotizacion").innerHTML="Reservar Mesa "+mesa+" a las "+hora+" el dia "+fecha;
}
function  cotizar9(){
     var fe=document.getElementById("fecha");
    var fecha=fe.value;
    var h=document.getElementById("hora");
    var hora=h.value;
   var mesas=document.getElementById("mesas9");
   var mesa=mesas.value;
        document.getElementById("cotizacion").innerHTML="Reservar Mesa "+mesa+" a las "+hora+" el dia "+fecha;
}

