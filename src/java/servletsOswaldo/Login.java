
package servletsOswaldo;

import clases_osr.Consultas;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Login", urlPatterns = {"/inicial"})
public class Login extends HttpServlet {
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {       
    }
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();       
        String usuario=request.getParameter("uno");
        String contrasena=request.getParameter("dos");
        Consultas co=new Consultas();   
        switch(co.autenticacion(usuario, contrasena))
        {  
            case 1:
                out.println("MenuCliente.jsp");
                out.close();
                //response.sendRedirect("MenuCliente.jsp");
                  HttpSession cliente = request.getSession();
           cliente.setAttribute("cliente",datosCliente.datosCliente.id_usuario);
            break;
            case 2:
                out.println("Cocinero.jsp");
                out.close();
                   HttpSession cocinero = request.getSession();
           cocinero.setAttribute("cocinero",datosCliente.datosCliente.id_usuario);
                //response.sendRedirect("Cocinero.jsp");
            break;
            case 3:
                out.println("Repartidor.jsp");
                out.close();
                  HttpSession repartidor = request.getSession();
           repartidor.setAttribute("repartidor",datosCliente.datosCliente.id_usuario);
                //response.sendRedirect("Repartidor.jsp");
            break;
            case 4:
                out.println("MenuGerente.jsp");
                out.close();
                  HttpSession gerente = request.getSession();
           gerente.setAttribute("gerente",datosCliente.datosCliente.id_usuario);
                //response.sendRedirect("MenuGerente.jsp");
            break;
            case 0:
                out.println("index.jsp");
                out.close();
//            request.setAttribute("resp","usuraio o contraseña incorrectos");
//            RequestDispatcher rd=null;
//            rd= request.getRequestDispatcher("index.jsp");
//            rd.forward(request, response);
            break;
        }   
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
