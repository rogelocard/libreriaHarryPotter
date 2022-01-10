package com.libreriaHarryPotter.configuracion;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author cardo
 */
public class Fecha {
    
    public static Calendar calendar = Calendar.getInstance();
    private static String fecha;
    
    public Fecha() {
        
    }
    
    public static String Fecha() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        fecha= sdf.format(calendar.getTime());
        return fecha;
        
    }
        
    public static String fechaBD() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        fecha = sdf.format(calendar.getTime());
        return fecha;
    }

    public static Calendar getCalendar() {
        return calendar;
    }

    public static void setCalendar(Calendar calendar) {
        Fecha.calendar = calendar;
    }

    public static String getFecha() {
        return fecha;
    }

    public static void setFecha(String fecha) {
        Fecha.fecha = fecha;
    }
    
    
}
