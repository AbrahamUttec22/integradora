/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletJonathan;

import Conexion.Conexion;
import clases_jacg.Repatidos;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jonat
 */
@WebServlet(name = "ActPla", urlPatterns = {"/ActPla"})
public class ActPla extends HttpServlet {
ResultSet cdr=null;
    Statement sentenciaSQL=null;
    Conexion conecta=new Conexion();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
         super.init(config);
        conecta.Conectar();
        sentenciaSQL= conecta.getSentenciaSQL();
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SerModPlatillo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SerModPlatillo at " + request.getContextPath() + "</h1>");
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
        int num;
  PrintWriter out = response.getWriter();
num=Integer.parseInt(request.getParameter("ident"));

        
        
try {        
	   
	   String strComando="select * from platillo where id_platillo="+num+""; 
            
            cdr=sentenciaSQL.executeQuery(strComando);
            
            while(cdr.next()){
        
	     out.println("<div margin-top=0>");       
        out.println("<input type=text placeholder=platillo required autofocus id=nombre value='"+cdr.getString(2)+ "'><br><br>");
        
        if (cdr.getString("tipo").equalsIgnoreCase("Entrada")){
        out.println("<select id=tipos>"); 
        out.println("<option id=tipo> Tipo de platillo</option>");
        
        out.println("<option value=Entrada selected=true >Entrada</option>");
        out.println("<option value='Plato Fuerte' > Plato Fuerte</option>"); 
        out.println("<option value=Postre > Postre</option> ");
        out.println("<option value=Bebida > Bebida</option>");
        out.println("</select><br><br>"); 
   }
    if (cdr.getString("tipo").equalsIgnoreCase("Plato Fuerte")){
        out.println("<select id=tipos>"); 
        out.println("<option  id=tipo> Tipo de platillo</option>");
        
        out.println("<option value=Entrada selected=true >Entrada</option>");
        out.println("<option value='Plato Fuerte' selected=true > Plato Fuerte</option>"); 
        out.println("<option value=Postre > Postre</option> ");
        out.println("<option value=Bebida > Bebida</option>");
        out.println("</select><br><br>"); 
   }    
        if (cdr.getString("tipo").equalsIgnoreCase("Bebida")){
        out.println("<select id=tipos>"); 
        out.println("<option  id=tipo> Tipo de platillo</option>");
        
        out.println("<option value=Entrada >Entrada</option>");
        out.println("<option value='Plato Fuerte' > Plato Fuerte</option>"); 
        out.println("<option value=Postre > Postre</option> ");
        out.println("<option value=Bebida selected=true > Bebida</option>");
        out.println("</select><br><br>"); 
   }
        if (cdr.getString("tipo").equalsIgnoreCase("Postre")){
        out.println("<select id=tipos>"); 
        out.println("<option id=tipo> Tipo de platillo</option>");
        
        out.println("<option value=Entrada selected=true >Entrada</option>");
        out.println("<option value='Plato Fuerte' > Plato Fuerte</option>"); 
        out.println("<option value=Postre selected=true> Postre</option> ");
        out.println("<option value=Bebida > Bebida</option>");
        out.println("</select><br><br>"); 
   }
        
        out.println("<input type=text placeholder=$ required autofocus id=preci VALUE="+cdr.getDouble(4)+"><br><br>");
        out.println("<input type=file placeholder=$ required autofocus id=ima VALUE="+cdr.getString(5)+"><br><br>");
        out.println("<textarea placeholder=Descripcion  id=desc value="+cdr.getString(6)+ " >"+cdr.getString(6)+ "</textarea><br><br>");
        
        out.println("<input type=button name=registrar value=Actualizar required autofocus onclick=actualizarpla("+cdr.getInt(1)+");><br><br>");
        out.println("</div>");
	       
	       
	       
	       
	   }
        } catch (SQLException e) {
             out.println("Excepcion SQL" + e.getMessage());
        } catch (NullPointerException e) {
             out.println("Apuntando SQL" + e.getMessage());
        }
             finally{
            out.close();
        }
     
    }


    
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
