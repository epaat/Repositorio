package componentesSwing;

import java.awt.*;

import javax.swing.*;
import javax.swing.event.*;

public class EjemploJSpinner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoJSpinner mimarco = new MarcoJSpinner();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
class MarcoJSpinner extends JFrame{
	
	
	public MarcoJSpinner(){
		
		setTitle("JSpinner");
		
		setBounds(400,350,600,300);
		
		PanelJSpinner lamina=new PanelJSpinner();
		
		add(lamina);
		
		setVisible(true);
	
	}
	
}

class PanelJSpinner extends JPanel{
	
		public PanelJSpinner(){
			
			String meses[]= {"Enero","Febrero", "Marzo", "Abril"};
			
			//JSpinner control = new JSpinner(new SpinnerListModel(meses));
			
			JSpinner control = new JSpinner(new SpinnerNumberModel(5,-5,15,1));
			
			control.setPreferredSize(new Dimension(150,20));
			
			control.addChangeListener(new ChangeListener() {

				@Override
				public void stateChanged(ChangeEvent e) {
					// TODO Auto-generated method stub
					System.out.println(control.getValue());
				}
				
				
			});
			
			add(control);
			
			
		}
}