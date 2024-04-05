package examen;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class GestorAutomatico extends Gestor {
	
	private final Map<Operador, TreeSet<Tarea>> carga;
	
	public Map<Operador, TreeSet<Tarea>> getCarga() {
		return Collections.unmodifiableMap(carga);
	}
	
	public GestorAutomatico(String nombre, Area... areas) {
		super(nombre, areas);
		this.carga = new HashMap<Operador, TreeSet<Tarea>>();
	}
	
	public SortedSet<Tarea> getTareasAsignadas(Operador op) {
		if(carga.get(op) != null) {
			return Collections.unmodifiableSortedSet(carga.get(op));
		}
		return null;
	}
	
	public int getCargaOperador(Operador op) {
		if(carga.get(op).size() < 0) {
			return -1;
		}
		return carga.get(op).size();
	}
	
	public Operador operadorCandidato(Area a)
	{
		List<Operador> lista = carga.keySet().stream()
			.filter(o -> o.getArea().equals(a))
			.collect(Collectors.toList());
		if(lista.isEmpty())
			return null;
		Iterator<Operador> it = lista.iterator();
		Operador aux = it.next();
		while(it.hasNext())
		{
			Operador aux1 = it.next();
			if(carga.get(aux).size() > carga.get(aux1).size())
			{
				aux = aux1;
			}
		}
		return aux;
		
	}
}
