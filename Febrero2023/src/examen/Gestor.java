package examen;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class Gestor {
	
	private final String nombre;
	private Collection<Area> areas;
	private Map<String, Tarea> mapa;
	private Collection<Operador> operadores;
	
	public Collection<Area> getArea() {
		return Collections.unmodifiableCollection(areas);
	}
	public List<Tarea> getTareas() {
		return new ArrayList<Tarea>(mapa.values());
	}
	public String getNombre() {
		return nombre;
	}
	public Collection<Operador> getOperadores() {
		return Collections.unmodifiableCollection(operadores);
	}
	public Collection<Tarea> getTareasHuerfanas() {
		Collection<Tarea> tareasHuerfanas = new ArrayList<Tarea>();
		for(Tarea tarea : mapa.values()) {
			if(tarea.getOperadores().isEmpty()) {
				tareasHuerfanas.add(tarea);
			}
		}
		return tareasHuerfanas;
	}
	
	public Gestor(String nombre, Area... areas) {
		super();
		this.nombre = nombre;
		this.areas = new ArrayList<Area>();
		for(Area a : areas) {
			this.areas.add(a);
		}
		this.mapa = new HashMap<String, Tarea>();
		this.operadores = new HashSet<Operador>();
	}
	
	public Tarea consultarTarea(String identificador) {
		if(mapa.containsKey(identificador)) {
			return mapa.get(identificador);
		}
		return null;
	}
	
	public boolean añadirOperador(Operador op) {
		if(areas.contains(op.getArea())){
			operadores.add(op);
			return true;
		}
		return false;
	}
	
	public String registrarTarea(String peticionario, String descripcion, Area area) {
		if(areas.contains(area)) {
			return null;
		}
		Tarea t = new Tarea(peticionario, descripcion, area);
		mapa.put(t.getIdentificador(), t);
		return t.getIdentificador();
	}
	
	public boolean asignarOperador(String identificador, Operador op) {
		if(identificador == null) {
			throw new IllegalArgumentException("El identificador no puede ser nulo");
		}
		if(identificador.isEmpty()) {
			throw new IllegalArgumentException("El identificador no puede ser una cadena vacía");
		}
		if(op == null) {
			throw new IllegalArgumentException("El operador no puede ser nulo");
		}
		if(mapa.get(identificador) == null) {
			throw new IllegalStateException("El identificador no corresponde a una tarea del gestor");
		}
		if(!operadores.contains(op)) {
			throw new IllegalStateException("El operador debe estar registrado en el gestor");
		}
		if(!op.getArea().equals(mapa.get(identificador).getArea())) {
			throw new IllegalStateException("El area del operador debe de ser el mismo que el de la tarea");
		}
		Tarea tarea = mapa.get(identificador);
		return tarea.añadirOperador(op);
	}
	
	public Collection<Tarea> tareasFiltrada(Predicate<Tarea> p) {
		HashSet<Tarea> aux = new HashSet<Tarea>();
		for(Tarea t : getTareas()) {
			if(p.test(t)) {
				aux.add(t);
			}
		}
		return aux;
		
	}
	
	
}
