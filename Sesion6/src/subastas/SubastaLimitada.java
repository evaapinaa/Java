package subastas;

public class SubastaLimitada extends Subasta{
	// ATRIBUTOS
	private final int maximo;
	// private int pujasPendientes;
	
	// METODOS DE CONSULTA
	public int getMaximo() {
		return maximo;
	}
	
	public int getPujasPendientes() {
		return maximo - getListaPujas().size();
	}
	
	// CONSTRUCTOR
	public SubastaLimitada(String NombreProducto, String propietario, int maximo) {
		super(NombreProducto, propietario);
		this.maximo = maximo;
		//this.pujasPendientes = maximo;
	}
	
	@Override
	public boolean pujar(String pujador, double cantidad) {
		if(super.pujar(pujador,cantidad)) {
			if(getPujasPendientes() <= 0) {
				ejecutar();
			}
			return true;
		}
		return false;
	}
}
