package app;

import java.util.Scanner;

public class App {
    public static void main(final String[] args) {

        System.out.print("Introduce un caracter: ");
        String LetraP; //Declara el caracter que se va a pedir
        final Scanner LetraScan = new Scanner(System.in); //Se pide el caracter
        LetraP = LetraScan.nextLine(); //Se guarda el caracter
        System.out.println(convBinario(LetraP.charAt(0))); //Pasa a binario);
        
   
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



    static public void menu(final int _opc) { // Menu opciones
        
        switch(_opc){
            case 1:
                
                break;
            case 2: 
                
                break;
            default:
                System.out.println("Opcion no valida");
        }

    }

    static public String  convBinario(int valorAscii){ //A binario
           
            String numBinario = Integer.toBinaryString(valorAscii); 
            String aux ="0";
            if(numBinario.length()<8){
                return aux+=numBinario;
            }
            return   numBinario;
    }
}