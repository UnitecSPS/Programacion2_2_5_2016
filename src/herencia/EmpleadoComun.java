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
public class EmpleadoComun extends Empleado {
    protected double salario;
    
    public EmpleadoComun(int c, String n, double sal){
        super(c,n);
        System.out.println("Llamando a Comun");
        
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    
}
