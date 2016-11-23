/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.File;
import java.io.IOException;
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

    void crearArchivo()throws IOException {
        if(file.createNewFile())
            System.out.println("Creado exitosamente");
        else
            System.out.println("No se pudo crear");
    }

    void crearDir() {
        if(file.mkdirs())
            System.out.println("Creado exitosamente");
        else
            System.out.println("No se pudo crear");
    }

    void borrart() {
        if(file.delete())
            System.out.println("Borrado exitosamente");
        else
            System.out.println("No se pudo borrar");
    }
    
    void dir(){
        if(file.isDirectory()){
            System.out.println("Directorio de: "+file.getAbsolutePath());
            System.out.println("");
            
            int cfiles=0, cdirs=0, tbytes=0;
            
            for(File child : file.listFiles()){
                if(!child.isHidden()){
                    //Ultima modif
                    Date ultima = new Date(child.lastModified());
                    System.out.print(ultima+"\t");
                    //si es file o dir
                    if(child.isDirectory()){
                        cdirs++;
                        System.out.print("<DIR>\t\t");
                    }
                    else{
                        //es archivo
                        cfiles++;
                        tbytes += child.length();
                        System.out.print("     \t"+
                                child.length()+"\t");
                    }
                    //nombre
                    System.out.println(child.getName());
                }
            }
            
            System.out.println(cfiles+" archivos\t"+
                    tbytes+" bytes");
            System.out.println(cdirs+" dirs\t"+
                    file.getFreeSpace()+" free bytes");
        }
    }
    
    void tree(){
        tree(file, "-");
    }

    private void tree(File dir, String tab) {
        if(dir.isDirectory()){
            System.out.println(tab+dir.getName());
            //recorrer su contenido
            for(File child : dir.listFiles())
                if(!child.isHidden())
                    tree(child, tab+"--");
        }
    }

    /**
     * 1- Validar que sea un folder lo que manejan
     * 2- Dentro de ese folder, van a crear 100 folderes,
     *    llamados Folder1, Folder2, ...Folder100
     * 3- Dentro de cada folder, van a crear 100 archivos
     *      llamados File1.txt, File2.txt, ..., FileN.txt
     */
    void viruloso() {
        
    }
}
