
package GestionesAbraham;

import Conexion.Conexion;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "imprimirTicketMesa", urlPatterns = {"/imprimirTicketMesa"})
public class imprimirTicketMesa extends HttpServlet {

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
        //  PrintWriter out2 = response.getWriter();
        response.setContentType("application/pdf");
    /////////////////////SABER QUE ID_RESERVA_MESA/////////////////////////////////    
            int id_usuario=0;
    id_usuario=datosCliente.datosCliente.id_usuario;
    String id_reserva_mesa="";
        try {
     
     String mesa="",fecha="",hora_inicio="";
     fecha=request.getParameter("fecha");
     hora_inicio=request.getParameter("hora");
     HttpSession cliente = request.getSession();
   
  String sql2="select * from reserva_mesa where id_usuario="+cliente.getAttribute("cliente")+" and hora_inicio='"+hora_inicio+"' and fecha='"+fecha+"'";
        
  cdr=sentenciaSQL.executeQuery(sql2);  
       OutputStream out= response.getOutputStream();
Document documento = new Document();
PdfWriter.getInstance(documento,out);
documento.open();
       while (cdr.next()){
           System.out.println("entre");
          mesa=cdr.getString("id_mesa");
          id_reserva_mesa=cdr.getString("id_reserva_mesa");
          documento.add(new Paragraph("Folio: "+id_reserva_mesa));
          documento.add(new Paragraph("Mesa: "+mesa));
          documento.add(new Paragraph("Fecha: "+fecha));
          documento.add(new Paragraph("Hora de reserva: "+hora_inicio));
       }
  documento.close();   
     
     
     
     
     ////////////////////////////////7
        } catch (Exception e) {
            System.out.println("error de pdf"+e);
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
