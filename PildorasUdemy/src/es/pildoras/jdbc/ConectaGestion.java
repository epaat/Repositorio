package es.pildoras.jdbc;


import java.sql.*;


public class ConectaGestion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		try {
			
			// 1. CREAR CONEXION
			
			
			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionpedidos", "root", "");
			
			// 2. CREAR STATEMENT
			
			Statement miSt = miCon.createStatement();
			
			// 3,EJECUTAR INSTRUCCION SQL
			
			ResultSet miRs = miSt.executeQuery("SELECT * FROM articulos2");
			
			// 4. LEER EL RESULTSET
			
			while(miRs.next()) {
				
				System.out.println(miRs.getString(1)+" "+miRs.getString(2));
			}
			
			miRs.close();
			
			miCon.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
