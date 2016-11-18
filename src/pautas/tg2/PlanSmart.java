/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas.tg2;
/**
 *
 * @author Diegu7
 */
public class PlanSmart extends PlanBasico{
    
    public PlanSmart(int numero, String nombre) {
        super(numero, nombre);
    }
    
    @Override
    public double pagoMensual(){
        double mins = monthlyMinutes() - 300;
        mins = mins > 0 ? mins : 0;
        return 42 + (mins*0.5);
    }
    
    @Override
    public String toString(){
        return super.toString()+ " - Plan Smart";
    }
}
