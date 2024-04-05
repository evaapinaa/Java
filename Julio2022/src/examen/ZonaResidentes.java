package examen;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ZonaResidentes extends Zona {
	
	private static final int MINUTOS_DEFECTO = 120;
	private List<String> matriculas;
	private final Set<Tramo> tramosNoGratuitos;
	
	public ZonaResidentes(String nombre, int minutos, List<String> matriculas,
		Set<Tramo> tramosNoGratuitos) {
		super(nombre, minutos);
		this.matriculas = matriculas;
		this.tramosNoGratuitos = new TreeSet<>(tramosNoGratuitos);
	}
	public ZonaResidentes (String nombre, List<String> matriculas, Set<Tramo> tramosNoGratuitos) {
		this(nombre, MINUTOS_DEFECTO, matriculas, tramosNoGratuitos);
	}
	public List<String> getMatriculas() {
		return new LinkedList<>(matriculas);
	}
	public Set<Tramo> getTramosGratuitos() {
		return new TreeSet<>(tramosNoGratuitos);
	}
	public void addResidente (String...residentes) {
		for(String residente : residentes) {
			matriculas.add(residente);
		}
	}
	public boolean bajaResidente(String matricula) {
		return matriculas.remove(matricula);
	}
	public void cancelarSancion (String matricula) {
		super.cancelarSancion(matricula);
	}
	public boolean comprobarFecha (LocalDateTime fecha) {
		boolean resultado = tramosNoGratuitos.stream() // resultado = true -> la fecha esta en un tramo no gratuito
		.anyMatch(t -> t.compruebaDentro(fecha));
		return !resultado; // !resultado significa que si la fecha no esta en un tramo horario se devuelve true
	}
	@Override
	public boolean comprobarEstacionamiento(String matricula) {
		if (!matriculas.contains(matricula)) {
			return comprobarFecha(LocalDateTime.now()) ||
					super.comprobarEstacionamiento(matricula);
		} else {
			return true;
		}
	}
	/*
	@Override
	public LocalDateTime calcularFechaFinal(LocalDateTime fechaInicio, long dinero) {
	long minutosPagados = getMinutos()*dinero;
	while (minutosPagados>0 ) {
	TramoHorario tramo1 = null;
	while (tramo1==null)
	for (TramoHorario tramo : tramosNoGratuitos) {
	if (tramo.isFecha(fechaInicio)) {
	tramo1 = tramo;
	}
	}
	}
	}
	*/
	@Override
	public ZonaResidentes clone() {
		return (ZonaResidentes)super.clone();
	}
	@Override
	public String toString() {
		return super.toString() + " [matriculas=" + matriculas + ", tramosNoGratuitos="
		+ tramosNoGratuitos + "]";
		}
}