package examen;

import java.time.LocalDateTime;
import java.util.Objects;

public class Evento {
	
	private final String nombre;
	private final LocalDateTime inicio;
	private final LocalDateTime fin;
	
	public LocalDateTime getFin() {
		return fin;
	}
	public LocalDateTime getInicio() {
		return inicio;
	}
	public String getNombre() {
		return nombre;
	}
	
	public Evento(String nombre, LocalDateTime inicio, LocalDateTime fin) {
		super();
		this.nombre = nombre;
		this.inicio = inicio;
		this.fin = fin;
	}
	
	public boolean isDentroEvento(LocalDateTime instante) {
		if((instante.equals(inicio) || instante.isAfter(inicio)) && (instante.equals(fin) || instante.isBefore(fin))) {
			return true;
		}
		return false;
	}
	
	public boolean solapaTiempo(Evento e) {
		if(getInicio().isBefore(e.getFin()) && getFin().isAfter(e.getInicio())) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(fin, inicio, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		return Objects.equals(fin, other.fin) && Objects.equals(inicio, other.inicio)
				&& Objects.equals(nombre, other.nombre);
	}
	
	
}
