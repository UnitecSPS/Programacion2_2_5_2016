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
public class Unicornio extends Animal
{
    
    public Unicornio(int p, String r)
    {
        super(p, r);
    }

    @Override
    public void hablar()
    {
        System.out.println("Indefinido");
    }

    @Override
    public void queComo()
    {
        System.out.println("Me alimento de sueños, sonrisas y lagrimas");
    }
        
}
