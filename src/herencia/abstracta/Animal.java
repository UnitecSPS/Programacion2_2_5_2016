
package herencia.abstracta;


public abstract class Animal {
    protected int patas;
    protected String raza;
    
    public Animal(int p, String r){
        patas = p;
        raza = r;
    }

    public int getPatas() {
        return patas;
    }

    public String getRaza() {
        return raza;
    }
    
    public abstract void hablar();
    public abstract void queComo();
}
