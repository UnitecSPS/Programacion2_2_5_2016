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
public class CuentaBancaria {
    private int cod;
    private String cliente;
    private double saldo;
    private TipoCuenta tipo;

    public CuentaBancaria(int cod, String cliente, TipoCuenta tipo) {
        this.cod = cod;
        this.cliente = cliente;
        this.tipo = tipo;
        saldo = tipo.minSaldo;
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
}
