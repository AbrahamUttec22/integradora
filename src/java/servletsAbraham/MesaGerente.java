
package servletsAbraham;

import Conexion.Conexion;
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


@WebServlet(name = "MesaGerente", urlPatterns = {"/MesaGerente"})
public class MesaGerente extends HttpServlet {
    int divi=0;
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
            out.println("<title>Servlet MesaGerente</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MesaGerente at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
//////////////////////////////////////////////////////////////////////////////

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             response.setContentType("text/html;charset=UTF-8");
      PrintWriter out= response.getWriter();
        try {
            String ti=request.getParameter("tipo");
            if (ti.equals("chica")){
                disponible="chicasDisponibles";
    ocupadas="chicasOcupadas";
            }else if (ti.equals("mediana")){
                disponible="medianasDisponibles";
    ocupadas="medianasOcupadas";
            }else if (ti.equals("grande")){
                   disponible="grandesDisponibles";
    ocupadas="grandesOcupadas";
            }
            out.print("<table>");
            verMesaD(ti,out);
            verMesaO(ti,out);
            out.print("</table>");
            out.close();
        } catch (Exception e) {
            System.out.println("error"+e);
        }
    }

    /////////////////////////////////////////////////////////////////////7
    
     public void verMesaD(String ti,PrintWriter out){
 
      try {
 final String sql="{call ConsultaMesaGerenteD(?) }";//declaramos una constante que contendra el nombre del procedimiento almacenado
int cont =0,bandera=0;
CallableStatement cs=conecta.getConexion().prepareCall(sql);
        cs.setString(1, ti);
cdr=cs.executeQuery();//usamos executeQuery por que son registros
out.print("<tr>");
        while(cdr.next()){
          if (cont>=5){
                  out.print("<td>");
  out.print("<input  style='background-color: #7FFF00'  type='submit'  id='mesa"+cont+"' class="+disponible+" value="+cdr.getString(1)+" onclick='proceso"+cont+"();' > <br>");
   out.print("</td>");
              bandera++;
          }
          if (bandera==0){
                out.print("<td>");
  out.print("<input  style='background-color: #7FFF00'   type='submit'  id='mesa"+cont+"' class="+disponible+" value="+cdr.getString(1)+" onclick='proceso"+cont+"();' > <br>");
   out.print("</td>");
          }
       
         if (cont==4){
              out.print("</tr>");
         }
                 
   cont++; 
   divi++;
   }//while
       
     
        } catch (Exception e) {
               System.out.println("error procedimiento"+e);
        }
    }
      /////////////////////////////////////////////////////////////////////7
     public void verMesaO(String ti,PrintWriter out){
 
      try {
 final String sql="{call ConsultaMesaGerenteO(?) }";//declaramos una constante que contendra el nombre del procedimiento almacenado
int cont =0,cont2=10,bandera=0;
CallableStatement cs=conecta.getConexion().prepareCall(sql);
 cs.setString(1, ti);
cdr=cs.executeQuery();//usamos executeQuery por que son registros
out.print("<tr>");
        while(cdr.next()){
       if (cont==5){
out.print("<tr>");
  } 
  out.print("<td>");
  out.print("<input  type='submit' class="+ocupadas+" id='mesa"+cont2+"' value="+cdr.getString(1)+" onclick='proceso"+cont2+"();'> <br>");
  //out.print(cdr.getString(1));
   out.print("</td>");

  
//  if (divi==1 && cont==4){
//        out.print("<tr>");
//  } 
//  if (divi==0 && cont==5){
//      out.print("<tr>");
//  }
//  if (divi==2 && cont==3){
//      out.print("<tr>");
//  }
//  if (divi==3 && cont==2){
//      out.print("<tr>");
//  }

   cont++;  
   cont2++;
   
         
        }
        out.print("</tr>");
        out.print("</tr>");
     
  
        } catch (Exception e) {
               System.out.println("error procedimiento"+e);
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
