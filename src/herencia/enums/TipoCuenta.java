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
    AHORRO(0.02), CHEQUES(0), PLAZOFIJO(0.08), VIP(0.05);
    
    public final double tasa;
    
    private TipoCuenta(double t){
        tasa = t;
    }
}
