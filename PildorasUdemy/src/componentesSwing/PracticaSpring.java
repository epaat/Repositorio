package componentesSwing;

import javax.swing.*;

public class PracticaSpring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoMuelle mimarco = new MarcoMuelle();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);
	}

}
class MarcoMuelle extends JFrame{
	
	
	public MarcoMuelle(){
		
		setTitle("Disposiciones");
		
		setBounds(400,250,600,300);
		
		PanelMuelle lamina=new PanelMuelle();
		
		add(lamina);
	
	}
	
}

class PanelMuelle extends JPanel{
	
		public PanelMuelle(){
			
			JButton boton1 = new JButton("Boton1");	
			
			JButton boton2 = new JButton("Boton2");	
			
			JButton boton3 = new JButton("Boton3");	
			
			SpringLayout milayout = new SpringLayout();
			
			setLayout(milayout);
			
			add(boton1);
			
			add(boton2);
			
			Spring miMuelle = Spring.constant(0, 10, 100);
			
			milayout.putConstraint(SpringLayout.WEST, boton1, miMuelle, SpringLayout.WEST, this);
			
			milayout.putConstraint(SpringLayout.WEST, boton2, miMuelle, SpringLayout.EAST, boton1);
			
			milayout.putConstraint(SpringLayout.WEST, boton3, miMuelle, SpringLayout.EAST, boton2);
			
			milayout.putConstraint(SpringLayout.EAST, this, miMuelle, SpringLayout.EAST, boton3);
			
			add(boton3);
		}
}