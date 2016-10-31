
package herencia.abstracta;


public class Mono extends Animal{
    
    public Mono(int i, String s) {
        super(i, s);
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
