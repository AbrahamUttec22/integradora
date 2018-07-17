var xhr, xhr1, xhr2;
function crear2(){
    if(window.ActiveXObject){
        xhr = new ActiveXObject("Microsoft.XMLHttp");
        xhr1 = new ActiveXObject("Microsoft.XMLHttp");
        xhr2 = new ActiveXObject("Microsoft.XMLHttp");       
    }else if((window.XMLHttpRequest) || (typeof XMLHttpRequest)!=undefined){
        xhr = new XMLHttpRequest();
        xhr1 = new XMLHttpRequest();
        xhr2 = new XMLHttpRequest();
    }else{
        alert("Su navegador no soporta AJAX");
        return;
    }
}
function RegistrarPaquete(){
//    crearObjeto();    
    document.getElementById("mostrar").style.display='none';
    document.getElementById("detallePaquetes").innerHTML="<form align=center name=registrar>\n\
Nombre:&nbsp&nbsp<input type=text id=NombrePaquete required/><br/><br/>\n\
Precio:&nbsp&nbsp<input type=text id=PrecioPaquete required=/><br/><br/>\n\
Descripción:&nbsp&nbsp<input type=text id=DescripcionPaquete required=/><br/><br/>\n\
Imagen:&nbsp&nbsp<input type=file id=ImagenPaquete required=/><br/><br/>\n\
<input type=button value=Registrar onclick=GuardarPaquete();>\n\
<input type=button value=Cancelar onclick=Mostrar();></form>";    
}

function GuardarPaquete(){        
    var nom= document.getElementById("NombrePaquete").value;
    var pre= document.getElementById("PrecioPaquete").value;
    var des= document.getElementById("DescripcionPaquete").value;
    var ima= document.getElementById("ImagenPaquete").value;
    var i= ima.substring(12);
    alert(nom+" "+pre+" "+des+" "+i);
    crear2();
xhr.open("GET", "RegistrarPaquete?nom="+nom+"&pre="+pre+"&desc="+des+"&imagen="+i, true);
        xhr.onreadystatechange=RespuestaRegistrar;  
xhr.send(null);
}

function RespuestaRegistrar(){
    if(xhr.readyState==4){
        alert(xhr.responseText);
        location.reload(true);
        }
}

function ActualizarPaquete(id){
    document.getElementById("mostrar").style.display='none';
        crear2();   
   xhr.open("GET", "ActualizarPaquete?id="+id, true);
        xhr.onreadystatechange=RespuestaActualizar;  
xhr.send(null);
}

function RespuestaActualizar(){
    if(xhr.readyState==4){ 
        document.getElementById("detallePaquetes").innerHTML=xhr.responseText;
        }
}

function Mostrar(){
   location.reload(true);
}

function GuardarCambios(){
    var nom = document.getElementById("nombre").value;
    var pre = document.getElementById("pre").value;
    var desc = document.getElementById("desc").value;
    crear2();
    xhr.open("POST", "ActualizarPaquete", true);
        xhr.onreadystatechange=RespuestaGuardarCambios;  
        xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
xhr.send("nombre="+nom+"&pre="+pre+"&desc="+desc);
}

function RespuestaGuardarCambios(){
    if(xhr.readyState==4){ 
        alert("guardar");
        alert(xhr.responseText);
        location.reload(true);
        }
}

function Eliminar(x){
    var opc = document.eliminar.opc.value;
   crear2();   
   xhr.open("GET", "EliminarPaquete?id="+x+"&opc="+opc, true);
        xhr.onreadystatechange=RespuestaEliminar;  
xhr.send(null);
}
function RespuestaEliminar(){
    if(xhr.readyState==4){ 
        alert(xhr.responseText);
        location.reload(true);
        }
}
function EliminarPaquetes(id){
    document.getElementById("mostrar").style.display='none';
   document.getElementById("detallePaquetes").innerHTML="<form name=eliminar align=center>\n\
<br/><br/>¿Seguro que desea eliminar?\n\
<br/><br/><input type=radio value=si name=opc onclick=Eliminar("+id+");>&nbsp SI\n\
<br/><br/><input type=radio value=no name=opc onclick=Eliminar("+id+");>&nbsp NO</form>"
}