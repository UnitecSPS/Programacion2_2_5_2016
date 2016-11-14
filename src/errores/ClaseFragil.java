/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package errores;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Aula
 */
public class ClaseFragil {
    public static void main(String[] args) {
        System.out.println("Iniciando Main");
        try{
            System.out.println("Iniciando Try");
            a();
            System.out.println("Finalizando Try");
        }
        catch(Exception e){
            System.out.println("Ingrese un valor correcto");
        }
        System.out.println("Finalizando Main");
    }

    private static void a() {
        System.out.println("Iniciando a()");
        b();
        System.out.println("Finalizando a()");
    }

    private static void b() {
        System.out.println("Iniciando b()");
        String vals[] = { "hola", "5", null };
        Scanner lea = new Scanner(System.in);
        int pos = lea.nextInt();
        System.out.println("Valor: "+ vals[pos]);
        System.out.println("Finalizando b()");
    }
}
