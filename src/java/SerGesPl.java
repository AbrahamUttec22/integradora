/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Conexion.Conexion;
import clases_jacg.DatosPlatillo;
import clases_jacg.GestionarPl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
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
@WebServlet(urlPatterns = {"/SerGesPl"})
public class SerGesPl extends HttpServlet {
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
            out.println("<title>Servlet SerGesPl</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SerGesPl at " + request.getContextPath() + "</h1>");
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
        
        PrintWriter out = response.getWriter();
        try {
     String mensaje,bo;
     DatosPlatillo da= new DatosPlatillo();
     GestionarPl ob= new GestionarPl();
     double pre;
     String nom,tipo,ima,im2;
     
     nom=request.getParameter("nombre");
     tipo=request.getParameter("tipo");
     pre=Double.parseDouble(request.getParameter("precio"));
     ima=request.getParameter("imagen");
     im2="img/"+ima;
     bo=request.getParameter("enviar");
       da.setNom(nom);
       da.setTipo(tipo);
       da.setPre(pre);
       da.setIma(im2);
        
    if(bo.equals("Registrar")){        
      if (ob.buscar(nom)){
          mensaje="PLATILLO REGISTRADO";
          ob.insertarP(da);
          request.setAttribute("mensaje",mensaje);
          request.getRequestDispatcher("RegistrarP.jsp").forward(request, response);

      }else{
           mensaje="PLATILLO EXISTENTE NO SE PUEDE RESGISTAR";
           request.setAttribute("mensaje",mensaje);
           request.getRequestDispatcher("RegistrarP.jsp").forward(request, response);
      }
    }
    if(bo.equals("Consultar")){
    if (ob.buscar(nom)){
        
             
            String str="select * FROM platillo where Nombre=('"+nom+"')";
            cdr=sentenciaSQL.executeQuery(str);
           while(cdr.next()){
            nom=cdr.getString(2);
            tipo=cdr.getString(3);
            pre=cdr.getDouble(4);
            ima=cdr.getString(5);
            request.setAttribute("resp",nom );
            request.setAttribute("resp2",tipo );
            request.setAttribute("resp3",pre );
            request.setAttribute("resp4",ima );
            
            RequestDispatcher rd=null;
            rd=request.getRequestDispatcher("RegistarP.jsp");
            rd.forward(request, response);
      
        mensaje="PLATILLO REGISTRADO";
        request.setAttribute("mensaje",mensaje);
        request.getRequestDispatcher("RegistrarP.jsp").forward(request, response);    
           
           }
        
       
                   
      }else{
           mensaje="No Existe el platillo";
           request.setAttribute("mensaje",mensaje);
           request.getRequestDispatcher("RegistrarP.jsp").forward(request, response);
      }
    
        
    
    
    }
        } catch (Exception e) {
            System.out.println(""+e);
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
