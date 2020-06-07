package componentesSwing;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class EjemploComboBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoComboBox mimarco = new MarcoComboBox();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

}
class MarcoComboBox extends JFrame{
	
	
	public MarcoComboBox(){
		
		setTitle("Disposiciones");
		
		setBounds(400,250,600,300);
		
		PanelComboBox lamina=new PanelComboBox();
		
		add(lamina);
		
		setVisible(true);
	
	}
	
}

class PanelComboBox extends JPanel{
	
		public PanelComboBox(){
			
			setLayout(new BorderLayout());
			
			texto = new JLabel("En breve aprenderemos JavaFX");
			
			texto.setFont(new Font("Serif", Font.PLAIN,18));
			
			add(texto, BorderLayout.CENTER);
			
			JPanel superior = new JPanel();
			
			miCombo = new JComboBox();
			
			miCombo.addItem("Serif");
			
			miCombo.addItem("SansSerif");
			
			miCombo.addItem("Monospaced");
			
			miCombo.addItem("Dialog");
			
			miCombo.addItem("Calibri");
			
			miCombo.addActionListener(new EventoComboFuente());
			
			superior.add(miCombo);
			
			add(superior, BorderLayout.NORTH);
		}
		
		private class EventoComboFuente implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				texto.setFont(new Font((String)miCombo.getSelectedItem(),Font.PLAIN, 18));			}
			
			
		}
		
		JLabel texto;
		
		JComboBox miCombo;
}

