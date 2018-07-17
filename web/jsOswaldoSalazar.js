var xhr,xhr1,xhr2,xhr3,xhr4,xhr5,xhr6,xhr7,xhr8,xhr9,xhr10,xhr11,xhr12;
function crearOswaldo(){
    if(window.ActiveXObject){
        xhr = new ActiveXObject("Microsoft.XMLHttp");
        xhr1 = new ActiveXObject("Microsoft.XMLHttp");xhr2 = new ActiveXObject("Microsoft.XMLHttp");
        xhr3 = new ActiveXObject("Microsoft.XMLHttp");xhr4 = new ActiveXObject("Microsoft.XMLHttp");
        xhr5 = new ActiveXObject("Microsoft.XMLHttp");xhr6 = new ActiveXObject("Microsoft.XMLHttp");
        xhr7 = new ActiveXObject("Microsoft.XMLHttp");xhr8 = new ActiveXObject("Microsoft.XMLHttp");
        xhr9 = new ActiveXObject("Microsoft.XMLHttp");xhr10 = new ActiveXObject("Microsoft.XMLHttp");
        xhr11 = new ActiveXObject("Microsoft.XMLHttp");xhr12 = new ActiveXObject("Microsoft.XMLHttp");
    }else if((window.XMLHttpRequest) || (typeof XMLHttpRequest)!=undefined){
        xhr = new XMLHttpRequest();
        xhr1 = new XMLHttpRequest();xhr2 = new XMLHttpRequest();xhr3 = new XMLHttpRequest();
        xhr4 = new XMLHttpRequest();xhr5 = new XMLHttpRequest();xhr6 = new XMLHttpRequest();
        xhr7 = new XMLHttpRequest();xhr8 = new XMLHttpRequest();xhr9 = new XMLHttpRequest();
        xhr10 = new XMLHttpRequest();xhr11 = new XMLHttpRequest();xhr12 = new XMLHttpRequest();
    }else{
        alert("Su navegador no soporta AJAX");
        return;
    }
}
function login()
{
    crearOswaldo();
    var usuario = document.getElementById("uname").value;
    var password = document.getElementById("psw").value;
    alert("usuario "+usuario+" password "+password+"dfghjkl");
    xhr.open("POST", "inicial", true);
    xhr.onreadystatechange=respuestaLogin;
    xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded');
    xhr.send("uno="+usuario+"&dos="+password);
}
function respuestaLogin()
{
    if(xhr.readyState == 4){         
        location.href=xhr.responseText;        
     }
}
function formDeRegistroCliente()
{
    document.getElementById("").innerHTML="";
}

/////////////////////////////////////////////////////////////////////////////////////////////77

