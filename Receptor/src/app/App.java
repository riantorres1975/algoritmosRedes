package app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.print("Introduce el Dato: ");
        String DatoP;
        Scanner DatoScan=new Scanner(System.in);
        DatoP=DatoScan.nextLine();
        System.out.print("Introduce el divisor: ");
        String DivisorP;
        Scanner DivisorScan=new Scanner(System.in);
        DivisorP=DivisorScan.nextLine();
        System.out.println("Seleccione el tipo de Paridad");
        System.out.println("1. Par");
        System.out.println("2. Impar");
        System.out.print("Opcion: ");
        int OpcP;
        Scanner OpcScan=new Scanner(System.in);
        OpcP=OpcScan.nextInt();
        switch(OpcP){
            case 1:
                
                break;
            case 2: 
                
                break;
            default:
                System.out.println("Opcion no valida");
        }
    }
}