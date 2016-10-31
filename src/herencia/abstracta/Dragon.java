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
public class Dragon extends Animal
{

    public Dragon(int p, String r)
    {
        super(p, r);
    }
    
    @Override
    public void hablar()
    {
        System.out.println("ROAAAAAAR");   
    }

    @Override
    public void queComo()
    {
        System.out.println("Animales de ganado");
    }
    
}
