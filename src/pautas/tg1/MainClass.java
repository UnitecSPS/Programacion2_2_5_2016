/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas.tg1;

import java.util.Scanner;

/**
 *
 * @author David
 */
public class MainClass
{
    public static void main(String[] args)
    {
        int op = 1;
        SalaCine sala = new SalaCine();
        while (op != 0)
        {
            System.out.println("\n[1] VENDER TICKET");
            System.out.println("[2] MOSTRAR SALA");
            System.out.println("[3] CANCELAR TICKET");
            System.out.println("[4] TERMINAR FUNCION");
            System.out.println("[0] SALIR");
            System.out.print("INGRESE OPCION: ");
            op = new Scanner(System.in).nextInt();
            
            switch (op)
            {
                case 1:
                    System.out.print("\nCLIENTE: ");
                    String cliente = new Scanner(System.in).useDelimiter("\n").next();
                    System.out.print("FILA: ");
                    int numfila = new Scanner(System.in).useDelimiter("\n").nextInt();
                    System.out.print("COLUMNA: ");
                    int numcol = new Scanner(System.in).useDelimiter("\n").nextInt();
                    sala.sellTicket(cliente, numfila, numcol);
                    break;
                case 2:
                    sala.printSala();
                    break;
                case 3:
                    System.out.print("\nNUMERO REFERENCIA: ");
                    int ref = new Scanner(System.in).useDelimiter("\n").nextInt();
                    System.out.println("SE PUDO CANCELAR?: " + sala.cancelTicket(ref));
                    break;
                case 4:
                    sala.eventClose();
                    break;
                default:
                    System.out.println("\nESTA SALIENDO DEL PROGRAMA...");
            }
                    
        }
    }
   
}
