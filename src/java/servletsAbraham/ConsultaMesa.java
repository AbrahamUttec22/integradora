
package servletsAbraham;

import Conexion.Conexion;
import datosGerente.datosGerente;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ConsultaMesa", urlPatterns = {"/ConsultaMesa"})
public class ConsultaMesa extends HttpServlet {
         String disponible="",ocupadas="";
    String simandaOcupado="si";
    ResultSet cdr=null;
    Statement sentenciaSQL=null;
    Conexion conecta= new Conexion();
     String id_e="",id_u="";
        int id_em=0;
    int id_us=0;
    String es;
    
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
            out.println("<title>Servlet ConsultaMesa</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ConsultaMesa at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     response.setContentType("text/html;charset=UTF-8");
      PrintWriter out= response.getWriter();
          String fecha="",ho="",hora="",ho1="",fe="",dia="",mes="",ano="";
          int comensal=0;
  
        
        try {
////////////////////////////////////////////////////////////////////////////7            
            fe=request.getParameter("fecha");
            ho=request.getParameter("hora");
            comensal=Integer.parseInt(request.getParameter("comensal"));
            ho1=ho.substring(0,2);
            hora=ho1+":00";
            dia=fe.substring(8,10);
            mes=fe.substring(5,7);
            ano=fe.substring(0,4);
            fecha=dia+"/"+mes+"/"+ano;
            /////////////////////////////////////////////
//            
//              <input type="button" class="chicasDisponibles">
//    <input type="button" class="chicasOcupadas">
//    <input type="button" class="medianasDisponibles">
//    <input type="button" class="medianasOcupadas">
//    <input type="button" class="grandesDisponibles">
//    <input type="button" class="grandesOcupadas">

if (comensal>=1 && comensal <=2){
    disponible="chicasDisponibles";
    ocupadas="chicasOcupadas";
}else if (comensal>=3 && comensal <=4){
     disponible="medianasDisponibles";
    ocupadas="medianasOcupadas";
}else if (comensal>=5){
     disponible="grandesDisponibles";
    ocupadas="grandesOcupadas";
}


///////////////////////////////////////////////////////////////////////////
//comensal,hora,fecha
simandaOcupado="si";
out.print("<table>");
disponible(comensal, hora, fecha,out);
if (simandaOcupado.equals("si"))
ocupado(comensal, hora, fecha,out);


out.print("</table>");
///////////////////////////////////////////////////////////////////////////7
            out.close();
        } catch (Exception e) {
        }
    }
  
    ////////////////////////////////////////////////////////////////
    public void disponible(int comensal,String hora,String fecha,PrintWriter out){
 
      try {
 final String sql="{call ConsultaMesaDisponible(?,?,?) }";//declaramos una constante que contendra el nombre del procedimiento almacenado
int cont =0,bandera=0;
CallableStatement cs=conecta.getConexion().prepareCall(sql);
        
cs.setInt(1,comensal);//s
cs.setString(2,hora);//
cs.setString(3,fecha);//
cdr=cs.executeQuery();//usamos executeQuery por que son registros
out.print("<tr>");
        while(cdr.next()){
         if (cont>=5){
              out.print("<td>");
   out.print("<input style='background-color: #7FFF00'   type='button'  class="+disponible+"  value="+cdr.getString(1)+"> <br>");
   out.print("</td>");
   bandera++;
         }
         if (bandera==0){
              out.print("<td>");
   out.print("<input style='background-color: #7FFF00'   type='button'  class="+disponible+"  value="+cdr.getString(1)+"> <br>");
   out.print("</td>");
         }
  if (cont==4){
        out.print("</tr>");
  }
            cont++;  
        }
      
 if (cont==0){
     respaldo(comensal,out,fecha,hora);
 }       
        } catch (Exception e) {
               System.out.println("error procedimiento"+e);
        }
    }
////////////////////////////////////////////////////////////////////////
  public void ocupado(int comensal,String hora,String fecha,PrintWriter out){
      
      try {
 final String sql="{call ConsultaMesaOcupado(?,?,?) }";//declaramos una constante que contendra el nombre del procedimiento almacenado
CallableStatement cs=conecta.getConexion().prepareCall(sql);
        
cs.setInt(1,comensal);//s
cs.setString(2,hora);//
cs.setString(3,fecha);//
cdr=cs.executeQuery();//usamos executeQuery por que son registros

        while(cdr.next()){
             out.print("<td>");
  out.print("<input  style='background-color: #FF0000'   type='button' disabled=''  class="+ocupadas+"  value="+cdr.getString(1)+"> <br>");
  //out.print(cdr.getString(1));
   out.print("</td>");
        }
   out.print("</tr>");
        } catch (Exception e) {
               System.out.println("error procedimiento"+e);
        }
  }
////////////////////////////////////////////////////////////////////////////7  
  
  public void respaldo (int comensal,PrintWriter out,String fecha,String hora){
    String tamano="";
      String sql="";
     int bandera=0;
      try {
          int cont=0;
       if (comensal>=1 && comensal<=2){
          tamano="chica";
      }else if (comensal>=3 && comensal<=4){
           tamano="mediana";
      }else if (comensal>=5){
           tamano="grande";
      }
  sql="select distinct id_mesa as disponible from mesa  where id_mesa  not in (select id_mesa from reserva_mesa where fecha='"+fecha+"' and hora_inicio>='"+hora+"') and tipo_mesa='"+tamano+"' or estatus='disponible' and tipo_mesa='"+tamano+"';";
    cdr= sentenciaSQL.executeQuery(sql);

     out.print("<tr>");
    while (cdr.next()){
         if (cont>=5){
       if (bandera==0){
            out.print("<tr>");
       }
           
         out.print("<td>");
  out.print("<input  style='background-color: #7FFF00'   type='button' class="+disponible+" value="+cdr.getString(1)+"> <br>");
  //out.print(cdr.getString(1));
   out.print("</td>");
     
        bandera++;
   }
         
       if (bandera==0){
   out.print("<td>");
   out.print("<input  style='background-color: #7FFF00'   type='button' class="+disponible+"  value="+cdr.getString(1)+"> <br>");
  //out.print(cdr.getString(1));
   out.print("</td>"); 
       }
  
  
    cont++;
    }//while
    
    
    if (cont>=1){
        simandaOcupado="no";
    }
    out.print("</tr>");
   out.print("</tr>");
   
      } catch (Exception e) {
      }
    
  }
 //////////////////////////////////////////////////////////////////////// 
  
  

  
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
