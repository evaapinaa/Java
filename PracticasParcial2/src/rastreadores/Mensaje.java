package rastreadores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mensaje implements Comparable<Mensaje> {
	
	private final String autor;
	private final String texto;
	private final List<String> temas;
	
	public String getAutor() {
		return autor;
	}
	public String getTexto() {
		return texto;
	}
	public List<String> getTemas() {
		return Collections.unmodifiableList(temas);
	}
	public Mensaje(String autor, String texto) {
		super();
		this.autor = autor;
		this.texto = texto;
		this.temas = new ArrayList<String>();
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
	
	public int compareTo(Mensaje m) {
		int c = this.getAutor().compareTo(m.getAutor());
		if (c==0) return this.getTexto().compareTo(m.getTexto());
		return c;
	}
	
	
	
	
}
