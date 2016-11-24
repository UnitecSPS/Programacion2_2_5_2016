/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aula
 */
public class TestBinario {
    public static void main(String[] args) {
        try {
            RandomAccessFile ram = new RandomAccessFile("test.ttt","rw");
            ram.writeUTF("Carlos");
            ram.seek(0);
            System.out.println("Escribi: "+ram.readUTF());
            System.out.println(ram.length());
            
        } catch (IOException ex) {
            Logger.getLogger(TestBinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
