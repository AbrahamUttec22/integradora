package servletsAraceli;

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
import java.sql.CallableStatement;
/**
 *
 * @author Araceli
 */
@WebServlet(name = "CotizarPedidos", urlPatterns = {"/CotizarPedidos"})
public class CotizarPedidos extends HttpServlet {
ResultSet cdr=null;
ResultSet cdr1=null;
Statement sentenciaSQL=null;
Conexion conecta=new Conexion();

public void init(ServletConfig config) throws ServletException{
    super.init(config);
    conecta.Conectar();
    sentenciaSQL=conecta.getSentenciaSQL();
}
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/pdf");
            int id_usuario=Integer.parseInt(request.getParameter("usuario"));
            String nombre=null, nompaq=null, descripcion=null;
            int precio = 0, paquete=0;            
        try {
       OutputStream out= response.getOutputStream();
Document documento = new Document();
PdfWriter.getInstance(documento,out);
documento.open();
String strComando="select * from pedido_evento where id_pedido_evento = (select max(id_pedido_evento) from pedido_evento);";
           cdr=sentenciaSQL.executeQuery(strComando);
           while(cdr.next()){
               paquete=cdr.getInt("id_paquete");
           }
        String strComando1="select * from paquete where id_paquete="+paquete;
           cdr1=sentenciaSQL.executeQuery(strComando1);
           while(cdr1.next()){
            nompaq=cdr1.getString("nombre_paquete");
            precio = cdr1.getInt("precio");
            descripcion = cdr1.getString("descripcion");
           }           
final String SQL = "{call cliente("+id_usuario+")}";
 CallableStatement cs = conecta.getConnection().prepareCall(SQL);
 ResultSet resultado = cs.executeQuery();
 while (resultado.next()){
     nombre=resultado.getString("Nombre");
 }
          documento.add(new Paragraph("---Restaurante Entretiempo---\n\n"));
          documento.add(new Paragraph("Asunto: Cotización para un evento\n\n"));
          documento.add(new Paragraph("Estimado (a): "+nombre+" le proporcionamos la siguiente infromación sobre el paquete que cotizó:\n\n"));
          documento.add(new Paragraph("Nombre del paquete: "+nompaq+"\n"));
          documento.add(new Paragraph("Precio: $"+precio+"\n"));
          documento.add(new Paragraph("Descripción: "+descripcion+"\n\n"));
          documento.add(new Paragraph("Sin otro particular por el momento, nos despedimos agradeciendo su preferencia"));
          documento.close();
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
