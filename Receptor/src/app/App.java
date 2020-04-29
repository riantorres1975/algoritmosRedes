package app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int[] dividendo;//Se crean arreglos de entero
        int[] largo_p;
        int[] resto;
        int[] crc;
        int[] divcrc;
        int cantdatos, divisor, rescrc;

        System.out.print("Introduce el Dato: ");
        String DatoP; //Declara el dato que se va a pedir
        final Scanner DatoScan=new Scanner(System.in); //Se pide el dato
        DatoP=DatoScan.nextLine();//Se guarda el dato en un string
        char [] values;
        values = DatoP.toCharArray(); //Se pasa a un arreglo de caracteres
        cantdatos=values.length; //Se calcula un el largo del arreglo
        dividendo=new int[cantdatos]; //Se pasa el largo del arreglo al arreglo enteros
        
        System.out.print("Introduce el divisor: ");//Se pide el divisor
        String DivisorP;
        final Scanner DivisorScan=new Scanner(System.in);
        DivisorP=DivisorScan.nextLine();//Se guarda el divisor en un string
        char [] ui;
        ui=DivisorP.toCharArray(); //Se pasa a un arreglo de caracteres
        divisor=ui.length; //Se calcula un el largo del arreglo
        largo_p=new int[divisor];//Se pasa el largo del arreglo al arreglo enteros

        System.out.println("Seleccione el tipo de Paridad");
        System.out.println("1. Par");
        System.out.println("2. Impar");
        System.out.print("Opcion: ");
        int OpcP;
        final Scanner OpcScan=new Scanner(System.in);
        OpcP=OpcScan.nextInt();

        for(int i=0; i<cantdatos; i++){            
            String auh=Character.toString(values[i]);
            int aux = Integer.parseInt(auh);
            dividendo[i]=aux;
        } //se guarda el dato en el arreglo

        for(int i=0; i<divisor; i++){
            String chap = Character.toString(ui[i]);
            int aux = Integer.parseInt(chap);
            largo_p[i]=aux;
        } //se guarda el divisor en el arreglo

        resto=new int[cantdatos]; //Se declara el largo del resto
        crc=new int[cantdatos];

        for(int j=0; j<dividendo.length; j++){
            resto[j] = dividendo[j];
        }
  
        resto=divide(dividendo, largo_p, resto);//Se manda al metodo

        for(int i=0;i<dividendo.length;i++)           
        {
            crc[i]=(dividendo[i]^resto[i]);
        }

        resto=divide(crc, largo_p, resto); 
        
        rescrc=cantdatos-(divisor-1);
        divcrc=new int[rescrc];//espacio donde se guardara el dato sin los bits extras

        for(int i=0; i< resto.length; i++)
        {
            if(resto[i]!=0)
            {
                System.out.println("Error su resto no es 0");
                for(int k=0; k<divcrc.length; k++){
                    divcrc[k]=dividendo[k];
                    System.out.print(divcrc[k]);
                }
                break;
            }
            if(i==resto.length-1){
                System.out.println("No hay error");
                for(int k=0; k<divcrc.length; k++){
                    divcrc[k]=dividendo[k];
                    System.out.print(divcrc[k]);
                }
            }
        }

        switch(OpcP){
            case 1:
                
                break;
            case 2: 
                
                break;
            default:
                System.out.println("Opcion no valida");
        }
    }
    static int[] divide(int dividendo[],int largo_p[], int resto[])//Metodo
     {
        int contador=0;
        while(true)
        {
            for(int i=0;i<largo_p.length;i++)
                resto[contador+i]=(resto[contador+i]^largo_p[i]);
            
            while(resto[contador]==0 && contador!=resto.length-1)
                contador++;
    
            if((resto.length-contador)<largo_p.length)
                break;
        }
       
        return resto;
     }
}