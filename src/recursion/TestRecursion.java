/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

/**
 *
 * @author Aula
 */
public class TestRecursion {
    public static void main(String[] args) {
        Recursiones recur = new Recursiones();
        
        //print
        recur.print(10);
        
        //suma
        System.out.println("SumaUp: "+recur.sumaUp(6));
        System.out.println("SumaDown: "+recur.sumaDown(6));
        
        //potencia
        System.out.println("Pot Up: "+ recur.powUp(2, 4));
        System.out.println("Pot Down: "+ recur.powDown(2, 4));
        
        //mcd
        System.out.println("MCD de 36 y 24: "+ recur.mcd(36, 24));
        
        //piramide
        recur.piramide(5);
        
        //primo
        System.out.println("Primo 7?: "+recur.primo(7));
        System.out.println("Primo 21?: "+recur.primo(21));
        
        System.out.println(recur.fibonacci(8));
    }
}
