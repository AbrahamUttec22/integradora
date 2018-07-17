package servletsOswaldo;
import Conexion.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "ParaPruebas", urlPatterns = {"/ParaPruebas"})
public class ParaPruebas extends HttpServlet 
{
    ResultSet cdr = null;
    ResultSet cdr2 = null;
    Statement sentenciaSQL = null;
    Conexion conecta = new Conexion();
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        conecta.Conectar();
        sentenciaSQL = conecta.getSentenciaSQL();
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");        
        PrintWriter out = response.getWriter();
        String dia,mes,ano;
        Calendar obj = Calendar.getInstance();
            int y=obj.get(Calendar.YEAR);
            int mo=obj.get(Calendar.MONTH)+1;
            int day=obj.get(Calendar.DAY_OF_MONTH);
            if(day<=9)
            {
                dia="0"+day;
            }
            else{
                dia= String.valueOf(day);
            }
            if(mo<=9)
            {
                mes="0"+mo;
            }
            else{
                mes= String.valueOf(mo);
            }
            String fecha=dia+"/"+mes+"/"+y;
            String platillos [] = new String[10];
            int pos=0;
            int id = 0;
            try {
            final String SQL="call OrdenesporFecha(?)";                                    
            CallableStatement cs=conecta.getConnection().prepareCall(SQL);
            cs.setString(1,fecha);
            cdr =cs.executeQuery(); 
            out.println("<table width='60%'>");
            out.println("<tr>");
                while (cdr.next()) {                
                    out.println("<td>"+ cdr.getString(1) + "</td>");
                    out.println("<td>"+ cdr.getString(2) + "</td>"); 
                    id=cdr.getInt(3);
                }                         
                final String SQL2="call PlatillosOrden(?)";                      
                CallableStatement cs1=conecta.getConnection().prepareCall(SQL2);
                cs1.setInt(1, id);
                cdr2 =cs1.executeQuery(); 
                out.println("<td>");
                while (cdr2.next()) {
                    out.println(cdr2.getString(2)+"&nbsp;&nbsp;-&nbsp;&nbsp;"+cdr2.getString(1)+"&nbsp;&nbsp;-&nbsp;&nbsp;"+cdr2.getString(3)+"<br>");   
                }               
                out.println("</td>");
                out.println("<td> <input type='button' value='Cambiar estado'><input type='hidden' value='"+id+"' id='idLista'><br></td>");
                out.println("</tr>");
                out.println("</table>");
                out.close();   
            }catch (Exception e) {
                out.println("Error" + e);
            }finally{
                out.close();
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
