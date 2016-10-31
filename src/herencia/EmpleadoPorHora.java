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
public class EmpleadoPorHora extends Empleado {
    private int horasT;
    
    public EmpleadoPorHora(int c, String n){
        super(c,n);
    }

    public int getHorasT() {
        return horasT;
    }

    public void setHorasT(int horasT) {
        this.horasT = horasT;
    }
    
    @Override
    public double pagar(){
        double monto = horasT * 150;
        horasT = 0;
        return monto;
    }
    
    @Override
    public void quienSoy(){
        System.out.println("Soy un Empleado que Trabaja por Hora");
    }

    @Override
    public double bono() {
        if(horasT > 400)
            return 1000;
        return 0;
    }
}
