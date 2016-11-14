package pautas.exalab1;

public class BarcoPesquero extends Barco
{
   private int pecesCapturados;
   private TipoPesquero tipo;

   public BarcoPesquero(String nombre, TipoPesquero tipo)
   {
      super(nombre);
      pecesCapturados = 0;
      this.tipo = tipo;
   }



   @Override
   void agregarElemento()
   {
      pecesCapturados++;
   }

   @Override
   double vaciarCobrar()
   {
      int x = pecesCapturados;
      pecesCapturados = 0;
      return x * tipo.price;
   }

   @Override
   double precioElemento()
   {
      return tipo.price;
   }

   @Override
   public String toString()
   {
      return super.toString() + "{pecesCapturados= " + pecesCapturados + ", tipo=" + this.tipo + "}";
   }
}
