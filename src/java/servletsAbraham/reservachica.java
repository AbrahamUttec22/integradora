
package servletsAbraham;

import Conexion.Conexion;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.OutputStream;
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
import javax.servlet.http.HttpSession;

@WebServlet(name = "reservachica", urlPatterns = {"/reservachica"})
public class reservachica extends HttpServlet {
       
  
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
    
     
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

  //solo calcular hora defaul estatus(reserva) tipo_mesa(chica )
    String mesa="",fecha="",hora="",comensal="";
         String ho1="",min1="",hora_inicio="";
         int id_usuario=0;
    id_usuario=datosCliente.datosCliente.id_usuario;
            mesa=request.getParameter("mesa");
    fecha=request.getParameter("fecha");
    hora=request.getParameter("hora");
    comensal=request.getParameter("numero");
    int comensales=Integer.parseInt(comensal);
    ho1=hora.substring(0,2);//hora
    min1=hora.substring(3,5);//minutos
    hora_inicio=ho1+":"+min1;
            System.out.println(id_usuario+mesa+fecha+hora+comensal+ho1+hora_inicio);
          //hora_inicio
//         hora_original=Integer.parseInt(ho1);//hora
//        
//         minutos=Integer.parseInt(min1);//minutos
/////////////////////////////////Y AQUI REGISTRAMOS///////////////////////////////////7
HttpSession cliente = request.getSession();
   String cas=String.valueOf(cliente.getAttribute("cliente"));
int id_s=Integer.parseInt(cas);
   
   
final String sql="{call reservaMesa(?,?,?,?,?,?,?) }";//declaramos una constante que contendra el nombre del procedimiento almacenado
CallableStatement cs=conecta.getConexion().prepareCall(sql); 
cs.setInt(1,id_s);
cs.setString(2,mesa);
cs.setString(3,fecha);
cs.setString(4,hora_inicio);
cs.setInt(5,comensales);
cs.setString(6,"RESERVA");
cs.setString(7,"chicas");
cs.executeQuery();
            

        } catch (Exception e) {
            System.out.println(""+e+" "+datosCliente.datosCliente.id_usuario);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
