package componentesSwing;

import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;

public class MenuEmergente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EmergenteFrame miMarco = new EmergenteFrame();
		
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

}
class EmergenteFrame extends JFrame{
	
	public EmergenteFrame() {
		
		setBounds(400,250,600,350);
		
		add(new EmergentePanel());
		
		setVisible(true);
	}
}

class EmergentePanel extends JPanel{
	
	public EmergentePanel() {
		
		JPopupMenu emergente = new JPopupMenu();
		
		JMenuItem azul = new JMenuItem("Azul");
		
		JMenuItem verde = new JMenuItem("Verde");
		
		JMenuItem rojo = new JMenuItem("Rojo");
		
		azul.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setBackground(Color.BLUE);
			}
			
			
		});
		
		verde.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setBackground(Color.GREEN);
			}
			
			
		});
		
		rojo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setBackground(Color.RED);
			}
			
			
		});
		
		emergente.add(azul);
		
		emergente.add(verde);
		
		emergente.add(rojo);
		
		setComponentPopupMenu(emergente);
		
	}
}