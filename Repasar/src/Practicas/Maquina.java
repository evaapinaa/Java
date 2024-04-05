package Practicas;

public class Maquina {
	
	private String producto;
	private double precio;
	private int stock;
	private Dinero dineroAcumulado;
	private Dinero dineroTransaccion;
	
	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
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

	public Maquina(String producto, double precio, int stock) {
		this.producto = producto;
		this.precio = precio;
		this.stock = stock;
		this.dineroAcumulado = Dinero.NADA;
		this.dineroTransaccion = Dinero.NADA;
	}
	
	public void insertar(Dinero dinero) {
		this.dineroTransaccion = dineroTransaccion.sumar(dinero);
	}
	
	public Dinero devolver() {
		Dinero devolucion = this.dineroTransaccion;
		this.dineroTransaccion = Dinero.NADA;
		return devolucion;
	}
	
	public boolean comprar() {
		if(dineroAcumulado.getTotal() > 0 && dineroTransaccion.getTotal() >= precio) {
			this.dineroAcumulado = dineroAcumulado.sumar(dineroTransaccion);
			stock--;
			dineroTransaccion = Dinero.NADA;
			return true;
		}
		return false;
	}
}
