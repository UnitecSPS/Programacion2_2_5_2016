
package herencia.abstracta;


public class Perro extends Animal{
    
    public Perro(String s) {
        super(4, s);
    }
    
    @Override
    public void hablar() {
        System.out.println("yo digo WOOF WOOF");
    }
    
    @Override
    public void queComo() {
        System.out.println("yo como comida para perro");
    }
    
}
