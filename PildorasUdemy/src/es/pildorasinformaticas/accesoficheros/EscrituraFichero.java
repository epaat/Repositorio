package es.pildorasinformaticas.accesoficheros;

import java.io.*;

public class EscrituraFichero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Escritura creaEscribeFichero = new Escritura();
		
		creaEscribeFichero.escribiendo();
	}

}

class Escritura{
	
	public void escribiendo() {
		
		String texto="Esta es la segunda frase";
		
		try {
			FileWriter escritura = new FileWriter("C:\\Users\\ELI\\Desktop/streamNuevo.txt",true);
			
			for(int i=0;i<texto.length();i++) {
				
				escritura.write(texto.charAt(i));
			}
			escritura.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}