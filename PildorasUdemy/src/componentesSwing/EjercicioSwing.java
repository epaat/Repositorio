package componentesSwing;

import java.awt.*;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.StyledEditorKit.*;

public class EjercicioSwing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoEjercicio mimarco = new MarcoEjercicio();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

}
class MarcoEjercicio extends JFrame{
	
	
	public MarcoEjercicio(){
		
		setTitle("Ejercicio");
		
		setBounds(400,150,600,500);
		
		PanelEjercicio lamina=new PanelEjercicio();
		
		add(lamina);
		
		setVisible(true);
	
	}
	
}

class PanelEjercicio extends JPanel{
	
		public PanelEjercicio(){
			
			setLayout(new BorderLayout());
			
			JPanel laminaMenu = new JPanel();
			
			JMenuBar miBarra = new JMenuBar();
			
			fuente = new JMenu("Fuente");
			
			estilo = new JMenu("Estilo");
			
			tamagno = new JMenu("Tamaño");
			
			miBarra.add(fuente);
			
			miBarra.add(estilo);
			
			miBarra.add(tamagno);
			//----Configuración de la fuente(tipo de letra)----------
			
			Configura_Menu("Arial","fuente","Arial",1,12);
			
			Configura_Menu("Courier","fuente","Courier",1,12);
			
			Configura_Menu("Verdana","fuente","Verdana",1,12);
			
			//----Configuración del estilo--------
			
			Configura_Menu("Negrita","estilo","",Font.BOLD,12);
			
			Configura_Menu("Cursiva","estilo","",Font.ITALIC,12);
			
			//---Configuración del tamaño-----------
			
			Configura_Menu("12","tamagno","",1,12);
			
			Configura_Menu("16","tamagno","",1,16);

			Configura_Menu("20","tamagno","",1,20);

			Configura_Menu("24","tamagno","",1,24);
			
			laminaMenu.add(miBarra);
			
			add(laminaMenu, BorderLayout.NORTH);
			
			miPane = new JTextPane();
			
			add(miPane,BorderLayout.CENTER);

			barra = new JToolBar();
			
			Configura_Barra("estilo",new ImageIcon("src/componentesSwing/negrita.gif"),Font.BOLD,1,4);
			
			Configura_Barra("estilo",new ImageIcon("src/componentesSwing/cursiva.png"),Font.ITALIC,1,4);
			
			Configura_Barra("estilo",new ImageIcon("src/componentesSwing/subrayado.png"),5,1,4);
			
			barra.addSeparator();
			
			Configura_Barra("color",new ImageIcon("src/componentesSwing/bola_azul.png"),1,2,4);
			
			Configura_Barra("color",new ImageIcon("src/componentesSwing/bola_roja.png"),1,3,4);
			
			Configura_Barra("color",new ImageIcon("src/componentesSwing/bola_amarilla.png"),1,4,4);
			
			barra.addSeparator();
			
			Configura_Barra("alineacion",new ImageIcon("src/componentesSwing/centrado.png"),1,1,1);
			
			Configura_Barra("alineacion",new ImageIcon("src/componentesSwing/derecha.png"),1,1,2);
			
			Configura_Barra("alineacion",new ImageIcon("src/componentesSwing/izquierda.png"),1,1,0);
			
			Configura_Barra("alineacion",new ImageIcon("src/componentesSwing/justificado.png"),1,1,3);
			
			barra.setOrientation(1);
			
			add(barra, BorderLayout.WEST);
		}
		
		public void Configura_Menu(String rotulo, String menu, String tipoLetra, int estilos, int tamagnos){
			
			JMenuItem elemMenu = new JMenuItem(rotulo);
			
			if(menu=="fuente") {
				
				fuente.add(elemMenu);
				
				elemMenu.addActionListener(new StyledEditorKit.FontFamilyAction("cambio letra", tipoLetra));
				
			}else if(menu=="estilo") {
				
				estilo.add(elemMenu);
				
				if(estilos==Font.BOLD)elemMenu.addActionListener(new StyledEditorKit.BoldAction());
				
				else elemMenu.addActionListener(new StyledEditorKit.ItalicAction());
			}
			else if(menu=="tamagno") {
				
				tamagno.add(elemMenu);
				
				elemMenu.addActionListener(new StyledEditorKit.FontSizeAction("cambia tamaño", tamagnos));
			}
		}
		
		public void Configura_Barra(String menu, Icon imagen,int estilos2, int colores, int alinear) {
			
			JButton boton = new JButton(imagen);
			
			if(menu=="estilo") {
				
				barra.add(boton);
				
				if(estilos2==Font.BOLD)boton.addActionListener(new StyledEditorKit.BoldAction());
				
				if(estilos2==Font.ITALIC)boton.addActionListener(new StyledEditorKit.ItalicAction());
				
				if( estilos2==5)boton.addActionListener(new StyledEditorKit.UnderlineAction());
			}
			else if(menu=="color") {
				
				barra.add(boton);
				
				if(colores==2)boton.addActionListener(new StyledEditorKit.ForegroundAction("Pone_azul", Color.BLUE));
				
				if(colores==3)boton.addActionListener(new StyledEditorKit.ForegroundAction("Pone_azul", Color.RED));
				
				if(colores==4)boton.addActionListener(new StyledEditorKit.ForegroundAction("Pone_azul", Color.YELLOW));
				
				
				
			}
			else if(menu=="alineacion") {
				
				barra.add(boton);
				
				boton.addActionListener(new StyledEditorKit.AlignmentAction("Alineado", alinear));
			}
		}
		
		JToolBar barra;
		
		JTextPane miPane;
		
		JMenu fuente, estilo, tamagno;
}
