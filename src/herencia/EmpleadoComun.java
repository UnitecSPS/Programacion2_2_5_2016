
package herencia;

public class EmpleadoComun extends Empleado {
    protected double salario;
    
    public EmpleadoComun(int c, String n, double sal){
        super(c,n);
        salario = sal;
        //System.out.println("Llamando a Comun");
        
    }
    
    public double pagar(){
        return salario - (salario*0.035);
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
    
    
}
