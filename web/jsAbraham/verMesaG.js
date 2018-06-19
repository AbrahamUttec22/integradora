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

//////////////////////////////////////////////////////////////////////////77
//////////////////////////////////////////////////////////////////////////77
//////////////////////////////////////////////////////////////////////////77
//////////////////////////////////////////////////////////////////////////77
//////////////////////////////////////////////////////////////////////////77//////////////////////////////////////////////////////////////////////////77//////////////////////////////////////////////////////////////////////////77//////////////////////////////////////////////////////////////////////////77
//////////////////////////////////////////////////////////////////////////77
//////////////////////////////////////////////////////////////////////////77//////////////////////////////////////////////////////////////////////////77
//////////////////////////////////////////////////////////////////////////77
//////////////////////////////////////////////////////////////////////////77
//////////////////////////////////////////////////////////////////////////77

var objeto2;
function crearOb2(){
    if (window.ActiveXObject){
        objeto2= new ActiveXObject("Microsoft.XMLHttp");
       
        
    }else if ((window.XMLHttpRequest) || (typeof  XMLHttpRequest)!=undefined) {
        objeto2=new XMLHttpRequest();
      
    }else{
        alert("Su navegador no soporta AJAX");
        return;
    }
}

function  proceso0(){
    var nombre=document.getElementById("mesa0");
    var nom=nombre.value;
   document.getElementById("datos").innerHTML="Cambiar el estatus de la mesa: "+nom+" a: \n\
<select id='esta'><option>Elige</option><option value='disponible'>DISPONIBLE</option><option value='ocupado'>OCUPADA</option></select> <input type='submit' value='Confirmar' onclick='cam0();'>";

}

