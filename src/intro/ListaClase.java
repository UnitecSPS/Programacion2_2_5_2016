/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intro;

import java.util.ArrayList;

/**
 *
 * @author Aula
 */
public class ListaClase {
    public static void main(String[] args) {
        ArrayList<MiClase> lista = new ArrayList<>();
        lista.add(new MiClase(1));
        
        for(MiClase mc : lista)
            mc.print();
    }
}
