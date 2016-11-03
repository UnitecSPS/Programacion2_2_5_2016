/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia.enums;

/**
 *
 * @author Aula
 */
public enum TipoCuenta {
    AHORRO(0.02,500), CHEQUES(0,100), PLAZOFIJO(0.08,10000), VIP(0.05,5000);
    
    public final double tasa, saldoMin;
    
    private TipoCuenta(double t, double sm){
        tasa = t;
        saldoMin = sm;
    }
}
