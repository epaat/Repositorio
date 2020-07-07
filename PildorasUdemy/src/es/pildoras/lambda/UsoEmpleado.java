package es.pildoras.lambda;

import java.util.*;

public class UsoEmpleado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList <Empleado> misEmpleados = new ArrayList<Empleado>();
		
		misEmpleados.add(new Empleado("Juan",2500));
		
		misEmpleados.add(new Empleado("Ana",1500));
		
		misEmpleados.add(new Empleado("Maria",4500));
		
		misEmpleados.add(new Empleado("Antonio",900));
		
		//Collections.sort(misEmpleados);
		
		//Collections.sort(misEmpleados, (Empleado e1, Empleado e2)->e1.getSalario().compareTo(e2.getSalario()));
		
		misEmpleados
			.stream()
			.sorted((e1,e2)->e1.getSalario().compareTo(e2.getSalario()))
			.filter((Empleado e)->e.getSalario()<=4000)
			.forEach((Empleado)->System.out.println(Empleado.getSalario()));
			
			
		
		//for(Empleado e: misEmpleados)System.out.println(e.getNombre()+" Salario: "+ e.getSalario());
		
		//
		misEmpleados.forEach((Empleado)-> System.out.println(Empleado.getSalario()));
	}

}
