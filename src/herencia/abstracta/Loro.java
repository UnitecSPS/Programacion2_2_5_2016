
package herencia.abstracta;

public class Loro extends Animal{
    
    public Loro(int i, String s) {
        super(i, s);
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
