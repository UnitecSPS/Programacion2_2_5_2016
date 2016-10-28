
package herencia;

import java.util.Calendar;

public class Empleado {
    protected int codigo;
    protected String nombre;
    protected Calendar contratacion;
    
    public Empleado(int c, String n){
        //System.out.println("Llamando a Papi");
        codigo = c;
        nombre = n;
        contratacion = Calendar.getInstance();
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Calendar getContratacion() {
        return contratacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public double pagar(){
        return 0;
    }
    
    public double bono(){
        System.out.println("no hay bono pa ti");
        return 0;
    }
    
    public void quienSoy(){
        System.out.println("Soy un Empleado Generico");
    }

    @Override
    public String toString() {
        return "Empleado{" + "codigo=" + codigo + ", nombre=" + nombre + '}';
    }
    
    
}
