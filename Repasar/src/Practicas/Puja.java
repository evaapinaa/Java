package Practicas;

public class Puja {

	private final String pujador;
	private final double cantidad;
	
	public String getPuja() {
		return pujador;
	}

	public double getCantidad() {
		return cantidad;
	}
	
	public Puja(String pujador, double cantidad) {
		this.pujador = pujador;
		this.cantidad =  cantidad;
	}
	
	
}
