package examen;

import java.time.LocalDateTime;

public class Estacionamiento {
	
	private final String matricula;
	private final LocalDateTime fechaInicio;
	private final LocalDateTime fechaFinal;
	
	public Estacionamiento(String matricula, LocalDateTime fechaInicio, LocalDateTime fechaFinal) {
		this.matricula = matricula;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
	}
	public String getMatricula() {
		return matricula;
	}
	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}
	public LocalDateTime getFechaFinal() {
		return fechaFinal;
	}
	// Propiedad calculada
	public boolean isActivo() {
		return fechaInicio.isBefore(LocalDateTime.now()) &&
		fechaFinal.isAfter(LocalDateTime.now());
	}
	@Override
	public String toString() {
		return getClass().getName() + " [matricula=" + matricula + ", fechaInicio=" +
		fechaInicio + ", fechaFinal="
		+ fechaFinal + "] ";
	}
}
