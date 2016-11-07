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
public class EmpleadoFantasma extends Empleado implements Aumentable{
    
    public EmpleadoFantasma(int c, String n){
        super(c,n);
    }

    @Override
    public double pagar() {
        return 5000;
    }

    @Override
    public double bono() {
        return 5000;
    }

    @Override
    public void increaseIncome() {
        System.out.println("Me voy al cielo");
    }

    @Override
    public boolean validForIncrease() {
        return true;
    }
}
