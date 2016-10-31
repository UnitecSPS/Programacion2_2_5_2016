/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

import java.util.ArrayList;

/**
 *
 * @author Aula
 */
public class MyCompany {
    public static void main(String[] args) {
        ArrayList<Empleado> emps = new ArrayList<>();
        
        emps.add(new EmpleadoComun(1,"Carlos",1000));
        emps.add(new EmpleadoPorHora(2,"Jose"));
        emps.add(new EmpleadoTemporal(3,"Frances"));
        //Agregar un empleado por venta
        
        //-------
        for(Empleado em : emps){
            em.quienSoy();
            System.out.println(em);
        }
        
        //------------------------------
        Empleado et = emps.get(0);
        System.out.println(et);
        if(et instanceof EmpleadoTemporal)
            System.out.println("Si soy descendiente de Empleado");
        
        Empleado ev = new EmpleadoPorVenta(6, "Maria", 3000);
        //Downcasting
        //1- Indirecto
        EmpleadoPorVenta eventa = (EmpleadoPorVenta)ev;
        eventa.agregarVenta(78000);
        System.out.println(ev);
        //2- Directo
        System.out.println("Comision: "+((EmpleadoPorVenta)ev).comision());
    }
}
