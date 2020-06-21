package es.pildoras.excepciones;

import javax.swing.JOptionPane;

public class EjercicioExcepciones2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int edad = Integer.parseInt(JOptionPane.showInputDialog("Introduce un n° entre 1 y 100"));
		
		try {
			examinaNumero(edad);
		} catch (NumeroFueraRango e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	static void examinaNumero(int edad) throws NumeroFueraRango  {
		
		if(edad>1 && edad<100)System.out.println("Nº Correcto");
		
		else throw new NumeroFueraRango("Numero fuera de rango");
	}	

}
class NumeroFueraRango extends Exception{
	
	public NumeroFueraRango() {}
	
	public NumeroFueraRango(String mensajeError) {
		
		super(mensajeError);
	}
}