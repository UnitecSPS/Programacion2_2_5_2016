/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intro;

import java.util.Date;

/**
 *
 * @author Aula
 */
public class TestDate {
    public static void main(String[] args) {
        Date hoy = new Date();
        System.out.println("Hoy: "+hoy+" ms: "+hoy.getTime());
        Date ayer = new Date(1);
        System.out.println("Ayer: "+ayer);
        Date maxima = new Date(Long.MAX_VALUE);
        System.out.println("Fecha Maxima: "+maxima);
        
    }
}
