/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package errores;

import java.util.Scanner;
import java.util.InputMismatchException;
/**
 *
 * @author Aula
 */
public class ValidationInput {
    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        
        
        do{ 
            try{
                System.out.print("Ingrese un entero: ");
                int x = lea.nextInt();
                break;
            }
            catch(InputMismatchException e){
                lea.nextLine();
                System.err.println("Por favor ingrese un entero!");
            }
        }while(true);
    }
}
