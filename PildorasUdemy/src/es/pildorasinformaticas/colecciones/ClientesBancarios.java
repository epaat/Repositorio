package es.pildorasinformaticas.colecciones;

import java.util.*;

public class ClientesBancarios {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Cliente cliente1 = new Cliente("Antonio López", "0001", 20000);
		
		Cliente cliente2 = new Cliente("Rafael Gómez ","0002", 15000);
		
		Cliente cliente3 = new Cliente("Ana Martín", "0003", 20000);
		
		Cliente cliente4 = new Cliente("Juan Díaz", "0004", 20);
		
		Cliente cliente5 = new Cliente("Antonio López", "0001", 20000);
		
		Set<Cliente> clientesDelBanco = new HashSet<Cliente>();
		
		clientesDelBanco.add(cliente1);
		
		clientesDelBanco.add(cliente2);
		
		clientesDelBanco.add(cliente3);
		
		clientesDelBanco.add(cliente4);
		
		clientesDelBanco.add(cliente5);
		
		/*for (Cliente cliente : clientesDelBanco) {
			
			if(cliente.getNombre().equals("Ana Martín"))clientesDelBanco.remove(cliente);
		}
		
		for (Cliente cliente : clientesDelBanco) {
			
			System.out.println(cliente.getNombre()+" "+ cliente.getnCuenta()+" " +cliente.getSaldo());
		}*/
		
		Iterator<Cliente> it = clientesDelBanco.iterator();
		
		while(it.hasNext()) {
			
			String nombreCliente = it.next().getNombre();
			
			if(nombreCliente.equals("Ana Martín"))it.remove();
		}
		
		for (Cliente cliente : clientesDelBanco) {
			
			System.out.println(cliente.getNombre()+" "+ cliente.getnCuenta()+" " +cliente.getSaldo());
		}
	}

}
