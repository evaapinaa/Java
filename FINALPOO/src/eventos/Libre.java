package eventos;

public class Libre extends Evento {

	public Libre(String nombre, double precio) {
		super(nombre, precio);
	}
	@Override
	protected boolean esAceptable(Marcador marcador) {
		return !getMapa().values().contains(marcador);
	}
	
	@Override
	public Libre clone() {
		// COPIA SUPERFICIAL SOLO
		Libre copia = (Libre)super.clone() ;
		return copia;
	}
}
