/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

/**
 *
 * @author Aula
 */
public class PrestamoAuto extends Prestamo {
    private double seguro;
    
    public PrestamoAuto(int c, String n, double m){
        super(c,n,m);
        seguro = monto * 0.3;
    }
    
    @Override
    public String toString(){
        return super.toString()+seguro;
    }
    
    public static void main(String[] args) {
        Prestamo p = new PrestamoAuto(1, "Carlos", 500);
    }
}
