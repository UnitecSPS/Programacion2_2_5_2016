/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Aula
 */
public class TestTxtFiles {
    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        System.out.print("Path: ");
        String path = lea.nextLine();
        System.out.println("Append? (s/n): ");
        char app = lea.nextLine().toLowerCase().charAt(0);
        
        try {
            FileWriter fw = new FileWriter(path, app=='s');

            do{
                System.out.println("Escriba algo: ");
                String dato = lea.nextLine();
                if(!dato.equals(":q"))
                    fw.write(dato+"\r\n");
                else
                    break;
                
            }while(true);
            
            fw.close();
            
        } catch (IOException ex) {
            System.out.println("Error: "+ ex.getMessage());
        }
    }
}
