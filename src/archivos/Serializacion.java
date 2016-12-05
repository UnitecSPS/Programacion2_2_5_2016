/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aula
 */
public class Serializacion {
    public static void main(String[] args) {
        try {
            //seriealizar
            FileOutputStream fo = new FileOutputStream("player.ply");
            Player p = new Player("pepe", 10);
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(p);
            //dessearilzar
            FileInputStream fi = new FileInputStream("player.ply");
            ObjectInputStream oi = new ObjectInputStream(fi);
            Player otro = (Player)oi.readObject();
            
            System.out.println("Leido: "+otro);
        
        } catch (IOException ex) {
            System.out.println("Error: "+ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Serializacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
