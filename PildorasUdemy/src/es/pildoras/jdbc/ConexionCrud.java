package es.pildoras.jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.*;

public class ConexionCrud {

	public void crearRegistro(String seccion, String nom, String origen, String precio){
		
		
		
		try {
			
			// 1. CREAR CONEXION
			
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionpedidos", "root", "");
			
			// 2. CREAR STATEMENT
			
			Statement miSt = (Statement) con.createStatement();
			
			// 3. CREAR SENTENCIA SQL
			
			PreparedStatement stmt = con.prepareStatement("INSERT INTO articulos2 (A,B,D,E) VALUES (?,?,?,?)");
			
			stmt.setString(1,seccion);
			
			stmt.setString(2, nom);
			
			stmt.setString(3, origen);
			
			stmt.setString(4, precio);
			
			// 4. EJECUTAR SQL
			
			stmt.executeUpdate();
			
			System.out.println("Registro eliminado correctamente");
			
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		public void leerRegistro(String nom){
			
			
			
			try {
				
				// 1. CREAR CONEXION
				
				Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionpedidos", "root", "");
				
				// 2. CREAR STATEMENT
				
				Statement miSt = (Statement) con.createStatement();
				
				// 3. CREAR SENTENCIA SQL
				
				PreparedStatement stmt = con.prepareStatement("SELECT A,B,C,D,E FROM articulos2 WHERE B=? ");
				
				stmt.setString(1,nom);
				
				ResultSet miRs = stmt.executeQuery();
				// 4. EJECUTAR SQL
				
				while(miRs.next()) {
					
					System.out.println(miRs.getString(1)+" "+ miRs.getString(2)+ " "+miRs.getString(3)+" "+miRs.getString(4)
					+miRs.getString(5));
					
					seccion = miRs.getString(1);
					
					nombre = miRs.getString(2);
					
					origen = miRs.getString(4);
					
					precio = miRs.getString(5);
					}
					miRs.close();
				
				System.out.println("Registro leido");
				
				
				
				
				con.close();
				
			
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		
		
		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getSeccion() {
			return seccion;
		}

		public void setSeccion(String seccion) {
			this.seccion = seccion;
		}

		public String getOrigen() {
			return origen;
		}

		public void setOrigen(String origen) {
			this.origen = origen;
		}

		public String getPrecio() {
			return precio;
		}

		public void setPrecio(String precio) {
			this.precio = precio;
		}


		private String nombre,seccion, origen, precio;
}
