package eventos;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Restringido extends Evento {
	
	private final Set<Marcador> opciones;
	
	public Set<Marcador> getOpciones() {
		return Collections.unmodifiableSet(opciones);
	}
	
	public Restringido(String nombre, double precio) {
		super(nombre, precio);
		opciones = new HashSet<Marcador>();
	}
	
	@Override
	protected boolean isAceptable(Marcador apuesta) {
		return opciones.contains(apuesta);
	}
	
	public int getNumApuestas(Marcador apuesta) {
		int cont = 0;
		for(Marcador m : getApuestas().values()) {
			if(apuesta.equals(m)) cont ++;
		}
		return cont;
	}
		

	

	
}
