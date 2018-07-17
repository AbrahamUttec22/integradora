package servletsOswaldo;
import Conexion.Conexion;
import datosCliente.datosCliente;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.*;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import static jdk.nashorn.internal.objects.NativeError.getFileName;
import static servletsOswaldo.EnviarCorreoRegistro.hacerCodigo;
@MultipartConfig
@WebServlet(name = "ServRegistrarCliente", urlPatterns = {"/ServRegistrarCliente"})
public class ServRegistrarCliente extends HttpServlet 
{
    private final static Logger LOGGER =  Logger.getLogger(ServRegistrarCliente.class.getCanonicalName());    
    public  ServRegistrarCliente(){
        super();
    }   
    ResultSet cdr = null;
    Statement sentenciaSQL = null;
    Conexion conecta = new Conexion();
    String mensaje,u,imagen2;
    String nombre,app,apm,municipio,cp,colonia,calle,noEx,telefono,correo,imagen, tarjeta,tipoTarjeta,usuario,contra;
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        conecta.Conectar();
        sentenciaSQL = conecta.getSentenciaSQL();
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String codigo=request.getParameter("uno");
        if(codigo.equals(datosCliente.codigoVerificacion))
         {
        PreparedStatement pst = null;
        ResultSet rs = null;
        Conexion uno=new Conexion();
        uno.Conectar();
        try  
        {               
            Statement sentenciaSQL = null;
            String strComando = "select * from cliente where nombre='"+nombre+"' and apellido_p='"+app+"' and apellido_m='"+apm+"'";
            sentenciaSQL=conecta.getSentenciaSQL();
            ResultSet rs1=sentenciaSQL.executeQuery(strComando);
            if(rs1.next())
            {
                out.println("El usuario ya existe");
            }else{                
            String sql = "call insertarSesion(?,?)";
            pst = uno.getConnection().prepareStatement(sql);
            pst.setString(1, usuario);       
            pst.setString(2, contra);       
            rs=pst.executeQuery();
            String sql2 = "call insertarTarjeta(?,?)";
            pst = uno.getConnection().prepareStatement(sql2);
            pst.setString(1, tarjeta);       
            pst.setString(2, tipoTarjeta);       
            rs=pst.executeQuery();
            String sql3 = "call insertarCliente(?,?,?,?,?,?,?,?,?,?,?)";
            pst = uno.getConnection().prepareStatement(sql3);
            pst.setString(1, nombre);
            pst.setString(2, app);
            pst.setString(3, apm);
            pst.setString(4, municipio);
            pst.setString(5, cp);
            pst.setString(6, colonia);
            pst.setString(7, calle);
            pst.setString(8, noEx);
            pst.setString(9, telefono);
            pst.setString(10, correo);
            pst.setString(11, imagen2);
            rs=pst.executeQuery();
            }
            out.println("<br><br><a href='index.jsp'>Iniciar Sesion</a>");
            out.close();
        }catch (Exception e) {
            out.println("Error "+e);
        }finally{
            out.close();
        }
    }else{
            out.println("<br><br>Codigo Incorrecto");            
            out.close();
        }  
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       for (Part part : request.getParts()) 
        {
        try{
        imagen=request.getParameter("imagen");
        nombre=request.getParameter("nombre");
        app=request.getParameter("App");
        apm=request.getParameter("Apm");
        municipio=request.getParameter("Municipio");
        cp=request.getParameter("CP");
        colonia=request.getParameter("Colonia");
        calle=request.getParameter("Calle");
        noEx=request.getParameter("NoExterior");
        telefono=request.getParameter("telefono");
        correo=request.getParameter("correo");
        usuario=request.getParameter("usr");
        contra=request.getParameter("cont");
        tarjeta=request.getParameter("tarj");
        tipoTarjeta=request.getParameter("NoTarjeta");
        }catch (Exception e) {
                out.println("Error "+e);
        } 
      
        //final String path = "C:/Users/Oswaldo/Desktop/integradora/SWPR/web/imgUsuario";
        final String path = "C:/Users/Oswaldo/Desktop/SWPR/web/imgUsuario ";
                final Part filePart = request.getPart("imagen");
                final String fileName = (String) getFileName(filePart);
                OutputStream outStr = null;
                InputStream filecontent = null;       
                 try {
                    outStr = new FileOutputStream(new File(path + File.separator+ fileName));
                    filecontent = filePart.getInputStream();
                    int read = 0;
                    final byte[] bytes = new byte[1024];
                    while ((read = filecontent.read(bytes)) != -1) {
                        outStr.write(bytes, 0, read);
                    }
                    imagen2="imgUsuario/"+fileName;        
                } catch (FileNotFoundException fne) {
                        out.println("Error "+fne);
                }
        }
        String correoRecibe =correo;
        String Nombre =nombre;
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
    private String getFileName(final Part part) {
    final String partHeader = part.getHeader("content-disposition");
    LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
    for (String content : part.getHeader("content-disposition").split(";")) {
        if (content.trim().startsWith("filename")) {
            return content.substring(
                    content.indexOf('=') + 1).trim().replace("\"", "");
        }
    }
    return null;
}
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

/** 
     ///////////////////INICIO PARTE DE LA IMAGEN///////////////////
    final String path = "C:/Users/Oswaldo/Desktop/integradora/SWPR/web/imgUsuario";
    final Part filePart = request.getPart("imagen");
    final String fileName = (String) getFileName(filePart);
    OutputStream out = null;
    InputStream filecontent = null;       
     try {
        out = new FileOutputStream(new File(path + File.separator+ fileName));
        filecontent = filePart.getInputStream();
        int read = 0;
        final byte[] bytes = new byte[1024];
        while ((read = filecontent.read(bytes)) != -1) {
            out.write(bytes, 0, read);
        }
        imagen2="imgUsuario/"+fileName;        
    } catch (FileNotFoundException fne) {
            writer.println("Error "+fne);
    }
    ///////////////////FIN PARTE DE LA IMAGEN/////////////////// 
 */
