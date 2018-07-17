package servletsAraceli;

import Conexion.Conexion;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Scanner;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SubirArchivo", urlPatterns = {"/SubirArchivo"})
public class SubirArchivo extends HttpServlet {
ResultSet cdr=null;
Statement sentenciaSQL=null;
Conexion conecta=new Conexion();

public void init(ServletConfig config) throws ServletException{
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
            out.println("<title>Servlet SubirArchivo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SubirArchivo at " + request.getContextPath() + "</h1>");
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
    response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String ruta=request.getParameter("ruta");
        File f = new File("C:\\Users\\Oswaldo\\Desktop\\SWPR\\web\\archivos\\"+ruta);
        int max=ruta.length();
        int min=max-3;
        String ext = ruta.substring(min, max);
        if (!ext.equals("txt")){
            out.println("Elija un archivo .txt");
        }else{
            Scanner s;
                int tb=0;
                int tm=0;
                String fecha = null;
		try {
                    String strComando1="select * from archivo where id_archivo = (select max(id_archivo) from archivo)";
           cdr=sentenciaSQL.executeQuery(strComando1);
           while(cdr.next()){
                fecha = cdr.getString("fecha_subio");
           }
           Calendar obj = Calendar.getInstance();        
            int años=obj.get(Calendar.YEAR);
        int mess=obj.get(Calendar.MONTH)+1;
        int dia=obj.get(Calendar.DAY_OF_MONTH);
        
        
        String strFecha = años+"-0"+mess+"-"+dia;
        
        if (strFecha.equals(fecha)){
        out.println ("Ya se subio el archivo de este mes");
        }else{
		s = new Scanner(f);
		while (s.hasNextLine()) {
		String linea = s.nextLine();
		Scanner sl = new Scanner(linea);
		sl.useDelimiter(",");
		String numero=(sl.next());
		int saldo=Integer.parseInt((sl.next()));
		String status=(sl.next());
                 String codigo=(sl.next());
                                String strComando="select * from tarjeta_prepago where no_tarjeta='"+numero+"'";
           cdr=sentenciaSQL.executeQuery(strComando);
           if (cdr.next()){
               tm++;
           }else{
               int tam=numero.length();
               if (tam!=12){
                   tm++;
               }else{
                sentenciaSQL.executeUpdate("INSERT INTO tarjeta_prepago VALUES(null,'"+numero+"', "+saldo+",'"+status+"','"+codigo+"', now())");
		tb++;	                
               }}}
                sentenciaSQL.executeUpdate("INSERT INTO archivo VALUES(null,'"+ruta+"', now(), "+tb+","+tm+")");
                        out.println("Tarjetas registradas con exito<br/>");
                        out.println("Tarjetas correctas: "+tb+"<br/>");
                        out.println("Tarjetas incorrectas: "+tm);
			s.close();
		}} catch (FileNotFoundException e) {
			out.println(e);
		}catch (SQLException ex) {
        ex.printStackTrace();
    }
        }		
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
