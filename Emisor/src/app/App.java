package app;

import java.util.Scanner;

public class App {
    public static void main(final String[] args) {

        System.out.print("Introduce un caracter: ");
        String LetraP; //Declara el caracter que se va a pedir
        final Scanner LetraScan = new Scanner(System.in); //Se pide el caracter
        
        LetraP = LetraScan.nextLine(); //Se guarda el caracter
        String numBinario = convBinario(LetraP.charAt(0)); //Pasa a binario);
        
        
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
        hamming(numBinario,menu(OpcP=OpcScan.nextInt()));
        
        


    }


    private static int  menu( int _opc) { //Par o impar opciones
    	if(_opc == 2) return 1; // impar
    	return 0; //par

    }

    private static String  convBinario(int valorAscii){ //A binario
           
            String numBinario = Integer.toBinaryString(valorAscii); 
            String aux ="0";
           if(numBinario.length()<8) return aux+=numBinario;
            return   numBinario;
    }

    private static int [] hamming(String numBinario, int p){ //metodo de hamming numero binario, p paridad
    	
    	int tamCadena = numBinario.length(); //tamaÃ±o de la cadena 
    	int bitR; //Bit de redundancia
    	for(bitR =1; Math.pow(2, bitR)<(tamCadena + bitR + 1); ) bitR++; // calculamos cuantos bits de redundancia tendremos
    	//System.out.println(bitR);
    	//System.out.println(numBinario);
    
    	int[] codiHamming = codificar(numBinario,tamCadena,bitR,p);
    	//System.out.println(error(codiHamming,bitR,p));
    	
    	System.out.print("Codificación de Hamming -> ");
    	for(int i = 1; i <codiHamming.length; i++) {
    		System.out.print(codiHamming[i]);
    	}
    	
    	return codiHamming; //retornamos el arreglo de 1 y 0 ya codificado 

   }
    
	private static int[] codificar(String numBinario, int tamCadena, int bitR, int p) {
		
		int[] arrayAux = new int[bitR + tamCadena+ 1]; 
		int j = 0; 
		
		for (int i = 1; i < arrayAux.length; i++) { 
			if ((Math.ceil(Math.log(i) / Math.log(2)) - Math.floor(Math.log(i) / Math.log(2))) == 0) { 
				arrayAux[i] = p; //paridad 1 impar 0 par
			} 
			else { 
				arrayAux[i] = (int)(numBinario.charAt(j) - '0'); 
				j++; 
			} 
	  }
		
		for (int i = 0; i < bitR; i++) { 
			
			int x = (int)Math.pow(2, i); 
			for (int it = 1; it < arrayAux.length; it++) { 
				if (((it >> i) & 1) == 1) { 
					if (x != it) 
						arrayAux[x] = arrayAux[x] ^ arrayAux[it]; 
				} 
			} 
		} 
		
		return  arrayAux; //retornamos el valor
	}	
}
