package app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int[] dividendo;//Se crean arreglos de entero
        int[] largo_p;
        int[] resto;
        int[] crc;
        int[] divcrc;
        int[] sinham;
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
        int p = 0;
        final Scanner OpcScan=new Scanner(System.in);
        OpcP=OpcScan.nextInt();
        switch(OpcP){
        	case 1:
        		p=0;
        		break;
        	case 2: 
        		p=1;
        		break;
        	default:
        		System.out.println("Opcion no valida");
        }
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
        rescrc=cantdatos-(divisor-1);
        divcrc=new int[rescrc];
        sinham=new int[8];
        int q=0,r=0;
        int posErr=0;
        StringBuffer cadena = new StringBuffer();
        
        int aux2;
        aux2=dividendo.length-(divisor-1);
        int[] restofinal;
        int t=0;
        restofinal= new int[divisor-1];
        for(int i=aux2; i<dividendo.length;i++){
           restofinal[t]=dividendo[i];
           t++;
        }

        for(int i=0; i< resto.length; i++)
        {
            if(resto[i]!=0)
            {
                System.out.println("Error su resto no es 0");
                for(int k=0; k<divcrc.length; k++){
                    divcrc[k]=dividendo[k];
                    //System.out.print(divcrc[k]);
                }
                posErr =hammingError(divcrc, 4,p);
                corregirErr(divcrc,posErr);
                int[] res = new int[divcrc.length + restofinal.length];
                System.arraycopy(divcrc, 0, res, 0, divcrc.length );
                System.arraycopy( restofinal, 0, res, divcrc.length, restofinal.length );
                for(int j=0; j<res.length; j++){
                    resto[j] = res[j];
                }  
                resto=divide(res, largo_p, resto);//Se manda al metodo

                for(int z=0;z<res.length;z++)           
                {
                    crc[z]=(res[z]^resto[z]);
                }
                resto=divide(crc, largo_p, resto);
                for(int k=0; k< resto.length; k++)
                {
                    if(resto[k]!=0)
                    {
                        System.out.println("Error: Existe mas de un error");
                        break;
                    }
                    if(k==resto.length-1){
                        System.out.println("No existen errores");
                        for(int z=0; z<divcrc.length; z++){
                            divcrc[z]=res[z];
                        }
                        for(int z=0; z<divcrc.length; z++){
                            if(z!=0&&z!=1&&z!=3&&z!=7){
                                sinham[r]=divcrc[z];
                                r++;
                            }
                        }
                        for (int x=0;x<sinham.length;x++){
                            cadena =cadena.append(sinham[x]);
                        }
                        int num=Integer.parseInt(cadena.toString(),2);
                        char c = (char)num;
                        System.out.println("El caracter es: "+c);
                     }
                } 
                
                break;
            }
            if(i==resto.length-1){
                System.out.println("No existen errores");
                for(int k=0; k<divcrc.length; k++){
                    divcrc[k]=dividendo[k];
                }
                for(int k=0; k<divcrc.length; k++){
                    if(k!=0&&k!=1&&k!=3&&k!=7){
                        sinham[q]=divcrc[k];
                        q++;
                    }
                }
                for (int x=0;x<sinham.length;x++){
                    cadena =cadena.append(sinham[x]);
                }
                int num=Integer.parseInt(cadena.toString(),2);
                char c = (char)num;
                System.out.println("El caracter es: "+c);
            }
        }

    }
    private static void corregirErr(int ar[],int posErr) {
    	for(int i =1; i<ar.length; i++) {
    		if(posErr == i) {
    			if(ar[i]==1) {
    				ar[i]=0;
    			}else {
    				ar[i]=1;
    			}
    		}
    		System.out.print(ar[i]);
    	}
    	System.out.println();
    	System.out.print("Error solucionado...!");
    }

    private static int hammingError(int[] ar, int r,int p) {
		int suma = 0;
		int resul =0;
		String cadena = "";
	
		for (int i = 0; i < r; i++) {
			int x = (int)Math.pow(2, i); 
			for (int j = 1; j < ar.length; j++) { 
				if (((j >> i) & 1) == 1) { 
						if (x != j) {
							//System.out.println("arreglo pos x= " + ar[x] + "  ^ j= " + ar[j] + " ");
							suma +=ar[j];
							if(ar[x] == ar[j]) {
								ar[x] = ar[j];
							}
						}
				} 
			} 
			suma+=ar[x];
			
		
				if(suma%2==0) {
					cadena+="0";
				}else {
					cadena+="1";
				}
			//System.out.println("r" + x + " = "+ ar[x]);
			suma = 0;
		
		} 
		String cadAux="";
		for (int x=cadena.length()-1;x>=0;x--) {
			cadAux = cadAux+ cadena.charAt(x);
		}
		resul = Integer.parseInt(cadAux,2);
		
		//System.out.print(cadAux + '\n');
		//System.out.print(resul);
		return resul;
    	
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
