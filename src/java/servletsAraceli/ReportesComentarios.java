package servletsAraceli;

import Conexion.Conexion;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.CallableStatement;

@WebServlet(name = "ReportesComentarios", urlPatterns = {"/ReportesComentarios"})
public class ReportesComentarios extends HttpServlet {
ResultSet cdr=null, inst=null;
Statement sentenciaSQL=null;
Statement sentenciaSQL1=null;
Conexion conecta=new Conexion();

public void init(ServletConfig config) throws ServletException{
    super.init(config);
    conecta.Conectar();
    sentenciaSQL=conecta.getSentenciaSQL();
    sentenciaSQL1=conecta.getSentenciaSQL();
}
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ReportesComentarios</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ReportesComentarios at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String fecha=request.getParameter("opc");
        String mes=fecha.substring(0, 1);
        String año=fecha.substring(1, 5);
        int usuario=0;
        int longm=mes.length();
        try{           
            if (longm==1){
                String strComando="select * from queja_sugerencia where fecha like '%"+año+"-0"+mes+"%'";
           cdr=sentenciaSQL.executeQuery(strComando);
            Document documento= new Document (PageSize.LETTER);   
PdfWriter writer=PdfWriter.getInstance(documento, new FileOutputStream("Reporte"+mes+año+".pdf"));
int num=0;         
documento.open();         
documento.add(new Paragraph("---RESTAURANTE ENTRETIEMPO--- \n"));
         documento.add(new Paragraph("Asunto: Reporte de comentarios del mes "+mes+" del "+año+" \n\n"));
         while(cdr.next()){
             num++;
             usuario=cdr.getInt("id_usuario");
documento.add(new Paragraph("Comentario: "+cdr.getString("comentario")+"\n"));   
         documento.add(new Paragraph("Fecha de envio: "+cdr.getString("fecha")+"\n"));
 final String SQL = "{call cliente("+usuario+")}";
 CallableStatement cs = conecta.getConnection().prepareCall(SQL);
 ResultSet resultado = cs.executeQuery();
 while(resultado.next()){     
     documento.add(new Paragraph("Cliente que envio: "+resultado.getString("Nombre")+"\n\n"));
 }        
         }
         documento.add(new Paragraph("Total de comentarios este mes: "+num+"\n\n"));
                 documento.close();
         out.println("Reporte Generado");
         File path = new File ("Reporte"+mes+año+".pdf");
                Desktop.getDesktop().open(path);
            }else{
                               String strComando="select * from queja_sugerencia where fecha like '%"+año+"-"+mes+"%'";
           cdr=sentenciaSQL.executeQuery(strComando);
            Document documento= new Document (PageSize.LETTER);   
PdfWriter writer=PdfWriter.getInstance(documento, new FileOutputStream("Reporte"+mes+año+".pdf"));
int num=0;         
documento.open();         
documento.add(new Paragraph("---RESTAURANTE ENTRETIEMPO--- \n"));
         documento.add(new Paragraph("Asunto: Reporte de comentarios del mes "+mes+" del "+año+" \n\n"));
         while(cdr.next()){
             num++;
             usuario=cdr.getInt("id_usuario");
documento.add(new Paragraph("Comentario: "+cdr.getString("comentario")+"\n"));   
         documento.add(new Paragraph("Fecha de envio: "+cdr.getString("fecha")+"\n"));
 final String SQL = "{call cliente("+usuario+")}";
 CallableStatement cs = conecta.getConnection().prepareCall(SQL);
 ResultSet resultado = cs.executeQuery();
 while(resultado.next()){     
     documento.add(new Paragraph("Cliente que envio: "+resultado.getString("Nombre")+"\n\n"));
 }        
         }
         out.println("Reporte Generado");
         File path = new File ("Reporte"+mes+año+".pdf");
                Desktop.getDesktop().open(path);
        documento.close();
            }
}catch (Exception e){
    e.printStackTrace();
}
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
