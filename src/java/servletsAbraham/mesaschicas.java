
package servletsAbraham;

import Conexion.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "mesaschicas", urlPatterns = {"/mesaschicas"})
public class mesaschicas extends HttpServlet {
 
       
  
    ResultSet cdr=null;
    Statement sentenciaSQL=null;
    Conexion conecta= new Conexion();
 
    
  @Override
    public void init(ServletConfig config) throws ServletException {
      super.init(config);
      
      conecta.Conectar();
      sentenciaSQL=conecta.getSentenciaSQL();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
           
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet mesaschicas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet mesaschicas at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          response.setContentType("text/html;charset=UTF-8");
          
  /////////////////////////////////////////////////////////////////7    COPIAR ESTO    
          
     Calendar calendario = Calendar.getInstance();
  int hor =calendario.get(Calendar.HOUR_OF_DAY)+2;
  int minut = calendario.get(Calendar.MINUTE);
  int dia_Calendar=calendario.get(Calendar.DAY_OF_MONTH);
  int mes_Calendar=calendario.get(Calendar.MONTH)+1;
   int ano_Calendar=calendario.get(Calendar.YEAR);
  int dia_fecha=0;
  int mes_fecha=0;
  int ano_fecha=0;
  
  //////////////////////////////////////////////////////////////////        
           String mesas[]={"ch1","ch2","ch3","ch4","ch5","ch6","ch7","ch8","ch9","ch10"};
  String ocupado[]=new String[15];
          int cont=0;
      PrintWriter out= response.getWriter();
       String fecha="",ho="",ho1="",fe="",dia="",mes="",ano="",min1="",hora_b="",minutos_b="",tiempo_b="";
        int hora_sumada=0,hora_restada=0,hora=0,minutos=0,hora_base=0,minutos_base=0;
         fe=request.getParameter("fecha");
         ho=request.getParameter("hora");
         /////////77
         ho1=ho.substring(0,2);//hora
         hora=Integer.parseInt(ho1);//hora
         min1=ho.substring(3,5);
         minutos=Integer.parseInt(min1);//minutos
         /////////////////////////////
         hora_sumada=hora+2;//hora sumada
         hora_restada=hora-2;//hora restada,
         /////////////////////////////////
         dia=fe.substring(8,10);

         mes=fe.substring(5,7);
         ano=fe.substring(0,4);
         dia_fecha=Integer.parseInt(dia);//////////////////copiar esto
         mes_fecha=Integer.parseInt(mes);//////////////////copiar esto
         ano_fecha=Integer.parseInt(ano);//////////////////copiar esto
         fecha=dia+"/"+mes+"/"+ano;
  if (dia_Calendar==dia_fecha && mes_fecha==mes_Calendar && ano_fecha==ano_Calendar){///copiar esto
        
  if (hor==hora && minut<=minutos || hor<hora){// copíar esto 
       

        try {
  final String sql="{call ConsultaMesaDisponible(?,?) }";//declaramos una constante que contendra el nombre del procedimiento almacenado
CallableStatement cs=conecta.getConexion().prepareCall(sql); 
cs.setString(1,fecha);
cs.setString(2,"chicas");
cdr=cs.executeQuery();//usamos executeQuery por que son registros
out.print("<tr>");
        while(cdr.next()){
           
 ///////////////////////////////////      recibir la hora de mis registros en la base     
      tiempo_b=cdr.getString("hora_inicio");  
       hora_b=tiempo_b.substring(0,2);
       minutos_b=tiempo_b.substring(3,5);
       hora_base=Integer.parseInt(hora_b);
       minutos_base=Integer.parseInt(minutos_b);
  ///////////////////////////////////
 
       
  if (hora_base>hora_restada && hora_base<hora_sumada){
       ocupado[cont]=cdr.getString("id_mesa");
  }
  if (hora_base==hora_restada){
      if (minutos_base>=minutos){
          ocupado[cont]=cdr.getString("id_mesa");
      }
  }
  if (hora_base==hora_sumada){
      if (minutos_base<=minutos){
          ocupado[cont]=cdr.getString("id_mesa");
      }
  }

  cont++;
}//  while

        /////////////////////////
   //////////////////////////////AQUI SE PONE 1 EN DONDE SE REPITAN LAS MESAS/////////////////////////////////////////
       for (int i = 0; i < mesas.length; i++) {
           for (int j = 0; j < ocupado.length; j++) {
               if (mesas[i].equals(ocupado[j])){
                   mesas[i]="1";
               }
           }
      }
       //////////////////////////////////////////////
       int contss=1;
           for (int i = 0; i < ocupado.length; i++) {
          if (ocupado[i]!=null){
                if (ocupado[i].equals(ocupado[contss])){
                   ocupado[i]=null;
                  
               }
          }
        
   contss++;
      }
/////////////////
            
 /////////////////////////////////AQUI SE IMPRIMNE/////////////////////////////////////////  
 int num=0;
 out.print("<table>");
  
      for (int i = 0; i < ocupado.length; i++) {
        if(ocupado[i]!=null){
       // out.print("<td>"+ocupado[i]+"</td>");//imprimir ocupado
      
out.print("<td><input  type='submit'  class='chicasOcupadas' value="+ocupado[i]+"></td>");
           
num++;
        }
        if (num==5){
              out.print("<tr>");
        }

    }
    
 for (int i = 0; i < mesas.length; i++) {
             if (num==5){
              out.print("<tr>");
        }
          if (mesas[i]!="1"){
             // out.print("<td>"+mesas[i]+"</td>\n");//imprimir disponible
out.print("<td><input type='button' id='mesas"+i+"' class='chicasDisponibles' value="+mesas[i]+" onclick='cotizar"+i+"();'></td>");
     
               num++;
          }
   }  
 
    out.print("</table><br><br><br><br>"); 
    
     
    out.close();
           
        } catch (Exception e) {
            System.out.println("error"+e);
        }
        
        }else {
            String validar="Solo puedes reservar 2hrs de anticipacion";

               out.println("alert('"+validar+"')");
         out.close();
  } 
  
      
  } //solo las mesas de hoy
  
  
////////////////////////////////////////////////////////////////////COPIAR ESTO dia de mañana
  ////////////////////////////////////////////////////////
   ////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////// ////////////////////////////////////////////////////////
     ////////////////////////////////////////////////////////
      ////////////////////////////////////////////////////////
       ////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////
         ////////////////////////////////////////////////////////
          ////////////////////////////////////////////////////////
           ////////////////////////////////////////////////////////
            //////////////////////////////////////////////////////// ////////////////////////////////////////////////////////
            
            
    
    
if (ano_fecha==ano_Calendar && mes_fecha>=mes_Calendar && dia_fecha>dia_Calendar){
       

        try {
  final String sql="{call ConsultaMesaDisponible(?,?) }";//declaramos una constante que contendra el nombre del procedimiento almacenado
CallableStatement cs=conecta.getConexion().prepareCall(sql); 
cs.setString(1,fecha);
cs.setString(2,"chicas");
cdr=cs.executeQuery();//usamos executeQuery por que son registros
out.print("<tr>");
        while(cdr.next()){
           
 ///////////////////////////////////      recibir la hora de mis registros en la base     
      tiempo_b=cdr.getString("hora_inicio");  
       hora_b=tiempo_b.substring(0,2);
       minutos_b=tiempo_b.substring(3,5);
       hora_base=Integer.parseInt(hora_b);
       minutos_base=Integer.parseInt(minutos_b);
  ///////////////////////////////////
 
       
  if (hora_base>hora_restada && hora_base<hora_sumada){
       ocupado[cont]=cdr.getString("id_mesa");
  }
  if (hora_base==hora_restada){
      if (minutos_base>=minutos){
          ocupado[cont]=cdr.getString("id_mesa");
      }
  }
  if (hora_base==hora_sumada){
      if (minutos_base<=minutos){
          ocupado[cont]=cdr.getString("id_mesa");
      }
  }

  cont++;
}//  while

        /////////////////////////
   
          //////////////////////////////AQUI SE PONE 1 EN DONDE SE REPITAN LAS MESAS/////////////////////////////////////////
       for (int i = 0; i < mesas.length; i++) {
           for (int j = 0; j < ocupado.length; j++) {
               if (mesas[i].equals(ocupado[j])){
                   mesas[i]="1";
               }
           }
      }
       
          //////////////////////////////////////////////
       int conts=1;
           for (int i = 0; i < ocupado.length; i++) {
          if (ocupado[i]!=null){
                if (ocupado[i].equals(ocupado[conts])){
                   ocupado[i]=null;
                  
               }
          }
        
   conts++;
      }
/////////////////


 /////////////////////////////////AQUI SE IMPRIMNE/////////////////////////////////////////  
 int num=0;
 out.print("<table>");
  
      for (int i = 0; i < ocupado.length; i++) {
        if(ocupado[i]!=null){
       // out.print("<td>"+ocupado[i]+"</td>");//imprimir ocupado
out.print("<td><input  type='submit'  class='chicasOcupadas' value="+ocupado[i]+"></td>");
           
num++;
        }
        if (num==5){
              out.print("<tr>");
        }

    }
    
 for (int i = 0; i < mesas.length; i++) {
             if (num==5){
              out.print("<tr>");
        }
          if (mesas[i]!="1"){
             // out.print("<td>"+mesas[i]+"</td>\n");//imprimir disponible
out.print("<td><input type='button' id='mesas"+i+"' class='chicasDisponibles' value="+mesas[i]+" onclick='cotizar"+i+"();'></td>");
     
               num++;
          }
   }  
 
    out.print("</table><br><br><br><br>"); 
    
     
    out.close();
           
        } catch (Exception e) {
            System.out.println("error"+e);
        }   
      
}
       
    }

public void imprimirOcupado( PrintWriter out){

    
}


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
