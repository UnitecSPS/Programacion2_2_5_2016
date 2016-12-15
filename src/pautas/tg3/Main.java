package pautas.tg3;

import java.io.IOException;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Justm
 */
public class Main {
    
    public static void main(String[] args) {
        Steam stm = new Steam();
        Scanner lea= new Scanner(System.in);
        int op=0;
         do{
            System.out.println("1. Add Game");
            System.out.println("2. Add Player");
            System.out.println("3. Download Game");
            System.out.println("4. Update Price");
            System.out.println("5. Report for Client");
            System.out.println("6. Print Games");
            System.out.println("7. Salir");
            System.out.print("Opcion: ");
        
            try{
            op=lea.nextInt();
            
            switch(op){
                case 1:
                    System.out.println("Titulo: ");
                    String titulo= lea.next();
                    System.out.println("Sistema Operativo: ");
                    char SO= lea.next().charAt(0);
                    System.out.println("Edad: ");
                    int edad= lea.nextInt();
                    System.out.println("Precio: ");
                    double precio= lea.nextDouble();
                    stm.addGame(titulo, SO, edad, precio);
                    break;
                case 2:
                    System.out.println("Nombre: ");
                    String nombre= lea.next();
                    System.out.println("Año de nacimiento: ");
                    int year= lea.nextInt();
                    System.out.println("Mes de nacimiento: ");
                    int month= lea.nextInt();
                    System.out.println("Dia de nacimiento: ");
                    int dia= lea.nextInt();
                    Calendar t= Calendar.getInstance();
                    t.set(year, month, dia);        
                    stm.addPlayer(nombre, t);
                    break;
                case 3:
                    System.out.println("Codigo del juego:  ");
                    int cvg= lea.nextInt();
                    System.out.println("Codigo de cliento: ");
                    int ccli=lea.nextInt();
                    System.out.println("Sistema Operativo:  ");
                    char so= lea.next().charAt(0);
                    stm.downloadGame(cvg, ccli, so);
                    break;
                case 4:
                    System.out.println("Codigo del juego:  ");
                    cvg= lea.nextInt();
                    System.out.println("Nuevo Precio: ");
                    precio= lea.nextDouble();
                    stm.updatePriceFor(cvg, precio);
                    break;
                case 5:
                    System.out.println("Codigo de cliento: ");
                    ccli=lea.nextInt();
                    System.out.println("Path Archivo: ");
                    String path= lea.next();
                    stm.reportForClient(ccli, path);
                    break;
                case 6:
                    stm.printGames();
                    break;

            }
        }catch(InputMismatchException e){
                lea.next();
                System.out.println("Ingrese un entero");
        }
        catch(IOException e){
            System.out.println("Error en Disco: "+e.getMessage());
        }
    } while (op!=7);
    }

}
