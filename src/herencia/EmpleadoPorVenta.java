/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

import java.util.Calendar;

/**
 *
 * Hereda de EmpleadoComun.
 *  Atributo extra que es un arreglo de 12 posiciones de double
 *  Generar una funcion comision() que por ahora retorne 0
 *  Redefinir quiensoy y toString
 */

public final class EmpleadoPorVenta extends EmpleadoComun {
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
