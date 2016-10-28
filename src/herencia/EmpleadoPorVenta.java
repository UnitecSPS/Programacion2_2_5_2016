
package herencia;

import java.util.Calendar;

public class EmpleadoPorVenta extends EmpleadoComun {
    private double ventas[];

    public EmpleadoPorVenta(int c, String n, double sal) {
        super(c, n, sal);
        ventas = new double[12];
    }
    
    private int mesActual(){
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.MONTH);
    }
    
    public void agregarVenta(double v){
        ventas[mesActual()] += v;
    }
    
    public double comision(){
        return ventas[mesActual()] * 0.1;
    }
    
    @Override
    public double pagar(){
        return super.pagar() + comision();
    }

    @Override
    public String toString() {
        return super.toString()+ " comision="+comision(); 
    }

    @Override
    public void quienSoy() {
        System.out.println("Soy un Empleado que gana Comision"); 
    }
    
    
}
