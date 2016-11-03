
package herencia.enums;

public class CuentaBancaria {
    private int cod;
    private String cliente;
    private double saldo;
    private TipoCuenta tipo;

    public CuentaBancaria(int cod, String cliente, TipoCuenta tipo) {
        this.cod = cod;
        this.cliente = cliente;
        this.tipo = tipo;
        saldo = 0;
    }
    
    public double tasa(){
        /*switch(tipo){
            case AHORRO:
                return 0.02;
            case PLAZOFIJO:
                return 0.08;
            case VIP:
                return 0.05;
            default:
                return 0;
        }*/
        return tipo.tasa;
    }
    
    public double getSaldo() {
        return tipo.saldo;
    }
}
