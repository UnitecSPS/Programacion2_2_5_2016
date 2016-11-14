package pautas.exalab1;

import java.util.Scanner;

public class BarcoPasajero extends Barco
{

   private String[] pasajeros;
   private double precioBoleto;
   private int numPasajeros;

   public BarcoPasajero(String nombre, int max, double precio)
   {
      super(nombre);
      pasajeros = new String[max];
      precioBoleto = precio;
      numPasajeros = 0;
   }


   @Override
   void agregarElemento()
   {
      Scanner lea = new Scanner(System.in);
       
      if (numPasajeros < pasajeros.length)
      {
         System.out.println("Ingrese nombre del pasajero: ");
         pasajeros[numPasajeros++] = lea.nextLine();
      } else
      {
         System.err.println("\n¡BARCO LLENO!\n");
      }
   }

   @Override
   double vaciarCobrar()
   {
      int x = numPasajeros;
      numPasajeros = 0;
      return x * precioBoleto;
   }

   @Override
   double precioElemento()
   {
      return precioBoleto;
   }

   @Override
   public String toString()
   {
      return super.toString() + "{Cantidad de Pasajeros que compraron boleto:" +
              numPasajeros + "}";
   }

   private void listarPasajeros(int pos)
   {
      if (pos < numPasajeros){
          System.out.println("-"+pasajeros[pos]);
          listarPasajeros(pos+1);
      }
      
   }

   public void listarPasajeros()
   {
      System.out.println("LISTADO DE PASAJEROS");
      listarPasajeros(0);
   }
}
