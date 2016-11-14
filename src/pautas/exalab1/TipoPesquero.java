package pautas.exalab1;

public enum TipoPesquero
{
   PEZ(15), CAMARON(40), LANGOSTA(60);


   public final double price;

   TipoPesquero(double price)
   {
      this.price = price;
   }
}
