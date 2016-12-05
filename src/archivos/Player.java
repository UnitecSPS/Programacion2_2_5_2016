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
public class Player implements Serializable{
    public String nombre;
    public transient int points;
    public  Membership member;

    public Player(String nombre, int points) {
        this.nombre = nombre;
        this.points = points;
        member = new Membership(5);
    }

    @Override
    public String toString() {
        return "Player{" + "nombre=" + nombre + ", points=" + points + 
                member+'}';
    }
    
    
}
