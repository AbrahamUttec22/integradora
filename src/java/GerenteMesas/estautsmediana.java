
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


@WebServlet(name = "estautsmediana", urlPatterns = {"/estautsmediana"})
public class estautsmediana extends HttpServlet {
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
            out.println("<title>Servlet estautsmediana</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet estautsmediana at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String horario_mesa="",mesa="";
       response.setContentType("text/html;charset=UTF-8");
       mesa=request.getParameter("mesa");
        String fecha="",ho="",ho1="",fe="",dia="",mes="",ano="",min1="",hora_b="",minutos_b="",tiempo_b="";
 
 int hora_sumada=0,hora_restada=0,hora=0,minutos=0,hora_base=0,minutos_base=0;
        
      PrintWriter out= response.getWriter();        
//////////////FECHA DE HOY///////////////////////
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
  
       // System.out.println("fecha"+fecha);
  ////////////////////////////HORA ACTUAL DEL SISTEMA//////////////////////////////////////        
        Calendar sistema = new GregorianCalendar();
        hora =sistema.get(Calendar.HOUR_OF_DAY);
        minutos = sistema.get(Calendar.MINUTE);
         /////////////////////////////
         hora_sumada=hora+2;//hora sumada
         hora_restada=hora-2;//hora restada,

////////////////////HORA ACTUAL DEL SISTEMA//////////////////////////////////////   
        try {
  final String sql="{call BuscarMesa(?,?,?) }";//declaramos una constante que contendra el nombre del procedimiento almacenado
CallableStatement cs=conecta.getConexion().prepareCall(sql); 
cs.setString(1,fecha);
cs.setString(2,"medianas");
cs.setString(3,mesa);
cdr=cs.executeQuery();//usamos executeQuery por que son registros
int hora_base_sumada=0;
out.print("<tr>");
        while(cdr.next()){
           
 ///////////////////////////////////      recibir la hora de mis registros en la base     
      tiempo_b=cdr.getString("hora_inicio");  
       hora_b=tiempo_b.substring(0,2);
       minutos_b=tiempo_b.substring(3,5);
       hora_base=Integer.parseInt(hora_b);
       minutos_base=Integer.parseInt(minutos_b);
       hora_base_sumada=hora_base+2;
  ///////////////////////////////////
  
 //7:30 < 9:05 &&    9:05<9:09
  //7:30 == 9:03 &&    9:03<9:01
       //7:01  >  5:07              7:01    9:07
       
       if (hora_base==hora && minutos_base<=minutos){
           horario_mesa=cdr.getString("hora_inicio");
       }else if (hora_base<hora && hora<hora_base_sumada){
           horario_mesa=cdr.getString("hora_inicio");
       }else if ( hora_base_sumada==hora && minutos_base>=minutos){
           horario_mesa=cdr.getString("hora_inicio");
       }
       


}//  while

         } catch (Exception e) {
            System.out.println("error del primero"+e);
        }
/////////////////
            
 /////////////////////////////////AQUI SE ACTUALIZAMOS/////////////////////////////////////////  
try {
               final String sql2="{call CambiarEstatusMesa(?,?,?,?) }";//declaramos una constante que contendra el nombre del procedimiento almacenado
CallableStatement cs2=conecta.getConexion().prepareCall(sql2); 
cs2.setString(1,fecha);
cs2.setString(2,"medianas");
cs2.setString(3,mesa);
cs2.setString(4,horario_mesa);
cs2.executeQuery();//usamos executeQuery por que son registros
 out.close();    
            } catch (Exception e) {
                System.out.println("error del error del 2"+e);
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
