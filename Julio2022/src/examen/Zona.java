package examen;


/**
* No tiene sentido porque aunque no se puedan construir objetos de esta clase y tengan que ser
las subclases las que
* utilicen el constructor. No todas las clases que hereden de una clase abstracta tienen por
qué estar en el mismo paquete
* que la propia clase abstracta. Hay que declararlos como public.
*/
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Zona implements Cloneable {
	
	private static final int MINUTOS_DEFECTO = 120;
	
	private String nombre;
	private Map<String, Estacionamiento> estacionamientos;
	private int minutos;
	private Set<String> sancionados;
	
	public Zona(String nombre, int minutos) {
		this.nombre = nombre;
		this.estacionamientos = new HashMap<>();
		this.minutos = minutos;
		this.sancionados = new TreeSet<>();
	}
	public Zona(String nombre) {
		this(nombre, MINUTOS_DEFECTO);
	}
	public String getNombre() {
		return nombre;
	}
	public Map<String, Estacionamiento> getEstacionamientos() {
		return new HashMap<>(estacionamientos);
	}
	public int getMinutos() {
		return minutos;
	}
	public Set<String> getSancionados() {
		return new TreeSet<>(sancionados);
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}
	public boolean isSancionado(String matricula) {
		return sancionados.contains(matricula);
	}
	public LocalDateTime calcularFechaFinal (LocalDateTime fechaInicio, long dinero) {
		long minutosEstacionado = minutos*dinero; // (minutos*dinero)/1
		return fechaInicio.plusMinutes(minutosEstacionado);
	}
	
	public boolean comprobarEstacionamiento (String matricula) {
		if (!estacionamientos.containsKey(matricula) || !estacionamientos.get(matricula).isActivo()) {
			sancionados.add(matricula);
			estacionamientos.remove(matricula);
			return false;
		} else {
			return true;
		}
	}
	
	public Estacionamiento aparcar (String matricula, long dinero, LocalDateTime fechaInicio) {
		if (!sancionados.contains(matricula)) {
			LocalDateTime fechaFinalizacion = calcularFechaFinal(fechaInicio, dinero);
			Estacionamiento estacionamiento = new Estacionamiento(matricula,
			fechaInicio, fechaFinalizacion);
			estacionamientos.put(matricula, estacionamiento);
			return estacionamiento;
		} else {
			return null;
		}
	}
	
	public Estacionamiento aparcar (String matricula, long dinero) {
		return aparcar(matricula, dinero, LocalDateTime.now());
	}
	
	protected void cancelarSancion (String matricula) {
		sancionados.remove(matricula);
	}
	@Override
	public Zona clone() {
		Zona copia = copiaSuperficial();
		//Corregir el aliasing;
		copia.nombre+=copia.nombre+" |";
		copia.estacionamientos = new HashMap<>();
		copia.sancionados = new TreeSet<>();
		return copia;
	}
	private Zona copiaSuperficial() {
		Zona copiaSuperficial;
		try {
			copiaSuperficial = (Zona)super.clone();
			return copiaSuperficial;
		} catch (CloneNotSupportedException e) {
			System.err.println("La clase no es cloneable");
		}
		return null;
	}
	@Override
	public String toString() {
		return getClass().getName()+" [nombre=" + nombre + ", estacionamientos=" +
		estacionamientos + ", minutos=" + minutos
		+ ", sancionados=" + sancionados + "] ";
	}
}
