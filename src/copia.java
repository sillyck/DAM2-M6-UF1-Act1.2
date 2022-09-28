/*
 * @author Jordi Ribellas
 */

import java.io.*;
import java.util.Scanner;

public class copia {
	public static void main (String[] args) throws IOException {
		
		Scanner entrada1 = new Scanner(System.in);
		
		System.out.println("Escriu la ruta del fitxer d'origen: ");
				
		File origen = new File(entrada1.nextLine());
		
		
		Scanner entrada2 = new Scanner(System.in);
		
		System.out.println("Escriu la ruta del fitxer d'origen: ");
				
		File desti = new File(entrada2.nextLine());
		
		
		if(!origen.exists()) {
			throw new IOException("El fitxer d'origen no existeix");
		}
		
		if(desti.exists()) {
			throw new IOException("El fitxer de destí ja existeix");
		}
		
		String ruta = origen.getPath();
		File rutaArxiu = new File (ruta);
		
		
		if(!rutaArxiu.canWrite()) {
			throw new IOException("La ruta a la que esta el fitxer no es pot escriure");
		}
		
		FileReader fiRea = new FileReader(origen);
		FileWriter fiWri = new FileWriter(desti);	
		
		try {		
			
			int i=0;
						
			char b[] = new char[20];
			while ((i = fiRea.read(b)) != -1) {
				fiWri.write(b);
			}
			
		} finally {
		
			fiRea.close();
			fiWri.close();

		}
		
		System.out.println("Fet!");
	}
	
}