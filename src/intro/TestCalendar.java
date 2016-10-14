/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intro;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 *
 * @author Aula
 */
public class TestCalendar {
    public static void main(String[] args) {
        Calendar hoy = Calendar.getInstance();
        System.out.println("Hoy: "+hoy.getTime());
        //fechas especificas
        Calendar estherBDay = Calendar.getInstance();
        estherBDay.set(1998, Calendar.NOVEMBER, 4);
        System.out.println("Esther nacio en: "+estherBDay.getTime());
        //comparar
        if(hoy.after(estherBDay))
            System.out.println("Si hoy es despues del nacimiento de Esther");
        if(estherBDay.before(hoy))
            System.out.println("Si la fecha de Esther es antes que hoy");
        if(hoy.getTimeInMillis() >= estherBDay.getTimeInMillis())
            System.out.println("Si si hoy paso despues que Esther bDAY");
        //Valores Individuales
        System.out.println("Año: "+hoy.get(Calendar.YEAR));
        System.out.println("Dia de hoy: "+hoy.get(Calendar.DAY_OF_YEAR));
        System.out.println("Mes: "+hoy.get(Calendar.MONTH));
        //Añadir o quitar valores
        hoy.add(Calendar.YEAR, 2);
        hoy.add(Calendar.MONTH, -6);
        System.out.println("Hoy en 2 años 6 meses atras: "+hoy.getTime());
        //comprobar si la fecha de nacimiento de Esther fue 15 años
        Calendar hace15 = Calendar.getInstance();
        hace15.add(Calendar.YEAR, -15);
        if(hace15.after(estherBDay))
            System.out.println("Han pasado 15 o mas años desde que nacio Esther");
        //imprimir los nombres del mes o dia
        System.out.println("Mes de Esther: "+
                estherBDay.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.GERMAN));
        System.out.println("Dia de Esther: "+
                estherBDay.getDisplayName(Calendar.DAY_OF_WEEK, 
                        Calendar.LONG, 
                        Locale.forLanguageTag("es")));
        //zona horario
        /*
        Imprimir la fecha del momento:
            - Tokio
            - Australia
            - Los Angeles
        */
        //TOKIO
        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat tokio=new SimpleDateFormat("yyyy-MM-dd 'T'HH:mm:ss");
        tokio.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));
        System.out.printf("Hora Tokyo:\t %s\n", tokio.format(calendar.getTime()));
        //AUSTRALIA
        SimpleDateFormat australia=new SimpleDateFormat("yyyy-MM-dd 'T'HH:mm:ss");
        australia.setTimeZone(TimeZone.getTimeZone("Australia/Sydney"));
        System.out.printf("Hora Australia:\t %s\n", australia.format(calendar.getTime()));
        
        //LOS ANGELES
        SimpleDateFormat losangeles=new SimpleDateFormat("yyyy-MM-dd 'T'HH:mm:ss");
        losangeles.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
        System.out.printf("Hora Los Angeles:\t %s\n", losangeles.format(calendar.getTime()));
    }
}