function cam0 (){
    crearOb2();
    var nombre=document.getElementById("mesa0");
    var nom=nombre.value;
    var es=document.getElementById("esta");
    var estatus=es.options[es.selectedIndex].value;
    objeto2.open("GET","ActualizarMesa?nom="+nom+"&estatus="+estatus,true);
    objeto2.onreadystatechange;
    objeto2.send(null);
    alert('Estatus cambiado');
    mostrarMesas();
   // location.href="Mesa.jsp";
//    location.reload(true);
}
function cam1 (){
    crearOb2();
    var nombre=document.getElementById("mesa1");
    var nom=nombre.value;
    var es=document.getElementById("esta");
    var estatus=es.options[es.selectedIndex].value;
    objeto2.open("GET","ActualizarMesa?nom="+nom+"&estatus="+estatus,true);
    objeto2.onreadystatechange;
    objeto2.send(null);
    alert('Estatus cambiado');
    mostrarMesas();
   // location.href="Mesa.jsp";
//    location.reload(true);
}
function cam2 (){
    crearOb2();
    var nombre=document.getElementById("mesa2");
    var nom=nombre.value;
    var es=document.getElementById("esta");
    var estatus=es.options[es.selectedIndex].value;
    objeto2.open("GET","ActualizarMesa?nom="+nom+"&estatus="+estatus,true);
    objeto2.onreadystatechange;
    objeto2.send(null);
    alert('Estatus cambiado');
    mostrarMesas();
   // location.href="Mesa.jsp";
//    location.reload(true);
}
function cam3 (){
    crearOb2();
    var nombre=document.getElementById("mesa3");
    var nom=nombre.value;
    var es=document.getElementById("esta");
    var estatus=es.options[es.selectedIndex].value;
    objeto2.open("GET","ActualizarMesa?nom="+nom+"&estatus="+estatus,true);
    objeto2.onreadystatechange;
    objeto2.send(null);
    alert('Estatus cambiado');
    mostrarMesas();
   // location.href="Mesa.jsp";
//    location.reload(true);
}
function cam4 (){
    crearOb2();
    var nombre=document.getElementById("mesa4");
    var nom=nombre.value;
    var es=document.getElementById("esta");
    var estatus=es.options[es.selectedIndex].value;
    objeto2.open("GET","ActualizarMesa?nom="+nom+"&estatus="+estatus,true);
    objeto2.onreadystatechange;
    objeto2.send(null);
    alert('Estatus cambiado');
    mostrarMesas();
   // location.href="Mesa.jsp";
//    location.reload(true);
}
function cam5 (){
    crearOb2();
    var nombre=document.getElementById("mesa5");
    var nom=nombre.value;
    var es=document.getElementById("esta");
    var estatus=es.options[es.selectedIndex].value;
    objeto2.open("GET","ActualizarMesa?nom="+nom+"&estatus="+estatus,true);
    objeto2.onreadystatechange;
    objeto2.send(null);
    alert('Estatus cambiado');
    mostrarMesas();
   // location.href="Mesa.jsp";
//    location.reload(true);
}
function cam6 (){
    crearOb2();
    var nombre=document.getElementById("mesa6");
    var nom=nombre.value;
    var es=document.getElementById("esta");
    var estatus=es.options[es.selectedIndex].value;
    objeto2.open("GET","ActualizarMesa?nom="+nom+"&estatus="+estatus,true);
    objeto2.onreadystatechange;
    objeto2.send(null);
    alert('Estatus cambiado');
    mostrarMesas();
   // location.href="Mesa.jsp";
//    location.reload(true);
}
function cam7 (){
    crearOb2();
    var nombre=document.getElementById("mesa7");
    var nom=nombre.value;
    var es=document.getElementById("esta");
    var estatus=es.options[es.selectedIndex].value;
    objeto2.open("GET","ActualizarMesa?nom="+nom+"&estatus="+estatus,true);
    objeto2.onreadystatechange;
    objeto2.send(null);
    alert('Estatus cambiado');
    mostrarMesas();
   // location.href="Mesa.jsp";
//    location.reload(true);
}
function cam8 (){
    crearOb2();
    var nombre=document.getElementById("mesa8");
    var nom=nombre.value;
    var es=document.getElementById("esta");
    var estatus=es.options[es.selectedIndex].value;
    objeto2.open("GET","ActualizarMesa?nom="+nom+"&estatus="+estatus,true);
    objeto2.onreadystatechange;
    objeto2.send(null);
    alert('Estatus cambiado');
    mostrarMesas();
   // location.href="Mesa.jsp";
//    location.reload(true);
}
function cam9 (){
    crearOb2();
    var nombre=document.getElementById("mesa9");
    var nom=nombre.value;
    var es=document.getElementById("esta");
    var estatus=es.options[es.selectedIndex].value;
    objeto2.open("GET","ActualizarMesa?nom="+nom+"&estatus="+estatus,true);
    objeto2.onreadystatechange;
    objeto2.send(null);
    alert('Estatus cambiado');
    mostrarMesas();
   // location.href="Mesa.jsp";
//    location.reload(true);
}
function cam10 (){
    crearOb2();
    var nombre=document.getElementById("mesa10");
    var nom=nombre.value;
    var es=document.getElementById("esta");
    var estatus=es.options[es.selectedIndex].value;
    objeto2.open("GET","ActualizarMesa?nom="+nom+"&estatus="+estatus,true);
    objeto2.onreadystatechange;
    objeto2.send(null);
    alert('Estatus cambiado');
    mostrarMesas();
   // location.href="Mesa.jsp";
//    location.reload(true);
}
function cam11 (){
    crearOb2();
    var nombre=document.getElementById("mesa11");
    var nom=nombre.value;
    var es=document.getElementById("esta");
    var estatus=es.options[es.selectedIndex].value;
    objeto2.open("GET","ActualizarMesa?nom="+nom+"&estatus="+estatus,true);
    objeto2.onreadystatechange;
    objeto2.send(null);
    alert('Estatus cambiado');
    mostrarMesas();
   // location.href="Mesa.jsp";
//    location.reload(true);
}
function cam12 (){
    crearOb2();
    var nombre=document.getElementById("mesa12");
    var nom=nombre.value;
    var es=document.getElementById("esta");
    var estatus=es.options[es.selectedIndex].value;
    objeto2.open("GET","ActualizarMesa?nom="+nom+"&estatus="+estatus,true);
    objeto2.onreadystatechange;
    objeto2.send(null);
    alert('Estatus cambiado');
    mostrarMesas();
   // location.href="Mesa.jsp";
//    location.reload(true);
}
function cam13 (){
    crearOb2();
    var nombre=document.getElementById("mesa13");
    var nom=nombre.value;
    var es=document.getElementById("esta");
    var estatus=es.options[es.selectedIndex].value;
    objeto2.open("GET","ActualizarMesa?nom="+nom+"&estatus="+estatus,true);
    objeto2.onreadystatechange;
    objeto2.send(null);
    alert('Estatus cambiado');
    mostrarMesas();
   // location.href="Mesa.jsp";
//    location.reload(true);
}
function cam14 (){
    crearOb2();
    var nombre=document.getElementById("mesa14");
    var nom=nombre.value;
    var es=document.getElementById("esta");
    var estatus=es.options[es.selectedIndex].value;
    objeto2.open("GET","ActualizarMesa?nom="+nom+"&estatus="+estatus,true);
    objeto2.onreadystatechange;
    objeto2.send(null);
    alert('Estatus cambiado');
    mostrarMesas();
   // location.href="Mesa.jsp";
//    location.reload(true);
}
function cam15 (){
    crearOb2();
    var nombre=document.getElementById("mesa15");
    var nom=nombre.value;
    var es=document.getElementById("esta");
    var estatus=es.options[es.selectedIndex].value;
    objeto2.open("GET","ActualizarMesa?nom="+nom+"&estatus="+estatus,true);
    objeto2.onreadystatechange;
    objeto2.send(null);
    alert('Estatus cambiado');
    mostrarMesas();
   // location.href="Mesa.jsp";
//    location.reload(true);
}
function cam16 (){
    crearOb2();
    var nombre=document.getElementById("mesa16");
    var nom=nombre.value;
    var es=document.getElementById("esta");
    var estatus=es.options[es.selectedIndex].value;
    objeto2.open("GET","ActualizarMesa?nom="+nom+"&estatus="+estatus,true);
    objeto2.onreadystatechange;
    objeto2.send(null);
    alert('Estatus cambiado');
    mostrarMesas();
   // location.href="Mesa.jsp";
//    location.reload(true);
}
function cam17 (){
    crearOb2();
    var nombre=document.getElementById("mesa17");
    var nom=nombre.value;
    var es=document.getElementById("esta");
    var estatus=es.options[es.selectedIndex].value;
    objeto2.open("GET","ActualizarMesa?nom="+nom+"&estatus="+estatus,true);
    objeto2.onreadystatechange;
    objeto2.send(null);
    alert('Estatus cambiado');
    mostrarMesas();
   // location.href="Mesa.jsp";
//    location.reload(true);
}
function cam18 (){
    crearOb2();
    var nombre=document.getElementById("mesa18");
    var nom=nombre.value;
    var es=document.getElementById("esta");
    var estatus=es.options[es.selectedIndex].value;
    objeto2.open("GET","ActualizarMesa?nom="+nom+"&estatus="+estatus,true);
    objeto2.onreadystatechange;
    objeto2.send(null);
    alert('Estatus cambiado');
    mostrarMesas();
   // location.href="Mesa.jsp";
//    location.reload(true);
}
function cam19 (){
    crearOb2();
    var nombre=document.getElementById("mesa19");
    var nom=nombre.value;
    var es=document.getElementById("esta");
    var estatus=es.options[es.selectedIndex].value;
    objeto2.open("GET","ActualizarMesa?nom="+nom+"&estatus="+estatus,true);
    objeto2.onreadystatechange;
    objeto2.send(null);
    alert('Estatus cambiado');
    mostrarMesas();
   // location.href="Mesa.jsp";
//    location.reload(true);
}













