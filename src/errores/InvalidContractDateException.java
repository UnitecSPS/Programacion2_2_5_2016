/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package errores;

import java.util.Calendar;

/**
 *
 * @author Aula
 */
public class InvalidContractDateException extends RuntimeException{
    public InvalidContractDateException(Calendar c){
        super(c.getTime()+" Is from the past.");
    }
}
