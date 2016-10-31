/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia.abstracta;

/**
 *
 * @author Aula
 */
public class Perro extends Animal {

    public Perro(String r) {
        super(4, r);
    }

    @Override
    public void hablar() {
        System.out.println("Guau Guau Guauu");
    }

    @Override
    public void queComo() {
        System.out.println("Doggy y muchos huesitos");
    }
    
}
