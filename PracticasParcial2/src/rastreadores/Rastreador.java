package rastreadores;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class Rastreador {
	
	private Map<String, List<Mensaje>> mapaAutores;
	private Map<String, List<Mensaje>> mapaTemas;
	
	
	public SortedSet<String> getAutores() {
		return new TreeSet<>(mapaAutores.keySet());
	}
	
	public SortedSet<String> getTemas() {
		return new TreeSet<>(mapaTemas.keySet());
	}
	
	public List<Mensaje> getLista(){
		List<Mensaje> l = new LinkedList<>();
		for(List<Mensaje> lista: mapaAutores.values()) {
			l.addAll(lista);
		}
		return l;
	}
	
	public Rastreador() {
		mapaAutores = new HashMap<String,List<Mensaje>>();
		mapaTemas = new HashMap<String,List<Mensaje>>();
		
	}
	
	public List<Mensaje> getListaAutor(String autor) {
		if(mapaAutores.containsKey(autor) ) {
			return mapaAutores.get(autor);
		}
		return new LinkedList<>();
	}
	
	public List<Mensaje> getListaTema(String tema) {
		if(mapaAutores.containsKey(tema) ) {
			return mapaAutores.get(tema);
		}
		return new LinkedList<>();
	}
	
	public void registrar(Mensaje mensaje) {
		if(!mapaAutores.containsKey(mensaje.getAutor())){
			mapaAutores.put(mensaje.getAutor(), new LinkedList<Mensaje>());
		}
		mapaAutores.get(mensaje.getAutor()).add(mensaje);
		
		for(String t: mensaje.getTemas()) {
			if(!mapaTemas.containsKey(t)){
				mapaTemas.put(t, new LinkedList<Mensaje>());
			}
			mapaTemas.get(t).add(mensaje);
		}
	}
	
	public List<Mensaje> getListaOrdenado() {
		List<Mensaje> resultado = getLista();
		resultado.sort(null);
		return resultado;
	}
	
	public List<Mensaje> getMensajesOrdenados(Comparator<Mensaje> criterio) {
		List<Mensaje> resultado = getLista();
		resultado.sort(criterio);
		return resultado;
	}
	
	
}
