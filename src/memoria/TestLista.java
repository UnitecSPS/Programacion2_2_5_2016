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
        
        //contains
        if(ln.contains("Sancho"))
            System.out.println("Existe Sancho!");
        if(!ln.contains("Rancho"))
            System.out.println("No Contiene a rancho!");
        
        //add in the middle
        try{
            ln.add(0, new Nodo("Rancho") );
            ln.add(2, new Nodo("Nacho") );
            ln.add(6, new Nodo("Juancho") );
            ln.add(8, new Nodo("Cacho") );
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Error: "+e.getMessage());
        }
        System.out.println("\nDespues de agregar 2:\n----");
        ln.printList();
        System.out.println("size: "+ln.size());
       
    }
}
