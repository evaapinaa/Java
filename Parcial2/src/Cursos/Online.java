package Cursos;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Online extends Curso{

	public Set<Curso> cursosPrevios;
	
	public Set<Curso> getCursosPrevios() {
		return new HashSet<Curso>(cursosPrevios);
	}
	
	
	public Online(String titulo, LocalDate inicio, LocalDate finalizacion, double precio, Curso...cursosPrevios) {
		super(titulo, inicio, finalizacion, precio);
		this.cursosPrevios = new HashSet<Curso>(Arrays.asList(cursosPrevios));
	}
	
	@Override
	protected boolean cumpleRequisitos(Alumno alumno) {
		return alumno.getLista().containsAll(cursosPrevios);
	}


	@Override
	public String toString() {
		return super.toString()+"[ Cursos Previos =" + getCursosPrevios() + "]";
	}

	
	
}
