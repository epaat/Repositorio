package es.pildorasinformaticas.accesoficheros;

import java.io.*;

public class Leyendo_Escribiendo_Archivo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int contador = 0;
		
		int bytesImagen[] = new int[306144];
		
		try {
			
			FileInputStream lectura_archivo = new FileInputStream("D:/Descargas/Imagenes/Abstract.png");
			
			boolean final_archivo = false;
			
			while(!final_archivo) {
				
				int byteImagenEntrada=lectura_archivo.read();
				
				if(byteImagenEntrada!=-1)bytesImagen[contador]=byteImagenEntrada;
				
				else final_archivo=true;
				
				System.out.println(bytesImagen[contador]);
				
				contador++;
			}
			
			lectura_archivo.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(contador);
		
		CreaFichero(bytesImagen);
	}
	//--------Método estatic porque esta dentro de main que es un método estático--------
	static void CreaFichero(int  arrayExterno[]) {
		
		try {
			FileOutputStream ficheroExterno = new FileOutputStream("D:/Descargas/Imagenes/Abstract2.png");
			
			for(int i=0;i<arrayExterno.length;i++) {
				
				ficheroExterno.write(arrayExterno[i]);
			}
			
			ficheroExterno.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
