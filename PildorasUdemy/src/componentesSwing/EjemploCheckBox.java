package componentesSwing;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class EjemploCheckBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoCheckBox mimarco = new MarcoCheckBox();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
class MarcoCheckBox extends JFrame{
	
	
	public MarcoCheckBox(){
		
		setTitle("CheckBox");
		
		setBounds(600,350,600,300);
		
		PanelCheckBox lamina=new PanelCheckBox();
		
		add(lamina);
		
		setVisible(true);
	
	}
	
}

class PanelCheckBox extends JPanel{
	
		public PanelCheckBox(){
			
			setLayout(new BorderLayout());
			
			texto= new JLabel("Hola alumnos de Java");
			
			texto.setFont(new Font("Courier", Font.PLAIN,24));
			
			JPanel superior = new JPanel();
			
			JPanel inferior = new JPanel();
			
			superior.add(texto);
			
			negrita = new JCheckBox("Negrita");
			
			cursiva = new JCheckBox("Cursiva");
			
			cursiva.addActionListener(new ManejaChecks());
			
			negrita.addActionListener(new ManejaChecks());
			
			inferior.add(negrita);
			
			inferior.add(cursiva);
			
			add(superior,BorderLayout.NORTH);
			
			add(inferior, BorderLayout.SOUTH);
			
		}
		
		private class ManejaChecks implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				int negrita_cursiva=0;
				
				if(negrita.isSelected())negrita_cursiva+=Font.BOLD;
				
				if(cursiva.isSelected())negrita_cursiva+=Font.ITALIC;
				
				texto.setFont(new Font("Courier",negrita_cursiva,24));
			}
			
			
		}
		
		private JCheckBox negrita, cursiva;
		
		private JLabel texto;
}

