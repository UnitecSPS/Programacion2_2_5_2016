/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

/**
 *
 * @author Aula
 */
public class Recursiones {
    
    public void print(int n){
        if(n > 1)
            print(n-1);
        System.out.println(n);
    }
 
    public int sumaUp(int n){
        if(n > 1)
            return sumaUp(n-1) + n;
        return n;
    }
    
    public int sumaDown(int n){
        return sumaDown(n, 0);
    }
    
    private int sumaDown(int n, int suma){
        if(n >= 1)
            return sumaDown(n-1,suma+n);
        return suma;
    }
    
    public int powUp(int b, int e){
        if(e > 0)
            return powUp(b, e-1) * b;
        return 1;
    }
    
    public int powDown(int b, int e){
        return powDown(b, e, 1);
    }

    private int powDown(int b, int e, int p) {
        if(e > 0)
            return powDown(b, e-1, p*b);
        return p;
    }
}
