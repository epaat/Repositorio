package es.pildorasinformaticas.accesoficheros;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class EjercicioFicheros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		directorio = JOptionPane.showInputDialog("Introduce el nombre de la carpeta");
		
		CrearCarpeta(directorio);
		
		archivo = JOptionPane.showInputDialog("Introduce el nombre del archivo");
		
		CrearArchivo(archivo);
		
		frase = JOptionPane.showInputDialog("Introduce la frase");
		
		CrearFrase(frase);
	}

	private static String directorio, archivo, frase;
	
	public static void CrearCarpeta(String directorio) {
		
		File carpeta =  new File("D:"+File.separator+"Descargas"+File.separator+"Carpeta_acceso"+File.separator+directorio);
		
		carpeta.mkdir();
	}
	
	public static void CrearArchivo(String archivo) {
		
		File ruta_archivo =  new File("D:"+File.separator+"Descargas"+File.separator+"Carpeta_acceso"+File.separator+directorio+File.separator+archivo+".txt");
		
		try {
			ruta_archivo.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void CrearFrase(String frase) {
		
		try {
			FileWriter escritura = new FileWriter("D:"+File.separator+"Descargas"+File.separator+"Carpeta_acceso"+File.separator+directorio+File.separator+archivo+".txt",true);
			
			for(int i=0;i<frase.length();i++) {
				
				escritura.write(frase.charAt(i));
			}
			escritura.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
