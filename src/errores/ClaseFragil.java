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
        catch(InputMismatchException e){
            System.out.println("Ingrese un valor entero");
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Por favor ingrese una posicion correcta");
        }
        catch(NumberFormatException e){
            System.out.println("Por favor seleccione un entero");
        }
//        catch(Exception e){
//            System.out.println("Error: "+e);
//            lastStackTraceElement(e);
//        }
        System.out.println("Finalizando Main");
    }

    private static void a() {
        System.out.println("Iniciando a()");
        b();
        System.out.println("Finalizando a()");
    }

    private static void b() {
        System.out.println("Iniciando b()");
        String vals[] = { "hola", "0","5", null };
        Scanner lea = new Scanner(System.in);
        int pos = lea.nextInt();//InputMisMatch
        System.out.println("Valor: "+ vals[pos]);//ArrayIndex..
        System.out.println("Longitud: "+vals[pos].length());//NullPointer
        int entero = Integer.parseInt(vals[pos]);//NumberFormat
        System.out.println("Division entr "+entero+": "+ (10/entero) );//Arithmetic
        System.out.println("Finalizando b()");
    }

    private static void lastStackTraceElement(Exception e) {
        StackTraceElement stations[] = e.getStackTrace();
        int last = 0;//stations.length - 1;
        System.out.print("Clase?: "+stations[last].getClassName());
        System.out.print(" Linea?: "+stations[last].getLineNumber());
        System.out.println(" Metodo?: "+stations[last].getMethodName());
    }
}
