/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoria;

import java.util.Scanner;

/**
 *
 * @author Aula
 */
public class FundamentoBasico {
    public static void main(String[] args) {
        
        int x = 5;
        int y = x;
        y = 10;
        System.out.println(x+"-"+y);
        
        Nodo na = new Nodo("Ivan");
        Nodo nb = na;
        nb.name  = "Miguel";
        
        System.out.println("Na: "+na);
        System.out.println("Nb: "+nb);
        
        //Strings
        String xa = "hola";
        Scanner lea = new Scanner(System.in);
        String xb = "Hola";
        
        if(xa == xb)
            System.out.println("Son iguales!");
        else
            System.out.println("No son iguales!");
    }
}
