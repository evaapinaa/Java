package examen;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.UUID;

public class Tarea {
	
	public static final Area VALOR_POR_DEFECTO = Area.UNIDAD_TECNICA;
	
	private final String identificador;
	private final String peticionario;
	private final String descripcion;
	private final Area area;
	private Collection<Operador> operadores;
	private final LocalDateTime fechaHoraCreacion;
	
	
	public String getIdentificador() {
		return identificador;
	}
	public String getPeticionario() {
		return peticionario;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public Area getArea() {
		return area;
	}
	public Collection<Operador> getOperadores() {
		return Collections.unmodifiableCollection(operadores);
	}
	public LocalDateTime getFechaHoraCreacion() {
		return fechaHoraCreacion;
	}


	public Tarea(String peticionario, String descripcion, Area area) {
		super();
		this.identificador = UUID.randomUUID().toString();
		this.peticionario = peticionario;
		this.descripcion = descripcion;
		this.area = area;
		this.operadores = new HashSet<Operador>();
		this.fechaHoraCreacion = LocalDateTime.now();
	}
	
	public Tarea(String peticionario, String descripcion) {
		this(peticionario,descripcion,VALOR_POR_DEFECTO);
	}
	
	public boolean añadirOperador(Operador op) {
		if(!operadores.contains(op) ) {
			operadores.add(op);
			return true;
		}
		return false;
	}
	
	
	
}
