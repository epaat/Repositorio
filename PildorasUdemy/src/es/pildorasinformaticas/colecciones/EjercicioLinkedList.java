package es.pildorasinformaticas.colecciones;

import java.util.*;

public class EjercicioLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList<String>paises = new LinkedList<String>();
		
		paises.add("Espa�a");
		
		paises.add("Colombia");
		
		paises.add("M�xico");
		
		paises.add("Per�");
		
		LinkedList<String>capitales = new LinkedList<String>();
		
		capitales.add("Madrid");
		
		capitales.add("Bogot�");
		
		capitales.add("D.F.");
		
		capitales.add("Lima");
		
		ListIterator<String> itPaises = paises.listIterator();
		
		ListIterator<String> itCapitales = capitales.listIterator();
	
		while(itCapitales.hasNext()) {
			
			if(itPaises.hasNext())itPaises.hasNext();
			
			itPaises.add(itCapitales.next());
		}
		
		System.out.println(paises);
		
		itCapitales = capitales.listIterator();
		
		while(itCapitales.hasNext()) {
			
			itCapitales.next();
			
			if(itCapitales.hasNext()) {
				
				itCapitales.next();
				
				itCapitales.remove();
			}
		}
		
		System.out.println(capitales);
	}

}
