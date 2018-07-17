/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var xhr0;
var xhr1;

    function creOb(){
        if(window.ActiveXObjet){
	   xhr0=new ActiveXObject("Microsoft.XMLHttp");
	      xhr1=new ActiveXObject("Microsoft.XMLHttp");
        }else if((window.XMLHttpRequest) || (typeof XMLHttpRequest) != undefined){
            xhr0=new XMLHttpRequest();
	   xhr1=new XMLHttpRequest();
	   }
            else{
                alert("su navegador no soporta AJAX");
                return;
            }
    }
function pintar(){
 creOb();   
  var sel=document.getElementById("menu").value;
   alert("a"+sel); 
  xhr0.open("GET","ConsulOr?sele="+sel,true);
  xhr0.onreadystatechange=impMensaje;
  xhr0.send(null);  
}

function impMensaje(){
   if (xhr0.readyState==4){
       
       document.getElementById("ver1").innerHTML=xhr0.responseText;
       
    }
}


function carrito(){
 creOb();   
  xhr1.open("GET","SerCarrito",true);
  xhr1.onreadystatechange=impMensaje1;
  xhr1.send(null);  
}

function impMensaje1 (){
   if (xhr1.readyState==4){
       
       document.getElementById("ver1").innerHTML=xhr1.responseText;
       
    }
}


