package Repaso;

import java.time.LocalDate;
import java.util.Objects;

public class Servicio implements Comparable<Servicio>{
	
	private final Tipo tipo;
	private final LocalDate fecha;
	
	public LocalDate getFecha() {
		return fecha;
	}
	public Tipo getTipo() {
		return tipo;
	}
	
	public Servicio(Tipo tipo, LocalDate fecha) {
		super();
		this.tipo = tipo;
		this.fecha = fecha;
	}
	
	public Servicio(Tipo tipo) {
		this(tipo, LocalDate.now());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(fecha, tipo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Servicio other = (Servicio) obj;
		return Objects.equals(fecha, other.fecha) && tipo == other.tipo;
	}
	
	@Override
	public int compareTo(Servicio s2) {
		int x = getFecha().compareTo(s2.getFecha());
		if(x == 0) {
			return getTipo().compareTo(s2.getTipo());
		}
		return x;
	}
	
}
