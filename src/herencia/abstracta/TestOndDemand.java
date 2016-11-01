/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia.abstracta;

import herencia.Empleado;

/**
 *
 * @author Aula
 */
public class TestOndDemand {
    public static void main(String[] args) {
        Empleado e = new Empleado(1,"Hola"){
            
            public double horas(){
                System.out.println("Llamando a horas..");
                return 20;
            }
            
            @Override
            public double bono(){
                if(horas() > 40)
                    return 1000;
                return 0;
            }
            
            @Override
            public double pagar(){
                return 5000+bono();
            }
            
            @Override
            public String toString(){
                return "Empleado OnDemand";
            }
        };
        
        System.out.println("Pagar: "+ e.pagar());
        System.out.println(e);
    }
}
