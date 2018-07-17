/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var xhr0;
var xhr;
var xhr1;


    function crearandoOb(){
        if(window.ActiveXObjet){
	   xhr0=new ActiveXObject("Microsoft.XMLHttp");
            xhr=new ActiveXObject("Microsoft.XMLHttp");
	   xhr1=new ActiveXObject("Microsoft.XMLHttp");
	   
        }else if((window.XMLHttpRequest) || (typeof XMLHttpRequest) != undefined){
            xhr0=new XMLHttpRequest();
	   xhr=new XMLHttpRequest();
	   xhr1=new XMLHttpRequest();
	   }
            else{
                alert("su navegador no soporta AJAX");
                return;
            }
    }
function RegistarP(){
    crearandoOb();
  var radios=document.getElementsByName("platillor");
  if (radios[0].checked){
  document.getElementById("mensaje1").innerHTML="";
  document.getElementById("mostrar0").innerHTML="";
  xhr0.open("GET","PintarRP",true);
  xhr0.onreadystatechange=imprimirMensaje0;
  xhr0.send(null);
        
    }else if (radios[1].checked){
  document.getElementById("mensaje1").innerHTML="";
  document.getElementById("mostrar0").innerHTML="";
  xhr1.open("GET","ConsPla",true);
  xhr1.onreadystatechange=imprimirMensaje1;
  xhr1.send(null);
    
    
    
    }
}

function insertarP(){
    
  var nom=document.getElementById("nombre").value;
  var pre=document.getElementById("precioj").value;
  var ima=document.getElementById("imagenj").value;
  var tipo=document.getElementById("tipoj").value;
  var i= ima.substring(12);
  var des=document.getElementById("descripcionj").value; 
    alert(nom+" "+pre+" "+ima+" "+tipo+" "+i+" "+des );
  xhr.open("GET","RegistrarPLa?nom="+nom+"&tip="+tipo+"&pre="+pre+"&ima="+i+"&des="+des,true);
  xhr.onreadystatechange=imprimirMensaje;
  xhr.send(null);  
}

function imprimirMensaje0(){
   if (xhr0.readyState==4){
       
       document.getElementById("mostrar1").innerHTML=xhr0.responseText;
       
    }
}

function imprimirMensaje(){
   if (xhr.readyState==4){
       
       document.getElementById("mensaje1").innerHTML=xhr.responseText;
       
    }
}
function imprimirMensaje1(){
   if (xhr1.readyState==4){
       document.getElementById("mostrar1").innerHTML=xhr1.responseText;

    }
}


var xhr2;

    function crearandoOb1(){
        if(window.ActiveXObjet){
	   xhr2=new ActiveXObject("Microsoft.XMLHttp");
	  
        }else if((window.XMLHttpRequest) || (typeof XMLHttpRequest) != undefined){
	   xhr2=new XMLHttpRequest();
	   
        }
            else{
                alert("su navegador no soporta AJAX");
                return;
            }
    }
var xhr5;
  function crearandoOb5(){
        if(window.ActiveXObjet){

	   xhr5=new ActiveXObject("Microsoft.XMLHttp");
        }else if((window.XMLHttpRequest) || (typeof XMLHttpRequest) != undefined){
	   xhr5=new XMLHttpRequest();

        }
            else{
                alert("su navegador no soporta AJAX");
                return;
            }
    }
    
    
function actualizarp(iden){
  crearandoOb1();
   var ident=iden;  
  xhr2.open("GET","ActPla?ident="+ident,true);
  xhr2.onreadystatechange=imprimirMensaje2;
  xhr2.send(null);
    
    }
function imprimirMensaje2(){
   if (xhr2.readyState==4){
       document.getElementById("mostrar0").innerHTML=xhr2.responseText;

    }
}
function borrarp(id){
    crearandoOb5();
    var iden=id;
    
    xhr5.open("GET","BorrarPla?iden="+iden,true);
    xhr5.onreadystatechange=imprimirMensaje5;
    xhr5.send(null);
document.getElementById("mostrar0").innerHTML="";
    }

function imprimirMensaje5(){
   if (xhr5.readyState==4){
       document.getElementById("mostrar1").innerHTML=xhr5.responseText;

    }
}

var xhr3;

    function crearandoOb2(){
        if(window.ActiveXObjet){
	   xhr3=new ActiveXObject("Microsoft.XMLHttp");
        }else if((window.XMLHttpRequest) || (typeof XMLHttpRequest) != undefined){
	   xhr3=new XMLHttpRequest();
        }
            else{
                alert("su navegador no soporta AJAX");
                return;
            }
    }

  
    
    
function actualizarpla(id){
 var ident=id;  
 var nombre=document.getElementById("nombre").value;
 var tipo=document.getElementById("tipos").value;
 var precio=document.getElementById("preci").value;
 var descr=document.getElementById("desc").value;
 var ima=document.getElementById("ima").value; 
 var i= ima.substring(12);   
  alert(""+ident+" "+nombre+" "+tipo+" "+precio+" "+descr+" "+i);  
  crearandoOb2();
   xhr3.open("GET","ActPlati?nom="+nombre+"&tip="+tipo+"&pre="+precio+"&id="+ident+"&des="+descr+"&ima="+i,true);
  xhr3.onreadystatechange=imprimirMensaje3;
  xhr3.send(null);
    
    }
function imprimirMensaje3(){
   if (xhr3.readyState==4){
       document.getElementById("mensaje1").innerHTML=xhr3.responseText;

    }
}

