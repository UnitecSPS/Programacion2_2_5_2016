package pautas.exalab1;

import java.util.Calendar;

public abstract class Barco
{
   protected String nombre;
   protected Calendar inicio;


   public Barco(String nombre)
   {
      this.nombre = nombre;
      inicio = Calendar.getInstance();
   }


   public final String getNombre()
   {
      return nombre;
   }

   public final Calendar getInicio()
   {
      return inicio;
   }

   @Override
   public String toString()
   {
      return nombre;
   }

   abstract void agregarElemento();

   abstract double vaciarCobrar();

   abstract double precioElemento();

}
