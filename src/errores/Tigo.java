/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package errores;

/**
 *
 * @author Aula
 */
public class Tigo {
    public Plan search(int p){
        return null;
    }
    
    public void printPlan(int np)throws PlanNotFoundException{
        Plan p = search(np);
        if(p != null)
            System.out.println(p);
        else
            throw new PlanNotFoundException(np);
    }
}
