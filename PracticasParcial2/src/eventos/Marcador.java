package eventos;

import java.util.Objects;

public class Marcador {
	
	private int tanteoLocal;
	private int tanteoVisitante;
	
	
	@Override
	public int hashCode() {
		return Objects.hash(tanteoLocal, tanteoVisitante);
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
		return tanteoLocal == other.tanteoLocal && tanteoVisitante == other.tanteoVisitante;
	}
	
	
}
