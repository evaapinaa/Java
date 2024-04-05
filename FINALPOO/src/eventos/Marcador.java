package eventos;

import java.util.Objects;

public class Marcador {
	
	private final int local;
	private final int visitante;
	
	public int getLocal() {
		return local;
	}
	public int getVisitante() {
		return visitante;
	}
	
	public Marcador(int local, int visitante) {
		super();
		this.local = local;
		this.visitante = visitante;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(local, visitante);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Marcador other = (Marcador) obj;
		return local == other.local && visitante == other.visitante;
	}
	@Override
	public String toString() {
		return getClass().getName()+"[local=" + local + ", visitante=" + visitante + "]";
	}
	
	
	
	
}
