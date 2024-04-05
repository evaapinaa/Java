package Cursos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public abstract class Curso {
	
	private String titulo;
	private LocalDate inicio;
	private LocalDate finalizacion;
	private double precio;
	private Set<Alumno> alumnosMatriculados;
	
	public String getTitulo() {
		return titulo;
	}
	public Set<Alumno> getAlumnosMatriculados() {
		return new HashSet<Alumno>(alumnosMatriculados);
	}
	public LocalDate getFinalizacion() {
		return finalizacion;
	}
	public LocalDate getInicio() {
		return inicio;
	}
	public double getPrecio() {
		return precio;
	}
	public int getNumeroAlumnos() {
		return alumnosMatriculados.size();
	}
	
	public Curso(String titulo, LocalDate inicio, LocalDate finalizacion, double precio) {
		super();
		this.titulo = titulo;
		this.inicio = inicio;
		this.finalizacion = finalizacion;
		this.precio = precio;
		this.alumnosMatriculados = new HashSet<Alumno>();
	}
	
	public boolean consultarTerminado() {
		return LocalDate.now().isAfter(getFinalizacion());
	}
	
	public boolean matricular(Alumno alumno) {
		if(LocalDate.now().isBefore(getInicio()) && alumno.getCredito() >= precio && cumpleRequisitos(alumno)) {
			this.alumnosMatriculados.add(alumno);
			alumno.decrementarCredito((int)precio);
			return true;
		}
		return false;
	}
	
	protected abstract boolean cumpleRequisitos(Alumno alumno);
	
	@Override
	public String toString() {
		return getClass().getName()+"[titulo=" + titulo + ", inicio=" + inicio + ", finalizacion=" + finalizacion + ", precio="
				+ precio + ", alumnosMatriculados=" + alumnosMatriculados + ", haTerminado = " + consultarTerminado()+"]";
	}

	
}
