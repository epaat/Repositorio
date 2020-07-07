package es.pildorasinformaticas.programaciongenerica;

public class VariosTipos<T> {

	public VariosTipos() {
		
		primero = null;
	}
	
	public static void imprimirTrabajador(VariosTipos<? extends Empleado> e) {
		
		Empleado primero = e.getPrimero();
		
		System.out.println(primero);
	}
	
	public void setPrimero(T nuevoValor) {
		
		primero = nuevoValor;
	}
	
	public T getPrimero() {
		
		return primero;
	}
	
	private T primero;
}
