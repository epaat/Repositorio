package es.pildorasinformaticas.colecciones;

public class Libro {

	
	public Libro(String autor, String titulo, int isbn) {
		this.autor = autor;
		this.titulo = titulo;
		this.isbn = isbn;
	}
	
	public String getDatos() {
		
		return "El titulo es: " + titulo + ". El autor es "+autor+" . Y el ISBN es "+ isbn;
	}
	
	/*public boolean equals(Object obj) {
		
		Libro otroLibro = (Libro)obj;
		
		if(obj instanceof Libro) {
			
			if(this.isbn==otroLibro.isbn) return true;
			
			else return false;
		}
		
		else return false;
	}*/
	
	

	private String autor;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + isbn;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		if (isbn != other.isbn)
			return false;
		return true;
	}

	private String titulo;
	
	private int isbn;
}
