package mensajes;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;


public class Rastreador {
	private List<Mensaje> lista;
	private SortedSet<String> autores;
	private SortedSet<String> temas;
	
	private Map<String, List<Mensaje>> mapaAutores;
	private Map<String, List<Mensaje>> mapaTemas;
	
	public Rastreador() {
		super();
		lista = new LinkedList<>();
		autores = new TreeSet<>();
		temas = new TreeSet<>();
		mapaAutores = new HashMap<String,List<Mensaje>>();
		mapaTemas= new HashMap<String,List<Mensaje>>();
	}
	
	public List<Mensaje> getLista() {
		return new LinkedList<Mensaje>(lista);
	}
	
	public SortedSet<String> getAutores() {
		return autores;
	}
	
	public SortedSet<String> getTemas() {
		return temas;
	}
	
	public List<Mensaje> getMensajesAutor(String autor) {
		if(mapaAutores.containsKey(autor)) {
			return mapaAutores.get(autor);
		}
		return new LinkedList<>();
	}
	
	public List<Mensaje> getMensajesTema(String tema) {
		if(mapaAutores.containsKey(tema)) {
			return mapaAutores.get(tema);
		}
		return new LinkedList<>();
	}
	
	public void registrar(Mensaje mensaje) {
		lista.add(mensaje);
		autores.add(mensaje.getAutor());
		temas.addAll(mensaje.getTemas());
		if(!mapaAutores.containsKey(mensaje.getAutor())) {
			mapaAutores.put(mensaje.getAutor(), new LinkedList<Mensaje>());
		}
		mapaAutores.get(mensaje.getAutor()).add(mensaje);
		
		for(String t: mensaje.getTemas()) {
			if(!mapaTemas.containsKey(t)) {
				mapaTemas.put(t, new LinkedList<Mensaje>());
			}
			
		}
	}
	
	
}
