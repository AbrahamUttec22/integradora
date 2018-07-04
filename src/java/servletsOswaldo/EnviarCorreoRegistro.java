package servletsOswaldo;
import static clases_osr.CorreoDeConfirmacion.hacerCodigo;
import datosCliente.datosCliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
@WebServlet(name = "EnviarCorreoRegistro", urlPatterns = {"/EnviarCorreoRegistro"})
public class EnviarCorreoRegistro extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String correoRecibe =request.getParameter("uno");
        String Nombre =request.getParameter("dos");
      String correoEnvia = "entretiempo.sabrosano@gmail.com";
      String claveCorreo = "entretiempo";
      Properties properties = new Properties();
      properties.put("mail.smtp.host", "smtp.gmail.com");
      properties.put("mail.smtp.port", "587");
      properties.put("mail.smtp.starttls.enable", "true");
      properties.put("mail.smtp.auth", "true");
      properties.put("mail.user", correoEnvia);
      properties.put("mail.password", claveCorreo);
      Session session = Session.getInstance(properties, null);
      int aviso = 0;
      try {
        MimeMessage mimeMessage = new MimeMessage(session);
        mimeMessage.setFrom(new InternetAddress(correoEnvia, Nombre));
        InternetAddress[] internetAddresses = {new InternetAddress(correoRecibe)};
        mimeMessage.setRecipients(Message.RecipientType.TO,internetAddresses);
        mimeMessage.setSubject("Codigo de activacion");
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setText("Tu codigo de verificacion es: "+hacerCodigo());
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);
        mimeMessage.setContent(multipart);
        Transport transport = session.getTransport("smtp");
        transport.connect(correoEnvia, claveCorreo);
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
        transport.close();
      } catch (Exception ex) {
       ex.printStackTrace();
       out.println("Error: "+ex.getMessage());
       out.close();
       aviso = 1;
      }
      if (aviso==0) {
        out.println("Correo electrónico enviado exitosamente!");
        out.close();
      }
    }
    
    
    public static String hacerCodigo()
        {
            Random rnd=new Random();
            String abc="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String cadena="";
            int m=0,pos=0,num;
            while (m<1) 
            {                
                pos=(int)(rnd.nextDouble()* abc.length() -1 + 0);
                num=(int) (rnd.nextDouble()* 9999 + 1000);
                cadena = cadena+abc.charAt(pos)+num;
                pos=(int)(rnd.nextDouble()* abc.length() -1 + 0);
                cadena = cadena+abc.charAt(pos);
                m++;
            }
            datosCliente.codigoVerificacion=cadena;
            return cadena;
        }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
