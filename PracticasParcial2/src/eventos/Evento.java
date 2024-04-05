package eventos;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class Evento {
	private String nombre;
	private final double precio;
	private Map<String, Marcador> apuestas;
	
	
	public String getNombre() {
		return nombre;
	}
	
	public Map<String, Marcador> getApuestas() {
		return Collections.unmodifiableMap(apuestas);
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public int getNumApuestas() {
		return apuestas.size();
	}
	
	public double getRecaudacion() {
		return getNumApuestas() * precio;
	}

	public Evento(String nombre, double precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.apuestas = new HashMap<String,Marcador>();
	}
	
	public boolean apostar(String nombre, Marcador apuesta) {
		if(isAceptable(apuesta)) {
			apuestas.put(nombre, apuesta);
			return true;
		}
		return false;
	}
	
	protected abstract boolean isAceptable(Marcador apuesta);
	
}
