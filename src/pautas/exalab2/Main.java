package pautas.exalab2;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int op=0;
        Scanner lea = new Scanner(System.in);
        Residencial res = new Residencial("Nova");
        
        do{
            System.out.println("1- Agregar Casa");
            System.out.println("2- Agregar Inquilino");
            System.out.println("3- Informacion Casa");
            System.out.println("4- Backup");
            System.out.println("5- Reload");
            System.out.println("6- Salir");
            System.out.print("Opcion: ");
            
            try{
                op = lea.nextInt();
                
                switch(op){
                    case 1:
                        System.out.print("Numero: ");
                        int n = lea.nextInt();
                        System.out.print("Familia: ");
                        res.construirResidencia(n, lea.next());
                        break;
                    case 2:
                        System.out.print("Numero: ");
                        n = lea.nextInt();
                        System.out.print("Nombre: ");
                        res.agregarInquilino(n, lea.next());
                        break;
                    case 3:
                        System.out.print("Numero: ");
                        n = lea.nextInt();
                        res.informacionCasa(n);
                        break;
                    case 4:
                        System.out.print("Filename: ");
                        res.backup(lea.next());
                        break;
                    case 5:
                        System.out.print("Filename: ");
                        res.reloadFromBackup(lea.next());
                        break;
                }
                
            }catch(InputMismatchException e){
                lea.next();
            }catch(IOException e){
                System.out.println("Error: "+e.getMessage());
            }
        }while(op!=6);

    }
}
