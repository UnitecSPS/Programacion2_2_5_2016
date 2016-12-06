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
public class TestLista {
    public static void main(String[] args) {
        ListaNodo ln = new ListaNodo();
        
        //add
        ln.add( new Nodo("Hola") );
        ln.add( new Nodo("Pancho") );
        ln.add( new Nodo("Sancho") );
        ln.add( new Nodo("Chancho") );
        
        //print
        ln.printList();
    }
}
