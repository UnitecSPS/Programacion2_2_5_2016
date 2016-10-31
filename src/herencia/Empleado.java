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
public abstract class Empleado {
    protected int codigo;
    protected String nombre;
    protected Calendar contratacion;
    
    public Empleado(int c, String n){
        //System.out.println("Llamando a Papi");
        codigo = c;
        nombre = n;
        contratacion = Calendar.getInstance();
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Calendar getContratacion() {
        return contratacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public abstract double pagar();
    
    public abstract double bono();
    
    public void quienSoy(){
        System.out.println("Soy un Empleado Generico");
    }

    @Override
    public String toString() {
        return "Empleado{" + "codigo=" + codigo + ", nombre=" + nombre + '}';
    }
    
    
}
