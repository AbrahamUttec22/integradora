package clases_osr;
import datosCliente.datosCliente;
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
import javax.swing.JOptionPane;
public class CorreoDeConfirmacion 
{    
    public static void mandarCorreo(String correoRecibe, String Nombre)
    {
      // El correo gmail de envío
      String correoEnvia = "entretiempo.sabrosano@gmail.com";
      String claveCorreo = "entretiempo";
      // La configuración para enviar correo
      Properties properties = new Properties();
      properties.put("mail.smtp.host", "smtp.gmail.com");
      properties.put("mail.smtp.port", "587");
      properties.put("mail.smtp.starttls.enable", "true");
      properties.put("mail.smtp.auth", "true");
      properties.put("mail.user", correoEnvia);
      properties.put("mail.password", claveCorreo);
      // Obtener la sesion
      Session session = Session.getInstance(properties, null);
      int aviso = 0;
      try {
       // Crear el cuerpo del mensaje
        MimeMessage mimeMessage = new MimeMessage(session);
       // Agregar quien envía el correo
        mimeMessage.setFrom(new InternetAddress(correoEnvia, Nombre));
       // Los destinatarios
        InternetAddress[] internetAddresses = {new InternetAddress(correoRecibe)};
       // Agregar los destinatarios al mensaje
        mimeMessage.setRecipients(Message.RecipientType.TO,internetAddresses);
       // Agregar el asunto al correo
        mimeMessage.setSubject("Codigo de activacion");
       // Creo la parte del mensaje
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setText("Tu codigo de verificacion es: "+hacerCodigo());
//        MimeBodyPart mimeBodyPartAdjunto = new MimeBodyPart();
//        mimeBodyPartAdjunto.attachFile("img/login.png");
       //Crear el multipart para agregar la parte del mensaje anterior
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);
//        multipart.addBodyPart(mimeBodyPartAdjunto);
       // Agregar el multipart al cuerpo del mensaje
        mimeMessage.setContent(multipart);
       // Enviar el mensaje
        Transport transport = session.getTransport("smtp");
        transport.connect(correoEnvia, claveCorreo);
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
        transport.close();
      } catch (Exception ex) {
       ex.printStackTrace();
       JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage());
       aviso = 1;
      }
      if (aviso==0) {
              JOptionPane.showMessageDialog(null, "¡Correo electrónico enviado exitosamente!");
      }
     }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
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
        public static void main(String[] args) {
	// CorreoDeConfirmacion.mandarCorreo();
//        CorreoDeConfirmacion uno = new CorreoDeConfirmacion();
//        uno.mostrar();
	}
}
