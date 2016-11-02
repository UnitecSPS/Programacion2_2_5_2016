/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

import java.util.Calendar;

/**
 *
 * @author Aula
 */
public final class EmpleadoTemporal extends EmpleadoComun {
    private Calendar finContrato;
    
    public EmpleadoTemporal(int c, String n){
        super(c,n,8000);
        finContrato = Calendar.getInstance();
        //System.out.println("Llamando Temporal");
    }
    
    @Override
    public double pagar(){
        Calendar hoy = Calendar.getInstance();
        if(hoy.before(finContrato))
            return super.pagar();
        return 0;
    }

    public Calendar getFinContrato() {
        return finContrato;
    }

    public void setFinContrato(int y, int m, int d) {
        this.finContrato.set(y, m, d);
    }
    
    @Override
    public void quienSoy(){
        System.out.println("Sn un Empleado con Salario pero Temporal");
    }

    @Override
    public String toString() {
        return super.toString() + " finContrato = "+finContrato.getTime(); 
    }
    
    
}
