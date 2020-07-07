package es.pildorasinformaticas.colecciones;

public class Cliente {
	
	public Cliente(String nombre, String nCuenta, double saldo) {
		
		this.nombre = nombre;
		
		this.nCuenta = nCuenta;
		
		this.saldo = saldo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nCuenta == null) ? 0 : nCuenta.hashCode());
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
		Cliente other = (Cliente) obj;
		if (nCuenta == null) {
			if (other.nCuenta != null)
				return false;
		} else if (!nCuenta.equals(other.nCuenta))
			return false;
		return true;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getnCuenta() {
		return nCuenta;
	}

	public void setnCuenta(String nCuenta) {
		this.nCuenta = nCuenta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	private String nombre;
	
	private String nCuenta;
	
	private double saldo;
}
