
package herencia.abstracta;


public class Mono extends Animal{
    
    public Mono(String s) {
        super(4, s);
    }
    
    @Override
    public void hablar() {
        System.out.println("quiero banana");
    }
    
    @Override
    public void queComo() {
        System.out.println("bananas");
    }
}
