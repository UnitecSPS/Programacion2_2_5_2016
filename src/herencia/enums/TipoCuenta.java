
package herencia.enums;

public enum TipoCuenta {
    AHORRO(0.02, 1000), CHEQUES(0, 7000), PLAZOFIJO(0.08, 1000000), VIP(0.05, 10000);
    
    public final double tasa;
    public final double saldo;
    
    private TipoCuenta(double t, double s){
        tasa = t;
        saldo = s;
    }
}
