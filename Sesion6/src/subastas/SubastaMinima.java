package subastas;

public class SubastaMinima extends Subasta {
	
	// ATRIBUTOS
	private double cantidadMin;
	
	// METODOS DE CONSULTA
	public double getCantidadMin() {
		return cantidadMin;
	}

	public void setCantidadMin(double cantidadMin) {
		this.cantidadMin = cantidadMin;
	}
	
	// CONSTRUCTOR
	public SubastaMinima(String NombreProducto, String propietario, double cantidadMin) {
		super(NombreProducto, propietario);
		this.cantidadMin = cantidadMin;
	}

	
	@Override
	public boolean ejecutar() {
		if (getPujaMayor() != null && getPujaMayor().getCantidad() > cantidadMin) {
			return super.ejecutar();
		}
		return false;
	}
	
	// CERRAR SUBASTA AUTOMATICAMENTE

}
