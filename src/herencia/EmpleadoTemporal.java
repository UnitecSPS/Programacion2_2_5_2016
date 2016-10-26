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
public class EmpleadoTemporal extends EmpleadoComun {
    private Calendar finContrato;
    
    public EmpleadoTemporal(int c, String n){
        super(c,n,8000);
        //System.out.println("Llamando Temporal");
    }

    public Calendar getFinContrato() {
        return finContrato;
    }

    public void setFinContrato(int y, int m, int d) {
        this.finContrato.set(y, m, d);
    }
    
    
}
