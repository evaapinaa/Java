import java.time.LocalDate;
import java.util.Objects;

public class Persona implements Comparable<Persona> {
	
	private final String dni;
	private final String nombre;
	private final LocalDate fechaNacimiento;
	
	public String getDni() {
		return dni;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public String getNombre() {
		return nombre;
	}
	
	public Persona(String dni, String nombre, LocalDate fechaNacimiento) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(dni, fechaNacimiento, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(dni, other.dni) && Objects.equals(fechaNacimiento, other.fechaNacimiento)
				&& Objects.equals(nombre, other.nombre);
	}
	
	@Override
	public int compareTo(Persona p) {
		int x = this.getNombre().compareTo(p.getNombre());
		if(x == 0) {
			return this.getDni().compareTo(p.getDni());
		}
		return x;
	}
	
	
}
