package es.pildoras.excepciones;

import javax.swing.JOptionPane;

public class EjercicioExcepciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int edad=0;
		
		try {
		edad = Integer.parseInt(JOptionPane.showInputDialog("Introduce un n°"));
		}catch(NumberFormatException e) {
			
			JOptionPane.showMessageDialog(null, "El valor introducido no es un numérico, el programa"
					+ "se cerrará");
		
		}
		
		System.exit(0);
		
		if(edad%2==0) JOptionPane.showMessageDialog(null, "El número "+edad+ " es par");
		
		else JOptionPane.showMessageDialog(null, "El número "+edad+ " es impar");
	}

}
