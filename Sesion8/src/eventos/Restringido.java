package eventos;

import java.util.HashSet;
import java.util.Set;

public class Restringido extends Evento {
	
	private final Set<Marcador> opciones;
	
	public Set<Marcador> getOpciones() {
		return new HashSet<>(opciones);
	}
	
	public Restringido(String nombre, double precio, Set<Marcador> opciones) {
		super(nombre, precio);
		this.opciones = new HashSet<>(opciones);
	}

	@Override
	protected boolean esAceptable(Marcador marcador) {
		return opciones.contains(marcador);
	}

	@Override
	public String toString() {
		return super.toString()+"[opciones=" + opciones + "]";
	}
	@Override
	public Restringido clone() {
		// COPIA SUPERFICIAL SOLO
		Restringido copia = (Restringido)super.clone() ;
		// COPIA PROFUNDA no puedo volver a asignar una copia de opciones en el atributo copia.opciones porque es final
		return copia;
	}
}
