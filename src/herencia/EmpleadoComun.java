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
public class EmpleadoComun extends Empleado implements Aumentable, Deductible{
    protected double salario;
    
    public EmpleadoComun(int c, String n, double sal){
        super(c,n);
        salario = sal;
        //System.out.println("Llamando a Comun");
        
    }
    
    @Override
    public double pagar(){
        return salario - deduct();
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    @Override
    public void quienSoy(){
        System.out.println("Soy un Empleado con Salario");
    }

    @Override
    public String toString() {
        return super.toString() + " salario="+salario; 
    }

    @Override
    public double bono() {
        return 0;
    }

    @Override
    public void increaseIncome() {
        if(validForIncrease())
            salario += salario * 0.1;
    }

    @Override
    public boolean validForIncrease() {
        return true;
    }

    @Override
    public double deduct() {
        return salario * 0.035;
    }
    
    
}
