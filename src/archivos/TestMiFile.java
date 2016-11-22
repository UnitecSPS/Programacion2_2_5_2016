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
 * @author Aula
 */
public class TestMiFile {
    static MiFile mf = new MiFile();
    static Scanner lea = new Scanner(System.in);
    
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
            System.out.println("11- Salir");
            System.out.print("Escoja opcion: ");
            
            try{
                op = lea.nextInt();
                
                switch(op){
                    case 1:
                        set();
                        break;
                    case 2:
                        mf.viewInfo();
                        break;
                    case 3:
                        mf.crearArchivo();
                        break;
                    case 4:
                        mf.crearDir();
                        break;
                    case 5:
                        mf.borrart();
                        break;
                    case 6:
                        mf.dir();
                        break;
                    case 7:
                        mf.tree();
                }
            }
            catch(InputMismatchException e){
                lea.nextLine();
                System.out.println("Por favor ingrese una opcion correcta");
            }
            catch(NullPointerException e){
                System.out.println("Debes seleccionar la opcion 1 por lo menos una vez");
            }
            catch(IOException e){
                System.out.println("Error en Disco: "+e.getMessage());
            }
        }while(op!= 11);
    }

    private static void set() {
        System.out.println("Direccion: ");
        mf.setFile(lea.next());
    }
}
