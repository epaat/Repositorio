package es.pildoras.lambda;

public class Empleado{
	

	public Empleado(String nombre, double salario) {
		this.nombre = nombre;
		this.salario = salario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}



	private String nombre;
	
	private double salario;

	/*@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Empleado otroEmpleado = (Empleado)o;
		
		if(this.salario<otroEmpleado.salario) return -1;
		
		if(this.salario>otroEmpleado.salario)return 1;
		
		return 0;
	}*/
}
