/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia.abstracta;

import java.util.ArrayList;

/**
 *
 * @author Aula
 */
public class Granja {
    public static void main(String[] args) {
        ArrayList<Animal> anis = new ArrayList<>();
        anis.add(new Perro("Chihuahua"));
        anis.add(new Vaca("Suiza"));
        anis.add(new Gallo("Peleador"));
        anis.add(new Animal(2,"Alien"){

            @Override
            public void hablar() {
                System.out.println("Cli Tic Toe");
            }

            @Override
            public void queComo() {
                System.out.println("Pollos Galacticos");
            }
            
        });
        
        Animal zombie = new Animal(2, "Zombie") {
            
            @Override
            public void hablar() {
                System.out.println("Gr huuu Grr Ahhh");
            }
            
            @Override
            public void queComo() {
                System.out.println("Cerebros!");
            }
        };
        
        anis.add(zombie);
        
        for(Animal ani : anis){
            System.out.println(ani);
            System.out.println("---------------");
            System.out.print("Como Hablo: ");
            ani.hablar();
            System.out.print("Que como?: ");
            ani.queComo();
            System.out.println("\n");
        }
    }
}
