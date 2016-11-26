/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 *
 * @author Justm
 */
public class EmpleadosMain {
    static Scanner lea = new Scanner(System.in);
    static EmpleadosManager em= new EmpleadosManager();
     public static void main(String[] args) {
        
         int op=0;
        
        do{
            System.out.println("\nMENU\n----------------");
            System.out.println("1- Set el Archivo/folder");
            System.out.println("2- Ver Informacion");
            System.out.println("3- Crear Archivo");
            System.out.println("4- Crear Folder");
            System.out.println("5- Borrar");
            System.out.println("6- Comando Dir");
            System.out.println("7- Comando Tree");
            System.out.println("8- Viruloso");
            System.out.println("11- Salir");
            System.out.print("Escoja opcion: ");
            
            try{
                op = lea.nextInt();
                
                switch(op){
                    case 1:
                        
                        break;
                    case 2:
                        
                        break;
                    case 3:
                        
                        break;
                    case 4:
                       
                        break;
                    case 5:
                        
                        break;
                    case 6:
                       
                        break;
                    case 7:
                        
                        break;
                    case 8:
                       
                        break;
                }
            }
            catch(InputMismatchException e){
                lea.nextLine();
                System.out.println("Por favor ingrese una opcion correcta");
            }
            catch(NullPointerException e){
                System.out.println("Debes seleccionar la opcion 1 por lo menos una vez");
            }
            catch(Exception e){
                System.out.println("Error en Disco: "+e.getMessage());
            }
        }while(op!= 11);
    }
}
