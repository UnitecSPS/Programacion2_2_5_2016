package pautas.tg2;
import java.util.ArrayList;
import java.util.Calendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class PlanBasico {
    protected int numero;
    protected String nombre;
    protected ArrayList<LogCall> arrLogCall = new ArrayList<>();
    
    
    public PlanBasico(int numero, String nombre){
        this.numero = numero;
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void call(int num, double mins){
        arrLogCall.add(new LogCall(num, mins));
    }
    
    public double monthlyMinutes(){
        Calendar hoy = Calendar.getInstance();
        Calendar inicio = Calendar.getInstance();
        Calendar fin = Calendar.getInstance();
        
        inicio.set(hoy.get(Calendar.YEAR), hoy.get(Calendar.MONTH), 1, 0, 0);
        fin.set(hoy.get(Calendar.YEAR), hoy.get(Calendar.MONTH)+1, 1, 0, 0);
        
        double minsTot = 0;
        for(LogCall i : arrLogCall){
            if(i.fecha.after(inicio) && i.fecha.before(fin)){
                minsTot = minsTot + i.minutosDuracion;
            }
        }
        return minsTot;
    }
    
    public double pagoMensual(){
        return monthlyMinutes() * 0.5;
    }
    
    @Override
    public String toString(){
        return "Numero: " + numero + " - Nombre: " + nombre;
    }
    
    public void Imprimir(){
        Calendar hoy = Calendar.getInstance();
        Calendar inicio = Calendar.getInstance();
        Calendar fin = Calendar.getInstance();
        
        inicio.set(hoy.get(Calendar.YEAR), hoy.get(Calendar.MONTH), 1, 0, 0);
        fin.set(hoy.get(Calendar.YEAR), hoy.get(Calendar.MONTH)+1, 1, 0, 0);
        
        System.out.println(this);
        
        for(LogCall i : arrLogCall){
            if(i.fecha.after(inicio) && i.fecha.before(fin)){
                System.out.println(i);
            }
        }
    }
}
