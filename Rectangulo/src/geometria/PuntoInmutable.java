package geometria;

public class PuntoInmutable {
	
	public static final int EJE_COORD_X = 0;
	public static final int EJE_COORD_Y = 0;
	
	// Atributos
	private final int x;
	private final int y;
	
	// Metodos
	public int getX() {
		return x;
	}
	
	/*
	public void setX(int x) {
		this.x = x;
	}*/
	
	public int getY() {
		return y;
	}
	
	/*public void setY(int y) {
		this.y = y;
	}*/
	
	//Constructores
	public PuntoInmutable(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public PuntoInmutable() {
		this(EJE_COORD_X,EJE_COORD_Y);
	}
	
	public PuntoInmutable(PuntoInmutable p) {
		this(p.getX(), p.getY());
	}
	
	public PuntoInmutable desplazarPunto(int incrX, int incrY) {
		int nuevoX = x + incrX;
		int nuevoY = y + incrY;
		return new PuntoInmutable(nuevoX,nuevoY);
	}
	
}
