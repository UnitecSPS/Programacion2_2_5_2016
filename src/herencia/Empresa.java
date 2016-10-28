
package herencia;

import java.util.ArrayList;
import java.util.Scanner;


public class Empresa {
    static ArrayList<Empleado> empleados;
    static Scanner lea = new Scanner(System.in);
            
    public static void main(String[] args) {
        empleados = new ArrayList<>();
        int op;
        
        do{
            System.out.println("1- Agregar Empleado");
            System.out.println("2- Pagar Empleado");
            System.out.println("3- Lista de Empleados");
            System.out.println("4- Sub Menu especifico");
            System.out.println("5- Salir");
            System.out.print("Escoja Opcion: ");
            op = lea.nextInt();
            
            switch(op){
                case 1:
                    hire();
                    break;
                case 2:
                    pay();
                    break;
                case 3:
                    list();
                    break;
                case 4:
                    submenu();
                    break;
            }
        }while(op!=5);
        
    }
    
    /**
     * Recorre la lista de Empleados. Si encuentra un
     * empleado con ese codigo, se retorna, sino, retorna null
     * @param cod Codigo del Empleado
     * @return El obj Empleado si se encuentra, null si no
     */
    private Empleado search(int cod){
        for (Empleado i : empleados) {
            if (i.codigo == cod)
                return i;
        }
        return null;
    }
    private Empleado searchRecursiva(int cod, int conta) {
        if (conta < empleados.size()) {
            if (empleados.get(conta).codigo == cod)
                return empleados.get(conta);
            return searchRecursiva(cod, conta+1);
        }
        return null;
    }
    private Empleado searchRecursiva(int con) {
        return searchRecursiva(con, 0);
    }

    /**
     * Contrata un nuevo empleado
     * 1- Se pide del teclado el tipo: COMUN, HORA, VENTA o TEMPORAL
     * 2- Se instancia un objeto segun el tipo y se guarda en el arreglo
     * 3- pero siempre y cuando el Codigo NO este repetido
     * 4- LOS DATOS requeridos se ingresan del teclado
     */
    private static void hire() {
        System.out.println("Que tipo de empleado contratara?");
        String tipo = lea.next();
        System.out.println("Coloque el salario del empleado");
        double sal = lea.nextDouble();
        System.out.println("Coloque el nombre del empleado");
        String nom = lea.next();
        System.out.println("Coloque el codigo del empleado");
        int cod = lea.nextInt();
        for (Empleado i : empleados) {
            if (i.codigo == cod) {
                System.out.println("Codigo ya esta en uso, vuelva a comenzar");
                hire();
            }
        }
        if (tipo.equals("comun"))
            empleados.add(new EmpleadoComun(cod, nom, sal));
        else if (tipo.equals("hora"))
            empleados.add(new EmpleadoPorHora(cod, nom));
        else if (tipo.equals("venta"))
            empleados.add(new EmpleadoPorVenta(cod, nom, sal));
        else
            empleados.add(new EmpleadoTemporal(cod, nom));
    }

    /**
     * Le paga a un empleado
     * 1- Pide del teclado el codigo
     * 2- Buscamos ese empleado
     * 3- Si existe, mostramos en pantalla su pago
     */
    private static void pay() {
        System.out.println("Para pagar escriba el codigo del empleado");
        int cod = lea.nextInt();
        for (Empleado i : empleados) {
            if (i.codigo == cod)
                System.out.println("Se ha pagado" + i.pagar() + " al empleado " + i.nombre);
        }
    }

    /**
     * Imprimir la lista de empleados
     */
    private static void list() {
        System.out.println("Estos son todos los empleados de la empresa");
        for (Empleado i : empleados) {
            i.toString();
        }
    }

    
    private static void submenu() {
        int op;
        do{
            System.out.println("1-Fecha Fin Contrato a Temporales");
            System.out.println("2-Ingresar Venta");
            System.out.println("3-Ingresar Horas de Trabajo");
            System.out.println("4-Regresar al Menu Principal");
            System.out.print("Escoja Opcion: ");
            op = lea.nextInt();
            
            switch(op){
                case 1:
                    setFin();
                    break;
                case 2:
                    ventas();
                    break;
                case 3:
                    horas();
            }
            
        }while(op!=4);
    }
    
    /**
     * 1- Leer un codigo
     * 2- Buscar el empleado, que existe y q sea Temporal
     * 3- Si concuerda, set fecha fin contrato
     * 4- Leer del teclado los datos
     */
    private static void setFin() {
        
    }

    /**
     * 1- Leer un codigo
     * 2- Buscar empleado, que exista y que sea PorVentas
     * 3- Si concuerda, agregar una venta
     * 4- Leer del teclado los datos
     */
    private static void ventas() {
        
    }

    /**
     * 1- Leer un codigo
     * 2- Buscar empleado, que exista y que sea PorHoras
     * 3- Si concuerda, agregar las horas trabajadas
     * 4- Leer del teclado los datos
     */
    private static void horas() {
        
    }
}
