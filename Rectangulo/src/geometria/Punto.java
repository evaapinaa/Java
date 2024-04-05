package geometria;


public class Punto {
	
	public static final int EJE_COORD_X = 0;
	public static final int EJE_COORD_Y = 0;
	
	// Atributos
	private int x;
	private int y;
	
	// Metodos
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public double distancia(Punto punto2) {
		return Math.sqrt(Math.pow(this.x-punto2.getX(),2)+Math.pow(this.y-punto2.getY(),2));
	}
	
	//Constructores
	public Punto(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Punto() {
		this(EJE_COORD_X,EJE_COORD_Y);
	}
	
	public Punto(Punto p) {
		this(p.getX(), p.getY());
	}
	
	public void desplazarPunto(int incrX, int incrY) {
		x += incrX;
		y += incrY;
	}
	
	// Sobrecarga
	public void desplazarPunto(Direccion direccion) {
		switch (direccion) {
		case ARRIBA:
			desplazarPunto(0,1);
			break;
		case ABAJO:
			desplazarPunto(0,-1);
			break;
		case IZQUIERDA:
			desplazarPunto(-1,0);
			break;
		case DERECHA:
			desplazarPunto(1,0);
			break;
		default:
			break;
		}
	}
	
	public static Punto mayorDistancia(Punto... puntos) {
		Punto origen = new Punto();
		Punto masLejano = null;
		double mayorDistancia = 0;
		
		for(Punto puntoActual : puntos) {
			double distanciaActual = origen.distancia(puntoActual);
			if(distanciaActual > mayorDistancia) {
				mayorDistancia = distanciaActual;
				masLejano = puntoActual;
			}
		}
		
		return masLejano;
	}
	
}