function verOrdenesOswaldo()
{
    crearOswaldo();
    //var id_usuario = document.getElementById("IdCocinero").value;
    var estado=document.getElementById("estado").value;
    alert("RECUPERA: "+ estado);
    xhr3.open("POST", "ServMostrarOrdenes", true);
    xhr3.onreadystatechange=RespuestaVerOrdenesOswaldo;
    xhr3.setRequestHeader('Content-type','application/x-www-form-urlencoded');
    xhr3.send("dos="+estado);
//    alert("Envia "+ estado);
}
function RespuestaVerOrdenesOswaldo()
{   
    if(xhr3.readyState == 4){ 
//        alert("Entra al if "+ xhr3.responseText);
        document.getElementById("lista").innerHTML="<br><br><br>"+xhr3.responseText;     
//        alert("termina de imprimir"+xhr3.responseText);
     }
}
function CambiarEstadoOswaldo()
{
    crearOswaldo();
    //alert("CambiarEstado");
    var id= document.getElementById("idLista").value;
    var estado=document.getElementById("estado").value;
    //alert("id de la lista: "+id+" - estatus: "+estado);
    xhr4.open("POST", "ServCambiarEstado", true);
    xhr4.onreadystatechange=RespuestaCambiarEstadoOswaldo;
    xhr4.setRequestHeader('Content-type','application/x-www-form-urlencoded');
    xhr4.send("uno="+id+"&dos="+estado);
}
function RespuestaCambiarEstadoOswaldo()
{
    alert("Antes de entrar al if");
    if(xhr4.readyState == 4){ 
        //alert("RESPUESTA DEL SERVLET: "+xhr4.responseText);
        location.reload(true);
     }
}
function verOrdenesOswaldo2()
{
    crearOswaldo();
    //var id_usuario = document.getElementById("IdCocinero").value;
    var estado=document.getElementById("estado").value;
    alert("RECUPERA: "+ estado);
    xhr5.open("POST", "ServMostrarOrdenes2", true);
    xhr5.onreadystatechange=RespuestaVerOrdenesOswaldo2;
    xhr5.setRequestHeader('Content-type','application/x-www-form-urlencoded');
    xhr5.send("dos="+estado);
//    alert("Envia "+ estado);
}
function RespuestaVerOrdenesOswaldo2()
{   
    if(xhr5.readyState == 4){ 
//      alert("Entra al if "+ xhr3.responseText);
        document.getElementById("lista").innerHTML="<br><br><br>"+xhr5.responseText;     
//      alert("termina de imprimir"+xhr3.responseText);
     }
}
function MostrarEmpleadosDispoiblesyOrdenesListas()
{
    alert("Entra");
    crearOswaldo();
    xhr6.open("GET", "ServAsignarRepartidro", true);
    xhr6.onreadystatechange=ResMostrarEmpleadosDispoiblesyOrdenesListas;
    xhr6.send(null);
}
function ResMostrarEmpleadosDispoiblesyOrdenesListas()
{
   if(xhr6.readyState == 4){ 
        document.getElementById("lista").innerHTML="<br>"+xhr6.responseText+"<br><br><input type='button' value='Asignar repartidor' onclick='AsignarRepartidor();'>";     
     }
}
function BuscarDireccionCliente()
{
    crearOswaldo();
    var p = document.getElementById("IdOrden");
    var idOrden = p.options[p.selectedIndex].value;
    var pp = document.getElementById("idEmpleado");
    var idEmpleado = pp.options[pp.selectedIndex].value;
    alert("RECUEPRA: "+idOrden +" - "+idEmpleado);
    xhr7.open("POST", "ServAsignarRepartidro", true);
    xhr7.onreadystatechange=ResBuscarDireccionCliente;
    xhr7.setRequestHeader('Content-type','application/x-www-form-urlencoded');
    xhr7.send("uno="+idOrden);
}
function ResBuscarDireccionCliente()
{
    if(xhr7.readyState == 4){ 
        alert("entra al if");
        document.getElementById("direccion").innerHTML="<br>Direccion del cliente:  "+xhr7.responseText;     
     }
}
function AsignarRepartidor()
{
    alert("Entra")
    crearOswaldo();
    var p = document.getElementById("IdOrden");
    var idOrden = p.options[p.selectedIndex].value;
    var pp = document.getElementById("idEmpleado");
    var idEmpleado = pp.options[pp.selectedIndex].value;
    if(idOrden == 0 || idEmpleado == 0)
    {
        alert("Selecciona una opcion");
    }else{   
    alert("RECUEPRA: "+idOrden +" - "+idEmpleado);
    xhr8.open("POST", "ServActualizarCliente", true);
    xhr8.onreadystatechange=RespuestaAsignarRepartidor;
    xhr8.setRequestHeader('Content-type','application/x-www-form-urlencoded');
    xhr8.send("uno="+idOrden+"&dos="+idEmpleado);
    }
}
function RespuestaAsignarRepartidor()
{
    if(xhr8.readyState == 4){ 
        alert("Se asignao al repartidor la orden");
        location.reload(true);
     }
}