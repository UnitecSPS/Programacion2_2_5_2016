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
public class AccountAlreadyExistException extends Exception{
    public AccountAlreadyExistException(int c){
        super("Cuenta "+c+" ya esta agregada");
    }
}
