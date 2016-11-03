
package herencia.enums;

public class Banco {
    public static void main(String[] args) {
        CuentaBancaria cb = new CuentaBancaria(1, "Maria", TipoCuenta.VIP);
        System.out.println("Tasa: "+cb.tasa());
        
        System.out.println("El saldo de Maria es: " + cb.getSaldo());
    }
}
