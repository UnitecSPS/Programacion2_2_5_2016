/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas.tg1;

import java.util.Calendar;

public class Ticket
{
    public int ref;
    public Calendar fecha;
    public double precio;
    
    public Ticket(int a, double b){
        ref=a;
        precio=b;
        fecha= Calendar.getInstance();
    }
    
    public int getRef(){
        return ref;
    }
    public Calendar getFecha(){
        return fecha;
    }
    public double getPrecio(){
        return precio;
    }
    public void print(){
        System.out.print("[NUMERO: "+ref+" PRECIO: "+precio+" FECHA: "+fecha.getTime() + "]");
    }
    
}
