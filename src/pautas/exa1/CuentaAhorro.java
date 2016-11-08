/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pautas.exa1;

import java.util.Calendar;

/**
 *
 * @author mac
 */
public final class CuentaAhorro extends CuentaBancaria {
    private Calendar fecha;
    private boolean activa;

    public CuentaAhorro(int numero, String nombre) {
        super(numero, nombre);
        fecha = Calendar.getInstance();
        activa = true;
    }
    
    @Override
    public void deposito(double m){
        if(!activa)
            m = m * 0.9;
        saldo += m;
        //actualizar fecha
        fecha = Calendar.getInstance();
    }

    @Override
    public boolean retiro(double m) {
        if(activa && saldo > m){
            saldo -= m;
            //actualizar fecha
            fecha = Calendar.getInstance();
            return true;
        }
        return false;
    }
    
    public void desactivar(){
        Calendar hace6 = Calendar.getInstance();
        hace6.add(Calendar.MONTH, -6);
        if(fecha.before(hace6))
            activa = false;
    }

    @Override
    public String toString() {
        return super.toString() + (activa ? "-ACTIVA" : "-DESACTIVADA");
    }
    
    
    
}
