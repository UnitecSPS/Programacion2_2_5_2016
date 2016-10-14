/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
package intro;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

/**
 *
 * @author Aula
 */
public class TestTimeZone {
    
    public static void main(String[] args) {
        Calendar Honduras = Calendar.getInstance(TimeZone.getDefault());
        Calendar Australia = Calendar.getInstance(TimeZone.getTimeZone("GMT+11"));
        Calendar Tokyo = Calendar.getInstance(TimeZone.getTimeZone("GMT+9"));
        Calendar Los_Angeles = Calendar.getInstance(TimeZone.getTimeZone("GMT-7"));
            
        System.out.println("Hora en Honduras "+Honduras.get(Calendar.HOUR_OF_DAY)+":"+Honduras.get(Calendar.MINUTE)+ " " + 
                    (Honduras.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM"));
        System.out.println("Hora en Australia "+Australia.get(Calendar.HOUR_OF_DAY)+":"+Australia.get(Calendar.MINUTE));        
        System.out.println("Hora en Tokyo "+Tokyo.get(Calendar.HOUR_OF_DAY)+":"+Tokyo.get(Calendar.MINUTE));
        System.out.println("Hora en Los Angeles California "+Los_Angeles.get(Calendar.HOUR_OF_DAY)+":"+Los_Angeles.get(Calendar.MINUTE));
    }
}
