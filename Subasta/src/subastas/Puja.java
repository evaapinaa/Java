package subastas;

public class Puja {
	
	// ATRIBUTOS
	private final String pujador;
	private final double cantidad;
	
	// METODOS DE CONSULTA
	public String getPujador() {
		return pujador;
	}

	public double getCantidad() {
		return cantidad;
	}
	
	// CONSTRUCTOR
	public Puja(String pujador, double cantidad) {
		this.pujador = pujador;
		this.cantidad = cantidad;
	}
}
