package eventos;

import java.util.HashMap;
import java.util.Map;

public abstract class Evento implements Cloneable {

	private String nombre;
	private double precio;
	private Map<String, Marcador> mapa;
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
	
	public Evento(String nombre, double precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.mapa = new HashMap<String, Marcador>();
	}

	public boolean apostar(String usuario, Marcador marcador) {
		if(esAceptable(marcador)) {
			mapa.put(usuario, marcador);
			return true;
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
	
}
