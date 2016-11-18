package pautas.tg2;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Tigo {
    public ArrayList<PlanBasico> planes = new ArrayList<>();
   
    public void addPlan(int n, String name, String tipo) {
        if(search(n) == null){
            if(tipo.equals("tarjeta"))
                planes.add(new PlanTarjeta(n, name));
            else if (tipo.equals("smart"))
                planes.add(new PlanSmart(n, name));
            else
                planes.add(new PlanBasico(n, name));
        }
    }
   
    public PlanBasico search(int numTel) {
         for (PlanBasico i : planes) {
            if (i.numero == numTel) {
                return i;
            }
        }
        return null;
    }
    
    public void makeCall(int numTelOr, int numTelDes, double mins){
        PlanBasico plano = search(numTelOr);
        PlanBasico pland = search(numTelDes);
        
        if(plano != null){
            if(pland != null)
                mins /= 2;
            plano.call(numTelDes, mins);
        }
    }
    
    public double payplan(int numTel){
        PlanBasico plan = search(numTel);
        if(plan != null)
            return plan.pagoMensual();
        return 0;
    }
    
    public void activateCard(int numtel, double monto){
       PlanBasico plan = search(numtel);
       if(plan instanceof PlanTarjeta)
        ((PlanTarjeta) plan).aplicarTarjeta(monto);
    }
    
    public void viewPlan(int numTel){
        PlanBasico plan = search(numTel);
        if(plan != null)
            System.out.println(plan);
    }
}
