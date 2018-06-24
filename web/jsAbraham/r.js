var objeto;
var objeto2;
var objeto3;
function crearObjeto(){
    if (window.ActiveXObject){
        objeto= new ActiveXObject("Microsoft.XMLHttp");
        objeto2= new ActiveXObject("Microsoft.XMLHttp");
         objeto3= new ActiveXObject("Microsoft.XMLHttp");
        
    }else if ((window.XMLHttpRequest) || (typeof  XMLHttpRequest)!=undefined) {
        objeto=new XMLHttpRequest();
          objeto2=new XMLHttpRequest();
      objeto3=new XMLHttpRequest();
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
////////////////////////////////////////////////77     
   var fech=fe.value;
   var dia=fech.substring(8,10);
   var mes=fech.substring(5,7);
   var ano=fech.substring(0,4);
   var fecha=dia+"/"+mes+"/"+ano;
/////////////////////////////////////////////////////////////////   
   var h=document.getElementById("hora");
   var hora=h.value;
   
////////////////////////AM O PM////////////////////////////////////////   
var ho=hora.substring(0,2);
 tiempo=parseInt(ho);
 v="";
 if (tiempo>=0 & tiempo<=11){
     v="am";
 }
 if (tiempo>=12 &tiempo <=23){
     v="pm";
 }
 /////////////////////////////////  
   var mesas=document.getElementById("mesas0");
   var mesa=mesas.value;
  document.getElementById("cotizacion").innerHTML="Reservar Mesa "+mesa+" a las "+hora+" "+v+" el dia "+fecha+""
  +"<br><br><center><input type='submit' value='Reservar' onclick='re1();'></center>";

}
function  cotizar1(){
     var fe=document.getElementById("fecha");
   ////////////////////////////////////////////////77     
   var fech=fe.value;
   var dia=fech.substring(8,10);
   var mes=fech.substring(5,7);
   var ano=fech.substring(0,4);
   var fecha=dia+"/"+mes+"/"+ano;
/////////////////////////////////////////////////////////////////   
    var h=document.getElementById("hora");
    var hora=h.value;
   ////////////////////////AM O PM////////////////////////////////////////   
var ho=hora.substring(0,2);
 tiempo=parseInt(ho);
 v="";
 if (tiempo>=0 & tiempo<=11){
     v="am";
 }
 if (tiempo>=12 &tiempo <=23){
     v="pm";
 }
 /////////////////////////////////   
   var mesas=document.getElementById("mesas1");
   var mesa=mesas.value;
    document.getElementById("cotizacion").innerHTML="Reservar Mesa "+mesa+" a las "+hora+" "+v+" el dia "+fecha+""
  +"<br><br><center><input type='submit' value='Reservar' onclick='re2();'></center>";

}
function  cotizar2(){
     var fe=document.getElementById("fecha");
   ////////////////////////////////////////////////77     
   var fech=fe.value;
   var dia=fech.substring(8,10);
   var mes=fech.substring(5,7);
   var ano=fech.substring(0,4);
   var fecha=dia+"/"+mes+"/"+ano;
/////////////////////////////////////////////////////////////////   
    var h=document.getElementById("hora");
    var hora=h.value;
    ////////////////////////AM O PM////////////////////////////////////////   
var ho=hora.substring(0,2);
 tiempo=parseInt(ho);
 v="";
 if (tiempo>=0 & tiempo<=11){
     v="am";
 }
 if (tiempo>=12 &tiempo <=23){
     v="pm";
 }
 /////////////////////////////////  
   var mesas=document.getElementById("mesas2");
   var mesa=mesas.value;
   document.getElementById("cotizacion").innerHTML="Reservar Mesa "+mesa+" a las "+hora+" "+v+" el dia "+fecha+""
  +"<br><br><center><input type='submit' value='Reservar' onclick='re3();'></center>";

}
function  cotizar3(){
     var fe=document.getElementById("fecha");
   ////////////////////////////////////////////////77     
   var fech=fe.value;
   var dia=fech.substring(8,10);
   var mes=fech.substring(5,7);
   var ano=fech.substring(0,4);
   var fecha=dia+"/"+mes+"/"+ano;
/////////////////////////////////////////////////////////////////   
    var h=document.getElementById("hora");
    var hora=h.value;
    ////////////////////////AM O PM////////////////////////////////////////   
var ho=hora.substring(0,2);
 tiempo=parseInt(ho);
 v="";
 if (tiempo>=0 & tiempo<=11){
     v="am";
 }
 if (tiempo>=12 &tiempo <=23){
     v="pm";
 }
 /////////////////////////////////  
   var mesas=document.getElementById("mesas3");
   var mesa=mesas.value;
   document.getElementById("cotizacion").innerHTML="Reservar Mesa "+mesa+" a las "+hora+" "+v+" el dia "+fecha+""
  +"<br><br><center><input type='submit' value='Reservar' onclick='re4();'></center>";

}
function  cotizar4(){
     var fe=document.getElementById("fecha");
    ////////////////////////////////////////////////77     
   var fech=fe.value;
   var dia=fech.substring(8,10);
   var mes=fech.substring(5,7);
   var ano=fech.substring(0,4);
   var fecha=dia+"/"+mes+"/"+ano;
/////////////////////////////////////////////////////////////////   
    var h=document.getElementById("hora");
    var hora=h.value;
    ////////////////////////AM O PM////////////////////////////////////////   
var ho=hora.substring(0,2);
 tiempo=parseInt(ho);
 v="";
 if (tiempo>=0 & tiempo<=11){
     v="am";
 }
 if (tiempo>=12 &tiempo <=23){
     v="pm";
 }
 /////////////////////////////////  
   var mesas=document.getElementById("mesas4");
   var mesa=mesas.value;
  document.getElementById("cotizacion").innerHTML="Reservar Mesa "+mesa+" a las "+hora+" "+v+" el dia "+fecha+""
  +"<br><br><center><input type='submit' value='Reservar' onclick='re5();'></center>";

}
function  cotizar5(){
     var fe=document.getElementById("fecha");
    ////////////////////////////////////////////////77     
   var fech=fe.value;
   var dia=fech.substring(8,10);
   var mes=fech.substring(5,7);
   var ano=fech.substring(0,4);
   var fecha=dia+"/"+mes+"/"+ano;
/////////////////////////////////////////////////////////////////   
    var h=document.getElementById("hora");
    var hora=h.value;
    ////////////////////////AM O PM////////////////////////////////////////   
var ho=hora.substring(0,2);
 tiempo=parseInt(ho);
 v="";
 if (tiempo>=0 & tiempo<=11){
     v="am";
 }
 if (tiempo>=12 &tiempo <=23){
     v="pm";
 }
 /////////////////////////////////  
   var mesas=document.getElementById("mesas5");
   var mesa=mesas.value;
   document.getElementById("cotizacion").innerHTML="Reservar Mesa "+mesa+" a las "+hora+" "+v+" el dia "+fecha+""
  +"<br><br><center><input type='submit' value='Reservar' onclick='re6();'></center>";

}
function  cotizar6(){
     var fe=document.getElementById("fecha");
    ////////////////////////////////////////////////77     
   var fech=fe.value;
   var dia=fech.substring(8,10);
   var mes=fech.substring(5,7);
   var ano=fech.substring(0,4);
   var fecha=dia+"/"+mes+"/"+ano;
/////////////////////////////////////////////////////////////////   
    var h=document.getElementById("hora");
    var hora=h.value;
    ////////////////////////AM O PM////////////////////////////////////////   
var ho=hora.substring(0,2);
 tiempo=parseInt(ho);
 v="";
 if (tiempo>=0 & tiempo<=11){
     v="am";
 }
 if (tiempo>=12 &tiempo <=23){
     v="pm";
 }
 /////////////////////////////////  
   var mesas=document.getElementById("mesas6");
   var mesa=mesas.value;
  document.getElementById("cotizacion").innerHTML="Reservar Mesa "+mesa+" a las "+hora+" "+v+" el dia "+fecha+""
  +"<br><br><center><input type='submit' value='Reservar' onclick='re7();'></center>";

}
function  cotizar7(){
     var fe=document.getElementById("fecha");
  ////////////////////////////////////////////////77     
   var fech=fe.value;
   var dia=fech.substring(8,10);
   var mes=fech.substring(5,7);
   var ano=fech.substring(0,4);
   var fecha=dia+"/"+mes+"/"+ano;
/////////////////////////////////////////////////////////////////   
    var h=document.getElementById("hora");
    var hora=h.value;
    ////////////////////////AM O PM////////////////////////////////////////   
var ho=hora.substring(0,2);
 tiempo=parseInt(ho);
 v="";
 if (tiempo>=0 & tiempo<=11){
     v="am";
 }
 if (tiempo>=12 &tiempo <=23){
     v="pm";
 }
 /////////////////////////////////  
   var mesas=document.getElementById("mesas7");
   var mesa=mesas.value;
  document.getElementById("cotizacion").innerHTML="Reservar Mesa "+mesa+" a las "+hora+" "+v+" el dia "+fecha+""
  +"<br><br><center><input type='submit' value='Reservar' onclick='re8();'></center>";

}
function  cotizar8(){
     var fe=document.getElementById("fecha");
   ////////////////////////////////////////////////77     
   var fech=fe.value;
   var dia=fech.substring(8,10);
   var mes=fech.substring(5,7);
   var ano=fech.substring(0,4);
   var fecha=dia+"/"+mes+"/"+ano;
/////////////////////////////////////////////////////////////////   
    var h=document.getElementById("hora");
    var hora=h.value;
    ////////////////////////AM O PM////////////////////////////////////////   
var ho=hora.substring(0,2);
 tiempo=parseInt(ho);
 v="";
 if (tiempo>=0 & tiempo<=11){
     v="am";
 }
 if (tiempo>=12 &tiempo <=23){
     v="pm";
 }
 /////////////////////////////////  
   var mesas=document.getElementById("mesas8");
   var mesa=mesas.value;
  document.getElementById("cotizacion").innerHTML="Reservar Mesa "+mesa+" a las "+hora+" "+v+" el dia "+fecha+""
  +"<br><br><center><input type='submit' value='Reservar' onclick='re9();'></center>";

}
function  cotizar9(){
     var fe=document.getElementById("fecha");
    ////////////////////////////////////////////////77     
   var fech=fe.value;
   var dia=fech.substring(8,10);
   var mes=fech.substring(5,7);
   var ano=fech.substring(0,4);
   var fecha=dia+"/"+mes+"/"+ano;
/////////////////////////////////////////////////////////////////   
    var h=document.getElementById("hora");
    var hora=h.value;
    ////////////////////////AM O PM////////////////////////////////////////   
var ho=hora.substring(0,2);
 tiempo=parseInt(ho);
 v="";
 if (tiempo>=0 & tiempo<=11){
     v="am";
 }
 if (tiempo>=12 &tiempo <=23){
     v="pm";
 }
 /////////////////////////////////  
   var mesas=document.getElementById("mesas9");
   var mesa=mesas.value;
   document.getElementById("cotizacion").innerHTML="Reservar Mesa "+mesa+" a las "+hora+" "+v+" el dia "+fecha+""
  +"<br><br><center><input type='submit' value='Reservar' onclick='re10();'></center>";

}


/////////////////////////MOSTRAR MENSAJE EXITOSO//////////////////////7
//1,2,3,4,5,6,7,8,9,10
//0,1,2,3,4,5,6,7,8,9
function  re1(){
     var fe=document.getElementById("fecha");
////////////////////////////////////////////////77     
   var fech=fe.value;
   var dia=fech.substring(8,10);
   var mes=fech.substring(5,7);
   var ano=fech.substring(0,4);
   var fecha=dia+"/"+mes+"/"+ano;
/////////////////////////////////////////////////////////////////   
   var h=document.getElementById("hora");
   var hora=h.value;
   
////////////////////////AM O PM////////////////////////////////////////   
var ho=hora.substring(0,2);
 tiempo=parseInt(ho);
 v="";
 if (tiempo>=0 & tiempo<=11){
     v="am";
 }
 if (tiempo>=12 &tiempo <=23){
     v="pm";
 }
 /////////////////////////////////  
   var mesas=document.getElementById("mesas0");
   var mesa=mesas.value;
   //enviamos mesa,fecha,hora_inicio,numero_comensales,estatus,tipo_mesa
    var co=document.getElementById("comensal");
    var comensal=co.value;
    
    if (comensal>=1 && comensal<=2){
    objeto2.open("GET","reservachica?mesa="+mesa+"&fecha="+fecha+"&hora="+hora+"&numero="+comensal,true);
     objeto2.onreadystatechange=mensajeExitoso;
    objeto2.send(null);  
    }

  if (comensal>=3 && comensal<=4){
    objeto2.open("GET","reservamediana?mesa="+mesa+"&fecha="+fecha+"&hora="+hora+"&numero="+comensal,true);
     objeto2.onreadystatechange=mensajeExitoso;
    objeto2.send(null);  
    }

  if (comensal>=5){
    objeto2.open("GET","reservagrande?mesa="+mesa+"&fecha="+fecha+"&hora="+hora+"&numero="+comensal,true);
    objeto2.onreadystatechange=mensajeExitoso;
    objeto2.send(null);  
    }

}
function  re2(){
     var fe=document.getElementById("fecha");
////////////////////////////////////////////////77     
   var fech=fe.value;
   var dia=fech.substring(8,10);
   var mes=fech.substring(5,7);
   var ano=fech.substring(0,4);
   var fecha=dia+"/"+mes+"/"+ano;
/////////////////////////////////////////////////////////////////   
   var h=document.getElementById("hora");
   var hora=h.value;
   
////////////////////////AM O PM////////////////////////////////////////   
var ho=hora.substring(0,2);
 tiempo=parseInt(ho);
 v="";
 if (tiempo>=0 & tiempo<=11){
     v="am";
 }
 if (tiempo>=12 &tiempo <=23){
     v="pm";
 }
 /////////////////////////////////  
   var mesas=document.getElementById("mesas1");
   var mesa=mesas.value;
   //enviamos mesa,fecha,hora_inicio,numero_comensales,estatus,tipo_mesa
    var co=document.getElementById("comensal");
    var comensal=co.value;
    
    if (comensal>=1 && comensal<=2){
    objeto2.open("GET","reservachica?mesa="+mesa+"&fecha="+fecha+"&hora="+hora+"&numero="+comensal,true);
     objeto2.onreadystatechange=mensajeExitoso;
    objeto2.send(null);  
    }

  if (comensal>=3 && comensal<=4){
    objeto2.open("GET","reservamediana?mesa="+mesa+"&fecha="+fecha+"&hora="+hora+"&numero="+comensal,true);
     objeto2.onreadystatechange=mensajeExitoso;
    objeto2.send(null);  
    }

  if (comensal>=5){
    objeto2.open("GET","reservagrande?mesa="+mesa+"&fecha="+fecha+"&hora="+hora+"&numero="+comensal,true);
    objeto2.onreadystatechange=mensajeExitoso;
    objeto2.send(null);  
    }

}
function  re3(){
     var fe=document.getElementById("fecha");
////////////////////////////////////////////////77     
   var fech=fe.value;
   var dia=fech.substring(8,10);
   var mes=fech.substring(5,7);
   var ano=fech.substring(0,4);
   var fecha=dia+"/"+mes+"/"+ano;
/////////////////////////////////////////////////////////////////   
   var h=document.getElementById("hora");
   var hora=h.value;
   
////////////////////////AM O PM////////////////////////////////////////   
var ho=hora.substring(0,2);
 tiempo=parseInt(ho);
 v="";
 if (tiempo>=0 & tiempo<=11){
     v="am";
 }
 if (tiempo>=12 &tiempo <=23){
     v="pm";
 }
 /////////////////////////////////  
   var mesas=document.getElementById("mesas2");
   var mesa=mesas.value;
   //enviamos mesa,fecha,hora_inicio,numero_comensales,estatus,tipo_mesa
    var co=document.getElementById("comensal");
    var comensal=co.value;
    
    if (comensal>=1 && comensal<=2){
    objeto2.open("GET","reservachica?mesa="+mesa+"&fecha="+fecha+"&hora="+hora+"&numero="+comensal,true);
     objeto2.onreadystatechange=mensajeExitoso;
    objeto2.send(null);  
    }

  if (comensal>=3 && comensal<=4){
    objeto2.open("GET","reservamediana?mesa="+mesa+"&fecha="+fecha+"&hora="+hora+"&numero="+comensal,true);
     objeto2.onreadystatechange=mensajeExitoso;
    objeto2.send(null);  
    }

  if (comensal>=5){
    objeto2.open("GET","reservagrande?mesa="+mesa+"&fecha="+fecha+"&hora="+hora+"&numero="+comensal,true);
    objeto2.onreadystatechange=mensajeExitoso;
    objeto2.send(null);  
    }

}
function  re4(){
     var fe=document.getElementById("fecha");
////////////////////////////////////////////////77     
   var fech=fe.value;
   var dia=fech.substring(8,10);
   var mes=fech.substring(5,7);
   var ano=fech.substring(0,4);
   var fecha=dia+"/"+mes+"/"+ano;
/////////////////////////////////////////////////////////////////   
   var h=document.getElementById("hora");
   var hora=h.value;
   
////////////////////////AM O PM////////////////////////////////////////   
var ho=hora.substring(0,2);
 tiempo=parseInt(ho);
 v="";
 if (tiempo>=0 & tiempo<=11){
     v="am";
 }
 if (tiempo>=12 &tiempo <=23){
     v="pm";
 }
 /////////////////////////////////  
   var mesas=document.getElementById("mesas3");
   var mesa=mesas.value;
   //enviamos mesa,fecha,hora_inicio,numero_comensales,estatus,tipo_mesa
    var co=document.getElementById("comensal");
    var comensal=co.value;
    
    if (comensal>=1 && comensal<=2){
    objeto2.open("GET","reservachica?mesa="+mesa+"&fecha="+fecha+"&hora="+hora+"&numero="+comensal,true);
     objeto2.onreadystatechange=mensajeExitoso;
    objeto2.send(null);  
    }

  if (comensal>=3 && comensal<=4){
    objeto2.open("GET","reservamediana?mesa="+mesa+"&fecha="+fecha+"&hora="+hora+"&numero="+comensal,true);
     objeto2.onreadystatechange=mensajeExitoso;
    objeto2.send(null);  
    }

  if (comensal>=5){
    objeto2.open("GET","reservagrande?mesa="+mesa+"&fecha="+fecha+"&hora="+hora+"&numero="+comensal,true);
    objeto2.onreadystatechange=mensajeExitoso;
    objeto2.send(null);  
    }

}
function  re5(){
     var fe=document.getElementById("fecha");
////////////////////////////////////////////////77     
   var fech=fe.value;
   var dia=fech.substring(8,10);
   var mes=fech.substring(5,7);
   var ano=fech.substring(0,4);
   var fecha=dia+"/"+mes+"/"+ano;
/////////////////////////////////////////////////////////////////   
   var h=document.getElementById("hora");
   var hora=h.value;
   
////////////////////////AM O PM////////////////////////////////////////   
var ho=hora.substring(0,2);
 tiempo=parseInt(ho);
 v="";
 if (tiempo>=0 & tiempo<=11){
     v="am";
 }
 if (tiempo>=12 &tiempo <=23){
     v="pm";
 }
 /////////////////////////////////  
   var mesas=document.getElementById("mesas4");
   var mesa=mesas.value;
   //enviamos mesa,fecha,hora_inicio,numero_comensales,estatus,tipo_mesa
    var co=document.getElementById("comensal");
    var comensal=co.value;
    
    if (comensal>=1 && comensal<=2){
    objeto2.open("GET","reservachica?mesa="+mesa+"&fecha="+fecha+"&hora="+hora+"&numero="+comensal,true);
     objeto2.onreadystatechange=mensajeExitoso;
    objeto2.send(null);  
    }

  if (comensal>=3 && comensal<=4){
    objeto2.open("GET","reservamediana?mesa="+mesa+"&fecha="+fecha+"&hora="+hora+"&numero="+comensal,true);
     objeto2.onreadystatechange=mensajeExitoso;
    objeto2.send(null);  
    }

  if (comensal>=5){
    objeto2.open("GET","reservagrande?mesa="+mesa+"&fecha="+fecha+"&hora="+hora+"&numero="+comensal,true);
    objeto2.onreadystatechange=mensajeExitoso;
    objeto2.send(null);  
    }

}
function  re6(){
     var fe=document.getElementById("fecha");
////////////////////////////////////////////////77     
   var fech=fe.value;
   var dia=fech.substring(8,10);
   var mes=fech.substring(5,7);
   var ano=fech.substring(0,4);
   var fecha=dia+"/"+mes+"/"+ano;
/////////////////////////////////////////////////////////////////   
   var h=document.getElementById("hora");
   var hora=h.value;
   
////////////////////////AM O PM////////////////////////////////////////   
var ho=hora.substring(0,2);
 tiempo=parseInt(ho);
 v="";
 if (tiempo>=0 & tiempo<=11){
     v="am";
 }
 if (tiempo>=12 &tiempo <=23){
     v="pm";
 }
 /////////////////////////////////  
   var mesas=document.getElementById("mesas5");
   var mesa=mesas.value;
   //enviamos mesa,fecha,hora_inicio,numero_comensales,estatus,tipo_mesa
    var co=document.getElementById("comensal");
    var comensal=co.value;
    
    if (comensal>=1 && comensal<=2){
    objeto2.open("GET","reservachica?mesa="+mesa+"&fecha="+fecha+"&hora="+hora+"&numero="+comensal,true);
     objeto2.onreadystatechange=mensajeExitoso;
    objeto2.send(null);  
    }

  if (comensal>=3 && comensal<=4){
    objeto2.open("GET","reservamediana?mesa="+mesa+"&fecha="+fecha+"&hora="+hora+"&numero="+comensal,true);
     objeto2.onreadystatechange=mensajeExitoso;
    objeto2.send(null);  
    }

  if (comensal>=5){
    objeto2.open("GET","reservagrande?mesa="+mesa+"&fecha="+fecha+"&hora="+hora+"&numero="+comensal,true);
    objeto2.onreadystatechange=mensajeExitoso;
    objeto2.send(null);  
    }

}
function  re7(){
     var fe=document.getElementById("fecha");
////////////////////////////////////////////////77     
   var fech=fe.value;
   var dia=fech.substring(8,10);
   var mes=fech.substring(5,7);
   var ano=fech.substring(0,4);
   var fecha=dia+"/"+mes+"/"+ano;
/////////////////////////////////////////////////////////////////   
   var h=document.getElementById("hora");
   var hora=h.value;
   
////////////////////////AM O PM////////////////////////////////////////   
var ho=hora.substring(0,2);
 tiempo=parseInt(ho);
 v="";
 if (tiempo>=0 & tiempo<=11){
     v="am";
 }
 if (tiempo>=12 &tiempo <=23){
     v="pm";
 }
 /////////////////////////////////  
   var mesas=document.getElementById("mesas6");
   var mesa=mesas.value;
   //enviamos mesa,fecha,hora_inicio,numero_comensales,estatus,tipo_mesa
    var co=document.getElementById("comensal");
    var comensal=co.value;
    
    if (comensal>=1 && comensal<=2){
    objeto2.open("GET","reservachica?mesa="+mesa+"&fecha="+fecha+"&hora="+hora+"&numero="+comensal,true);
     objeto2.onreadystatechange=mensajeExitoso;
    objeto2.send(null);  
    }

  if (comensal>=3 && comensal<=4){
    objeto2.open("GET","reservamediana?mesa="+mesa+"&fecha="+fecha+"&hora="+hora+"&numero="+comensal,true);
     objeto2.onreadystatechange=mensajeExitoso;
    objeto2.send(null);  
    }

  if (comensal>=5){
    objeto2.open("GET","reservagrande?mesa="+mesa+"&fecha="+fecha+"&hora="+hora+"&numero="+comensal,true);
    objeto2.onreadystatechange=mensajeExitoso;
    objeto2.send(null);  
    }

}
function  re8(){
     var fe=document.getElementById("fecha");
////////////////////////////////////////////////77     
   var fech=fe.value;
   var dia=fech.substring(8,10);
   var mes=fech.substring(5,7);
   var ano=fech.substring(0,4);
   var fecha=dia+"/"+mes+"/"+ano;
/////////////////////////////////////////////////////////////////   
   var h=document.getElementById("hora");
   var hora=h.value;
   
////////////////////////AM O PM////////////////////////////////////////   
var ho=hora.substring(0,2);
 tiempo=parseInt(ho);
 v="";
 if (tiempo>=0 & tiempo<=11){
     v="am";
 }
 if (tiempo>=12 &tiempo <=23){
     v="pm";
 }
 /////////////////////////////////  
   var mesas=document.getElementById("mesas7");
   var mesa=mesas.value;
   //enviamos mesa,fecha,hora_inicio,numero_comensales,estatus,tipo_mesa
    var co=document.getElementById("comensal");
    var comensal=co.value;
    
    if (comensal>=1 && comensal<=2){
    objeto2.open("GET","reservachica?mesa="+mesa+"&fecha="+fecha+"&hora="+hora+"&numero="+comensal,true);
     objeto2.onreadystatechange=mensajeExitoso;
    objeto2.send(null);  
    }

  if (comensal>=3 && comensal<=4){
    objeto2.open("GET","reservamediana?mesa="+mesa+"&fecha="+fecha+"&hora="+hora+"&numero="+comensal,true);
     objeto2.onreadystatechange=mensajeExitoso;
    objeto2.send(null);  
    }

  if (comensal>=5){
    objeto2.open("GET","reservagrande?mesa="+mesa+"&fecha="+fecha+"&hora="+hora+"&numero="+comensal,true);
    objeto2.onreadystatechange=mensajeExitoso;
    objeto2.send(null);  
    }

}
function  re9(){
     var fe=document.getElementById("fecha");
////////////////////////////////////////////////77     
   var fech=fe.value;
   var dia=fech.substring(8,10);
   var mes=fech.substring(5,7);
   var ano=fech.substring(0,4);
   var fecha=dia+"/"+mes+"/"+ano;
/////////////////////////////////////////////////////////////////   
   var h=document.getElementById("hora");
   var hora=h.value;
   
////////////////////////AM O PM////////////////////////////////////////   
var ho=hora.substring(0,2);
 tiempo=parseInt(ho);
 v="";
 if (tiempo>=0 & tiempo<=11){
     v="am";
 }
 if (tiempo>=12 &tiempo <=23){
     v="pm";
 }
 /////////////////////////////////  
   var mesas=document.getElementById("mesas8");
   var mesa=mesas.value;
   //enviamos mesa,fecha,hora_inicio,numero_comensales,estatus,tipo_mesa
    var co=document.getElementById("comensal");
    var comensal=co.value;
    
    if (comensal>=1 && comensal<=2){
    objeto2.open("GET","reservachica?mesa="+mesa+"&fecha="+fecha+"&hora="+hora+"&numero="+comensal,true);
     objeto2.onreadystatechange=mensajeExitoso;
    objeto2.send(null);  
    }

  if (comensal>=3 && comensal<=4){
    objeto2.open("GET","reservamediana?mesa="+mesa+"&fecha="+fecha+"&hora="+hora+"&numero="+comensal,true);
     objeto2.onreadystatechange=mensajeExitoso;
    objeto2.send(null);  
    }

  if (comensal>=5){
    objeto2.open("GET","reservagrande?mesa="+mesa+"&fecha="+fecha+"&hora="+hora+"&numero="+comensal,true);
    objeto2.onreadystatechange=mensajeExitoso;
    objeto2.send(null);  
    }

}
function  re10(){
     var fe=document.getElementById("fecha");
////////////////////////////////////////////////77     
   var fech=fe.value;
   var dia=fech.substring(8,10);
   var mes=fech.substring(5,7);
   var ano=fech.substring(0,4);
   var fecha=dia+"/"+mes+"/"+ano;
/////////////////////////////////////////////////////////////////   
   var h=document.getElementById("hora");
   var hora=h.value;
   
////////////////////////AM O PM////////////////////////////////////////   
var ho=hora.substring(0,2);
 tiempo=parseInt(ho);
 v="";
 if (tiempo>=0 & tiempo<=11){
     v="am";
 }
 if (tiempo>=12 &tiempo <=23){
     v="pm";
 }
 /////////////////////////////////  
   var mesas=document.getElementById("mesas9");
   var mesa=mesas.value;
   //enviamos mesa,fecha,hora_inicio,numero_comensales,estatus,tipo_mesa
    var co=document.getElementById("comensal");
    var comensal=co.value;
    
    if (comensal>=1 && comensal<=2){
    objeto2.open("GET","reservachica?mesa="+mesa+"&fecha="+fecha+"&hora="+hora+"&numero="+comensal,true);
     objeto2.onreadystatechange=mensajeExitoso;
    objeto2.send(null);  
    }

  if (comensal>=3 && comensal<=4){
    objeto2.open("GET","reservamediana?mesa="+mesa+"&fecha="+fecha+"&hora="+hora+"&numero="+comensal,true);
     objeto2.onreadystatechange=mensajeExitoso;
    objeto2.send(null);  
    }

  if (comensal>=5){
    objeto2.open("GET","reservagrande?mesa="+mesa+"&fecha="+fecha+"&hora="+hora+"&numero="+comensal,true);
    objeto2.onreadystatechange=mensajeExitoso;
    objeto2.send(null);  
    }

}

function mensajeExitoso(){
    if (objeto2.readyState==4){
      document.getElementById("mesa").innerHTML="";
     document.getElementById("cotizacion").innerHTML="";
     alert('Reserva realizada');
    }
   
}