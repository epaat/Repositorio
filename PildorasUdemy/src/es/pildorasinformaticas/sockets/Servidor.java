package es.pildorasinformaticas.sockets;

import java.awt.*;
import java.io.DataInputStream;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

import javax.swing.*;

public class Servidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoServidorChat mimarco=new MarcoServidorChat();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	}	
}
class MarcoServidorChat extends JFrame implements Runnable{
	
	public MarcoServidorChat(){
		
		setBounds(1200,300,280,350);				
			
		JPanel milamina= new JPanel();
		
		milamina.setLayout(new BorderLayout());
		
		areatexto=new JTextArea();
		
		milamina.add(areatexto,BorderLayout.CENTER);
		
		add(milamina);
		
		setVisible(true);	
		
		Thread miHilo = new Thread(this);
		
		miHilo.start();
	
		
		}	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			ServerSocket miServidor = new ServerSocket(9999); // puerto a la escucha
			
			String nick, ip, mensaje;
			
			ArrayList<String>listaIpConectados = new ArrayList<String>();
			
			EnvioPaqueteDatos paqueteRecibido;
			
			while(true) {
			
				Socket miSocket = miServidor.accept(); // acepta todas las conexiones que viajan por el socket	
				
				
				
				//Flujo de entrada de datos
				
				ObjectInputStream flujoDatosEntrada = new ObjectInputStream(miSocket.getInputStream());
				
				paqueteRecibido = (EnvioPaqueteDatos) flujoDatosEntrada.readObject();
				
				nick = paqueteRecibido.getNick();
				
				ip = paqueteRecibido.getIp();
				
				mensaje = paqueteRecibido.getTextoCliente();
				
				/*DataInputStream flujoEntrada = new DataInputStream(miSocket.getInputStream());
				
				String mensajeTexto = flujoEntrada.readUTF();
				
				areatexto.append("\n"+mensajeTexto);*/
			
				if(!mensaje.equals(" online")) {
					
					areatexto.append("\n" + "nick"+" : "+nick+" Mensaje: "+mensaje+ " IP: "+ ip);
					
					Socket reenvioDestinatario = new Socket(ip,9090);
					
					ObjectOutputStream paquetereenvio = new ObjectOutputStream(reenvioDestinatario.getOutputStream());
					
					paquetereenvio.writeObject(paqueteRecibido);
					
					reenvioDestinatario.close();
					
					miSocket.close();
				}else {
					
					InetAddress dirClientes = miSocket.getInetAddress();
					
					String ipClientesConectados = dirClientes.getHostAddress();
					
					System.out.println("Direccion remota conectada: "+ ipClientesConectados);
					
					listaIpConectados.add(ipClientesConectados);
					
					paqueteRecibido.setIPs(listaIpConectados);
					
					for(String laIp: listaIpConectados) {
						
						System.out.println("ArrayList:"+laIp);
						
						Socket reenvioDestinatario = new Socket(laIp,9090);
						
						ObjectOutputStream paquetereenvio = new ObjectOutputStream(reenvioDestinatario.getOutputStream());
						
						paquetereenvio.writeObject(paqueteRecibido);
						
						reenvioDestinatario.close();
						
						miSocket.close();
					}
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
	
	private	JTextArea areatexto;

	
	
}
