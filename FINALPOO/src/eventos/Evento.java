package eventos;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class Evento implements Cloneable {

	private String nombre;
	private double precio;
	private Map<String, Marcador> mapa;
	private Estado estado;
	private Marcador resultado;
	
	// APUESTAS REALIZADAS
	
	public int getApuestasRealizadas() {
		return mapa.size();
	}
	
	public double getRecaudacion() {
		return getApuestasRealizadas()*precio;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public Map<String, Marcador> getMapa() {
		return new HashMap<String, Marcador>(mapa);
	}
	
	public Estado getEstado() {
		return estado;
	}
	
	public Marcador getResultado() {
		return resultado;
	}
	
	public void setResultado(Marcador resultado) {
		
		if(resultado == null) {
			throw new IllegalArgumentException("El marcador no puede ser nulo");
		}
		
		if(!estado.equals(Estado.CERRADO)) {
			throw new IllegalStateException("El estado debe ser cerrado.");
		}
		
		this.resultado = resultado;
		this.estado = Estado.FINALIZADO;
	}
	
	public Evento(String nombre, double precio) {
		super();
		if(nombre == null) {
			throw new IllegalArgumentException("El nombre no puede ser nulo");
		}
		if(nombre.isEmpty()) {
			throw new IllegalArgumentException("El nombre no puede ser vacío");
		}
		if(precio<=0) {
			throw new IllegalArgumentException("El precio debe ser positivo, y mayor que cero");
		}
		
		this.nombre = nombre;
		this.precio = precio;
		this.mapa = new HashMap<String, Marcador>();
		this.estado = Estado.ABIERTO;
		this.resultado = null;
	}
	
	public boolean apostar(String usuario, Marcador marcador) {
		if(!estado.equals(Estado.ABIERTO)) {
			throw new IllegalStateException("Para apostar, el estado debe ser abierto.");
		}
		if(esAceptable(marcador)) {
			mapa.put(usuario, marcador);
			return true;
		}
		if(usuario == null) {
			throw new IllegalArgumentException("El usuario debe ser distinto de null");
		}
		if(usuario.isEmpty()) {
			throw new IllegalArgumentException("El usuario no puede ser vacío.");
		}
		if(marcador == null) {
			throw new IllegalArgumentException("El marcador debe ser distinto de null");
		}
		
		return false;
	}
	protected abstract boolean esAceptable(Marcador marcador);

	@Override
	public String toString() {
		return getClass().getName()+" [nombre=" + nombre + ", precio=" + precio + ", mapa=" + mapa + ", apuestas realizadas="
				+ getApuestasRealizadas() + ", recaudacion=" + getRecaudacion() + "]";
	}
	
	private Evento getCopiaSuperficial() {
		try {
			return (Evento)super.clone();
		}catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Evento clone() {
		// COPIA SUPERFICIAL SOLO
				Evento copia = getCopiaSuperficial() ;
				// COPIA PROFUNDA
				copia.mapa = new HashMap<String, Marcador>(mapa);
				return copia;
	}
	
	public void cerrarEvento() {
		if(!estado.equals(Estado.ABIERTO)) {
			throw new IllegalStateException("Para poder cerrar un evento, anteriormente tiene que estar abierto.");
		}
		this.estado = Estado.CERRADO;
	}
	
	public Set<String> consultarGanadores() {
		if(!estado.equals(Estado.FINALIZADO)) {
			throw new IllegalStateException("Para poder consultar los ganadores, el estado del evento debe ser finalizado.");
		}
		Set<String> resultado = new HashSet<String>();
		for(String s : mapa.keySet()) {
			if(mapa.get(s).equals(this.getResultado())) {
				resultado.add(s);
			}
		}
		return resultado;
	}
}
