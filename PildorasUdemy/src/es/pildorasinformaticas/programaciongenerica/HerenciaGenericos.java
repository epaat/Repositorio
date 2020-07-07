package es.pildorasinformaticas.programaciongenerica;

public class HerenciaGenericos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Empleado Empleado15248;
		
		Jefe Sara = new Jefe("Sara", 27, 3750);
		
		Empleado15248 = Sara;*/
		
		VariosTipos<Empleado> Empleado15248 = new VariosTipos<Empleado>();
		
		VariosTipos<Jefe> Sara = new VariosTipos<Jefe>();
		
		//Empleado15248 = Sara;
		
		VariosTipos.imprimirTrabajador(Sara);
	}

}
