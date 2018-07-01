
package GerenteMesas;

import Conexion.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "medianas", urlPatterns = {"/medianas"})
public class medianas extends HttpServlet {

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
            out.println("<title>Servlet medianas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet medianas at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    /////////////////////////////////////////////////////////////////7    COPIAR ESTO    
           response.setContentType("text/html;charset=UTF-8");
           String mesas[]={"me1","me2","me3","me4","me5","me6","me7","me8","me9","me10"};
  String ocupado[]=new String[15];
     
      PrintWriter out= response.getWriter();
       String fecha="",ho="",ho1="",fe="",dia="",mes="",ano="",min1="",hora_b="",minutos_b="",tiempo_b="";
        int hora_sumada=0,hora_restada=0,hora=0,minutos=0,hora_base=0,minutos_base=0;
          int cont=0;
      Calendar calendario = Calendar.getInstance();
  int hor =calendario.get(Calendar.HOUR_OF_DAY)+2;
  int minut = calendario.get(Calendar.MINUTE);
  int dia_Calendar=calendario.get(Calendar.DAY_OF_MONTH);
  dia=String.valueOf(dia_Calendar);
  int mes_Calendar=calendario.get(Calendar.MONTH)+1;
  mes=String.valueOf(mes_Calendar);
   int ano_Calendar=calendario.get(Calendar.YEAR);
   ano=String.valueOf(ano_Calendar);
if (mes_Calendar<=9 && dia_Calendar>10){
    fecha=dia+"/0"+mes+"/"+ano;
}else if (mes_Calendar<=9 && dia_Calendar<=9){
      fecha="0"+dia+"/0"+mes+"/"+ano; 
}
  
  ////////////////////////////////////////////////////////////////// 
  
            Calendar sistema = new GregorianCalendar();
        hora =sistema.get(Calendar.HOUR_OF_DAY);
        minutos = sistema.get(Calendar.MINUTE);
         /////////////////////////////
         hora_sumada=hora+2;//hora sumada
         hora_restada=hora-2;//hora restada,
         int hora_base_sumada=0;
        try {
  final String sql="{call ConsultaMesaDisponible(?,?) }";//declaramos una constante que contendra el nombre del procedimiento almacenado
CallableStatement cs=conecta.getConexion().prepareCall(sql); 
cs.setString(1,fecha);
cs.setString(2,"medianas");
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
 
      hora_base_sumada=hora_base+2;
  ///////////////////////////////////
       
  if (hora_base==hora && minutos_base<=minutos){
           ocupado[cont]=cdr.getString("id_mesa");
           
       }else if (hora_base<hora && hora<hora_base_sumada){
   
           ocupado[cont]=cdr.getString("id_mesa");
       }else if ( hora_base_sumada==hora && minutos_base>=minutos){
  ocupado[cont]=cdr.getString("id_mesa");
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
out.print("<td><input  type='submit'  id='mesas"+i+"' class='medianasOcupadas' value="+ocupado[i]+" onclick='cotizar"+i+"();'></td>");
           
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
out.print("<td><input type='button'  class='medianasDisponibles' value="+mesas[i]+"></td>");
     
               num++;
          }
   }  
 
    out.print("</table><br><br><br><br>");    
    out.close();
           
        } catch (Exception e) {
            System.out.println("error"+e);
        }    
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
