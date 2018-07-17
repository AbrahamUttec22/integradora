
var xhr0;
var xhr1;
var xhr2;
function creOb(){
        if(window.ActiveXObjet){
	   xhr0=new ActiveXObject("Microsoft.XMLHttp");
	      xhr1=new ActiveXObject("Microsoft.XMLHttp");
	      xhr2=new ActiveXObject("Microsoft.XMLHttp");
        }else if((window.XMLHttpRequest) || (typeof XMLHttpRequest) != undefined){
            xhr0=new XMLHttpRequest();
	   xhr1=new XMLHttpRequest();
	   xhr2=new XMLHttpRequest();
	   }
            else{
                alert("su navegador no soporta AJAX");
                return;
            }
    }
function pintar(){
 creOb();   
  var sel=document.getElementById("menu").value;

  xhr0.open("GET","ConsulOr?sele="+sel,true);
  xhr0.onreadystatechange=impMensaje;
  xhr0.send(null);  
}

function impMensaje(){
   if (xhr0.readyState==4){
       
       document.getElementById("ver1").innerHTML=xhr0.responseText;
       
    }
}


function agregar(){


var i0 = document.getElementById("idp").value;
var ii = document.getElementById("nombre").value;	
var i = document.getElementById("precio").value;				
var sub=i/1.16;
var s=sub.toFixed(2);
var Iva=sub*.16;
var iva=Iva.toFixed(2);
var Total=sub+Iva;
var t=Total.toFixed(2);
var x = document.getElementById("myTable").getElementsByTagName("tr").length;
addRow([x,i0,i,ii,s,iva,t]);

  }

function borrarTodo(){			
        document.getElementById("men3").innerHTML="";
        document.getElementById("men4").innerHTML="";
       document.getElementById("men2").innerHTML="<table class=imagetable width=50% id=myTable>"
            +"<thead>"
            +"<tr>"
	   +"<th>Numero</th>"
	   +"<th>Id platillo</th>"    
	   +"<th>Precio</th>"
	   +"<th>Nombre</th>"
	   +"<th>Subtotal</th>"
	   +"<th>IVA</th>"
	   +"<th>Total</th>"
	   +"</tr>"
            +"</thead>"
            +"<tbody id=tbl_bdy>"
	   
	   +"</tbody>"
	   +"</table><br><br>"
	   +"<input type=button id=todo value='Borrar Carrito' onClick=borrarTodo(); />&nbsp;&nbsp;&nbsp;&nbsp;"
	   +"<input type=button id=todo value='Calcular' onClick=getAllRows(); />";
	   
}

function addRow(dataArr){
var tr=document.createElement('tr');
var len=dataArr.length;

    for(var i=0;i<len;i++){
var td=document.createElement('td');
td.appendChild(document.createTextNode(dataArr[i]));
tr.appendChild(td);
    }document.getElementById('tbl_bdy').appendChild(tr);


return true;  
}

function probar(id){
creOb();
var ident=id;
xhr2.open("GET","Previo?ident="+ident,true);
xhr2.onreadystatechange=impMensaje2;
xhr2.send(null);
    
    }
function impMensaje2(){
   if (xhr2.readyState==4){
       document.getElementById("men1").innerHTML=xhr2.responseText;

    }
}


var xhr3;
    function creOb1(){
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


function getAllRows(){
creOb1();    
tabla = document.getElementById("myTable");
var total = 0;
for(var i = 1; tabla.rows[i]; i++)
total += Number(tabla.rows[i].cells[6].innerHTML);
var num = total.toFixed(2);
//alert(total);

xhr3.open("GET","Calculo?sub="+num,true);
xhr3.onreadystatechange=impMensaje3;
xhr3.send(null);
    
    }
function impMensaje3(){
   if (xhr3.readyState==4){
       document.getElementById("men3").innerHTML=xhr3.responseText;

    }
}


var xhr4;
    function creOb2(){
        if(window.ActiveXObjet){
	   xhr4=new ActiveXObject("Microsoft.XMLHttp");
	      
        }else if((window.XMLHttpRequest) || (typeof XMLHttpRequest) != undefined){
            xhr4=new XMLHttpRequest();
	   
	   }
            else{
                alert("su navegador no soporta AJAX");
                return;
            }
    }


function solicitard(){
creOb2();    

 xhr4.open("GET","ObtencionD",true);
xhr4.onreadystatechange=impMensaje4;
xhr4.send(null);
    }
function impMensaje4(){
   if (xhr4.readyState==4){
       document.getElementById("men4").innerHTML=xhr4.responseText;

    }
}
var xhr5;
var xhr6;
    function creOb3(){
        if(window.ActiveXObjet){
	   xhr5=new ActiveXObject("Microsoft.XMLHttp");
	         xhr6=new ActiveXObject("Microsoft.XMLHttp");
        }else if((window.XMLHttpRequest) || (typeof XMLHttpRequest) != undefined){
            xhr5=new XMLHttpRequest();
	   xhr6=new XMLHttpRequest();
	   }
            else{
                alert("su navegador no soporta AJAX");
                return;
            }
    }

function ordenarcomida(){
creOb3();    

    var tip=document.getElementById("pedido").value;
if (tip==1){
     document.getElementById("men5").innerHTML="";

    xhr5.open("GET","PintarCliente?ti="+tip,true);
xhr5.onreadystatechange=impMensaje5;
xhr5.send(null);
}else if (tip==2){
     document.getElementById("men5").innerHTML="";

xhr5.open("GET","PintarCliente?ti="+tip,true);
xhr5.onreadystatechange=impMensaje5;
xhr5.send(null);
}else if (tip==3){
     document.getElementById("men5").innerHTML="";

xhr5.open("GET","PintarCliente?ti="+tip,true);
xhr5.onreadystatechange=impMensaje5;
xhr5.send(null);
}

    
} 
function impMensaje5(){
   if (xhr5.readyState==4){
       document.getElementById("men5").innerHTML=xhr5.responseText;

    }
}

function insertarVenta(){
   
creOb3();    
var tot=document.getElementById("total").value;
var tip=document.getElementById("pedido").value;
var ho=document.getElementById("hora_pedido").value;
var sub=document.getElementById("Sub").value;

if (ho==""){
    alert ("completa los campos por favor");
}else{
  
xhr6.open("GET","RegistarVenta?tot="+tot+"&tip="+tip+"&hora="+ho+"&sub="+sub,true);
xhr6.onreadystatechange=impMensaje6;
xhr6.send(null);  
}

    
    
} 
function impMensaje6(){
   if (xhr6.readyState==4){
       alert(xhr6.responseText);
         document.getElementById("men2").innerHTML="<table border=1 class=imagetable width=50% id=myTable>"
            +"<thead>"
            +"<tr>"
	   +"<th>Numero</th>"
	   +"<th>Id platillo</th>"    
	   +"<th>Precio</th>"
	   +"<th>Nombre</th>"
	   +"<th>Subtotal</th>"
	   +"<th>IVA</th>"
	   +"<th>Total</th>"
	   +"</tr>"
            +"</thead>"
            +"<tbody id=tbl_bdy>"
	   
	   +"</tbody>"
	   +"</table><br><br>"
	   +"<input type=button id=todo value='Borrar Carrito' onClick=borrarTodo(); />&nbsp;&nbsp;&nbsp;&nbsp;"
	   +"<input type=button id=todo value='Calcular' onClick=getAllRows(); />";
       document.getElementById("men3").innerHTML="";
       document.getElementById("men4").innerHTML="";
document.getElementById("men5").innerHTML="";
    }
}



