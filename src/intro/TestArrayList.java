/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intro;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Aula
 */
public class TestArrayList {
    public static void main(String[] args) {
        //Crear un arraylist
        ArrayList<String> coleccion = new ArrayList<>();
        ArrayList<Integer> coleccion1 = new ArrayList<>();
        ArrayList<Double> coleccion2 = new ArrayList<>();
        ArrayList<Character> coleccion3 = new ArrayList<>();
        /*
        Agregar valores:
            arra[pos] = valor;
        */
        coleccion.add("Carlos");
        coleccion.add("Jose");
        coleccion.add("Monica");
        /*
            Utilizar un valor de la coleccion
            Sout( arra[pos] )
        */
        System.out.println("[0]: "+ coleccion.get(0) );
        /*
         Recorrer un arreglo
        */
        for(String cad : coleccion){
            System.out.println("-"+cad);
        }
        /*
            Tamaño:
                arra.length
        */
        System.out.println("Tamaño: "+ coleccion.size() );
        /*
            Eliminar elementos
        */
        coleccion.remove(1);
        System.out.println("Luego de Remove el 1: ");
        for(String cad : coleccion){
            System.out.println("-"+cad);
        }
        /*
            Guardar un valor en una posicion especifica
        */
        coleccion.add(0,"Raul");
        System.out.println("Luego de agregar en la 0: ");
        for(String cad : coleccion){
            System.out.println("-"+cad);
        }
        /*
            Substituir un valor
        */
        coleccion.set(1, "Gochez");
        System.out.println("Luego de modificar la 1: ");
        for(String cad : coleccion){
            System.out.println("-"+cad);
        }
        /*
            Busquedas
        */
        if( coleccion.contains("Monica") )
            System.out.println("Si tiene a Monica en la "+
                    coleccion.indexOf("Monica"));
        /*
        Eliminar todo
        */
        coleccion.clear();
        
        
        //primitivos
        coleccion1.add(1);
        coleccion2.add(5.3);
        char l = 'H';
        coleccion3.add(l);
    }
}
