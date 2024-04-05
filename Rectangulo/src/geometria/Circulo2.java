package geometria;

public class Circulo2 {
	private static final PuntoInmutable ORIGEN_COORDENADAS = new PuntoInmutable();
	public static final int RADIO_POR_DEFECTO = 5;
	
	// Atributos
	private PuntoInmutable centro;
	private int radio;
	//private double perimetro;
	
	// Metodos de consulta
	public PuntoInmutable getCentro() {
		return centro;
	}
	
	public int getRadio() {
		return radio;
	}
	
	public int getPerimetro() {
		return (int) (2 * Math.PI * radio);
	}
	
	// Constructores
	public Circulo2(PuntoInmutable centro, int radio) {
		this.centro = centro;
		this.radio = radio;
	}
	
	public Circulo2() {
		this(ORIGEN_COORDENADAS,RADIO_POR_DEFECTO);
	}
	
	// Metodos
	public void desplazar(int coordX, int coordY) {
		this.centro = centro.desplazarPunto(coordX, coordY);
	}
	
	public void escalar(int escala) {
		radio = (radio*escala)/100;
		// radio *= escala/100.0;
	}	
	
	
}


