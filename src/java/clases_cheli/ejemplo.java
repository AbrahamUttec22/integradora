package clases_cheli;


import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ejemplo {
    
       public int dias(String f1, String f2){
       SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
Date fecha1 = null;
Date fecha2 = null;
String error=null;
    try { 
        java.util.Date fechainicial = formato.parse(f1);
        java.util.Date fechafinal = formato.parse(f2);
        int dias=(int) ((fechafinal.getTime()-fechainicial.getTime())/86400000);
        return(dias);
    } catch (ParseException ex) {
        return 0;
    }
   }
}
