/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas.exa2;

/**
 *
 * @author Aula
 */
public enum TipoCuenta {
    NORMAL(0.02, 500), PLANILLA(0, 200), VIP(0.04, 1000);
    
    public final double tasa, saldoMin;
    
    private TipoCuenta(double t, double sm){
        tasa = t;
        saldoMin = sm;
    }
}
