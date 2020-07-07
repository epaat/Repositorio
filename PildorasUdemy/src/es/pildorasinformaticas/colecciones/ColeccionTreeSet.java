package es.pildorasinformaticas.colecciones;

import java.util.*;
import java.util.TreeSet;

public class ColeccionTreeSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*TreeSet<String> ordenaGente = new TreeSet<String>();
		
		ordenaGente.add("Oscar");
		
		ordenaGente.add("Maria");
		
		ordenaGente.add("Ana");
		
		for(String g:ordenaGente) {
			
			System.out.println(g);
		}*/
		
		Productos comparadorPr = new Productos();
		
		TreeSet<Productos> ordenaProductos = new TreeSet<Productos>(comparadorPr);
		
		Productos pr1 = new Productos(3,"esta es la descripcion del Tercer Producto");
		
		Productos pr7 = new Productos(7,"Séptimo");
		
		Productos pr2 = new Productos(2,"Segundo Producto");
		
		ordenaProductos.add(pr1);
		
		ordenaProductos.add(pr7);
		
		ordenaProductos.add(pr2);
		
		for(Productos p:ordenaProductos) {
			
			System.out.println(p.getDescripcion());
		}
	}

}

class Productos implements Comparable<Productos>, Comparator<Productos>{
	
	public Productos() {
		
	}

	public Productos(int numeroProducto, String descripcion) {
		
		this.numeroProducto= numeroProducto;
		
		this.descripcion = descripcion;
		
		
	}
	
	public String getDescripcion() {
		
		return descripcion;
	}
	@Override
	public int compareTo(Productos pr) {
		// TODO Auto-generated method stub
		return numeroProducto- pr.numeroProducto;
	}
	
	private int numeroProducto;
	
	private String descripcion;

	@Override
	public int compare(Productos o1, Productos o2) {
		// TODO Auto-generated method stub
		
		int carac1 = o1.getDescripcion().length();
		
		int carac2 = o2.getDescripcion().length();
		
		if(carac1<carac2) return -1;
		
		else if(carac1>carac2) return 1;
		
		else return 0;
	}
}
