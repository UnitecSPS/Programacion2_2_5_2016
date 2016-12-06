/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoria;

/**
 *
 * @author Aula
 */
public class Nodo {
    public String name;
    public Nodo next = null;

    public Nodo(String nombre) {
        this.name = nombre;
    }

    @Override
    public String toString() {
        return name;
    }
}
