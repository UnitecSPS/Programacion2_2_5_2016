package pautas.exalab2;
import java.util.ArrayList;

/**
 * Created by David on 12/16/16.
 */
public class Residencia {
    final int code;
    final String name;
    ArrayList<String> names;
    Residencia prev; //previous o anterior
    Residencia next; //next o siguiente

    public Residencia(int code, String name) {
        this.code = code;
        this.name = name;
        names = new ArrayList<>();
        prev = null;
        next = null;
    }

    public void addInquilino(String s) {
        names.add(s);
    }

    public void print() {
        System.out.println("Code=" + code);
        System.out.println("Name=" + name);
        for (String s : names) {
            System.out.println("-" + s);
        }
    }
}
