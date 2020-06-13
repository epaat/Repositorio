package componentesSwing;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.text.*;

public class EjemploProcesador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoProcesador mimarco = new MarcoProcesador();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

}
class MarcoProcesador extends JFrame{
	
	
	public MarcoProcesador(){
		
		setTitle("Procesador de texto");
		
		setBounds(400,250,600,300);
		
		PanelProcesador lamina=new PanelProcesador();
		
		add(lamina);
	
		setVisible(true);
	}
	
}

class PanelProcesador extends JPanel{
	
		public PanelProcesador(){
			
		setLayout(new BorderLayout());
			
			JPanel laminaMenu = new JPanel();
			
			//-----Construcción Barra de Menú-----
			
			JMenuBar miBarra = new JMenuBar();
			
			 fuente = new JMenu("Fuente");
			
			 estilo = new JMenu("Estilo");
			
			 tamagno = new JMenu("Tamaño");
			 
			 //-----Configuración de rotulo con Tipo de letra--------------------
			 
			
			miBarra.add(fuente);
			
			miBarra.add(estilo);
			
			miBarra.add(tamagno);
			
			configuraMenu("Arial","fuente","Arial",1,12);
			
			configuraMenu("Courier","fuente","Courier",1,12);
			
			configuraMenu("Verdana","fuente","Verdana",1,12);
			
			//---------Configuración de rotulo con estilo de letra----------------------------------
			
			configuraMenu("Negrita","estilo","",Font.BOLD,12);
			
			configuraMenu("Cursiva","estilo","",Font.ITALIC,12);
			
			//----------Configuración de rotulo con tamaño de letra---------------------------------
			
			configuraMenu("12","tamaño","",1,12);
			
			configuraMenu("16","tamaño","",1,16);
			
			configuraMenu("20","tamaño","",1,20);
			
			configuraMenu("24","tamaño","",1,24);
			
			laminaMenu.add(miBarra);
			
			add(laminaMenu, BorderLayout.NORTH);
			
			miArea = new JTextPane();
			
			add(miArea, BorderLayout.CENTER);
		}
		
		//---Se hace un metodo con los rotulos, el menu al que pertenece--
		//--Dentro del metodo de instancia el item para que sea creado----
		//---Dentro de estos menus va el tipo de letra, los estilos y el tamaño---
		//---Para configurar las funcionalidades---
		
		public void configuraMenu(String rotulo, String menu, String tipoLetra, int estilos, int tamagnos) {
			
			JMenuItem elemMenu = new JMenuItem(rotulo);
			
			if(menu=="fuente") {
				
				fuente.add(elemMenu);
				
				elemMenu.addActionListener(new StyledEditorKit.FontFamilyAction("cambiaLetra", tipoLetra));
			}
			
			else if(menu=="estilo") {
				
				//Solo hay dos opciones por lo tanto si no elige uno debe ser el otro ademas pueden
				//ser combinaciones
				
				estilo.add(elemMenu);
				
				if(estilos==Font.BOLD)elemMenu.addActionListener(new StyledEditorKit.BoldAction());
				
				//if(estilos==Font.ITALIC)elemMenu.addActionListener(new StyledEditorKit.ItalicAction());
				else elemMenu.addActionListener(new StyledEditorKit.ItalicAction());
			}
			
			else if(menu=="tamaño") {
				
				tamagno.add(elemMenu);
				
				elemMenu.addActionListener(new StyledEditorKit.FontSizeAction("cambiaTamaño", tamagnos));
			}
			
			//elemMenu.addActionListener(new GestionaEventos(rotulo, tipoLetra, estilos, tamagnos));
		}
		
		/*private class GestionaEventos implements ActionListener{

			GestionaEventos(String rotulo,String tipoLetra,int estilos,int tamagnos){
				
				this.tipoLetra = tipoLetra;
				
				this.estilos = estilos;
				
				this.tamagnos = tamagnos;
				
				this.rotulo = rotulo;
				
			}
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				letraExistente=miArea.getFont();
				
				if(rotulo=="Arial" || rotulo=="Courier" || rotulo=="Verdana" ) {
					
					estilos=letraExistente.getStyle();
					
					tamagnos= letraExistente.getSize();
					
				}else if(rotulo=="Cursiva"|| rotulo=="Negrita") {
					
					if(letraExistente.getStyle()==1||letraExistente.getStyle()==2)estilos=3;
					
					tipoLetra = letraExistente.getFontName();
					
					tamagnos= letraExistente.getSize();
					
				}else if(rotulo=="12"||rotulo=="16"||rotulo=="20"||rotulo=="24") {
					
					tipoLetra = letraExistente.getFontName();
					
					estilos=letraExistente.getStyle();
				}
				
				miArea.setFont(new Font(tipoLetra, estilos, tamagnos));
			}
			
			String tipoLetra, rotulo;
			
			int estilos, tamagnos;
			
			
		}*/
		JTextPane miArea;
		
		JMenu fuente, estilo, tamagno;
		
		Font letraExistente;
}