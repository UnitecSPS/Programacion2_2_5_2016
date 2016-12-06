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
public class ListaNodo {
    private Nodo root = null;
    
    public boolean isEmpty(){
        return root == null;
    }
    
    public void add(Nodo obj){
        if(isEmpty())
            root = obj;
        else{
            Nodo tmp = root;
            
            while(tmp.next != null)
                tmp = tmp.next;
            tmp.next = obj;
        }
    }
    
    public void printList(){
        
    }
}
