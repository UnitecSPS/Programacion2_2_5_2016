/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package errores;


/**
 *
 * @author Aula
 */
public class Claro {
    public static void main(String[] args) {
       
        try {
            a();
        } catch (PlanNotFoundException ex) {
            System.out.println(ex);
        }
    }

    private static void a() throws PlanNotFoundException{
        b();
    }

    private static void b() throws PlanNotFoundException{
        Tigo t = new Tigo();
        t.printPlan(5);
    }
}
