package app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.print("Introduce el Dato: ");
        String DatoP; //Declara el dato que se va a pedir
        Scanner DatoScan=new Scanner(System.in); //Se pide el dato
        DatoP=DatoScan.nextLine();//Se guarda el dato en un string
        int [] Dato; //se declara el int donde sera guardado
        
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