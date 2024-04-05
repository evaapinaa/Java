package examen;

import java.util.Objects;

public class Operador {
	
	private final String nombre;
	private final Area area;
	
	public Area getArea() {
		return area;
	}
	public String getNombre() {
		return nombre;
	}
	
	public Operador(String nombre, Area area) {
		super();
		this.nombre = nombre;
		this.area = area;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(area, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Operador other = (Operador) obj;
		return area == other.area && Objects.equals(nombre, other.nombre);
	}
	
	
	
}
