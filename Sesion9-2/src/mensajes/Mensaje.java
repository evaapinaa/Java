package mensajes;

import java.util.ArrayList;
import java.util.List;

public class Mensaje implements Comparable<Mensaje> {
	private final String autor;
	private final String texto;
	private List<String> temas;
	
	public List<String> getTemas() {
		return new ArrayList<String>(temas);
	}
	
	public String getAutor() {
		return autor;
	}
	
	public String getTexto() {
		return texto;
	}
	
	public Mensaje(String autor, String texto) {
		super();
		this.autor = autor;
		this.texto = texto;
		temas = new ArrayList<String>();
		String[] palabras = texto.split("\\s+");
		for (String palabra : palabras) {
			if(palabra.startsWith("#")) {
				temas.add(palabra);
			}
		}
	}

	@Override
	public String toString() {
		return getClass().getName()+"[autor=" + autor + ", texto=" + texto + ", temas=" + temas + "]";
	}
	
	@Override
	public int compareTo(Mensaje o) {
		return this.getAutor().compareTo(o.getAutor());
	}
	
}
