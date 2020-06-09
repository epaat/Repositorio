package componentesSwing;

import java.awt.event.*;

import javax.swing.*;

public class EjemploMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoMenu mimenu = new MarcoMenu();
		
		mimenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
class MarcoMenu extends JFrame{
	
	
	public MarcoMenu(){
		
		setTitle("Menu");
		
		setBounds(400,150,600,300);
		
		PanelMenu lamina=new PanelMenu();
		
		add(lamina);
		
		setVisible(true);
	
	}
	
}

class PanelMenu extends JPanel{
	
		public PanelMenu(){
			
			JMenuBar miBarra = new JMenuBar();
			
			//-------Aquí iran los elementos del menú-----------
			
			JMenu archivo = new JMenu("Archivo");
			
			JMenu edicion = new JMenu("Edición");
			
			JMenu herramientas = new JMenu("Herramientas");
			
			miBarra.add(archivo);
			
			miBarra.add(edicion);
			
			miBarra.add(herramientas);
			
			//-----Aquí irían los elementos de archivo------
			
			JMenuItem guardar = new JMenuItem("Guardar");
			
			JMenuItem guardarComo = new JMenuItem("Guardar Como");
			
			guardarComo.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					System.out.println("Haz pulsado en Guardar Como");
				}
				
				
			});
			
			archivo.add(guardar);
			
			archivo.add(guardarComo);
			
			//------Aquí iran los elementos de edicion--------
			
			JMenuItem cortar = new JMenuItem("Cortar");
			
			JMenuItem copiar = new JMenuItem("Copiar");
			
			JMenuItem pegar = new JMenuItem("Pegar");
			
			edicion.add(cortar);
			
			edicion.add(copiar);
			
			edicion.add(pegar);
			
			//------Aquí iran los elementos de herramientas-----
			
			JMenuItem opciones = new JMenuItem("Opciones");
			
			JMenu preferencias = new JMenu("Preferencias");
			
			herramientas.add(opciones);
			
			herramientas.addSeparator();
			
			herramientas.add(preferencias);
			
			//Aquí iran las opciones de preferencias
			
			JMenuItem ayuda = new JMenuItem("Ayuda");
			
			JMenuItem generales = new JMenuItem("Generales");
			
			preferencias.add(ayuda);
			
			preferencias.add(generales);
			
			add(miBarra);
		}
}