package geometria;

public class Circulo {
	private static final Punto ORIGEN_COORDENADAS = new Punto();
	public static final int RADIO_POR_DEFECTO = 5;
	
	// Atributos
	private Punto centro;
	private int radio;
	//private double perimetro;
	
	// Metodos de consulta
	public Punto getCentro() {
		return new Punto(centro);
	}
	
	public int getRadio() {
		return radio;
	}
	
	public int getPerimetro() {
		return (int) (2 * Math.PI * radio);
	}
	
	// Constructores
	public Circulo(Punto centro, int radio) {
		this.centro = new Punto(centro);
		this.radio = radio;
	}
	
	public Circulo() {
		this(ORIGEN_COORDENADAS,RADIO_POR_DEFECTO);
	}
	
	// Metodos
	public void desplazar(int coordX, int coordY) {
		centro.desplazarPunto(coordX, coordY);
	}
	
	public void escalar(int escala) {
		radio = (radio*escala)/100;
		// radio *= escala/100.0;
	}	
	
	
}


