package maquinas;

public class Maquina {
	
	// ATRIBUTOS
	private String producto;
	private double precio;
	private int stock;
	private Dinero dineroAcumulado;
	private Dinero dineroTransaccion;
	
	// METODOS DE CONSULTA
	public String getProducto() {
		return producto;
	}

	public double getPrecio() {
		return precio;
	}
	
	public int getStock() {
		return stock;
	}

	public Dinero getDineroAcumulado() {
		return dineroAcumulado;
	}

	public Dinero getDineroTransaccion() {
		return dineroTransaccion;
	}

	public boolean isVacia() {
		if (stock == 0) {
			return true;
		}
		return false;
	}
	
	// PUEDEN MODIFICARSE
	public void setProducto(String producto) {
		this.producto = producto;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	// CONSTRUCTOR
	public Maquina(String producto, double precio, int stock) {
		this.producto = producto;
		this.precio = precio;
		this.stock = stock;
		this.dineroAcumulado = Dinero.NADA;
		this.dineroTransaccion = Dinero.NADA;
		
	}
	
	// METODOS
	
	public void insertarDinero(Dinero dinero) {
		this.dineroTransaccion = dineroTransaccion.suma(dinero);
	}
	
	public void devolverDinero() {
		this.dineroTransaccion = Dinero.NADA;
	}
	
	public boolean comprar() {
		if (!isVacia() && dineroTransaccion.getTotal() >= precio) {
			dineroAcumulado = dineroAcumulado.suma(dineroTransaccion);
			stock = stock - 1;
			dineroTransaccion = Dinero.NADA;
			return true;
		}
		return false;
	}
}
