package es.pildorasinformaticas.serializando;

import java.io.*;

public class Recuperando {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			ObjectInputStream flujoEntrada = new ObjectInputStream(new FileInputStream("D:/Descargas/externoJava/miObjetoSerializado.dat"));
		
			Empleado [] entradaObjeto =(Empleado[]) flujoEntrada.readObject();
			
			flujoEntrada.close();
			
			for(Empleado e: entradaObjeto) {
				
				System.out.println(e);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
