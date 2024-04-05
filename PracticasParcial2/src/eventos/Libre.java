package eventos;

public class Libre extends Evento {

	public Libre(String nombre, double precio) {
		super(nombre, precio);
	}
	
	@Override
	protected boolean isAceptable(Marcador apuesta) {
		return !getApuestas().values().contains(apuesta);
	}
	
}
