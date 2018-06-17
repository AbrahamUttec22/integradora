var objeto;
function crearOb(){
    if (window.ActiveXObject){
        objeto= new ActiveXObject("Microsoft.XMLHttp");
       
        
    }else if ((window.XMLHttpRequest) || (typeof  XMLHttpRequest)!=undefined) {
        objeto=new XMLHttpRequest();
      
    }else{
        alert("Su navegador no soporta AJAX");
        return;
    }
}

function mostrarMesas(){
    crearOb();
    mandarV();
    
}

function mandarV(){
    try {
    var tip=document.getElementById("tipo");
    var tipo=tip.options[tip.selectedIndex].value;
    objeto.open("GET","MesaGerente?tipo="+tipo,true);
    objeto.onreadystatechange=imprimirMesa;
    objeto.send(null);  
    } catch (e) {
        print("el error"+e);
    }

   
}

function  imprimirMesa(){
    if (objeto.readyState==4){
        document.getElementById("mostrar").innerHTML=""+objeto.responseText+"";
    }
   
}



