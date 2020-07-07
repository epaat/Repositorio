package es.pildorasinformaticas.accesoficheros;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

public class EjercicioStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoStreams mimarco = new MarcoStreams();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
class MarcoStreams extends JFrame{
	
	
	public MarcoStreams(){
		
		setTitle("Ejercicio");
		
		setBounds(400,350,600,300);
		
		PanelStreams lamina=new PanelStreams();
		
		add(lamina);
		
		setVisible(true);
	
	}
	
}

class PanelStreams extends JPanel{
	
		public PanelStreams(){
			
			setLayout(new BorderLayout());
			
			JPanel laminaBotones = new JPanel();
			
			escribir = new JButton("Escribir");
			
			escribir.addActionListener(new EventoBotones());
			
			borrar = new JButton("Borrar");
			
			borrar.addActionListener(new EventoBotones());
			
			leer = new JButton("Leer");
			
			leer.addActionListener(new EventoBotones());
			
			miarea = new JTextArea();
			
			laminaBotones.add(escribir);
			
			laminaBotones.add(borrar);
			
			laminaBotones.add(leer);
			
			add(laminaBotones, BorderLayout.SOUTH);
			
			add(miarea, BorderLayout.CENTER);
		}
		
	private class EventoBotones extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent o) {
			// TODO Auto-generated method stub
			
			if(o.getSource()==escribir) {
				
				String texto=miarea.getText();
				
				try {
					FileWriter escritura = new FileWriter("C:\\Users\\ELI\\Desktop/fichero_escritura.txt",true);
					
					for(int i=0;i<texto.length();i++) {
						
						escritura.write(texto.charAt(i));
					}
					escritura.close();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(o.getSource()==borrar) {
				
				miarea.setText("");
			}
			
			else if(o.getSource()==leer) {
				
				try {
					FileReader entrada = new FileReader("C:/Users/ELI/Desktop/fichero_escritura.txt");
					
					int caracter = entrada.read();
					
					char letra = (char)caracter;
					
					while(caracter!=-1) {
						
						 miarea.append(""+letra);
						
						caracter=entrada.read();
						
						letra = (char)caracter;
					}
					
					entrada.close();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("No se ha encontrado el archivo");
				}
			}
		}
		
		
	}
		
		JTextArea miarea;
		
		JButton escribir,borrar, leer;
}

