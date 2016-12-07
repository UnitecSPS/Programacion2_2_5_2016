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
        ListaNodo lista = new ListaNodo();
        lista.add(new Nodo("david1"));
        lista.add(new Nodo("david2"));
        lista.add(new Nodo("david3"));
        lista.add(new Nodo("david4"));
        lista.add(new Nodo("david5"));
        lista.add(new Nodo("david6"));
        lista.add(new Nodo("david7"));

        lista.printList();
        System.out.println("\nSIZE = " + lista.size());
        lista.remove("david2");

        System.out.println();
        lista.printList();
        System.out.println("\nSIZE = " + lista.size());
        System.out.println();
        lista.remove("david5");
        System.out.println();
        lista.printList();
        System.out.println("\nSIZE = " + lista.size());


        int n = lista.indexOf("david7");

        System.out.println("\nINDEX OF david7 = " + n);

        System.out.println("\nLISTA GET posicion 3 (empezando de 0) = "
                + lista.get(3));

        System.out.println("\nLISTA CONTAINS david3 = " + lista.contains("david3"));
        System.out.println("\nLISTA CONTAINS david5 = " + lista.contains("david5"));


        lista.clear();

        lista.printList();

    }
}
