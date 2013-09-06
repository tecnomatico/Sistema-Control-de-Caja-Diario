package util;

import static util.FechaUtil.getAnio;
import static util.FechaUtil.getDia;
import static util.FechaUtil.getDiaString;
import static util.FechaUtil.getMes;
import static util.FechaUtil.getMesString;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author alumno
 */
public class FechaUtil {
    
 
    /**
     * 
     * @param fecha  recibe una fecha de tipo date
     * @return la fecha en formato String  DD/MM/AAAA  
     */
    public static String getDateDDMMAAAA (Date fecha){
        String mifecha = fecha.toString();
        String dia = mifecha.substring(8, 10);
        String  mes = mifecha.substring(5, 7);
        String anio = mifecha.substring(0, 4);
        String f = dia+"/"+mes+"/"+anio;
        
        return f;
    }
    
    
      /**
     * 
     * @param fecha de tipo date
     * @return  convierte en String en el formato DD-MM-AAAA
     */
       public static String getDateDD_MM_AAAA (Date fecha){
        String mifecha = fecha.toString();
        int dia = getDia(fecha);
        int mes = getMes(fecha);
        int anio = getAnio(fecha);
        String f = dia+"-"+mes+"-"+anio;
        
        return f;
    }

    public static int getDia (Date fecha){
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(fecha);
        
        return gc.get(Calendar.DAY_OF_MONTH);
    }
    public static String getDiaString (Date fecha){
        String dia="";
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(fecha);
        int index = gc.get(Calendar.DAY_OF_WEEK);
        if (index == Calendar.SUNDAY) {
            dia= "DOMINGO";
        } else {
            if (index == Calendar.MONDAY) {
                dia ="LUNES";
            } else {
                if (index == Calendar.TUESDAY) {
                dia ="MARTES";
            } 
                if (index == Calendar.WEDNESDAY) {
                dia ="MIERCOLES";
            } 
                else {
                    if (index == Calendar.THURSDAY) {
                dia ="JUEVES";
            } else {
                  if (index == Calendar.FRIDAY) {
                dia ="VIERNES";
            } else {
                  if (index == Calendar.SATURDAY) {
                dia ="SABADO";    
                     
            }      
            }
            }
            }
        }
        }
        
       return dia;
    }
    
    public static String  getMesString(Date fecha){
        String mes="";
         GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(fecha);
        int index  = gc.get(Calendar.MONTH);
        if (index == Calendar.JANUARY) {
            mes = "ENERO";
        } else {
             if (index == Calendar.FEBRUARY) {
            mes = "FEBRERO";
        } else {
              if (index == Calendar.MARCH) {
                  mes = "MARZO";
              } else {
                   if (index == Calendar.APRIL) {
                      mes = "ABRIL";
                   } else {
                         if (index == Calendar.MAY) {
                             mes = "MAYO";
                            } else {
                             if (index == Calendar.JUNE) {
                                   mes = "JUNIO";
                            } else {
                                 if (index == Calendar.JULY) {
                                       mes = "JULIO";
                                   } else {
                                      if (index == Calendar.AUGUST) {
                                           mes = "AGOSTO";
                                      } else {
                                       if (index == Calendar.SEPTEMBER) {
                                            mes = "SEPTIEMBRE";
                                        } else {
                                          if (index == Calendar.OCTOBER) {
                                               mes = "OCTUBRE";
                                            } else {
                                             if (index == Calendar.NOVEMBER) {
                                                mes = "NOVIEMBRE";
                                              } else {
                                              if (index == Calendar.DECEMBER) {
                                                        mes = "DICIEMBRE";
                                                } 
                                             }
                                            }
                                        }
                                      }
                                   }
                             }
                         }
                    }
              }    
        }
        }
        
        return mes;
    }
    public static String getFecha_Dia_DD_De_MM_De_AAAA(Date fecha){
        String fechaActual = getDiaString(fecha)+" "+getDia(fecha)+" DE "+getMesString(fecha)+" DE "+getAnio(fecha);
        return fechaActual;
    }
    
    public static int getMes (Date fecha){
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(fecha);
        int mes  = gc.get(Calendar.MONTH)+1;
        return mes;
    }
   
    public static int getAnio (Date fecha){
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(fecha);
        return gc.get(Calendar.YEAR);
        
    }
   
  
    /**
     * 
     * @param fechaHoy una fecha ingresada
     * @return la hora en formato hh:mm en String
     */
       public static String getHora(Date fechaHoy){
           String hora= String.valueOf(fechaHoy.getHours()) ;
           String min= String.valueOf(fechaHoy.getMinutes());
           
           if (fechaHoy.getHours()==0) {
               hora = "0"+ fechaHoy.getHours();    
           }
           if (fechaHoy.getMinutes()<=9){
               min= "0"+ fechaHoy.getMinutes();
           }
           String horaEnString = hora +":"+ min;
         return horaEnString;
     }
     /**
        * 
        * @param hora recibe una cadena con el formato HH:MM
        * @return  una fecha donde contendra en sus atributos la hora
        */
     public static Date getHora(String hora){
         int hs = Integer.parseInt(hora.substring(0, 1));
         int min = Integer.parseInt(hora.substring(3, 4));
         Date miHora = new Date(0, 0, 0, hs, min);
         return miHora;
     }
    
    public static Date getFechaSinhora (Date fecha){
        fecha.setHours(0);
        fecha.setMinutes(0);
        fecha.setSeconds(0);
        return fecha;
        
    }
     
}
