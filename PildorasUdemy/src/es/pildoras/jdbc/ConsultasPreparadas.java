package es.pildoras.jdbc;

import java.sql.*;

import com.mysql.jdbc.PreparedStatement;

public class ConsultasPreparadas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			// 1. CREAR CONEXION
			
			
			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionpedidos", "root", "");
			
			// 2. CREAR STATEMENT
			
			//Statement miSt = miCon.createStatement();
			
			String sentencia ="SELECT A,B,C,D,E FROM articulos2 WHERE B=? AND D=?";
			
			PreparedStatement miPSt= (PreparedStatement) miCon.prepareStatement(sentencia);
			
			miPSt.setString(1, "psp");
			
			miPSt.setString(2, "china");
			
			// 3. CREAR INSTRUCCIÓN SQL
			
			//String inSQL = "INSERT INTO articulos2 (B,E) VALUES ('CAMISA FLORES','50')";
			
			//String inSQL = "UPDATE articulos2 SET E=70 WHERE B='CAMISA FLORES'";
			
			//String inSQL = "DELETE FROM articulos2 WHERE B='CAMISA FLORES'";
			
			// --3. EJECUTAR INSTRUCCIÓN SQL
			
			ResultSet miRs = miPSt.executeQuery();
			
			//--4. LEER EL RESULSET
			
			while(miRs.next()) {
			
			System.out.println(miRs.getString(1)+" "+ miRs.getString(2)+ " "+miRs.getString(3)+" "+miRs.getString(4)
			+miRs.getString(5));
			}
			miRs.close();
			
			//REUTILIZACIÓN DE CONSULTA PREPARADA
			
			System.out.println();
			
			System.out.println();
			
			miPSt.setString(1, "Maceta");
			
			miPSt.setString(2, "España");
			
			ResultSet miRs2 = miPSt.executeQuery();
			
			while(miRs2.next()) {
				
				System.out.println(miRs2.getString(1)+" "+ miRs2.getString(2)+ " "+miRs2.getString(3)+" "+miRs2.getString(4)
				+miRs2.getString(5));
				}
			miRs2.close();
			miCon.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
