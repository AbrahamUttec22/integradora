var xhr;
function crear3(){
    if(window.ActiveXObject){
        xhr = new ActiveXObject("Microsoft.XMLHttp");      
    }else if((window.XMLHttpRequest) || (typeof XMLHttpRequest)!=undefined){
        xhr = new XMLHttpRequest();
    }else{
        alert("Su navegador no soporta AJAX");
        return;
    }
}

function MostrarOpciones(){
    var opc = document.opciones.opc.value;
    crear3();
    xhr.open("GET", "MostrarOpciones?opc="+opc, true);
        xhr.onreadystatechange=RespuestaMostrar;  
xhr.send(null);
}

function RespuestaMostrar(){
        if(xhr.readyState==4){
        document.getElementById("detallepaquetes").innerHTML=xhr.responseText;
        }
}

function GenerarCotizacion(){
    alert("entro a generar");
    var idPaquete=document.paquetes.opcPaquete.value;
    var idCliente=document.getElementById("idCliente").value;
    xhr.open("GET", "GenerarCotizaciones?idPaquete="+idPaquete+"&idCliente="+idCliente, true);
        xhr.onreadystatechange=RespuestaCotizacion;  
xhr.send(null);
}

function RespuestaCotizacion(){
    if(xhr.readyState==4){
        alert(xhr.responseText+" Su cotizacion se guardo con exito");
        var idCliente=document.getElementById("idCliente").value;
        document.getElementById("detallepaquetes").innerHTML="<a href=CotizarPedidos?usuario="+idCliente+" target=_blank>Descargar Cotización</a>";
        }
}

function MostrarPlatillo(){
    var opc= document.paquetes.platillo.value;
    crear3();
    xhr.open("POST", "GenerarCotizaciones", true);
        xhr.onreadystatechange=RespuestaPlatillos;  
        xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
xhr.send("opcPlatillo="+opc);
}

function RespuestaPlatillos(){
    if(xhr.readyState==4){
        document.getElementById("MostrarPlatillo").innerHTML=xhr.responseText;
        document.getElementById("MostrarCarrito").innerHTML="<table width=100% id=Carrito><th>Numero</th><th>Nombre</th>\n\
<th>Precio</th><th>Cantidad</th><th>Subtotal</th><tbody id=cuerpo_tabla></tbody></table>";
        }
}

function AgregarCarrito(platillo){
    var x = document.getElementById("Carrito").getElementsByTagName("tr").length;
    var can=document.getElementById("cantidad"+platillo).value;
    crear3();
    xhr.open("POST", "AgregarAlCarrito", true);
        xhr.onreadystatechange=RespuestaAgregar;  
        xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded');        
xhr.send("platillo="+platillo+"&x="+x+"&can="+can);
//alert("carrito");
//agregarfila([1,"hola",13,1,98]);
}

function RespuestaAgregar(){
    if(xhr.readyState==4){
        agregarfila([xhr.responseText]);  
        }
}

function agregarfila(datos){
    alert(datos);
    var tr=document.createElement('tr');
                var lon=datos.length;
                for(var i=0;i<lon;i++){
                    alert(lon);
                    var td=document.createElement('td');
                    td.appendChild(document.createTextNode(datos[i]));
                    tr.appendChild(td);
                }
                document.getElementById('cuerpo_tabla').appendChild(tr);
             return true;
}

function HacerPedido(){
    var idPaquete=document.paquetes.opcPaquete.value;
    var idCliente=document.getElementById("idCliente").value;
    xhr.open("GET", "HacerPedido?idPaquete="+idPaquete+"&idCliente="+idCliente, true);
        xhr.onreadystatechange=RespuestaHacerPedido;  
xhr.send(null);
}

function RespuestaHacerPedido(){
    if(xhr.readyState==4){
        document.getElementById("detallepaquetes").innerHTML=xhr.responseText;
        }
}

function CalcularPagos(){
    var fecha=document.getElementById("fechaevento").value;
    var precio=document.getElementById("total").value;
 crear3();
    xhr.open("POST", "HacerPedido", true);
        xhr.onreadystatechange=RespuestaCalcular;  
        xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded');        
xhr.send("fecha="+fecha+"&total="+precio);
}

function RespuestaCalcular(){
    if(xhr.readyState==4){
        document.getElementById("respuestaPedido").innerHTML=xhr.responseText;
        }
    }
    
    function ConfirmarCompra(){
        var idPaquete = document.getElementById("idPaquete").value;
        var idUsuario = document.getElementById("idCliente").value;
        var fecha = document.getElementById("fechaevento").value;
        var hora = document.getElementById("horaevento").value;
        var personas = document.getElementById("personas").value;
        var subtotal = document.getElementById("subtotal").value;
        var desc = document.getElementById("descuento").value;
        var total = document.getElementById("total").value;
        if (desc==""){
            desc =0;
        }
         xhr.open("GET", "ConfirmarPedido?paquete="+idPaquete+"&usuario="+idUsuario+"&fecha="+fecha+"&hora="+hora+"&personas="+personas+"&sub="+subtotal+"&desc="+desc, true);
        xhr.onreadystatechange=RespuestaCalcular;      
xhr.send(null);
    }