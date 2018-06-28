var objeto;
var objeto2;
var objeto3;
function instanciar(){
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

function ConsultaGerente(){
    instanciar();
    var radios=document.getElementsByName("Aempleado");
    if (radios[0].checked){
    document.getElementById("imprimirselectconsultaabraham").innerHTML="<center>Tipo empleado <select class=input  id=consultaE onchange=consultaempleado();>"
       +" <option value=0> Elige</option>"
        +"<option value=1> Cocinero</option>"
        +"<option value=2> Repartidor</option>" 
        +"<option value=3> Eliminados</option> "
        +"<option value=4> Todos</option>"
        + "  </select>  </center>  ";
    document.getElementById("respuestaabraham").innerHTML="";
    }else if (radios[1].checked){
              document.getElementById("imprimirselectconsultaabraham").innerHTML="<center>Tipo empleado <select class=input  id=consultaE onchange=consultaempleado();>"
       +" <option value=0> Elige</option>"
        +"<option value=1> Cocinero</option>"
        +"<option value=2> Repartidor</option>" 
        +"<option value=3> Eliminados</option> "
        +"<option value=4> Todos</option>"
        + "  </select>  </center>  ";
                document.getElementById("respuestaabraham").innerHTML="";
    }else if (radios[2].checked){
           document.getElementById("imprimirselectconsultaabraham").innerHTML="<center>Tipo empleado <select class=input  id=consultaE onchange=consultaempleado();>"
       +" <option value=0> Elige</option>"
        +"<option value=1> Cocinero</option>"
        +"<option value=2> Repartidor</option>" 
        +"<option value=3> Eliminados</option> "
        +"<option value=4> Todos</option>"
        + "  </select>  </center>  "; 
document.getElementById("respuestaabraham").innerHTML="";
//
    }else if (radios[3].checked){////
document.getElementById("imprimirselectconsultaabraham").innerHTML="<center>"
+"Ingresa el rfc del empleado<input type=text id=rfc>&nbsp;<input type=submit value=busca onclick=consultaeliminado();>"
+"</center>";
    
                document.getElementById("respuestaabraham").innerHTML="";
    }
}

function consultaempleado(){
  var titulo=document.getElementById("consultaE");
  var tit=titulo.options[titulo.selectedIndex].value;
 objeto.open("GET","ConsultaEmpleado?tit="+tit,true);
 objeto.onreadystatechange=imprimirEmpleados;
 objeto.send(null);  
}
function imprimirEmpleados(){
   if (objeto.readyState==4){
        document.getElementById("respuestaabraham").innerHTML="<br><br>"+objeto.responseText+"";

    }
}
/////////////////////////////////////////////////////////////////////////

function consultaeliminado(){
  var rfc=document.getElementById("rfc").value;
 objeto2.open("GET","eliminarEmpleado?rfc="+rfc,true);
 objeto2.onreadystatechange=imprimirEmpleadoseliminado;
 objeto2.send(null);  
}
function imprimirEmpleadoseliminado(){
   if (objeto2.readyState==4){
       var x=String(objeto2.responseText);
       if (x==1){
         alert("No existe ese empleado");
         document.getElementById("respuestaabraham").innerHTML="<br><br>";
       }else{
             document.getElementById("respuestaabraham").innerHTML="<br><br>"+objeto2.responseText+"";
    
       }
  
    }
}


function eliminarE(){
  var rfc=document.getElementById("rfc").value;
 objeto2.open("GET","eliminarE?rfc="+rfc,true);
 objeto2.onreadystatechange=mostrarmensajeexitoso;
 objeto2.send(null);  
}

function mostrarmensajeexitoso(){
   if (objeto2.readyState==4){

         alert("Empleado dado de baja");
         document.getElementById("respuestaabraham").innerHTML="<br><br>";
       
    }
}

