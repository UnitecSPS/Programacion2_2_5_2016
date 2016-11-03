/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia.enums;

import java.util.Scanner;

/**
 *
 * @author Aula
 */
public class TestTipoCuentaClass {
    public static void main(String[] args) {
        TipoCuentaClass tc = TipoCuentaClass.AHORRO;
        
        //comparaciones---
        if(tc == TipoCuentaClass.AHORRO)
            System.out.println("Si soy Ahorro");
        //Imprimir el valor que tiene
        System.out.println(tc.name());
        if(tc.name().equals("AHORRO"))
            System.out.println("Si soy Ahorro!");
        
        //imprimir las opciones disponibles
        for(TipoCuentaClass t : TipoCuentaClass.values()){
            System.out.println("-"+t);
        }
        
        //Ordinal
        System.out.println("Ordinal de Tc: "+tc.ordinal());
        System.out.println("Ordinal de Cheques: "+TipoCuentaClass.CHEQUES.ordinal());  
        
        //Ingresarlo del teclado
        Scanner lea = new Scanner(System.in);
        tc = TipoCuentaClass.valueOf(lea.next().toUpperCase());
        System.out.println("Tipo ingresado: "+tc);
        
    }
}
