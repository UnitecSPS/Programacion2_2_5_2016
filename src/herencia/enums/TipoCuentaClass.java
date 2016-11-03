/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia.enums;

/**
 *
 * @author Aula
 */
public class TipoCuentaClass {
    public static final TipoCuentaClass AHORRO = new TipoCuentaClass("AHORRO",0,0.02);
    public static final TipoCuentaClass CHEQUES = new TipoCuentaClass("CHEQUES",1,0);
    public static final TipoCuentaClass PLAZOFIJO = new TipoCuentaClass("PLAZOFIJO",2,0.08);
    public static final TipoCuentaClass VIP = new TipoCuentaClass("VIP",3,0.05);
    private String name;
    private int ordinal;
    public final double tasa;
    
    public TipoCuentaClass(String n, int o, double t){
        name = n;
        ordinal = o;
        tasa = t;
    }
    
    public String name(){
        return name;
    }
    
    public int ordinal(){
        return ordinal;
    }
    
    @Override
    public String toString(){
        return name();
    }
    
    public static TipoCuentaClass[] values(){
        TipoCuentaClass[] vals = { AHORRO, CHEQUES, PLAZOFIJO, VIP };
        return vals;
    }
    
    public static TipoCuentaClass valueOf(String n){
        for(TipoCuentaClass t : values()){
            if(t.name().equals(n))
                return t;
        }
        throw new IllegalArgumentException(n+" No es valido");
    }
}
