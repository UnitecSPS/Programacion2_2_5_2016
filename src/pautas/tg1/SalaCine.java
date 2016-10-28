/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas.tg1;

import java.util.Calendar;

public class SalaCine
{

    Ticket[][] tickets;
    int ticketsVendidos;

    public SalaCine()
    {
        this.tickets = new Ticket[10][30];
        this.ticketsVendidos = 0;
    }
    
    public Coordenada searchTicketByReference(int number)
    {
        return searchTicketByReference(number, 0, 0);
    }

    private Coordenada searchTicketByReference(int number, int f, int c)
    {
        if (f < 10)
        {
            if (c < 30)
            {
                //valida que la posicion no este nula y que sea el numero que busco
                if (tickets[f][c] != null && tickets[f][c].getRef() == number)
                {
                    return new Coordenada(f, c);
                } 
                return searchTicketByReference(number, f, c + 1);
            } 
            return searchTicketByReference(number, f + 1, 0);
        }
        return null;
    }
    
    public boolean isPalindromo(String name)
    {
        return isPalindromo(name,0,name.length()-1);
    }
    
    private boolean isPalindromo(String name, int inicio, int fin){
        if(inicio < fin){
            if(name.charAt(inicio) == name.charAt(fin))
                return isPalindromo(name, inicio+1, fin-1);
            return false;
        }
        return true;
    }
    
    public double income()
    {
        return income(0, 0, 0);
    }

    private double income(int f, int c, double total)
    {
        if (f < 10)
        {
            if (c < 30)
            {
                if (tickets[f][c] != null)
                {
                    total += tickets[f][c].getPrecio();
                } 
                return income(f, c + 1, total);
            } else
            {
                return income(f + 1, 0, total);
            }
        }
        return total;
    }
    
    private void reset(int f, int c)
    {
        if (f < 10)
        {
            if (c < 30)
            {
                tickets[f][c] = null;
                reset(f, c + 1);
            }
            reset(f + 1, 0);
        }
    }

    public void reset()
    {
        reset(0, 0);
    }

    public void sellTicket(String cliente, int numFila, int numColumna)
    {
        if (tickets[numFila][numColumna] == null) //si esta vacio
        {
            ticketsVendidos++;
            Calendar calendar = Calendar.getInstance();
            int dia = calendar.get(Calendar.DAY_OF_WEEK);
            double precio = 100;
            
            if (dia == Calendar.TUESDAY) //si el dia de venta es martes
            {
                precio /= 2;
            } else if (dia == Calendar.THURSDAY
                    && isPalindromo(cliente))
            {
                precio *= 0.7;
            }
            
            tickets[numFila][numColumna] = new Ticket(ticketsVendidos, precio);

        } else
        {
            System.err.println("EL ASIENTO SE ENCUENTRA OCUPADO, INTENTE CON OTRO");
        }
    }

    private void printSala(int fila, int col)
    {
        if (fila < 10)
        {
            if (col < 30)
            {
                if (tickets[fila][col] != null)
                {
                    tickets[fila][col].print();
                } else
                {
                    System.out.print("[DISPONIBLE]");
                }
                
                printSala(fila, col + 1);
            } else
            {
                System.out.println("");
                printSala(fila + 1, 0);
            }
        }

    }

    public void printSala()
    {
        printSala(0, 0);
    }

    public boolean cancelTicket(int n)
    {
        Coordenada c = searchTicketByReference(n);
        if(c != null){
            tickets[c.fila][c.columna] = null;
            return true;
        }
        return false;
    }

    public void eventClose()
    {
        System.out.println("TOTAL DE INGRESOS: " + income());
        reset();
    }

    
}
