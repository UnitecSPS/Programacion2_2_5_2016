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
    
    public int mcd(int n1, int n2){
        return mcd(n1, n2, 2);
    }
    
    private int mcd(int n1, int n2, int d) {
        if(n1 >= d && n2 >= d){
            if(n1 % d == 0 && n2 % d == 0){
                return mcd(n1/d, n2/d, d) * d;
            }
            return mcd(n1, n2, d+1);
        }
        return 1;
    }
    
    public void piramide(int filas){
        piramide(filas, 1, 1);
    }

    private void piramide(int filas, int f, int c) {
        if(f <= filas){
            if(c <= f){
                System.out.print("*");
                piramide(filas,f,c+1);
            }
            else{
                System.out.println("");
                piramide(filas,f+1,1);
            }
        }
    }
    
    /**
     * PRUEBA #1:
     *  Funcion recursiva que me retorna TRUE si un numero
     *  n es primo o no.
     * @param n Numero a evaluar
     */
    public boolean primo(int n){
        if(n > 1)
            return primo(n,2);
        return false;
    }

    private boolean primo(int n, int d) {
        if( d < n){
            if(n % d == 0)
                return false;
            return primo(n, d+1);
        }
        return true;
    }
    public int f(int n){
        if(n>1){
            return f(n-1)+f(n-2);
        }
        return n;
     }
    public int fD(int n){
        return fD(n, 1, 1, 0);
    }
    private int fD(int n,int c,int f1,int f2){
        if(c<=n){
            return fD(n,c+1,f1+f2,f1);
        }
        return f2;
        
    }
}
