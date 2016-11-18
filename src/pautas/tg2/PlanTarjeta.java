package pautas.tg2;
import java.util.Calendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class PlanTarjeta extends PlanBasico {
    private double saldo;
   
    public PlanTarjeta(int c, String s) {
        super(c, s);
        saldo = 0;
    }
   
    public void aplicarTarjeta(double m) {
        Calendar hoy = Calendar.getInstance();
        
        if (m > 0){
            if(hoy.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
                m *= 3;
            saldo += m;
        }
    }

    @Override
    public void call(int num, double mins) {
        double monto = mins * 0.7;
        if(monto <= saldo){
            saldo -= monto;
            super.call(num, mins);
        }
    }
    
    @Override
    public double pagoMensual() {
        return 0;
    }
   
    @Override
    public String toString() {
        return super.toString() + " Saldo: " + saldo + " -PlanTarjeta";
    }
}
