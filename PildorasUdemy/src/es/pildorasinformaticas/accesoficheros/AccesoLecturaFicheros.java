package es.pildorasinformaticas.accesoficheros;

import java.io.*;


public class AccesoLecturaFicheros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LeerFichero acceso_externo = new LeerFichero();
		
		acceso_externo.leeDatos();
	}

}
class LeerFichero{
	
	public void leeDatos() {
		
		try {
			FileReader entrada = new FileReader("C:/Users/ELI/Desktop/primerFichero.txt");
			
			BufferedReader miBuffer = new BufferedReader(entrada);
			
			String linea="";
			
			while(linea!=null) {
				
				linea = miBuffer.readLine();
				
				if(linea!=null)System.out.println(linea);
			}
			
			entrada.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("No se ha encontrado el archivo");
		}
	}
}