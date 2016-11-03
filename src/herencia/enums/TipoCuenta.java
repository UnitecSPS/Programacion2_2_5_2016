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
    AHORRO(0.02, 0.01), CHEQUES(0, 0), PLAZOFIJO(0.08, 0.05), VIP(0.05, 0.02);
    
    public final double tasa;
    public final double minSaldo;
    
    private TipoCuenta(double t, double min){
        tasa = t;
        minSaldo = min;
    }
}
