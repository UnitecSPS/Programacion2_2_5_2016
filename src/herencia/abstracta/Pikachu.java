/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia.abstracta;

/**
 *
 * @author David
 */
public class Pikachu extends Animal
{
    public Pikachu()
    {
        super(4, "Pokemon");
    }

    @Override
    public void hablar()
    {
        System.out.println("PIKACHUUUU");
    }

    @Override
    public void queComo()
    {
        System.out.println("Poketabletas");
    }
    
}