function  proceso1(){
    var nombre=document.getElementById("mesa1");
    var nom=nombre.value;

     document.getElementById("datos").innerHTML="Cambiar el estatus de la mesa: "+nom+" a: \n\
<select id='esta'><option>Elige</option><option value='disponible'>DISPONIBLE</option><option value='ocupado'>OCUPADA</option></select> <input type='submit' value='Confirmar' onclick='cam1();'>";

}
function  proceso2(){
    var nombre=document.getElementById("mesa2");
    var nom=nombre.value;
    document.getElementById("datos").innerHTML="Cambiar el estatus de la mesa: "+nom+" a: \n\
<select id='esta'><option>Elige</option><option value='disponible'>DISPONIBLE</option><option value='ocupado'>OCUPADA</option></select> <input type='submit' value='Confirmar' onclick='cam2();'>";

}
function  proceso3(){
    var nombre=document.getElementById("mesa3");
    var nom=nombre.value;
    document.getElementById("datos").innerHTML="Cambiar el estatus de la mesa: "+nom+" a: \n\
<select id='esta'><option>Elige</option><option value='disponible'>DISPONIBLE</option><option value='ocupado'>OCUPADA</option></select> <input type='submit' value='Confirmar' onclick='cam3();'>";


}
function  proceso4(){
    var nombre=document.getElementById("mesa4");
    var nom=nombre.value;
   document.getElementById("datos").innerHTML="Cambiar el estatus de la mesa: "+nom+" a: \n\
<select id='esta'><option>Elige</option><option value='disponible'>DISPONIBLE</option><option value='ocupado'>OCUPADA</option></select> <input type='submit' value='Confirmar' onclick='cam4();'>";

}
function  proceso5(){
    var nombre=document.getElementById("mesa5");
    var nom=nombre.value;
    document.getElementById("datos").innerHTML="Cambiar el estatus de la mesa: "+nom+" a: \n\
<select id='esta'><option>Elige</option><option value='disponible'>DISPONIBLE</option><option value='ocupado'>OCUPADA</option></select> <input type='submit' value='Confirmar' onclick='cam5();'>";

}
function  proceso6(){
    var nombre=document.getElementById("mesa6");
    var nom=nombre.value;
   document.getElementById("datos").innerHTML="Cambiar el estatus de la mesa: "+nom+" a: \n\
<select id='esta'><option>Elige</option><option value='disponible'>DISPONIBLE</option><option value='ocupado'>OCUPADA</option></select> <input type='submit' value='Confirmar' onclick='cam6();'>";

}
function  proceso7(){
    var nombre=document.getElementById("mesa7");
    var nom=nombre.value;
   document.getElementById("datos").innerHTML="Cambiar el estatus de la mesa: "+nom+" a: \n\
<select id='esta'><option>Elige</option><option value='disponible'>DISPONIBLE</option><option value='ocupado'>OCUPADA</option></select> <input type='submit' value='Confirmar' onclick='cam7();'>";

}
function  proceso8(){
    var nombre=document.getElementById("mesa8");
    var nom=nombre.value;
   document.getElementById("datos").innerHTML="Cambiar el estatus de la mesa: "+nom+" a: \n\
<select id='esta'><option>Elige</option><option value='disponible'>DISPONIBLE</option><option value='ocupado'>OCUPADA</option></select> <input type='submit' value='Confirmar' onclick='cam8();'>";

}
function  proceso9(){
    var nombre=document.getElementById("mesa9");
    var nom=nombre.value;
    document.getElementById("datos").innerHTML="Cambiar el estatus de la mesa: "+nom+" a: \n\
<select id='esta'><option>Elige</option><option value='disponible'>DISPONIBLE</option><option value='ocupado'>OCUPADA</option></select> <input type='submit' value='Confirmar' onclick='cam9();'>";

}
function  proceso10(){
    var nombre=document.getElementById("mesa10");
    var nom=nombre.value;
   document.getElementById("datos").innerHTML="Cambiar el estatus de la mesa: "+nom+" a: \n\
<select id='esta'><option>Elige</option><option value='disponible'>DISPONIBLE</option><option value='ocupado'>OCUPADA</option></select> <input type='submit' value='Confirmar' onclick='cam10();'>";

}
function  proceso11(){
    var nombre=document.getElementById("mesa11");
    var nom=nombre.value;
 
   document.getElementById("datos").innerHTML="Cambiar el estatus de la mesa: "+nom+" a: \n\
<select id='esta'><option>Elige</option><option value='disponible'>DISPONIBLE</option><option value='ocupado'>OCUPADA</option></select> <input type='submit' value='Confirmar' onclick='cam11();'>";

}
function  proceso12(){
    var nombre=document.getElementById("mesa12");
    var nom=nombre.value;
   document.getElementById("datos").innerHTML="Cambiar el estatus de la mesa: "+nom+" a: \n\
<select id='esta'><option>Elige</option><option value='disponible'>DISPONIBLE</option><option value='ocupado'>OCUPADA</option></select> <input type='submit' value='Confirmar' onclick='cam12();'>";

}
function  proceso13(){
    var nombre=document.getElementById("mesa13");
    var nom=nombre.value;
    document.getElementById("datos").innerHTML="Cambiar el estatus de la mesa: "+nom+" a: \n\
<select id='esta'><option>Elige</option><option value='disponible'>DISPONIBLE</option><option value='ocupado'>OCUPADA</option></select> <input type='submit' value='Confirmar' onclick='cam13();'>";

}
function  proceso14(){
    var nombre=document.getElementById("mesa14");
    var nom=nombre.value;
    document.getElementById("datos").innerHTML="Cambiar el estatus de la mesa: "+nom+" a: \n\
<select id='esta'><option>Elige</option><option value='disponible'>DISPONIBLE</option><option value='ocupado'>OCUPADA</option></select> <input type='submit' value='Confirmar' onclick='cam14();'>";

}
function  proceso15(){
    var nombre=document.getElementById("mesa15");
    var nom=nombre.value;
   document.getElementById("datos").innerHTML="Cambiar el estatus de la mesa: "+nom+" a: \n\
<select id='esta'><option>Elige</option><option value='disponible'>DISPONIBLE</option><option value='ocupado'>OCUPADA</option></select> <input type='submit' value='Confirmar' onclick='cam15();'>";

}
function  proceso16(){
    var nombre=document.getElementById("mesa16");
    var nom=nombre.value;
    document.getElementById("datos").innerHTML="Cambiar el estatus de la mesa: "+nom+" a: \n\
<select id='esta'><option>Elige</option><option value='disponible'>DISPONIBLE</option><option value='ocupado'>OCUPADA</option></select> <input type='submit' value='Confirmar' onclick='cam16();'>";

}
function  proceso17(){
    var nombre=document.getElementById("mesa17");
    var nom=nombre.value;
   document.getElementById("datos").innerHTML="Cambiar el estatus de la mesa: "+nom+" a: \n\
<select id='esta'><option>Elige</option><option value='disponible'>DISPONIBLE</option><option value='ocupado'>OCUPADA</option></select> <input type='submit' value='Confirmar' onclick='cam17();'>";

}
function  proceso18(){
    var nombre=document.getElementById("mesa18");
    var nom=nombre.value;
   document.getElementById("datos").innerHTML="Cambiar el estatus de la mesa: "+nom+" a: \n\
<select id='esta'><option>Elige</option><option value='disponible'>DISPONIBLE</option><option value='ocupado'>OCUPADA</option></select> <input type='submit' value='Confirmar' onclick='cam18();'>";

}
function  proceso19(){
    var nombre=document.getElementById("mesa19");
    var nom=nombre.value;
   document.getElementById("datos").innerHTML="Cambiar el estatus de la mesa: "+nom+" a: \n\
<select id='esta'><option>Elige</option><option value='disponible'>DISPONIBLE</option><option value='ocupado'>OCUPADA</option></select> <input type='submit' value='Confirmar' onclick='cam19();'>";

}
