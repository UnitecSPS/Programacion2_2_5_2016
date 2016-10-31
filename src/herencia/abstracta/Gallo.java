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
public class Gallo extends Ave {

    public Gallo(String r) {
        super(r);
    }

    @Override
    public void hablar() {
        System.out.println("Kikirikiiiii");
    }

    @Override
    public void queComo() {
        System.out.println("Gusanos y Maiz");
    }
    
}
