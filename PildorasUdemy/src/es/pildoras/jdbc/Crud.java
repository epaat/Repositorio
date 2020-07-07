package es.pildoras.jdbc;

import java.awt.event.*;

import javax.swing.*;

public class Crud {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoCrud mimarco = new MarcoCrud();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
class MarcoCrud extends JFrame{
	
	
	public MarcoCrud(){
		
		setTitle("Crud");
		
		setBounds(600,350,600,300);
		
		PanelCrud lamina=new PanelCrud();
		
		add(lamina);
		
		setVisible(true);
	
	}
	
}

class PanelCrud extends JPanel{
	
		public PanelCrud(){
			
			setLayout(null);
			
			seccion = new JLabel("Sección:");
			
			seccion.setBounds(10, 10, 50, 30);
			
			add(seccion);
			
			tseccion = new JTextField();
			
			tseccion.setBounds(130, 15, 100, 20);
			
			add(tseccion);
			
			nombreArticulo = new JLabel("Nombre del articulo:");
			
			nombreArticulo.setBounds(10, 50, 150, 30);
			
			add(nombreArticulo);
			
			tnombreArticulo = new JTextField();
			
			tnombreArticulo.setBounds(130, 55, 100, 20);
			
			add(tnombreArticulo);
			
			paisDeOrigen = new JLabel("Pais de origen:");
			
			paisDeOrigen.setBounds(10, 85, 150, 30);
			
			add(paisDeOrigen);
			
			tPaisDeOrigen = new JTextField();
			
			tPaisDeOrigen.setBounds(130, 90, 100, 20);
			
			add(tPaisDeOrigen);
			
			precio = new JLabel("Precio:");
			
			precio.setBounds(10, 115, 150, 30);
			
			add(precio);
			
			tprecio = new JTextField();
			
			tprecio.setBounds(130, 120, 100, 20);
			
			add(tprecio);
			
			crear = new JButton("crear");

			crear.setBounds(10, 150, 100,25);
			
			add(crear);
			
			crear.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					ConexionCrud insertar = new ConexionCrud();
					
					insertar.crearRegistro(tseccion.getText(),tnombreArticulo.getText(), tPaisDeOrigen.getText(), tprecio.getText());
				}
				
				
			});
			
			actualizar = new JButton("Actualizar");

			actualizar.setBounds(150, 150, 100,25);
			
			add(actualizar);
			
			leer = new JButton("Leer");

			leer.setBounds(290, 150, 100,25);
			
			add(leer);
			
			leer.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					ConexionCrud leer = new ConexionCrud();
					
					leer.leerRegistro(tnombreArticulo.getText()); 
					
					tseccion.setText(leer.getSeccion());
					
					tnombreArticulo.setText(leer.getNombre());
					
					tPaisDeOrigen.setText(leer.getOrigen());
					
					tprecio.setText(leer.getPrecio());
				}
				
				
			});
			
			eliminar = new JButton("Eliminar");

			eliminar.setBounds(440, 150, 100,25);
			
			add(eliminar);
		}
		
	JTextField tseccion, tnombreArticulo, tPaisDeOrigen, tprecio;
	
	JLabel seccion, nombreArticulo, paisDeOrigen, precio;
	
	JButton crear, actualizar, leer, eliminar;
	
	
}