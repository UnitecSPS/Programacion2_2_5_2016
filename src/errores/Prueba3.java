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
public class Prueba3 {
    public static void main(String[] args) {
        Tigo tigo = new Tigo();
        
        try{
            tigo.printPlan(5);
        }
        catch(NullPointerException e){
            e.printStackTrace();
        }
        catch(PlanNotFoundException e){
            System.out.println(e.getMessage());
        }
        finally{
            System.out.println("Prueba Finalizada");
        }
    }
}
