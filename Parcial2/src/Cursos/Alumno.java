package Cursos;

import java.util.HashSet;
import java.util.Set;

public class Alumno {
	
	public static final int VALOR_POR_DEFECTO = 100;
	
	private final String nombre;
	private final String DNI;
	private int credito;
	private Set<Curso> lista;
	
	public int getCredito() {
		return credito;
	}
	public String getDNI() {
		return DNI;
	}
	public Set<Curso> getLista() {
		return new HashSet<Curso>(lista);
	}
	public String getNombre() {
		return nombre;
	}
	
	public Alumno(String nombre, String DNI, int credito) {
		super();
		this.nombre = nombre;
		this.DNI = DNI;
		this.credito = credito;
		lista = new HashSet<Curso>();
	}
	
	public Alumno(String nombre, String DNI) {
		this(nombre,DNI, VALOR_POR_DEFECTO);	
	}
	
	public void incrementarCredito(int cantidad) {
		credito += cantidad;
	}
	
	public void decrementarCredito(int cantidad) {
		credito -= cantidad;
	}
	
	public void añadirCurso(Curso curso) {
		lista.add(curso);
	}
	
	@Override
	public String toString() {
		return getClass().getName()+"[nombre=" + nombre + ", DNI=" + DNI + ", credito=" + credito + ", numero de cursos = " + lista.size() + "]";
	}
	
	
}
