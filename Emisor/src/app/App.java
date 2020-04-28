package app;

import java.util.Scanner;

public class App {
    public static void main(final String[] args) {

        System.out.print("Introduce un caracter: ");
        String LetraP;
        final Scanner LetraScan = new Scanner(System.in);
        LetraP = LetraScan.nextLine();
        int LetrasA = 0;
        LetrasA = LetraP.charAt(0);
        String b;
        b = Integer.toBinaryString(LetrasA);
        System.out.print("Introduce el divisor: ");
        String DivisorP;
        final Scanner DivisorScan = new Scanner(System.in);
        DivisorP = DivisorScan.nextLine();
        System.out.println("Seleccione el tipo de Paridad");
        System.out.println("1. Par");
        System.out.println("2. Impar");
        System.out.print("Opcion: ");

        //Opciones
        int OpcP;
        final Scanner OpcScan = new Scanner(System.in);
        menu(OpcP=OpcScan.nextInt());


    }



    static public void menu(int _opc){ //Menu opciones
        
        switch(_opc){
            case 1:
                
                break;
            case 2: 
                
                break;
            default:
                System.out.println("Opcion no valida");
        }

    }
}