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
public class Tsuchinoko extends Animal
{
    
     public Tsuchinoko(int p, String r)
    {
        super(p, r);
    }

    @Override
    public void hablar()
    {
        System.out.println("Tsssssss");
    }

    @Override
    public void queComo()
    {
        System.out.println("Roedores");
    }
    
}
