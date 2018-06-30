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
              document.getElementById("imprimirselectconsultaabraham").innerHTML="<center>"
    +"<form enctype='multipart/form-data' id='formu'>"//importante para guardar imagenes y datos
    +"<input class=input type=text placeholder=Nombre  autofocus name=nombre id=nombre><br><br>"
    +"<input class=input type=text placeholder=Apellido Paterno  name=apellido_p id=apellido_p><br><br>"
    +"<input class=input type=text placeholder=Apellido Materno  name=apellido_m id=apellido_m><br><br>"
    +"<input class=input type=text placeholder=RFC  name=rfc id=rfc><br><br> "                  
    +"<input class=input type=text placeholder=Telefono name=telefono id=telefono><br><br>"
 +"<input class=input type=text placeholder=Direccion name=direccion id=direccion><br><br>"
 
 +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Foto<input class=input type=file  placeholder=Imagen name=imagen id=imagen><br><br>"
 +"<select id=tipo name=tipo class=input><br><br>"
      +"<option  > Tipo de empleado</option>  "
      +"<option value=cocinero> Cocinero</option>"     
      +"<option value=repartidor> Repartidor</option>  "
  +"</select>"
  +"<br><br><input class=input type=text placeholder=Usuario name=usuario id=usuario><br><br>"
+"<input class=input type=password placeholder=Contraseña  name=contrasena id=contrasena><br><br>"
+"<input class=btn__submit type=button value=REGISTRAR onclick=RegistraA();>"
+"</form>";//cierre de form
+"</center>";
                document.getElementById("respuestaabraham").innerHTML="";
    }else if (radios[2].checked){
           document.getElementById("imprimirselectconsultaabraham").innerHTML="<center>"
+"Ingresa el rfc del empleado<input type=text id=rfc2>&nbsp;<input type=submit  onclick=consultaactualiza();>"
+"</center>";
           
document.getElementById("respuestaabraham").innerHTML="";
//
    }else if (radios[3].checked){////
document.getElementById("imprimirselectconsultaabraham").innerHTML="<center>"
+"Ingresa el rfc del empleado<input type=text id=rfc>&nbsp;<input type=submit value=busca onclick=consultaeliminado();>"
+"</center>";
 document.getElementById("respuestaabraham").innerHTML="";
    }
}

///////////////////////CONSULTAS//////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////
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
///////////////////////ELIMINAR//////////////////////////////////////////////////
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

///////////////////////////////REGISTRAR//////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////


function RegistraA(){//aqui enviamos todo el formulario anterior
  var fdata=new FormData(document.getElementById("formu"));
  objeto2.open("POST","RegistrarE",true);
  objeto2.onreadystatechange=imprimirRegistro;
//objeto2.setRequestHeader('Content-type','multipart/form-data','application/x-www-form-urlencoded');
  objeto2.send(fdata);

}

function imprimirRegistro(){
   if (objeto2.readyState==4){
       alert(objeto2.responseText);
    }
}

///////////////////////////////ACTUALIZAR//////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////
function consultaactualiza(){
  var rfc=document.getElementById("rfc2").value;
 objeto3.open("GET","ConsultaActualiza?rfc="+rfc,true);
 objeto3.onreadystatechange=imprimirEmpleadoA;
 objeto3.send(null);  
}
function imprimirEmpleadoA(){
   if (objeto3.readyState==4){
       var x=String(objeto3.responseText);
       if (x==1){
         alert("No existe ese empleado");
         document.getElementById("respuestaabraham").innerHTML="<br><br>";
       }else{
             document.getElementById("respuestaabraham").innerHTML="<br><br>"+objeto3.responseText+"";
    
       }
  
    }
}

function actulizaEm(){
 var fdata=new FormData(document.getElementById("formuAc"));
 objeto4.open("POST","ActualizarG",true);
 objeto4.onreadystatechange=mostrarmens;
 objeto4.send(fdata);  
}
function mostrarmens(){
   if (objeto4.readyState==4){
         alert("Datos actualizados");
         document.getElementById("respuestaabraham").innerHTML="<br><br>";
       
    }
}