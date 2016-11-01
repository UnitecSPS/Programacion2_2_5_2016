
package herencia.abstracta;

import java.util.ArrayList;

public class Granja {
    
    static Animal ballena = new Animal(0, "blanca") {
        @Override
        public void hablar() {
            System.out.println("muuuu");
        }
        
        @Override
        public void queComo() {
            System.out.println("planton");
        }
    };
    
    static Animal tacuazin = new Animal(4, "raza desconocida") {
        
        @Override
        public void hablar() {
            System.out.println("como gallinas");
        }
        
        @Override
        public void queComo() {
            System.out.println("yo no hablo");
        }
    };
    
    static ArrayList<Animal> miGranja = new ArrayList<>();
    
    public static void main(String[] args) {
        
        miGranja.add(tacuazin);
        miGranja.add(ballena);
        miGranja.add(new Loro("Guacamaya"));
        miGranja.add(new Mono("Cara blanca"));
        miGranja.add(new Perro("Aguacatero"));
        
    }
    
}
