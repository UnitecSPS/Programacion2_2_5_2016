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
public class Banco {
    public static void main(String[] args) {
        CuentaBancaria cb = new CuentaBancaria(1, "Maria", TipoCuenta.VIP);
        System.out.println("Tasa: "+cb.tasa());
        System.out.println("Saldo: "+cb.getSaldo());
    }
}
