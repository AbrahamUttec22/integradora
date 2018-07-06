<%-- 
    Document   : GraficasMes
    Created on : 5/07/2018, 07:11:49 AM
    Author     : granq
--%>

<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*"%>
<%@page import="org.jfree.chart.*"%>
<%@page import="org.jfree.chart.plot.*"%>
<%@page import="org.jfree.data.general.*"%>
<%@page import="Conexion.*"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   
    </head>
    <body>
        
     
        <%
            int regular=0,buena=0,excelente=0;
            String segun="";
      Calendar ca= Calendar.getInstance();
      int ye=ca.get(Calendar.YEAR);
      int moth=ca.get(Calendar.MONTH)+1;
      int day=ca.get(Calendar.DAY_OF_MONTH);
      int mesBase=0;
        try {
Conexion conexion= new Conexion();            
conexion.Conectar();
  String sql2="select * from encuesta";
    String fechaBase="";
    String mess="";
     PreparedStatement sentencia2= conexion.getConexion().prepareCall(sql2);
     ResultSet resultado2 = sentencia2.executeQuery(); //resultset resultado obtener los datos de columna correspondientes a un fila
            while (resultado2.next()) { // con un while podremos recorrer las columnas del registro por eso usamos el next()
       segun=resultado2.getString("evaluacion");
       fechaBase=resultado2.getString("fecha");
       mess=fechaBase.substring(5,7);
       mesBase=Integer.parseInt(mess);
           System.out.println("mesBase"+mesBase+" moth"+moth);
if(mesBase==moth){

       if (segun.equalsIgnoreCase("regular")){
           regular++;
       }else if (segun.equalsIgnoreCase("buena")){
           buena++;
       }else if (segun.equalsIgnoreCase("excelente")){
           excelente++;
       }
}
     
 }
           
//////////////////////////////////77777

DefaultPieDataset data= new DefaultPieDataset();
data.setValue("REGULAR",regular);
data.setValue("BUENA",buena);
data.setValue("EXCELENTE",excelente);

JFreeChart grafico=ChartFactory.createPieChart("Evaluaciones de las encuestas por mes",data,true,true,true);

response.setContentType("image/JPEG");

       OutputStream sa= response.getOutputStream(); 
       ChartUtilities.writeChartAsJPEG(sa,grafico,500,500);
    } catch (Exception e) {
        System.out.println("error"+e);
    }



        %>
    </body>
</html>
