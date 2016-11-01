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
public abstract class Animal {
    protected int patas;
    protected String raza;
    
    public Animal(int p, String r){
        patas = p;
        raza = r;
    }

    public int getPatas() {
        return patas;
    }

    public String getRaza() {
        return raza;
    }
    
    public abstract void hablar();
    public abstract void queComo();
    
    public String toString(){
        return raza + " con "+patas+" :";
    }
}
