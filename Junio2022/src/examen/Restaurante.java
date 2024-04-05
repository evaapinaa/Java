package examen;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Predicate;

public class Restaurante implements Cloneable {
	
	private String nombre;
	private TreeSet<Servicio> servicios;
	private List<String> codigos;
	private List<Valoracion> valoraciones;
	
	public Restaurante(String nombre) {
		this.nombre = nombre;
		this.servicios = new TreeSet<>();
		this.codigos = new LinkedList<>();
		this.valoraciones = new LinkedList<>();
	}
	
	public String getNombre() {
		return nombre;
	}
	public TreeSet<Servicio> getServicios() {
		return new TreeSet<>(servicios);
	}
	public List<String> getCodigos() {
		return new LinkedList<>(codigos);
	}
	public List<Valoracion> getValoraciones() {
		return new LinkedList<>(valoraciones);
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public boolean addServicio (Tipo tipo, LocalDate fecha) {
		Servicio servicio = new Servicio(tipo, fecha);
		return servicios.add(servicio);
	}
	public boolean addServicio (Tipo tipo) {
		return addServicio(tipo, LocalDate.now());
	}
	// para que lo pueda utilizar el metodo asistirServicio de la clase descendiente
	public String asistirServicio (Tipo tipo) {
		boolean result = false;
		for (Servicio servicio : servicios) {
			if (servicio.getFecha().isEqual(LocalDate.now()) && servicio.getTipo().equals(tipo)) {
				result = true;
			}
		}
		if (result) {
			String codigo = java.util.UUID.randomUUID().toString();
			codigos.add(codigo);
			return codigo;
		} else {
			return null;
		}
	}
	public Valoracion valorarServicio (String codigo, String usuario, int nota, String comentario) {
		if (codigos.contains(codigo)) {
			Valoracion valoracion = new Valoracion(usuario, nota, comentario);
			valoraciones.add(valoracion);
			codigos.remove(codigo);
			return valoracion;
		} else {
			return null;
			}
	}
	public List<Valoracion> getValoraciones(Predicate<Valoracion> criterio) {
		List<Valoracion> lista = new LinkedList<>();
		valoraciones.stream()
					.filter(v->criterio.test(v))
					.forEach(v->lista.add(v));
		return lista;
	}
	@Override
	public Restaurante clone() {
		Restaurante copia = copiaSuperficial();
		//Corregimos el aliasing
		copia.nombre+=copia.nombre+"-copia";
		copia.servicios = new TreeSet<>();
		copia.codigos = getCodigos();
		copia.valoraciones = getValoraciones();
		return copia;
	}
	private Restaurante copiaSuperficial() {
		try {
			Restaurante copiaSuperficial = (Restaurante)super.clone();
			return copiaSuperficial;
		} catch (CloneNotSupportedException e) {
			System.err.println("La clase no es cloneable");
		}
			return null;
	}
	
}
