var objeto;
var objeto2;
var objeto3;
var objeto4;
var objeto5;
function crearObjeto(){
    if (window.ActiveXObject){
        objeto= new ActiveXObject("Microsoft.XMLHttp");
        objeto2= new ActiveXObject("Microsoft.XMLHttp");
         objeto3= new ActiveXObject("Microsoft.XMLHttp");
         objeto4= new ActiveXObject("Microsoft.XMLHttp");
         objeto5= new ActiveXObject("Microsoft.XMLHttp");
        
    }else if ((window.XMLHttpRequest) || (typeof  XMLHttpRequest)!=undefined) {
        objeto=new XMLHttpRequest();
          objeto2=new XMLHttpRequest();
      objeto3=new XMLHttpRequest();
      objeto4=new XMLHttpRequest();
      objeto5=new XMLHttpRequest();
    }else{
        alert("Su navegador no soporta AJAX");
        return;
    }
}

            function generarPdf(){
                crearObjeto();
 var fdata=new FormData(document.getElementById("fo"));
 objeto2.open("POST","reservachica",true);
  objeto2.onreadystatechange=im;
//objeto2.setRequestHeader('Content-type','multipart/form-data','application/x-www-form-urlencoded');
  objeto2.send(fdata);

   }
        function im(){
   if (objeto2.readyState==4){
       alert(objeto2.responseText);
    }
}    
          

