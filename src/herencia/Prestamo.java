/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

/**
 *
 * @author Aula
 */
public class Prestamo {
    protected int cod;
    protected String cliente;
    protected double monto;
    
    public Prestamo(int c, String n, double m){
        cod = c;
        cliente = n;
        monto = m;
    }
    
    @Override
    public String toString(){
        return cod+cliente+monto;
    }
}
