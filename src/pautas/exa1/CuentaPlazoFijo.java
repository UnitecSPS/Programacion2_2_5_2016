/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pautas.exa1;

/**
 *
 * @author mac
 */
public class CuentaPlazoFijo extends CuentaBancaria {
    private double intereses;
    public static final double TASA = 0.1;
    
    public CuentaPlazoFijo(int numero, String nombre) {
        super(numero, nombre);
        intereses=0;
    }
    
    @Override
    public boolean retiro(double m) {
        if(intereses > m){
            intereses -= m;
            return true;
        }
        return false;
    }
    
    /**
     * NO HABIA QUE HACER LAS SIGUIENTES FUNCIONES!
     * Pero asi deberia de ser la cuenta
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    @Override
    public void deposito(double m){
        intereses += m;
    }
    
}
