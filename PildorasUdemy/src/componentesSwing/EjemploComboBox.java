package componentesSwing;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

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
			
			miSlider = new JSlider(8,36,24);
			
			miSlider.setMajorTickSpacing(12);
			
			miSlider.setMinorTickSpacing(2);
			
			miSlider.setPaintTicks(true);
			
			miSlider.setPaintLabels(true);
			
			miSlider.addChangeListener(new ChangeListener() {
				
				//clase interna anonima
				@Override
				public void stateChanged(ChangeEvent e) {
					// TODO Auto-generated method stub
					
					texto.setFont(new Font((String)miCombo.getSelectedItem(),Font.PLAIN, miSlider.getValue()));
				}
				
				
			});
			
			superior.add(miSlider);
			
			add(superior, BorderLayout.NORTH);
		}
		
		private class EventoComboFuente implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				texto.setFont(new Font((String)miCombo.getSelectedItem(),Font.PLAIN, miSlider.getValue()));			}
			
			
		}
		
		JLabel texto;
		
		JComboBox miCombo;
		
		JSlider miSlider;
}

