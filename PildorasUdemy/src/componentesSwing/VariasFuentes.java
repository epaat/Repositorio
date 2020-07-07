package componentesSwing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;

public class VariasFuentes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoVariasFuentes mimarco = new MarcoVariasFuentes();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);
		
	}

}
class MarcoVariasFuentes extends JFrame{
	
	
	public MarcoVariasFuentes(){
		
		setTitle("Multiples fuentes");
		
		setBounds(400,250,600,300);
		
		//PanelVariasFuentes lamina=new PanelVariasFuentes();
		
		milamina = new JPanel();
		
		//add(lamina);
		
		add(milamina);
		
		
	
	/*}
	
}

class PanelVariasFuentes extends JPanel{
	
		public PanelVariasFuentes(){
			
			/*JButton botonAzul = new JButton("Azul");
			
			JButton botonRojo = new JButton("Rojo");
			
			JButton botonVerde = new JButton("Verde");
			
			add(botonAzul);
			
			add(botonRojo);
			
			add(botonVerde);*/
			
			EventoColorFondo colorAzul = new EventoColorFondo("Azul", Color.BLUE,new ImageIcon("src/componentesSwing/bola_azul.png"));
			
			EventoColorFondo colorRojo = new EventoColorFondo("Rojo", Color.RED,new ImageIcon("src/componentesSwing/bola_roja.png"));
			
			EventoColorFondo colorAmarillo = new EventoColorFondo("Amarillo", Color.YELLOW,new ImageIcon("src/componentesSwing/bola_amarilla.png"));
			
			/*add(new JButton(colorAzul));
			
			add(new JButton(colorRojo));
			
			add(new JButton(colorVerde));
			
			InputMap mapaEntrada = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
			
			//KeyStroke teclaAzul = KeyStroke.getKeyStroke("ctrl A");
			
			//KeyStroke teclaRojo = KeyStroke.getKeyStroke("ctrl R");
			
			//KeyStroke teclaVerde = KeyStroke.getKeyStroke("ctrl V");
			
			mapaEntrada.put(KeyStroke.getKeyStroke("ctrl A"), "fondo_azul");
			
			mapaEntrada.put(KeyStroke.getKeyStroke("ctrl R"), "fondo_rojo");
			
			mapaEntrada.put(KeyStroke.getKeyStroke("ctrl V"), "fondo_verde");
			
			//mapaEntrada.put(teclaRojo, "fondo_rojo");
			
			//mapaEntrada.put(teclaVerde, "fondo_verde");
			
			ActionMap mapaAccion = getActionMap();
			
			mapaAccion.put("fondo_azul", colorAzul);
			
			mapaAccion.put("fondo_rojo", colorRojo);
			
			mapaAccion.put("fondo_verde", colorVerde);*/
			
			JToolBar barra = new JToolBar();
			
			//-----Se agregab objetos de tipo EventoColorFondo a la barra de herrmientas-----
			
			barra.add(colorAzul);
			
			barra.add(colorRojo);
			
			barra.add(colorAmarillo);
			
			add(barra, BorderLayout.WEST);
			
		}
	private class EventoColorFondo extends AbstractAction{

			public EventoColorFondo(String nombre, Color color_fondo, Icon icono) {
				
				putValue(Action.NAME,nombre);
				
				putValue(Action.SMALL_ICON, icono);
				
				putValue(Action.SHORT_DESCRIPTION, "Pone la lámina o JPanel de color: " + nombre);
				
				putValue("color_fondo_JPanel", color_fondo);
			}
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				Color c = (Color) getValue("color_fondo_JPanel");
				
				milamina.setBackground(c);
				
				System.out.println("Nombre "+ getValue(Action.NAME)+ " Descripción "+ getValue(Action.SHORT_DESCRIPTION));
			}
			
			
		}
	
	JPanel milamina;
}

