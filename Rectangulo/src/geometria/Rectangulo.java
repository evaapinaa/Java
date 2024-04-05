package geometria;

public class Rectangulo {
	
	// ATRIBUTOS
	//private int ladoX;
	//private int ladoY;
	private Punto verticeII;
	private Punto verticeSD;
	//private Punto verticeSI;
	//private Punto verticeID;
	//private double perimetro;
	
	// METRODOS DE CONSULTA
	public int getLadoX() {
		return Math.abs(verticeSD.getX() - verticeII.getX());
	}
	
	public int getLadoY() {
		return Math.abs(verticeSD.getY() - verticeII.getY());
	}
	
	public Punto getVerticeII() {
		return new Punto(verticeII);
	}
	
	public Punto getVerticeSD() {
		return new Punto(verticeII.getX() + getLadoX(), verticeII.getY() + getLadoY());
	}
	
	public Punto getVerticeSI() {
		return new Punto(verticeII.getX(), verticeII.getY() + getLadoY());
	}
	
	public Punto getVerticeID() {
		return new Punto(verticeII.getX() + getLadoX(), verticeII.getY());
	}
	
	public int getPerimetro() {
		return (2 * getLadoX() + 2 * getLadoY());
	}
	
	// CONSTRUCTORES
//	
//	public Rectangulo(Punto verticeII, int ladoX, int ladoY) {
//		this.verticeII = new Punto(verticeII);
//		this.ladoX = ladoX;
//		this.ladoY = ladoY;
//        this.verticeSD = new Punto(verticeII.getX() + ladoX, verticeII.getY() + ladoY);
//	}
	
	public Rectangulo(Punto verticeII, Punto verticeSD) {
		this.verticeII = new Punto(verticeII);
		this.verticeSD = new Punto(verticeSD);
		//ladoX = Math.abs(verticeSD.getX() - verticeII.getX());
		//ladoY = Math.abs(verticeSD.getY() - verticeII.getY());
		
	}
	
	public void desplazar(int incrX, int incrY) {
		verticeII.desplazarPunto(incrX, incrY);
		verticeSD.desplazarPunto(incrX,incrY);
	}
	
	public void escalar(int escala) {
		double factor = escala / 100.0;
		
	    int ladoX = (int) (getLadoX() * factor);
	    int ladoY = (int) (getLadoY() * factor);
	    
	    int diffX = (int) (ladoX * (1 - factor) / 2);
	    int diffY = (int) (ladoY * (1 - factor) / 2);
	    
	    desplazar(diffX,diffY);
	    
	}
}
