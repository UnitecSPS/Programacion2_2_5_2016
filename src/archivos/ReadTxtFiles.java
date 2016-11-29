/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Aula
 */
public class ReadTxtFiles {
    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        System.out.print("Path: ");
        String path = lea.nextLine();
        
        try(FileReader fr = new FileReader(path)){
            File f = new File(path);
            char buffer[] = new char[(int)f.length()];
            fr.read(buffer);
            System.out.println("Contenido:\n-----------");
            System.out.println(buffer);
            
        }catch(IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
