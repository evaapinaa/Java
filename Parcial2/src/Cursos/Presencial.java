package Cursos;

import java.time.LocalDate;

public class Presencial extends Curso {
	
	private final int cupo;
	
	public int getCupo() {
		return cupo;
	}
	
	public int getPlazasLibres() {
		return cupo - getNumeroAlumnos();
	}

	public Presencial(String titulo, LocalDate inicio, LocalDate finalizacion, double precio, int cupo) {
		super(titulo, inicio, finalizacion, precio);
		this.cupo = cupo;
	}
	
	@Override
	protected boolean cumpleRequisitos(Alumno alumno) {
		return getPlazasLibres() > 0;
	}
	
}
