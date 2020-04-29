package app;

import java.util.Scanner;

public class App {
    public static void main(final String[] args) {
        int[] dividendo;//Se crean arreglos de entero
        int[] unidad_datos;
        int[] largo_p;
        int[] resto;
        int[] crc;
		int cantdatos, divisor, largo;
        String codigoHamming ="";
        System.out.print("Introduce un caracter: ");
        String LetraP; //Declara el caracter que se va a pedir
        final Scanner LetraScan = new Scanner(System.in); //Se pide el caracter
        
        LetraP = LetraScan.nextLine(); //Se guarda el caracter
        String numBinario = convBinario(LetraP.charAt(0)); //Pasa a binario);
        
        
        System.out.print("Introduce el divisor: ");
        String DivisorP;
        final Scanner DivisorScan = new Scanner(System.in);
        DivisorP = DivisorScan.nextLine();
        char [] ui;
        ui=DivisorP.toCharArray(); //Se pasa a un arreglo de caracteres
        divisor=ui.length; //Se calcula un el largo del arreglo
        largo_p=new int[divisor];//Se pasa el largo del arreglo al arreglo enteros
        
        for(int i=0; i<divisor; i++){
            String chap = Character.toString(ui[i]);
            int aux = Integer.parseInt(chap);
            largo_p[i]=aux;
        }

        System.out.println("Seleccione el tipo de Paridad");
        System.out.println("1. Par");
        System.out.println("2. Impar");
        System.out.print("Opcion: ");

        //Opciones
        int OpcP;
        final Scanner OpcScan = new Scanner(System.in);
        codigoHamming= hamming(numBinario,menu(OpcP=OpcScan.nextInt()));
        char [] values;
        values = codigoHamming.toCharArray();
        cantdatos=values.length;
        unidad_datos=new int[cantdatos];

        for(int i=0; i<cantdatos; i++){            
            String auh=Character.toString(values[i]);
            int aux = Integer.parseInt(auh);
            unidad_datos[i]=aux;
        }
        cantdatos=unidad_datos.length;
		largo=cantdatos+divisor-1;
        
        dividendo=new int[largo];
        resto=new int[largo];
        crc=new int[largo];
   
        for(int i=0;i<unidad_datos.length;i++){
            dividendo[i]=unidad_datos[i];
        }

		for(int j=0; j<dividendo.length; j++){
			resto[j] = dividendo[j];
	 	}
  
		resto=divide(dividendo, largo_p, resto);
	  
	  	for(int i=0;i<dividendo.length;i++)           
	  	{
		  crc[i]=(dividendo[i]^resto[i]);
		}
        resto=divide(crc, largo_p, resto);  

        int aux2;
        aux2=resto.length-(divisor-1);
        int[] restofinal;
        int q=0;
        restofinal= new int[divisor-1];
        for(int i=aux2; i<resto.length;i++){
           restofinal[q]=resto[i];
           q++;
        }
       
        int[] res = new int[unidad_datos.length + restofinal.length];
        System.arraycopy( unidad_datos, 0, res, 0, unidad_datos.length );
        System.arraycopy( restofinal, 0, res, unidad_datos.length, restofinal.length );
        System.out.print("\n");
        System.out.print("El resultado es: ");
        for(int i=0; i<res.length; i++){
            System.out.print(res[i]);
        }


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

    private static String hamming(String numBinario, int p){ //metodo de hamming numero binario, p paridad
    	
    	int tamCadena = numBinario.length(); //tamaÃ±o de la cadena 
    	int bitR; //Bit de redundancia
    	String hammingCadena="";
    	for(bitR =1; Math.pow(2, bitR)<(tamCadena + bitR + 1); ) bitR++; // calculamos cuantos bits de redundancia tendremos
    	//System.out.println(bitR);
    	//System.out.println(numBinario);
    
    	int[] codiHamming = codificar(numBinario,tamCadena,bitR,p);
    	//System.out.println(error(codiHamming,bitR,p));
    	
    	
    	System.out.print("Codificación de Hamming -> ");
    	for(int i = 1; i <codiHamming.length; i++) {
    		System.out.print(codiHamming[i]);
    		hammingCadena += Integer.toBinaryString(codiHamming[i]);
    	}
    	
    	return hammingCadena; //retornamos la cadena de 1 y 0 ya codificado 

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
    static int[] divide(int dividendo[],int largo_p[], int resto[])
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
