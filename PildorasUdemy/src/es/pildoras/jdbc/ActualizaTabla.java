package es.pildoras.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ActualizaTabla {


public static void main(String[] args) {
	// TODO Auto-generated method stub

	
	try {
		
		// 1. CREAR CONEXION
		
		
		Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionpedidos", "root", "");
		
		// 2. CREAR STATEMENT
		
		Statement miSt = miCon.createStatement();
		
		// 3. CREAR INSTRUCCIÓN SQL
		
		//String inSQL = "INSERT INTO articulos2 (B,E) VALUES ('CAMISA FLORES','50')";
		
		//String inSQL = "UPDATE articulos2 SET E=70 WHERE B='CAMISA FLORES'";
		
		String inSQL = "DELETE FROM articulos2 WHERE B='CAMISA FLORES'";
		
		// 4. EJECUTAR SQL
		
		miSt.executeUpdate(inSQL);
		
		System.out.println("Registro eliminado correctamente");
		
		miCon.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}