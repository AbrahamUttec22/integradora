
package GestionesAbraham;

import Conexion.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ticketMesa", urlPatterns = {"/ticketMesa"})
public class ticketMesa extends HttpServlet {
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
             //  PrintWriter out2 = response.getWriter();
        response.setContentType("application/pdf");
    /////////////////////SABER QUE ID_RESERVA_MESA/////////////////////////////////    
            int id_usuario=0;
    id_usuario=datosCliente.datosCliente.id_usuario;
    String id_reserva_mesa="";
        try {
             HttpSession cliente = request.getSession();
   
       String sql="select max(id_reserva_mesa) from reserva_mesa where id_usuario="+cliente.getAttribute("cliente")+"";
       cdr=sentenciaSQL.executeQuery(sql);  
       while (cdr.next()){
           id_reserva_mesa=cdr.getString(1);
       }
     //////////////////////////////////////////////////////  
     //select * from reserva_mesa where id_reserva_mesa=122;
     //folio de reserva |tipo_mesa |fecha hora_reservacion
     String mesa="",fecha="",hora_inicio="";
    

  String sql2="select * from reserva_mesa where id_reserva_mesa='"+id_reserva_mesa+"'";
       cdr=sentenciaSQL.executeQuery(sql2);  
       OutputStream out= response.getOutputStream();
Document documento = new Document();
PdfWriter.getInstance(documento,out);
documento.open();
       while (cdr.next()){
          mesa=cdr.getString("id_mesa");
          fecha=cdr.getString("fecha");
          hora_inicio=cdr.getString("hora_inicio");
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

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
