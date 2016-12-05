/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.Serializable;

/**
 *
 * @author Aula
 */
public class Membership implements Serializable {
    int version;

    public Membership(int version) {
        this.version = version;
    }

    
    
    @Override
    public String toString() {
        return "Membership{" + "version=" + version + '}';
    }
    
    
}
