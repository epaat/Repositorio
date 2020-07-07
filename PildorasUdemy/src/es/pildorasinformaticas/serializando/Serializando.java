package es.pildorasinformaticas.serializando;

import java.io.*;
import java.util.*;

public class Serializando {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Administrador jefe = new Administrador("Juan", 80000, 2005,12,15);
		
		jefe.setIncentivo(5000);
		
		Empleado[] personal = new Empleado[3];
		
		personal[0] = jefe;
		
		personal[1] = new Empleado("Ana",25000,2008,10,1);
		
		personal[2] = new Empleado("Luis", 18000, 2012, 9, 15);
		
		try {
			
			//generando objeto serializado
			
			/*ObjectOutputStream flujoSalida = new ObjectOutputStream(new FileOutputStream("D:/Descargas/externoJava/miObjetoSerializado.dat"));
			
			flujoSalida.writeObject(personal);
			
			flujoSalida.close();*/
			
			//leyendo objeto serializado
			
			ObjectInputStream flujoEntrada = new ObjectInputStream(new FileInputStream("D:/Descargas/externoJava/miObjetoSerializado.dat"));
			
			Empleado [] entradaObjeto =(Empleado[]) flujoEntrada.readObject();
			
			flujoEntrada.close();
			
			for(Empleado e: entradaObjeto) {
				
				System.out.println(e);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e) {
			
		}
	}

}
class Empleado implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Empleado(String n, double s, int agno, int mes, int dia) {
		
		nombre = n;
		
		sueldo = s;
		
		GregorianCalendar calendario = new GregorianCalendar(agno,mes-1,dia);
		
		fechaContrato = calendario.getTime();
	}
	
	public String getNombre() {
		
		return nombre;
	}
	
	public double getSueldo() {
		
		return sueldo;
	}
	
	public Date getFechaContato() {
		
		return fechaContrato;
	}
	
	public void subirSueldo(double porcentaje) {
		
		double aumento = sueldo*porcentaje/100;
		
		sueldo+=aumento;
	}
	
	public String toString() {
		
		return "El nombre es " + nombre +" y, su suel es ="+ sueldo+" , fecha de contrato="+fechaContrato;
	}
	
	private String nombre;
	
	private double sueldo;
	
	private Date fechaContrato;
}

//------------------------------------------------------------------------------------------------------------

class Administrador extends Empleado{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Administrador(String n, double s, int agno, int mes, int dia) {
		
		super(n,s,agno,mes, dia);
		
		incentivo = 0;
	}
	
	public double getSueldo() {
		
		double sueldoBase = super.getSueldo();
		
		return sueldoBase + incentivo;
	}
	
	public void setIncentivo(double b) {
		
		incentivo = b;
	}
	
	public String toString() {
		
		return super.toString()+ "Incentivo "+ incentivo;
	}
	
	private double incentivo;
}