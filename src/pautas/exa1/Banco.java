/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pautas.exa1;

import java.util.ArrayList;

/**
 *
 * @author mac
 */
public class Banco {
    private ArrayList<CuentaBancaria> cuentas = new ArrayList<>();
    
    public CuentaBancaria search(int cod){
        return search(cod,0);
    }

    private CuentaBancaria search(int cod, int pos) {
        if(pos < cuentas.size()){
            CuentaBancaria c = cuentas.get(pos);
            if(c.getNumero() == cod)
                return c;
            return search(cod, pos+1);
        }
        return null;
    }
    
    public void addCuenta(int num, String cli, TipoCuenta tipo){
        if(search(num) == null){
            if(tipo == TipoCuenta.AHORRO)
                cuentas.add(new CuentaAhorro(num, cli));
            else
                cuentas.add(new CuentaPlazoFijo(num, cli));
        }
    }
    
    public void evalDeactivations(){
        evalDeactivations(0);
    }

    private void evalDeactivations(int pos) {
        if(pos < cuentas.size()){
            CuentaBancaria c = cuentas.get(pos);
            if(c instanceof CuentaAhorro)
                ((CuentaAhorro)c).desactivar();
            evalDeactivations(pos+1);
        }
    }
    
    public void applyInterests(){
        for(CuentaBancaria c : cuentas){
            if(c instanceof CuentaPlazoFijo)
                c.deposito( c.getSaldo() * CuentaPlazoFijo.TASA );
        }
    }
    
    public boolean transfer(int nc1, int nc2, double m){
        CuentaBancaria c1 = search(nc1);
        CuentaBancaria c2 = search(nc2);
        
        if(c1 != null && c2 != null){
            if(c1.retiro(m)){
                c2.deposito(m);
                return true;
            }
        }
        return false;
    }
}
