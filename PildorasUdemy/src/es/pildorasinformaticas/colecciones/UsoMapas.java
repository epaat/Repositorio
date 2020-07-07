package es.pildorasinformaticas.colecciones;

import java.util.*;

public class UsoMapas {
	
	public static void main(String[] args) {
		
		HashMap<String, Empleado> listaEmpleados = new HashMap<String, Empleado>();
		
		listaEmpleados.put("100", new Empleado("Juan"));
		
		listaEmpleados.put("101", new Empleado("Antonio"));
		
		listaEmpleados.put("102", new Empleado("Maria"));
		
		listaEmpleados.put("103", new Empleado("Lucía"));
		
		System.out.println(listaEmpleados);
		
		listaEmpleados.remove("101");
		
		System.out.println(listaEmpleados);
		
		listaEmpleados.put("103", new Empleado("Ana"));
		
		System.out.println(listaEmpleados);
		
		for(Map.Entry<String, Empleado>personaEmpleado:listaEmpleados.entrySet()) {
			
			String clave = personaEmpleado.getKey();
			
			Empleado valor = personaEmpleado.getValue();
			
			System.out.println("Clave= "+clave+" Valor= "+valor);
		}
	}

}
class Empleado{
	
	
	
	public Empleado(String nombre) {
		
		this.nombre = nombre;
		
		salario =200;
	}

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", salario=" + salario + "]";
	}

	private String nombre;
	
	private double salario;
}