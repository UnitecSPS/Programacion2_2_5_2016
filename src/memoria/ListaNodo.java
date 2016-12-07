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
    
    public void printList() {
        Nodo tmp = root;

        while (tmp != null) {
            System.out.println(tmp);
            tmp = tmp.next;
        }
    }

    public void remove(String s) {
        Nodo tmp = root;

        while (tmp != null) {
            if (tmp.next.name.equals(s)) {
                break;
            }
            tmp = tmp.next;
        }

        tmp.next = tmp.next.next;
    }

    public int indexOf(String s) {
        int x = 0;

        Nodo tmp = root;

        while (tmp != null) {
            if (tmp.name.equals(s)) {
                return x;
            }
            tmp = tmp.next;
            ++x;
        }

        return -1;
    }

    public Nodo get(int index) {
        int x = 0;

        Nodo tmp = root;

        while (tmp != null) {
            if (x == index) {
                return tmp;
            }
            tmp = tmp.next;
            ++x;
        }

        return null;
    }

    public int size() {
        int x = 1;

        Nodo tmp = root;

        while (tmp != null) {
            if (tmp.next == null) {
                return x;
            }
            tmp = tmp.next;
            ++x;
        }

        return 0;
    }

    public boolean contains(String s) {
        Nodo tmp = root;

        while (tmp != null) {
            if (tmp.name.equals(s)) {
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }

    private void clear(Nodo n) {
        if (n.next != null) {
            System.out.println("n.next != null y n = " + n);
            clear(n.next);
        }

        System.out.println("volviendo n = " + n + " a null");
        n.next = null;
    }

    public void clear() {
        clear(root);
        root = null;
    }

}
