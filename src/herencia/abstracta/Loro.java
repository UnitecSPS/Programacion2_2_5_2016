
package herencia.abstracta;

public class Loro extends Animal{
    
    public Loro(String s) {
        super(2, s);
    }
    
    @Override
    public void hablar() {
        System.out.println("a a i i tuki tuki");
    }
    
    @Override
    public void queComo() {
        System.out.println("arroz y otros granos");
    }
}
