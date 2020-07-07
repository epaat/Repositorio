package es.pildorasinformaticas.sockets;

import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;

import javax.swing.*;

public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoClienteChat mimarco=new MarcoClienteChat();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
class MarcoClienteChat extends JFrame{
	
	public MarcoClienteChat(){
		
		setBounds(600,300,280,350);
				
		LaminaClienteChat milamina=new LaminaClienteChat();
		
		add(milamina);
		
		setVisible(true);	
		
		estableceConexionServidor();
		
		}	
	void estableceConexionServidor() {
		
		try {
			Socket miSocket = new Socket("192.168.0.7",9999);
			
			EnvioPaqueteDatos datos = new EnvioPaqueteDatos();
			
			datos.setTextoCliente(" online");
			
			ObjectOutputStream flujoSalidaPaquete = new ObjectOutputStream(miSocket.getOutputStream());
			
			flujoSalidaPaquete.writeObject(datos);
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


class LaminaClienteChat extends JPanel implements Runnable {
	
	public LaminaClienteChat(){	
		
		nick = new JLabel();
		
		nick.setText(JOptionPane.showInputDialog("Nick: "));
		
		add(nick);
		
		JLabel cliente=new JLabel("Online-->");
		
		add(cliente);
		
		ip = new JComboBox();
		
		
		
		add(ip);
		
		areaChat = new JTextArea(12,20);
		
		add(areaChat);
		
		campo1=new JTextField(20);
	
		add(campo1);		
	
		miboton=new JButton("Enviar");	
		
		miboton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//System.out.println(campo1.getText());
				
				try {
					
					//Creación de socket via de comunicación
					Socket miSocket = new Socket("192.168.0.7",9999);
					
					EnvioPaqueteDatos datos = new EnvioPaqueteDatos();
					
					datos.setNick(nick.getText());
					
					datos.setIp(ip.getSelectedItem().toString());
					
					datos.setTextoCliente(campo1.getText());
					
					ObjectOutputStream flujoSalidaPaquete = new ObjectOutputStream(miSocket.getOutputStream());
					
					flujoSalidaPaquete.writeObject(datos);
					
					miSocket.close();
					
					// Creación del flujo de datos
					
					/*DataOutputStream flujoSalida = new DataOutputStream(miSocket.getOutputStream());
					
					flujoSalida.writeUTF(campo1.getText());
					
					flujoSalida.close();*/
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			
		});
	
		add(miboton);	
		
		Thread mihilo = new Thread(this);
		
		mihilo.start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			ServerSocket escuchaCliente = new ServerSocket(9090);
			
			Socket cliente;
			
			EnvioPaqueteDatos paqueteRecibido;
			
			while(true) {
				
				cliente = escuchaCliente.accept();
				
				ObjectInputStream flujoEntrada = new ObjectInputStream(cliente.getInputStream());
				
				paqueteRecibido = (EnvioPaqueteDatos) flujoEntrada.readObject();
				
				if(paqueteRecibido.getTextoCliente().equals(" online")) {
					
					//areaChat.append("\n"+ paqueteRecibido.getIPs());
					
					ArrayList<String> IpsJCombo = new ArrayList<String>();
					
					IpsJCombo = paqueteRecibido.getIPs();
					
					ip.removeAllItems();
					
					for(String ips : IpsJCombo)ip.addItem(ips);

				}else {
				
				areaChat.append("\n" + paqueteRecibido.getNick()+ ": "+paqueteRecibido.getTextoCliente());
				
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private JTextField campo1;	
	
	private JComboBox ip;
	
	private JLabel nick;
	
	private JButton miboton;
	
	private JTextArea areaChat;

	
}

class EnvioPaqueteDatos implements Serializable{
	
	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getTextoCliente() {
		return textoCliente;
	}

	public void setTextoCliente(String textoCliente) {
		this.textoCliente = textoCliente;
	}
	
	
	public ArrayList<String> getIPs() {
		return IPs;
	}

	public void setIPs(ArrayList<String> iPs) {
		IPs = iPs;
	}


	private String nick, ip, textoCliente;
	
	private ArrayList<String>IPs;
}


