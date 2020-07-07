package es.pildorasinformaticas.accesoficheros;

import java.io.File;
import java.io.IOException;

public class CreandoDirectorios {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File ruta_archivo =  new File("D:"+File.separator+"Descargas"+File.separator+"Carpeta_acceso"+File.separator+"Datos economicos"+File.separator+"Balance Trimestre1.xlsx");
		
		//ruta_archivo.mkdir();
		
		try {
			ruta_archivo.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
