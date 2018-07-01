var objeto;
var objeto2;
var objeto3;
var objeto4;
var objeto5;
var objeto6;
function crearObjeto(){
    if (window.ActiveXObject){
        objeto= new ActiveXObject("Microsoft.XMLHttp");
        objeto2= new ActiveXObject("Microsoft.XMLHttp");
         objeto3= new ActiveXObject("Microsoft.XMLHttp");
         objeto4= new ActiveXObject("Microsoft.XMLHttp");
         objeto5= new ActiveXObject("Microsoft.XMLHttp");
         objeto6= new ActiveXObject("Microsoft.XMLHttp");
        
    }else if ((window.XMLHttpRequest) || (typeof  XMLHttpRequest)!=undefined) {
        objeto=new XMLHttpRequest();
        objeto2=new XMLHttpRequest();
        objeto3=new XMLHttpRequest();
        objeto4=new XMLHttpRequest();
        objeto5=new XMLHttpRequest();
        objeto6=new XMLHttpRequest();
    }else{
        alert("Su navegador no soporta AJAX");
        return;
    }
}

function iniciarAbraham(){
    crearObjeto();
    mandarVariables();
    
}

function mandarVariables(){
  var tip=document.getElementById("tipoMesa");
  var tipo= String(tip.options[tip.selectedIndex].value);
    
    if (tipo=='chicas'){
    objeto.open("GET","chicas",true);
    objeto.onreadystatechange=imprimirConsulta;
    objeto.send(null);  
    }

  if (tipo=='medianas'){
    objeto.open("GET","medianas",true);
    objeto.onreadystatechange=imprimirConsulta;
    objeto.send(null);  
    }

  if (tipo=='grandes'){
    objeto.open("GET","grandes",true);
    objeto.onreadystatechange=imprimirConsulta;
    objeto.send(null);  
    }
}

function  imprimirConsulta(){
    if (objeto.readyState==4){
        document.getElementById("mesa").innerHTML=""+objeto.responseText+"";
        document.getElementById("cotizacion").innerHTML="";
    }
   
}


function  cotizar0(){

   var mesas=document.getElementById("mesas0");
   var mesa=mesas.value;
  document.getElementById("cotizacion").innerHTML="Cambiar el estado de la mesa "+mesa
    +" a disponible"  
  +"<br><br><center><input type='submit' value='Cambiar' onclick='re1();'></center>";

}
function  cotizar1(){
 
   var mesas=document.getElementById("mesas1");
   var mesa=mesas.value;
    document.getElementById("cotizacion").innerHTML="Cambiar el estado de la mesa "+mesa
    +" a disponible"      
  +"<br><br><center><input type='submit' value='Reservar' onclick='re2();'></center>";

}
function  cotizar2(){

 /////////////////////////////////  
   var mesas=document.getElementById("mesas2");
   var mesa=mesas.value;
   document.getElementById("cotizacion").innerHTML="Cambiar el estado de la mesa "+mesa
   +" a disponible"  
   +"<br><br><center><input type='submit' value='Reservar' onclick='re3();'></center>";

}
function  cotizar3(){

   var mesas=document.getElementById("mesas3");
   var mesa=mesas.value;
   document.getElementById("cotizacion").innerHTML="Cambiar el estado de la mesa "+mesa
   +" a disponible"
            +"<br><br><center><input type='submit' value='Reservar' onclick='re4();'></center>";

}
function  cotizar4(){
   var mesas=document.getElementById("mesas4");
   var mesa=mesas.value;
  document.getElementById("cotizacion").innerHTML="Cambiar el estado de la mesa "+mesa
   +" a disponible"
  +"<br><br><center><input type='submit' value='Reservar' onclick='re5();'></center>";

}
function  cotizar5(){ 
   var mesas=document.getElementById("mesas5");
   var mesa=mesas.value;
   document.getElementById("cotizacion").innerHTML="Cambiar el estado de la mesa "+mesa
    +" a disponible"
  +"<br><br><center><input type='submit' value='Reservar' onclick='re6();'></center>";

}
function  cotizar6(){
   var mesas=document.getElementById("mesas6");
   var mesa=mesas.value;
  document.getElementById("cotizacion").innerHTML="Cambiar el estado de la mesa "+mesa
   +" a disponible"
            +"<br><br><center><input type='submit' value='Reservar' onclick='re7();'></center>";

}
function  cotizar7(){

   var mesas=document.getElementById("mesas7");
   var mesa=mesas.value;
  document.getElementById("cotizacion").innerHTML="Cambiar el estado de la mesa "+mesa
   +" a disponible"
            +"<br><br><center><input type='submit' value='Reservar' onclick='re8();'></center>";

}
function  cotizar8(){

   var mesas=document.getElementById("mesas8");
   var mesa=mesas.value;
  document.getElementById("cotizacion").innerHTML="Cambiar el estado de la mesa "+mesa
          +" a disponible"
            +"<br><br><center><input type='submit' value='Reservar' onclick='re9();'></center>";

}
function  cotizar9(){
   var mesas=document.getElementById("mesas9");
   var mesa=mesas.value;
   document.getElementById("cotizacion").innerHTML="Cambiar el estado de la mesa "+mesa
   +" a disponible"
            +"<br><br><center><input type='submit' value='Reservar' onclick='re10();'></center>";

}


