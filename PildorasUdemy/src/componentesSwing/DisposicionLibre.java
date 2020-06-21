package componentesSwing;

import java.awt.*;

import javax.swing.*;

public class DisposicionLibre {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoDispLibre mimarco = new MarcoDispLibre();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

}
class MarcoDispLibre extends JFrame{
	
	
	public MarcoDispLibre(){
		
		setTitle("Disposiciones");
		
		setBounds(400,250,600,300);
		
		PanelDispLibre lamina=new PanelDispLibre();
		
		add(lamina);
		
		setVisible(true);
	
	}
	
}

class PanelDispLibre extends JPanel{
	
		public PanelDispLibre(){
			
			setLayout(new EnColumnas());
			
			JLabel nombre = new JLabel("Nombre: ");
			
			JLabel apellido = new JLabel("Apellido: ");
			
			JLabel tfno = new JLabel("Telefono: ");
			
			JTextField c_nombre = new JTextField();
			
			JTextField c_apellido = new JTextField();
			
			JTextField c_tfno = new JTextField();
			
			/*nombre.setBounds(20,20,80,10);
			
			c_nombre.setBounds(100, 15, 100, 20);
			
			apellido.setBounds(20, 60, 80, 10);
			
			c_apellido.setBounds(100, 55, 100, 20);*/
			
			add(nombre);
			
			add(c_nombre);
			
			add(apellido);
			
			add(c_apellido);
			
			add(tfno);
			
			add(c_tfno);
			
		}
}

class EnColumnas implements LayoutManager{

	@Override
	public void addLayoutComponent(String name, Component comp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void layoutContainer(Container miContenedor ) {
		// TODO Auto-generated method stub
		
		int d = miContenedor.getWidth();
		
		x = d/2;
		y = 20;
		
		int n=miContenedor.getComponentCount();
		
		int contador=0;
		
		for(int i=0;i<n;i++) {
			
			contador++;
			
			Component c = miContenedor.getComponent(i);
			
			c.setBounds(x-100, y, 100, 20);
			
			x+=100;
			
			if(contador%2==0) {
				
				x=d/2;
				y+=40;
			}
		}
	}

	@Override
	public Dimension minimumLayoutSize(Container parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dimension preferredLayoutSize(Container parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeLayoutComponent(Component comp) {
		// TODO Auto-generated method stub
		
	}
	
	private int x=20;
	
	private int  y=20;
}
