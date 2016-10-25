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
public class Empleado {
    protected int codigo;
    protected String nombre;
    protected Calendar contratacion;
    
    public Empleado(int c, String n){
        System.out.println("Llamando a Papi");
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
    
    public double pagar(){
        return 0;
    }
    
    public double bono(){
        return 0;
    }
}