/////////////////////////MOSTRAR MENSAJE EXITOSO//////////////////////7
//1,2,3,4,5,6,7,8,9,10
//0,1,2,3,4,5,6,7,8,9
function  re1(){//copiar solos if y el tip y tipo y hacer los servblets
     
   var mesas=document.getElementById("mesas0");
   var mesa=mesas.value;
 var tip=document.getElementById("tipoMesa");
  var tipo= String(tip.options[tip.selectedIndex].value);
    if (tipo=='chicas'){
    objeto4.open("GET","estautschica?mesa="+mesa,true);
    objeto4.onreadystatechange=mensajeExitoso;
    objeto4.send(null);  
    }

  if (tipo=='medianas'){
   objeto4.open("GET","estautsmediana?mesa="+mesa,true);
    objeto4.onreadystatechange=mensajeExitoso;
    objeto4.send(null);  
    }

  if (tipo=='grandes'){
    objeto4.open("GET","estautsgrande?mesa="+mesa,true);
    objeto4.onreadystatechange=mensajeExitoso;
    objeto4.send(null);   
    }

}
function  re2(){

 /////////////////////////////////  
   var mesas=document.getElementById("mesas1");
   var mesa=mesas.value;
  var tip=document.getElementById("tipoMesa");
  var tipo= String(tip.options[tip.selectedIndex].value);
    if (tipo=='chicas'){
    objeto4.open("GET","estautschica?mesa="+mesa,true);
    objeto4.onreadystatechange=mensajeExitoso;
    objeto4.send(null);  
    }

  if (tipo=='medianas'){
   objeto4.open("GET","estautsmediana?mesa="+mesa,true);
    objeto4.onreadystatechange=mensajeExitoso;
    objeto4.send(null);  
    }

  if (tipo=='grandes'){
    objeto4.open("GET","estautsgrande?mesa="+mesa,true);
    objeto4.onreadystatechange=mensajeExitoso;
    objeto4.send(null);   
    }

}
function  re3(){
 
   var mesas=document.getElementById("mesas2");
   var mesa=mesas.value;
    var tip=document.getElementById("tipoMesa");
  var tipo= String(tip.options[tip.selectedIndex].value);
    if (tipo=='chicas'){
    objeto4.open("GET","estautschica?mesa="+mesa,true);
    objeto4.onreadystatechange=mensajeExitoso;
    objeto4.send(null);  
    }

  if (tipo=='medianas'){
   objeto4.open("GET","estautsmediana?mesa="+mesa,true);
    objeto4.onreadystatechange=mensajeExitoso;
    objeto4.send(null);  
    }

  if (tipo=='grandes'){
    objeto4.open("GET","estautsgrande?mesa="+mesa,true);
    objeto4.onreadystatechange=mensajeExitoso;
    objeto4.send(null);   
    }

}
function  re4(){
     
   var mesas=document.getElementById("mesas3");
   var mesa=mesas.value;
   var tip=document.getElementById("tipoMesa");
  var tipo= String(tip.options[tip.selectedIndex].value);
    if (tipo=='chicas'){
    objeto4.open("GET","estautschica?mesa="+mesa,true);
    objeto4.onreadystatechange=mensajeExitoso;
    objeto4.send(null);  
    }

  if (tipo=='medianas'){
   objeto4.open("GET","estautsmediana?mesa="+mesa,true);
    objeto4.onreadystatechange=mensajeExitoso;
    objeto4.send(null);  
    }

  if (tipo=='grandes'){
    objeto4.open("GET","estautsgrande?mesa="+mesa,true);
    objeto4.onreadystatechange=mensajeExitoso;
    objeto4.send(null);   
    }
}
function  re5(){
 
   var mesas=document.getElementById("mesas4");
   var mesa=mesas.value;
    var tip=document.getElementById("tipoMesa");
  var tipo= String(tip.options[tip.selectedIndex].value);
    if (tipo=='chicas'){
    objeto4.open("GET","estautschica?mesa="+mesa,true);
    objeto4.onreadystatechange=mensajeExitoso;
    objeto4.send(null);  
    }

  if (tipo=='medianas'){
   objeto4.open("GET","estautsmediana?mesa="+mesa,true);
    objeto4.onreadystatechange=mensajeExitoso;
    objeto4.send(null);  
    }

  if (tipo=='grandes'){
    objeto4.open("GET","estautsgrande?mesa="+mesa,true);
    objeto4.onreadystatechange=mensajeExitoso;
    objeto4.send(null);   
    }

}
function  re6(){
    
   var mesas=document.getElementById("mesas5");
   var mesa=mesas.value;
   var tip=document.getElementById("tipoMesa");
  var tipo= String(tip.options[tip.selectedIndex].value);
    if (tipo=='chicas'){
    objeto4.open("GET","estautschica?mesa="+mesa,true);
    objeto4.onreadystatechange=mensajeExitoso;
    objeto4.send(null);  
    }

  if (tipo=='medianas'){
   objeto4.open("GET","estautsmediana?mesa="+mesa,true);
    objeto4.onreadystatechange=mensajeExitoso;
    objeto4.send(null);  
    }

  if (tipo=='grandes'){
    objeto4.open("GET","estautsgrande?mesa="+mesa,true);
    objeto4.onreadystatechange=mensajeExitoso;
    objeto4.send(null);   
    }

}
function  re7(){
   
   var mesas=document.getElementById("mesas6");
   var mesa=mesas.value;
   var tip=document.getElementById("tipoMesa");
  var tipo= String(tip.options[tip.selectedIndex].value);
    if (tipo=='chicas'){
    objeto4.open("GET","estautschica?mesa="+mesa,true);
    objeto4.onreadystatechange=mensajeExitoso;
    objeto4.send(null);  
    }

  if (tipo=='medianas'){
   objeto4.open("GET","estautsmediana?mesa="+mesa,true);
    objeto4.onreadystatechange=mensajeExitoso;
    objeto4.send(null);  
    }

  if (tipo=='grandes'){
    objeto4.open("GET","estautsgrande?mesa="+mesa,true);
    objeto4.onreadystatechange=mensajeExitoso;
    objeto4.send(null);   
    }
}
function  re8(){
    
   var mesas=document.getElementById("mesas7");
   var mesa=mesas.value;
   var tip=document.getElementById("tipoMesa");
  var tipo= String(tip.options[tip.selectedIndex].value);
    if (tipo=='chicas'){
    objeto4.open("GET","estautschica?mesa="+mesa,true);
    objeto4.onreadystatechange=mensajeExitoso;
    objeto4.send(null);  
    }

  if (tipo=='medianas'){
   objeto4.open("GET","estautsmediana?mesa="+mesa,true);
    objeto4.onreadystatechange=mensajeExitoso;
    objeto4.send(null);  
    }

  if (tipo=='grandes'){
    objeto4.open("GET","estautsgrande?mesa="+mesa,true);
    objeto4.onreadystatechange=mensajeExitoso;
    objeto4.send(null);   
    }
}
function  re9(){
   
   var mesas=document.getElementById("mesas8");
   var mesa=mesas.value;
    var tip=document.getElementById("tipoMesa");
  var tipo= String(tip.options[tip.selectedIndex].value);
    if (tipo=='chicas'){
    objeto4.open("GET","estautschica?mesa="+mesa,true);
    objeto4.onreadystatechange=mensajeExitoso;
    objeto4.send(null);  
    }

  if (tipo=='medianas'){
   objeto4.open("GET","estautsmediana?mesa="+mesa,true);
    objeto4.onreadystatechange=mensajeExitoso;
    objeto4.send(null);  
    }

  if (tipo=='grandes'){
    objeto4.open("GET","estautsgrande?mesa="+mesa,true);
    objeto4.onreadystatechange=mensajeExitoso;
    objeto4.send(null);   
    }

}
function  re10(){
    
   var mesas=document.getElementById("mesas9");
   var mesa=mesas.value;
   var tip=document.getElementById("tipoMesa");
  var tipo= String(tip.options[tip.selectedIndex].value);
    if (tipo=='chicas'){
    objeto4.open("GET","estautschica?mesa="+mesa,true);
    objeto4.onreadystatechange=mensajeExitoso;
    objeto4.send(null);  
    }

  if (tipo=='medianas'){
   objeto4.open("GET","estautsmediana?mesa="+mesa,true);
    objeto4.onreadystatechange=mensajeExitoso;
    objeto4.send(null);  
    }

  if (tipo=='grandes'){
    objeto4.open("GET","estautsgrande?mesa="+mesa,true);
    objeto4.onreadystatechange=mensajeExitoso;
    objeto4.send(null);   
    }
}

function mensajeExitoso(){
    if (objeto4.readyState==4){
     alert('Cambio realizado');
        iniciarAbraham();
    }
   
}