package pautas.exalab1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;


public class Muelle
{
   static ArrayList<Barco> barcos = new ArrayList<>();;
   static Scanner lea = new Scanner(System.in);

   public static void main(String[] args)
   {
      int op = 0;

      do
      {

         System.out.println("\nBIENVENIDO A MI MUELLE");
         System.out.println("[1] Agregar Barco");
         System.out.println("[2] Agregar elemento a un barco");
         System.out.println("[3] Vaciar Barco");
         System.out.println("[4] Barcos desde...");
         System.out.println("[0] Salir");
         op = lea.nextInt();
         switch (op)
         {
            case 1:
               System.out.println("TIPO DE BARCO: ");
               String tipo = lea.next();
               agregarBarco(tipo);
               break;
            case 2:
               System.out.println("NOMBRE DEL BARCO: ");
               String nom = lea.next();
               agregarElemento(nom);
               break;
            case 3:
               System.out.println("NOMBRE DEL BARCO: ");
               String nomb = lea.next();
               System.out.println("TOTAL: " + vaciarBarco(nomb));
               break;
            case 4:
               System.out.println("Año: ");
               int anio = lea.nextInt();
               barcosDesde(anio);
               break;
         }

      } while (op != 0);

   }

   public static void agregarBarco(String tipo)
   {
       System.out.println("Nombre del barco: ");
       String n = lea.next();
       
       if(buscar(n) == null){
           if(tipo.equalsIgnoreCase("PESQUERO")){
               System.out.println("Tipo de barco pesquero: ");
               barcos.add(new BarcoPesquero(n, TipoPesquero.valueOf(lea.next().toUpperCase())));
           }
           else if(tipo.equalsIgnoreCase("PASAJERO")){
               System.out.println("Tamaño: ");
               int max = lea.nextInt();
               System.out.println("Precio: ");
               double precio = lea.nextDouble();
               barcos.add(new BarcoPasajero(n, max, precio));
           }
       }
   }

   public static void agregarElemento(String nombre)
   {
      Barco bar = buscar(nombre);

      if (bar != null)
      {
         bar.agregarElemento();
      } else
      {
         System.out.println("¡BARCO NO EXISTE!¬");
      }
   }

   public static double vaciarBarco(String nombre)
   {
      Barco bar = buscar(nombre);

      if (bar != null)
      {
         System.out.println(bar);
         if (bar instanceof BarcoPasajero) 
             ((BarcoPasajero) bar).listarPasajeros();
         
         return bar.vaciarCobrar();
      } else
      {
         System.out.println("¡BARCO NO EXISTE!¬");
      }
      return 0;
   }

   private static void barcosDesde(int year, int pos)
   {
      if(pos < barcos.size()){
          Barco b = barcos.get(pos);
          if (b.getInicio().get(Calendar.YEAR) >= year){
               System.out.println("[Nombre:" + b.getNombre() +
                 ",Fecha Circulacion: " + b.getInicio().getTime() + "]");
          }

          barcosDesde(year, pos + 1);
      }
   }

   public static void barcosDesde(int year)
   {
      barcosDesde(year, 0);
   }

   private static Barco buscar(String nombre)
   {
      for (Barco b : barcos)
      {
         if (b.getNombre().equalsIgnoreCase(nombre))
         {
            return b;
         }
      }
      return null;
   }

}
