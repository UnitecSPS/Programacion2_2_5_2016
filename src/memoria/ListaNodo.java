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
    private int size = 0;
    
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
        size++;
    }
    
    public void printList(){
        Nodo tmp = root;
        while(tmp != null){
            System.out.println("-"+tmp);
            tmp = tmp.next;
        }
    }
    
    public void clear(){
        root = null;
    }
    
    public boolean contains(String name){
        Nodo tmp = root;
        while(tmp != null){
            if(tmp.name.equals(name))
                return true;
            tmp = tmp.next;
        }
        return false;
    }
    
    /**
     * Vamos a insertar el nodo, pero NO al final de la lista
     * sino, en la posicion especifica.
     * El resto se corre.
     * @param index
     * @param obj 
     * @throws IndexOutOfBoundsException Si el index se pasa de
     *   los limites
     */
    public void add(int index, Nodo obj){
        if(obj==null) return;
        if(index < 0 || index > size)
            throw new IndexOutOfBoundsException(index+" not valid");
        
        if(index == 0){
            obj.next = root;
            root = obj;
        }
        else{
            Nodo tmp = root;
            for(int n=0; n < index-1; n++)
                tmp = tmp.next;
            obj.next = tmp.next;
            tmp.next = obj;
        }
        size++;
    }
    
    public int size(){
        return size;
    }
    
    public boolean remove(String name){
        if(isEmpty()) return false;
        
        if(root.name.equals(name)){
            root = root.next;
            size--;
            return true;
        }
        else{
            Nodo tmp = root;
            while(tmp.next != null){
                if(tmp.next.name.equals(name)){
                    tmp.next = tmp.next.next;
                    size--;
                    return true;
                }
                tmp = tmp.next;
            }
        }
        
        return false;
    }
    
    public Nodo get(int index){
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException(index+" not valid");
        
        Nodo tmp = root;
        
        for(int c=0; c < index; c++){
            tmp = tmp.next;
        }
        
        return tmp;
    }
    
    public Nodo[] toArray(){
        return null;
    }
}
