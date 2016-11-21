/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.File;
import java.util.Date;

/**
 *
 * @author Aula
 */
public class MiFile {
    private File file = null;
    
    public void setFile(String dir){
        file = new File(dir);
    }

    public void viewInfo() {
        if(file.exists()){
            System.out.println("\nSI EXISTE:\n-------");
            System.out.println("Nombre: "+file.getName());
            System.out.println("Path: "+file.getPath());
            System.out.println("Absoluto: "+file.getAbsolutePath());
            System.out.println("Padre: "+file.getAbsoluteFile().getParentFile().getName());
            System.out.println("Bytes: "+file.length());
            if(file.isFile())
                System.out.println("ES UN ARCHIVO");
            else if(file.isDirectory())
                System.out.println("ES UN FOLDER");
            if(file.isHidden())
                System.out.println("OCULTO");
            System.out.println("Ultima Modif: "+new Date(file.lastModified()));
        }
        else
            System.out.println("Aun No existe");
    }
    
    
}
