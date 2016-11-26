/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package archivos;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Docente
 */
public class EmpleadosMain
{
    public static void main(String[] args)
    {
        Scanner lea = new Scanner(System.in);
        EmpleadosManager manager = new EmpleadosManager();
        
        int op = 0;
        
        do{
            System.out.println("\n\nMENU\n------------------");
            System.out.println("1- Agregar Empleado");
            System.out.println("2- Listar Empleados No Despedidos");
            System.out.println("3- Agregar Venta a Empleado");
            System.out.println("4- Pagar Empleado");
            System.out.println("5- Despedir Empleado");
            System.out.println("6- Salir");
            System.out.print("Escoja Opcion: ");
            
            try{
                op = lea.nextInt();
                
                switch(op){
                    case 1:
                        System.out.println("Nombre: ");
                        String n = lea.next();
                        System.out.println("Salario: ");
                        double sal = lea.nextDouble();
                        manager.addEmployee(n, sal);
                        break;
                    case 2:
                        manager.employeeList();
                        break;
                    case 5:
                        System.out.println("Codigo: ");
                        manager.fireEmployee(lea.nextInt());
                        break;
                }
            }catch(InputMismatchException e){
                lea.next();
                System.out.println("Ingrese un entero");
            }
            catch(IOException e){
                System.out.println("Error en Disco: "+e.getMessage());
            }
            
        }while(op!=6);
    }
}
