package pautas.tg2;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class MainPro {
    public static Tigo tigo = new Tigo();
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
		int choice;
		do{
                    System.out.println("---------------------\n1-Add Plan\n2-Search\n3-MakeCall\n4-Pay Plan\n5-Activate Card\n6-ViewPlan\n7-Cerrar\n-");
                    choice = scan.nextInt();
                    switch(choice){
                    case 1:
                        System.out.print("Ingrese el numer: \n-");
                        int numCrea = scan.nextInt();
                        System.out.print("Ingrese el nombre del cliente: \n-");
                        String cliente = scan.next();
                        System.out.print("Ingrese el tipo de plan: \n-");
                        String plan = scan.next().toLowerCase();
                        tigo.addPlan(numCrea,cliente, plan);
                        break;
                    case 2:
                        System.out.println("Numero a buscar: \n-");
                        int numSer = scan.nextInt();
                        System.out.println(tigo.search(numSer));
                        break;
                    case 3:
                        System.out.print("Ingrese el num original: \n-");
                        int numOr = scan.nextInt();
                        System.out.print("Ingrese el num destino: \n-");
                        int numDes = scan.nextInt();
                        System.out.print("Ingrese los minutos: \n-");
                        double mins = scan.nextDouble();
                        tigo.makeCall(numOr, numDes, mins);
                        break;
                    case 4:
                        System.out.print("Ingrese el num de pay plan: \n-");
                        int numPP = scan.nextInt();
                        System.out.println("Monto: " + tigo.payplan(numPP));
                        break;
                    case 5:
                        System.out.print("Ingrese el num de activar: \n-");
                        int numAC = scan.nextInt();
                        System.out.print("Ingrese el monto de activar: \n-");
                        double monto = scan.nextDouble();
                        tigo.activateCard(numAC, monto);
                        break;
                    case 6:
                        System.out.print("Ingrese el num para ver plan: \n-");
                        int numVP = scan.nextInt();                   
                        tigo.viewPlan(numVP);
                        break;
                    default:
                            break;
                    }
		}while(choice != 7);
    }
}
